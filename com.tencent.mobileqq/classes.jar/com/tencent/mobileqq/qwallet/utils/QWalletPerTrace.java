package com.tencent.mobileqq.qwallet.utils;

import com.tencent.qphone.base.util.QLog;

public class QWalletPerTrace
{
  public static void a(String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("markTimeStamp ");
      localStringBuilder.append(paramString);
      QLog.d("QWalletPerTrace", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.utils.QWalletPerTrace
 * JD-Core Version:    0.7.0.1
 */