package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveChannelAnchorListCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;

class GProSdkWrapperImpl$65$1
  implements Runnable
{
  GProSdkWrapperImpl$65$1(GProSdkWrapperImpl.65 param65, int paramInt, String paramString, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchLiveChannelAnchorList", "", i, str, str, this.d.a);
    this.d.b.a(this.a, this.b, GProConvert.b(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.65.1
 * JD-Core Version:    0.7.0.1
 */