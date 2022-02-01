package org.aspectj.runtime.reflect;

import java.lang.reflect.Field;
import org.aspectj.lang.reflect.FieldSignature;

public class FieldSignatureImpl
  extends MemberSignatureImpl
  implements FieldSignature
{
  private Field field;
  Class fieldType;
  
  FieldSignatureImpl(int paramInt, String paramString, Class paramClass1, Class paramClass2)
  {
    super(paramInt, paramString, paramClass1);
    this.fieldType = paramClass2;
  }
  
  FieldSignatureImpl(String paramString)
  {
    super(paramString);
  }
  
  protected String createToString(StringMaker paramStringMaker)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramStringMaker.makeModifiersString(getModifiers()));
    if (paramStringMaker.includeArgs) {
      localStringBuffer.append(paramStringMaker.makeTypeName(getFieldType()));
    }
    if (paramStringMaker.includeArgs) {
      localStringBuffer.append(" ");
    }
    localStringBuffer.append(paramStringMaker.makePrimaryTypeName(getDeclaringType(), getDeclaringTypeName()));
    localStringBuffer.append(".");
    localStringBuffer.append(getName());
    return localStringBuffer.toString();
  }
  
  public Field getField()
  {
    if (this.field == null) {}
    try
    {
      this.field = getDeclaringType().getDeclaredField(getName());
      label22:
      return this.field;
    }
    catch (Exception localException)
    {
      break label22;
    }
  }
  
  public Class getFieldType()
  {
    if (this.fieldType == null) {
      this.fieldType = extractType(3);
    }
    return this.fieldType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.reflect.FieldSignatureImpl
 * JD-Core Version:    0.7.0.1
 */