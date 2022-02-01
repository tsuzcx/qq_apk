package com.tencent.mtt.hippy.views.modal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

class HippyModalHostManager$2
  implements DialogInterface.OnShowListener
{
  HippyModalHostManager$2(HippyModalHostManager paramHippyModalHostManager, HippyModalHostView paramHippyModalHostView) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    new ShowEvent().send(this.val$hippyModalHostView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.modal.HippyModalHostManager.2
 * JD-Core Version:    0.7.0.1
 */