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
    if (paramMessage != null) {}
    for (int i = paramMessage.what;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineIState = paramIState1;
      this.b = paramIState2;
      this.c = paramIState3;
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time=");
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(this.jdField_a_of_type_Long);
    localStringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[] { localObject, localObject, localObject, localObject, localObject, localObject }));
    localStringBuilder.append(" processed=");
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineIState == null)
    {
      localObject = "<null>";
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" org=");
      if (this.b != null) {
        break label247;
      }
      localObject = "<null>";
      label106:
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" dest=");
      if (this.c != null) {
        break label260;
      }
      localObject = "<null>";
      label129:
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" what=");
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine == null) {
        break label273;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a(this.jdField_a_of_type_Int);
      label161:
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label279;
      }
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("(0x");
      localStringBuilder.append(Integer.toHexString(this.jdField_a_of_type_Int));
      localStringBuilder.append(")");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      }
      return localStringBuilder.toString();
      localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineIState.a();
      break;
      label247:
      localObject = this.b.a();
      break label106;
      label260:
      localObject = this.c.a();
      break label129;
      label273:
      localObject = "";
      break label161;
      label279:
      localStringBuilder.append((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.StateMachine.LogRec
 * JD-Core Version:    0.7.0.1
 */