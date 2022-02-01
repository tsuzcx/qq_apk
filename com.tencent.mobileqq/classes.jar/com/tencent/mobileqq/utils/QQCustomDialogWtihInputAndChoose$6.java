package com.tencent.mobileqq.utils;

import android.view.WindowManager;
import com.tencent.mobileqq.qwallet.widget.MyLinearLayout;

class QQCustomDialogWtihInputAndChoose$6
  implements Runnable
{
  QQCustomDialogWtihInputAndChoose$6(QQCustomDialogWtihInputAndChoose paramQQCustomDialogWtihInputAndChoose) {}
  
  public void run()
  {
    if (this.this$0.h == null) {
      return;
    }
    this.this$0.g.addView(this.this$0.e, this.this$0.h);
    QQCustomDialogWtihInputAndChoose localQQCustomDialogWtihInputAndChoose = this.this$0;
    localQQCustomDialogWtihInputAndChoose.i = true;
    localQQCustomDialogWtihInputAndChoose.e.post(new QQCustomDialogWtihInputAndChoose.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.6
 * JD-Core Version:    0.7.0.1
 */