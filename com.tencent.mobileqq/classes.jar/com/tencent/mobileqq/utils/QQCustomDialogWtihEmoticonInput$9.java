package com.tencent.mobileqq.utils;

import android.view.View;
import android.view.WindowManager;

class QQCustomDialogWtihEmoticonInput$9
  implements Runnable
{
  QQCustomDialogWtihEmoticonInput$9(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput, View paramView) {}
  
  public void run()
  {
    if (QQCustomDialogWtihEmoticonInput.access$200(this.this$0)) {}
    while (this.this$0.mIsWindowAdded) {
      return;
    }
    this.this$0.mWindowManager.addView(this.val$emotionView, this.this$0.mWindowParams);
    this.this$0.mIsWindowAdded = true;
    this.val$emotionView.post(new QQCustomDialogWtihEmoticonInput.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.9
 * JD-Core Version:    0.7.0.1
 */