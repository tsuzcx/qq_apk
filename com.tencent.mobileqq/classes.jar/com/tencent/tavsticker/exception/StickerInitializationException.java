package com.tencent.tavsticker.exception;

public class StickerInitializationException
  extends Exception
{
  private String message = "";
  
  public StickerInitializationException() {}
  
  public StickerInitializationException(String paramString)
  {
    super(paramString);
    this.message = paramString;
  }
  
  public StickerInitializationException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public String getMessage()
  {
    return this.message;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.exception.StickerInitializationException
 * JD-Core Version:    0.7.0.1
 */