package com.tencent.mobileqq.studymode;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class KidModeAdvanceSettingFragment$10
  implements CompoundButton.OnCheckedChangeListener
{
  KidModeAdvanceSettingFragment$10(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    KidModeAdvanceSettingFragment.b(this.a, 8, paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment.10
 * JD-Core Version:    0.7.0.1
 */