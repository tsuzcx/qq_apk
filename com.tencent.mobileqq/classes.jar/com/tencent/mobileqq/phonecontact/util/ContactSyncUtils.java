package com.tencent.mobileqq.phonecontact.util;

import android.text.TextUtils;

public class ContactSyncUtils
{
  public static String a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() >= 3)) {
      return paramString.substring(0, 3);
    }
    return "invalid uin";
  }
  
  public static String b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() >= 3)) {
      return paramString.substring(paramString.length() - 3);
    }
    return "invalid phone num";
  }
  
  public static String c(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 4))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramString.length() - 4;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append("*");
        i += 1;
      }
      localStringBuilder.append(paramString.substring(j));
      return localStringBuilder.toString();
    }
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.util.ContactSyncUtils
 * JD-Core Version:    0.7.0.1
 */