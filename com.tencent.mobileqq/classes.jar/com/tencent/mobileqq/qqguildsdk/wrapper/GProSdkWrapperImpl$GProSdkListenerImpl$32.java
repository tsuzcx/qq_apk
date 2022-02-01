package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProGuildInit;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$32
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$32(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, GProGuildInit paramGProGuildInit) {}
  
  public void run()
  {
    if (this.a != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGuildId:");
      localStringBuilder.append(this.a.getGuildId());
      GProLog.b("GProSdkWrapperImpl", false, "system notify", "onPushChannelCategoryChanged", "notify", localStringBuilder.toString());
      this.b.a.a(GProConvert.a(this.a.getGuildId()), GProConvert.a(this.a));
      return;
    }
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onPushChannelCategoryChanged", "notify", "guildInit is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.32
 * JD-Core Version:    0.7.0.1
 */