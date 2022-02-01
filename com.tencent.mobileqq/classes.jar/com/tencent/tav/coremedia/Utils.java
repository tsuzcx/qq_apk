package com.tencent.tav.coremedia;

public class Utils
{
  public static void checkNotNull(Object paramObject)
  {
    if (paramObject != null) {
      return;
    }
    Logger.e("CoreMedia", "obj is null!", new NullPointerException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.coremedia.Utils
 * JD-Core Version:    0.7.0.1
 */