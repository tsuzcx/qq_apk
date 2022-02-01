package com.tencent.mtt.hippy.views.modal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mtt.hippy.HippyInstanceContext;

class HippyModalHostView$3
  implements DialogInterface.OnKeyListener
{
  HippyModalHostView$3(HippyModalHostView paramHippyModalHostView) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1)
    {
      if (paramInt == 4)
      {
        this.this$0.mOnRequestCloseListener.onRequestClose(paramDialogInterface);
        return true;
      }
      if ((((HippyInstanceContext)this.this$0.getContext()).getBaseContext() instanceof Activity))
      {
        paramDialogInterface = (Activity)((HippyInstanceContext)this.this$0.getContext()).getBaseContext();
        if (paramDialogInterface != null) {
          return paramDialogInterface.onKeyUp(paramInt, paramKeyEvent);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.modal.HippyModalHostView.3
 * JD-Core Version:    0.7.0.1
 */