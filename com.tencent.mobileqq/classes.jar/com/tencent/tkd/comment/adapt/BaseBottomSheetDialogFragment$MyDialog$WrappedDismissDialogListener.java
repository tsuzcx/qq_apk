package com.tencent.tkd.comment.adapt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import java.lang.ref.WeakReference;

class BaseBottomSheetDialogFragment$MyDialog$WrappedDismissDialogListener
  implements DialogInterface.OnDismissListener
{
  private final WeakReference<DialogInterface.OnDismissListener> jdField_a_of_type_JavaLangRefWeakReference;
  
  public BaseBottomSheetDialogFragment$MyDialog$WrappedDismissDialogListener(BaseBottomSheetDialogFragment.MyDialog paramMyDialog, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnDismissListener);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      ((DialogInterface.OnDismissListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.adapt.BaseBottomSheetDialogFragment.MyDialog.WrappedDismissDialogListener
 * JD-Core Version:    0.7.0.1
 */