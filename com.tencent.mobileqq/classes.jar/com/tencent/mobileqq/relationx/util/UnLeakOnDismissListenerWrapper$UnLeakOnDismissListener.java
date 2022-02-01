package com.tencent.mobileqq.relationx.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import mqq.util.WeakReference;

public class UnLeakOnDismissListenerWrapper$UnLeakOnDismissListener
  implements DialogInterface.OnDismissListener
{
  WeakReference<DialogInterface.OnDismissListener> a;
  
  UnLeakOnDismissListenerWrapper$UnLeakOnDismissListener(UnLeakOnDismissListenerWrapper paramUnLeakOnDismissListenerWrapper, DialogInterface.OnDismissListener paramOnDismissListener)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.util.UnLeakOnDismissListenerWrapper.UnLeakOnDismissListener
 * JD-Core Version:    0.7.0.1
 */