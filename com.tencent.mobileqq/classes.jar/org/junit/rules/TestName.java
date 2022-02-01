package org.junit.rules;

import org.junit.runner.Description;

public class TestName
  extends TestWatcher
{
  private String name;
  
  public String getMethodName()
  {
    return this.name;
  }
  
  protected void starting(Description paramDescription)
  {
    this.name = paramDescription.getMethodName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.rules.TestName
 * JD-Core Version:    0.7.0.1
 */