package org.aspectj.internal.lang.reflect;

import org.aspectj.lang.reflect.PerClauseKind;
import org.aspectj.lang.reflect.PointcutBasedPerClause;
import org.aspectj.lang.reflect.PointcutExpression;

public class PointcutBasedPerClauseImpl
  extends PerClauseImpl
  implements PointcutBasedPerClause
{
  private final PointcutExpression pointcutExpression;
  
  public PointcutBasedPerClauseImpl(PerClauseKind paramPerClauseKind, String paramString)
  {
    super(paramPerClauseKind);
    this.pointcutExpression = new PointcutExpressionImpl(paramString);
  }
  
  public PointcutExpression getPointcutExpression()
  {
    return this.pointcutExpression;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = PointcutBasedPerClauseImpl.1.$SwitchMap$org$aspectj$lang$reflect$PerClauseKind[getKind().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            localStringBuffer.append("perthis(");
          }
        }
        else {
          localStringBuffer.append("pertarget(");
        }
      }
      else {
        localStringBuffer.append("percflowbelow(");
      }
    }
    else {
      localStringBuffer.append("percflow(");
    }
    localStringBuffer.append(this.pointcutExpression.asString());
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.internal.lang.reflect.PointcutBasedPerClauseImpl
 * JD-Core Version:    0.7.0.1
 */