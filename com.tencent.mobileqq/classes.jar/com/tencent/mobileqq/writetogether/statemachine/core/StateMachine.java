package com.tencent.mobileqq.writetogether.statemachine.core;

import android.support.v4.util.SparseArrayCompat;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class StateMachine<E extends Enum>
{
  private SparseArrayCompat<StateProcessor<E>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private E jdField_a_of_type_JavaLangEnum;
  private String jdField_a_of_type_JavaLangString = "EditorStateMachine";
  private SparseArrayCompat<List<E>> jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private E jdField_b_of_type_JavaLangEnum;
  
  public StateMachine(E paramE, String paramString)
  {
    this.jdField_a_of_type_JavaLangEnum = paramE;
    paramE = new StringBuilder();
    paramE.append(this.jdField_a_of_type_JavaLangString);
    paramE.append(".");
    paramE.append(paramString);
    this.jdField_a_of_type_JavaLangString = paramE.toString();
  }
  
  private void a(E paramE, List<E> paramList)
  {
    if (this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat == null) {
      this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
    }
    this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramE.ordinal(), paramList);
  }
  
  private boolean a(E paramE)
  {
    List localList = (List)this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramE.ordinal());
    return (localList != null) && (localList.contains(this.jdField_a_of_type_JavaLangEnum)) && (this.jdField_a_of_type_JavaLangEnum != paramE);
  }
  
  public <T extends StateProcessor<E>> T a(E paramE)
  {
    return (StateProcessor)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramE.ordinal());
  }
  
  public E a()
  {
    return this.jdField_a_of_type_JavaLangEnum;
  }
  
  public void a()
  {
    a(this.jdField_b_of_type_JavaLangEnum);
  }
  
  public void a(int paramInt)
  {
    StateProcessor localStateProcessor = a(this.jdField_a_of_type_JavaLangEnum);
    if (localStateProcessor != null) {
      localStateProcessor.a(paramInt);
    }
  }
  
  public void a(StateProcessor<E> paramStateProcessor)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat == null) {
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
    }
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(((Enum)paramStateProcessor.a()).ordinal(), paramStateProcessor);
    a((Enum)paramStateProcessor.a(), paramStateProcessor.a());
  }
  
  public void a(E paramE)
  {
    a(paramE, null);
  }
  
  public void a(E paramE, String paramString)
  {
    Object localObject;
    if (a(paramE))
    {
      localObject = a(paramE);
      if ((localObject == null) || (!((StateProcessor)localObject).a())) {
        this.jdField_b_of_type_JavaLangEnum = this.jdField_a_of_type_JavaLangEnum;
      }
      this.jdField_a_of_type_JavaLangEnum = paramE;
      paramE = a(this.jdField_b_of_type_JavaLangEnum);
      if (paramE != null) {
        paramE.a();
      }
      if (localObject != null)
      {
        ((StateProcessor)localObject).jdField_a_of_type_JavaLangString = paramString;
        ((StateProcessor)localObject).a(this.jdField_b_of_type_JavaLangEnum);
      }
      if (QLog.isColorLevel())
      {
        paramE = this.jdField_a_of_type_JavaLangString;
        paramString = new StringBuilder();
        paramString.append("[setState] from: ");
        paramString.append(this.jdField_b_of_type_JavaLangEnum);
        paramString.append(" -> to: ");
        paramString.append(this.jdField_a_of_type_JavaLangEnum);
        QLog.d(paramE, 2, paramString.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      paramString = this.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setState] not allowed state trans: from: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangEnum);
      ((StringBuilder)localObject).append(" -> to: ");
      ((StringBuilder)localObject).append(paramE);
      QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public E b()
  {
    return this.jdField_b_of_type_JavaLangEnum;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.core.StateMachine
 * JD-Core Version:    0.7.0.1
 */