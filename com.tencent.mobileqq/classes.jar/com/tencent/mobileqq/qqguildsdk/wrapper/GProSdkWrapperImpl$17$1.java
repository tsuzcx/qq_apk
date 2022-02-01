package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelNameCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$17$1
  implements Runnable
{
  GProSdkWrapperImpl$17$1(GProSdkWrapperImpl.17 param17, int paramInt, String paramString, GProSecurityResult paramGProSecurityResult) {}
  
  public void run()
  {
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelName", "ui", this.a, this.b, GProSdkWrapperImpl.a(this.d.c, this.c), this.d.a);
    this.d.b.a(this.a, null, this.b, GProSdkWrapperImpl.b(this.d.c, this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.17.1
 * JD-Core Version:    0.7.0.1
 */