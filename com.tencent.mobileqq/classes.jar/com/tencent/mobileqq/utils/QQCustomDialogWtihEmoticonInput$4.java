package com.tencent.mobileqq.utils;

import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel.DispatchKeyEventListener;

class QQCustomDialogWtihEmoticonInput$4
  implements SystemEmoticonPanel.DispatchKeyEventListener
{
  QQCustomDialogWtihEmoticonInput$4(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.this$0.mIsWindowAdded))
    {
      this.this$0.mWindowManager.removeView(this.this$0.mOldViewEmoSpace);
      this.this$0.mIsWindowAdded = false;
      paramKeyEvent = this.this$0.getWindow().getAttributes();
      paramKeyEvent.y = 0;
      this.this$0.getWindow().setAttributes(paramKeyEvent);
      QQCustomDialogWtihEmoticonInput.access$100(this.this$0);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.4
 * JD-Core Version:    0.7.0.1
 */