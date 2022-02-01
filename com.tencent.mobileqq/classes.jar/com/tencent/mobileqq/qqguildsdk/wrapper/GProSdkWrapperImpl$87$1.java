package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildClientIdCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$87$1
  implements Runnable
{
  GProSdkWrapperImpl$87$1(GProSdkWrapperImpl.87 param87, int paramInt1, String paramString, long paramLong, int paramInt2) {}
  
  public void run()
  {
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildClientId", "", this.a, this.b, "", this.e.a);
    this.e.b.a(this.a, this.b, GProConvert.a(this.c), GProConvert.a(this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.87.1
 * JD-Core Version:    0.7.0.1
 */