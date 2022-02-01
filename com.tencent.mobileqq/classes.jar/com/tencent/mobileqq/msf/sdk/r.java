package com.tencent.mobileqq.msf.sdk;

import android.os.Handler;
import com.tencent.mobileqq.msf.sdk.b.c;
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
  
  public void onFirstPkgResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramFromServiceMsg.getRequestSsoSeq();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("receive first res package, , thread id = ");
      localStringBuilder.append(Thread.currentThread().getId());
      localStringBuilder.append(", ssoSeq = ");
      localStringBuilder.append(i);
      localStringBuilder.append(", index = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", length = ");
      localStringBuilder.append(paramFromServiceMsg.getWupBuffer().length);
      localStringBuilder.append(", packageLength = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", totalLength = ");
      localStringBuilder.append(paramInt3);
      QLog.d("MSF.D.ProxyNew", 2, localStringBuilder.toString());
    }
    paramToServiceMsg = new ServiceMsgWrapper(paramToServiceMsg, paramFromServiceMsg, paramInt3);
    paramToServiceMsg.buildFromMsgWupBuffer(paramInt1, paramFromServiceMsg.getWupBuffer());
    q.a(this.a).put(Integer.valueOf(i), paramToServiceMsg);
    q.b(this.a).postDelayed(new j(q.a(this.a), i), 20000L);
  }
  
  public void onNextPkgResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Integer localInteger = Integer.valueOf(paramInt1);
    ServiceMsgWrapper localServiceMsgWrapper = (ServiceMsgWrapper)q.a(this.a).get(localInteger);
    if ((QLog.isColorLevel()) || (localServiceMsgWrapper == null))
    {
      boolean bool = true;
      if (localServiceMsgWrapper == null) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("receive next res package, , thread id = ");
      localStringBuilder.append(Thread.currentThread().getId());
      localStringBuilder.append(", ssoSeq = ");
      localStringBuilder.append(localInteger);
      localStringBuilder.append(", index = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", length = ");
      localStringBuilder.append(paramArrayOfByte.length);
      localStringBuilder.append(", resServiceMsgWrapper = null ");
      if (localServiceMsgWrapper != null) {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("MSF.D.ProxyNew", paramInt1, localStringBuilder.toString());
    }
    if (localServiceMsgWrapper != null)
    {
      localServiceMsgWrapper.buildFromMsgWupBuffer(paramInt2, paramArrayOfByte);
      if (localServiceMsgWrapper.isFinishTransported())
      {
        q.a(this.a, localServiceMsgWrapper.getToServiceMsg(), localServiceMsgWrapper.getFromServiceMsg());
        c.a().onReceiveResp(localServiceMsgWrapper.getToServiceMsg(), localServiceMsgWrapper.getFromServiceMsg());
        q.a(this.a).remove(localInteger);
      }
    }
  }
  
  public void onReceiveFirstPkgPushResp(FromServiceMsg paramFromServiceMsg, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramFromServiceMsg.getRequestSsoSeq();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("receive first push package, , thread id = ");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      ((StringBuilder)localObject).append(", ssoSeq = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", index = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", length = ");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getWupBuffer().length);
      ((StringBuilder)localObject).append(", packageLength = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", totalLength = ");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.d("MSF.D.ProxyNew", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ServiceMsgWrapper(null, paramFromServiceMsg, paramInt3);
    ((ServiceMsgWrapper)localObject).buildFromMsgWupBuffer(paramInt1, paramFromServiceMsg.getWupBuffer());
    q.c(this.a).put(Integer.valueOf(i), localObject);
    q.b(this.a).postDelayed(new j(q.c(this.a), i), 20000L);
  }
  
  public void onReceiveNextPkgPushResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Integer localInteger = Integer.valueOf(paramInt1);
    ServiceMsgWrapper localServiceMsgWrapper = (ServiceMsgWrapper)q.c(this.a).get(localInteger);
    if ((QLog.isColorLevel()) || (localServiceMsgWrapper == null))
    {
      boolean bool = true;
      if (localServiceMsgWrapper == null) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("receive next push package, , thread id = ");
      localStringBuilder.append(Thread.currentThread().getId());
      localStringBuilder.append(", ssoSeq = ");
      localStringBuilder.append(localInteger);
      localStringBuilder.append(", index = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", length = ");
      localStringBuilder.append(paramArrayOfByte.length);
      localStringBuilder.append(", resServiceMsgWrapper = null ");
      if (localServiceMsgWrapper != null) {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("MSF.D.ProxyNew", paramInt1, localStringBuilder.toString());
    }
    if (localServiceMsgWrapper != null)
    {
      localServiceMsgWrapper.buildFromMsgWupBuffer(paramInt2, paramArrayOfByte);
      if (localServiceMsgWrapper.isFinishTransported())
      {
        q.a(this.a, localServiceMsgWrapper.getFromServiceMsg());
        c.a().onRecvServicePushResp(localServiceMsgWrapper.getFromServiceMsg());
        q.c(this.a).remove(localInteger);
      }
    }
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
  
  public boolean pingBinder()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.ProxyNew", 2, "pingBinder");
    }
    return super.pingBinder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.r
 * JD-Core Version:    0.7.0.1
 */