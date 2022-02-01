package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class WVSecurityConfBean
{
  public int a;
  public int b = 0;
  
  public static WVSecurityConfBean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        WVSecurityConfBean localWVSecurityConfBean = new WVSecurityConfBean();
        paramString = new JSONObject(paramString);
        localWVSecurityConfBean.a = paramString.optInt("switch", 0);
        localWVSecurityConfBean.b = paramString.optInt("stoppreload", 0);
        QLog.d("ConfBean", 2, "confBean = " + localWVSecurityConfBean.a);
        return localWVSecurityConfBean;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ConfBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("result:").append(this.a);
    localStringBuilder.append(" stoppreload:").append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WVSecurityConfBean
 * JD-Core Version:    0.7.0.1
 */