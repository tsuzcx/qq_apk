package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.writetogether.statemachine.core.StateMachine;
import com.tencent.mobileqq.writetogetherui.ITemplateWhenCreating;
import java.util.Arrays;
import java.util.Collections;

public class CreatingStateMachineController
{
  private StateMachine<CreatingState> jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine;
  private ITemplateWhenCreating jdField_a_of_type_ComTencentMobileqqWritetogetheruiITemplateWhenCreating;
  
  public CreatingStateMachineController(ITemplateWhenCreating paramITemplateWhenCreating)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiITemplateWhenCreating = paramITemplateWhenCreating;
  }
  
  public CreatingState a()
  {
    return (CreatingState)this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine = new StateMachine(CreatingState.TEMPLATE_NO, "CreatingStateMachineController");
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new CreatingStateMachineController.1(this, CreatingState.TEMPLATE_FIRST_USE, Collections.singletonList(CreatingState.TEMPLATE_NO)));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new CreatingStateMachineController.2(this, CreatingState.TEMPLATE_SHOW_ENTRANCE, Arrays.asList(new CreatingState[] { CreatingState.TEMPLATE_NO, CreatingState.TEMPLATE_FIRST_USE, CreatingState.TEMPLATE_SHOW_LAYER })));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new CreatingStateMachineController.3(this, CreatingState.TEMPLATE_SHOW_LAYER, Arrays.asList(new CreatingState[] { CreatingState.TEMPLATE_NO, CreatingState.TEMPLATE_FIRST_USE, CreatingState.TEMPLATE_SHOW_ENTRANCE })));
  }
  
  public void a(CreatingState paramCreatingState)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(paramCreatingState);
  }
  
  public CreatingState b()
  {
    return (CreatingState)this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.CreatingStateMachineController
 * JD-Core Version:    0.7.0.1
 */