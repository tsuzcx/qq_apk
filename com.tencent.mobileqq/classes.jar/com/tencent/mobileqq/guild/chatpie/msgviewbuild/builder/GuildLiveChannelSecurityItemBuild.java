package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildLiveChannelMsgItemLayout;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.IGuildNickLayoutProcessor;
import com.tencent.mobileqq.guild.chatpie.view.GuildVasAvatar;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class GuildLiveChannelSecurityItemBuild
  extends GuildLiveChannelTextItemBuild
{
  public GuildLiveChannelSecurityItemBuild(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  protected String a(ChatMessage paramChatMessage, GuildTextItemBuild.Holder paramHolder, Context paramContext)
  {
    paramHolder.i.setText(paramChatMessage.msg);
    return paramChatMessage.msg;
  }
  
  String a(ChatMessage paramChatMessage, String paramString, AIOSelectableDelegateImpl paramAIOSelectableDelegateImpl)
  {
    return paramChatMessage.msg;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    BaseGuildMsgViewBuild.ViewHolder localViewHolder = (BaseGuildMsgViewBuild.ViewHolder)AIOUtils.b(paramView);
    paramView = localQQCustomMenu;
    if (localViewHolder != null) {
      paramView = a(localQQCustomMenu, localViewHolder.q);
    }
    return paramView.d();
  }
  
  protected void c(GuildMsgItemLayout paramGuildMsgItemLayout, ChatMessage paramChatMessage)
  {
    super.c(paramGuildMsgItemLayout, paramChatMessage);
    paramGuildMsgItemLayout.setIconLongClickListener(new GuildLiveChannelSecurityItemBuild.1(this));
    paramChatMessage = (GuildVasAvatar)paramGuildMsgItemLayout.findViewById(2131430587);
    paramChatMessage.setImageDrawable(paramGuildMsgItemLayout.getResources().getDrawable(2130840915));
    paramChatMessage.setOnClickListener(new GuildLiveChannelSecurityItemBuild.2(this));
  }
  
  protected void d(GuildMsgItemLayout paramGuildMsgItemLayout, ChatMessage paramChatMessage)
  {
    if ((paramGuildMsgItemLayout instanceof GuildLiveChannelMsgItemLayout)) {
      ((GuildLiveChannelMsgItemLayout)paramGuildMsgItemLayout).b();
    }
  }
  
  protected void e(GuildMsgItemLayout paramGuildMsgItemLayout, ChatMessage paramChatMessage)
  {
    super.e(paramGuildMsgItemLayout, paramChatMessage);
    paramGuildMsgItemLayout = (IGuildNickLayoutProcessor)paramGuildMsgItemLayout.a(IGuildNickLayoutProcessor.class);
    if (paramGuildMsgItemLayout == null) {
      return;
    }
    ((TextView)paramGuildMsgItemLayout.b().findViewById(2131430595)).setText(2131890422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildLiveChannelSecurityItemBuild
 * JD-Core Version:    0.7.0.1
 */