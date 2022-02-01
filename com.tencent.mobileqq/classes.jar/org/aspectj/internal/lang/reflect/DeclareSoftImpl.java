package org.aspectj.internal.lang.reflect;

import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.DeclareSoft;
import org.aspectj.lang.reflect.PointcutExpression;

public class DeclareSoftImpl
  implements DeclareSoft
{
  private AjType<?> declaringType;
  private AjType<?> exceptionType;
  private String missingTypeName;
  private PointcutExpression pointcut;
  
  public DeclareSoftImpl(AjType<?> paramAjType, String paramString1, String paramString2)
  {
    this.declaringType = paramAjType;
    this.pointcut = new PointcutExpressionImpl(paramString1);
    try
    {
      this.exceptionType = AjTypeSystem.getAjType(Class.forName(paramString2, false, paramAjType.getJavaClass().getClassLoader()));
      return;
    }
    catch (ClassNotFoundException paramAjType)
    {
      label43:
      break label43;
    }
    this.missingTypeName = paramString2;
  }
  
  public AjType getDeclaringType()
  {
    return this.declaringType;
  }
  
  public PointcutExpression getPointcutExpression()
  {
    return this.pointcut;
  }
  
  public AjType getSoftenedExceptionType()
  {
    String str = this.missingTypeName;
    if (str == null) {
      return this.exceptionType;
    }
    throw new ClassNotFoundException(str);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("declare soft : ");
    String str = this.missingTypeName;
    if (str != null) {
      localStringBuffer.append(this.exceptionType.getName());
    } else {
      localStringBuffer.append(str);
    }
    localStringBuffer.append(" : ");
    localStringBuffer.append(getPointcutExpression().asString());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.internal.lang.reflect.DeclareSoftImpl
 * JD-Core Version:    0.7.0.1
 */