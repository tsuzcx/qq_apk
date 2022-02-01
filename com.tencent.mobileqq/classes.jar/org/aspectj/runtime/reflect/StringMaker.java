package org.aspectj.runtime.reflect;

import java.lang.reflect.Modifier;

class StringMaker
{
  static StringMaker longStringMaker;
  static StringMaker middleStringMaker;
  static StringMaker shortStringMaker = new StringMaker();
  int cacheOffset;
  boolean includeArgs = true;
  boolean includeEnclosingPoint = true;
  boolean includeJoinPointTypeName = true;
  boolean includeModifiers = false;
  boolean includeThrows = false;
  boolean shortKindName = true;
  boolean shortPrimaryTypeNames = false;
  boolean shortTypeNames = true;
  
  static
  {
    StringMaker localStringMaker = shortStringMaker;
    localStringMaker.shortTypeNames = true;
    localStringMaker.includeArgs = false;
    localStringMaker.includeThrows = false;
    localStringMaker.includeModifiers = false;
    localStringMaker.shortPrimaryTypeNames = true;
    localStringMaker.includeJoinPointTypeName = false;
    localStringMaker.includeEnclosingPoint = false;
    localStringMaker.cacheOffset = 0;
    middleStringMaker = new StringMaker();
    localStringMaker = middleStringMaker;
    localStringMaker.shortTypeNames = true;
    localStringMaker.includeArgs = true;
    localStringMaker.includeThrows = false;
    localStringMaker.includeModifiers = false;
    localStringMaker.shortPrimaryTypeNames = false;
    shortStringMaker.cacheOffset = 1;
    longStringMaker = new StringMaker();
    localStringMaker = longStringMaker;
    localStringMaker.shortTypeNames = false;
    localStringMaker.includeArgs = true;
    localStringMaker.includeThrows = false;
    localStringMaker.includeModifiers = true;
    localStringMaker.shortPrimaryTypeNames = false;
    localStringMaker.shortKindName = false;
    localStringMaker.cacheOffset = 2;
  }
  
  public void addSignature(StringBuffer paramStringBuffer, Class[] paramArrayOfClass)
  {
    if (paramArrayOfClass == null) {
      return;
    }
    if (!this.includeArgs)
    {
      if (paramArrayOfClass.length == 0)
      {
        paramStringBuffer.append("()");
        return;
      }
      paramStringBuffer.append("(..)");
      return;
    }
    paramStringBuffer.append("(");
    addTypeNames(paramStringBuffer, paramArrayOfClass);
    paramStringBuffer.append(")");
  }
  
  public void addThrows(StringBuffer paramStringBuffer, Class[] paramArrayOfClass)
  {
    if ((this.includeThrows) && (paramArrayOfClass != null))
    {
      if (paramArrayOfClass.length == 0) {
        return;
      }
      paramStringBuffer.append(" throws ");
      addTypeNames(paramStringBuffer, paramArrayOfClass);
    }
  }
  
  public void addTypeNames(StringBuffer paramStringBuffer, Class[] paramArrayOfClass)
  {
    int i = 0;
    while (i < paramArrayOfClass.length)
    {
      if (i > 0) {
        paramStringBuffer.append(", ");
      }
      paramStringBuffer.append(makeTypeName(paramArrayOfClass[i]));
      i += 1;
    }
  }
  
  String makeKindName(String paramString)
  {
    int i = paramString.lastIndexOf('-');
    if (i == -1) {
      return paramString;
    }
    return paramString.substring(i + 1);
  }
  
  String makeModifiersString(int paramInt)
  {
    if (!this.includeModifiers) {
      return "";
    }
    String str = Modifier.toString(paramInt);
    if (str.length() == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
  
  public String makePrimaryTypeName(Class paramClass, String paramString)
  {
    return makeTypeName(paramClass, paramString, this.shortPrimaryTypeNames);
  }
  
  public String makeTypeName(Class paramClass)
  {
    return makeTypeName(paramClass, paramClass.getName(), this.shortTypeNames);
  }
  
  String makeTypeName(Class paramClass, String paramString, boolean paramBoolean)
  {
    if (paramClass == null) {
      return "ANONYMOUS";
    }
    if (paramClass.isArray())
    {
      paramClass = paramClass.getComponentType();
      paramString = new StringBuilder();
      paramString.append(makeTypeName(paramClass, paramClass.getName(), paramBoolean));
      paramString.append("[]");
      return paramString.toString();
    }
    if (paramBoolean) {
      return stripPackageName(paramString).replace('$', '.');
    }
    return paramString.replace('$', '.');
  }
  
  String stripPackageName(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    if (i == -1) {
      return paramString;
    }
    return paramString.substring(i + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.reflect.StringMaker
 * JD-Core Version:    0.7.0.1
 */