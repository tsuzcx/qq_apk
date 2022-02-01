package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$27
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$27(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tinyId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", bVoiceless: ");
    localStringBuilder.append(this.b);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onPushSetUserVoicelessToMe", "notify", localStringBuilder.toString());
    this.c.a.c(GProConvert.a(this.a), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.27
 * JD-Core Version:    0.7.0.1
 */