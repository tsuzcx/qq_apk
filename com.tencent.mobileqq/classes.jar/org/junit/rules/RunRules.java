package org.junit.rules;

import java.util.Iterator;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RunRules
  extends Statement
{
  private final Statement statement;
  
  public RunRules(Statement paramStatement, Iterable<TestRule> paramIterable, Description paramDescription)
  {
    this.statement = applyAll(paramStatement, paramIterable, paramDescription);
  }
  
  private static Statement applyAll(Statement paramStatement, Iterable<TestRule> paramIterable, Description paramDescription)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramStatement = ((TestRule)paramIterable.next()).apply(paramStatement, paramDescription);
    }
    return paramStatement;
  }
  
  public void evaluate()
  {
    this.statement.evaluate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.rules.RunRules
 * JD-Core Version:    0.7.0.1
 */