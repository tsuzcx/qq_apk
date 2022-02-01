package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.entity;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.IJsEntityFormatter;
import org.json.JSONObject;

public class JsDefaultEntity
  implements IJsEntityFormatter
{
  private static final String TAG = "JsDefaultEntity";
  private JSONObject mResult = new JSONObject();
  
  public JSONObject format()
  {
    return this.mResult;
  }
  
  public void setData(String paramString1, String paramString2)
  {
    try
    {
      this.mResult.put(paramString1, paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("set data error ");
      paramString2.append(paramString1);
      Log.e("JsDefaultEntity", paramString2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.entity.JsDefaultEntity
 * JD-Core Version:    0.7.0.1
 */