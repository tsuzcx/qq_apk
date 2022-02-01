package com.tencent.qqlive.module.videoreport.storage.annotation;

import java.lang.reflect.Field;

public class FieldMember
  implements Member
{
  private Field field;
  
  public FieldMember(Field paramField)
  {
    if (!paramField.isAccessible()) {
      paramField.setAccessible(true);
    }
    this.field = paramField;
  }
  
  public Object getValue(Object paramObject)
  {
    try
    {
      paramObject = this.field.get(paramObject);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (IllegalArgumentException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.annotation.FieldMember
 * JD-Core Version:    0.7.0.1
 */