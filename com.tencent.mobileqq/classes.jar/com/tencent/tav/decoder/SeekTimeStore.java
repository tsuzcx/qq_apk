package com.tencent.tav.decoder;

public class SeekTimeStore
{
  public static volatile boolean ENABLE = true;
  private static volatile long lastSeekTime;
  
  public static void clean()
  {
    try
    {
      lastSeekTime = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int compareNewSeekTime(long paramLong)
  {
    try
    {
      int i;
      if ((ENABLE) && (lastSeekTime != 0L))
      {
        long l = lastSeekTime;
        i = (int)(paramLong - l);
      }
      else
      {
        i = 0;
      }
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static long getLastSeekTime()
  {
    return lastSeekTime;
  }
  
  public static void updateSeekTime(long paramLong)
  {
    try
    {
      lastSeekTime = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.SeekTimeStore
 * JD-Core Version:    0.7.0.1
 */