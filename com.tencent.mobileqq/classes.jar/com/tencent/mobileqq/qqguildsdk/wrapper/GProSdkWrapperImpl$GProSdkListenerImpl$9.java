package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$9
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$9(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, long paramLong1, long paramLong2, int paramInt) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId : ");
    localStringBuilder.append(this.a);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onPushKickOffGuild", "be kick by other", localStringBuilder.toString());
    this.d.a.a(GProConvert.a(this.a), GProConvert.a(this.b), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.9
 * JD-Core Version:    0.7.0.1
 */