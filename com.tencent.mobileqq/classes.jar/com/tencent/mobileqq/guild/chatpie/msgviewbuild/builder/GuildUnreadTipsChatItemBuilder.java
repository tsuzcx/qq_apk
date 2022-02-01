package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

public class GuildUnreadTipsChatItemBuilder
  extends AbstractChatItemBuilder
{
  public GuildUnreadTipsChatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramMessageRecord = (GuildUnreadTipsChatItemBuilder.Holder)paramViewHolder;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.c).inflate(2131625020, null);
      paramMessageRecord = (TextView)paramViewHolder.findViewById(2131434371);
      paramMessageRecord.setMovementMethod(null);
      paramMessageRecord.setGravity(17);
      paramMessageRecord = paramViewHolder;
      if (ThemeUtil.isInNightMode(this.a))
      {
        paramMessageRecord = (TextView)paramViewHolder.findViewById(2131435014);
        paramView = (TextView)paramViewHolder.findViewById(2131435015);
        paramMessageRecord.setBackgroundColor(2130841051);
        paramView.setBackgroundColor(2130841051);
        return paramViewHolder;
      }
    }
    else
    {
      paramMessageRecord = paramView;
    }
    return paramMessageRecord;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new GuildUnreadTipsChatItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildUnreadTipsChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */