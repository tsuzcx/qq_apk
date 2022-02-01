package me.ele.uetool.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import java.lang.ref.WeakReference;

class AttrsDialog$WrappedDismissDialogListener
  implements DialogInterface.OnDismissListener
{
  WeakReference<DialogInterface.OnDismissListener> mRefListener;
  
  AttrsDialog$WrappedDismissDialogListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.mRefListener = new WeakReference(paramOnDismissListener);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.mRefListener != null) && (this.mRefListener.get() != null)) {
      ((DialogInterface.OnDismissListener)this.mRefListener.get()).onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.WrappedDismissDialogListener
 * JD-Core Version:    0.7.0.1
 */