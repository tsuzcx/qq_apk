package com.tencent.mobileqq.highway.transaction;

import android.os.Handler;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.config.HwServlet.OnGetConfigListener;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.netprobe.EchoProbe;
import com.tencent.mobileqq.highway.netprobe.LoginWifiProbe;
import com.tencent.mobileqq.highway.netprobe.MtuProbe;
import com.tencent.mobileqq.highway.netprobe.ProbeCallback;
import com.tencent.mobileqq.highway.netprobe.ProbeChain;
import com.tencent.mobileqq.highway.netprobe.ProbeRequest;
import com.tencent.mobileqq.highway.netprobe.ProbeTask;
import com.tencent.mobileqq.highway.netprobe.TracerouteProbe;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.segment.RequestWorker;
import com.tencent.mobileqq.highway.segment.RequestWorker.RequestHandler;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;

public class TransactionWorker
  implements IHwManager, HwServlet.OnGetConfigListener
{
  public static final int PRIORITY_HIGH = 0;
  public static final int PRIORITY_LOW = 2;
  public static final int PRIORITY_MEDIUM = 1;
  public static final int PRIORITY_NUM = 3;
  public static final int TRANS_OP_CNCL = 2;
  public static final int TRANS_OP_SEND = 1;
  private static final int[] round_array = { 0, 0, 1, 0, 0, 1, 2 };
  private static final AtomicInteger seqFactory = new AtomicInteger(new Random().nextInt(100000));
  private HwEngine engine;
  private volatile int index = 0;
  private SparseArray<ArrayList<Transaction>> transQueues = new SparseArray();
  private ArrayList<Transaction> transWaitForSessionKeyQueue = new ArrayList();
  
  public TransactionWorker(HwEngine paramHwEngine)
  {
    this.engine = paramHwEngine;
  }
  
  private void submitTransactionToTransQuene(Transaction paramTransaction)
  {
    paramTransaction.transationId = seqFactory.incrementAndGet();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SubmitTransation : T_Id:");
    ((StringBuilder)localObject).append(paramTransaction.transationId);
    ((StringBuilder)localObject).append(" ukey:");
    ((StringBuilder)localObject).append(String.valueOf(paramTransaction.ticket));
    BdhLogUtil.LogEvent("T", ((StringBuilder)localObject).toString());
    localObject = this.transQueues;
    int i = 0;
    try
    {
      if (paramTransaction.mBuzCmdId == 25) {
        i = 1;
      }
      if (this.transQueues.get(i) != null)
      {
        ((ArrayList)this.transQueues.get(i)).add(paramTransaction);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SubmitTransation : T_Id:");
        localStringBuilder.append(paramTransaction.transationId);
        localStringBuilder.append(" : add to queue[ ");
        localStringBuilder.append(i);
        localStringBuilder.append("]");
        BdhLogUtil.LogEvent("T", localStringBuilder.toString());
      }
      notifyToSend();
      paramTransaction.startTime = SystemClock.uptimeMillis();
      return;
    }
    finally {}
  }
  
  private int submitTransactionToWaitForSessionKeyQuene(Transaction paramTransaction)
  {
    Object localObject = this.engine;
    if ((localObject != null) && (((HwEngine)localObject).app != null) && (this.engine.app.getAccount() != null) && (this.engine.mRequestWorker != null) && (this.engine.mRequestWorker.mRequestHandler != null))
    {
      localObject = this.engine.app.getAccount();
      HwServlet.getConfig(this.engine.app, (String)localObject, this);
      try
      {
        this.transWaitForSessionKeyQueue.add(paramTransaction);
        paramTransaction.startTimeoutTimer();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Submit Trans to transWaitForSessionKeyQueue ,Transaction path:");
        ((StringBuilder)localObject).append(paramTransaction.filePath);
        ((StringBuilder)localObject).append(" transWaitForSessionKeyQueue size:");
        ((StringBuilder)localObject).append(this.transWaitForSessionKeyQueue.size());
        BdhLogUtil.LogEvent("T", ((StringBuilder)localObject).toString());
        return 0;
      }
      finally {}
    }
    return -1018;
  }
  
  public void cancelTransaction(Transaction paramTransaction)
  {
    paramTransaction.cancelTransaction();
    this.engine.mRequestWorker.notifyTransactionChange(2, paramTransaction);
  }
  
  void dumpEngineInfo()
  {
    int i = this.engine.mRequestWorker.mCurrentRequests;
    int j = this.engine.mTransWorker.getTransactionNum();
    int k = this.engine.mConnManager.connectedConn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EngineInfo : Request:");
    localStringBuilder.append(i);
    localStringBuilder.append(" TransCnt:");
    localStringBuilder.append(j);
    localStringBuilder.append(" ConnCnt:");
    localStringBuilder.append(k);
    QLog.d("E", 1, localStringBuilder.toString());
  }
  
  int getConnErroCode()
  {
    return this.engine.mConnManager.vConnErrCode;
  }
  
  public HwEngine getHwEngine()
  {
    return this.engine;
  }
  
  public long getIpConnectCost()
  {
    return this.engine.mConnManager.getConnCost();
  }
  
  String getLastUsedIp()
  {
    EndPoint localEndPoint = this.engine.mConnManager.lastEndPoint;
    if (localEndPoint != null) {
      return localEndPoint.host;
    }
    return "";
  }
  
  String getLastUsedPort()
  {
    EndPoint localEndPoint = this.engine.mConnManager.lastEndPoint;
    if (localEndPoint != null) {
      return String.valueOf(localEndPoint.port);
    }
    return "";
  }
  
  long[] getReportDataFlow()
  {
    return new long[] { this.engine.upFlow_Wifi.getAndSet(0L), this.engine.dwFlow_Wifi.getAndSet(0L), this.engine.upFlow_Xg.getAndSet(0L), this.engine.dwFlow_Xg.getAndSet(0L) };
  }
  
  public Transaction getTransactionById(int paramInt)
  {
    SparseArray localSparseArray = this.transQueues;
    int i = 0;
    Object localObject1 = null;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        Object localObject5 = (ArrayList)this.transQueues.get(i);
        localObject4 = localObject1;
        if (localObject5 != null)
        {
          localObject5 = ((ArrayList)localObject5).iterator();
          for (;;)
          {
            localObject4 = localObject1;
            if (!((Iterator)localObject5).hasNext()) {
              break;
            }
            localObject4 = (Transaction)((Iterator)localObject5).next();
            if (((Transaction)localObject4).getTransationId() == paramInt) {
              localObject1 = localObject4;
            }
          }
          return localObject1;
        }
      }
      finally
      {
        Object localObject4;
        for (;;)
        {
          throw localObject2;
        }
        i += 1;
        Object localObject3 = localObject4;
      }
    }
  }
  
  public int getTransactionNum()
  {
    SparseArray localSparseArray = this.transQueues;
    int i = 0;
    int j = 0;
    int k;
    label70:
    for (;;)
    {
      if (i < 3) {
        k = j;
      }
      try
      {
        if (this.transQueues.get(i) == null) {
          break label70;
        }
        k = j + ((ArrayList)this.transQueues.get(i)).size();
      }
      finally
      {
        for (;;)
        {
          throw localObject;
        }
        i += 1;
        j = k;
      }
      return j;
    }
  }
  
  public boolean isNetworkConnected()
  {
    return BdhUtils.isBdhNetConnected(this.engine.getAppContext());
  }
  
  public void notifyToSend()
  {
    this.engine.mRequestWorker.notifyTransactionChange(1, null);
  }
  
  public void onDestroy()
  {
    SparseArray localSparseArray = this.transQueues;
    int i = 0;
    label128:
    for (;;)
    {
      if (i < 3) {}
      try
      {
        Object localObject1 = new ArrayList();
        if (this.transQueues.get(i) == null) {
          break label128;
        }
        ((ArrayList)localObject1).addAll((Collection)this.transQueues.get(i));
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          cancelTransaction((Transaction)((Iterator)localObject1).next());
        }
        ((ArrayList)this.transQueues.get(i)).clear();
      }
      finally
      {
        for (;;)
        {
          throw localObject2;
        }
        i += 1;
      }
      this.transQueues.clear();
      this.transWaitForSessionKeyQueue = new ArrayList();
      return;
    }
  }
  
  public void onGetConfig()
  {
    Object localObject1 = this.engine;
    if (localObject1 != null)
    {
      if (((HwEngine)localObject1).currentUin == null) {
        return;
      }
      localObject1 = this.engine.currentUin;
      try
      {
        byte[] arrayOfByte1 = SessionInfo.getInstance((String)localObject1).getHttpconn_sig_session();
        if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0))
        {
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onGetConfig suc,transWaitForSessionKeyQueue size:");
          ((StringBuilder)localObject3).append(this.transWaitForSessionKeyQueue.size());
          BdhLogUtil.LogEvent("E", ((StringBuilder)localObject3).toString());
          int i = arrayOfByte1.length;
          localObject3 = this.transWaitForSessionKeyQueue.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Transaction localTransaction = (Transaction)((Iterator)localObject3).next();
            localTransaction.ticket = new byte[i];
            System.arraycopy(arrayOfByte1, 0, localTransaction.ticket, 0, i);
            if (localTransaction.needCryptExtendInfo)
            {
              Object localObject4 = SessionInfo.getInstance((String)localObject1).getSessionKey();
              if ((localObject4 != null) && (localObject4.length != 0))
              {
                int j = localObject4.length;
                byte[] arrayOfByte2 = new byte[j];
                System.arraycopy(localObject4, 0, arrayOfByte2, 0, j);
                localTransaction.extendInfo = new Cryptor().encrypt(localTransaction.extendInfo, arrayOfByte2);
                submitTransactionToTransQuene(localTransaction);
              }
              else
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("onGetConfig,get sessionKey successfully,but task has mSigSession, not has mSessionKey, transaction path:");
                ((StringBuilder)localObject4).append(localTransaction.filePath);
                BdhLogUtil.LogEvent("T", ((StringBuilder)localObject4).toString());
                HwServlet.getConfig(this.engine.app, (String)localObject1);
                localTransaction.onTransFailed(-1017, "", 0, 0, 0, null);
              }
            }
            else
            {
              submitTransactionToTransQuene(localTransaction);
            }
          }
          this.transWaitForSessionKeyQueue.clear();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onGetConfig failed,transWaitForSessionKeyQueue size:");
          ((StringBuilder)localObject1).append(this.transWaitForSessionKeyQueue.size());
          BdhLogUtil.LogEvent("E", ((StringBuilder)localObject1).toString());
          localObject1 = this.transWaitForSessionKeyQueue.iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((Transaction)((Iterator)localObject1).next()).onTransFailed(-1016, "", 0, 0, 0, null);
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public void onInit()
  {
    SparseArray localSparseArray = this.transQueues;
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        ArrayList localArrayList = new ArrayList();
        this.transQueues.put(i, localArrayList);
        i += 1;
      }
      finally
      {
        break label49;
      }
    }
    return;
    label49:
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void onTransactionFinish(boolean paramBoolean, Transaction paramTransaction)
  {
    SparseArray localSparseArray = this.transQueues;
    int i = 0;
    label78:
    for (;;)
    {
      if (i < 3) {}
      try
      {
        if (this.transQueues.get(i) == null) {
          break label78;
        }
        ((ArrayList)this.transQueues.get(i)).remove(paramTransaction);
      }
      finally
      {
        for (;;)
        {
          throw paramTransaction;
        }
        i += 1;
      }
      if (!paramBoolean) {
        this.engine.mRequestWorker.notifyTransactionChange(2, paramTransaction);
      }
      return;
    }
  }
  
  public DataTransInfo pullNextSegment(SparseArray<HwNetSegConf> paramSparseArray)
  {
    SparseArray localSparseArray = this.transQueues;
    Object localObject1 = null;
    int i = 0;
    Object localObject2 = localObject1;
    for (;;)
    {
      try
      {
        if (i < round_array.length)
        {
          Object localObject3 = (ArrayList)this.transQueues.get(round_array[this.index]);
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            localObject2 = localObject1;
            if (((ArrayList)localObject3).size() > 0)
            {
              localObject3 = ((ArrayList)localObject3).iterator();
              localObject2 = localObject1;
              if (((Iterator)localObject3).hasNext())
              {
                localObject2 = (Transaction)((Iterator)localObject3).next();
                HwNetSegConf localHwNetSegConf = (HwNetSegConf)paramSparseArray.get(((Transaction)localObject2).getBuzType());
                if (localHwNetSegConf == null) {
                  paramSparseArray.get(0);
                }
                localObject2 = ((Transaction)localObject2).peekNextSegment(localHwNetSegConf);
                if (localObject2 == null) {
                  continue;
                }
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("pullNextSegment : T_Id:");
                ((StringBuilder)localObject1).append(((DataTransInfo)localObject2).parent.getTransationId());
                ((StringBuilder)localObject1).append(" ConfSegNum:");
                ((StringBuilder)localObject1).append(localHwNetSegConf.segNum);
                ((StringBuilder)localObject1).append(" ConfSegSize:");
                ((StringBuilder)localObject1).append(localHwNetSegConf.segSize);
                BdhLogUtil.LogEvent("R", ((StringBuilder)localObject1).toString());
              }
            }
          }
          if (this.index >= round_array.length - 1) {
            this.index = 0;
          } else {
            this.index += 1;
          }
        }
        else
        {
          return localObject2;
        }
      }
      finally
      {
        continue;
        throw paramSparseArray;
        continue;
        i += 1;
        localObject1 = localObject2;
      }
      if (localObject2 == null) {
        break;
      }
    }
  }
  
  public void resumeTransaction(Transaction paramTransaction)
  {
    paramTransaction.setPause(false);
    this.engine.mRequestWorker.notifyTransactionChange(1, paramTransaction);
  }
  
  boolean startNetDetection(ProbeCallback paramProbeCallback)
  {
    try
    {
      Object localObject = this.engine.mConnManager.lastEndPoint;
      if (localObject != null)
      {
        ProbeChain localProbeChain = new ProbeChain();
        localProbeChain.addProbeItem(new LoginWifiProbe());
        localProbeChain.addProbeItem(new MtuProbe());
        localProbeChain.addProbeItem(new EchoProbe());
        localProbeChain.addProbeItem(new TracerouteProbe());
        localObject = new ProbeRequest(((EndPoint)localObject).host, localProbeChain);
        boolean bool = this.engine.mWeakNetLearner.startProbe(new ProbeTask((ProbeRequest)localObject, paramProbeCallback));
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable paramProbeCallback)
    {
      label116:
      break label116;
    }
    return false;
  }
  
  void startTransRunnable(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    RequestWorker.RequestHandler localRequestHandler = this.engine.mRequestWorker.mRequestHandler;
    if (localRequestHandler != null)
    {
      if (paramRunnable1 != null) {
        localRequestHandler.removeCallbacks(paramRunnable1);
      }
      localRequestHandler.postDelayed(paramRunnable2, 600000L);
    }
  }
  
  void stopTransRunnable(Runnable paramRunnable)
  {
    RequestWorker.RequestHandler localRequestHandler = this.engine.mRequestWorker.mRequestHandler;
    if (localRequestHandler != null) {
      localRequestHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public void stopTransaction(Transaction paramTransaction)
  {
    paramTransaction.setPause(true);
    this.engine.mRequestWorker.notifyTransactionChange(2, paramTransaction);
  }
  
  public int submitTransation(Transaction paramTransaction)
  {
    if ((paramTransaction != null) && (paramTransaction.filePath != null) && (paramTransaction.transationId == -1))
    {
      boolean bool;
      if (this.engine.mConnManager.getCurrentConnNum() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      int i = paramTransaction.initSegmentList(this, bool);
      if (i == 0)
      {
        if (paramTransaction.ticket != null)
        {
          submitTransactionToTransQuene(paramTransaction);
          return i;
        }
        return submitTransactionToWaitForSessionKeyQuene(paramTransaction);
      }
      return i;
    }
    return 9042;
  }
  
  public void switchToBackupChannel()
  {
    SparseArray localSparseArray = this.transQueues;
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        if (this.transQueues.get(i) != null)
        {
          Object localObject1 = new ArrayList();
          ((ArrayList)localObject1).addAll((Collection)this.transQueues.get(i));
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Transaction localTransaction = (Transaction)((Iterator)localObject1).next();
            cancelTransaction(localTransaction);
            localTransaction.onSwitchToBackupChannel();
            continue;
            return;
          }
        }
      }
      finally
      {
        for (;;)
        {
          throw localObject2;
        }
        i += 1;
      }
    }
  }
  
  boolean updateAndCheckNet()
  {
    HwNetworkCenter.getInstance(this.engine.getAppContext()).updateNetInfo(this.engine.getAppContext());
    return HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType() != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.transaction.TransactionWorker
 * JD-Core Version:    0.7.0.1
 */