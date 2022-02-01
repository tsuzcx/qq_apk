package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$15
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$15(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, long paramLong1, String paramString, int paramInt, long paramLong2) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tinyId : ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", url : ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", avatarSizeFlag : ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", avatarTimeStamp : ");
    localStringBuilder.append(this.d);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onGetGuildUserAvatarUrl", "", localStringBuilder.toString());
    this.e.a.a(GProConvert.a(this.a), this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.15
 * JD-Core Version:    0.7.0.1
 */