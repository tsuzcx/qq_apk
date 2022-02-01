package com.tencent.tkd.comment.adapt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import java.lang.ref.WeakReference;

class BaseBottomSheetDialogFragment$MyDialog$WrappedCancelListener
  implements DialogInterface.OnCancelListener
{
  private final WeakReference<DialogInterface.OnCancelListener> jdField_a_of_type_JavaLangRefWeakReference;
  
  public BaseBottomSheetDialogFragment$MyDialog$WrappedCancelListener(BaseBottomSheetDialogFragment.MyDialog paramMyDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnCancelListener);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      ((DialogInterface.OnCancelListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).onCancel(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.adapt.BaseBottomSheetDialogFragment.MyDialog.WrappedCancelListener
 * JD-Core Version:    0.7.0.1
 */