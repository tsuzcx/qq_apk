package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MultiChannelReportBean
{
  public boolean a = true;
  
  public static MultiChannelReportBean a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        MultiChannelReportBean localMultiChannelReportBean = new MultiChannelReportBean();
        if (new JSONObject(paramString).optInt("enableMultiChannelReport", 1) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localMultiChannelReportBean.a = bool;
          return localMultiChannelReportBean;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramString) {}
    }
    QLog.e("MultiChannelReportProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public static String a(MultiChannelReportBean paramMultiChannelReportBean)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramMultiChannelReportBean != null) {}
    try
    {
      localJSONObject.put("isMultiChannelReportEnable", paramMultiChannelReportBean.a);
      return localJSONObject.toString();
    }
    catch (JSONException paramMultiChannelReportBean)
    {
      for (;;)
      {
        paramMultiChannelReportBean.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MultiChannelReportBean
 * JD-Core Version:    0.7.0.1
 */