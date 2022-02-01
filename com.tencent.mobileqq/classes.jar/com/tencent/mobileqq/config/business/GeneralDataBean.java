package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class GeneralDataBean
{
  public boolean a = false;
  
  public static GeneralDataBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        GeneralDataBean localGeneralDataBean = new GeneralDataBean();
        if (new JSONObject(paramString).optInt("openSwitch", 0) == 1)
        {
          bool = true;
          localGeneralDataBean.a = bool;
          return localGeneralDataBean;
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
 * Qualified Name:     com.tencent.mobileqq.config.business.GeneralDataBean
 * JD-Core Version:    0.7.0.1
 */