package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class DarkModeConfigProcessor$DarkModeConfigBean
{
  private boolean a = false;
  
  public static DarkModeConfigBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        DarkModeConfigBean localDarkModeConfigBean = new DarkModeConfigBean();
        paramString = new JSONObject(paramString);
        bool = true;
        if (paramString.optInt("isDefaultOpen", 1) == 1)
        {
          localDarkModeConfigBean.a = bool;
          return localDarkModeConfigBean;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("DarkModeConfigProcessor", 2, "DarkModeConfigBean parse error", paramString);
        return null;
      }
      boolean bool = false;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.DarkModeConfigProcessor.DarkModeConfigBean
 * JD-Core Version:    0.7.0.1
 */