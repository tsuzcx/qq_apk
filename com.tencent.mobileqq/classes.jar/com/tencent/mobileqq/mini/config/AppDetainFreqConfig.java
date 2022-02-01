package com.tencent.mobileqq.mini.config;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/config/AppDetainFreqConfig;", "", "()V", "mItemList", "", "Lcom/tencent/mobileqq/mini/config/AppDetainFreqConfig$ItemConfig;", "getItemConfig", "appId", "", "parse", "", "content", "Companion", "ItemConfig", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class AppDetainFreqConfig
{
  public static final AppDetainFreqConfig.Companion Companion = new AppDetainFreqConfig.Companion(null);
  private static final String TAG = "AppDetainFreqConfig";
  private List<AppDetainFreqConfig.ItemConfig> mItemList = CollectionsKt.emptyList();
  
  @Nullable
  public final AppDetainFreqConfig.ItemConfig getItemConfig(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Iterator localIterator = ((Iterable)this.mItemList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (Intrinsics.areEqual(((AppDetainFreqConfig.ItemConfig)localObject).getAppId(), paramString))
      {
        paramString = localObject;
        break label56;
      }
    }
    paramString = null;
    label56:
    return (AppDetainFreqConfig.ItemConfig)paramString;
  }
  
  public final void parse(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "content");
    List localList = (List)new ArrayList();
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("appList");
      int i = 0;
      int j = paramString.length();
      while (i < j)
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        String str = localJSONObject.getString("appid");
        Intrinsics.checkExpressionValueIsNotNull(str, "itemJson.getString(\"appid\")");
        localList.add(new AppDetainFreqConfig.ItemConfig(str, localJSONObject.getInt("limitTimes")));
        i += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("AppDetainFreqConfig", 1, "parse failed -->", (Throwable)paramString);
      this.mItemList = localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.config.AppDetainFreqConfig
 * JD-Core Version:    0.7.0.1
 */