package com.tencent.mobileqq.qwallet.config.impl;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class QWalletConfigHandler
{
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceivePreExec|");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString3);
      QLog.d("QWalletConfigHandler", 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.config.impl.QWalletConfigHandler
 * JD-Core Version:    0.7.0.1
 */