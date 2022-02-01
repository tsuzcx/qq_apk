package com.tencent.mobileqq.now.message;

import aghc;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import aywe;
import aywf;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

public class WrapperArkView
  extends FrameLayout
{
  int jdField_a_of_type_Int;
  aghc jdField_a_of_type_Aghc;
  private aywe jdField_a_of_type_Aywe;
  MessageForArkApp jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp;
  
  public WrapperArkView(@NonNull Context paramContext, ViewGroup paramViewGroup, MessageForArkApp paramMessageForArkApp, aghc paramaghc, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp = paramMessageForArkApp;
    this.jdField_a_of_type_Aghc = paramaghc;
    this.jdField_a_of_type_Int = paramInt;
    setLayoutParams(paramViewGroup.getLayoutParams());
  }
  
  private View a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_Aghc.a(0, 0, paramChatMessage, null, this, this.jdField_a_of_type_Aywe);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer instanceof aywf)) {
      ((aywf)this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer).e();
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer = new aywf();
    removeAllViews();
    addView(a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer instanceof aywf)) {
      ((aywf)this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer).e();
    }
  }
  
  public void setOnArkViewTouchListener(aywe paramaywe)
  {
    this.jdField_a_of_type_Aywe = paramaywe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.WrapperArkView
 * JD-Core Version:    0.7.0.1
 */