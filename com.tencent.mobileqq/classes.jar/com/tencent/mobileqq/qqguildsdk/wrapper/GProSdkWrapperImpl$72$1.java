package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.ICheckSelfRealNameVerifiedCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$72$1
  implements Runnable
{
  GProSdkWrapperImpl$72$1(GProSdkWrapperImpl.72 param72, int paramInt, String paramString1, String paramString2, long paramLong, String paramString3) {}
  
  public void run()
  {
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "checkSelfRealNameVerified", "", this.a, this.b, this.c, this.f.a);
    this.f.b.a(this.a, this.b, this.d, this.c, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.72.1
 * JD-Core Version:    0.7.0.1
 */