package com.tencent.mobileqq.weiyun.channel;

import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.MsgHead;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.utils.Singleton;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public final class WySender
{
  private static Singleton<WySender, Void> d = new WySender.1();
  private AtomicInteger a = new AtomicInteger(0);
  private ConcurrentHashMap<Integer, WySender.ICallback> b = new ConcurrentHashMap();
  private long c = 1L;
  
  public static WySender a()
  {
    return (WySender)d.get(null);
  }
  
  private void a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendRequestInner : seq[");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("], cmd[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("]");
        QLog.d("WySender", 1, ((StringBuilder)localObject).toString());
      }
      Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      int i;
      if (paramString.contains("."))
      {
        String[] arrayOfString = paramString.split("\\.");
        i = Integer.parseInt(arrayOfString[(arrayOfString.length - 1)]);
      }
      else
      {
        i = Integer.parseInt(paramString);
      }
      paramArrayOfByte = new PBPackage(i, paramArrayOfByte);
      paramString = new ToServiceMsg("mobileqq.service", ((AppRuntime)localObject).getAccount(), paramString);
      paramString.setTimeout(Math.min(60000L, (Math.pow(this.c, 0.15D) * 30000.0D)));
      paramString.setEnableFastResend(true);
      paramString.putWupBuffer(PBSerialization.a(paramArrayOfByte));
      paramString.extraData.putInt("sequence", paramInt);
      paramString.extraData.putLong("sendtimekey", System.currentTimeMillis());
      paramArrayOfByte = new NewIntent(((AppRuntime)localObject).getApplication(), WyServlet.class);
      paramArrayOfByte.putExtra(ToServiceMsg.class.getSimpleName(), paramString);
      ((AppRuntime)localObject).startServlet(paramArrayOfByte);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("sendRequestInner : seq[");
    paramString.append(paramInt);
    paramString.append("], cmd is empty");
    QLog.e("WySender", 1, paramString.toString());
  }
  
  void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int m = paramToServiceMsg.extraData.getInt("sequence");
    int i;
    if (paramFromServiceMsg.isSuccess()) {
      i = 0;
    } else {
      i = paramFromServiceMsg.getResultCode();
    }
    if (i == 1002) {
      this.c += 1L;
    } else {
      this.c = 1L;
    }
    Object localObject1 = null;
    PBPackage localPBPackage;
    if (i == 0) {
      localPBPackage = PBSerialization.a(paramFromServiceMsg.getWupBuffer());
    } else {
      localPBPackage = null;
    }
    paramFromServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
    paramToServiceMsg = paramFromServiceMsg;
    if (i == 1002)
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("(1002)");
      paramToServiceMsg.append(paramFromServiceMsg);
      paramToServiceMsg = paramToServiceMsg.toString();
    }
    int j = i;
    paramFromServiceMsg = paramToServiceMsg;
    if (i == 0) {
      if (localPBPackage == null)
      {
        j = 1810023;
        paramFromServiceMsg = paramToServiceMsg;
      }
      else
      {
        localObject2 = localPBPackage.b();
        int k = ((WeiyunPB.MsgHead)localObject2).retcode.get();
        j = i;
        paramFromServiceMsg = paramToServiceMsg;
        if (k != 0)
        {
          paramFromServiceMsg = ((WeiyunPB.MsgHead)localObject2).retmsg.get();
          j = k;
        }
      }
    }
    Object localObject2 = (WySender.ICallback)this.b.remove(Integer.valueOf(m));
    if (localObject2 != null)
    {
      if (localPBPackage == null) {
        paramToServiceMsg = localObject1;
      } else {
        paramToServiceMsg = localPBPackage.c();
      }
      ((WySender.ICallback)localObject2).a(j, paramFromServiceMsg, paramToServiceMsg);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, WySender.ICallback paramICallback)
  {
    int i = this.a.incrementAndGet();
    if (paramICallback != null) {
      this.b.put(Integer.valueOf(i), paramICallback);
    }
    a(i, paramString, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.channel.WySender
 * JD-Core Version:    0.7.0.1
 */