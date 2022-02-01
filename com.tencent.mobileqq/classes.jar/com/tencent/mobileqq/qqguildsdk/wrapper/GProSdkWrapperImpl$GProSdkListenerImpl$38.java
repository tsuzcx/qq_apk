package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.List;

class GProSdkWrapperImpl$GProSdkListenerImpl$38
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$38(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, long paramLong1, long paramLong2, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId: ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", channelId: ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", members: ");
    ((StringBuilder)localObject).append(this.c.size());
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onPushLeaveChannel", "notify", ((StringBuilder)localObject).toString());
    localObject = GProConvert.b(this.c);
    String str1 = GProConvert.a(this.a);
    String str2 = GProConvert.a(this.b);
    this.d.a.b(str1, str2, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.38
 * JD-Core Version:    0.7.0.1
 */