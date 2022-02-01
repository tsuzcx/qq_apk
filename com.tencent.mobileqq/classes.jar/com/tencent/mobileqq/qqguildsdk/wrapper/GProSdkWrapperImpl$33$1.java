package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProEnterChannleInfoResult;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.callback.IEnterAudioChannelCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$33$1
  implements Runnable
{
  GProSdkWrapperImpl$33$1(GProSdkWrapperImpl.33 param33, int paramInt, String paramString, GProSecurityResult paramGProSecurityResult, GProEnterChannleInfoResult paramGProEnterChannleInfoResult) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId ：");
    localStringBuilder.append(this.e.a);
    localStringBuilder.append(", channelId: ");
    localStringBuilder.append(this.e.b);
    localStringBuilder.append(GProSdkWrapperImpl.a(this.e.e, this.c));
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "enterAudioChannel", "", i, str, localStringBuilder.toString(), this.e.c);
    this.e.d.a(this.a, this.b, GProSdkWrapperImpl.b(this.e.e, this.c), GProSdkWrapperImpl.a(this.e.e, this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.33.1
 * JD-Core Version:    0.7.0.1
 */