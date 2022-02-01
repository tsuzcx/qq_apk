package com.tencent.mobileqq.studymode;

import com.tencent.mobileqq.theme.DarkModeManager.ActionResult;

class ModeChoiceViewContainer$8
  implements DarkModeManager.ActionResult
{
  ModeChoiceViewContainer$8(ModeChoiceViewContainer paramModeChoiceViewContainer, int paramInt1, int paramInt2) {}
  
  public void onCancel()
  {
    ModeChoiceViewContainer.a(this.c, this.a, this.b);
  }
  
  public void onConfirm()
  {
    this.c.g();
    ModeChoiceViewContainer.a(this.c, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeChoiceViewContainer.8
 * JD-Core Version:    0.7.0.1
 */