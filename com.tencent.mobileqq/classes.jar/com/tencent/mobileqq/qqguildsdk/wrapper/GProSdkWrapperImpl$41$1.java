package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$41$1
  implements Runnable
{
  GProSdkWrapperImpl$41$1(GProSdkWrapperImpl.41 param41, int paramInt, String paramString, GProSecurityResult paramGProSecurityResult) {}
  
  public void run()
  {
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "setAudioChannelUserLimit", "", this.a, this.b, GProSdkWrapperImpl.a(this.d.c, this.c), this.d.a);
    this.d.b.a(this.a, this.b, GProSdkWrapperImpl.b(this.d.c, this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.41.1
 * JD-Core Version:    0.7.0.1
 */