package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$13
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$13(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId : ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("， operatorTinyId ：");
    localStringBuilder.append(this.b);
    localStringBuilder.append("， adminTinyId ：");
    localStringBuilder.append(this.c);
    localStringBuilder.append("， bAdmin：");
    localStringBuilder.append(this.d);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onPushAdminChanged", "", localStringBuilder.toString());
    this.e.a.a(GProConvert.a(this.a), GProConvert.a(this.c), this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.13
 * JD-Core Version:    0.7.0.1
 */