package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.writetogether.statemachine.core.StateMachine;
import com.tencent.mobileqq.writetogether.statemachine.core.StateProcessor;
import com.tencent.mobileqq.writetogetherui.EditableModifier;
import java.util.List;

class EditorStateMachineController$7
  extends StateProcessor<EditorState>
{
  EditorStateMachineController$7(EditorStateMachineController paramEditorStateMachineController, EditorState paramEditorState, List paramList)
  {
    super(paramEditorState, paramList);
  }
  
  public void a(EditorState paramEditorState)
  {
    EditorStateMachineController.c(this.a).a(true, false);
    EditorStateMachineController.b(this.a).c();
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.EditorStateMachineController.7
 * JD-Core Version:    0.7.0.1
 */