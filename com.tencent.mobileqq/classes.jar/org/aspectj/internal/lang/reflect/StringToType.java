package org.aspectj.internal.lang.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.StringTokenizer;
import org.aspectj.lang.reflect.AjTypeSystem;

public class StringToType
{
  public static Type[] commaSeparatedListToTypeArray(String paramString, Class paramClass)
  {
    paramString = new StringTokenizer(paramString, ",");
    Type[] arrayOfType = new Type[paramString.countTokens()];
    int i = 0;
    while (paramString.hasMoreTokens())
    {
      arrayOfType[i] = stringToType(paramString.nextToken().trim(), paramClass);
      i += 1;
    }
    return arrayOfType;
  }
  
  private static Type makeParameterizedType(String paramString, Class paramClass)
  {
    int i = paramString.indexOf('<');
    Class localClass = Class.forName(paramString.substring(0, i), false, paramClass.getClassLoader());
    return new StringToType.1(commaSeparatedListToTypeArray(paramString.substring(i + 1, paramString.lastIndexOf('>')), paramClass), localClass);
  }
  
  public static Type stringToType(String paramString, Class paramClass)
  {
    int i = 0;
    try
    {
      if (paramString.indexOf("<") == -1) {
        return AjTypeSystem.getAjType(Class.forName(paramString, false, paramClass.getClassLoader()));
      }
      Type localType = makeParameterizedType(paramString, paramClass);
      return localType;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label33:
      break label33;
    }
    paramClass = paramClass.getTypeParameters();
    while (i < paramClass.length)
    {
      if (paramClass[i].getName().equals(paramString)) {
        return paramClass[i];
      }
      i += 1;
    }
    paramString = new ClassNotFoundException(paramString);
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.internal.lang.reflect.StringToType
 * JD-Core Version:    0.7.0.1
 */