package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$10$1
  implements Runnable
{
  GProSdkWrapperImpl$10$1(GProSdkWrapperImpl.10 param10, int paramInt, String paramString, GProSecurityResult paramGProSecurityResult) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId ：");
    localStringBuilder.append(this.d.a);
    localStringBuilder.append(GProSdkWrapperImpl.a(this.d.d, this.c));
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "removeGuild", "ui", i, str, localStringBuilder.toString(), this.d.b);
    this.d.c.a(this.a, this.b, GProSdkWrapperImpl.b(this.d.d, this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.10.1
 * JD-Core Version:    0.7.0.1
 */