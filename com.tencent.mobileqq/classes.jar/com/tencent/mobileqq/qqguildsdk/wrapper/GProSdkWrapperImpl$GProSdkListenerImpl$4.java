package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProChannel;
import com.tencent.mobileqq.qqguildsdk.data.GProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$4
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$4(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, int paramInt, String paramString, GProChannel paramGProChannel) {}
  
  public void run()
  {
    int i = this.a;
    Object localObject2 = this.b;
    if (this.c != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("guildId : ");
      ((StringBuilder)localObject1).append(this.c.getGuildId());
      ((StringBuilder)localObject1).append("， channeluin ：");
      ((StringBuilder)localObject1).append(this.c.getChannelId());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "channelinfo is null";
    }
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onChannelInfoUpdated", "notify", i, (String)localObject2, (String)localObject1);
    localObject2 = this.d.a;
    i = this.a;
    Object localObject1 = this.c;
    if (localObject1 != null) {
      localObject1 = new GProChannelInfo((GProChannel)localObject1);
    } else {
      localObject1 = null;
    }
    ((GProSdkWrapperImpl)localObject2).a(i, (GProChannelInfo)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.4
 * JD-Core Version:    0.7.0.1
 */