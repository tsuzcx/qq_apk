package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.manager.UserListMgr;

class GPSAsynManagerEngine$32
  implements IResultWithSecurityCallback
{
  GPSAsynManagerEngine$32(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (paramInt == 0) {
      this.d.e().c(this.a, this.b);
    }
    this.c.a(paramInt, paramString, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.32
 * JD-Core Version:    0.7.0.1
 */