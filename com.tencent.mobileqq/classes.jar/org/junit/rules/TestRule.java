package org.junit.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public abstract interface TestRule
{
  public abstract Statement apply(Statement paramStatement, Description paramDescription);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.rules.TestRule
 * JD-Core Version:    0.7.0.1
 */