package com.tencent.mobileqq.qassistant.statemachine;

import com.tencent.qphone.base.util.QLog;

class ShowVoicePanelState$1
  implements Runnable
{
  ShowVoicePanelState$1(ShowVoicePanelState paramShowVoicePanelState) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    ShowVoicePanelState.a((ShowVoicePanelState)localObject, ((ShowVoicePanelState)localObject).a());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterResult = ");
      ((StringBuilder)localObject).append(ShowVoicePanelState.a(this.this$0));
      QLog.d("ShowVoicePanelState", 2, ((StringBuilder)localObject).toString());
    }
    if (ShowVoicePanelState.b(this.this$0) != null) {
      ShowVoicePanelState.b(this.this$0).c(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.ShowVoicePanelState.1
 * JD-Core Version:    0.7.0.1
 */