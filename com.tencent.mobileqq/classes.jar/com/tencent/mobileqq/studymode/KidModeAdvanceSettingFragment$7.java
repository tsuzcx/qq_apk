package com.tencent.mobileqq.studymode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;

class KidModeAdvanceSettingFragment$7
  implements DialogInterface.OnClickListener
{
  KidModeAdvanceSettingFragment$7(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    KidModeAdvanceSettingFragment.b(this.a, true);
    KidModeAdvanceSettingFragment.a(this.a).setEnabled(true);
    KidModeAdvanceSettingFragment.a(this.a, KidModeAdvanceSettingFragment.a(this.a), false, KidModeAdvanceSettingFragment.a(this.a));
    PhoneUnityManager.a(this.a.getActivity(), KidModeAdvanceSettingFragment.a(this.a), StudyModeManager.b(), 2002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment.7
 * JD-Core Version:    0.7.0.1
 */