package com.tencent.mtt.tkd.views.modal;

import android.content.DialogInterface;
import com.tencent.mtt.hippy.views.modal.HippyModalHostView.OnRequestCloseListener;
import com.tencent.mtt.hippy.views.modal.RequestCloseEvent;

class TkdModalHostManager$1
  implements HippyModalHostView.OnRequestCloseListener
{
  TkdModalHostManager$1(TkdModalHostManager paramTkdModalHostManager, TkdModalHostView paramTkdModalHostView) {}
  
  public void onRequestClose(DialogInterface paramDialogInterface)
  {
    new RequestCloseEvent().send(this.val$hippyModalHostView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.tkd.views.modal.TkdModalHostManager.1
 * JD-Core Version:    0.7.0.1
 */