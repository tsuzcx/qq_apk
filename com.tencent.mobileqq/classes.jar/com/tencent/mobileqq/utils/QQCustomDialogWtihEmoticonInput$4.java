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
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.a.c))
    {
      this.a.jdField_a_of_type_AndroidViewWindowManager.removeView(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel);
      paramKeyEvent = this.a;
      paramKeyEvent.c = false;
      paramKeyEvent = paramKeyEvent.getWindow().getAttributes();
      paramKeyEvent.y = 0;
      this.a.getWindow().setAttributes(paramKeyEvent);
      QQCustomDialogWtihEmoticonInput.a(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.4
 * JD-Core Version:    0.7.0.1
 */