package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

class GPSAsynManagerEngine$19
  implements IResultWithSecurityCallback
{
  GPSAsynManagerEngine$19(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString1, String paramString2, boolean paramBoolean, IResultWithSecurityCallback paramIResultWithSecurityCallback) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (paramInt == 0) {
      this.e.a(13, "setGuildAdmin", this.a, this.b, Boolean.valueOf(this.c));
    }
    this.d.a(paramInt, paramString, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.19
 * JD-Core Version:    0.7.0.1
 */