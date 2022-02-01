package com.tencent.mobileqq.guild.chatpie.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuClickProcessor;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;

public class GuildSelectMoreMenuProcessor
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor, IBaseBubbleBuilderMenuClickProcessor
{
  private final String c = "GuildSelectMoreMenuProcessor";
  
  public GuildSelectMoreMenuProcessor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramSessionInfo);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    a(paramChatMessage, paramContext);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext)
  {
    BaseActivity localBaseActivity = (BaseActivity)paramContext;
    if ((localBaseActivity != null) && (localBaseActivity.getChatFragment() != null))
    {
      paramContext = AIOLongShotHelper.f();
      if (paramContext != null) {
        paramContext.e();
      }
      localBaseActivity.getChatFragment().k().c(paramChatMessage);
      if (paramChatMessage == null) {}
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("onClickSelectMore Error:");
    if (localBaseActivity != null) {
      paramChatMessage = localBaseActivity.toString();
    } else {
      paramChatMessage = "ca is null ";
    }
    paramContext.append(paramChatMessage);
    QLog.e("BaseBubbleBuilder", 1, paramContext.toString());
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu, Context paramContext)
  {
    if ((a()) && (MultiMsgManager.a().b()))
    {
      ((Vibrator)paramContext.getSystemService("vibrator")).vibrate(20L);
      paramQQCustomMenu.a(2131439015, paramContext.getString(2131892030), 2130840749);
    }
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    a(paramQQCustomMenu, paramContext);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 2131439015;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.menu.GuildSelectMoreMenuProcessor
 * JD-Core Version:    0.7.0.1
 */