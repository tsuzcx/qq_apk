package com.tencent.tkd.comment.adapt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import java.lang.ref.WeakReference;

class BaseBottomSheetDialogFragment$WrappedCancelListener
  implements DialogInterface.OnCancelListener
{
  private final WeakReference<DialogInterface.OnCancelListener> a;
  
  public BaseBottomSheetDialogFragment$WrappedCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.a = new WeakReference(paramOnCancelListener);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    DialogInterface.OnCancelListener localOnCancelListener = (DialogInterface.OnCancelListener)this.a.get();
    if (localOnCancelListener != null) {
      localOnCancelListener.onCancel(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.adapt.BaseBottomSheetDialogFragment.WrappedCancelListener
 * JD-Core Version:    0.7.0.1
 */