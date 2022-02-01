package org.aspectj.runtime.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import org.aspectj.lang.reflect.InitializerSignature;

class InitializerSignatureImpl
  extends CodeSignatureImpl
  implements InitializerSignature
{
  private Constructor constructor;
  
  InitializerSignatureImpl(int paramInt, Class paramClass)
  {
    super(paramInt, str, paramClass, EMPTY_CLASS_ARRAY, EMPTY_STRING_ARRAY, EMPTY_CLASS_ARRAY);
  }
  
  InitializerSignatureImpl(String paramString)
  {
    super(paramString);
  }
  
  protected String createToString(StringMaker paramStringMaker)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramStringMaker.makeModifiersString(getModifiers()));
    localStringBuffer.append(paramStringMaker.makePrimaryTypeName(getDeclaringType(), getDeclaringTypeName()));
    localStringBuffer.append(".");
    localStringBuffer.append(getName());
    return localStringBuffer.toString();
  }
  
  public Constructor getInitializer()
  {
    if (this.constructor == null) {}
    try
    {
      this.constructor = getDeclaringType().getDeclaredConstructor(getParameterTypes());
      label22:
      return this.constructor;
    }
    catch (Exception localException)
    {
      break label22;
    }
  }
  
  public String getName()
  {
    if (Modifier.isStatic(getModifiers())) {
      return "<clinit>";
    }
    return "<init>";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.reflect.InitializerSignatureImpl
 * JD-Core Version:    0.7.0.1
 */