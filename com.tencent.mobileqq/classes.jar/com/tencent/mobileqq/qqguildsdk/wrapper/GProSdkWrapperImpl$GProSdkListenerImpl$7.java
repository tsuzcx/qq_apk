package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$7
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$7(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, long paramLong) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId : ");
    localStringBuilder.append(this.a);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onPushDestroyGuild", "", localStringBuilder.toString());
    this.b.a.a(GProConvert.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.7
 * JD-Core Version:    0.7.0.1
 */