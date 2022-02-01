package com.tencent.mobileqq.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.Switch;

class AppletsSettingFragment$5
  implements DialogInterface.OnClickListener
{
  AppletsSettingFragment$5(AppletsSettingFragment paramAppletsSettingFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = this.a;
      AppletsSettingFragment.a(paramDialogInterface, true ^ AppletsSettingFragment.a(paramDialogInterface));
      paramDialogInterface = this.a;
      AppletsSettingFragment.b(paramDialogInterface, AppletsSettingFragment.a(paramDialogInterface));
      this.a.b.cancel();
      return;
    }
    if (paramInt == 0)
    {
      AppletsSettingFragment.d(this.a).setChecked(AppletsSettingFragment.a(this.a));
      this.a.b.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.AppletsSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */