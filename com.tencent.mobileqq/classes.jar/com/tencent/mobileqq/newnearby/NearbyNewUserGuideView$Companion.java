package com.tencent.mobileqq.newnearby;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/newnearby/NearbyNewUserGuideView$Companion;", "", "()V", "TAG", "", "parseConfigs", "", "Lcom/tencent/mobileqq/newnearby/NearbyNewUserGuideView$Config;", "json", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NearbyNewUserGuideView$Companion
{
  @JvmStatic
  @Nullable
  public final List<NearbyNewUserGuideView.Config> a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "json");
    try
    {
      localObject1 = (List)new ArrayList();
      paramString = new JSONObject(paramString).getJSONArray("config");
      int i = 0;
      int j = paramString.length();
      while (i < j)
      {
        Object localObject2 = paramString.getJSONObject(i);
        int k = ((JSONObject)localObject2).getInt("x");
        int m = ((JSONObject)localObject2).getInt("y");
        int n = ((JSONObject)localObject2).getInt("width");
        int i1 = ((JSONObject)localObject2).getInt("height");
        localObject2 = ((JSONObject)localObject2).getString("text");
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "text");
        ((List)localObject1).add(new NearbyNewUserGuideView.Config(k, m, n, i1, (String)localObject2));
        i += 1;
      }
      return localObject1;
    }
    catch (Exception paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parse json error: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.e("NearbyNewUserGuideView", 1, ((StringBuilder)localObject1).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.NearbyNewUserGuideView.Companion
 * JD-Core Version:    0.7.0.1
 */