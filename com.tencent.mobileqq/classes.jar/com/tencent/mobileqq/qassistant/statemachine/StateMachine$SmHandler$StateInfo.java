package com.tencent.mobileqq.qassistant.statemachine;

class StateMachine$SmHandler$StateInfo
{
  State jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState;
  StateInfo jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo;
  boolean jdField_a_of_type_Boolean;
  
  private StateMachine$SmHandler$StateInfo(StateMachine.SmHandler paramSmHandler) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState.a());
    localStringBuilder.append(",active=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",parent=");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((StateInfo)localObject).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState.a();
    }
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.StateMachine.SmHandler.StateInfo
 * JD-Core Version:    0.7.0.1
 */