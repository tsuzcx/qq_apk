package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelNameCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

class GPSAsynManagerEngine$13
  implements ISetChannelNameCallback
{
  GPSAsynManagerEngine$13(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString1, String paramString2, ISetChannelNameCallback paramISetChannelNameCallback) {}
  
  public void a(int paramInt, IGProChannelInfo paramIGProChannelInfo, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    IGProChannelInfo localIGProChannelInfo = paramIGProChannelInfo;
    if (paramInt == 0)
    {
      localIGProChannelInfo = paramIGProChannelInfo;
      if (this.d.a(paramIGProSecurityResult))
      {
        localIGProChannelInfo = this.d.e(this.a, this.b);
        this.d.a(5, "setChannelName", this.a);
      }
    }
    this.c.a(paramInt, localIGProChannelInfo, paramString, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.13
 * JD-Core Version:    0.7.0.1
 */