package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProEnterChannelPermission;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchEnterChannelPermissionCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$66$1
  implements Runnable
{
  GProSdkWrapperImpl$66$1(GProSdkWrapperImpl.66 param66, int paramInt, String paramString, GProEnterChannelPermission paramGProEnterChannelPermission) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchEnterChannelPermission", "", i, str, str, this.d.a);
    this.d.b.a(this.a, this.b, GProConvert.a(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.66.1
 * JD-Core Version:    0.7.0.1
 */