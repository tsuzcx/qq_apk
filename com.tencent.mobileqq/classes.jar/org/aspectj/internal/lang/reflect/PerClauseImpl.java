package org.aspectj.internal.lang.reflect;

import org.aspectj.lang.reflect.PerClause;
import org.aspectj.lang.reflect.PerClauseKind;

public class PerClauseImpl
  implements PerClause
{
  private final PerClauseKind kind;
  
  protected PerClauseImpl(PerClauseKind paramPerClauseKind)
  {
    this.kind = paramPerClauseKind;
  }
  
  public PerClauseKind getKind()
  {
    return this.kind;
  }
  
  public String toString()
  {
    return "issingleton()";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.internal.lang.reflect.PerClauseImpl
 * JD-Core Version:    0.7.0.1
 */