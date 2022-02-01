package com.tencent.mobileqq.now.message;

import aezx;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import axjm;
import axjn;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

public class WrapperArkView
  extends FrameLayout
{
  int jdField_a_of_type_Int;
  aezx jdField_a_of_type_Aezx;
  private axjm jdField_a_of_type_Axjm;
  MessageForArkApp jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp;
  
  public WrapperArkView(@NonNull Context paramContext, ViewGroup paramViewGroup, MessageForArkApp paramMessageForArkApp, aezx paramaezx, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp = paramMessageForArkApp;
    this.jdField_a_of_type_Aezx = paramaezx;
    this.jdField_a_of_type_Int = paramInt;
    setLayoutParams(paramViewGroup.getLayoutParams());
  }
  
  private View a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_Aezx.a(0, 0, paramChatMessage, null, this, this.jdField_a_of_type_Axjm);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer instanceof axjn)) {
      ((axjn)this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer).f();
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer = new axjn();
    removeAllViews();
    addView(a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer instanceof axjn)) {
      ((axjn)this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer).f();
    }
  }
  
  public void setOnArkViewTouchListener(axjm paramaxjm)
  {
    this.jdField_a_of_type_Axjm = paramaxjm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.WrapperArkView
 * JD-Core Version:    0.7.0.1
 */