package com.tencent.smtt.sdk;

import android.os.HandlerThread;

class l
  extends HandlerThread
{
  private static l a;
  
  public l(String paramString)
  {
    super(paramString);
  }
  
  public static l a()
  {
    try
    {
      if (a == null)
      {
        a = new l("TbsHandlerThread");
        a.start();
      }
      l locall = a;
      return locall;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.l
 * JD-Core Version:    0.7.0.1
 */