package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class StructPicLimitDataBean
{
  public long a;
  public boolean a;
  
  public StructPicLimitDataBean()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 134217728L;
  }
  
  public static StructPicLimitDataBean a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        StructPicLimitDataBean localStructPicLimitDataBean = new StructPicLimitDataBean();
        paramString = new JSONObject(paramString);
        if (paramString.optInt("openSwitch", 0) == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localStructPicLimitDataBean.jdField_a_of_type_Boolean = bool;
          localStructPicLimitDataBean.jdField_a_of_type_Long = paramString.optLong("picMaxLen", 134217728L);
          return localStructPicLimitDataBean;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramString) {}
    }
    QLog.e("GlobalSearchConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.StructPicLimitDataBean
 * JD-Core Version:    0.7.0.1
 */