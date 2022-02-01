package com.tencent.mobileqq.forward;

import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel.DispatchKeyEventListener;

class ForwardNewVersionDialog$3
  implements IEmoticonMainPanel.DispatchKeyEventListener
{
  ForwardNewVersionDialog$3(ForwardNewVersionDialog paramForwardNewVersionDialog) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (ForwardNewVersionDialog.a(this.a)))
    {
      ForwardNewVersionDialog.a(this.a).removeView(ForwardNewVersionDialog.a(this.a).getView());
      ForwardNewVersionDialog.a(this.a, false);
      paramKeyEvent = this.a.getWindow().getAttributes();
      paramKeyEvent.y = 0;
      this.a.getWindow().setAttributes(paramKeyEvent);
      ForwardNewVersionDialog.a(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.3
 * JD-Core Version:    0.7.0.1
 */