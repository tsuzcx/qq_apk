package com.tencent.mobileqq.studymode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;

class KidModeAdvanceSettingFragment$11
  implements DialogInterface.OnCancelListener
{
  KidModeAdvanceSettingFragment$11(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface.dismiss();
    KidModeAdvanceSettingFragment.a(this.a).setEnabled(true);
    KidModeAdvanceSettingFragment.a(this.a, KidModeAdvanceSettingFragment.a(this.a), false, KidModeAdvanceSettingFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment.11
 * JD-Core Version:    0.7.0.1
 */