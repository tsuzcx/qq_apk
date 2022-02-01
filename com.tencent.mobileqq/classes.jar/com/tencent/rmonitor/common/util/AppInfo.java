package com.tencent.rmonitor.common.util;

import android.content.Context;
import android.util.SparseArray;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/AppInfo;", "", "()V", "Companion", "PssInfo", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class AppInfo
{
  public static final AppInfo.Companion a = new AppInfo.Companion(null);
  private static final long b = 10000L;
  private static AppInfo.PssInfo c = new AppInfo.PssInfo();
  private static final SparseArray<String> d = new SparseArray();
  @NotNull
  private static final Lazy e = LazyKt.lazy((Function0)AppInfo.Companion.pid.2.INSTANCE);
  
  @JvmStatic
  @NotNull
  public static final String a(@Nullable Context paramContext)
  {
    return a.a(paramContext);
  }
  
  @JvmStatic
  public static final boolean a(@Nullable Context paramContext, @NotNull String[] paramArrayOfString)
  {
    return a.a(paramContext, paramArrayOfString);
  }
  
  @JvmStatic
  @NotNull
  public static final String b(@Nullable Context paramContext)
  {
    return a.b(paramContext);
  }
  
  @JvmStatic
  public static final long e()
  {
    return a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.AppInfo
 * JD-Core Version:    0.7.0.1
 */