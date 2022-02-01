package com.tencent.mobileqq.studymode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.CompoundButton;
import mqq.util.WeakReference;

class ModeChoiceViewContainer$WeakRefSimpleUIDismissListener
  implements DialogInterface.OnDismissListener
{
  WeakReference<ModeChoiceViewContainer> a;
  WeakReference<CompoundButton> b;
  
  ModeChoiceViewContainer$WeakRefSimpleUIDismissListener(ModeChoiceViewContainer paramModeChoiceViewContainer, CompoundButton paramCompoundButton)
  {
    this.a = new WeakReference(paramModeChoiceViewContainer);
    this.b = new WeakReference(paramCompoundButton);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a;
    CompoundButton localCompoundButton = null;
    if (paramDialogInterface == null) {
      paramDialogInterface = null;
    } else {
      paramDialogInterface = (ModeChoiceViewContainer)paramDialogInterface.get();
    }
    WeakReference localWeakReference = this.b;
    if (localWeakReference != null) {
      localCompoundButton = (CompoundButton)localWeakReference.get();
    }
    if ((paramDialogInterface != null) && (localCompoundButton != null)) {
      paramDialogInterface.a(localCompoundButton, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeChoiceViewContainer.WeakRefSimpleUIDismissListener
 * JD-Core Version:    0.7.0.1
 */