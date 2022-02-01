package com.tencent.mobileqq.qqexpand.utils;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/LocalStorageUtils;", "", "()V", "expandConfig", "Landroid/content/SharedPreferences;", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public final class LocalStorageUtils
{
  public static final LocalStorageUtils a = new LocalStorageUtils();
  
  @JvmStatic
  @NotNull
  public static final SharedPreferences a()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MobileQQ.sMobileQQ.waitAppRuntime(null)");
    localObject = ((AppRuntime)localObject).getAccount();
    if (localObject == null) {
      localObject = "";
    }
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_expand_local_storage");
    localObject = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MobileQQ.sMobileQQ\n     …e\", Context.MODE_PRIVATE)");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.LocalStorageUtils
 * JD-Core Version:    0.7.0.1
 */