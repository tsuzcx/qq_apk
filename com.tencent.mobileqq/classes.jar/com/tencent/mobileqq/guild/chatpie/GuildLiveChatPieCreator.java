package com.tencent.mobileqq.guild.chatpie;

import android.content.Intent;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class GuildLiveChatPieCreator
  extends GuildChatPieCreator
{
  public BaseChatPie a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, TopGestureLayout paramTopGestureLayout, Intent paramIntent)
  {
    return new GuildLiveChannelChatPie(paramQQAppInterface, paramTopGestureLayout, paramBaseActivity, paramBaseActivity);
  }
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    return true;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, Intent paramIntent)
  {
    return paramBaseChatPie instanceof GuildLiveChannelChatPie;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildLiveChatPieCreator
 * JD-Core Version:    0.7.0.1
 */