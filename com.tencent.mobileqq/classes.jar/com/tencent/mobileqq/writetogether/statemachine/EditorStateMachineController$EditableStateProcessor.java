package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.writetogether.statemachine.core.StateProcessor;
import com.tencent.mobileqq.writetogetherui.EditableModifier;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class EditorStateMachineController$EditableStateProcessor
  extends StateProcessor<EditorState>
{
  public EditorStateMachineController$EditableStateProcessor(EditorState paramEditorState, List<EditorState> paramList)
  {
    super(paramList, localList);
  }
  
  public void a(EditorState paramEditorState)
  {
    EditorStateMachineController.a(this.b).i_(true);
    if (QLog.isColorLevel()) {
      QLog.d("EditorStateMachineContr", 2, "[onEnter] enter: " + this.a + ", lastState: " + paramEditorState);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.EditorStateMachineController.EditableStateProcessor
 * JD-Core Version:    0.7.0.1
 */