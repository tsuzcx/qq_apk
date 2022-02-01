package com.tencent.mobileqq.guild.mainframe.container.facade;

import com.tencent.mobileqq.guild.mainframe.attachcontainer.AbsGestureListener;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.NotifyData;
import com.tencent.qphone.base.util.QLog;

class GuildFacadeChannelFrameController$4
  extends AbsGestureListener
{
  GuildFacadeChannelFrameController$4(GuildFacadeChannelFrameController paramGuildFacadeChannelFrameController) {}
  
  public void a(NotifyData paramNotifyData)
  {
    if ((paramNotifyData.a() == 3) && (paramNotifyData.b() == 1000))
    {
      if (QLog.isColorLevel()) {
        QLog.i("GuildFacadeChannelFrameController", 1, "return from AIO");
      }
      GuildFacadeChannelFrameController.g(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.facade.GuildFacadeChannelFrameController.4
 * JD-Core Version:    0.7.0.1
 */