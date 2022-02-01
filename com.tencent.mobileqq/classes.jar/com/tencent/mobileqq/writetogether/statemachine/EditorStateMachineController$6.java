package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.writetogether.WriteTogetherUtils;
import com.tencent.mobileqq.writetogether.statemachine.core.StateMachine;
import com.tencent.mobileqq.writetogether.statemachine.core.StateProcessor;
import com.tencent.mobileqq.writetogetherui.EditableModifier;
import java.util.List;

class EditorStateMachineController$6
  extends StateProcessor<EditorState>
{
  EditorStateMachineController$6(EditorStateMachineController paramEditorStateMachineController, EditorState paramEditorState, List paramList)
  {
    super(paramEditorState, paramList);
  }
  
  public void a(EditorState paramEditorState)
  {
    super.a(paramEditorState);
    if (WriteTogetherUtils.a(EditorStateMachineController.d(this.a), EditorStateMachineController.e(this.a)))
    {
      EditorStateMachineController.c(this.a).a(false, false);
      return;
    }
    EditorStateMachineController.b(this.a).a(EditorState.CLOSED_BY_ADMIN, EditorStateMachineController.a(this.a).getString(2131918131));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.EditorStateMachineController.6
 * JD-Core Version:    0.7.0.1
 */