package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter;

import com.tencent.qqlive.module.videoreport.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class JsCallbackBuilder
{
  private static final String TAG = "JsCallbackBuilder";
  private IJsEntityFormatter dataFormatter;
  private String msg = "success";
  private String ret = "0";
  
  public String format()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret", this.ret).put("msg", this.msg);
      if (this.dataFormatter != null) {
        localJSONObject.put("data", this.dataFormatter.format());
      }
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("format ");
      localStringBuilder.append(localJSONException);
      Log.e("JsCallbackBuilder", localStringBuilder.toString());
    }
    return localJSONObject.toString();
  }
  
  public JsCallbackBuilder setData(IJsEntityFormatter paramIJsEntityFormatter)
  {
    this.dataFormatter = paramIJsEntityFormatter;
    return this;
  }
  
  public JsCallbackBuilder setMsg(String paramString)
  {
    this.msg = paramString;
    return this;
  }
  
  public JsCallbackBuilder setRet(String paramString)
  {
    this.ret = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.JsCallbackBuilder
 * JD-Core Version:    0.7.0.1
 */