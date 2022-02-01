package com.tencent.mobileqq.utils;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

class QQCustomDialogWtihInputAndChoose$1
  implements View.OnTouchListener
{
  QQCustomDialogWtihInputAndChoose$1(QQCustomDialogWtihInputAndChoose paramQQCustomDialogWtihInputAndChoose) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.this$0.mViewInputBtn.setImageResource(2130847214);
    this.this$0.mViewInputBtn.setTag(Integer.valueOf(2130847214));
    this.this$0.hideChooseList();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.1
 * JD-Core Version:    0.7.0.1
 */