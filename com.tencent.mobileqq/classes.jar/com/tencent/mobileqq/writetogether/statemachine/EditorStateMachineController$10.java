package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.writetogether.client.ChangesetScheduler;
import com.tencent.mobileqq.writetogether.client.IScheduler;
import com.tencent.mobileqq.writetogetherui.EditableModifier;
import java.util.List;

class EditorStateMachineController$10
  extends EditorStateMachineController.UneditableStateProcessor
{
  EditorStateMachineController$10(EditorStateMachineController paramEditorStateMachineController, EditorState paramEditorState, List paramList)
  {
    super(paramEditorStateMachineController, paramEditorState, paramList);
  }
  
  public void a()
  {
    super.a();
    EditorStateMachineController.f(this.a).a(1);
  }
  
  public void a(EditorState paramEditorState)
  {
    super.a(paramEditorState);
    EditorStateMachineController.c(this.a).d();
    EditorStateMachineController.c(this.a).a(false, false);
    if (EditorStateMachineController.f(this.a) == null)
    {
      EditorStateMachineController.a(this.a, new ChangesetScheduler());
      EditorStateMachineController.f(this.a).a(this.a);
    }
    EditorStateMachineController.f(this.a).a(1, 60000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.EditorStateMachineController.10
 * JD-Core Version:    0.7.0.1
 */