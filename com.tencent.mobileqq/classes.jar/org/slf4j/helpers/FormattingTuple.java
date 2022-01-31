package org.slf4j.helpers;

public class FormattingTuple
{
  public static FormattingTuple NULL = new FormattingTuple(null);
  private Object[] argArray;
  private String message;
  private Throwable throwable;
  
  public FormattingTuple(String paramString)
  {
    this(paramString, null, null);
  }
  
  public FormattingTuple(String paramString, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    this.message = paramString;
    this.throwable = paramThrowable;
    this.argArray = paramArrayOfObject;
  }
  
  public Object[] getArgArray()
  {
    return this.argArray;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public Throwable getThrowable()
  {
    return this.throwable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.slf4j.helpers.FormattingTuple
 * JD-Core Version:    0.7.0.1
 */