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
    EditorStateMachineController.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController).a(false, false);
    EditorStateMachineController.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController).k_(false);
    QQToast.a(EditorStateMachineController.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController), this.jdField_a_of_type_JavaLangString, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.EditorStateMachineController.ShowToastWhenMoveToStateProcessor
 * JD-Core Version:    0.7.0.1
 */