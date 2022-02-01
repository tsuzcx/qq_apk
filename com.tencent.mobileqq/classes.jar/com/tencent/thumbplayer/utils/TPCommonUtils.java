package com.tencent.thumbplayer.utils;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.StringReader;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.Map;
import java.util.regex.PatternSyntaxException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;

public class TPCommonUtils
{
  public static final int SDK_INT;
  private static final String TAG = "TPCommonUtils";
  
  static
  {
    if ((Build.VERSION.SDK_INT == 25) && (Build.VERSION.CODENAME.charAt(0) == 'O')) {}
    for (int i = 26;; i = Build.VERSION.SDK_INT)
    {
      SDK_INT = i;
      return;
    }
  }
  
  public static void assertTrue(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static String getMd5(String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      int i;
      try
      {
        paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"));
        localStringBuilder = new StringBuilder(40);
        int j = paramString.length;
        i = 0;
        if (i < j)
        {
          int k = paramString[i];
          if ((k & 0xFF) >> 4 == 0) {
            localStringBuilder.append("0").append(Integer.toHexString(k & 0xFF));
          } else {
            localStringBuilder.append(Integer.toHexString(k & 0xFF));
          }
        }
      }
      catch (Exception paramString)
      {
        TPLogUtil.e("TPCommonUtils", paramString.toString());
        return null;
      }
      paramString = localStringBuilder.toString();
      return paramString;
      i += 1;
    }
  }
  
  public static final String getTaskIdFromDataTransportUrl(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.lastIndexOf("proxy/") <= 0)) {
      return "";
    }
    try
    {
      int i = paramString.indexOf("proxy/") + "proxy/".length();
      paramString = paramString.substring(i, i + 8);
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static boolean isEmpty(Collection<? extends Object> paramCollection)
  {
    return (paramCollection == null) || (paramCollection.size() <= 0);
  }
  
  public static boolean isEmpty(Map<? extends Object, ? extends Object> paramMap)
  {
    return (paramMap == null) || (paramMap.size() <= 0);
  }
  
  public static boolean isUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = paramString.split(":");
      return paramString[0].matches("^((https|http|ftp|rtsp|mms)?)");
    }
    catch (PatternSyntaxException paramString) {}
    return false;
  }
  
  public static boolean isXmlDocument(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        bool1 = bool2;
        if (paramString.contains("<?xml"))
        {
          DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(paramString)));
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static double optDouble(String paramString, double paramDouble)
  {
    double d = paramDouble;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      d = Double.parseDouble(paramString);
      return d;
    }
    catch (NumberFormatException paramString)
    {
      TPLogUtil.e("TPCommonUtils", paramString);
    }
    return paramDouble;
  }
  
  public static float optFloat(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        float f = Float.parseFloat(paramString);
        return f;
      }
      catch (NumberFormatException paramString)
      {
        TPLogUtil.e("TPCommonUtils", paramString);
      }
    }
    return paramInt;
  }
  
  public static int optInt(String paramString, int paramInt)
  {
    int i = paramInt;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public static long optLong(String paramString, long paramLong)
  {
    long l = paramLong;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      TPLogUtil.e("TPCommonUtils", paramString);
    }
    return paramLong;
  }
  
  public static void requireNotNull(Object paramObject, String paramString)
  {
    if (paramObject == null)
    {
      if (!TextUtils.isEmpty(paramString)) {}
      for (;;)
      {
        throw new IllegalArgumentException(paramString);
        paramString = "this argument should not be null!";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPCommonUtils
 * JD-Core Version:    0.7.0.1
 */