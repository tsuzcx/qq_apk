package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildTopCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;

class GPSAsynManagerEngine$10
  implements ISetGuildTopCallback
{
  GPSAsynManagerEngine$10(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString, boolean paramBoolean, ISetGuildTopCallback paramISetGuildTopCallback) {}
  
  public void a(int paramInt, IGProGuildInfo paramIGProGuildInfo, String paramString)
  {
    if (paramInt == 0)
    {
      paramIGProGuildInfo = this.d.e(this.a, this.b);
      this.d.a(4, "setGuildTop", this.a);
    }
    this.c.a(paramInt, paramIGProGuildInfo, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.10
 * JD-Core Version:    0.7.0.1
 */