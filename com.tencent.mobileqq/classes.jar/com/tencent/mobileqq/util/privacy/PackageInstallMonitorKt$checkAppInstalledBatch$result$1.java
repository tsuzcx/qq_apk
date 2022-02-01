package com.tencent.mobileqq.util.privacy;

import android.content.Context;
import com.tencent.mobileqq.utils.PackageUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType", "ctx", "Landroid/content/Context;", "pkg", "invoke"}, k=3, mv={1, 1, 16})
final class PackageInstallMonitorKt$checkAppInstalledBatch$result$1
  extends Lambda
  implements Function2<Context, String, String>
{
  public static final 1 INSTANCE = new 1();
  
  PackageInstallMonitorKt$checkAppInstalledBatch$result$1()
  {
    super(2);
  }
  
  public final String invoke(@NotNull Context paramContext, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "ctx");
    return PackageUtil.c(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.privacy.PackageInstallMonitorKt.checkAppInstalledBatch.result.1
 * JD-Core Version:    0.7.0.1
 */