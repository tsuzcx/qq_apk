package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.writetogether.statemachine.core.StateProcessor;
import com.tencent.mobileqq.writetogetherui.EditableModifier;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class EditorStateMachineController$UneditableStateProcessor
  extends StateProcessor<EditorState>
{
  public EditorStateMachineController$UneditableStateProcessor(EditorState paramEditorState, List<EditorState> paramList)
  {
    super(paramList, localList);
  }
  
  public void a(EditorState paramEditorState)
  {
    EditorStateMachineController.c(this.c).p_(false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onEnter] enter: ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", lastState: ");
      localStringBuilder.append(paramEditorState);
      QLog.d("EditorStateMachineContr", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.EditorStateMachineController.UneditableStateProcessor
 * JD-Core Version:    0.7.0.1
 */