package com.tencent.mobileqq.studymode;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ModeChoiceViewContainer$6
  implements CompoundButton.OnCheckedChangeListener
{
  ModeChoiceViewContainer$6(ModeChoiceViewContainer paramModeChoiceViewContainer) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ModeChoiceViewContainer", 2, new Object[] { "mKidModeChatPINYINSwitch click, isChecked=", Boolean.valueOf(paramBoolean) });
    }
    ModeChoiceViewContainer.d(this.a).a(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeChoiceViewContainer.6
 * JD-Core Version:    0.7.0.1
 */