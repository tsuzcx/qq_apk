package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.GuildMsgItemBuildFactory;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout;
import com.tencent.mobileqq.guild.widget.GuildLiveMixedMsgLinearLayout;
import com.tencent.mobileqq.guild.widget.GuildMixedMsgLinearLayout;

public class GuildLiveChannelMixedMsgItemBuilder
  extends GuildMixedMsgItemBuilder
{
  public GuildLiveChannelMixedMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  protected View b(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = a(paramChatMessage, paramViewHolder, paramView, paramGuildMsgItemLayout, paramOnLongClickAndTouchListener);
    paramView = new RelativeLayout.LayoutParams(-2, -1);
    paramGuildMsgItemLayout.setContentView(paramViewHolder, paramChatMessage.isNeedCombine(), GuildMsgItemBuildFactory.a(this.g, paramChatMessage), paramView);
    return paramViewHolder;
  }
  
  protected GuildMixedMsgLinearLayout c()
  {
    return new GuildLiveMixedMsgLinearLayout(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildLiveChannelMixedMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */