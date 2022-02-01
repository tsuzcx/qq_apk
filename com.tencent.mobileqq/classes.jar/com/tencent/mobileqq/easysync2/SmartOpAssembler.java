package com.tencent.mobileqq.easysync2;

import android.support.annotation.NonNull;
import com.tencent.util.Pair;
import java.util.List;

public class SmartOpAssembler
  extends OpAssembler
{
  private char jdField_a_of_type_Char;
  private int jdField_a_of_type_Int;
  private MergingOpAssembler jdField_a_of_type_ComTencentMobileqqEasysync2MergingOpAssembler = new MergingOpAssembler();
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private MergingOpAssembler b = new MergingOpAssembler();
  private MergingOpAssembler c = new MergingOpAssembler();
  
  private void a(Operation paramOperation, String paramString)
  {
    int i = paramString.lastIndexOf('\n');
    if (i < 0)
    {
      paramOperation.jdField_a_of_type_Int = paramString.length();
      paramOperation.b = 0;
      a(paramOperation);
      return;
    }
    i += 1;
    paramOperation.jdField_a_of_type_Int = i;
    paramOperation.b = (paramString.split("\n", -1).length - 1);
    a(paramOperation);
    paramOperation.jdField_a_of_type_Int = (paramString.length() - i);
    paramOperation.b = 0;
    a(paramOperation);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.c.toString());
    this.c.c();
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEasysync2MergingOpAssembler.toString());
    this.jdField_a_of_type_ComTencentMobileqqEasysync2MergingOpAssembler.c();
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.b.toString());
    this.b.c();
  }
  
  int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.c.b();
  }
  
  void a(char paramChar, String paramString)
  {
    Operation localOperation = Changeset.a(paramChar);
    localOperation.jdField_a_of_type_JavaLangString = "";
    a(localOperation, paramString);
  }
  
  void a(char paramChar, String paramString, List<Pair<String, String>> paramList, AttribPool paramAttribPool)
  {
    Operation localOperation = Changeset.a(paramChar);
    localOperation.jdField_a_of_type_JavaLangString = Changeset.a(paramChar, paramList, paramAttribPool);
    a(localOperation, paramString);
  }
  
  public void a(Operation paramOperation)
  {
    if (paramOperation.jdField_a_of_type_Char == 0) {
      return;
    }
    if (paramOperation.jdField_a_of_type_Int == 0) {
      return;
    }
    if (paramOperation.jdField_a_of_type_Char == '-')
    {
      if (this.jdField_a_of_type_Char == '=') {
        b();
      }
      this.jdField_a_of_type_ComTencentMobileqqEasysync2MergingOpAssembler.a(paramOperation);
      this.jdField_a_of_type_Int -= paramOperation.jdField_a_of_type_Int;
    }
    else if (paramOperation.jdField_a_of_type_Char == '+')
    {
      if (this.jdField_a_of_type_Char == '=') {
        b();
      }
      this.b.a(paramOperation);
      this.jdField_a_of_type_Int += paramOperation.jdField_a_of_type_Int;
    }
    else if (paramOperation.jdField_a_of_type_Char == '=')
    {
      if (this.jdField_a_of_type_Char != '=') {
        d();
      }
      this.c.a(paramOperation);
    }
    this.jdField_a_of_type_Char = paramOperation.jdField_a_of_type_Char;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqEasysync2MergingOpAssembler.c();
    this.b.c();
    this.c.c();
    StringBuilder localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
    localStringBuilder.delete(0, localStringBuilder.length());
    this.jdField_a_of_type_Int = 0;
  }
  
  @NonNull
  public String toString()
  {
    d();
    b();
    return this.jdField_a_of_type_JavaLangStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.SmartOpAssembler
 * JD-Core Version:    0.7.0.1
 */