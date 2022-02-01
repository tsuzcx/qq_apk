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
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.a.w))
    {
      this.a.u.removeView(this.a.q);
      paramKeyEvent = this.a;
      paramKeyEvent.w = false;
      paramKeyEvent = paramKeyEvent.getWindow().getAttributes();
      paramKeyEvent.y = 0;
      this.a.getWindow().setAttributes(paramKeyEvent);
      QQCustomDialogWtihEmoticonInput.b(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.4
 * JD-Core Version:    0.7.0.1
 */