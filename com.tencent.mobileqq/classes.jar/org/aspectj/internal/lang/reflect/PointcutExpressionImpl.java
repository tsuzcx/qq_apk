package org.aspectj.internal.lang.reflect;

import org.aspectj.lang.reflect.PointcutExpression;

public class PointcutExpressionImpl
  implements PointcutExpression
{
  private String expression;
  
  public PointcutExpressionImpl(String paramString)
  {
    this.expression = paramString;
  }
  
  public String asString()
  {
    return this.expression;
  }
  
  public String toString()
  {
    return asString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.internal.lang.reflect.PointcutExpressionImpl
 * JD-Core Version:    0.7.0.1
 */