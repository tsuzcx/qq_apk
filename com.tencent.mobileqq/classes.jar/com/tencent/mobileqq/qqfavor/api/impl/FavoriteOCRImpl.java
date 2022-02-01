package com.tencent.mobileqq.qqfavor.api.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqfavor.api.IFavoriteOCR;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import mqq.app.AppRuntime;

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
  
  public void favorite(Activity paramActivity, String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localObject;
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      QfavBuilder.a(null, doReplaceForIndex20(paramString)).b((QQAppInterface)localObject, null).a(paramActivity, ((QQAppInterface)localObject).getAccount());
      QfavReport.a((AppRuntime)localObject, 6, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfavor.api.impl.FavoriteOCRImpl
 * JD-Core Version:    0.7.0.1
 */