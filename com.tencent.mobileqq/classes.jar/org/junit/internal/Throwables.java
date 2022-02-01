package org.junit.internal;

public final class Throwables
{
  private static <T extends Throwable> void rethrow(Throwable paramThrowable)
  {
    throw paramThrowable;
  }
  
  public static Exception rethrowAsException(Throwable paramThrowable)
  {
    rethrow(paramThrowable);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.internal.Throwables
 * JD-Core Version:    0.7.0.1
 */