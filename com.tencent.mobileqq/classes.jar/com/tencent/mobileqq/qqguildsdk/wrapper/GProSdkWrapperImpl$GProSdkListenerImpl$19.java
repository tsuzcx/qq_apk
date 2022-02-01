package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;

class GProSdkWrapperImpl$GProSdkListenerImpl$19
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$19(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, ArrayList paramArrayList) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("infoList size : ");
    localStringBuilder.append(this.a.size());
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onBatchGuildUserNickUpdate", "", localStringBuilder.toString());
    this.b.a.b(GProConvert.j(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.19
 * JD-Core Version:    0.7.0.1
 */