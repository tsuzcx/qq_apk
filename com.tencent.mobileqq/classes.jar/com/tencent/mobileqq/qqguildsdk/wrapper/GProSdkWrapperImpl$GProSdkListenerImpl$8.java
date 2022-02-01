package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProCategoryChannelIdList;
import com.tencent.gprosdk.GProGuild;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.HashMap;

class GProSdkWrapperImpl$GProSdkListenerImpl$8
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$8(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, long paramLong, GProGuild paramGProGuild, HashMap paramHashMap, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId : ");
    ((StringBuilder)localObject).append(this.a);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onPushJoinGuild", "", ((StringBuilder)localObject).toString());
    GProSdkWrapperImpl localGProSdkWrapperImpl = this.f.a;
    String str = GProConvert.a(this.a);
    localObject = this.b;
    if (localObject != null) {
      localObject = new GProGuildInfo((GProGuild)localObject);
    } else {
      localObject = null;
    }
    localGProSdkWrapperImpl.b(str, (GProGuildInfo)localObject, GProConvert.a(this.c), GProConvert.a(this.d), GProConvert.f(this.e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.8
 * JD-Core Version:    0.7.0.1
 */