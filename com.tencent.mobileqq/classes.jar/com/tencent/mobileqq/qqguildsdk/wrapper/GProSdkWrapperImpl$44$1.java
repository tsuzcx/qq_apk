package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProGuildJoin;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoByAppIdentityCallback;
import com.tencent.mobileqq.qqguildsdk.data.GuildJoinInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$44$1
  implements Runnable
{
  GProSdkWrapperImpl$44$1(GProSdkWrapperImpl.44 param44, int paramInt, String paramString, GProGuildJoin paramGProGuildJoin, GProSecurityResult paramGProSecurityResult) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildJoin ：");
    localStringBuilder.append(this.c.toString());
    localStringBuilder.append(GProSdkWrapperImpl.a(this.e.b, this.d));
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGuildInfoByAppIdentity", "", i, str, localStringBuilder.toString());
    this.e.a.a(this.a, this.b, new GuildJoinInfo(this.c), GProSdkWrapperImpl.b(this.e.b, this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.44.1
 * JD-Core Version:    0.7.0.1
 */