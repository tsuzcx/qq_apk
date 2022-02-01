package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchIsLiveChannelOpenCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$73$1
  implements Runnable
{
  GProSdkWrapperImpl$73$1(GProSdkWrapperImpl.73 param73, int paramInt1, String paramString, int paramInt2) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchIsLiveChannelOpen", "", i, str, str, this.d.a);
    this.d.b.a(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.73.1
 * JD-Core Version:    0.7.0.1
 */