package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$63$1
  implements Runnable
{
  GProSdkWrapperImpl$63$1(GProSdkWrapperImpl.63 param63, int paramInt, String paramString, GProSecurityResult paramGProSecurityResult) {}
  
  public void run()
  {
    GProLog.b("GProSdkWrapperImpl", true, "sdkWrapper callback", "on clearNoticeRedPoint", "", this.a, this.b, GProSdkWrapperImpl.a(this.d.c, this.c), this.d.a);
    this.d.b.onResult(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.63.1
 * JD-Core Version:    0.7.0.1
 */