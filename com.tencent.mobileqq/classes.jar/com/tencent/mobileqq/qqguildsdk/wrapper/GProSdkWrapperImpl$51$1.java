package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProGuildInit;
import com.tencent.mobileqq.qqguildsdk.data.GuildInitInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchChannelListWithGuildInitForGuestCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$51$1
  implements Runnable
{
  GProSdkWrapperImpl$51$1(GProSdkWrapperImpl.51 param51, int paramInt, String paramString, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("guildInitList size ：");
    Object localObject1 = this.c;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
    } else {
      localObject1 = "0";
    }
    ((StringBuilder)localObject2).append(localObject1);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelListForGuest", "", i, str, ((StringBuilder)localObject2).toString(), this.d.a);
    str = null;
    localObject2 = this.c;
    localObject1 = str;
    if (localObject2 != null)
    {
      localObject1 = str;
      if (((ArrayList)localObject2).size() > 0) {
        localObject1 = GProConvert.a((GProGuildInit)this.c.get(0));
      }
    }
    this.d.b.a(this.a, this.b, (GuildInitInfo)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.51.1
 * JD-Core Version:    0.7.0.1
 */