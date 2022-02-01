package com.tencent.mobileqq.studymode;

import android.widget.CompoundButton;
import com.tencent.mobileqq.theme.DarkModeManager.ActionResult;

class ModeChoiceViewContainer$3$1
  implements DarkModeManager.ActionResult
{
  ModeChoiceViewContainer$3$1(ModeChoiceViewContainer.3 param3, CompoundButton paramCompoundButton, boolean paramBoolean, int paramInt) {}
  
  public void onCancel()
  {
    this.d.a.a(this.a, false);
  }
  
  public void onConfirm()
  {
    this.d.a.g();
    ModeChoiceViewContainer.a(this.d.a, this.a, true, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeChoiceViewContainer.3.1
 * JD-Core Version:    0.7.0.1
 */