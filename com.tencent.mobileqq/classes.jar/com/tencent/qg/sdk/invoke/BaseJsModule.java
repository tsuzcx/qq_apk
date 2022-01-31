package com.tencent.qg.sdk.invoke;

import org.json.JSONObject;

public abstract class BaseJsModule
{
  public abstract String getModuleName();
  
  public abstract boolean handleJsRequest(String paramString, JSONObject paramJSONObject, InvokeCallback paramInvokeCallback);
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qg.sdk.invoke.BaseJsModule
 * JD-Core Version:    0.7.0.1
 */