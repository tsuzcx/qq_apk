package com.tencent.msfmqpsdkbridge;

import android.text.TextUtils;
import com.tencent.mqpsdk.INetTransportProvider.INetTransportCodec;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MSFCodec
  implements INetTransportProvider.INetTransportCodec
{
  private String a;
  
  public MSFCodec(String paramString)
  {
    this.a = paramString;
  }
  
  public Object a(Object paramObject)
  {
    if ((paramObject == null) || (TextUtils.isEmpty(this.a))) {
      return null;
    }
    Object localObject = "";
    AppRuntime localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
    if (localAppRuntime != null) {
      localObject = localAppRuntime.getAccount();
    }
    localObject = new ToServiceMsg("mobileqq.service", (String)localObject, this.a);
    ((ToServiceMsg)localObject).putWupBuffer((byte[])paramObject);
    return localObject;
  }
  
  public Object b(Object paramObject)
  {
    return ((FromServiceMsg)paramObject).getWupBuffer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.msfmqpsdkbridge.MSFCodec
 * JD-Core Version:    0.7.0.1
 */