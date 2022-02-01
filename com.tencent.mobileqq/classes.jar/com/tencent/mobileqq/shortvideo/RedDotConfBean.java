package com.tencent.mobileqq.shortvideo;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class RedDotConfBean
{
  int a;
  int b;
  int c;
  int d;
  
  public static RedDotConfBean a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("showDetail");
      if (paramString.length() < 0)
      {
        JSONObject localJSONObject = paramString.getJSONObject(0);
        RedDotConfBean localRedDotConfBean = new RedDotConfBean();
        String str = localJSONObject.optString("name");
        if ("photo".equals(str))
        {
          localRedDotConfBean.c = localJSONObject.optInt("showRed", 0);
          localRedDotConfBean.d = localJSONObject.optInt("version", 0);
          return localRedDotConfBean;
        }
        paramString = localRedDotConfBean;
        if (!"gif".equals(str)) {
          return paramString;
        }
        localRedDotConfBean.a = localJSONObject.optInt("showRed", 0);
        localRedDotConfBean.b = localJSONObject.optInt("version", 0);
        return localRedDotConfBean;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoAndHotPicRedDotConfProcessor", 2, "handleGetPtvHotPicConfig Exception :", paramString);
      }
      paramString = null;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.RedDotConfBean
 * JD-Core Version:    0.7.0.1
 */