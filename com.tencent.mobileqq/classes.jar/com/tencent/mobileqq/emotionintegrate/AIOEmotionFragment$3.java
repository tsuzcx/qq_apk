package com.tencent.mobileqq.emotionintegrate;

import android.app.Activity;
import android.widget.PopupWindow;
import android.widget.TextView;

class AIOEmotionFragment$3
  implements Runnable
{
  AIOEmotionFragment$3(AIOEmotionFragment paramAIOEmotionFragment, PopupWindow paramPopupWindow, TextView paramTextView) {}
  
  public void run()
  {
    if (((this.this$0.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!((Activity)this.this$0.jdField_a_of_type_AndroidContentContext).isFinishing())) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAsDropDown(this.this$0.jdField_a_of_type_AndroidWidgetTextView, this.this$0.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() - this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.3
 * JD-Core Version:    0.7.0.1
 */