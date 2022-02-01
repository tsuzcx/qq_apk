package org.aspectj.internal.lang.reflect;

import java.lang.reflect.Method;
import java.util.StringTokenizer;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.Pointcut;
import org.aspectj.lang.reflect.PointcutExpression;

public class PointcutImpl
  implements Pointcut
{
  private final Method baseMethod;
  private final AjType declaringType;
  private final String name;
  private String[] parameterNames = new String[0];
  private final PointcutExpression pc;
  
  protected PointcutImpl(String paramString1, String paramString2, Method paramMethod, AjType paramAjType, String paramString3)
  {
    this.name = paramString1;
    this.pc = new PointcutExpressionImpl(paramString2);
    this.baseMethod = paramMethod;
    this.declaringType = paramAjType;
    this.parameterNames = splitOnComma(paramString3);
  }
  
  private String[] splitOnComma(String paramString)
  {
    paramString = new StringTokenizer(paramString, ",");
    String[] arrayOfString = new String[paramString.countTokens()];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = paramString.nextToken().trim();
      i += 1;
    }
    return arrayOfString;
  }
  
  public AjType getDeclaringType()
  {
    return this.declaringType;
  }
  
  public int getModifiers()
  {
    return this.baseMethod.getModifiers();
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String[] getParameterNames()
  {
    return this.parameterNames;
  }
  
  public AjType<?>[] getParameterTypes()
  {
    Class[] arrayOfClass = this.baseMethod.getParameterTypes();
    AjType[] arrayOfAjType = new AjType[arrayOfClass.length];
    int i = 0;
    while (i < arrayOfAjType.length)
    {
      arrayOfAjType[i] = AjTypeSystem.getAjType(arrayOfClass[i]);
      i += 1;
    }
    return arrayOfAjType;
  }
  
  public PointcutExpression getPointcutExpression()
  {
    return this.pc;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(getName());
    localStringBuffer.append("(");
    AjType[] arrayOfAjType = getParameterTypes();
    int i = 0;
    while (i < arrayOfAjType.length)
    {
      localStringBuffer.append(arrayOfAjType[i].getName());
      String[] arrayOfString = this.parameterNames;
      if ((arrayOfString != null) && (arrayOfString[i] != null))
      {
        localStringBuffer.append(" ");
        localStringBuffer.append(this.parameterNames[i]);
      }
      int j = i + 1;
      i = j;
      if (j < arrayOfAjType.length)
      {
        localStringBuffer.append(",");
        i = j;
      }
    }
    localStringBuffer.append(") : ");
    localStringBuffer.append(getPointcutExpression().asString());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.internal.lang.reflect.PointcutImpl
 * JD-Core Version:    0.7.0.1
 */