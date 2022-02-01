package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class DarkModeConfigProcessor$DarkModeConfigBean
{
  private boolean a = false;
  
  public static DarkModeConfigBean a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      DarkModeConfigBean localDarkModeConfigBean = new DarkModeConfigBean();
      if (new JSONObject(paramString).optInt("isDefaultOpen", 1) == 1) {}
      for (;;)
      {
        localDarkModeConfigBean.a = bool;
        return localDarkModeConfigBean;
        bool = false;
      }
      return null;
    }
    catch (Exception paramString)
    {
      QLog.e("DarkModeConfigProcessor", 2, "DarkModeConfigBean parse error", paramString);
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.DarkModeConfigProcessor.DarkModeConfigBean
 * JD-Core Version:    0.7.0.1
 */