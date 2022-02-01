package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$35$1
  implements Runnable
{
  GProSdkWrapperImpl$35$1(GProSdkWrapperImpl.35 param35, int paramInt, String paramString, GProSecurityResult paramGProSecurityResult) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId ：");
    localStringBuilder.append(this.d.a);
    localStringBuilder.append(", channelId: ");
    localStringBuilder.append(this.d.b);
    localStringBuilder.append(GProSdkWrapperImpl.a(this.d.e, this.c));
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "exitAudioChannel", "", i, str, localStringBuilder.toString(), this.d.c);
    this.d.d.a(this.a, this.b, GProSdkWrapperImpl.b(this.d.e, this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.35.1
 * JD-Core Version:    0.7.0.1
 */