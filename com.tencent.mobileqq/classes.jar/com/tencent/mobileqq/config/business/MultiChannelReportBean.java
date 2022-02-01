package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MultiChannelReportBean
{
  public boolean a = true;
  
  public static MultiChannelReportBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        MultiChannelReportBean localMultiChannelReportBean = new MultiChannelReportBean();
        if (new JSONObject(paramString).optInt("enableMultiChannelReport", 1) == 1)
        {
          bool = true;
          localMultiChannelReportBean.a = bool;
          return localMultiChannelReportBean;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiChannelReportProcessor", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return null;
      }
      boolean bool = false;
    }
  }
  
  public static String a(MultiChannelReportBean paramMultiChannelReportBean)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramMultiChannelReportBean != null) {
      try
      {
        localJSONObject.put("isMultiChannelReportEnable", paramMultiChannelReportBean.a);
      }
      catch (JSONException paramMultiChannelReportBean)
      {
        paramMultiChannelReportBean.printStackTrace();
      }
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MultiChannelReportBean
 * JD-Core Version:    0.7.0.1
 */