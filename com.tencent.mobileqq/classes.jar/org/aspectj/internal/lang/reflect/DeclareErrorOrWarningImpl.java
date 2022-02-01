package org.aspectj.internal.lang.reflect;

import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.DeclareErrorOrWarning;
import org.aspectj.lang.reflect.PointcutExpression;

public class DeclareErrorOrWarningImpl
  implements DeclareErrorOrWarning
{
  private AjType declaringType;
  private boolean isError;
  private String msg;
  private PointcutExpression pc;
  
  public DeclareErrorOrWarningImpl(String paramString1, String paramString2, boolean paramBoolean, AjType paramAjType)
  {
    this.pc = new PointcutExpressionImpl(paramString1);
    this.msg = paramString2;
    this.isError = paramBoolean;
    this.declaringType = paramAjType;
  }
  
  public AjType getDeclaringType()
  {
    return this.declaringType;
  }
  
  public String getMessage()
  {
    return this.msg;
  }
  
  public PointcutExpression getPointcutExpression()
  {
    return this.pc;
  }
  
  public boolean isError()
  {
    return this.isError;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("declare ");
    String str;
    if (isError()) {
      str = "error : ";
    } else {
      str = "warning : ";
    }
    localStringBuffer.append(str);
    localStringBuffer.append(getPointcutExpression().asString());
    localStringBuffer.append(" : ");
    localStringBuffer.append("\"");
    localStringBuffer.append(getMessage());
    localStringBuffer.append("\"");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.internal.lang.reflect.DeclareErrorOrWarningImpl
 * JD-Core Version:    0.7.0.1
 */