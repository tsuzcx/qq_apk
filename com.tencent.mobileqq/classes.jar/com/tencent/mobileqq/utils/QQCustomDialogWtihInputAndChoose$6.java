package com.tencent.mobileqq.utils;

import android.view.WindowManager;
import com.tencent.mobileqq.activity.qwallet.widget.MyLinearLayout;

class QQCustomDialogWtihInputAndChoose$6
  implements Runnable
{
  QQCustomDialogWtihInputAndChoose$6(QQCustomDialogWtihInputAndChoose paramQQCustomDialogWtihInputAndChoose) {}
  
  public void run()
  {
    if (this.this$0.mWindowParams == null) {
      return;
    }
    this.this$0.mWindowManager.addView(this.this$0.mChooseLayout, this.this$0.mWindowParams);
    this.this$0.mIsWindowAdded = true;
    this.this$0.mChooseLayout.post(new QQCustomDialogWtihInputAndChoose.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.6
 * JD-Core Version:    0.7.0.1
 */