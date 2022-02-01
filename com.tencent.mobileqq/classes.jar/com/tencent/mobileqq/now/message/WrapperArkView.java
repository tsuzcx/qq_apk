package com.tencent.mobileqq.now.message;

import afxi;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import aydl;
import aydm;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

public class WrapperArkView
  extends FrameLayout
{
  int jdField_a_of_type_Int;
  afxi jdField_a_of_type_Afxi;
  private aydl jdField_a_of_type_Aydl;
  MessageForArkApp jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp;
  
  public WrapperArkView(@NonNull Context paramContext, ViewGroup paramViewGroup, MessageForArkApp paramMessageForArkApp, afxi paramafxi, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp = paramMessageForArkApp;
    this.jdField_a_of_type_Afxi = paramafxi;
    this.jdField_a_of_type_Int = paramInt;
    setLayoutParams(paramViewGroup.getLayoutParams());
  }
  
  private View a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_Afxi.a(0, 0, paramChatMessage, null, this, this.jdField_a_of_type_Aydl);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer instanceof aydm)) {
      ((aydm)this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer).e();
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer = new aydm();
    removeAllViews();
    addView(a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer instanceof aydm)) {
      ((aydm)this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer).e();
    }
  }
  
  public void setOnArkViewTouchListener(aydl paramaydl)
  {
    this.jdField_a_of_type_Aydl = paramaydl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.WrapperArkView
 * JD-Core Version:    0.7.0.1
 */