package com.tencent.qqmini.sdk.widget;

import org.json.JSONObject;

public abstract interface CoverView$JsRuntimeListener
{
  public abstract void onCallbackJsEventFail(String paramString, JSONObject paramJSONObject, int paramInt);
  
  public abstract void onCallbackJsEventOK(String paramString, JSONObject paramJSONObject, int paramInt);
  
  public abstract void onEvaluateSubscribeJS(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.CoverView.JsRuntimeListener
 * JD-Core Version:    0.7.0.1
 */