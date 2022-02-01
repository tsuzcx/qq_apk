package org.aspectj.lang.reflect;

public class NoSuchAdviceException
  extends Exception
{
  private static final long serialVersionUID = 3256444698657634352L;
  private String name;
  
  public NoSuchAdviceException(String paramString)
  {
    this.name = paramString;
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.NoSuchAdviceException
 * JD-Core Version:    0.7.0.1
 */