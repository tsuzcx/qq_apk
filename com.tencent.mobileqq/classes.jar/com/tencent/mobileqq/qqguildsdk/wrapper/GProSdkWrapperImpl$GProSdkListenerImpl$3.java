package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProGuild;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$3
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$3(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, int paramInt, String paramString, GProGuild paramGProGuild, boolean paramBoolean) {}
  
  public void run()
  {
    int i = this.a;
    Object localObject2 = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId :");
    if (this.c != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.c.getGuildId());
      ((StringBuilder)localObject1).append(", usertype : ");
      ((StringBuilder)localObject1).append(this.c.getUserType());
      ((StringBuilder)localObject1).append(", fetchChannelList : ");
      ((StringBuilder)localObject1).append(this.d);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "null";
    }
    localStringBuilder.append((String)localObject1);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onGuildInfoUpdated", "notify", i, (String)localObject2, localStringBuilder.toString());
    localObject2 = this.e.a;
    i = this.a;
    Object localObject1 = this.c;
    if (localObject1 != null) {
      localObject1 = new GProGuildInfo((GProGuild)localObject1);
    } else {
      localObject1 = null;
    }
    ((GProSdkWrapperImpl)localObject2).a(i, (GProGuildInfo)localObject1, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.3
 * JD-Core Version:    0.7.0.1
 */