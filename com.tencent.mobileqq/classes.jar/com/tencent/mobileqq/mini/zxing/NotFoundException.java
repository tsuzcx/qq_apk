package com.tencent.mobileqq.mini.zxing;

public final class NotFoundException
  extends ReaderException
{
  private static final NotFoundException INSTANCE = new NotFoundException();
  
  static
  {
    INSTANCE.setStackTrace(NO_TRACE);
  }
  
  public static NotFoundException getNotFoundInstance()
  {
    return INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.NotFoundException
 * JD-Core Version:    0.7.0.1
 */