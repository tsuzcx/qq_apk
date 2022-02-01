package com.tencent.mobileqq.kandian.biz.viola.api;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/InvokeCallJSCallback;", "", "invokeCallJS", "", "callback", "", "data", "invokeErrorCallJS", "errorText", "invokeJS", "result", "Lorg/json/JSONObject;", "popBack", "callbackId", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface InvokeCallJSCallback
{
  public abstract void invokeCallJS(@Nullable String paramString, @Nullable Object paramObject);
  
  public abstract void invokeErrorCallJS(@Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void invokeJS(@Nullable String paramString, @Nullable JSONObject paramJSONObject);
  
  public abstract void popBack(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.InvokeCallJSCallback
 * JD-Core Version:    0.7.0.1
 */