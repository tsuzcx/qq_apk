package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.ISwitchPresenceArchiveCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$85$1
  implements Runnable
{
  GProSdkWrapperImpl$85$1(GProSdkWrapperImpl.85 param85, int paramInt1, String paramString, int paramInt2) {}
  
  public void run()
  {
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "setShowPresence", "", this.a, this.b, "", this.d.a);
    this.d.b.a(GProConvert.a(this.c), this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.85.1
 * JD-Core Version:    0.7.0.1
 */