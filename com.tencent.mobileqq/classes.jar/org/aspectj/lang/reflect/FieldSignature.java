package org.aspectj.lang.reflect;

import java.lang.reflect.Field;

public abstract interface FieldSignature
  extends MemberSignature
{
  public abstract Field getField();
  
  public abstract Class getFieldType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.FieldSignature
 * JD-Core Version:    0.7.0.1
 */