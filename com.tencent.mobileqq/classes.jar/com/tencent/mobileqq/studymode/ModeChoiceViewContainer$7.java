package com.tencent.mobileqq.studymode;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;

class ModeChoiceViewContainer$7
  implements Runnable
{
  ModeChoiceViewContainer$7(ModeChoiceViewContainer paramModeChoiceViewContainer) {}
  
  public void run()
  {
    if (ModeChoiceViewContainer.a(this.this$0).isFinishing()) {
      return;
    }
    if ((SimpleUIUtil.e()) && (!this.this$0.f())) {
      this.this$0.a(true, SimpleUIUtil.i());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeChoiceViewContainer.7
 * JD-Core Version:    0.7.0.1
 */