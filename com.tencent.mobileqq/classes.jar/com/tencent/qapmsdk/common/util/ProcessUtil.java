package com.tencent.qapmsdk.common.util;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/ProcessUtil;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class ProcessUtil
{
  public static final ProcessUtil.Companion Companion = new ProcessUtil.Companion(null);
  @NotNull
  public static final String TAG = "QAPM_common_ProcessUtil";
  private static String currProcessName = "";
  
  @JvmStatic
  @NotNull
  public static final String getCurrentProcessName(@Nullable Context paramContext)
  {
    return Companion.getCurrentProcessName(paramContext);
  }
  
  @JvmStatic
  public static final boolean isMainProcess(@Nullable Context paramContext)
  {
    return Companion.isMainProcess(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.ProcessUtil
 * JD-Core Version:    0.7.0.1
 */