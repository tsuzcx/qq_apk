package com.tencent.smtt.sdk;

import android.os.HandlerThread;

class n
  extends HandlerThread
{
  private static n a;
  
  public n(String paramString)
  {
    super(paramString);
  }
  
  public static n a()
  {
    try
    {
      if (a == null)
      {
        a = new n("TbsHandlerThread");
        a.start();
      }
      n localn = a;
      return localn;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.n
 * JD-Core Version:    0.7.0.1
 */