package com.tencent.sonic.sdk;

class SonicEngine$1
  implements Runnable
{
  SonicEngine$1(SonicEngine paramSonicEngine, SonicDBHelper paramSonicDBHelper) {}
  
  public void run()
  {
    try
    {
      this.val$helper.getWritableDatabase();
      return;
    }
    catch (Throwable localThrowable)
    {
      SonicUtils.log("SonicSdk_SonicEngine", 6, "initSonicDB getWritableDatabase encounter error." + localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicEngine.1
 * JD-Core Version:    0.7.0.1
 */