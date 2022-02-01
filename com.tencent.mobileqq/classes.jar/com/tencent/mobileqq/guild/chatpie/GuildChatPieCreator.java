package com.tencent.mobileqq.guild.chatpie;

import android.content.Intent;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.chatpiecreator.IChatPieCreator;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class GuildChatPieCreator
  implements IChatPieCreator
{
  public BaseChatPie a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, TopGestureLayout paramTopGestureLayout, Intent paramIntent)
  {
    return new GuildChatPie(paramQQAppInterface, paramTopGestureLayout, paramBaseActivity, paramBaseActivity);
  }
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    return ((paramBaseActivity instanceof SplashActivity)) || ((paramBaseActivity instanceof ChatActivity));
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, Intent paramIntent)
  {
    return paramBaseChatPie instanceof GuildChatPie;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildChatPieCreator
 * JD-Core Version:    0.7.0.1
 */