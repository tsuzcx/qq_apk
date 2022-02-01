package com.tencent.open;

import com.tencent.open.data.SharedPrefs;

public class OpenProxy
{
  private static OpenProxy a;
  
  public static OpenProxy a()
  {
    try
    {
      if (a == null) {
        a = new OpenProxy();
      }
      OpenProxy localOpenProxy = a;
      return localOpenProxy;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    SharedPrefs.b(paramString);
  }
  
  public void b(String paramString)
  {
    SharedPrefs.d(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.OpenProxy
 * JD-Core Version:    0.7.0.1
 */