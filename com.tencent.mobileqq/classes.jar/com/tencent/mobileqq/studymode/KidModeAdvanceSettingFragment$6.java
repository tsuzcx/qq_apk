package com.tencent.mobileqq.studymode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;

class KidModeAdvanceSettingFragment$6
  implements DialogInterface.OnClickListener
{
  KidModeAdvanceSettingFragment$6(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    KidModeAdvanceSettingFragment.a(this.a).setEnabled(true);
    paramDialogInterface = this.a;
    KidModeAdvanceSettingFragment.a(paramDialogInterface, KidModeAdvanceSettingFragment.a(paramDialogInterface), false, KidModeAdvanceSettingFragment.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment.6
 * JD-Core Version:    0.7.0.1
 */