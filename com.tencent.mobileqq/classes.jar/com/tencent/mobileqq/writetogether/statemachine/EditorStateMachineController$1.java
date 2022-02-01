package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.writetogether.statemachine.core.StateMachine;

class EditorStateMachineController$1
  extends TroopObserver
{
  EditorStateMachineController$1(EditorStateMachineController paramEditorStateMachineController) {}
  
  public void onTroopFlagExt3Update(String paramString, long paramLong)
  {
    if ((0x40000000 & paramLong) != 0L)
    {
      EditorStateMachineController.a(this.a).a(EditorState.CLOSED_BY_ADMIN, EditorStateMachineController.a(this.a).getString(2131720730));
      return;
    }
    EditorStateMachineController.a(this.a).a(EditorState.OPEN_BY_ADMIN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.EditorStateMachineController.1
 * JD-Core Version:    0.7.0.1
 */