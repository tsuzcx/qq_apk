package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;
import com.tencent.mobileqq.writetogether.statemachine.core.StateMachine;

class EditorStateMachineController$1
  extends TroopPushObserver
{
  EditorStateMachineController$1(EditorStateMachineController paramEditorStateMachineController) {}
  
  protected void a(String paramString, long paramLong)
  {
    if ((paramLong & 0x40000000) != 0L)
    {
      EditorStateMachineController.b(this.a).a(EditorState.CLOSED_BY_ADMIN, EditorStateMachineController.a(this.a).getString(2131918131));
      return;
    }
    EditorStateMachineController.b(this.a).a(EditorState.OPEN_BY_ADMIN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.EditorStateMachineController.1
 * JD-Core Version:    0.7.0.1
 */