package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;

class GPSAsynManagerEngine$6
  implements IResultCallback
{
  GPSAsynManagerEngine$6(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString, IResultCallback paramIResultCallback) {}
  
  public void onResult(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.c.i(this.a);
      this.c.a(11, "destroyGuild", this.a);
    }
    this.b.onResult(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.6
 * JD-Core Version:    0.7.0.1
 */