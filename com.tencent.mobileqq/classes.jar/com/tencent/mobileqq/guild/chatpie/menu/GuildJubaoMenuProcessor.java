package com.tencent.mobileqq.guild.chatpie.menu;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuClickProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.api.IQQGuildJubaoApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class GuildJubaoMenuProcessor
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor, IBaseBubbleBuilderMenuClickProcessor
{
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    ((IQQGuildJubaoApi)QRoute.api(IQQGuildJubaoApi.class)).reportGuild(BaseActivity.sTopActivity, this.b.b, "", 25080, true);
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    paramQQCustomMenu.a(2131436687, paramContext.getString(2131891075), 0);
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 2131436687;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.menu.GuildJubaoMenuProcessor
 * JD-Core Version:    0.7.0.1
 */