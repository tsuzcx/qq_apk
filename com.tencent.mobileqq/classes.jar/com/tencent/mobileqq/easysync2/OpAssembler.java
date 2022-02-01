package com.tencent.mobileqq.easysync2;

import android.support.annotation.NonNull;

public class OpAssembler
{
  private StringBuilder a = new StringBuilder();
  
  public void a(Operation paramOperation)
  {
    this.a.append(paramOperation.jdField_a_of_type_JavaLangString);
    if (paramOperation.b > 0) {
      this.a.append('|').append(Changeset.a(paramOperation.b));
    }
    this.a.append(paramOperation.jdField_a_of_type_Char);
    this.a.append(Changeset.a(paramOperation.jdField_a_of_type_Int));
  }
  
  public void c()
  {
    this.a.delete(0, this.a.length());
  }
  
  @NonNull
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.OpAssembler
 * JD-Core Version:    0.7.0.1
 */