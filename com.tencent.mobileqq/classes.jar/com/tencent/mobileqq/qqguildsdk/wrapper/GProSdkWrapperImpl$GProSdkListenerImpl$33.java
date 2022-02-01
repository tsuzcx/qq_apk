package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProGuildMemberCountInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$33
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$33(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, GProGuildMemberCountInfo paramGProGuildMemberCountInfo) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("memberCountInfo:");
    ((StringBuilder)localObject).append(this.a);
    if (((StringBuilder)localObject).toString() != null) {
      localObject = this.a.toString();
    } else {
      localObject = " is null";
    }
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onMemberCountUpdate", "notify", (String)localObject);
    this.b.a.a(GProConvert.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.33
 * JD-Core Version:    0.7.0.1
 */