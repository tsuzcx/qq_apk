package com.tencent.mobileqq.guild.main;

import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelVoice;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

class QQGuildChannelAdapterNew$2
  implements Runnable
{
  QQGuildChannelAdapterNew$2(QQGuildChannelAdapterNew paramQQGuildChannelAdapterNew, QQGuildChannelVoice paramQQGuildChannelVoice) {}
  
  public void run()
  {
    ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).launchAudioChatPie(BaseApplication.getContext(), QQGuildChannelAdapterNew.c(this.this$0), this.a.a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.QQGuildChannelAdapterNew.2
 * JD-Core Version:    0.7.0.1
 */