package org.aspectj.internal.lang.reflect;

import org.aspectj.lang.reflect.PerClauseKind;
import org.aspectj.lang.reflect.TypePattern;
import org.aspectj.lang.reflect.TypePatternBasedPerClause;

public class TypePatternBasedPerClauseImpl
  extends PerClauseImpl
  implements TypePatternBasedPerClause
{
  private TypePattern typePattern;
  
  public TypePatternBasedPerClauseImpl(PerClauseKind paramPerClauseKind, String paramString)
  {
    super(paramPerClauseKind);
    this.typePattern = new TypePatternImpl(paramString);
  }
  
  public TypePattern getTypePattern()
  {
    return this.typePattern;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pertypewithin(");
    localStringBuilder.append(this.typePattern.asString());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.internal.lang.reflect.TypePatternBasedPerClauseImpl
 * JD-Core Version:    0.7.0.1
 */