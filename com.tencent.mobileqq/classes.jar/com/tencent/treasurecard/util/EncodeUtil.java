package com.tencent.treasurecard.util;

import android.text.TextUtils;
import java.net.URLEncoder;

public class EncodeUtil
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      String str = URLEncoder.encode(paramString);
      return str;
    }
    catch (Exception localException) {}
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.treasurecard.util.EncodeUtil
 * JD-Core Version:    0.7.0.1
 */