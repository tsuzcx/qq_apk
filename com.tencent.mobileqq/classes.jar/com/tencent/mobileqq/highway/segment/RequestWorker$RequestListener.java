package com.tencent.mobileqq.highway.segment;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.conn.IConnection;
import com.tencent.mobileqq.highway.conn.TcpConnection;
import com.tencent.mobileqq.highway.transaction.DataTransInfo;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.transaction.TransactionWorker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

class RequestWorker$RequestListener
  implements IRequestListener
{
  private Runnable netDetectTimer;
  private final HwRequest req;
  private Runnable reqTimeoutTimer;
  private Runnable writeTimeoutTimer;
  
  public RequestWorker$RequestListener(RequestWorker paramRequestWorker, HwRequest paramHwRequest)
  {
    this.req = paramHwRequest;
    this.netDetectTimer = new RequestWorker.RequestListener.1(this, paramRequestWorker, paramHwRequest);
    this.reqTimeoutTimer = new RequestWorker.RequestListener.2(this, paramRequestWorker);
    this.writeTimeoutTimer = new RequestWorker.RequestListener.3(this, paramRequestWorker);
  }
  
  private void recordConnInfo(HwRequest paramHwRequest, long paramLong)
  {
    Object localObject = ((RequestDataTrans)paramHwRequest).mInfo;
    int i;
    if (localObject != null) {
      i = ((DataTransInfo)localObject).length;
    } else {
      i = 0;
    }
    if ((this.this$0.engine != null) && (this.this$0.engine.mConnManager != null))
    {
      localObject = (IConnection)this.this$0.engine.mConnManager.connections.get(Integer.valueOf(paramHwRequest.sendConnId));
      if ((localObject != null) && (((IConnection)localObject).getProtoType() == 1))
      {
        localObject = (TcpConnection)localObject;
        ((TcpConnection)localObject).mLastDataSegSize = i;
        ((TcpConnection)localObject).mLastDataTransTime = paramLong;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("recordConnInfo: conId = ");
        ((StringBuilder)localObject).append(paramHwRequest.sendConnId);
        ((StringBuilder)localObject).append(" record con.mLastDataTransTime = ");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" con.mLastDataSegSize = ");
        ((StringBuilder)localObject).append(i);
        BdhLogUtil.LogEvent("R", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void scheduleRetry(int paramInt, long paramLong)
  {
    if ((RequestWorker.access$400(this.this$0).get()) && (!this.req.isCancel.get()))
    {
      if (this.this$0.mRequestHandler == null) {
        return;
      }
      this.req.lastSendStartTime = SystemClock.uptimeMillis();
      boolean bool;
      if (HwNetworkCenter.getInstance(this.this$0.engine.getAppContext()).getNetType() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      if ((this.req instanceof RequestDataTrans))
      {
        localObject = this.this$0.engine.mTransWorker.getTransactionById(this.req.transId);
        if (localObject != null) {
          ((Transaction)localObject).getRetryRequests().put(Integer.valueOf(this.req.getHwSeq()), this.req);
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("conId:");
      ((StringBuilder)localObject).append(this.req.sendConnId);
      ((StringBuilder)localObject).append(" ScheduleRetry : ");
      ((StringBuilder)localObject).append(this.req.getHwSeq());
      ((StringBuilder)localObject).append(" retry:");
      ((StringBuilder)localObject).append(this.req.retryCount);
      ((StringBuilder)localObject).append(" delay:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" hasNet:");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(" sentRequestsRetry.size()");
      BdhLogUtil.LogEvent("R", ((StringBuilder)localObject).toString());
      if (bool)
      {
        localObject = this.req;
        ((HwRequest)localObject).retryCount += 1;
        this.req.onRetry(paramInt);
        if (paramLong != 0L)
        {
          this.this$0.mRequestHandler.postDelayed(new RequestWorker.RequestListener.4(this), paramLong);
          return;
        }
        this.this$0.engine.mConnManager.wakeupConnectionToWrite(this.this$0.mCurrentRequests, false);
        return;
      }
      this.this$0.mRequestHandler.postDelayed(this.netDetectTimer, paramLong);
    }
  }
  
  public void handleConnClosed() {}
  
  public void handleError(int paramInt, String paramString, IConnection paramIConnection)
  {
    Object localObject1 = this.req;
    if (!(localObject1 instanceof RequestAck)) {
      ((HwRequest)localObject1).onError(paramInt);
    }
    long l2 = HwNetworkCenter.getInstance(this.this$0.engine.getAppContext()).getNetType();
    long l1 = 0L;
    int j = 0;
    boolean bool2;
    if (l2 != 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.this$0.mRequestHandler.removeCallbacks(this.reqTimeoutTimer);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("conId:");
    ((StringBuilder)localObject1).append(this.req.sendConnId);
    ((StringBuilder)localObject1).append(" HandleError : Seq:");
    ((StringBuilder)localObject1).append(this.req.getHwSeq());
    ((StringBuilder)localObject1).append(" ErrCode:");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(" HasNet:");
    ((StringBuilder)localObject1).append(bool2);
    BdhLogUtil.LogEvent("R", ((StringBuilder)localObject1).toString());
    if (this.req.isCancel.get()) {
      return;
    }
    l2 = SystemClock.uptimeMillis();
    long l3 = this.req.lastSendStartTime;
    localObject1 = this.req;
    ((HwRequest)localObject1).timeComsume += l2 - l3;
    boolean bool1;
    if (paramInt == -1004)
    {
      if (this.req.hwCmd.equalsIgnoreCase("PicUp.DataUp")) {
        paramInt = ((RequestDataTrans)this.req).mInfo.errno;
      }
      bool1 = false;
    }
    else
    {
      bool1 = true;
    }
    Transaction localTransaction = null;
    Object localObject2;
    boolean bool3;
    if ((bool2) && (paramInt != -1000))
    {
      localObject1 = this.req;
      ((HwRequest)localObject1).continueErrCount += 1;
      if (paramInt == -1003)
      {
        if (this.req.endpoint != null) {
          localObject1 = this.req.endpoint.host;
        } else {
          localObject1 = null;
        }
        if ((this.req.lastUseAddress != null) && (this.req.lastUseAddress.equalsIgnoreCase((String)localObject1)))
        {
          localObject2 = this.req;
          ((HwRequest)localObject2).continueConnClose += 1;
        }
        else
        {
          this.req.continueConnClose = 1;
        }
        localObject2 = this.req;
        ((HwRequest)localObject2).lastUseAddress = ((String)localObject1);
        bool3 = bool1;
        if (((HwRequest)localObject2).continueConnClose >= 3)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ContinueConnClose exceed the ContinueConnClosedLimitation. Host : ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(" retryCount:");
          ((StringBuilder)localObject2).append(this.req.retryCount);
          BdhLogUtil.LogEvent("C", ((StringBuilder)localObject2).toString());
          localObject2 = ConfigManager.getInstance(this.this$0.engine.getAppContext(), this.this$0.engine);
          if (localObject2 != null)
          {
            Context localContext = this.this$0.engine.getAppContext();
            AppRuntime localAppRuntime = this.this$0.engine.app;
            String str = this.this$0.engine.currentUin;
            if (paramIConnection == null) {
              bool3 = false;
            } else {
              bool3 = paramIConnection.isIpv6();
            }
            ((ConfigManager)localObject2).onSrvAddrUnavailable(localContext, localAppRuntime, str, (String)localObject1, 9, bool3);
          }
          localObject1 = this.this$0.engine.mTransWorker.getTransactionById(this.req.transId);
          bool3 = bool1;
          if (localObject1 != null)
          {
            ((Transaction)localObject1).onRequestFailed(paramInt);
            bool3 = bool1;
          }
        }
      }
      else
      {
        bool3 = bool1;
        if (paramInt == -1014) {
          bool3 = false;
        }
      }
    }
    else
    {
      this.req.continueConnClose = 0;
      bool3 = bool1;
    }
    int i;
    if (this.req.timeComsume >= 600000L) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.req.continueErrCount >= 10) {
      j = 1;
    }
    localObject1 = localTransaction;
    if (!(this.req instanceof RequestAck))
    {
      localTransaction = this.this$0.engine.mTransWorker.getTransactionById(this.req.transId);
      localObject1 = localTransaction;
      if (localTransaction != null)
      {
        localObject2 = localTransaction.mTransReport;
        if (this.req.protoType == 1) {
          localObject1 = "TCP";
        } else {
          localObject1 = "HTTP";
        }
        ((TransReport)localObject2).protoType = ((String)localObject1);
        localObject1 = localTransaction;
        if (this.req.endpoint != null)
        {
          localTransaction.mTransReport.ipIndex = this.req.endpoint.ipIndex;
          if (paramIConnection != null) {
            localTransaction.mTransReport.isIpv6 = paramIConnection.isIpv6();
          }
          localTransaction.mTransReport.mHasIpv6List = this.this$0.engine.mConnManager.mHasIpv6List;
          localTransaction.mTransReport.mIPv6Fast = this.this$0.engine.mConnManager.isIpv6Fast();
          localObject1 = localTransaction;
        }
      }
    }
    if ((bool3) && (i == 0) && (j == 0))
    {
      if (!bool2) {
        l1 = 6000L;
      }
      paramString = this.req;
      if (!(paramString instanceof RequestHeartBreak))
      {
        RequestWorker.access$100(this.this$0, paramString);
        scheduleRetry(paramInt, l1);
      }
    }
    else
    {
      paramIConnection = new StringBuilder();
      paramIConnection.append("HandleError : Seq:");
      paramIConnection.append(this.req.getHwSeq());
      paramIConnection.append(" NotifyError :");
      paramIConnection.append(paramInt);
      paramIConnection.append("req.timeComsume:");
      paramIConnection.append(this.req.timeComsume);
      paramIConnection.append(" allowRetry:");
      paramIConnection.append(bool3);
      paramIConnection.append(" req.continueErrCount:");
      paramIConnection.append(this.req.continueErrCount);
      BdhLogUtil.LogEvent("R", paramIConnection.toString());
      this.req.onError(paramInt);
      if (localObject1 != null)
      {
        paramIConnection = new HwResponse();
        paramIConnection.hwSeq = this.req.getHwSeq();
        paramIConnection.errCode = paramInt;
        if (i != 0) {
          paramIConnection.errCode = -1005;
        }
        ((Transaction)localObject1).onTransFailed(paramIConnection.errCode, paramString, 0, 0, this.req.retryCount, null);
      }
      RequestWorker.access$300(this.this$0).remove(Integer.valueOf(this.req.getHwSeq()));
    }
  }
  
  public void handleResponse(HwResponse paramHwResponse)
  {
    Object localObject = this.this$0.mRequestHandler;
    long l1 = paramHwResponse.recvTime - this.req.sendTime;
    long l2 = SystemClock.uptimeMillis();
    long l3 = paramHwResponse.recvTime;
    HwRequest localHwRequest = this.req;
    if ((localHwRequest instanceof RequestDataTrans)) {
      recordConnInfo(localHwRequest, l1);
    }
    paramHwResponse.reqCost = l1;
    paramHwResponse.switchCost = (l2 - l3);
    paramHwResponse.mBuCmdId = this.req.mBuCmdId;
    paramHwResponse.mTransId = this.req.transId;
    if (localObject != null) {
      ((RequestWorker.RequestHandler)localObject).removeCallbacks(this.reqTimeoutTimer);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("HandleResp :");
    ((StringBuilder)localObject).append(paramHwResponse.dumpRespInfo());
    ((StringBuilder)localObject).append(" ,isCancle:");
    ((StringBuilder)localObject).append(this.req.isCancel);
    BdhLogUtil.LogEvent("R", ((StringBuilder)localObject).toString());
    if ((this.req.isCancel.get()) && ("PicUp.Echo".equalsIgnoreCase(this.req.hwCmd)))
    {
      RequestWorker.access$300(this.this$0).remove(Integer.valueOf(this.req.getHwSeq()));
      return;
    }
    if ((paramHwResponse.isIpv6) && (paramHwResponse.retCode == 97))
    {
      BdhLogUtil.LogEvent("R", "handleResponse , ipv6 illegal user");
      this.this$0.engine.mConnManager.onIPV6IllegalUserErr(this.req.sendConnId);
      RequestWorker.access$100(this.this$0, this.req);
      scheduleRetry(paramHwResponse.buzRetCode, 0L);
      return;
    }
    if ((paramHwResponse.shouldRetry) && (this.req.buzRetryCount < 3))
    {
      localObject = this.req;
      ((HwRequest)localObject).buzRetryCount += 1;
      RequestWorker.access$100(this.this$0, this.req);
      scheduleRetry(paramHwResponse.buzRetCode, 0L);
      return;
    }
    RequestWorker.access$300(this.this$0).remove(Integer.valueOf(this.req.getHwSeq()));
    this.req.updateStaus(4);
    localObject = (IConnection)this.this$0.engine.mConnManager.connections.get(Integer.valueOf(this.req.sendConnId));
    if (localObject != null) {
      paramHwResponse.isIpv6 = ((IConnection)localObject).isIpv6();
    }
    this.req.onResponse(this.this$0, paramHwResponse);
  }
  
  public void handleSendBegin(int paramInt)
  {
    RequestWorker.RequestHandler localRequestHandler = this.this$0.mRequestHandler;
    if ((RequestWorker.access$400(this.this$0).get()) && (localRequestHandler != null))
    {
      localRequestHandler.removeCallbacks(this.reqTimeoutTimer);
      localRequestHandler.removeCallbacks(this.netDetectTimer);
      HwRequest localHwRequest = this.req;
      localHwRequest.sendConnId = paramInt;
      localHwRequest.lastSendStartTime = SystemClock.uptimeMillis();
      localRequestHandler.postDelayed(this.reqTimeoutTimer, this.req.timeOut);
      localRequestHandler.postDelayed(this.writeTimeoutTimer, this.req.timeOut);
      this.req.onSendBegin();
    }
  }
  
  public void handleSendEnd(int paramInt1, int paramInt2)
  {
    this.req.sendComsume = (SystemClock.uptimeMillis() - this.req.lastSendStartTime);
    this.req.protoType = paramInt2;
    Object localObject = this.this$0.mRequestHandler;
    if (localObject != null) {
      ((RequestWorker.RequestHandler)localObject).removeCallbacks(this.writeTimeoutTimer);
    }
    this.req.onSendEnd();
    localObject = this.req;
    if ((localObject instanceof RequestDataTrans))
    {
      localObject = ((RequestDataTrans)localObject).mInfo.parent;
      if (localObject != null)
      {
        AtomicInteger localAtomicInteger = (AtomicInteger)((Transaction)localObject).mTransReport.mDataFlowOfChannel.get(Integer.valueOf(paramInt1));
        if (localAtomicInteger != null)
        {
          localAtomicInteger.incrementAndGet();
          return;
        }
        localAtomicInteger = new AtomicInteger(1);
        ((Transaction)localObject).mTransReport.mDataFlowOfChannel.put(Integer.valueOf(paramInt1), localAtomicInteger);
      }
    }
  }
  
  public void handleSendTimeOut()
  {
    if (this.req.isCancel.get())
    {
      RequestWorker.access$300(this.this$0).remove(Integer.valueOf(this.req.getHwSeq()));
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("conId:");
    ((StringBuilder)localObject1).append(this.req.sendConnId);
    ((StringBuilder)localObject1).append(" handleSendTimeOut->req.hwSeq:");
    ((StringBuilder)localObject1).append(this.req.getHwSeq());
    BdhLogUtil.LogEvent("R", ((StringBuilder)localObject1).toString());
    this.req.onError(-1005);
    int i = this.req.sendConnId;
    localObject1 = this.req;
    if ((localObject1 instanceof RequestHeartBreak))
    {
      localObject1 = (RequestHeartBreak)localObject1;
      if (((RequestHeartBreak)localObject1).isUrgent) {
        try
        {
          this.req.isCancel.set(true);
          RequestWorker.access$300(this.this$0).remove(Integer.valueOf(this.req.getHwSeq()));
          this.this$0.engine.mConnManager.onUrgentHeartBreakTimeout(this.req.sendConnId);
          return;
        }
        finally {}
      }
    }
    this.this$0.engine.mConnManager.onRequestTimeOut(i);
    if ((RequestWorker.access$500(this.this$0).get(Integer.valueOf(i)) != null) && (!((HwRequest)RequestWorker.access$500(this.this$0).get(Integer.valueOf(i))).isCancel.get()) && (((HwRequest)RequestWorker.access$500(this.this$0).get(Integer.valueOf(i))).status.get() != 4))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("conId:");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(" handleSendTimeOut->there has been a HB sending !");
      BdhLogUtil.LogEvent("R", ((StringBuilder)localObject1).toString());
    }
    else
    {
      this.this$0.sendHeartBreak(i, true, true, 0);
    }
    localObject1 = this.req;
    ((HwRequest)localObject1).timeOut += 15000L;
    localObject1 = this.req;
    ((HwRequest)localObject1).timeOutCount += 1;
    handleError(-1005, "ReqTimeOut", (IConnection)this.this$0.engine.mConnManager.connections.get(Integer.valueOf(i)));
  }
  
  public void handleWriteTimeout()
  {
    if (this.req.isCancel.get())
    {
      RequestWorker.access$300(this.this$0).remove(Integer.valueOf(this.req.getHwSeq()));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("conId:");
    localStringBuilder.append(this.req.sendConnId);
    localStringBuilder.append(" handleWriteTimeout->req.hwSeq:");
    localStringBuilder.append(this.req.getHwSeq());
    BdhLogUtil.LogEvent("R", localStringBuilder.toString());
    this.req.onError(-1006);
    this.this$0.engine.mConnManager.onRequestWriteTimeout(this.req.sendConnId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestWorker.RequestListener
 * JD-Core Version:    0.7.0.1
 */