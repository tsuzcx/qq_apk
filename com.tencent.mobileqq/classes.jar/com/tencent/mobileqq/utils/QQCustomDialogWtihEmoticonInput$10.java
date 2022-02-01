package com.tencent.mobileqq.utils;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialogWtihEmoticonInput$10
  implements View.OnClickListener
{
  QQCustomDialogWtihEmoticonInput$10(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.this$0.hideSoftInputFromWindow();
    if (this.val$pl != null)
    {
      this.val$pl.onClick(this.this$0, 0);
      if (this.this$0.mIsWindowAdded)
      {
        if (!this.this$0.useAIOStyle) {
          break label100;
        }
        this.this$0.mWindowManager.removeView(this.this$0.mViewEmoSpace);
      }
    }
    for (;;)
    {
      this.this$0.mIsWindowAdded = false;
      try
      {
        if (this.this$0.isShowing()) {
          this.this$0.dismiss();
        }
        label92:
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label100:
        this.this$0.mWindowManager.removeView(this.this$0.mOldViewEmoSpace);
      }
      catch (Exception localException)
      {
        break label92;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.10
 * JD-Core Version:    0.7.0.1
 */