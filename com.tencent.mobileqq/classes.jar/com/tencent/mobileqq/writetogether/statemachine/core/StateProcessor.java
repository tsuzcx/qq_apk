package com.tencent.mobileqq.writetogether.statemachine.core;

import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class StateProcessor<E>
{
  protected E a;
  protected String a;
  protected List<E> a;
  
  public StateProcessor(E paramE, List<E> paramList)
  {
    this.jdField_a_of_type_JavaLangObject = paramE;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public E a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  @NonNull
  List<E> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StateProcessor", 2, "[onExit] curState: " + this.jdField_a_of_type_JavaLangObject);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StateProcessor", 2, "[handleEvent] state: " + this.jdField_a_of_type_JavaLangObject + ", event: " + paramInt);
    }
  }
  
  public void a(E paramE)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StateProcessor", 2, "[onEnter] enter: " + this.jdField_a_of_type_JavaLangObject + ", lastState: " + paramE);
    }
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.core.StateProcessor
 * JD-Core Version:    0.7.0.1
 */