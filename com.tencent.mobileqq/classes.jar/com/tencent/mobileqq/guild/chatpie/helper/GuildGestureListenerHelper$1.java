package com.tencent.mobileqq.guild.chatpie.helper;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.guild.chatpie.GuildChatPie;
import com.tencent.mobileqq.guild.chatpie.GuildHelperProvider;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.AbsGestureListener;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.NotifyData;

class GuildGestureListenerHelper$1
  extends AbsGestureListener
{
  GuildGestureListenerHelper$1(GuildGestureListenerHelper paramGuildGestureListenerHelper) {}
  
  public void a(NotifyData paramNotifyData)
  {
    GuildGestureListenerHelper.a(this.a, paramNotifyData);
    GuildGestureListenerHelper.b(this.a, paramNotifyData);
    GuildGestureListenerHelper.c(this.a, paramNotifyData);
    GuildGestureListenerHelper.d(this.a, paramNotifyData);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    if ((paramInt != 1) && (paramInt != 2)) {
      return false;
    }
    GuildHelperProvider localGuildHelperProvider = (GuildHelperProvider)this.a.a.bv().d();
    if (paramInt == 1) {
      bool = true;
    }
    return localGuildHelperProvider.b(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildGestureListenerHelper.1
 * JD-Core Version:    0.7.0.1
 */