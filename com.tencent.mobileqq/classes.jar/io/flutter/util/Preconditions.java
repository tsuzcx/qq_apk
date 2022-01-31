package io.flutter.util;

public final class Preconditions
{
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.util.Preconditions
 * JD-Core Version:    0.7.0.1
 */