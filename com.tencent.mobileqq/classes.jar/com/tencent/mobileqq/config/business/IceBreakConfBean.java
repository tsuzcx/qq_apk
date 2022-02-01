package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IceBreakConfBean
{
  private JSONArray a = new JSONArray();
  
  public static IceBreakConfBean a(String paramString)
  {
    IceBreakConfBean localIceBreakConfBean = new IceBreakConfBean();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse content = ");
      localStringBuilder.append(paramString);
      QLog.d("IceBreakConfBean", 2, localStringBuilder.toString());
    }
    try
    {
      localIceBreakConfBean.a = new JSONObject(paramString).optJSONArray("cmShowTemplates");
      return localIceBreakConfBean;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IceBreakConfBean", 2, "parse JSONException", paramString);
      }
    }
    return localIceBreakConfBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.IceBreakConfBean
 * JD-Core Version:    0.7.0.1
 */