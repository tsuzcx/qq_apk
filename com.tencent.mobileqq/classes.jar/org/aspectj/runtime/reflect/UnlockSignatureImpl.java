package org.aspectj.runtime.reflect;

import org.aspectj.lang.reflect.UnlockSignature;

class UnlockSignatureImpl
  extends SignatureImpl
  implements UnlockSignature
{
  private Class parameterType;
  
  UnlockSignatureImpl(Class paramClass)
  {
    super(8, "unlock", paramClass);
    this.parameterType = paramClass;
  }
  
  UnlockSignatureImpl(String paramString)
  {
    super(paramString);
  }
  
  protected String createToString(StringMaker paramStringMaker)
  {
    if (this.parameterType == null) {
      this.parameterType = extractType(3);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unlock(");
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
 * Qualified Name:     org.aspectj.runtime.reflect.UnlockSignatureImpl
 * JD-Core Version:    0.7.0.1
 */