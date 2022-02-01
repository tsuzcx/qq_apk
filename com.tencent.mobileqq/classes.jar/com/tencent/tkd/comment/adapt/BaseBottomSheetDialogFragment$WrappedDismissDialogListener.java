package com.tencent.tkd.comment.adapt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import java.lang.ref.WeakReference;

class BaseBottomSheetDialogFragment$WrappedDismissDialogListener
  implements DialogInterface.OnDismissListener
{
  private final WeakReference<DialogInterface.OnDismissListener> a;
  
  public BaseBottomSheetDialogFragment$WrappedDismissDialogListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.a = new WeakReference(paramOnDismissListener);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    DialogInterface.OnDismissListener localOnDismissListener = (DialogInterface.OnDismissListener)this.a.get();
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.tkd.comment.adapt.BaseBottomSheetDialogFragment.WrappedDismissDialogListener
 * JD-Core Version:    0.7.0.1
 */