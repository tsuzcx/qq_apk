package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;

class GProSdkWrapperImpl$GProSdkListenerImpl$30
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$30(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, ArrayList paramArrayList, int paramInt, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("count:");
    localStringBuilder.append(this.a.size());
    localStringBuilder.append(", action: ");
    localStringBuilder.append(this.b);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onPushSwitchLiveRoom", "notify", localStringBuilder.toString());
    this.e.a.a(GProConvert.a(this.c), GProConvert.a(this.d), GProConvert.i(this.a), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.30
 * JD-Core Version:    0.7.0.1
 */