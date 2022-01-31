package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;

public class AvatarTroopUtil
{
  public static String a(String paramString)
  {
    if (a(paramString)) {
      return paramString + 140;
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    String str = "http://p.qlogo.cn/gh/dir/file/";
    if (1 == paramInt) {
      paramString1 = "http://p.qlogo.cn/gh/dir/file/".replace("dir", paramString2).replace("file", paramString2 + "_" + paramString1);
    }
    do
    {
      return paramString1;
      paramString1 = str;
    } while (paramInt != 0);
    return "http://p.qlogo.cn/gh/dir/file/".replace("dir", paramString2).replace("file", paramString2);
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("http://p.qlogo.cn/gh/");
  }
  
  public static String b(String paramString)
  {
    if (a(paramString)) {
      return paramString + 0;
    }
    return null;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (((paramString.length() > 1) && (paramString.startsWith("+"))) || (paramString.startsWith("-"))) {}
    for (int i = 1;; i = 0)
    {
      int j = paramString.length();
      int k;
      do
      {
        k = j - 1;
        if (k < i) {
          break;
        }
        j = k;
      } while (Character.isDigit(paramString.charAt(k)));
      return false;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AvatarTroopUtil
 * JD-Core Version:    0.7.0.1
 */