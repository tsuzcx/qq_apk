package com.tencent.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ActionSheetAdapter$CustomDismissListener
  implements DialogInterface.OnDismissListener
{
  private WeakReference<DialogInterface.OnDismissListener> a;
  
  public ActionSheetAdapter$CustomDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.a = new WeakReference(paramOnDismissListener);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    DialogInterface.OnDismissListener localOnDismissListener = (DialogInterface.OnDismissListener)this.a.get();
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss(paramDialogInterface);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("Q.dating", 2, "CustomDismissListener, lis is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.ActionSheetAdapter.CustomDismissListener
 * JD-Core Version:    0.7.0.1
 */