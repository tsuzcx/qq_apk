package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.List;

class EditorStateMachineController$DialogUneditableStateProcessor
  extends EditorStateMachineController.UneditableStateProcessor
{
  public EditorStateMachineController$DialogUneditableStateProcessor(EditorState paramEditorState, List<EditorState> paramList)
  {
    super(paramEditorState, paramList, localList);
  }
  
  public void a(EditorState paramEditorState)
  {
    super.a(paramEditorState);
    DialogUtil.a(EditorStateMachineController.a(this.a), 233, null, this.f, new EditorStateMachineController.DialogUneditableStateProcessor.1(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.EditorStateMachineController.DialogUneditableStateProcessor
 * JD-Core Version:    0.7.0.1
 */