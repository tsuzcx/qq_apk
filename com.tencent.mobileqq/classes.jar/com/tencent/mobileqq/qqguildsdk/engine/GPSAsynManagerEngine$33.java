package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.manager.GuildListMgr;

class GPSAsynManagerEngine$33
  implements IResultWithSecurityCallback
{
  GPSAsynManagerEngine$33(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt == 0) && (this.d.a(paramIGProSecurityResult)))
    {
      this.d.b().b(this.a, this.b);
      this.d.a(4, "setGuildProfile", this.a);
    }
    this.c.a(paramInt, paramString, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.33
 * JD-Core Version:    0.7.0.1
 */