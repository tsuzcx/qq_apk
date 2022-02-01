package com.tencent.mobileqq.studymode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;

class KidModeAdvanceSettingFragment$7
  implements DialogInterface.OnCancelListener
{
  KidModeAdvanceSettingFragment$7(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface.dismiss();
    KidModeAdvanceSettingFragment.a(this.a).setEnabled(true);
    paramDialogInterface = this.a;
    KidModeAdvanceSettingFragment.a(paramDialogInterface, KidModeAdvanceSettingFragment.a(paramDialogInterface), false, KidModeAdvanceSettingFragment.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment.7
 * JD-Core Version:    0.7.0.1
 */