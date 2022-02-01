package com.tencent.mobileqq.mini.model;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/model/DetailConfigParseHelper;", "", "()V", "parse", "", "Lcom/tencent/mobileqq/mini/model/AppDetainConfig;", "configStr", "", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class DetailConfigParseHelper
{
  @NotNull
  public final List<AppDetainConfig> parse(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "configStr");
    List localList = (List)new ArrayList();
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("detainConfig");
      if (paramString != null)
      {
        int i = 0;
        int j = paramString.length();
        while (i < j)
        {
          Object localObject = paramString.getJSONObject(i);
          String str1 = ((JSONObject)localObject).getString("content");
          Intrinsics.checkExpressionValueIsNotNull(str1, "itemJson.getString(\"content\")");
          String str2 = ((JSONObject)localObject).getString("exitButton");
          Intrinsics.checkExpressionValueIsNotNull(str2, "itemJson.getString(\"exitButton\")");
          String str3 = ((JSONObject)localObject).getString("enterButton");
          Intrinsics.checkExpressionValueIsNotNull(str3, "itemJson.getString(\"enterButton\")");
          localObject = new AppDetainConfig(str1, str2, str3, ((JSONObject)localObject).optString("openLink", null), ((JSONObject)localObject).optString("openType", null), ((JSONObject)localObject).optString("exitPage", null));
          if (((AppDetainConfig)localObject).isValidItem()) {
            localList.add(localObject);
          }
          i += 1;
        }
      }
      return localList;
    }
    catch (Exception paramString)
    {
      QLog.e("MiniAppDetainManager", 1, "parse failed-->", (Throwable)paramString);
    }
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.model.DetailConfigParseHelper
 * JD-Core Version:    0.7.0.1
 */