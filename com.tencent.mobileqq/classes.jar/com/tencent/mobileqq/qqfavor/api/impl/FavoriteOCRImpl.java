package com.tencent.mobileqq.qqfavor.api.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qqfavor.api.IFavoriteOCR;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;

public class FavoriteOCRImpl
  implements IFavoriteOCR
{
  private static String doReplaceForIndex20(String paramString)
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
        j = i;
        if (i + 1 < k)
        {
          j = i;
          if ('ÿ' == paramString.charAt(i + 1))
          {
            j = i;
            if (i + 2 < k)
            {
              if (paramString.charAt(i + 2) == '\024') {
                paramString.setCharAt(i + 2, 'ý');
              }
              j = i + 4;
            }
          }
        }
      }
    }
    return paramString.toString();
  }
  
  public void favorite(Activity paramActivity, String paramString)
  {
    QQAppInterface localQQAppInterface = AssistantUtils.a();
    QfavBuilder.a(null, doReplaceForIndex20(paramString)).b(localQQAppInterface, null).a(paramActivity, localQQAppInterface.getAccount());
    QfavReport.a(localQQAppInterface, 6, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqfavor.api.impl.FavoriteOCRImpl
 * JD-Core Version:    0.7.0.1
 */