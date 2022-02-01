package com.tencent.mobileqq.qassistant.statemachine;

import android.os.Message;
import java.util.Vector;

class StateMachine$LogRecords
{
  private int jdField_a_of_type_Int = 20;
  private Vector<StateMachine.LogRec> jdField_a_of_type_JavaUtilVector = new Vector();
  private boolean jdField_a_of_type_Boolean = false;
  private int b = 0;
  private int c = 0;
  
  void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilVector.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void a(StateMachine paramStateMachine, Message paramMessage, String paramString, IState paramIState1, IState paramIState2, IState paramIState3)
  {
    try
    {
      this.c += 1;
      if (this.jdField_a_of_type_JavaUtilVector.size() < this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_JavaUtilVector.add(new StateMachine.LogRec(paramStateMachine, paramMessage, paramString, paramIState1, paramIState2, paramIState3));
      }
      else
      {
        StateMachine.LogRec localLogRec = (StateMachine.LogRec)this.jdField_a_of_type_JavaUtilVector.get(this.b);
        this.b += 1;
        if (this.b >= this.jdField_a_of_type_Int) {
          this.b = 0;
        }
        localLogRec.a(paramStateMachine, paramMessage, paramString, paramIState1, paramIState2, paramIState3);
      }
      return;
    }
    finally {}
  }
  
  boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.StateMachine.LogRecords
 * JD-Core Version:    0.7.0.1
 */