package com.tencent.mobileqq.qwallet.utils.impl;

import android.net.Uri;
import android.net.Uri.Builder;

public class QWalletLogicUtils
{
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString1;
    if (paramString1.indexOf(paramString2) == -1)
    {
      paramString1 = Uri.parse(paramString1).buildUpon();
      paramString1.appendQueryParameter(paramString2, paramString3);
      str = paramString1.build().toString();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.utils.impl.QWalletLogicUtils
 * JD-Core Version:    0.7.0.1
 */