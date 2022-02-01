package com.tencent.mobileqq.textpreview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;

public class MenuUtil
  extends BaseMenuUtil
{
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    int k = paramString.length();
    int j;
    for (int i = 0; i < k; i = j + 1)
    {
      j = i;
      if ('\024' == paramString.charAt(i))
      {
        int m = i + 1;
        j = i;
        if (m < k)
        {
          j = i;
          if ('ÿ' == paramString.charAt(m))
          {
            m = i + 2;
            j = i;
            if (m < k)
            {
              if (paramString.charAt(m) == '\024') {
                paramString.setCharAt(m, 'ý');
              }
              j = i + 4;
            }
          }
        }
      }
    }
    return paramString.toString();
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    QfavBuilder.a(null, a(paramString)).b(paramQQAppInterface, null).a(paramActivity, paramQQAppInterface.getAccount());
    QfavReport.a(paramQQAppInterface, 6, 1);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", -1);
    localBundle.putString("forward_text", paramString);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    paramString.putExtra("direct_send_if_dataline_forward", true);
    ForwardBaseOption.a(paramActivity, paramString, 21);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 48);
    localBundle.putString("forward_text", paramString);
    localBundle.putInt("forward_extra", paramInt);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    paramString.putExtra("direct_send_if_dataline_forward", true);
    ForwardBaseOption.a(paramActivity, paramString, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.textpreview.MenuUtil
 * JD-Core Version:    0.7.0.1
 */