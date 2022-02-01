package org.junit.internal.runners.statements;

import java.util.Iterator;
import java.util.List;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class RunBefores
  extends Statement
{
  private final List<FrameworkMethod> befores;
  private final Statement next;
  private final Object target;
  
  public RunBefores(Statement paramStatement, List<FrameworkMethod> paramList, Object paramObject)
  {
    this.next = paramStatement;
    this.befores = paramList;
    this.target = paramObject;
  }
  
  public void evaluate()
  {
    Iterator localIterator = this.befores.iterator();
    while (localIterator.hasNext()) {
      ((FrameworkMethod)localIterator.next()).invokeExplosively(this.target, new Object[0]);
    }
    this.next.evaluate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.internal.runners.statements.RunBefores
 * JD-Core Version:    0.7.0.1
 */