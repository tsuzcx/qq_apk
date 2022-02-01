package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class StructPicLimitDataBean
{
  public boolean a = true;
  public long b = 134217728L;
  
  public static StructPicLimitDataBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        StructPicLimitDataBean localStructPicLimitDataBean = new StructPicLimitDataBean();
        paramString = new JSONObject(paramString);
        if (paramString.optInt("openSwitch", 0) == 0)
        {
          bool = true;
          localStructPicLimitDataBean.a = bool;
          localStructPicLimitDataBean.b = paramString.optLong("picMaxLen", 134217728L);
          return localStructPicLimitDataBean;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GlobalSearchConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return null;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.StructPicLimitDataBean
 * JD-Core Version:    0.7.0.1
 */