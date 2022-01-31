package com.tencent.qapmsdk.common.util;

import android.app.Application;
import android.content.Context;
import android.util.SparseArray;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/AppInfo;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class AppInfo
{
  public static final AppInfo.Companion Companion = new AppInfo.Companion(null);
  private static final String TAG = "QAPM_common_AppInfo";
  @NotNull
  private static final Lazy pid$delegate = LazyKt.lazy((Function0)AppInfo.Companion.pid.2.INSTANCE);
  private static final SparseArray<String> processMap = new SparseArray();
  
  @JvmStatic
  public static final long getPssMemory(@Nullable Application paramApplication, int paramInt)
  {
    return Companion.getPssMemory(paramApplication, paramInt);
  }
  
  @JvmStatic
  public static final boolean hasPermissions(@Nullable Context paramContext, @NotNull String[] paramArrayOfString)
  {
    return Companion.hasPermissions(paramContext, paramArrayOfString);
  }
  
  @JvmStatic
  @NotNull
  public static final String obtainProcessName(@Nullable Context paramContext)
  {
    return Companion.obtainProcessName(paramContext);
  }
  
  @JvmStatic
  @NotNull
  public static final String obtainProcessPackageName(@Nullable Context paramContext)
  {
    return Companion.obtainProcessPackageName(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.AppInfo
 * JD-Core Version:    0.7.0.1
 */