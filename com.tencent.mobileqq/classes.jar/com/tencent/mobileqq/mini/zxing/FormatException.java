package com.tencent.mobileqq.mini.zxing;

public final class FormatException
  extends ReaderException
{
  private static final FormatException INSTANCE = new FormatException();
  
  static
  {
    INSTANCE.setStackTrace(NO_TRACE);
  }
  
  private FormatException() {}
  
  private FormatException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public static FormatException getFormatInstance()
  {
    if (isStackTrace) {
      return new FormatException();
    }
    return INSTANCE;
  }
  
  public static FormatException getFormatInstance(Throwable paramThrowable)
  {
    if (isStackTrace) {
      return new FormatException(paramThrowable);
    }
    return INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.FormatException
 * JD-Core Version:    0.7.0.1
 */