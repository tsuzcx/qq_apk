package com.tencent.mobileqq.guild.chatpie.menu;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuClickProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.chatpie.helper.GuildReplyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class GuildReplyMenuProcessor
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor, IBaseBubbleBuilderMenuClickProcessor
{
  public GuildReplyMenuProcessor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramSessionInfo);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramContext instanceof BaseActivity))
    {
      paramContext = ((BaseActivity)paramContext).getChatFragment();
      if (paramContext != null) {
        ((GuildReplyHelper)paramContext.k().q(119)).a(paramChatMessage, 0, 0L, null);
      }
    }
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    if (paramChatMessage != null)
    {
      if (paramChatMessage.shmsgseq == 0L) {
        return;
      }
      boolean bool = ((IGuildInfoUtilsApi)QRoute.api(IGuildInfoUtilsApi.class)).canTalkinChannel(this.a, this.b.c, this.b.b);
      if (!((IGuildInfoUtilsApi)QRoute.api(IGuildInfoUtilsApi.class)).isHomePage(this.a, this.b.b))
      {
        if (!bool) {
          return;
        }
        if ((paramChatMessage.senderuin != null) && (!paramChatMessage.senderuin.equals(this.a.getCurrentUin())) && (paramChatMessage.isSupportReply()))
        {
          paramQQCustomMenu.a(2131444634, paramContext.getString(2131895468), 2130840747);
          return;
        }
        if ((paramChatMessage.isSend()) && (paramChatMessage.isSupportReply()) && (paramChatMessage.extraflag != 32772) && (paramChatMessage.extraflag != 32768)) {
          paramQQCustomMenu.a(2131444634, paramContext.getString(2131895468), 2130840747);
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return 2131444634 == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.menu.GuildReplyMenuProcessor
 * JD-Core Version:    0.7.0.1
 */