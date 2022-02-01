package com.tencent.mobileqq.confess;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class TroopConfessItemBuilder
  extends BaseBubbleBuilder
{
  private int a = 0;
  
  public TroopConfessItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.a = (BaseChatItemLayout.B + AIOUtils.b(20.0F, paramContext.getResources()));
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (MessageForTroopConfess)paramChatMessage;
    paramViewHolder = (TroopConfessItemBuilder.TroopConfessViewHolder)paramViewHolder;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.e).inflate(2131624457, null);
      paramChatMessage.setLayoutParams(new ViewGroup.LayoutParams(this.a, -2));
      TroopConfessItemBuilder.TroopConfessViewHolder.a(paramViewHolder, (TextView)paramChatMessage.findViewById(2131448989));
      TroopConfessItemBuilder.TroopConfessViewHolder.b(paramViewHolder, (TextView)paramChatMessage.findViewById(2131448980));
      TroopConfessItemBuilder.TroopConfessViewHolder.c(paramViewHolder, (TextView)paramChatMessage.findViewById(2131449004));
      TroopConfessItemBuilder.TroopConfessViewHolder.a(paramViewHolder, (ConfessNewsBgView)paramChatMessage.findViewById(2131449303));
      TroopConfessItemBuilder.TroopConfessViewHolder.a(paramViewHolder).setPressMask(true);
      TroopConfessItemBuilder.TroopConfessViewHolder.a(paramViewHolder, paramChatMessage.findViewById(2131437512));
    }
    TroopConfessItemBuilder.TroopConfessViewHolder.a(paramViewHolder).setBgType(paramBaseChatItemLayout.getConfessTopicId() % 4);
    TroopConfessItemBuilder.TroopConfessViewHolder.b(paramViewHolder).setOnLongClickListener(paramOnLongClickAndTouchListener);
    TroopConfessItemBuilder.TroopConfessViewHolder.b(paramViewHolder).setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.a(paramBaseChatItemLayout.mTroopConfessMsg);
    paramChatMessage.setOnClickListener(new TroopConfessItemBuilder.1(this, paramBaseChatItemLayout));
    if (v)
    {
      paramView = paramViewHolder.r;
      paramView.append(TroopConfessItemBuilder.TroopConfessViewHolder.d(paramViewHolder).getText());
      paramView.append(TroopConfessItemBuilder.TroopConfessViewHolder.c(paramViewHolder).getText());
      if (TroopConfessItemBuilder.TroopConfessViewHolder.e(paramViewHolder).getVisibility() == 0) {
        paramViewHolder.r.append(TroopConfessItemBuilder.TroopConfessViewHolder.e(paramViewHolder).getText());
      }
      paramChatMessage.setContentDescription(paramViewHolder.r.toString());
    }
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopConfessItemBuilder.TroopConfessViewHolder();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      if (!(paramChatMessage instanceof MessageForTroopConfess)) {
        return;
      }
      MessageForTroopConfess localMessageForTroopConfess = (MessageForTroopConfess)paramChatMessage;
      if (paramInt != 2131431695)
      {
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
      ChatActivityFacade.b(this.e, this.d, paramChatMessage);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.e, this.f.a);
    super.a(paramView, this.e, 2131428089, null, null);
    return paramView.d();
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected void c(View paramView)
  {
    super.c(paramView);
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TroopConfessItemBuilder
 * JD-Core Version:    0.7.0.1
 */