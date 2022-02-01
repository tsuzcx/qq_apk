package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.guild.chatpie.GuildMsgItemBuildFactory;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout;

public class GuildLiveChannelReplyTextItemBuilder
  extends GuildReplyTextItemBuilder
{
  public GuildLiveChannelReplyTextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  protected ViewGroup a(Context paramContext)
  {
    return GuildReplyTextItemBuilder.a(paramContext, (ViewGroup)LayoutInflater.from(paramContext).inflate(2131625074, null));
  }
  
  protected void a(View paramView, GuildReplyTextItemBuilder.ReplyHolder paramReplyHolder, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, MessageForReplyText paramMessageForReplyText, boolean paramBoolean)
  {
    super.a(paramView, paramReplyHolder, paramOnLongClickAndTouchListener, paramMessageForReplyText, paramBoolean);
    paramOnLongClickAndTouchListener = paramView.getContext();
    paramReplyHolder.a.setBackground(paramOnLongClickAndTouchListener.getResources().getDrawable(2130840940));
    paramReplyHolder.b.setTextColor(paramOnLongClickAndTouchListener.getResources().getColor(2131166251));
    paramReplyHolder.c.setTextColor(paramOnLongClickAndTouchListener.getResources().getColor(2131166252));
    paramReplyHolder.e.setTextColor(paramOnLongClickAndTouchListener.getResources().getColor(2131166250));
    ((ImageView)paramView.findViewById(2131436449)).setImageResource(2130840939);
  }
  
  protected View b(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = a(paramChatMessage, paramViewHolder, paramView, paramGuildMsgItemLayout, paramOnLongClickAndTouchListener);
    paramView = new RelativeLayout.LayoutParams(-2, -1);
    paramGuildMsgItemLayout.setContentView(paramViewHolder, paramChatMessage.isNeedCombine(), GuildMsgItemBuildFactory.a(this.g, paramChatMessage), paramView);
    return paramViewHolder;
  }
  
  protected LinearLayout.LayoutParams c()
  {
    return new LinearLayout.LayoutParams(-2, -1);
  }
  
  protected LinearLayout.LayoutParams h()
  {
    return new LinearLayout.LayoutParams(-2, -2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildLiveChannelReplyTextItemBuilder
 * JD-Core Version:    0.7.0.1
 */