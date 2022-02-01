package com.tencent.mobileqq.studymode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.QQToast;

class KidModeAdvanceSettingFragment$5
  implements DialogInterface.OnClickListener
{
  KidModeAdvanceSettingFragment$5(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetSupport(this.b.getBaseActivity()))
    {
      QQToast.makeText(this.b.getBaseActivity(), 1, 2131892157, 1).show();
      KidModeAdvanceSettingFragment.a(this.b).setEnabled(true);
      paramDialogInterface = this.b;
      KidModeAdvanceSettingFragment.a(paramDialogInterface, KidModeAdvanceSettingFragment.a(paramDialogInterface), false, KidModeAdvanceSettingFragment.b(this.b));
      return;
    }
    KidModeAdvanceSettingFragment.b(this.b, this.a);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */