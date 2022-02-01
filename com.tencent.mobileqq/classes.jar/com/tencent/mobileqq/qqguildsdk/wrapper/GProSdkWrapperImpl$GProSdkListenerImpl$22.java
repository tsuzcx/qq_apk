package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProUser;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$22
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$22(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, long paramLong1, long paramLong2, GProUser paramGProUser) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", channelId: ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(this.c);
    if (((StringBuilder)localObject).toString() != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", userInfo:");
      ((StringBuilder)localObject).append(this.c.toString());
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onPushAudioChannelUserEnter", "notify", (String)localObject);
    this.d.a.a(GProConvert.a(this.a), GProConvert.a(this.b), new GProUserInfo(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.22
 * JD-Core Version:    0.7.0.1
 */