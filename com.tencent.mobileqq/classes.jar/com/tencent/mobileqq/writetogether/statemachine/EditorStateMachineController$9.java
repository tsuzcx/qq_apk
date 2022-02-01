package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.writetogether.statemachine.core.StateMachine;
import com.tencent.mobileqq.writetogether.statemachine.core.StateProcessor;
import java.util.List;

class EditorStateMachineController$9
  extends StateProcessor<EditorState>
{
  EditorStateMachineController$9(EditorStateMachineController paramEditorStateMachineController, EditorState paramEditorState, List paramList)
  {
    super(paramEditorState, paramList);
  }
  
  public void a(EditorState paramEditorState)
  {
    super.a(paramEditorState);
    EditorStateMachineController.b(this.a).c();
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.EditorStateMachineController.9
 * JD-Core Version:    0.7.0.1
 */