package com.tencent.mobileqq.leba.config;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class LebaConfigApi
{
  public boolean a()
  {
    try
    {
      LebaQzoneStyleBean localLebaQzoneStyleBean = (LebaQzoneStyleBean)QConfigManager.a().a(614);
    }
    catch (Exception localException)
    {
      QLog.i("LebaConfigApi", 1, "isSupportSort", localException);
      localStringBuilder = null;
    }
    boolean bool = false;
    if (localStringBuilder == null)
    {
      QLog.i("LebaConfigApi", 1, "isSupportSort configBean == null");
      return false;
    }
    if (localStringBuilder.b == 1) {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isSupportSort =");
    localStringBuilder.append(bool);
    QLog.i("LebaConfigApi", 1, localStringBuilder.toString());
    return bool;
  }
  
  public boolean b()
  {
    try
    {
      LebaQzoneStyleBean localLebaQzoneStyleBean = (LebaQzoneStyleBean)QConfigManager.a().a(614);
    }
    catch (Exception localException)
    {
      QLog.i("LebaConfigApi", 1, "isNewStyle", localException);
      localStringBuilder = null;
    }
    boolean bool = false;
    if (localStringBuilder == null)
    {
      QLog.i("LebaConfigApi", 1, "isNewStyle configBean == null");
      return false;
    }
    if (localStringBuilder.a == 1) {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isNewStyle =");
    localStringBuilder.append(bool);
    QLog.i("LebaConfigApi", 1, localStringBuilder.toString());
    return bool;
  }
  
  public boolean c()
  {
    LebaRedTouchSwitchBean localLebaRedTouchSwitchBean = (LebaRedTouchSwitchBean)QConfigManager.a().a(598);
    boolean bool = true;
    if (localLebaRedTouchSwitchBean != null) {
      bool = true ^ localLebaRedTouchSwitchBean.a;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.config.LebaConfigApi
 * JD-Core Version:    0.7.0.1
 */