package com.tencent.mobileqq.config;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class BeancurdConfBean
{
  public boolean a;
  
  public static BeancurdConfBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      BeancurdConfBean localBeancurdConfBean = new BeancurdConfBean();
      paramString = new JSONObject(paramString);
      boolean bool = false;
      if (paramString.optInt("new_beancurd_switch", 0) == 1) {
        bool = true;
      }
      localBeancurdConfBean.a = bool;
      return localBeancurdConfBean;
    }
    catch (Exception paramString)
    {
      QLog.e("BeancurdConfBean", 1, "BeancurdConfBean parse error", paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.BeancurdConfBean
 * JD-Core Version:    0.7.0.1
 */