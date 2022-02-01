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
      if (paramString.length() > 0)
      {
        paramString = paramString.getJSONObject(0);
        RedDotConfBean localRedDotConfBean = new RedDotConfBean();
        String str = paramString.optString("name");
        boolean bool = "photo".equals(str);
        if (bool)
        {
          localRedDotConfBean.c = paramString.optInt("showRed", 0);
          localRedDotConfBean.d = paramString.optInt("version", 0);
          return localRedDotConfBean;
        }
        if ("gif".equals(str))
        {
          localRedDotConfBean.a = paramString.optInt("showRed", 0);
          localRedDotConfBean.b = paramString.optInt("version", 0);
        }
        return localRedDotConfBean;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoAndHotPicRedDotConfProcessor", 2, "handleGetPtvHotPicConfig Exception :", paramString);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.RedDotConfBean
 * JD-Core Version:    0.7.0.1
 */