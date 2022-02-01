package com.tencent.mobileqq.utils;

import android.view.View;
import android.view.WindowManager;

class QQCustomDialogWtihEmoticonInput$9
  implements Runnable
{
  QQCustomDialogWtihEmoticonInput$9(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput, View paramView) {}
  
  public void run()
  {
    if (QQCustomDialogWtihEmoticonInput.c(this.this$0)) {
      return;
    }
    if (this.this$0.w) {
      return;
    }
    this.this$0.u.addView(this.a, this.this$0.v);
    this.this$0.w = true;
    this.a.post(new QQCustomDialogWtihEmoticonInput.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.9
 * JD-Core Version:    0.7.0.1
 */