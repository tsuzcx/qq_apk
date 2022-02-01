package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel;

import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.utils.ThreadCenter;

class CsTaskImpl$1
  implements ChannelCallback
{
  CsTaskImpl$1(CsTaskImpl paramCsTaskImpl, byte[] paramArrayOfByte) {}
  
  public void onError(boolean paramBoolean, int paramInt, String paramString)
  {
    ThreadCenter.clear(this.b);
    if (CsTaskImpl.b(this.b) > 0)
    {
      this.b.send(this.a);
      return;
    }
    if (CsTaskImpl.a(this.b) != null) {
      CsTaskImpl.a(this.b).onError(paramBoolean, paramInt, paramString);
    }
    CsTaskImpl.a(this.b, null);
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    ThreadCenter.clear(this.b);
    if (CsTaskImpl.a(this.b) != null) {
      CsTaskImpl.a(this.b).onRecv(paramArrayOfByte);
    }
    CsTaskImpl.a(this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel.CsTaskImpl.1
 * JD-Core Version:    0.7.0.1
 */