package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.writetogetherui.EditableModifier;
import java.util.List;

class EditorStateMachineController$ToastUneditableStateProcessor
  extends EditorStateMachineController.UneditableStateProcessor
{
  public EditorStateMachineController$ToastUneditableStateProcessor(EditorState paramEditorState, List<EditorState> paramList)
  {
    super(paramEditorState, paramList, localList);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt == 0) {
      QQToast.a(EditorStateMachineController.a(this.b), this.a, 0).a();
    }
  }
  
  public void a(EditorState paramEditorState)
  {
    super.a(paramEditorState);
    EditorStateMachineController.a(this.b).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.EditorStateMachineController.ToastUneditableStateProcessor
 * JD-Core Version:    0.7.0.1
 */