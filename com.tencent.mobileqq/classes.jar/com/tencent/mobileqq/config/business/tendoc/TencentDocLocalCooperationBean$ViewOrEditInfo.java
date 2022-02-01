package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocLocalCooperationBean$ViewOrEditInfo
{
  public String[] a;
  public String b;
  public String c;
  public String d;
  public boolean e;
  public boolean f;
  
  public TencentDocLocalCooperationBean$ViewOrEditInfo(JSONObject paramJSONObject)
  {
    try
    {
      String str = paramJSONObject.getString("extension");
      if (str != null) {
        this.a = str.split("\\|");
      }
      this.b = paramJSONObject.getString("text");
      this.c = paramJSONObject.getString("tShow");
      this.d = paramJSONObject.getString("tPress");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("TencentDocLocalCooperationBean", 1, paramJSONObject.getLocalizedMessage(), paramJSONObject);
    }
  }
  
  public boolean a(String paramString)
  {
    if ((this.a != null) && (paramString != null))
    {
      int i = 0;
      for (;;)
      {
        String[] arrayOfString = this.a;
        if (i >= arrayOfString.length) {
          break;
        }
        if (paramString.equals(arrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationBean.ViewOrEditInfo
 * JD-Core Version:    0.7.0.1
 */