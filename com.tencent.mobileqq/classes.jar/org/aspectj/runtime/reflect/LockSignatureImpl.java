package org.aspectj.runtime.reflect;

import org.aspectj.lang.reflect.LockSignature;

class LockSignatureImpl
  extends SignatureImpl
  implements LockSignature
{
  private Class parameterType;
  
  LockSignatureImpl(Class paramClass)
  {
    super(8, "lock", paramClass);
    this.parameterType = paramClass;
  }
  
  LockSignatureImpl(String paramString)
  {
    super(paramString);
  }
  
  protected String createToString(StringMaker paramStringMaker)
  {
    if (this.parameterType == null) {
      this.parameterType = extractType(3);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lock(");
    localStringBuilder.append(paramStringMaker.makeTypeName(this.parameterType));
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public Class getParameterType()
  {
    if (this.parameterType == null) {
      this.parameterType = extractType(3);
    }
    return this.parameterType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.reflect.LockSignatureImpl
 * JD-Core Version:    0.7.0.1
 */