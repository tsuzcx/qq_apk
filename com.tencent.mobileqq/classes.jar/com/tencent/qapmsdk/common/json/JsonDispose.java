package com.tencent.qapmsdk.common.json;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/json/JsonDispose;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class JsonDispose
{
  public static final JsonDispose.Companion Companion = new JsonDispose.Companion(null);
  private static final String TAG = "QAPM_common_JsonDispose";
  
  @JvmStatic
  @NotNull
  public static final JSONObject copyJson(@NotNull JSONObject paramJSONObject1, @NotNull JSONObject paramJSONObject2)
  {
    return Companion.copyJson(paramJSONObject1, paramJSONObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.json.JsonDispose
 * JD-Core Version:    0.7.0.1
 */