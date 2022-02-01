package com.tencent.qqmini.v8rt.engine;

final class SystemClock
{
  private static SystemClock sInstance = new SystemClock();
  
  public static SystemClock g()
  {
    return sInstance;
  }
  
  public long elapsedRealtime()
  {
    return android.os.SystemClock.elapsedRealtime();
  }
  
  public void sleep(long paramLong)
  {
    android.os.SystemClock.sleep(paramLong);
  }
  
  public long uptimeMillis()
  {
    return android.os.SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.SystemClock
 * JD-Core Version:    0.7.0.1
 */