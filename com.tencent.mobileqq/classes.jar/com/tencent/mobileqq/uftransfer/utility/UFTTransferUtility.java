package com.tencent.mobileqq.uftransfer.utility;

import android.text.TextUtils;
import java.io.File;

public class UFTTransferUtility
{
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if (!paramString.startsWith("H_")) {
      return 0;
    }
    int i = paramString.indexOf("_");
    if (i == -1) {
      return 0;
    }
    int j = paramString.lastIndexOf("_");
    if (i == j) {
      return 0;
    }
    paramString = paramString.substring(j);
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static long a(String paramString)
  {
    long l2 = 0L;
    if (paramString == null) {
      return 0L;
    }
    try
    {
      paramString = new File(paramString);
      long l1 = l2;
      if (paramString.exists())
      {
        l1 = l2;
        if (paramString.length() > 0L) {
          l1 = paramString.length();
        }
      }
      return l1;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public static UFTTransferUtility.UrlHostInfo a(String paramString)
  {
    UFTTransferUtility.UrlHostInfo localUrlHostInfo = new UFTTransferUtility.UrlHostInfo();
    if (TextUtils.isEmpty(paramString)) {
      return localUrlHostInfo;
    }
    String str1 = null;
    String str2;
    label271:
    label278:
    do
    {
      for (;;)
      {
        try
        {
          i = paramString.indexOf("://");
          if (i != -1) {
            break label271;
          }
          i = 0;
          str2 = paramString.substring(i);
          k = str2.indexOf("/");
          int j = k;
          if (-1 == k) {
            j = str2.length() - 1;
          }
          k = paramString.indexOf("&bHost=");
          if (-1 == k) {
            break label278;
          }
          int m = paramString.indexOf("&bPort=", k);
          if (-1 == m) {
            break label278;
          }
          str1 = paramString.substring(k + 7, m);
          str2 = paramString.substring(m + 7);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str1);
          localStringBuilder.append(":");
          localStringBuilder.append(str2);
          str1 = localStringBuilder.toString();
          k = 1;
          str2 = str1;
          if (str1 != null) {
            break;
          }
          str2 = paramString.substring(i, j + i);
        }
        catch (Exception paramString)
        {
          return localUrlHostInfo;
        }
        int i = str2.indexOf(":");
        if (i >= 0)
        {
          paramString = str2.substring(0, i);
          str1 = str2.substring(i + 1);
          localUrlHostInfo.jdField_a_of_type_JavaLangString = paramString;
          localUrlHostInfo.jdField_a_of_type_Int = Integer.valueOf(str1).intValue();
        }
        else
        {
          localUrlHostInfo.jdField_a_of_type_JavaLangString = str2;
          localUrlHostInfo.jdField_a_of_type_Int = 0;
        }
        if (k != 0) {
          localUrlHostInfo.b = 1;
        }
        return localUrlHostInfo;
        i += 3;
        continue;
        int k = 0;
      }
    } while (str2 != null);
    return localUrlHostInfo;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    int i = paramString.indexOf("User-ReturnCode=[");
    if (i == -1) {
      return 0;
    }
    paramString = paramString.substring(i + 17);
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    i = paramString.indexOf("]");
    if (i == -1) {
      return 0;
    }
    paramString = paramString.substring(0, i);
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static int c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if (!paramString.startsWith("H_")) {
      return 0;
    }
    int i = paramString.indexOf("_");
    if (i == -1) {
      return 0;
    }
    int j = paramString.lastIndexOf("_");
    if (i == j) {
      return 0;
    }
    paramString = paramString.substring(i, j - 1);
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.utility.UFTTransferUtility
 * JD-Core Version:    0.7.0.1
 */