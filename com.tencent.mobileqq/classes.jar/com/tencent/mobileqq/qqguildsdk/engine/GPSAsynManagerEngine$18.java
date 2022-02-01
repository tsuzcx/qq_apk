package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

class GPSAsynManagerEngine$18
  implements ISetGuildInfoCallback
{
  GPSAsynManagerEngine$18(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString1, String paramString2, ISetGuildInfoCallback paramISetGuildInfoCallback) {}
  
  public void a(int paramInt, IGProGuildInfo paramIGProGuildInfo, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    IGProGuildInfo localIGProGuildInfo = paramIGProGuildInfo;
    if (paramInt == 0)
    {
      localIGProGuildInfo = paramIGProGuildInfo;
      if (this.d.a(paramIGProSecurityResult))
      {
        localIGProGuildInfo = this.d.d(this.a, this.b);
        this.d.a(4, "setGuildName", this.a);
      }
    }
    this.c.a(paramInt, localIGProGuildInfo, paramString, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.18
 * JD-Core Version:    0.7.0.1
 */