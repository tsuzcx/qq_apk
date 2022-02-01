package com.tencent.mtt.tkd.views.modal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.mtt.hippy.views.modal.ShowEvent;

class TkdModalHostManager$2
  implements DialogInterface.OnShowListener
{
  TkdModalHostManager$2(TkdModalHostManager paramTkdModalHostManager, TkdModalHostView paramTkdModalHostView) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    new ShowEvent().send(this.val$hippyModalHostView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.tkd.views.modal.TkdModalHostManager.2
 * JD-Core Version:    0.7.0.1
 */