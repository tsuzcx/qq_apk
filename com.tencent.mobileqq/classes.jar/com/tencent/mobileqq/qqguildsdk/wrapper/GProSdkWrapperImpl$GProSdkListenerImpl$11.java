package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProGuildInit;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$11
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$11(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, GProGuildInit paramGProGuildInit, long paramLong) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    long l;
    if (this.a != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId : ");
      l = this.a.getGuildId();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("， channelId：");
      l = this.b;
    }
    localStringBuilder.append(l);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onPushChannelCreated", "", localStringBuilder.toString());
    if (this.a != null) {
      this.c.a.a(GProConvert.a(this.a.getGuildId()), GProConvert.a(this.b), GProConvert.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.11
 * JD-Core Version:    0.7.0.1
 */