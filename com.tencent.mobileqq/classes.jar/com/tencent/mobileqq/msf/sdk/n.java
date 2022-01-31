package com.tencent.mobileqq.msf.sdk;

import android.os.Handler;
import com.tencent.mobileqq.msf.sdk.report.c;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker.Stub;
import com.tencent.qphone.base.remote.ServiceMsgWrapper;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class n
  extends IMsfServiceCallbacker.Stub
{
  n(l paraml) {}
  
  public boolean isBinderAlive()
  {
    QLog.i("MSF.D.Proxy", 1, "isBinderAlive");
    return super.isBinderAlive();
  }
  
  public void onReceivePushResp(FromServiceMsg paramFromServiceMsg)
  {
    l.a(this.a, paramFromServiceMsg);
    c.a().onRecvServicePushResp(paramFromServiceMsg);
  }
  
  public void onResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    l.a(this.a, paramToServiceMsg, paramFromServiceMsg);
    c.a().onReceiveResp(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onSyncReceivePushResp(FromServiceMsg paramFromServiceMsg, int paramInt1, int paramInt2, int paramInt3)
  {
    Integer localInteger = Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq());
    ServiceMsgWrapper localServiceMsgWrapper = (ServiceMsgWrapper)l.c(this.a).get(localInteger);
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
      QLog.d("MSF.D.Proxy", 2, bool);
      localObject = localServiceMsgWrapper;
      if (localServiceMsgWrapper == null)
      {
        localObject = new ServiceMsgWrapper(null, paramFromServiceMsg, paramInt3);
        l.c(this.a).put(localInteger, localObject);
        l.b(this.a).postDelayed(new j(l.c(this.a), localInteger.intValue()), 20000L);
      }
      ((ServiceMsgWrapper)localObject).buildFromMsgWupBuffer(paramFromServiceMsg.getWupBuffer(), paramInt1);
      if (((ServiceMsgWrapper)localObject).isFinishTransported())
      {
        l.a(this.a, ((ServiceMsgWrapper)localObject).getFromServiceMsg());
        c.a().onRecvServicePushResp(paramFromServiceMsg);
        l.c(this.a).remove(localInteger);
      }
      return;
    }
  }
  
  public void onSyncResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt1, int paramInt2, int paramInt3)
  {
    Integer localInteger = Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq());
    ServiceMsgWrapper localServiceMsgWrapper = (ServiceMsgWrapper)l.a(this.a).get(localInteger);
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
      QLog.d("MSF.D.Proxy", 2, bool);
      localObject = localServiceMsgWrapper;
      if (localServiceMsgWrapper == null)
      {
        localObject = new ServiceMsgWrapper(paramToServiceMsg, paramFromServiceMsg, paramInt3);
        l.a(this.a).put(localInteger, localObject);
        l.b(this.a).postDelayed(new j(l.a(this.a), localInteger.intValue()), 20000L);
      }
      ((ServiceMsgWrapper)localObject).buildFromMsgWupBuffer(paramFromServiceMsg.getWupBuffer(), paramInt1);
      if (((ServiceMsgWrapper)localObject).isFinishTransported())
      {
        l.a(this.a, ((ServiceMsgWrapper)localObject).getToServiceMsg(), ((ServiceMsgWrapper)localObject).getFromServiceMsg());
        c.a().onReceiveResp(paramToServiceMsg, paramFromServiceMsg);
        l.a(this.a).remove(localInteger);
      }
      return;
    }
  }
  
  public boolean pingBinder()
  {
    QLog.i("MSF.D.Proxy", 1, "pingBinder");
    return super.pingBinder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.n
 * JD-Core Version:    0.7.0.1
 */