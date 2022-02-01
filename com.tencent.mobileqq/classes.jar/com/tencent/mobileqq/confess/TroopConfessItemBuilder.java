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
  private int c = 0;
  
  public TroopConfessItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.c = (BaseChatItemLayout.B + AIOUtils.a(20.0F, paramContext.getResources()));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (MessageForTroopConfess)paramChatMessage;
    TroopConfessItemBuilder.TroopConfessViewHolder localTroopConfessViewHolder = (TroopConfessItemBuilder.TroopConfessViewHolder)paramViewHolder;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558939, null);
      paramChatMessage.setLayoutParams(new ViewGroup.LayoutParams(this.c, -2));
      TroopConfessItemBuilder.TroopConfessViewHolder.a(localTroopConfessViewHolder, (TextView)paramChatMessage.findViewById(2131380813));
      TroopConfessItemBuilder.TroopConfessViewHolder.b(localTroopConfessViewHolder, (TextView)paramChatMessage.findViewById(2131380804));
      TroopConfessItemBuilder.TroopConfessViewHolder.c(localTroopConfessViewHolder, (TextView)paramChatMessage.findViewById(2131380828));
      TroopConfessItemBuilder.TroopConfessViewHolder.a(localTroopConfessViewHolder, (ConfessNewsBgView)paramChatMessage.findViewById(2131381104));
      TroopConfessItemBuilder.TroopConfessViewHolder.a(localTroopConfessViewHolder).setPressMask(true);
      TroopConfessItemBuilder.TroopConfessViewHolder.a(localTroopConfessViewHolder, paramChatMessage.findViewById(2131370639));
    }
    TroopConfessItemBuilder.TroopConfessViewHolder.a(localTroopConfessViewHolder).setBgType(paramBaseChatItemLayout.getConfessTopicId() % 4);
    TroopConfessItemBuilder.TroopConfessViewHolder.a(localTroopConfessViewHolder).setOnLongClickListener(paramOnLongClickAndTouchListener);
    TroopConfessItemBuilder.TroopConfessViewHolder.a(localTroopConfessViewHolder).setOnTouchListener(paramOnLongClickAndTouchListener);
    localTroopConfessViewHolder.a(paramBaseChatItemLayout.mTroopConfessMsg);
    paramChatMessage.setOnClickListener(new TroopConfessItemBuilder.1(this, paramBaseChatItemLayout));
    if (e)
    {
      ((TroopConfessItemBuilder.TroopConfessViewHolder)paramViewHolder).b.append(TroopConfessItemBuilder.TroopConfessViewHolder.b(localTroopConfessViewHolder).getText()).append(TroopConfessItemBuilder.TroopConfessViewHolder.a(localTroopConfessViewHolder).getText());
      if (TroopConfessItemBuilder.TroopConfessViewHolder.c(localTroopConfessViewHolder).getVisibility() == 0) {
        ((TroopConfessItemBuilder.TroopConfessViewHolder)paramViewHolder).b.append(TroopConfessItemBuilder.TroopConfessViewHolder.c(localTroopConfessViewHolder).getText());
      }
      paramChatMessage.setContentDescription(((TroopConfessItemBuilder.TroopConfessViewHolder)paramViewHolder).b.toString());
    }
    return paramChatMessage;
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopConfessItemBuilder.TroopConfessViewHolder();
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForTroopConfess))) {
      return;
    }
    MessageForTroopConfess localMessageForTroopConfess = (MessageForTroopConfess)paramChatMessage;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
    return paramView.a();
  }
  
  public void b(View paramView)
  {
    super.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TroopConfessItemBuilder
 * JD-Core Version:    0.7.0.1
 */