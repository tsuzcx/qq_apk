package com.tencent.mtt.hippy.views.modal;

import android.content.DialogInterface;

class HippyModalHostManager$1
  implements HippyModalHostView.OnRequestCloseListener
{
  HippyModalHostManager$1(HippyModalHostManager paramHippyModalHostManager, HippyModalHostView paramHippyModalHostView) {}
  
  public void onRequestClose(DialogInterface paramDialogInterface)
  {
    new RequestCloseEvent().send(this.val$hippyModalHostView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.modal.HippyModalHostManager.1
 * JD-Core Version:    0.7.0.1
 */