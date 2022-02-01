package com.tencent.mobileqq.mini.zxing;

public final class ChecksumException
  extends ReaderException
{
  private static final ChecksumException INSTANCE = new ChecksumException();
  
  static
  {
    INSTANCE.setStackTrace(NO_TRACE);
  }
  
  private ChecksumException() {}
  
  private ChecksumException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public static ChecksumException getChecksumInstance()
  {
    if (isStackTrace) {
      return new ChecksumException();
    }
    return INSTANCE;
  }
  
  public static ChecksumException getChecksumInstance(Throwable paramThrowable)
  {
    if (isStackTrace) {
      return new ChecksumException(paramThrowable);
    }
    return INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.ChecksumException
 * JD-Core Version:    0.7.0.1
 */