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
    int i = 0;
    Object localObject = ((RequestDataTrans)paramHwRequest).mInfo;
    if (localObject != null) {
      i = ((DataTransInfo)localObject).length;
    }
    if ((this.this$0.engine != null) && (this.this$0.engine.mConnManager != null))
    {
      localObject = (IConnection)this.this$0.engine.mConnManager.connections.get(Integer.valueOf(paramHwRequest.sendConnId));
      if ((localObject != null) && (((IConnection)localObject).getProtoType() == 1))
      {
        localObject = (TcpConnection)localObject;
        ((TcpConnection)localObject).mLastDataSegSize = i;
        ((TcpConnection)localObject).mLastDataTransTime = paramLong;
        BdhLogUtil.LogEvent("R", "recordConnInfo: conId = " + paramHwRequest.sendConnId + " record con.mLastDataTransTime = " + paramLong + " con.mLastDataSegSize = " + i);
      }
    }
  }
  
  private void scheduleRetry(int paramInt, long paramLong)
  {
    if ((!RequestWorker.access$400(this.this$0).get()) || (this.req.isCancel.get()) || (this.this$0.mRequestHandler == null)) {
      return;
    }
    this.req.lastSendStartTime = SystemClock.uptimeMillis();
    if (HwNetworkCenter.getInstance(this.this$0.engine.getAppContext()).getNetType() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.req instanceof RequestDataTrans))
      {
        localObject = this.this$0.engine.mTransWorker.getTransactionById(this.req.transId);
        if (localObject != null) {
          ((Transaction)localObject).getRetryRequests().put(Integer.valueOf(this.req.getHwSeq()), this.req);
        }
      }
      BdhLogUtil.LogEvent("R", "conId:" + this.req.sendConnId + " ScheduleRetry : " + this.req.getHwSeq() + " retry:" + this.req.retryCount + " delay:" + paramLong + " hasNet:" + bool + " sentRequestsRetry.size()");
      if (!bool) {
        break label299;
      }
      Object localObject = this.req;
      ((HwRequest)localObject).retryCount += 1;
      this.req.onRetry(paramInt);
      if (paramLong == 0L) {
        break;
      }
      this.this$0.mRequestHandler.postDelayed(new RequestWorker.RequestListener.4(this), paramLong);
      return;
    }
    this.this$0.engine.mConnManager.wakeupConnectionToWrite(this.this$0.mCurrentRequests, false);
    return;
    label299:
    this.this$0.mRequestHandler.postDelayed(this.netDetectTimer, paramLong);
  }
  
  public void handleConnClosed() {}
  
  public void handleError(int paramInt, String paramString, IConnection paramIConnection)
  {
    if (!(this.req instanceof RequestAck)) {
      this.req.onError(paramInt);
    }
    boolean bool1 = true;
    if (HwNetworkCenter.getInstance(this.this$0.engine.getAppContext()).getNetType() != 0L) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      this.this$0.mRequestHandler.removeCallbacks(this.reqTimeoutTimer);
      BdhLogUtil.LogEvent("R", "conId:" + this.req.sendConnId + " HandleError : Seq:" + this.req.getHwSeq() + " ErrCode:" + paramInt + " HasNet:" + bool2);
      if (!this.req.isCancel.get()) {
        break;
      }
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.req.lastSendStartTime;
    Object localObject1 = this.req;
    ((HwRequest)localObject1).timeComsume = (l1 - l2 + ((HwRequest)localObject1).timeComsume);
    int i = paramInt;
    if (paramInt == -1004)
    {
      if (this.req.hwCmd.equalsIgnoreCase("PicUp.DataUp")) {
        paramInt = ((RequestDataTrans)this.req).mInfo.errno;
      }
      bool1 = false;
      i = paramInt;
    }
    Object localObject2;
    label336:
    Object localObject3;
    boolean bool3;
    label469:
    int j;
    if ((bool2) && (i != -1000))
    {
      localObject1 = this.req;
      ((HwRequest)localObject1).continueErrCount += 1;
      if (i == -1003)
      {
        localObject1 = null;
        if (this.req.endpoint != null) {
          localObject1 = this.req.endpoint.host;
        }
        if ((this.req.lastUseAddress != null) && (this.req.lastUseAddress.equalsIgnoreCase((String)localObject1)))
        {
          localObject2 = this.req;
          ((HwRequest)localObject2).continueConnClose += 1;
          this.req.lastUseAddress = ((String)localObject1);
          if (this.req.continueConnClose >= 3)
          {
            BdhLogUtil.LogEvent("C", "ContinueConnClose exceed the ContinueConnClosedLimitation. Host : " + (String)localObject1 + " retryCount:" + this.req.retryCount);
            localObject2 = ConfigManager.getInstance(this.this$0.engine.getAppContext(), this.this$0.engine);
            if (localObject2 != null)
            {
              localObject3 = this.this$0.engine.getAppContext();
              AppRuntime localAppRuntime = this.this$0.engine.app;
              String str = this.this$0.engine.currentUin;
              if (paramIConnection != null) {
                break label781;
              }
              bool3 = false;
              ((ConfigManager)localObject2).onSrvAddrUnavailable((Context)localObject3, localAppRuntime, str, (String)localObject1, 9, bool3);
            }
            localObject1 = this.this$0.engine.mTransWorker.getTransactionById(this.req.transId);
            if (localObject1 != null) {
              ((Transaction)localObject1).onRequestFailed(i);
            }
          }
          label520:
          if (this.req.timeComsume < 600000L) {
            break label817;
          }
          paramInt = 1;
          label536:
          if (this.req.continueErrCount < 10) {
            break label822;
          }
          j = 1;
          label551:
          localObject1 = null;
          if (!(this.req instanceof RequestAck))
          {
            localObject2 = this.this$0.engine.mTransWorker.getTransactionById(this.req.transId);
            if (localObject2 != null)
            {
              localObject3 = ((Transaction)localObject2).mTransReport;
              if (this.req.protoType != 1) {
                break label828;
              }
            }
          }
        }
      }
    }
    label781:
    label817:
    label822:
    label828:
    for (localObject1 = "TCP";; localObject1 = "HTTP")
    {
      ((TransReport)localObject3).protoType = ((String)localObject1);
      if (this.req.endpoint != null)
      {
        ((Transaction)localObject2).mTransReport.ipIndex = this.req.endpoint.ipIndex;
        if (paramIConnection != null) {
          ((Transaction)localObject2).mTransReport.isIpv6 = paramIConnection.isIpv6();
        }
        ((Transaction)localObject2).mTransReport.mHasIpv6List = this.this$0.engine.mConnManager.mHasIpv6List;
        ((Transaction)localObject2).mTransReport.mIPv6Fast = this.this$0.engine.mConnManager.isIpv6Fast();
      }
      localObject1 = localObject2;
      if ((!bool1) || (paramInt != 0) || (j != 0)) {
        break label836;
      }
      l1 = 0L;
      if (!bool2) {
        l1 = 6000L;
      }
      if ((this.req instanceof RequestHeartBreak)) {
        break;
      }
      RequestWorker.access$100(this.this$0, this.req);
      scheduleRetry(i, l1);
      return;
      this.req.continueConnClose = 1;
      break label336;
      bool3 = paramIConnection.isIpv6();
      break label469;
      if (i == -1014)
      {
        bool1 = false;
        break label520;
        this.req.continueConnClose = 0;
      }
      break label520;
      paramInt = 0;
      break label536;
      j = 0;
      break label551;
    }
    label836:
    BdhLogUtil.LogEvent("R", "HandleError : Seq:" + this.req.getHwSeq() + " NotifyError :" + i + "req.timeComsume:" + this.req.timeComsume + " allowRetry:" + bool1 + " req.continueErrCount:" + this.req.continueErrCount);
    this.req.onError(i);
    if (localObject1 != null)
    {
      paramIConnection = new HwResponse();
      paramIConnection.hwSeq = this.req.getHwSeq();
      paramIConnection.errCode = i;
      if (paramInt != 0) {
        paramIConnection.errCode = -1005;
      }
      ((Transaction)localObject1).onTransFailed(paramIConnection.errCode, paramString, 0, 0, this.req.retryCount, null);
    }
    RequestWorker.access$300(this.this$0).remove(Integer.valueOf(this.req.getHwSeq()));
  }
  
  public void handleResponse(HwResponse paramHwResponse)
  {
    Object localObject = this.this$0.mRequestHandler;
    long l1 = paramHwResponse.recvTime - this.req.sendTime;
    long l2 = SystemClock.uptimeMillis();
    long l3 = paramHwResponse.recvTime;
    if ((this.req instanceof RequestDataTrans)) {
      recordConnInfo(this.req, l1);
    }
    paramHwResponse.reqCost = l1;
    paramHwResponse.switchCost = (l2 - l3);
    paramHwResponse.mBuCmdId = this.req.mBuCmdId;
    paramHwResponse.mTransId = this.req.transId;
    if (localObject != null) {
      ((RequestWorker.RequestHandler)localObject).removeCallbacks(this.reqTimeoutTimer);
    }
    BdhLogUtil.LogEvent("R", "HandleResp :" + paramHwResponse.dumpRespInfo() + " ,isCancle:" + this.req.isCancel);
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
      this.req.sendConnId = paramInt;
      this.req.lastSendStartTime = SystemClock.uptimeMillis();
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
    if ((this.req instanceof RequestDataTrans))
    {
      localObject = ((RequestDataTrans)this.req).mInfo.parent;
      if (localObject != null)
      {
        localAtomicInteger = (AtomicInteger)((Transaction)localObject).mTransReport.mDataFlowOfChannel.get(Integer.valueOf(paramInt1));
        if (localAtomicInteger == null) {
          break label112;
        }
        localAtomicInteger.incrementAndGet();
      }
    }
    return;
    label112:
    AtomicInteger localAtomicInteger = new AtomicInteger(1);
    ((Transaction)localObject).mTransReport.mDataFlowOfChannel.put(Integer.valueOf(paramInt1), localAtomicInteger);
  }
  
  public void handleSendTimeOut()
  {
    if (this.req.isCancel.get())
    {
      RequestWorker.access$300(this.this$0).remove(Integer.valueOf(this.req.getHwSeq()));
      return;
    }
    BdhLogUtil.LogEvent("R", "conId:" + this.req.sendConnId + " handleSendTimeOut->req.hwSeq:" + this.req.getHwSeq());
    this.req.onError(-1005);
    int i = this.req.sendConnId;
    Object localObject1;
    if ((this.req instanceof RequestHeartBreak))
    {
      localObject1 = (RequestHeartBreak)this.req;
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
    if ((RequestWorker.access$500(this.this$0).get(Integer.valueOf(i)) != null) && (!((HwRequest)RequestWorker.access$500(this.this$0).get(Integer.valueOf(i))).isCancel.get()) && (((HwRequest)RequestWorker.access$500(this.this$0).get(Integer.valueOf(i))).status.get() != 4)) {
      BdhLogUtil.LogEvent("R", "conId:" + i + " handleSendTimeOut->there has been a HB sending !");
    }
    for (;;)
    {
      localObject1 = this.req;
      ((HwRequest)localObject1).timeOut += 15000L;
      localObject1 = this.req;
      ((HwRequest)localObject1).timeOutCount += 1;
      handleError(-1005, "ReqTimeOut", (IConnection)this.this$0.engine.mConnManager.connections.get(Integer.valueOf(i)));
      return;
      this.this$0.sendHeartBreak(i, true, true, 0);
    }
  }
  
  public void handleWriteTimeout()
  {
    if (this.req.isCancel.get())
    {
      RequestWorker.access$300(this.this$0).remove(Integer.valueOf(this.req.getHwSeq()));
      return;
    }
    BdhLogUtil.LogEvent("R", "conId:" + this.req.sendConnId + " handleWriteTimeout->req.hwSeq:" + this.req.getHwSeq());
    this.req.onError(-1006);
    this.this$0.engine.mConnManager.onRequestWriteTimeout(this.req.sendConnId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestWorker.RequestListener
 * JD-Core Version:    0.7.0.1
 */