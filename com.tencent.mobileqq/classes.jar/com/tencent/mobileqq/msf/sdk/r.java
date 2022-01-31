package com.tencent.mobileqq.msf.sdk;

import android.os.Handler;
import com.tencent.mobileqq.msf.sdk.report.c;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker.Stub;
import com.tencent.qphone.base.remote.ServiceMsgWrapper;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class r
  extends IMsfServiceCallbacker.Stub
{
  r(q paramq) {}
  
  public boolean isBinderAlive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.ProxyNew", 2, "isBinderAlive");
    }
    return super.isBinderAlive();
  }
  
  public void onReceivePushResp(FromServiceMsg paramFromServiceMsg)
  {
    q.a(this.a, paramFromServiceMsg);
    c.a().onRecvServicePushResp(paramFromServiceMsg);
  }
  
  public void onResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    q.a(this.a, paramToServiceMsg, paramFromServiceMsg);
    c.a().onReceiveResp(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onSyncReceivePushResp(FromServiceMsg paramFromServiceMsg, int paramInt1, int paramInt2, int paramInt3)
  {
    Integer localInteger = Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq());
    ServiceMsgWrapper localServiceMsgWrapper = (ServiceMsgWrapper)q.c(this.a).get(localInteger);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("receive push package, , thread id = ").append(Thread.currentThread().getId()).append(", ssoSeq = ").append(localInteger).append(", index = ").append(paramInt1).append(", length = ").append(paramFromServiceMsg.getWupBuffer().length).append(", packageLength = ").append(paramInt2).append(", totalLength = ").append(paramInt3).append(", resServiceMsgWrapper = null ");
      if (localServiceMsgWrapper != null) {
        break label257;
      }
    }
    label257:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("MSF.D.ProxyNew", 2, bool);
      localObject = localServiceMsgWrapper;
      if (localServiceMsgWrapper == null)
      {
        localObject = new ServiceMsgWrapper(null, paramFromServiceMsg, paramInt3);
        q.c(this.a).put(localInteger, localObject);
        q.b(this.a).postDelayed(new j(q.c(this.a), localInteger.intValue()), 20000L);
      }
      ((ServiceMsgWrapper)localObject).buildFromMsgWupBuffer(paramFromServiceMsg.getWupBuffer(), paramInt1);
      if (((ServiceMsgWrapper)localObject).isFinishTransported())
      {
        q.a(this.a, ((ServiceMsgWrapper)localObject).getFromServiceMsg());
        c.a().onRecvServicePushResp(paramFromServiceMsg);
        q.c(this.a).remove(localInteger);
      }
      return;
    }
  }
  
  public void onSyncResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt1, int paramInt2, int paramInt3)
  {
    Integer localInteger = Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq());
    ServiceMsgWrapper localServiceMsgWrapper = (ServiceMsgWrapper)q.a(this.a).get(localInteger);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("receive res package, , thread id = ").append(Thread.currentThread().getId()).append(", ssoSeq = ").append(localInteger).append(", index = ").append(paramInt1).append(", length = ").append(paramFromServiceMsg.getWupBuffer().length).append(", packageLength = ").append(paramInt2).append(", totalLength = ").append(paramInt3).append(", resServiceMsgWrapper = null ");
      if (localServiceMsgWrapper != null) {
        break label264;
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("MSF.D.ProxyNew", 2, bool);
      localObject = localServiceMsgWrapper;
      if (localServiceMsgWrapper == null)
      {
        localObject = new ServiceMsgWrapper(paramToServiceMsg, paramFromServiceMsg, paramInt3);
        q.a(this.a).put(localInteger, localObject);
        q.b(this.a).postDelayed(new j(q.a(this.a), localInteger.intValue()), 20000L);
      }
      ((ServiceMsgWrapper)localObject).buildFromMsgWupBuffer(paramFromServiceMsg.getWupBuffer(), paramInt1);
      if (((ServiceMsgWrapper)localObject).isFinishTransported())
      {
        q.a(this.a, ((ServiceMsgWrapper)localObject).getToServiceMsg(), ((ServiceMsgWrapper)localObject).getFromServiceMsg());
        c.a().onReceiveResp(paramToServiceMsg, paramFromServiceMsg);
        q.a(this.a).remove(localInteger);
      }
      return;
    }
  }
  
  public boolean pingBinder()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.ProxyNew", 2, "pingBinder");
    }
    return super.pingBinder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.r
 * JD-Core Version:    0.7.0.1
 */