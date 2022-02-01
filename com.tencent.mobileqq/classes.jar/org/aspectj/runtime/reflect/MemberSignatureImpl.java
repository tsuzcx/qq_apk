package org.aspectj.runtime.reflect;

import org.aspectj.lang.reflect.MemberSignature;

abstract class MemberSignatureImpl
  extends SignatureImpl
  implements MemberSignature
{
  MemberSignatureImpl(int paramInt, String paramString, Class paramClass)
  {
    super(paramInt, paramString, paramClass);
  }
  
  public MemberSignatureImpl(String paramString)
  {
    super(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.reflect.MemberSignatureImpl
 * JD-Core Version:    0.7.0.1
 */