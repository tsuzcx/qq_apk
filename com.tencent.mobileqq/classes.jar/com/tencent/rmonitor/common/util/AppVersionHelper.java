package com.tencent.rmonitor.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/AppVersionHelper;", "", "()V", "META_BUGLY_APP_VERSION", "", "TAG", "appVersion", "manifestVersionCode", "manifestVersionName", "userSetVersion", "", "checkAndGetAppVersion", "context", "Landroid/content/Context;", "checkAppVersion", "", "parseAppVersionFromMetaData", "parseAppVersionFromPackageInfo", "setProductVersion", "productVersion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class AppVersionHelper
{
  public static final AppVersionHelper a = new AppVersionHelper();
  private static String b;
  private static boolean c;
  private static String d;
  private static String e;
  
  private final void a()
  {
    if (c)
    {
      Logger.b.i(new String[] { "AppVersionHelper", "checkAppVersion for userSetVersion is true" });
      return;
    }
    String str = b;
    if (str != null)
    {
      int i;
      if (((CharSequence)str).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        Object localObject = str.toCharArray();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).toCharArray()");
        int m = localObject.length;
        i = 0;
        int k;
        for (int j = 0; i < m; j = k)
        {
          k = j;
          if (localObject[i] == '.') {
            k = j + 1;
          }
          i += 1;
        }
        if (j < 3)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append('.');
          ((StringBuilder)localObject).append(e);
          str = ((StringBuilder)localObject).toString();
          localObject = Logger.b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkAppVersion, old:");
          localStringBuilder.append(b);
          localStringBuilder.append(", new: ");
          localStringBuilder.append(str);
          ((Logger)localObject).i(new String[] { "AppVersionHelper", localStringBuilder.toString() });
          b = str;
        }
        return;
      }
    }
    Logger.b.i(new String[] { "AppVersionHelper", "checkAppVersion for versionName is null or empty" });
  }
  
  private final void b(Context paramContext)
  {
    if (paramContext == null)
    {
      Logger.b.i(new String[] { "AppVersionHelper", "parseAppVersionFromPackageInfo for context is null" });
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        paramContext = ((PackageInfo)localObject).versionName;
        if (paramContext != null)
        {
          b = paramContext;
          e = String.valueOf(((PackageInfo)localObject).versionCode);
          d = b;
          paramContext = Logger.b;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parseAppVersionFromPackageInfo, ");
          ((StringBuilder)localObject).append("appVersion: ");
          ((StringBuilder)localObject).append(b);
          ((StringBuilder)localObject).append(", manifestVersionCode: ");
          ((StringBuilder)localObject).append(e);
          paramContext.i(new String[] { "AppVersionHelper", ((StringBuilder)localObject).toString() });
          return;
        }
      }
      catch (Throwable paramContext)
      {
        Logger.b.a("AppVersionHelper", paramContext);
        return;
      }
      paramContext = "";
    }
  }
  
  private final void c(Context paramContext)
  {
    if (paramContext == null)
    {
      Logger.b.i(new String[] { "AppVersionHelper", "parseAppVersionFromMetaData for context is null" });
      return;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.get("BUGLY_APP_VERSION");
      if (paramContext != null)
      {
        b = paramContext.toString();
        paramContext = Logger.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseAppVersionFromMetaData, ");
        localStringBuilder.append(b);
        paramContext.i(new String[] { "AppVersionHelper", localStringBuilder.toString() });
        return;
      }
    }
    catch (Throwable paramContext)
    {
      Logger.b.a("AppVersionHelper", paramContext);
    }
  }
  
  @NotNull
  public final String a(@Nullable Context paramContext)
  {
    if (TextUtils.isEmpty((CharSequence)b))
    {
      b(paramContext);
      c(paramContext);
    }
    a();
    paramContext = b;
    if (paramContext != null) {
      return paramContext;
    }
    return "";
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "productVersion");
    Logger localLogger = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setProductVersion, old:");
    localStringBuilder.append(b);
    localStringBuilder.append(", new: ");
    localStringBuilder.append(paramString);
    localLogger.i(new String[] { "AppVersionHelper", localStringBuilder.toString() });
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      b = "";
      c = false;
      BaseInfo.userMeta.version = "";
      return;
    }
    b = paramString;
    c = true;
    BaseInfo.userMeta.version = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.AppVersionHelper
 * JD-Core Version:    0.7.0.1
 */