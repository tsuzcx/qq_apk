package com.tencent.tfd.sdk.wxa;

import android.os.Build;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GalacticCore
{
  public static Map<String, GalacticCore.do> Dd = new ConcurrentHashMap();
  public static Gemini Ed;
  public static String Fd;
  
  static
  {
    Dd.put("C892BA2", new GalacticCore.do(new Lynx()));
    Dd.put("43780D5", new GalacticCore.do(new Lynx()));
    Dd.put("22792AF", new GalacticCore.do(new Leo()));
    Fd = "";
    try
    {
      Fd = void.c(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.GalacticCore
 * JD-Core Version:    0.7.0.1
 */