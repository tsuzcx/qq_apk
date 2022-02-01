package com.tencent.mobileqq.easysync2;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Operation
{
  char jdField_a_of_type_Char;
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString = "";
  int b;
  
  void a()
  {
    this.jdField_a_of_type_Char = '\000';
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Operation)) {
      return false;
    }
    Object localObject = (Operation)paramObject;
    if ((this.jdField_a_of_type_Char == ((Operation)localObject).jdField_a_of_type_Char) && (this.jdField_a_of_type_Int == ((Operation)localObject).jdField_a_of_type_Int) && (this.b == ((Operation)localObject).b))
    {
      paramObject = this.jdField_a_of_type_JavaLangString;
      localObject = ((Operation)localObject).jdField_a_of_type_JavaLangString;
      if (paramObject == localObject) {
        return bool;
      }
      if ((paramObject != null) && (paramObject.equals(localObject))) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[opcode=");
    localStringBuilder.append(this.jdField_a_of_type_Char);
    localStringBuilder.append(", chars=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",lines=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", attribs=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Operation
 * JD-Core Version:    0.7.0.1
 */