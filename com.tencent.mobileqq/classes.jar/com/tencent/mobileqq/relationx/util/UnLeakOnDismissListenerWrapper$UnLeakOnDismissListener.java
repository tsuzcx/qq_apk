package com.tencent.mobileqq.relationx.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import mqq.util.WeakReference;

public class UnLeakOnDismissListenerWrapper$UnLeakOnDismissListener
  implements DialogInterface.OnDismissListener
{
  WeakReference<DialogInterface.OnDismissListener> jdField_a_of_type_MqqUtilWeakReference;
  
  UnLeakOnDismissListenerWrapper$UnLeakOnDismissListener(UnLeakOnDismissListenerWrapper paramUnLeakOnDismissListenerWrapper, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramOnDismissListener);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    DialogInterface.OnDismissListener localOnDismissListener = (DialogInterface.OnDismissListener)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.util.UnLeakOnDismissListenerWrapper.UnLeakOnDismissListener
 * JD-Core Version:    0.7.0.1
 */