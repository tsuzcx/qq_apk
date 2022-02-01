package com.tencent.mobileqq.now.message;

import afrj;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import aypr;
import ayps;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

public class WrapperArkView
  extends FrameLayout
{
  int jdField_a_of_type_Int;
  afrj jdField_a_of_type_Afrj;
  private aypr jdField_a_of_type_Aypr;
  MessageForArkApp jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp;
  
  public WrapperArkView(@NonNull Context paramContext, ViewGroup paramViewGroup, MessageForArkApp paramMessageForArkApp, afrj paramafrj, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp = paramMessageForArkApp;
    this.jdField_a_of_type_Afrj = paramafrj;
    this.jdField_a_of_type_Int = paramInt;
    setLayoutParams(paramViewGroup.getLayoutParams());
  }
  
  private View a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_Afrj.a(0, 0, paramChatMessage, null, this, this.jdField_a_of_type_Aypr);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer instanceof ayps)) {
      ((ayps)this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer).f();
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer = new ayps();
    removeAllViews();
    addView(a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer instanceof ayps)) {
      ((ayps)this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer).f();
    }
  }
  
  public void setOnArkViewTouchListener(aypr paramaypr)
  {
    this.jdField_a_of_type_Aypr = paramaypr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.WrapperArkView
 * JD-Core Version:    0.7.0.1
 */