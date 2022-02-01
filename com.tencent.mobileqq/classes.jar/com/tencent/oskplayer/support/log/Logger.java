package com.tencent.oskplayer.support.log;

public class Logger
{
  private static ILogger sLogger = null;
  
  public static ILogger g()
  {
    if (sLogger == null) {}
    try
    {
      if (sLogger == null) {
        sLogger = new DefaultLogger();
      }
      return sLogger;
    }
    finally {}
  }
  
  public static void setLogger(ILogger paramILogger)
  {
    try
    {
      sLogger = paramILogger;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.support.log.Logger
 * JD-Core Version:    0.7.0.1
 */