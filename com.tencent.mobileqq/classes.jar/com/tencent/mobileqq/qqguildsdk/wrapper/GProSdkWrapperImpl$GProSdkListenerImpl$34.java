package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProNoticeRedPoint;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$34
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$34(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, GProNoticeRedPoint paramGProNoticeRedPoint, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("redPoint:");
    ((StringBuilder)localObject).append(this.a);
    if (((StringBuilder)localObject).toString() != null) {
      localObject = this.a.toString();
    } else {
      localObject = " is null";
    }
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onNoticeListUpdate", "notify", (String)localObject);
    localObject = new GuildNoticeRedPoint();
    ((GuildNoticeRedPoint)localObject).a = this.a.getType();
    ((GuildNoticeRedPoint)localObject).b = this.a.getCount();
    ((GuildNoticeRedPoint)localObject).c = this.a.getExpireTs();
    this.c.a.a(74, "onNoticeListUpdate", localObject, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.34
 * JD-Core Version:    0.7.0.1
 */