package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$31
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$31(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, long paramLong1, long paramLong2, long paramLong3, int paramInt) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", channelId:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", roomId:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", action: ");
    localStringBuilder.append(this.d);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onPushSelfBannedSpeakChange", "notify", localStringBuilder.toString());
    this.e.a.a(GProConvert.a(this.a), GProConvert.a(this.b), GProConvert.a(this.c), this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.31
 * JD-Core Version:    0.7.0.1
 */