package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class GlobalSearchConfBean
{
  private boolean a = false;
  
  public static GlobalSearchConfBean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        GlobalSearchConfBean localGlobalSearchConfBean = new GlobalSearchConfBean();
        localGlobalSearchConfBean.a = new JSONObject(paramString).optBoolean("needSeparatePersonWithGroup", false);
        return localGlobalSearchConfBean;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("GlobalSearchConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "needSeparate:" + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.GlobalSearchConfBean
 * JD-Core Version:    0.7.0.1
 */