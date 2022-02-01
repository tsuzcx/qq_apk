package com.tencent.mobileqq.leba.config;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class LebaConfigApi
{
  public boolean a()
  {
    Object localObject;
    try
    {
      LebaQzoneStyleBean localLebaQzoneStyleBean = (LebaQzoneStyleBean)QConfigManager.a().a(614);
      if (localLebaQzoneStyleBean == null)
      {
        QLog.i("LebaConfigApi", 1, "isSupportSort configBean == null");
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("LebaConfigApi", 1, "isSupportSort", localException);
        localObject = null;
      }
    }
    if (localObject.b == 1) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("LebaConfigApi", 1, "isSupportSort =" + bool);
      return bool;
    }
  }
  
  public boolean b()
  {
    Object localObject;
    try
    {
      LebaQzoneStyleBean localLebaQzoneStyleBean = (LebaQzoneStyleBean)QConfigManager.a().a(614);
      if (localLebaQzoneStyleBean == null)
      {
        QLog.i("LebaConfigApi", 1, "isNewStyle configBean == null");
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("LebaConfigApi", 1, "isNewStyle", localException);
        localObject = null;
      }
    }
    if (localObject.a == 1) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("LebaConfigApi", 1, "isNewStyle =" + bool);
      return bool;
    }
  }
  
  public boolean c()
  {
    LebaRedTouchSwitchBean localLebaRedTouchSwitchBean = (LebaRedTouchSwitchBean)QConfigManager.a().a(598);
    if (localLebaRedTouchSwitchBean != null) {
      return !localLebaRedTouchSwitchBean.a;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.config.LebaConfigApi
 * JD-Core Version:    0.7.0.1
 */