package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

class GPSAsynManagerEngine$5
  implements IResultWithSecurityCallback
{
  GPSAsynManagerEngine$5(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString, IResultWithSecurityCallback paramIResultWithSecurityCallback) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt == 0) && (this.c.a(paramIGProSecurityResult)))
    {
      this.c.d(this.a, true);
      this.c.a(9, "removeGuild", this.a);
    }
    this.b.a(paramInt, paramString, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.5
 * JD-Core Version:    0.7.0.1
 */