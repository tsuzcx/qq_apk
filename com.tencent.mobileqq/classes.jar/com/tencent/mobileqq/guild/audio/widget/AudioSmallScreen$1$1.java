package com.tencent.mobileqq.guild.audio.widget;

import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

class AudioSmallScreen$1$1
  implements Runnable
{
  AudioSmallScreen$1$1(AudioSmallScreen.1 param1) {}
  
  public void run()
  {
    ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).launchAudioChatPie(BaseApplication.getContext(), AudioSmallScreen.a(this.a.a), AudioSmallScreen.b(this.a.a), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.AudioSmallScreen.1.1
 * JD-Core Version:    0.7.0.1
 */