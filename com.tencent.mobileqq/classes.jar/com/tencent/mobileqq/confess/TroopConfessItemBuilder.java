package com.tencent.mobileqq.confess;

import abzu;
import abzv;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
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
  public TroopConfessItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (MessageForTroopConfess)paramChatMessage;
    abzv localabzv = (abzv)paramViewHolder;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968771, null);
      paramChatMessage.setLayoutParams(new ViewGroup.LayoutParams(BaseChatItemLayout.d, -2));
      abzv.a(localabzv, (TextView)paramChatMessage.findViewById(2131363702));
      abzv.b(localabzv, (TextView)paramChatMessage.findViewById(2131363703));
      abzv.c(localabzv, (TextView)paramChatMessage.findViewById(2131363704));
      abzv.a(localabzv, (ConfessNewsBgView)paramChatMessage.findViewById(2131363701));
      abzv.a(localabzv).setPressMask(true);
      abzv.a(localabzv, paramChatMessage.findViewById(2131363552));
    }
    abzv.a(localabzv).setBgType(paramBaseChatItemLayout.getConfessTopicId() % 4);
    abzv.a(localabzv).setOnLongClickListener(paramOnLongClickAndTouchListener);
    abzv.a(localabzv).setOnTouchListener(paramOnLongClickAndTouchListener);
    localabzv.a(paramBaseChatItemLayout.mTroopConfessMsg);
    paramChatMessage.setOnClickListener(new abzu(this, paramBaseChatItemLayout));
    if (b)
    {
      ((abzv)paramViewHolder).b.append(abzv.b(localabzv).getText()).append(abzv.a(localabzv).getText());
      if (abzv.c(localabzv).getVisibility() == 0) {
        ((abzv)paramViewHolder).b.append(abzv.c(localabzv).getText());
      }
      paramChatMessage.setContentDescription(((abzv)paramViewHolder).b.toString());
    }
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new abzv();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForTroopConfess))) {
      return;
    }
    paramContext = (MessageForTroopConfess)paramChatMessage;
    switch (paramInt)
    {
    default: 
      return;
    }
    ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    return paramView.a();
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TroopConfessItemBuilder
 * JD-Core Version:    0.7.0.1
 */