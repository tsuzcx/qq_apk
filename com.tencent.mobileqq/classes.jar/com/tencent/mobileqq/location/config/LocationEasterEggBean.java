package com.tencent.mobileqq.location.config;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class LocationEasterEggBean
{
  private String a = "";
  private String b = "";
  
  public static LocationEasterEggBean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        LocationEasterEggBean localLocationEasterEggBean = new LocationEasterEggBean();
        paramString = new JSONObject(paramString);
        localLocationEasterEggBean.a = paramString.optString("dest_icon", "");
        localLocationEasterEggBean.b = paramString.optString("avatar_pendant", "");
        return localLocationEasterEggBean;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("LocationEasterEggBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.config.LocationEasterEggBean
 * JD-Core Version:    0.7.0.1
 */