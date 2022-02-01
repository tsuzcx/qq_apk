package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.writetogetherconfig.WriteTogetherConfBean;
import com.tencent.mobileqq.writetogetherui.EditableModifier;
import java.util.List;

class EditorStateMachineController$3
  extends EditorStateMachineController.UneditableStateProcessor
{
  EditorStateMachineController$3(EditorStateMachineController paramEditorStateMachineController, EditorState paramEditorState, List paramList)
  {
    super(paramEditorStateMachineController, paramEditorState, paramList);
  }
  
  public void a(EditorState paramEditorState)
  {
    super.a(paramEditorState);
    if (!WriteTogetherConfBean.a(EditorStateMachineController.d(this.a), EditorStateMachineController.e(this.a))) {
      EditorStateMachineController.c(this.a).a(false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.EditorStateMachineController.3
 * JD-Core Version:    0.7.0.1
 */