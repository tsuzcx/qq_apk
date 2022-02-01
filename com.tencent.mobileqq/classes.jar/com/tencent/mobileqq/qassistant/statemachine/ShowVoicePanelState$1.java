package com.tencent.mobileqq.qassistant.statemachine;

import bamc;
import bamm;
import com.tencent.qphone.base.util.QLog;

public class ShowVoicePanelState$1
  implements Runnable
{
  public ShowVoicePanelState$1(bamc parambamc) {}
  
  public void run()
  {
    bamc.a(this.this$0, this.this$0.a());
    if (QLog.isColorLevel()) {
      QLog.d("ShowVoicePanelState", 2, "enterResult = " + bamc.a(this.this$0));
    }
    if (bamc.a(this.this$0) != null) {
      bamc.a(this.this$0).a(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.ShowVoicePanelState.1
 * JD-Core Version:    0.7.0.1
 */