package org.aspectj.runtime.reflect;

import java.lang.reflect.Method;
import java.util.StringTokenizer;
import org.aspectj.lang.reflect.AdviceSignature;

class AdviceSignatureImpl
  extends CodeSignatureImpl
  implements AdviceSignature
{
  private Method adviceMethod = null;
  Class returnType;
  
  AdviceSignatureImpl(int paramInt, String paramString, Class paramClass1, Class[] paramArrayOfClass1, String[] paramArrayOfString, Class[] paramArrayOfClass2, Class paramClass2)
  {
    super(paramInt, paramString, paramClass1, paramArrayOfClass1, paramArrayOfString, paramArrayOfClass2);
    this.returnType = paramClass2;
  }
  
  AdviceSignatureImpl(String paramString)
  {
    super(paramString);
  }
  
  private String toAdviceName(String paramString)
  {
    if (paramString.indexOf('$') == -1) {
      return paramString;
    }
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, "$");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str = localStringTokenizer.nextToken();
      if ((str.startsWith("before")) || (str.startsWith("after")) || (str.startsWith("around"))) {
        return str;
      }
    }
    return paramString;
  }
  
  protected String createToString(StringMaker paramStringMaker)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramStringMaker.includeArgs) {
      localStringBuffer.append(paramStringMaker.makeTypeName(getReturnType()));
    }
    if (paramStringMaker.includeArgs) {
      localStringBuffer.append(" ");
    }
    localStringBuffer.append(paramStringMaker.makePrimaryTypeName(getDeclaringType(), getDeclaringTypeName()));
    localStringBuffer.append(".");
    localStringBuffer.append(toAdviceName(getName()));
    paramStringMaker.addSignature(localStringBuffer, getParameterTypes());
    paramStringMaker.addThrows(localStringBuffer, getExceptionTypes());
    return localStringBuffer.toString();
  }
  
  public Method getAdvice()
  {
    if (this.adviceMethod == null) {}
    try
    {
      this.adviceMethod = getDeclaringType().getDeclaredMethod(getName(), getParameterTypes());
      label26:
      return this.adviceMethod;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public Class getReturnType()
  {
    if (this.returnType == null) {
      this.returnType = extractType(6);
    }
    return this.returnType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.reflect.AdviceSignatureImpl
 * JD-Core Version:    0.7.0.1
 */