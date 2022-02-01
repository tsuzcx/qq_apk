package org.junit.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public abstract class Verifier
  implements TestRule
{
  public Statement apply(Statement paramStatement, Description paramDescription)
  {
    return new Verifier.1(this, paramStatement);
  }
  
  protected void verify() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.rules.Verifier
 * JD-Core Version:    0.7.0.1
 */