package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class AppletNotificationConfigureBean
{
  public boolean a = false;
  
  public static AppletNotificationConfigureBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      AppletNotificationConfigureBean localAppletNotificationConfigureBean = new AppletNotificationConfigureBean();
      localAppletNotificationConfigureBean.a = new JSONObject(paramString).optBoolean("is_in_messagetab", false);
      paramString = new StringBuilder();
      paramString.append("confBean = ");
      paramString.append(localAppletNotificationConfigureBean.toString());
      QLog.d("AppletNotificationConfProcessor", 2, paramString.toString());
      return localAppletNotificationConfigureBean;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AppletNotificationConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.AppletNotificationConfigureBean
 * JD-Core Version:    0.7.0.1
 */