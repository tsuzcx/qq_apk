package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$5
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$5(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, int paramInt, String paramString, long paramLong) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId : ");
    localStringBuilder.append(this.c);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onUserListFetchFinish", "notify", i, str, localStringBuilder.toString());
    this.d.a.a(this.a, GProConvert.a(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.5
 * JD-Core Version:    0.7.0.1
 */