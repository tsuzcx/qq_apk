package com.tencent.mobileqq.webview.authorize;

import androidx.annotation.NonNull;
import org.json.JSONObject;

public abstract interface IAuthorizeConfigInjector
{
  @NonNull
  public abstract String a();
  
  public abstract void a(@NonNull JSONObject paramJSONObject);
  
  public abstract boolean a(String paramString);
  
  public abstract boolean a(String paramString1, String paramString2);
  
  public abstract boolean b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.authorize.IAuthorizeConfigInjector
 * JD-Core Version:    0.7.0.1
 */