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
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakConfBean", 2, "parse content = " + paramString);
    }
    try
    {
      localIceBreakConfBean.a = new JSONObject(paramString).optJSONArray("cmShowTemplates");
      return localIceBreakConfBean;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("IceBreakConfBean", 2, "parse JSONException", paramString);
    }
    return localIceBreakConfBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.IceBreakConfBean
 * JD-Core Version:    0.7.0.1
 */