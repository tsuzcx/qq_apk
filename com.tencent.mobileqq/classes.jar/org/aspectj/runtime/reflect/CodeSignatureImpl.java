package org.aspectj.runtime.reflect;

import org.aspectj.lang.reflect.CodeSignature;

abstract class CodeSignatureImpl
  extends MemberSignatureImpl
  implements CodeSignature
{
  Class[] exceptionTypes;
  String[] parameterNames;
  Class[] parameterTypes;
  
  CodeSignatureImpl(int paramInt, String paramString, Class paramClass, Class[] paramArrayOfClass1, String[] paramArrayOfString, Class[] paramArrayOfClass2)
  {
    super(paramInt, paramString, paramClass);
    this.parameterTypes = paramArrayOfClass1;
    this.parameterNames = paramArrayOfString;
    this.exceptionTypes = paramArrayOfClass2;
  }
  
  CodeSignatureImpl(String paramString)
  {
    super(paramString);
  }
  
  public Class[] getExceptionTypes()
  {
    if (this.exceptionTypes == null) {
      this.exceptionTypes = extractTypes(5);
    }
    return this.exceptionTypes;
  }
  
  public String[] getParameterNames()
  {
    if (this.parameterNames == null) {
      this.parameterNames = extractStrings(4);
    }
    return this.parameterNames;
  }
  
  public Class[] getParameterTypes()
  {
    if (this.parameterTypes == null) {
      this.parameterTypes = extractTypes(3);
    }
    return this.parameterTypes;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.reflect.CodeSignatureImpl
 * JD-Core Version:    0.7.0.1
 */