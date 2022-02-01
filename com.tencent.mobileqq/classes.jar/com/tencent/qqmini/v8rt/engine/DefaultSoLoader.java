package com.tencent.qqmini.v8rt.engine;

public class DefaultSoLoader
  implements LibLoader
{
  public static final String LOG_TAG = "DefaultSoLoader";
  
  public boolean loadSo()
  {
    try
    {
      System.loadLibrary("tv8rt");
      Logger.i("DefaultSoLoader", "loadSo success");
      return true;
    }
    catch (Exception localException)
    {
      Logger.e("DefaultSoLoader", "loadSo Error", localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.DefaultSoLoader
 * JD-Core Version:    0.7.0.1
 */