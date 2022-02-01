package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class WVSecurityConfBean
{
  public int a;
  public int b = 0;
  
  public static WVSecurityConfBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      WVSecurityConfBean localWVSecurityConfBean = new WVSecurityConfBean();
      paramString = new JSONObject(paramString);
      localWVSecurityConfBean.a = paramString.optInt("switch", 0);
      localWVSecurityConfBean.b = paramString.optInt("stoppreload", 0);
      paramString = new StringBuilder();
      paramString.append("confBean = ");
      paramString.append(localWVSecurityConfBean.a);
      QLog.d("ConfBean", 2, paramString.toString());
      return localWVSecurityConfBean;
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
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("result:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" stoppreload:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WVSecurityConfBean
 * JD-Core Version:    0.7.0.1
 */