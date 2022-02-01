package com.tencent.mobileqq.guild.mainframe.helper;

import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildLeftBarController;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildListController;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.NotifyObj;
import java.util.Observable;
import java.util.Observer;

class GuildLeftItemUpdateHelper$2
  implements Observer
{
  GuildLeftItemUpdateHelper$2(GuildLeftItemUpdateHelper paramGuildLeftItemUpdateHelper) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObject instanceof IGuildUnreadCntService.NotifyObj)) {
      return;
    }
    paramObservable = (IGuildUnreadCntService.NotifyObj)paramObject;
    if (paramObservable.a != 2) {
      return;
    }
    GuildLeftItemUpdateHelper.c(this.a).c().i().a(1, paramObservable.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.GuildLeftItemUpdateHelper.2
 * JD-Core Version:    0.7.0.1
 */