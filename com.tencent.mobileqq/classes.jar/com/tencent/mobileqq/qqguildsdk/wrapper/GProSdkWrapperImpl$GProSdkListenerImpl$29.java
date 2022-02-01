package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$29
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$29(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tinyId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", action: ");
    localStringBuilder.append(this.b);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onPushLiveRoomStatusChangeMsg", "notify", localStringBuilder.toString());
    this.g.a.a(GProConvert.a(this.c), GProConvert.a(this.d), GProConvert.a(this.e), this.f, GProConvert.a(this.a), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.29
 * JD-Core Version:    0.7.0.1
 */