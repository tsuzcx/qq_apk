package com.tencent.mobileqq.qassistant.statemachine;

import com.tencent.qphone.base.util.QLog;

class ShowVoicePanelState$1
  implements Runnable
{
  ShowVoicePanelState$1(ShowVoicePanelState paramShowVoicePanelState) {}
  
  public void run()
  {
    ShowVoicePanelState.a(this.this$0, this.this$0.a());
    if (QLog.isColorLevel()) {
      QLog.d("ShowVoicePanelState", 2, "enterResult = " + ShowVoicePanelState.a(this.this$0));
    }
    if (ShowVoicePanelState.a(this.this$0) != null) {
      ShowVoicePanelState.a(this.this$0).a(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.ShowVoicePanelState.1
 * JD-Core Version:    0.7.0.1
 */