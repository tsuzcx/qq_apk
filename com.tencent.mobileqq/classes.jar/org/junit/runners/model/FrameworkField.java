package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class FrameworkField
  extends FrameworkMember<FrameworkField>
{
  private final Field field;
  
  FrameworkField(Field paramField)
  {
    if (paramField == null) {
      throw new NullPointerException("FrameworkField cannot be created without an underlying field.");
    }
    this.field = paramField;
  }
  
  public Object get(Object paramObject)
  {
    return this.field.get(paramObject);
  }
  
  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    return this.field.getAnnotation(paramClass);
  }
  
  public Annotation[] getAnnotations()
  {
    return this.field.getAnnotations();
  }
  
  public Class<?> getDeclaringClass()
  {
    return this.field.getDeclaringClass();
  }
  
  public Field getField()
  {
    return this.field;
  }
  
  protected int getModifiers()
  {
    return this.field.getModifiers();
  }
  
  public String getName()
  {
    return getField().getName();
  }
  
  public Class<?> getType()
  {
    return this.field.getType();
  }
  
  public boolean isShadowedBy(FrameworkField paramFrameworkField)
  {
    return paramFrameworkField.getName().equals(getName());
  }
  
  public String toString()
  {
    return this.field.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.runners.model.FrameworkField
 * JD-Core Version:    0.7.0.1
 */