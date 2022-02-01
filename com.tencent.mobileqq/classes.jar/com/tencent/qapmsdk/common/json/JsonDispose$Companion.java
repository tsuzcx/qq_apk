package com.tencent.qapmsdk.common.json;

import com.tencent.qapmsdk.common.logger.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/json/JsonDispose$Companion;", "", "()V", "TAG", "", "copyJson", "Lorg/json/JSONObject;", "from", "to", "common_release"}, k=1, mv={1, 1, 15})
public final class JsonDispose$Companion
{
  @JvmStatic
  @NotNull
  public final JSONObject copyJson(@NotNull JSONObject paramJSONObject1, @NotNull JSONObject paramJSONObject2)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject1, "from");
    Intrinsics.checkParameterIsNotNull(paramJSONObject2, "to");
    Iterator localIterator = paramJSONObject1.keys();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "from.keys()");
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        paramJSONObject2.put(str, paramJSONObject1.get(str));
      }
      catch (JSONException localJSONException)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_common_JsonDispose", localJSONException + ": copy json key " + str + " error" });
      }
    }
    return paramJSONObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.json.JsonDispose.Companion
 * JD-Core Version:    0.7.0.1
 */