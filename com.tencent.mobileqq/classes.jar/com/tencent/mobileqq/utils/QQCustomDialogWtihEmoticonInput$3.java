package com.tencent.mobileqq.utils;

import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel.DispatchKeyEventListener;

class QQCustomDialogWtihEmoticonInput$3
  implements IEmoticonMainPanel.DispatchKeyEventListener
{
  QQCustomDialogWtihEmoticonInput$3(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.a.w))
    {
      this.a.u.removeView(this.a.r.getView());
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
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.3
 * JD-Core Version:    0.7.0.1
 */