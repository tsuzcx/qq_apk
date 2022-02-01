package com.tencent.mobileqq.util.privacy.handler;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.util.privacy.PackageInstallMonitorKt;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/util/privacy/handler/CheckAppInstalledBatchHandler;", "Lcom/tencent/mobileqq/util/privacy/handler/IJSPackageInfoHandler;", "()V", "handleJsPackageInfoRequest", "", "context", "Landroid/content/Context;", "methodName", "", "args", "", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/Object;", "QQCommon_release"}, k=1, mv={1, 1, 16})
public final class CheckAppInstalledBatchHandler
  implements IJSPackageInfoHandler
{
  @NotNull
  public BusinessData a(@Nullable String paramString)
  {
    return IJSPackageInfoHandler.DefaultImpls.a(this, paramString);
  }
  
  @Nullable
  public Object a(@NotNull Context paramContext, @NotNull String paramString, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "methodName");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    QLog.d("IJSPackageInfoHandler", 1, "CheckAppInstalledBatchHandler handleJsPackageInfoRequest");
    if (TextUtils.equals((CharSequence)paramString, (CharSequence)"checkAppInstalledBatchAuthorized"))
    {
      int i;
      if (paramVarArgs.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i ^ 0x1) != 0)
      {
        paramString = a(paramVarArgs[0]);
        return PackageInstallMonitorKt.c(paramContext, paramString.b(), paramString.c());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.privacy.handler.CheckAppInstalledBatchHandler
 * JD-Core Version:    0.7.0.1
 */