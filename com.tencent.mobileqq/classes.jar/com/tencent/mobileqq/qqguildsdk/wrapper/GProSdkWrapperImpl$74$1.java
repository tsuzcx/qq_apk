package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveSecurityTipsCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$74$1
  implements Runnable
{
  GProSdkWrapperImpl$74$1(GProSdkWrapperImpl.74 param74, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchLiveSecurityTips", "", this.a, this.b, this.c, this.d.a);
    this.d.b.a(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.74.1
 * JD-Core Version:    0.7.0.1
 */