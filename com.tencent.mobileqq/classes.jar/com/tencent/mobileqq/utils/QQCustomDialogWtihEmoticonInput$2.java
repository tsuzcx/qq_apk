package com.tencent.mobileqq.utils;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

class QQCustomDialogWtihEmoticonInput$2
  implements View.OnTouchListener
{
  QQCustomDialogWtihEmoticonInput$2(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.this$0.mViewEmoBtn.setImageResource(2130840191);
    this.this$0.mViewEmoBtn.setTag(Integer.valueOf(2130840191));
    if (this.this$0.mIsWindowAdded)
    {
      QQCustomDialogWtihEmoticonInput.access$100(this.this$0);
      if (!this.this$0.useAIOStyle) {
        break label110;
      }
      this.this$0.mWindowManager.removeView(this.this$0.mViewEmoSpace);
    }
    for (;;)
    {
      this.this$0.mIsWindowAdded = false;
      paramView = this.this$0.getWindow().getAttributes();
      paramView.y = 0;
      this.this$0.getWindow().setAttributes(paramView);
      return false;
      label110:
      this.this$0.mWindowManager.removeView(this.this$0.mOldViewEmoSpace);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.2
 * JD-Core Version:    0.7.0.1
 */