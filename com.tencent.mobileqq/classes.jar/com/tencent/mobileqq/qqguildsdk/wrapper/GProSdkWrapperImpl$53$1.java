package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProGuild;
import com.tencent.gprosdk.GProGuildInit;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchGuestGuildForImplCallback;

class GProSdkWrapperImpl$53$1
  implements Runnable
{
  GProSdkWrapperImpl$53$1(GProSdkWrapperImpl.53 param53, int paramInt, String paramString, GProGuild paramGProGuild, GProGuildInit paramGProGuildInit) {}
  
  public void run()
  {
    int i = this.a;
    Object localObject2 = this.b;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("guildInfo ：");
    ((StringBuilder)localObject1).append(this.c);
    if (((StringBuilder)localObject1).toString() != null) {}
    for (localObject1 = this.c.getName();; localObject1 = ((StringBuilder)localObject3).toString())
    {
      break;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("guildInit ：");
      localObject1 = this.d;
      if (localObject1 != null) {
        localObject1 = ((GProGuildInit)localObject1).toString();
      } else {
        localObject1 = "";
      }
      ((StringBuilder)localObject3).append((String)localObject1);
    }
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGuestGuild", "", i, (String)localObject2, (String)localObject1, this.e.a);
    localObject2 = this.e.b;
    i = this.a;
    Object localObject3 = this.b;
    localObject1 = this.c;
    if (localObject1 != null) {
      localObject1 = new GProGuildInfo((GProGuild)localObject1);
    } else {
      localObject1 = null;
    }
    ((IFetchGuestGuildForImplCallback)localObject2).a(i, (String)localObject3, (GProGuildInfo)localObject1, GProConvert.a(this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.53.1
 * JD-Core Version:    0.7.0.1
 */