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
  private int a;
  
  public TroopConfessItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Int = (BaseChatItemLayout.B + AIOUtils.b(20.0F, paramContext.getResources()));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (MessageForTroopConfess)paramChatMessage;
    paramViewHolder = (TroopConfessItemBuilder.TroopConfessViewHolder)paramViewHolder;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558837, null);
      paramChatMessage.setLayoutParams(new ViewGroup.LayoutParams(this.jdField_a_of_type_Int, -2));
      TroopConfessItemBuilder.TroopConfessViewHolder.a(paramViewHolder, (TextView)paramChatMessage.findViewById(2131380076));
      TroopConfessItemBuilder.TroopConfessViewHolder.b(paramViewHolder, (TextView)paramChatMessage.findViewById(2131380067));
      TroopConfessItemBuilder.TroopConfessViewHolder.c(paramViewHolder, (TextView)paramChatMessage.findViewById(2131380091));
      TroopConfessItemBuilder.TroopConfessViewHolder.a(paramViewHolder, (ConfessNewsBgView)paramChatMessage.findViewById(2131380359));
      TroopConfessItemBuilder.TroopConfessViewHolder.a(paramViewHolder).setPressMask(true);
      TroopConfessItemBuilder.TroopConfessViewHolder.a(paramViewHolder, paramChatMessage.findViewById(2131370283));
    }
    TroopConfessItemBuilder.TroopConfessViewHolder.a(paramViewHolder).setBgType(paramBaseChatItemLayout.getConfessTopicId() % 4);
    TroopConfessItemBuilder.TroopConfessViewHolder.a(paramViewHolder).setOnLongClickListener(paramOnLongClickAndTouchListener);
    TroopConfessItemBuilder.TroopConfessViewHolder.a(paramViewHolder).setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.a(paramBaseChatItemLayout.mTroopConfessMsg);
    paramChatMessage.setOnClickListener(new TroopConfessItemBuilder.1(this, paramBaseChatItemLayout));
    if (e)
    {
      paramView = paramViewHolder.b;
      paramView.append(TroopConfessItemBuilder.TroopConfessViewHolder.b(paramViewHolder).getText());
      paramView.append(TroopConfessItemBuilder.TroopConfessViewHolder.a(paramViewHolder).getText());
      if (TroopConfessItemBuilder.TroopConfessViewHolder.c(paramViewHolder).getVisibility() == 0) {
        paramViewHolder.b.append(TroopConfessItemBuilder.TroopConfessViewHolder.c(paramViewHolder).getText());
      }
      paramChatMessage.setContentDescription(paramViewHolder.b.toString());
    }
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopConfessItemBuilder.TroopConfessViewHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      if (!(paramChatMessage instanceof MessageForTroopConfess)) {
        return;
      }
      MessageForTroopConfess localMessageForTroopConfess = (MessageForTroopConfess)paramChatMessage;
      if (paramInt != 2131365480)
      {
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return paramView.a();
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TroopConfessItemBuilder
 * JD-Core Version:    0.7.0.1
 */