package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;

public class FlashChatConfBean
{
  public String a = "";
  
  public static FlashChatConfBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      FlashChatConfBean localFlashChatConfBean = new FlashChatConfBean();
      localFlashChatConfBean.a = paramString;
      paramString = new StringBuilder();
      paramString.append("confBean = ");
      paramString.append(localFlashChatConfBean.toString());
      QLog.d("ConfBean", 2, paramString.toString());
      return localFlashChatConfBean;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ConfBean", 1, new Object[] { "parse e:", paramString.toString() });
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("configContent:");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.FlashChatConfBean
 * JD-Core Version:    0.7.0.1
 */