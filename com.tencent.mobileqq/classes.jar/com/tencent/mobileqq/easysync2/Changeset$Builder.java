package com.tencent.mobileqq.easysync2;

import com.tencent.util.Pair;
import java.util.List;

public class Changeset$Builder
{
  int jdField_a_of_type_Int;
  Operation jdField_a_of_type_ComTencentMobileqqEasysync2Operation = new Operation();
  SmartOpAssembler jdField_a_of_type_ComTencentMobileqqEasysync2SmartOpAssembler = new SmartOpAssembler();
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  
  public Changeset$Builder(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public Builder a(int paramInt1, int paramInt2)
  {
    Operation localOperation = this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation;
    localOperation.jdField_a_of_type_Char = '=';
    localOperation.jdField_a_of_type_JavaLangString = "";
    localOperation.jdField_a_of_type_Int = paramInt1;
    localOperation.b = Math.max(paramInt2, 0);
    this.jdField_a_of_type_ComTencentMobileqqEasysync2SmartOpAssembler.a(this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation);
    return this;
  }
  
  public Builder a(String paramString, List<Pair<String, String>> paramList, AttribPool paramAttribPool)
  {
    this.jdField_a_of_type_ComTencentMobileqqEasysync2SmartOpAssembler.a('+', paramString, paramList, paramAttribPool);
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramString);
    return this;
  }
  
  public Builder b(int paramInt1, int paramInt2)
  {
    Operation localOperation = this.jdField_a_of_type_ComTencentMobileqqEasysync2Operation;
    localOperation.jdField_a_of_type_Char = '-';
    localOperation.jdField_a_of_type_JavaLangString = "";
    localOperation.jdField_a_of_type_Int = paramInt1;
    localOperation.b = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqEasysync2SmartOpAssembler.a(localOperation);
    return this;
  }
  
  public String toString()
  {
    this.jdField_a_of_type_ComTencentMobileqqEasysync2SmartOpAssembler.a();
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_ComTencentMobileqqEasysync2SmartOpAssembler.a();
    return Changeset.a(this.jdField_a_of_type_Int, i + j, this.jdField_a_of_type_ComTencentMobileqqEasysync2SmartOpAssembler.toString(), this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Changeset.Builder
 * JD-Core Version:    0.7.0.1
 */