package com.tencent.qqmini.sdk.launcher.core.proxy;

import org.json.JSONObject;

public abstract interface MediaChooseJsProxy$Bridge
{
  public abstract void hideLoading();
  
  public abstract void responseCancel(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public abstract void responseFail(int paramInt, String paramString1, JSONObject paramJSONObject, String paramString2);
  
  public abstract void responseOk(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public abstract void showLoading(String paramString);
  
  public abstract void updateLoading(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy.Bridge
 * JD-Core Version:    0.7.0.1
 */