package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;

class GProSdkWrapperImpl$GProSdkListenerImpl$17
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$17(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, ArrayList paramArrayList) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("infoList size：");
    localStringBuilder.append(this.a.size());
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onBatchGetUserAvatarUrl", "", localStringBuilder.toString());
    this.b.a.a(GProConvert.i(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.17
 * JD-Core Version:    0.7.0.1
 */