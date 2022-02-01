package com.tencent.mobileqq.kandian.biz.viola.api;

import com.tencent.viola.annotation.JSMethod;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/IQReportModule;", "", "reportDT", "", "eventName", "", "params", "Lorg/json/JSONObject;", "reportT", "code", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IQReportModule
{
  @JSMethod(uiThread=false)
  public abstract void reportDT(@NotNull String paramString, @Nullable JSONObject paramJSONObject);
  
  @JSMethod(uiThread=false)
  public abstract void reportT(@NotNull String paramString, @NotNull JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.IQReportModule
 * JD-Core Version:    0.7.0.1
 */