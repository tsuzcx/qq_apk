package com.tencent.mobileqq.config;

public class QConfigureException
  extends RuntimeException
{
  public QConfigureException(Exception paramException)
  {
    super(paramException);
  }
  
  public QConfigureException(Exception paramException, String paramString)
  {
    super(paramString, paramException);
  }
  
  public QConfigureException(String paramString)
  {
    super(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigureException
 * JD-Core Version:    0.7.0.1
 */