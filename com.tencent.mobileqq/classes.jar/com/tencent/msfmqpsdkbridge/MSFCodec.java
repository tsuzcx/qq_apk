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
  private String mCmd = null;
  
  public MSFCodec(String paramString)
  {
    this.mCmd = paramString;
  }
  
  public Object decode(Object paramObject)
  {
    return ((FromServiceMsg)paramObject).getWupBuffer();
  }
  
  public Object encode(Object paramObject)
  {
    if (paramObject != null)
    {
      if (TextUtils.isEmpty(this.mCmd)) {
        return null;
      }
      Object localObject = MobileQQ.getMobileQQ().waitAppRuntime(null);
      if (localObject != null) {
        localObject = ((AppRuntime)localObject).getAccount();
      } else {
        localObject = "";
      }
      localObject = new ToServiceMsg("mobileqq.service", (String)localObject, this.mCmd);
      ((ToServiceMsg)localObject).putWupBuffer((byte[])paramObject);
      return localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msfmqpsdkbridge.MSFCodec
 * JD-Core Version:    0.7.0.1
 */