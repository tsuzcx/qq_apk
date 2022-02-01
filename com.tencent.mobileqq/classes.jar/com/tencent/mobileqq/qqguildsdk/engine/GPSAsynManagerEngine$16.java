package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.manager.ChannelListMgr;

class GPSAsynManagerEngine$16
  implements IResultWithSecurityCallback
{
  GPSAsynManagerEngine$16(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString, int paramInt, IResultWithSecurityCallback paramIResultWithSecurityCallback) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt == 0) && (this.d.a(paramIGProSecurityResult))) {
      this.d.d().g(this.a, this.b);
    }
    this.c.a(paramInt, paramString, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.16
 * JD-Core Version:    0.7.0.1
 */