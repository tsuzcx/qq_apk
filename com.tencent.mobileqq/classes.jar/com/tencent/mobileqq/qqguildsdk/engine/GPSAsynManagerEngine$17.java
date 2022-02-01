package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

class GPSAsynManagerEngine$17
  implements IResultWithSecurityCallback
{
  GPSAsynManagerEngine$17(GPSAsynManagerEngine paramGPSAsynManagerEngine, IResultWithSecurityCallback paramIResultWithSecurityCallback) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (paramInt == 0) {
      this.b.a(paramIGProSecurityResult);
    }
    this.a.a(paramInt, paramString, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.17
 * JD-Core Version:    0.7.0.1
 */