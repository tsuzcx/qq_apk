package com.tencent.mobileqq.leba.UITemplate;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ARKUITemplateInfo
  extends BaseUITemplateInfo
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public boolean a(JSONObject paramJSONObject)
  {
    try
    {
      a(paramJSONObject);
      JSONObject localJSONObject = paramJSONObject.optJSONObject("params");
      this.a = localJSONObject.optString("ark_app_name");
      this.b = localJSONObject.optString("ark_app_ver");
      this.c = localJSONObject.optString("ark_app_view");
      this.d = localJSONObject.optString("ark_extra");
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("new_leba", 1, "pareseJson fail,  json = " + paramJSONObject.toString(), localException);
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof ARKUITemplateInfo))) {}
    do
    {
      return false;
      paramObject = (ARKUITemplateInfo)paramObject;
    } while ((this.a == null) || (!this.a.equals(paramObject.a)) || (this.b == null) || (!this.b.equals(paramObject.b)) || (this.c == null) || (!this.c.equals(paramObject.c)) || (this.d == null) || (!this.d.equals(paramObject.d)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.UITemplate.ARKUITemplateInfo
 * JD-Core Version:    0.7.0.1
 */