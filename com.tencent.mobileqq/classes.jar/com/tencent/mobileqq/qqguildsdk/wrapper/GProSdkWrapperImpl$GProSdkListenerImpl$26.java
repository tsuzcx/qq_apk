package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$26
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$26(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("tinyId:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", bMute: ");
    localStringBuilder.append(this.c);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onPushUserMuteSeatInGuild", "notify", localStringBuilder.toString());
    this.d.a.b(GProConvert.a(this.a), GProConvert.a(this.b), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.26
 * JD-Core Version:    0.7.0.1
 */