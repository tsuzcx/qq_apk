package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;

public class FlashChatConfBean
{
  public String a = "";
  
  public static FlashChatConfBean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        FlashChatConfBean localFlashChatConfBean = new FlashChatConfBean();
        localFlashChatConfBean.a = paramString;
        QLog.d("ConfBean", 2, "confBean = " + localFlashChatConfBean.toString());
        return localFlashChatConfBean;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ConfBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("configContent:").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.FlashChatConfBean
 * JD-Core Version:    0.7.0.1
 */