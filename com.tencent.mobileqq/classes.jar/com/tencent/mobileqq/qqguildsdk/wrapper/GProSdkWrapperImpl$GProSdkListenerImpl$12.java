package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;

class GProSdkWrapperImpl$GProSdkListenerImpl$12
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$12(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, long paramLong, ArrayList paramArrayList) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId : ");
    localStringBuilder.append(this.a);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onPushChannelDestroy", "", localStringBuilder.toString());
    this.c.a.a(GProConvert.b(this.b), GProConvert.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.12
 * JD-Core Version:    0.7.0.1
 */