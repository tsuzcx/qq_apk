package com.tencent.mobileqq.studymode;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class KidModeAdvanceSettingFragment$2
  implements CompoundButton.OnCheckedChangeListener
{
  KidModeAdvanceSettingFragment$2(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!NetworkUtil.isNetSupport(this.a.getBaseActivity()))
    {
      QQToast.makeText(this.a.getBaseActivity(), 1, 2131892157, 1).show();
      KidModeAdvanceSettingFragment localKidModeAdvanceSettingFragment = this.a;
      KidModeAdvanceSettingFragment.a(localKidModeAdvanceSettingFragment, KidModeAdvanceSettingFragment.a(localKidModeAdvanceSettingFragment), paramBoolean ^ true, KidModeAdvanceSettingFragment.b(this.a));
    }
    else
    {
      paramCompoundButton.setEnabled(false);
      KidModeAdvanceSettingFragment.a(this.a, 4);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */