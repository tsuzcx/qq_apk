package org.junit.rules;

import org.junit.runners.model.Statement;

class Timeout$1
  extends Statement
{
  Timeout$1(Timeout paramTimeout, Exception paramException) {}
  
  public void evaluate()
  {
    throw new RuntimeException("Invalid parameters for Timeout", this.val$e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.rules.Timeout.1
 * JD-Core Version:    0.7.0.1
 */