package org.aspectj.internal.lang.reflect;

import java.util.StringTokenizer;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.DeclarePrecedence;
import org.aspectj.lang.reflect.TypePattern;

public class DeclarePrecedenceImpl
  implements DeclarePrecedence
{
  private AjType<?> declaringType;
  private TypePattern[] precedenceList;
  private String precedenceString;
  
  public DeclarePrecedenceImpl(String paramString, AjType paramAjType)
  {
    this.declaringType = paramAjType;
    this.precedenceString = paramString;
    paramAjType = paramString;
    if (paramString.startsWith("(")) {
      paramAjType = paramString.substring(1, paramString.length() - 1);
    }
    paramString = new StringTokenizer(paramAjType, ",");
    this.precedenceList = new TypePattern[paramString.countTokens()];
    int i = 0;
    for (;;)
    {
      paramAjType = this.precedenceList;
      if (i >= paramAjType.length) {
        break;
      }
      paramAjType[i] = new TypePatternImpl(paramString.nextToken().trim());
      i += 1;
    }
  }
  
  public AjType getDeclaringType()
  {
    return this.declaringType;
  }
  
  public TypePattern[] getPrecedenceOrder()
  {
    return this.precedenceList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("declare precedence : ");
    localStringBuilder.append(this.precedenceString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.internal.lang.reflect.DeclarePrecedenceImpl
 * JD-Core Version:    0.7.0.1
 */