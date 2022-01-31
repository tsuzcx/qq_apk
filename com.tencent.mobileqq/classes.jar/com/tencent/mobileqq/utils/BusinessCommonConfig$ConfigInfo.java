package com.tencent.mobileqq.utils;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public abstract class BusinessCommonConfig$ConfigInfo
{
  public int a = -1;
  public int b;
  public String l;
  
  public void a(String paramString)
  {
    this.l = paramString;
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    for (int i = 1;; i = 0) {
      try
      {
        paramString2 = new JSONObject(paramString2);
        this.b = paramString2.getInt("task_id");
        boolean bool = a(paramString2);
        if (bool)
        {
          this.a = i;
          return bool;
        }
      }
      catch (Exception paramString2)
      {
        QLog.d(paramString1, 1, "parseJson, Exception", paramString2);
        return false;
      }
    }
  }
  
  public abstract boolean a(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BusinessCommonConfig.ConfigInfo
 * JD-Core Version:    0.7.0.1
 */