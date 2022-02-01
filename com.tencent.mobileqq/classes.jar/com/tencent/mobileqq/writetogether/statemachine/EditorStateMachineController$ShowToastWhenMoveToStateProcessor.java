package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.writetogetherui.EditableModifier;
import java.util.List;

class EditorStateMachineController$ShowToastWhenMoveToStateProcessor
  extends EditorStateMachineController.ToastUneditableStateProcessor
{
  public EditorStateMachineController$ShowToastWhenMoveToStateProcessor(EditorState paramEditorState, List<EditorState> paramList)
  {
    super(paramEditorState, paramList, localList);
  }
  
  public void a(EditorState paramEditorState)
  {
    super.a(paramEditorState);
    EditorStateMachineController.c(this.a).a(false, false);
    EditorStateMachineController.c(this.a).p_(false);
    QQToast.makeText(EditorStateMachineController.a(this.a), this.f, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.EditorStateMachineController.ShowToastWhenMoveToStateProcessor
 * JD-Core Version:    0.7.0.1
 */