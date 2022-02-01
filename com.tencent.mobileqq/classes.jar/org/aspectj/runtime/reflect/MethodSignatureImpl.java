package org.aspectj.runtime.reflect;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import org.aspectj.lang.reflect.MethodSignature;

class MethodSignatureImpl
  extends CodeSignatureImpl
  implements MethodSignature
{
  private Method method;
  Class returnType;
  
  MethodSignatureImpl(int paramInt, String paramString, Class paramClass1, Class[] paramArrayOfClass1, String[] paramArrayOfString, Class[] paramArrayOfClass2, Class paramClass2)
  {
    super(paramInt, paramString, paramClass1, paramArrayOfClass1, paramArrayOfString, paramArrayOfClass2);
    this.returnType = paramClass2;
  }
  
  MethodSignatureImpl(String paramString)
  {
    super(paramString);
  }
  
  private Method search(Class paramClass, String paramString, Class[] paramArrayOfClass, Set paramSet)
  {
    if (paramClass == null) {
      return null;
    }
    if (!paramSet.contains(paramClass)) {
      paramSet.add(paramClass);
    }
    try
    {
      localMethod = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Method localMethod;
      label37:
      int i;
      break label37;
    }
    localMethod = search(paramClass.getSuperclass(), paramString, paramArrayOfClass, paramSet);
    if (localMethod != null) {
      return localMethod;
    }
    paramClass = paramClass.getInterfaces();
    if (paramClass != null)
    {
      i = 0;
      while (i < paramClass.length)
      {
        localMethod = search(paramClass[i], paramString, paramArrayOfClass, paramSet);
        if (localMethod != null) {
          return localMethod;
        }
        i += 1;
      }
    }
    return null;
  }
  
  protected String createToString(StringMaker paramStringMaker)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramStringMaker.makeModifiersString(getModifiers()));
    if (paramStringMaker.includeArgs) {
      localStringBuffer.append(paramStringMaker.makeTypeName(getReturnType()));
    }
    if (paramStringMaker.includeArgs) {
      localStringBuffer.append(" ");
    }
    localStringBuffer.append(paramStringMaker.makePrimaryTypeName(getDeclaringType(), getDeclaringTypeName()));
    localStringBuffer.append(".");
    localStringBuffer.append(getName());
    paramStringMaker.addSignature(localStringBuffer, getParameterTypes());
    paramStringMaker.addThrows(localStringBuffer, getExceptionTypes());
    return localStringBuffer.toString();
  }
  
  public Method getMethod()
  {
    Class localClass;
    if (this.method == null) {
      localClass = getDeclaringType();
    }
    try
    {
      this.method = localClass.getDeclaredMethod(getName(), getParameterTypes());
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label31:
      HashSet localHashSet;
      break label31;
    }
    localHashSet = new HashSet();
    localHashSet.add(localClass);
    this.method = search(localClass, getName(), getParameterTypes(), localHashSet);
    return this.method;
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
 * Qualified Name:     org.aspectj.runtime.reflect.MethodSignatureImpl
 * JD-Core Version:    0.7.0.1
 */