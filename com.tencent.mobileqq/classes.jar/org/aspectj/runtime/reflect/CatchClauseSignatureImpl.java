package org.aspectj.runtime.reflect;

import org.aspectj.lang.reflect.CatchClauseSignature;

class CatchClauseSignatureImpl
  extends SignatureImpl
  implements CatchClauseSignature
{
  String parameterName;
  Class parameterType;
  
  CatchClauseSignatureImpl(Class paramClass1, Class paramClass2, String paramString)
  {
    super(0, "catch", paramClass1);
    this.parameterType = paramClass2;
    this.parameterName = paramString;
  }
  
  CatchClauseSignatureImpl(String paramString)
  {
    super(paramString);
  }
  
  protected String createToString(StringMaker paramStringMaker)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("catch(");
    localStringBuilder.append(paramStringMaker.makeTypeName(getParameterType()));
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public String getParameterName()
  {
    if (this.parameterName == null) {
      this.parameterName = extractString(4);
    }
    return this.parameterName;
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
 * Qualified Name:     org.aspectj.runtime.reflect.CatchClauseSignatureImpl
 * JD-Core Version:    0.7.0.1
 */