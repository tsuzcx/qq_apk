package com.tencent.mobileqq.guild.mainframe.helper;

import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.NoticeRedUpdateListener;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildLeftBarController;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildListController;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildInboxItemBuilder;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildListItemBaseBuilder;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.guild.util.QQGuildSPUtils;
import java.util.ArrayList;
import java.util.Iterator;

class GuildLeftItemUpdateHelper$3
  extends IGuildInboxRedService.NoticeRedUpdateListener
{
  GuildLeftItemUpdateHelper$3(GuildLeftItemUpdateHelper paramGuildLeftItemUpdateHelper) {}
  
  public void a(IGuildUnreadCntService.UnreadCntInfo paramUnreadCntInfo)
  {
    GuildLeftItemUpdateHelper.d(this.a).c().i().a(4, "");
    paramUnreadCntInfo = ((GuildLeftItemViewExtHelper)GuildLeftItemUpdateHelper.e(this.a).a(GuildMainFrameConstants.d)).l().iterator();
    while (paramUnreadCntInfo.hasNext()) {
      if (((GuildListItemBaseBuilder)paramUnreadCntInfo.next() instanceof GuildInboxItemBuilder))
      {
        i = 1;
        break label73;
      }
    }
    int i = 0;
    label73:
    if (i == 0)
    {
      QQGuildSPUtils.b(true);
      GuildLeftItemUpdateHelper.f(this.a).c().i().a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.GuildLeftItemUpdateHelper.3
 * JD-Core Version:    0.7.0.1
 */