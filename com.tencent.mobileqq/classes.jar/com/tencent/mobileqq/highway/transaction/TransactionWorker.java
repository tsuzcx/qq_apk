package com.tencent.mobileqq.highway.transaction;

import android.os.Handler;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.config.HwServlet;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;

public class TransactionWorker
  implements IHwManager
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
  private volatile int index;
  private SparseArray<ArrayList<Transaction>> transQueues = new SparseArray();
  private ArrayList<Transaction> transWaitForSessionKeyQueue = new ArrayList();
  
  public TransactionWorker(HwEngine paramHwEngine)
  {
    this.engine = paramHwEngine;
  }
  
  private void submitTransactionToTransQuene(Transaction paramTransaction)
  {
    paramTransaction.transationId = seqFactory.incrementAndGet();
    BdhLogUtil.LogEvent("T", "SubmitTransation : T_Id:" + paramTransaction.transationId + " ukey:" + String.valueOf(paramTransaction.ticket));
    SparseArray localSparseArray = this.transQueues;
    int i = 0;
    try
    {
      if (paramTransaction.mBuzCmdId == 25) {
        i = 1;
      }
      if (this.transQueues.get(i) != null)
      {
        ((ArrayList)this.transQueues.get(i)).add(paramTransaction);
        BdhLogUtil.LogEvent("T", "SubmitTransation : T_Id:" + paramTransaction.transationId + " : add to queue[ " + i + "]");
      }
      notifyToSend();
      paramTransaction.startTime = SystemClock.uptimeMillis();
      return;
    }
    finally {}
  }
  
  private int submitTransactionToWaitForSessionKeyQuene(Transaction paramTransaction)
  {
    if ((this.engine == null) || (this.engine.app == null) || (this.engine.app.getAccount() == null) || (this.engine.mRequestWorker == null) || (this.engine.mRequestWorker.mRequestHandler == null)) {
      return -1015;
    }
    final String str = this.engine.app.getAccount();
    HwServlet.getConfig(this.engine.app, str);
    final RequestWorker.RequestHandler localRequestHandler = this.engine.mRequestWorker.mRequestHandler;
    paramTransaction.waitForSessionkeyStartTime = SystemClock.uptimeMillis();
    this.transWaitForSessionKeyQueue.add(paramTransaction);
    BdhLogUtil.LogEvent("T", "Submit Trans to transWaitForSessionKeyQueue ,Transaction path:" + paramTransaction.filePath + " Transaction waitForSessionkeyStartTime:" + paramTransaction.waitForSessionkeyStartTime + " transWaitForSessionKeyQueue size:" + this.transWaitForSessionKeyQueue.size());
    if (this.transWaitForSessionKeyQueue.size() == 1) {
      localRequestHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          ArrayList localArrayList;
          for (;;)
          {
            Transaction localTransaction2;
            try
            {
              byte[] arrayOfByte1 = SessionInfo.getInstance(str).getHttpconn_sig_session();
              if ((arrayOfByte1 == null) || (arrayOfByte1.length == 0)) {
                break label315;
              }
              BdhLogUtil.LogEvent("T", "Get SessionKey Successfully， push them to task quene,transWaitForSessionKeyQueue size:" + TransactionWorker.this.transWaitForSessionKeyQueue.size());
              int i = arrayOfByte1.length;
              localArrayList = new ArrayList();
              Iterator localIterator = TransactionWorker.this.transWaitForSessionKeyQueue.iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              localTransaction2 = (Transaction)localIterator.next();
              localTransaction2.ticket = new byte[i];
              System.arraycopy(arrayOfByte1, 0, localTransaction2.ticket, 0, i);
              if (!localTransaction2.needCryptExtendInfo) {
                break label276;
              }
              byte[] arrayOfByte2 = SessionInfo.getInstance(str).getSessionKey();
              if ((arrayOfByte2 != null) && (arrayOfByte2.length != 0))
              {
                int j = SessionInfo.getInstance(str).getSessionKey().length;
                byte[] arrayOfByte3 = new byte[j];
                System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 0, j);
                localTransaction2.extendInfo = new Cryptor().encrypt(localTransaction2.extendInfo, arrayOfByte3);
                TransactionWorker.this.submitTransactionToTransQuene(localTransaction2);
                continue;
              }
              BdhLogUtil.LogEvent("T", "Get SessionKey Successfully,but task has mSigSession, not has mSessionKey, Trasction path:" + localTransaction2.filePath);
            }
            finally {}
            HwServlet.getConfig(TransactionWorker.this.engine.app, str);
            localArrayList.add(localTransaction2);
            continue;
            label276:
            TransactionWorker.this.submitTransactionToTransQuene(localTransaction2);
          }
          TransactionWorker.this.transWaitForSessionKeyQueue.clear();
          TransactionWorker.this.transWaitForSessionKeyQueue.addAll(localArrayList);
          for (;;)
          {
            return;
            label315:
            BdhLogUtil.LogEvent("T", "Get SessionKey failed,transWaitForSessionKeyQueue size:" + TransactionWorker.this.transWaitForSessionKeyQueue.size());
            Transaction localTransaction1 = (Transaction)TransactionWorker.this.transWaitForSessionKeyQueue.get(0);
            if (localTransaction1 != null)
            {
              if (SystemClock.uptimeMillis() - localTransaction1.waitForSessionkeyStartTime > 30000L)
              {
                TransactionWorker.this.transWaitForSessionKeyQueue.remove(localTransaction1);
                localTransaction1.cb.onFailed(-1015, null, new HashMap());
                BdhLogUtil.LogEvent("T", "Get SessionKey failed,first transaction failed, transWaitForSessionKeyQueue size:" + TransactionWorker.this.transWaitForSessionKeyQueue.size());
              }
              if (TransactionWorker.this.transWaitForSessionKeyQueue.size() > 0) {
                localRequestHandler.postDelayed(this, 500L);
              }
            }
          }
        }
      }, 500L);
    }
    return 0;
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
    QLog.d("E", 1, "EngineInfo : Request:" + i + " TransCnt:" + j + " ConnCnt:" + k);
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
    Object localObject1 = null;
    SparseArray localSparseArray = this.transQueues;
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      Object localObject4;
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
      finally {}
      i += 1;
      Object localObject3 = localObject4;
    }
  }
  
  public int getTransactionNum()
  {
    int j = 0;
    SparseArray localSparseArray = this.transQueues;
    int i = 0;
    for (;;)
    {
      int k;
      if (i < 3) {
        k = j;
      }
      try
      {
        if (this.transQueues.get(i) == null) {
          break label64;
        }
        k = j + ((ArrayList)this.transQueues.get(i)).size();
      }
      finally {}
      return j;
      label64:
      i += 1;
      j = k;
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
    for (;;)
    {
      if (i < 3)
      {
        try
        {
          Object localObject1 = new ArrayList();
          if (this.transQueues.get(i) == null) {
            break label122;
          }
          ((ArrayList)localObject1).addAll((Collection)this.transQueues.get(i));
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            cancelTransaction((Transaction)((Iterator)localObject1).next());
          }
          ((ArrayList)this.transQueues.get(i)).clear();
        }
        finally {}
      }
      else
      {
        this.transQueues.clear();
        this.transWaitForSessionKeyQueue = new ArrayList();
        return;
      }
      label122:
      i += 1;
    }
  }
  
  public void onInit()
  {
    localSparseArray = this.transQueues;
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
      finally {}
    }
  }
  
  public void onTransactionFinish(boolean paramBoolean, Transaction paramTransaction)
  {
    SparseArray localSparseArray = this.transQueues;
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        if (this.transQueues.get(i) == null) {
          break label72;
        }
        ((ArrayList)this.transQueues.get(i)).remove(paramTransaction);
      }
      finally {}
      if (!paramBoolean) {
        this.engine.mRequestWorker.notifyTransactionChange(2, paramTransaction);
      }
      return;
      label72:
      i += 1;
    }
  }
  
  public DataTransInfo pullNextSegment(SparseArray<HwNetSegConf> paramSparseArray)
  {
    Object localObject1 = null;
    SparseArray localSparseArray = this.transQueues;
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
              }
            }
          }
          if (this.index >= round_array.length - 1)
          {
            this.index = 0;
            break label180;
          }
        }
        else
        {
          return localObject2;
        }
        this.index += 1;
      }
      finally {}
      label180:
      i += 1;
      localObject1 = localObject2;
      if (localObject2 == null) {
        break;
      }
    }
  }
  
  public void queryTransaction(Transaction paramTransaction, byte[] paramArrayOfByte)
  {
    this.engine.mRequestWorker.sendInfoQueryRequest(paramTransaction, paramArrayOfByte);
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
    catch (Throwable paramProbeCallback) {}
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
    if ((paramTransaction == null) || (paramTransaction.filePath == null) || (paramTransaction.transationId != -1)) {
      return 9042;
    }
    if (this.engine.mConnManager.getCurrentConnNum() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      int i = paramTransaction.initSegmentList(this, bool);
      if (i == 0)
      {
        if (paramTransaction.ticket == null) {
          break;
        }
        submitTransactionToTransQuene(paramTransaction);
      }
      return i;
    }
    return submitTransactionToWaitForSessionKeyQuene(paramTransaction);
  }
  
  public void switchToBackupChannel()
  {
    SparseArray localSparseArray = this.transQueues;
    int i = 0;
    while (i < 3) {
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
          }
        }
        i += 1;
      }
      finally {}
    }
  }
  
  boolean updateAndCheckNet()
  {
    HwNetworkCenter.getInstance(this.engine.getAppContext()).updateNetInfo(this.engine.getAppContext());
    return HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType() != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.transaction.TransactionWorker
 * JD-Core Version:    0.7.0.1
 */