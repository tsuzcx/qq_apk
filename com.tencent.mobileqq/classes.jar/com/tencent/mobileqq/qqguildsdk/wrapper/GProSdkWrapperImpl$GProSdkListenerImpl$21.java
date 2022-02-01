package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProGuildUserProfile;
import com.tencent.mobileqq.qqguildsdk.data.GProUserProfileInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$21
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$21(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, int paramInt, String paramString, long paramLong1, long paramLong2, GProGuildUserProfile paramGProGuildUserProfile) {}
  
  public void run()
  {
    int i = this.a;
    Object localObject2 = this.b;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("guildId：");
    ((StringBuilder)localObject1).append(this.c);
    ((StringBuilder)localObject1).append("， tinyId：");
    ((StringBuilder)localObject1).append(this.d);
    ((StringBuilder)localObject1).append(this.e);
    if (((StringBuilder)localObject1).toString() != null) {
      localObject1 = this.e.getAvatarUrl();
    } else {
      localObject1 = "";
    }
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onRefreshGuildUserProfileInfo", "notify", i, (String)localObject2, (String)localObject1);
    localObject2 = this.f.a;
    i = this.a;
    String str1 = this.b;
    String str2 = GProConvert.a(this.c);
    String str3 = GProConvert.a(this.d);
    localObject1 = this.e;
    if (localObject1 != null) {
      localObject1 = new GProUserProfileInfo((GProGuildUserProfile)localObject1);
    } else {
      localObject1 = null;
    }
    ((GProSdkWrapperImpl)localObject2).a(i, str1, str2, str3, (GProUserProfileInfo)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.21
 * JD-Core Version:    0.7.0.1
 */