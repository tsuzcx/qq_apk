package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$39
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$39(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, long paramLong1, long paramLong2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId: ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", channelId: ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", type: ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("->");
    ((StringBuilder)localObject).append(this.d);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onPushChannelVisibleChanged", "notify", ((StringBuilder)localObject).toString());
    localObject = GProConvert.a(this.a);
    String str = GProConvert.a(this.b);
    this.e.a.a((String)localObject, str, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.39
 * JD-Core Version:    0.7.0.1
 */