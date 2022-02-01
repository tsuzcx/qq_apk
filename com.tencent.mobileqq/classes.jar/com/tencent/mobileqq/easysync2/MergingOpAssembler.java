package com.tencent.mobileqq.easysync2;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.easysync2.utils.Utils;

public class MergingOpAssembler
  extends OpAssembler
{
  int jdField_a_of_type_Int = 0;
  private OpAssembler jdField_a_of_type_ComTencentMobileqqEasysync2OpAssembler = new OpAssembler();
  Operation jdField_a_of_type_ComTencentMobileqqEasysync2Operation = new Operation();
  
  public void a()
  {
    a(false);
  }
  
  public void a(Operation paramOperation)
  {
    Operation localOperation;
    if (paramOperation.jdField_a_of_type_Int > 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation.jdField_a_of_type_Char != paramOperation.jdField_a_of_type_Char) || (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation.jdField_a_of_type_JavaLangString, paramOperation.jdField_a_of_type_JavaLangString))) {
        break label135;
      }
      if (paramOperation.b > 0)
      {
        localOperation = this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation;
        localOperation.jdField_a_of_type_Int += this.jdField_a_of_type_Int + paramOperation.jdField_a_of_type_Int;
        localOperation = this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation;
        localOperation.b += paramOperation.b;
        this.jdField_a_of_type_Int = 0;
      }
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation.b == 0)
    {
      localOperation = this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation;
      localOperation.jdField_a_of_type_Int += paramOperation.jdField_a_of_type_Int;
      return;
    }
    this.jdField_a_of_type_Int += paramOperation.jdField_a_of_type_Int;
    return;
    label135:
    a();
    Changeset.a(paramOperation, this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation.jdField_a_of_type_Char != 0) {
      if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation.jdField_a_of_type_Char != '=') || (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation.jdField_a_of_type_JavaLangString))) {
        break label48;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation.jdField_a_of_type_Char = '\000';
      return;
      label48:
      this.jdField_a_of_type_ComTencentMobileqqEasysync2OpAssembler.a(this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation);
      if (this.jdField_a_of_type_Int > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation.b = 0;
        this.jdField_a_of_type_ComTencentMobileqqEasysync2OpAssembler.a(this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation);
        this.jdField_a_of_type_Int = 0;
      }
    }
  }
  
  public void b()
  {
    a(true);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqEasysync2OpAssembler.c();
    Changeset.a(this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation);
  }
  
  @NonNull
  public String toString()
  {
    a();
    return this.jdField_a_of_type_ComTencentMobileqqEasysync2OpAssembler.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.MergingOpAssembler
 * JD-Core Version:    0.7.0.1
 */