package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProGuild;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchGuildInfoForImplCallback;

class GProSdkWrapperImpl$52$1
  implements Runnable
{
  GProSdkWrapperImpl$52$1(GProSdkWrapperImpl.52 param52, int paramInt, String paramString, GProGuild paramGProGuild) {}
  
  public void run()
  {
    int i = this.a;
    Object localObject2 = this.b;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("guildInfo ：");
    ((StringBuilder)localObject1).append(this.c);
    if (((StringBuilder)localObject1).toString() != null) {
      localObject1 = this.c.toString();
    } else {
      localObject1 = "";
    }
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGuildInfoForGuest", "", i, (String)localObject2, (String)localObject1, this.d.a);
    localObject2 = this.d.b;
    i = this.a;
    String str = this.b;
    localObject1 = this.c;
    if (localObject1 != null) {
      localObject1 = new GProGuildInfo((GProGuild)localObject1);
    } else {
      localObject1 = null;
    }
    ((IFetchGuildInfoForImplCallback)localObject2).a(i, str, (GProGuildInfo)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.52.1
 * JD-Core Version:    0.7.0.1
 */