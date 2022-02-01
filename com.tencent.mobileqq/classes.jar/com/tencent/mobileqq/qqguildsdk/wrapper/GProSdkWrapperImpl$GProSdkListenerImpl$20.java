package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;

class GProSdkWrapperImpl$GProSdkListenerImpl$20
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$20(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, ArrayList paramArrayList, long paramLong) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("infoList size : ");
    localStringBuilder.append(this.a.size());
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onBatchGuildMemberNameUpdate", "", localStringBuilder.toString());
    this.c.a.a(GProConvert.a(this.b), GProConvert.j(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.20
 * JD-Core Version:    0.7.0.1
 */