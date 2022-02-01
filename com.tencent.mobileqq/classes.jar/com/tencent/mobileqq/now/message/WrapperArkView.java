package com.tencent.mobileqq.now.message;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

public class WrapperArkView
  extends FrameLayout
{
  int jdField_a_of_type_Int;
  ChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioChatItemBuilder;
  MessageForArkApp jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp;
  private OnArkViewTouchListener jdField_a_of_type_ComTencentMobileqqNowMessageOnArkViewTouchListener;
  
  public WrapperArkView(@NonNull Context paramContext, ViewGroup paramViewGroup, MessageForArkApp paramMessageForArkApp, ChatItemBuilder paramChatItemBuilder, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp = paramMessageForArkApp;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatItemBuilder = paramChatItemBuilder;
    this.jdField_a_of_type_Int = paramInt;
    setLayoutParams(paramViewGroup.getLayoutParams());
  }
  
  private View a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioChatItemBuilder.a(0, 0, paramChatMessage, null, this, this.jdField_a_of_type_ComTencentMobileqqNowMessageOnArkViewTouchListener);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer instanceof QQLiveArkContainerWrapper)) {
      ((QQLiveArkContainerWrapper)this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer).f();
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer = new QQLiveArkContainerWrapper();
    removeAllViews();
    addView(a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp));
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer instanceof QQLiveArkContainerWrapper)) {
      ((QQLiveArkContainerWrapper)this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer).f();
    }
  }
  
  public void setOnArkViewTouchListener(OnArkViewTouchListener paramOnArkViewTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNowMessageOnArkViewTouchListener = paramOnArkViewTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.WrapperArkView
 * JD-Core Version:    0.7.0.1
 */