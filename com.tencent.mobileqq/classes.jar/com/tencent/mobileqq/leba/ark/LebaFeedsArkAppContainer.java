package com.tencent.mobileqq.leba.ark;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;

public class LebaFeedsArkAppContainer
  extends ArkAppContainer
{
  public static final String[] a = { "[%APP_NAME%]", "[$APP_NAME$]", "[%APP_DESC%]", "[$APP_DESC$]", "[%PROMPT%]", "[$PROMPT$]" };
  
  public String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      return str;
    }
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      str = paramString;
      if (i >= j) {
        break;
      }
      paramString = paramString.replace(arrayOfString[i], "");
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.ark.LebaFeedsArkAppContainer
 * JD-Core Version:    0.7.0.1
 */