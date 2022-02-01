package com.tencent.mobileqq.highway.segment;

import android.os.HandlerThread;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.conn.IConnection;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;
import com.tencent.mobileqq.highway.transaction.DataTransInfo;
import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.transaction.TransactionWorker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhSegTimeoutUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestWorker
  implements IHwManager
{
  public static final int PRIORITY_NUM = 3;
  public static final int REQ_PRIORITY_DATA = 2;
  public static final int REQ_PRIORITY_HEART = 0;
  public static final int REQ_PRIORITY_QUERY = 1;
  private static final AtomicInteger seqFactory = new AtomicInteger(new Random().nextInt(100000));
  HwEngine engine;
  public volatile int mCurrentRequests = 0;
  private HandlerThread mHandlerThread;
  public RequestWorker.RequestHandler mRequestHandler;
  private AtomicBoolean mWorking = new AtomicBoolean(false);
  private SparseArray<List<HwRequest>> priorityList = new SparseArray();
  private ConcurrentHashMap<Integer, HwRequest> sendUrgentHB = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, HwRequest> sentRequests = new ConcurrentHashMap();
  
  public RequestWorker(HwEngine paramHwEngine)
  {
    this.engine = paramHwEngine;
  }
  
  private void addHwRequest(HwRequest paramHwRequest)
  {
    int j = paramHwRequest.getPriority();
    int i = j;
    if (j + 0 > 3) {
      i = 2;
    }
    synchronized (this.priorityList)
    {
      paramHwRequest.status.set(2);
      ((List)this.priorityList.get(i)).add(paramHwRequest);
      if (paramHwRequest.getPriority() > 0) {
        this.mCurrentRequests += 1;
      }
      return;
    }
  }
  
  private void cancelAllRequest()
  {
    ??? = this.priorityList;
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        ((List)this.priorityList.get(i)).clear();
        i += 1;
      }
      finally
      {
        Iterator localIterator;
        break label117;
      }
    }
    synchronized (this.sentRequests)
    {
      localIterator = this.sentRequests.values().iterator();
      while (localIterator.hasNext()) {
        ((HwRequest)localIterator.next()).isCancel.set(true);
      }
      this.sentRequests.clear();
      this.sendUrgentHB.clear();
      return;
    }
    label117:
    for (;;)
    {
      throw localObject3;
    }
  }
  
  private void cancelRequestByTrans(Transaction paramTransaction)
  {
    Object localObject2 = new ArrayList();
    synchronized (this.priorityList)
    {
      Object localObject3 = (List)this.priorityList.get(2);
      Iterator localIterator = ((List)localObject3).iterator();
      while (localIterator.hasNext())
      {
        HwRequest localHwRequest = (HwRequest)localIterator.next();
        if (localHwRequest.transId == paramTransaction.getTransationId())
        {
          localHwRequest.isCancel.set(true);
          localHwRequest.onCancle();
          ((ArrayList)localObject2).add(localHwRequest);
        }
      }
      ((List)localObject3).removeAll((Collection)localObject2);
      ((ArrayList)localObject2).clear();
      synchronized (this.sentRequests)
      {
        localObject2 = this.sentRequests.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (HwRequest)((Iterator)localObject2).next();
          if ((((HwRequest)localObject3).transId == paramTransaction.getTransationId()) && (((HwRequest)localObject3).getPriority() == 2))
          {
            ((HwRequest)localObject3).isCancel.set(true);
            ((HwRequest)localObject3).onCancle();
          }
        }
        return;
      }
    }
    for (;;)
    {
      throw paramTransaction;
    }
  }
  
  private void doQuit()
  {
    cancelAllRequest();
    this.mRequestHandler = null;
    this.mHandlerThread.quit();
  }
  
  public static int getNextSeq()
  {
    try
    {
      int i = seqFactory.incrementAndGet();
      if (i > 1000000) {
        seqFactory.set(new Random().nextInt(1060000));
      }
      return i;
    }
    finally {}
  }
  
  private void handleConnClosed(int paramInt)
  {
    Object localObject3;
    int j;
    int m;
    label698:
    synchronized (this.sentRequests)
    {
      SparseArray localSparseArray = new SparseArray();
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = this.sentRequests.values().iterator();
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (HwRequest)((Iterator)localObject2).next();
        if (((HwRequest)localObject3).isCancel.get()) {
          break label698;
        }
        if (((HwRequest)localObject3).sendConnId == paramInt)
        {
          localObject4 = (IConnection)this.engine.mConnManager.connections.get(Integer.valueOf(paramInt));
          if (((HwRequest)localObject3).hwCmd.equalsIgnoreCase("PicUp.Echo"))
          {
            ((HwRequest)localObject3).isCancel.set(true);
            ((HwRequest)localObject3).reqListener.handleError(-1003, "ConnClose", (IConnection)localObject4);
          }
          else if (((HwRequest)localObject3).hwCmd.equalsIgnoreCase("PicUp.QueryOffset"))
          {
            ((HwRequest)localObject3).reqListener.handleError(-1003, "ConnClose", (IConnection)localObject4);
          }
          else if ((localObject3 instanceof RequestFilter))
          {
            if (((HwRequest)localObject3).retryCount > 1)
            {
              this.sentRequests.remove(Integer.valueOf(((HwRequest)localObject3).getHwSeq()));
              ((HwRequest)localObject3).onError(-1003);
              return;
            }
            ((HwRequest)localObject3).reqListener.handleError(-1003, "ConnClose", (IConnection)localObject4);
          }
          else if ((((HwRequest)localObject3).hwCmd.equalsIgnoreCase("PicUp.DataUp")) && (!((HwRequest)localObject3).isCancel.get()) && (((HwRequest)localObject3).status.get() == 3))
          {
            localObject4 = this.engine.mTransWorker.getTransactionById(((HwRequest)localObject3).transId);
            if (localObject4 != null) {
              localSparseArray.put(((Transaction)localObject4).getTransationId(), localObject4);
            }
            localArrayList.add(localObject3);
          }
        }
      }
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (HwRequest)((Iterator)localObject2).next();
        ((HwRequest)localObject3).isCancel.set(true);
        this.sentRequests.remove(Integer.valueOf(((HwRequest)localObject3).getHwSeq()));
      }
      int k = localSparseArray.size();
      int i = 0;
      while (i < k)
      {
        localObject2 = (Transaction)localSparseArray.valueAt(i);
        localObject3 = new byte[((Transaction)localObject2).bitmap.length];
        localObject4 = localArrayList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          HwRequest localHwRequest = (HwRequest)((Iterator)localObject4).next();
          if (localHwRequest.transId == ((Transaction)localObject2).getTransationId())
          {
            Object localObject5 = (RequestDataTrans)localHwRequest;
            j = ((RequestDataTrans)localObject5).mInfo.bitmapS;
            m = ((RequestDataTrans)localObject5).mInfo.bitmapE;
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("QueryDebug Waiting Resp : ");
            ((StringBuilder)localObject5).append(localHwRequest.dumpBaseInfo());
            BdhLogUtil.LogEvent("R", ((StringBuilder)localObject5).toString());
            break label701;
          }
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("QueryDebug Before Query : TransId:");
        ((StringBuilder)localObject4).append(((Transaction)localObject2).getTransationId());
        ((StringBuilder)localObject4).append(" CopyBitmap:");
        ((StringBuilder)localObject4).append(Arrays.toString((byte[])localObject3));
        ((StringBuilder)localObject4).append(" CurrentBitmap:");
        ((StringBuilder)localObject4).append(Arrays.toString(((Transaction)localObject2).bitmap));
        BdhLogUtil.LogEvent("R", ((StringBuilder)localObject4).toString());
        sendInfoQueryRequest((Transaction)localObject2, (byte[])localObject3);
        i += 1;
      }
      if ((k == 0) && (this.engine.mTransWorker.getTransactionNum() > 0)) {
        this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
      }
      this.sendUrgentHB.remove(Integer.valueOf(paramInt));
      return;
    }
    label701:
    while (j <= m)
    {
      localObject3[j] = 2;
      j += 1;
    }
  }
  
  private void handleResp(List<HwResponse> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      HwResponse localHwResponse = (HwResponse)localIterator.next();
      HwRequest localHwRequest = (HwRequest)this.sentRequests.get(Integer.valueOf(localHwResponse.hwSeq));
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("HandleResp : Resp.hwSeq:");
      ((StringBuilder)localObject).append(localHwResponse.hwSeq);
      ((StringBuilder)localObject).append(" SegmentResp:");
      ((StringBuilder)localObject).append(localHwResponse.segmentResp);
      ((StringBuilder)localObject).append(" FIN:");
      paramList = localHwResponse.segmentResp;
      String str = "null";
      if (paramList != null) {
        paramList = Integer.valueOf(localHwResponse.segmentResp.uint32_flag.get());
      } else {
        paramList = "null";
      }
      ((StringBuilder)localObject).append(paramList);
      BdhLogUtil.LogEvent("R", ((StringBuilder)localObject).toString());
      paramList = localHwRequest;
      if (localHwRequest == null)
      {
        localObject = this.engine.mTransWorker.getTransactionById(localHwResponse.mTransId);
        paramList = localHwRequest;
        if (localObject != null)
        {
          localHwRequest = (HwRequest)((Transaction)localObject).getRetryRequests().get(Integer.valueOf(localHwResponse.hwSeq));
          paramList = localHwRequest;
          if (localHwRequest != null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("HandleRetryRequestsResp : Resp.hwSeq:");
            ((StringBuilder)localObject).append(localHwResponse.hwSeq);
            ((StringBuilder)localObject).append(" SegmentResp:");
            ((StringBuilder)localObject).append(localHwResponse.segmentResp);
            ((StringBuilder)localObject).append(" FIN:");
            paramList = str;
            if (localHwResponse.segmentResp != null) {
              paramList = Integer.valueOf(localHwResponse.segmentResp.uint32_flag.get());
            }
            ((StringBuilder)localObject).append(paramList);
            BdhLogUtil.LogEvent("R", ((StringBuilder)localObject).toString());
            paramList = localHwRequest;
          }
        }
      }
      if ((paramList != null) && (paramList.reqListener != null)) {
        paramList.reqListener.handleResponse(localHwResponse);
      }
    }
    prepareRequests();
  }
  
  private void prepareRequests()
  {
    Object localObject1 = this.engine.getCurrentConfig();
    int i = ((List)this.priorityList.get(2)).size() + this.sentRequests.size();
    long l2 = ((HwNetSegConf)localObject1).segNum;
    long l1 = l2;
    if (l2 > 8L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("seg num beyond default,value :");
      ((StringBuilder)localObject1).append(l2);
      QLog.i("BDH_LOG", 1, ((StringBuilder)localObject1).toString());
      l1 = 8L;
    }
    for (int j = 0; i < l1; j = 1)
    {
      localObject1 = this.engine.mTransWorker.pullNextSegment(this.engine.getCurrentBuzConfigs());
      if (localObject1 == null) {
        break;
      }
      RequestDataTrans localRequestDataTrans = new RequestDataTrans(((DataTransInfo)localObject1).parent.peerUin, "PicUp.DataUp", ((DataTransInfo)localObject1).parent.mBuzCmdId, (DataTransInfo)localObject1, ((DataTransInfo)localObject1).parent.ticket, ((DataTransInfo)localObject1).parent.getTransationId(), 30000L);
      addHwRequest(localRequestDataTrans);
      i += 1;
      Object localObject2 = ((DataTransInfo)localObject1).parent.TRACKER;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" SLICEINFO Start:");
      localStringBuilder.append(((DataTransInfo)localObject1).bitmapS);
      localStringBuilder.append(" End:");
      localStringBuilder.append(((DataTransInfo)localObject1).bitmapE);
      localStringBuilder.append(" Seq:");
      localStringBuilder.append(localRequestDataTrans.getHwSeq());
      ((Tracker)localObject2).logStep("QUEUE", localStringBuilder.toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("PrepareRequests : T_Id:");
      ((StringBuilder)localObject2).append(((DataTransInfo)localObject1).parent.getTransationId());
      ((StringBuilder)localObject2).append(" Offset:");
      ((StringBuilder)localObject2).append(((DataTransInfo)localObject1).offset);
      ((StringBuilder)localObject2).append(" Len:");
      ((StringBuilder)localObject2).append(((DataTransInfo)localObject1).length);
      ((StringBuilder)localObject2).append(" HwSeq:");
      ((StringBuilder)localObject2).append(localRequestDataTrans.getHwSeq());
      ((StringBuilder)localObject2).append(" Status:");
      ((StringBuilder)localObject2).append(localRequestDataTrans.status.get());
      ((StringBuilder)localObject2).append(" dataSize:");
      ((StringBuilder)localObject2).append(i);
      BdhLogUtil.LogEvent("R", ((StringBuilder)localObject2).toString());
    }
    if (j != 0) {
      this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
    }
  }
  
  public void cancelAckRequest(HwRequest paramHwRequest)
  {
    paramHwRequest.isCancel.set(true);
    paramHwRequest.onCancle();
    synchronized (this.priorityList)
    {
      ((List)this.priorityList.get(2)).remove(paramHwRequest);
      synchronized (this.sentRequests)
      {
        this.sentRequests.remove(paramHwRequest);
        return;
      }
    }
  }
  
  public HwRequest getMaxPriorityRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3)
  {
    if (!this.mWorking.get()) {
      return null;
    }
    Object localObject3 = new ArrayList();
    int i;
    label583:
    label603:
    label606:
    synchronized (this.sentRequests)
    {
      Object localObject5 = this.sentRequests.values().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (HwRequest)((Iterator)localObject5).next();
        if (((HwRequest)localObject6).isCancel.get()) {
          ((ArrayList)localObject3).add(Integer.valueOf(((HwRequest)localObject6).getHwSeq()));
        }
      }
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        i = ((Integer)((Iterator)localObject3).next()).intValue();
        this.sentRequests.remove(Integer.valueOf(i));
      }
      Object localObject6 = new ArrayList();
      localObject5 = this.priorityList;
      ??? = null;
      i = 0;
      localObject3 = ???;
      if (i <= paramInt2) {}
      try
      {
        List localList = (List)this.priorityList.get(i);
        localObject3 = ???;
        if (localList.size() == 0) {
          break label606;
        }
        if (i != 0)
        {
          ??? = (HwRequest)localList.remove(0);
          if (((HwRequest)???).status.get() == 3)
          {
            localObject3 = ???;
            break label606;
          }
          localObject3 = ???;
          if ((??? instanceof RequestDataTrans))
          {
            localObject3 = ???;
            if (BdhSegTimeoutUtil.sEnableDynTimeout == 1)
            {
              paramLong1 = BdhSegTimeoutUtil.calculateTimeout(this.engine.getAppContext(), (RequestDataTrans)???, paramLong2, paramInt3, paramLong1);
              localObject3 = ???;
              if (paramLong1 > 1000L)
              {
                ((HwRequest)???).timeOut = paramLong1;
                localObject3 = ???;
              }
            }
          }
        }
        else
        {
          Object localObject7 = localList.iterator();
          do
          {
            for (;;)
            {
              if (!((Iterator)localObject7).hasNext()) {
                break label603;
              }
              localObject3 = (HwRequest)((Iterator)localObject7).next();
              if (this.engine.mConnManager.connections.containsKey(Integer.valueOf(((RequestHeartBreak)localObject3).connId))) {
                break;
              }
              ((ArrayList)localObject6).add(localObject3);
            }
          } while (((RequestHeartBreak)localObject3).connId != paramInt1);
          ??? = localObject3;
          if ((localObject3 instanceof RequestHeartBreak))
          {
            localObject7 = (RequestHeartBreak)localObject3;
            ??? = localObject3;
            if (((RequestHeartBreak)localObject7).isUrgent)
            {
              long l = BdhSegTimeoutUtil.getUrgentHbTimeout(this.engine.getAppContext());
              ??? = localObject3;
              if (l > 1000L)
              {
                ((RequestHeartBreak)localObject7).timeOut = l;
                ??? = localObject3;
              }
            }
          }
          if (??? != null) {
            localList.remove(???);
          }
          localList.removeAll((Collection)localObject6);
          localObject3 = ???;
          break label606;
        }
        if (localObject3 != null)
        {
          if (((HwRequest)localObject3).getPriority() > 0) {
            this.mCurrentRequests -= 1;
          }
          ((HwRequest)localObject3).updateStaus(3);
          this.sentRequests.put(Integer.valueOf(((HwRequest)localObject3).getHwSeq()), localObject3);
          if (((HwRequest)localObject3).reqListener == null) {
            ((HwRequest)localObject3).reqListener = new RequestWorker.RequestListener(this, (HwRequest)localObject3);
          }
          ((HwRequest)localObject3).reqListener.handleSendBegin(paramInt1);
        }
        return localObject3;
      }
      finally
      {
        break label583;
      }
      throw ((Throwable)???);
    }
  }
  
  public void notifyTransactionChange(int paramInt, Transaction paramTransaction)
  {
    Object localObject = this.mRequestHandler;
    if (this.mWorking.get())
    {
      if (localObject == null) {
        return;
      }
      if (paramInt == 1)
      {
        ((RequestWorker.RequestHandler)localObject).sendEmptyMessage(1);
        return;
      }
      if (paramInt == 2)
      {
        localObject = Message.obtain(this.mRequestHandler);
        ((Message)localObject).what = 3;
        ((Message)localObject).obj = paramTransaction;
        ((Message)localObject).sendToTarget();
      }
    }
  }
  
  public void onConnClose(int paramInt)
  {
    RequestWorker.RequestHandler localRequestHandler = this.mRequestHandler;
    if (this.mWorking.get())
    {
      if (localRequestHandler == null) {
        return;
      }
      localRequestHandler.post(new RequestWorker.1(this, paramInt));
    }
  }
  
  public void onConnConnected(int paramInt) {}
  
  public void onConnIdle(int paramInt) {}
  
  public void onDestroy()
  {
    if (this.mWorking.compareAndSet(true, false))
    {
      RequestWorker.RequestHandler localRequestHandler = this.mRequestHandler;
      if (localRequestHandler != null) {
        localRequestHandler.sendEmptyMessage(2);
      }
    }
  }
  
  public void onInit()
  {
    int i = 0;
    while (i < 3)
    {
      LinkedList localLinkedList = new LinkedList();
      this.priorityList.put(i, localLinkedList);
      i += 1;
    }
    this.mHandlerThread = new HandlerThread("Highway-BDH-REQ", 5);
    this.mHandlerThread.start();
    this.mRequestHandler = new RequestWorker.RequestHandler(this, this.mHandlerThread.getLooper());
    this.mWorking.set(true);
  }
  
  public void onNetworkChanged(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("RequestWorker onNetworkChanged : about to clear the request - hasNetwork:");
    ((StringBuilder)localObject).append(paramBoolean);
    BdhLogUtil.LogEvent("N", ((StringBuilder)localObject).toString());
    localObject = this.mRequestHandler;
    if ((paramBoolean) && (this.mWorking.get()))
    {
      if (localObject == null) {
        return;
      }
      if ((this.sentRequests.isEmpty()) && (this.mCurrentRequests == 0))
      {
        ((RequestWorker.RequestHandler)localObject).obtainMessage(1).sendToTarget();
        return;
      }
      sendConnectRequest(0L, false);
    }
  }
  
  public void onReceiveResp(List<HwResponse> paramList)
  {
    if (!this.mWorking.get()) {
      return;
    }
    handleResp(paramList);
  }
  
  public void remove2SENDRequest(int paramInt1, int paramInt2)
  {
    List localList = (List)this.priorityList.get(2);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      HwRequest localHwRequest = (HwRequest)localIterator.next();
      if (localHwRequest.transId == paramInt1)
      {
        RequestDataTrans localRequestDataTrans = (RequestDataTrans)localHwRequest;
        if ((localRequestDataTrans.mInfo.bitmapE <= paramInt2) && (localRequestDataTrans.status.get() == 2)) {
          localList.remove(localHwRequest.getHwSeq());
        }
      }
    }
  }
  
  public void sendAckRequest(HwRequest paramHwRequest)
  {
    addHwRequest(paramHwRequest);
    this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
  }
  
  public void sendConnectRequest(long paramLong, boolean paramBoolean)
  {
    RequestWorker.RequestHandler localRequestHandler = this.mRequestHandler;
    if (this.mWorking.get())
    {
      if (localRequestHandler == null) {
        return;
      }
      int i = 5;
      if (paramLong > 0L)
      {
        if (!paramBoolean) {
          i = 4;
        }
        localRequestHandler.sendMessageDelayed(localRequestHandler.obtainMessage(i), paramLong);
        return;
      }
      if (!paramBoolean) {
        i = 4;
      }
      localRequestHandler.obtainMessage(i).sendToTarget();
    }
  }
  
  public void sendFinishQueryRequest(Transaction paramTransaction, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = new RequestFinishQuery(paramTransaction.peerUin, "PicUp.QueryOffset", paramTransaction.mBuzCmdId, paramTransaction.ticket, paramTransaction, 30000L, paramArrayOfByte);
    paramTransaction.mCurrentQueryFinishCount += 1;
    paramArrayOfByte.mQueryHoleFinishIndex = paramInt;
    addHwRequest(paramArrayOfByte);
    paramTransaction = new StringBuilder();
    paramTransaction.append("sendFinishQueryRequest : ");
    paramTransaction.append(paramArrayOfByte.dumpBaseInfo());
    paramTransaction.append(" size:");
    paramTransaction.append(this.mCurrentRequests);
    paramTransaction.append(" queryIndex:");
    paramTransaction.append(paramArrayOfByte.mQueryHoleFinishIndex);
    BdhLogUtil.LogEvent("R", paramTransaction.toString());
    this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
  }
  
  public void sendHeartBreak(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    Object localObject1 = this.mRequestHandler;
    if (this.mWorking.get())
    {
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = new RequestHeartBreak(this.engine.currentUin, "PicUp.Echo", 0, 30000L, paramInt1, paramBoolean1);
      Runnable localRunnable = (Runnable)this.engine.mConnManager.heartBreaks.remove(Integer.valueOf(paramInt1));
      if ((paramBoolean2) && (localRunnable != null)) {
        ((RequestWorker.RequestHandler)localObject1).removeCallbacks(localRunnable);
      }
      if (paramInt2 == 0)
      {
        addHwRequest((HwRequest)localObject2);
        if (paramBoolean1) {
          this.sendUrgentHB.put(Integer.valueOf(paramInt1), localObject2);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("SendHeartBreak : ");
        ((StringBuilder)localObject1).append(((HwRequest)localObject2).dumpBaseInfo());
        ((StringBuilder)localObject1).append(" size:");
        ((StringBuilder)localObject1).append(this.mCurrentRequests);
        ((StringBuilder)localObject1).append(" delay:");
        ((StringBuilder)localObject1).append(paramInt2);
        BdhLogUtil.LogEvent("N", ((StringBuilder)localObject1).toString());
        this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
        return;
      }
      localObject2 = new RequestWorker.2(this, paramInt1, (HwRequest)localObject2, paramInt2);
      ((RequestWorker.RequestHandler)localObject1).postDelayed((Runnable)localObject2, paramInt2);
      this.engine.mConnManager.heartBreaks.put(Integer.valueOf(paramInt1), localObject2);
    }
  }
  
  public void sendInfoQueryFinish(Transaction paramTransaction, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt == 0)
    {
      sendFinishQueryRequest(paramTransaction, paramArrayOfByte, paramInt);
      return;
    }
    paramTransaction = new RequestWorker.3(this, paramTransaction, paramArrayOfByte, paramInt);
    this.mRequestHandler.postDelayed(paramTransaction, RequestFinishQuery.QUERY_HOLE_INTERVAL);
  }
  
  public void sendInfoQueryRequest(Transaction paramTransaction, byte[] paramArrayOfByte)
  {
    paramTransaction = new RequestInfoQuery(paramTransaction.peerUin, "PicUp.QueryOffset", paramTransaction.mBuzCmdId, paramTransaction.ticket, paramTransaction, 30000L, paramArrayOfByte);
    addHwRequest(paramTransaction);
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("SendInfoQueryRequest : ");
    paramArrayOfByte.append(paramTransaction.dumpBaseInfo());
    paramArrayOfByte.append(" size:");
    paramArrayOfByte.append(this.mCurrentRequests);
    BdhLogUtil.LogEvent("R", paramArrayOfByte.toString());
    this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestWorker
 * JD-Core Version:    0.7.0.1
 */