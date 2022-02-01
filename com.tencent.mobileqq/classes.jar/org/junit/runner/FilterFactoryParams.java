package org.junit.runner;

public final class FilterFactoryParams
{
  private final String args;
  private final Description topLevelDescription;
  
  public FilterFactoryParams(Description paramDescription, String paramString)
  {
    if ((paramString == null) || (paramDescription == null)) {
      throw new NullPointerException();
    }
    this.topLevelDescription = paramDescription;
    this.args = paramString;
  }
  
  public String getArgs()
  {
    return this.args;
  }
  
  public Description getTopLevelDescription()
  {
    return this.topLevelDescription;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.runner.FilterFactoryParams
 * JD-Core Version:    0.7.0.1
 */