package com.tencent.mobileqq.utils;

import android.view.KeyEvent;
import com.tencent.mobileqq.qwallet.widget.MyLinearLayout.DispatchKeyEventListener;

class QQCustomDialogWtihInputAndChoose$4
  implements MyLinearLayout.DispatchKeyEventListener
{
  QQCustomDialogWtihInputAndChoose$4(QQCustomDialogWtihInputAndChoose paramQQCustomDialogWtihInputAndChoose) {}
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.a.b))
    {
      this.a.a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.4
 * JD-Core Version:    0.7.0.1
 */