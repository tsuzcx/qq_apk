package com.tencent.mobileqq.kandian.biz.reward.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTask;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/utils/RIJRewardTaskPrefHelper;", "", "()V", "CONTENT_TYPE", "", "MAX_TIME_IN_MS", "RECORD_TIME_IN_MS", "ROW_KEY", "sp", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getSp", "()Landroid/content/SharedPreferences;", "sp$delegate", "Lkotlin/Lazy;", "configKey", "key", "restoreFromSp", "Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTask;", "saveToSp", "", "task", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTaskPrefHelper
{
  public static final RIJRewardTaskPrefHelper a = new RIJRewardTaskPrefHelper();
  private static final Lazy b = LazyKt.lazy((Function0)RIJRewardTaskPrefHelper.sp.2.INSTANCE);
  
  private final SharedPreferences a()
  {
    return (SharedPreferences)b.getValue();
  }
  
  @JvmStatic
  @Nullable
  public static final RIJRewardTask a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(b(paramString));
    ((StringBuilder)localObject1).append("_ROW_KEY");
    String str = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(b(paramString));
    ((StringBuilder)localObject1).append("_CONTENT_TYPE");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(b(paramString));
    ((StringBuilder)localObject2).append("_MAX_TIME_IN_MS");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(b(paramString));
    ((StringBuilder)localObject3).append("_RECORD_TIME_IN_MS");
    paramString = ((StringBuilder)localObject3).toString();
    str = a.a().getString(str, "");
    localObject3 = a.a();
    int i = 0;
    int j = ((SharedPreferences)localObject3).getInt((String)localObject1, 0);
    int k = a.a().getInt((String)localObject2, 0);
    int m = a.a().getInt(paramString, 0);
    paramString = (CharSequence)str;
    if ((paramString == null) || (paramString.length() == 0)) {
      i = 1;
    }
    if (i != 0) {
      return null;
    }
    return new RIJRewardTask(str, j, k, m);
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString, @Nullable RIJRewardTask paramRIJRewardTask)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(b(paramString));
    ((StringBuilder)localObject1).append("_ROW_KEY");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(b(paramString));
    ((StringBuilder)localObject2).append("_CONTENT_TYPE");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(b(paramString));
    ((StringBuilder)localObject3).append("_MAX_TIME_IN_MS");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(b(paramString));
    ((StringBuilder)localObject4).append("_RECORD_TIME_IN_MS");
    localObject4 = ((StringBuilder)localObject4).toString();
    SharedPreferences.Editor localEditor = a.a().edit();
    if (paramRIJRewardTask != null)
    {
      paramString = paramRIJRewardTask.b();
      if (paramString != null) {}
    }
    else
    {
      paramString = "";
    }
    paramString = localEditor.putString((String)localObject1, paramString);
    int j = 0;
    if (paramRIJRewardTask != null) {
      i = paramRIJRewardTask.c();
    } else {
      i = 0;
    }
    paramString = paramString.putInt((String)localObject2, i);
    if (paramRIJRewardTask != null) {
      i = paramRIJRewardTask.d();
    } else {
      i = 0;
    }
    paramString = paramString.putInt((String)localObject3, i);
    int i = j;
    if (paramRIJRewardTask != null) {
      i = paramRIJRewardTask.e();
    }
    paramString.putInt((String)localObject4, i).apply();
  }
  
  @JvmStatic
  @NotNull
  public static final String b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(RIJQQAppInterfaceUtil.c());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.utils.RIJRewardTaskPrefHelper
 * JD-Core Version:    0.7.0.1
 */