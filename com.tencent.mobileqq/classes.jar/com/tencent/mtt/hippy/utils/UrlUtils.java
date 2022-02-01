package com.tencent.mtt.hippy.utils;

public class UrlUtils
{
  public static boolean isFileUrl(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() > 6)
      {
        bool1 = bool2;
        if (paramString.substring(0, 7).equalsIgnoreCase("file://")) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean isHttpUrl(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() > 6)
      {
        bool1 = bool2;
        if (paramString.substring(0, 7).equalsIgnoreCase("http://")) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean isHttpsUrl(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() > 7)
      {
        bool1 = bool2;
        if (paramString.substring(0, 8).equalsIgnoreCase("https://")) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean isWebUrl(String paramString)
  {
    return (isHttpUrl(paramString)) || (isHttpsUrl(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.UrlUtils
 * JD-Core Version:    0.7.0.1
 */