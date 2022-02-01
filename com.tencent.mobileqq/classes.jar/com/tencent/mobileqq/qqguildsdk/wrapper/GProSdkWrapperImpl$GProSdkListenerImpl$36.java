package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProClientIdentity;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$36
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$36(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, long paramLong1, long paramLong2, GProClientIdentity paramGProClientIdentity) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", tinyId:");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", clientIdentity:");
    ((StringBuilder)localObject).append(this.c);
    if (((StringBuilder)localObject).toString() != null) {
      localObject = this.c.toString();
    } else {
      localObject = " is null";
    }
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onGuildMemberClientIdentityUpdate", "notify", (String)localObject);
    this.d.a.a(GProConvert.a(this.a), GProConvert.a(this.b), GProConvert.a(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.36
 * JD-Core Version:    0.7.0.1
 */