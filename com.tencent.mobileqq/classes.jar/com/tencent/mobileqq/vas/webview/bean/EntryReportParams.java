package com.tencent.mobileqq.vas.webview.bean;

import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class EntryReportParams
{
  String a = "outside";
  String b;
  String c;
  String d;
  
  public EntryReportParams(int paramInt)
  {
    this.b = String.valueOf(paramInt);
    this.c = "";
    this.d = "";
  }
  
  public String a()
  {
    return Base64Util.encodeToString(b().getBytes(), 0);
  }
  
  public String b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.a);
      localJSONObject.put("page_id", this.b);
      localJSONObject.put("item_id", this.c);
      localJSONObject.put("item_type", this.d);
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("vas_web_report，json: ");
        localStringBuilder.append(localJSONException);
        QLog.d("WebReportAdapter", 2, localStringBuilder.toString());
      }
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.webview.bean.EntryReportParams
 * JD-Core Version:    0.7.0.1
 */