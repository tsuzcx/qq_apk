package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class DeviceManageConfBean
{
  public int a = 0;
  
  public static DeviceManageConfBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      DeviceManageConfBean localDeviceManageConfBean = new DeviceManageConfBean();
      localDeviceManageConfBean.a = new JSONObject(paramString).optInt("kDeviceManageShowMuteKey", 0);
      paramString = new StringBuilder();
      paramString.append("confBean = ");
      paramString.append(localDeviceManageConfBean.toString());
      QLog.d("DeviceManageConfProcessor", 2, paramString.toString());
      return localDeviceManageConfBean;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DeviceManageConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("kDeviceManageShowMuteKey:");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.DeviceManageConfBean
 * JD-Core Version:    0.7.0.1
 */