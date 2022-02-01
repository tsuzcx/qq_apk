package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$28
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$28(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, long paramLong1, long paramLong2, int paramInt) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guidId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", channelId:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", action: ");
    localStringBuilder.append(this.c);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onPushLiveChannelAnchorIdentityChange", "notify", localStringBuilder.toString());
    this.d.a.c(GProConvert.a(this.a), GProConvert.a(this.b), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.28
 * JD-Core Version:    0.7.0.1
 */