package com.tencent.qqprotect.common;

import android.text.TextUtils;
import mqq.app.MobileQQ;

public class BaseQPMiscUtils
{
  public static String a()
  {
    String str2 = MobileQQ.sMobileQQ.getPackageName();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "com.tencent.mobileqq";
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.common.BaseQPMiscUtils
 * JD-Core Version:    0.7.0.1
 */