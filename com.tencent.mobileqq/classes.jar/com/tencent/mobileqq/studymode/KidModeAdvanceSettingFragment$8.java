package com.tencent.mobileqq.studymode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;

class KidModeAdvanceSettingFragment$8
  implements DialogInterface.OnClickListener
{
  KidModeAdvanceSettingFragment$8(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    KidModeAdvanceSettingFragment.a(this.a).setEnabled(true);
    KidModeAdvanceSettingFragment.a(this.a, KidModeAdvanceSettingFragment.a(this.a), false, KidModeAdvanceSettingFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment.8
 * JD-Core Version:    0.7.0.1
 */