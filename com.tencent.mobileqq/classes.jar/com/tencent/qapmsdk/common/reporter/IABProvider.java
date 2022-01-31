package com.tencent.qapmsdk.common.reporter;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/reporter/IABProvider;", "", "addFactorToAPM", "", "reportParams", "Lorg/json/JSONObject;", "common_release"}, k=1, mv={1, 1, 15})
public abstract interface IABProvider
{
  public abstract void addFactorToAPM(@Nullable JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.common.reporter.IABProvider
 * JD-Core Version:    0.7.0.1
 */