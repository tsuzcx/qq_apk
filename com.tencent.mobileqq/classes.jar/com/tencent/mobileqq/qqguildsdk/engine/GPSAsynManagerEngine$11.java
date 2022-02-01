package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelTalkPermissionCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

class GPSAsynManagerEngine$11
  implements ISetChannelTalkPermissionCallback
{
  GPSAsynManagerEngine$11(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString, int paramInt, ISetChannelTalkPermissionCallback paramISetChannelTalkPermissionCallback) {}
  
  public void a(int paramInt, IGProChannelInfo paramIGProChannelInfo, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    IGProChannelInfo localIGProChannelInfo = paramIGProChannelInfo;
    if (paramInt == 0)
    {
      localIGProChannelInfo = paramIGProChannelInfo;
      if (this.d.a(paramIGProSecurityResult)) {
        localIGProChannelInfo = this.d.b(this.a, this.b);
      }
    }
    this.c.a(paramInt, localIGProChannelInfo, paramString, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.11
 * JD-Core Version:    0.7.0.1
 */