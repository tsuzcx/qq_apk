package com.tencent.mobileqq.qassistant.statemachine;

import android.os.Message;
import android.text.TextUtils;
import java.util.Calendar;

public class StateMachine$LogRec
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private IState jdField_a_of_type_ComTencentMobileqqQassistantStatemachineIState;
  private StateMachine jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
  private String jdField_a_of_type_JavaLangString;
  private IState b;
  private IState c;
  
  StateMachine$LogRec(StateMachine paramStateMachine, Message paramMessage, String paramString, IState paramIState1, IState paramIState2, IState paramIState3)
  {
    a(paramStateMachine, paramMessage, paramString, paramIState1, paramIState2, paramIState3);
  }
  
  public void a(StateMachine paramStateMachine, Message paramMessage, String paramString, IState paramIState1, IState paramIState2, IState paramIState3)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine = paramStateMachine;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    int i;
    if (paramMessage != null) {
      i = paramMessage.what;
    } else {
      i = 0;
    }
    this.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineIState = paramIState1;
    this.b = paramIState2;
    this.c = paramIState3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time=");
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(this.jdField_a_of_type_Long);
    localStringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[] { localObject, localObject, localObject, localObject, localObject, localObject }));
    localStringBuilder.append(" processed=");
    localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineIState;
    String str = "<null>";
    if (localObject == null) {
      localObject = "<null>";
    } else {
      localObject = ((IState)localObject).a();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" org=");
    localObject = this.b;
    if (localObject == null) {
      localObject = "<null>";
    } else {
      localObject = ((IState)localObject).a();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" dest=");
    localObject = this.c;
    if (localObject == null) {
      localObject = str;
    } else {
      localObject = ((IState)localObject).a();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" what=");
    localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
    if (localObject != null) {
      localObject = ((StateMachine)localObject).a(this.jdField_a_of_type_Int);
    } else {
      localObject = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("(0x");
      localStringBuilder.append(Integer.toHexString(this.jdField_a_of_type_Int));
      localStringBuilder.append(")");
    }
    else
    {
      localStringBuilder.append((String)localObject);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.StateMachine.LogRec
 * JD-Core Version:    0.7.0.1
 */