package com.tencent.mobileqq.util.privacy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"CHECK_APP_INSTALLED_AUTHORIZED", "", "CHECK_APP_INSTALLED_BATCH_AUTHORIZED", "GET_APP_VERSION_CODE_BATCH_AUTHORIZED", "INVALID_PACKAGE_VERSION_NAME", "IS_APP_INSTALLED_AUTHORIZED", "IS_APP_INSTALLED_BATCH_AUTHORIZED", "TAG", "UNAUTHORIZED_PACKAGE_PLACEHOLDER", "checkAppInstalled", "context", "Landroid/content/Context;", "pkgName", "business", "checkAppInstalledBatch", "arrayStr", "doWhiteListCheck", "T", "result", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "doWhiteListCheckBatch", "pkgNameArray", "getAppVersionCodeBatch", "isAppInstalled", "", "isAppInstalledBatch", "QQCommon_release"}, k=2, mv={1, 1, 16})
public final class PackageInstallMonitorKt
{
  @Nullable
  public static final <T> T a(@NotNull Context paramContext, @Nullable String paramString1, @NotNull String paramString2, @NotNull Function2<? super Context, ? super String, ? extends T> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString2, "business");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "result");
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((!TextUtils.isEmpty(localCharSequence)) && (!TextUtils.isEmpty((CharSequence)paramString2)))
    {
      paramString2 = PackageInstallWhiteListConfigProcessor.a.a(paramString2);
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        int i = 0;
        int j = paramString2.length();
        while (i < j)
        {
          if (TextUtils.equals((CharSequence)paramString2.get(i).toString(), localCharSequence))
          {
            paramString2 = new StringBuilder();
            paramString2.append("doWhiteListCheck whiteList contains ");
            paramString2.append(paramString1);
            QLog.d("PackageInstallMonitor", 1, paramString2.toString());
            return paramFunction2.invoke(paramContext, paramString1);
          }
          i += 1;
        }
        QLog.d("PackageInstallMonitor", 1, "doWhiteListCheck cur package not in config");
        return null;
      }
      QLog.d("PackageInstallMonitor", 1, "doWhiteListCheck get manage config fail");
      return null;
    }
    paramContext = new StringBuilder();
    paramContext.append("doWhiteListCheck pkgName: ");
    paramContext.append(paramString1);
    paramContext.append(", business: ");
    paramContext.append(paramString2);
    QLog.d("PackageInstallMonitor", 1, paramContext.toString());
    return null;
  }
  
  public static final boolean a(@NotNull Context paramContext, @Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString2, "business");
    paramContext = (Boolean)a(paramContext, paramString1, paramString2, (Function2)PackageInstallMonitorKt.isAppInstalled.result.1.INSTANCE);
    if (paramContext != null) {
      return paramContext.booleanValue();
    }
    return false;
  }
  
  @Nullable
  public static final <T> T b(@NotNull Context paramContext, @Nullable String paramString1, @NotNull String paramString2, @NotNull Function2<? super Context, ? super String, ? extends T> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString2, "business");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "result");
    Object localObject = (CharSequence)paramString1;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty((CharSequence)paramString2)))
    {
      JSONArray localJSONArray = PackageInstallWhiteListConfigProcessor.a.a(paramString2);
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        if (paramString1 != null)
        {
          paramString2 = new Regex("\\|").split((CharSequence)localObject, 0);
          if (paramString2 != null)
          {
            paramString2 = ((Collection)paramString2).toArray(new String[0]);
            if (paramString2 != null)
            {
              paramString2 = (String[])paramString2;
              break label132;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
          }
        }
        paramString2 = null;
        label132:
        if (paramString2 != null)
        {
          localObject = new StringBuilder();
          int k = paramString2.length;
          int i = 0;
          while (i < k)
          {
            int m = localJSONArray.length();
            int j = 0;
            while (j < m)
            {
              if (TextUtils.equals((CharSequence)localJSONArray.get(j).toString(), (CharSequence)paramString2[i]))
              {
                paramString1 = new StringBuilder();
                paramString1.append("doWhiteListCheckBatch whiteList contains ");
                paramString1.append(paramString2[i]);
                QLog.d("PackageInstallMonitor", 1, paramString1.toString());
                j = 1;
                break label254;
              }
              j += 1;
            }
            j = 0;
            label254:
            if (i > 0) {
              ((StringBuilder)localObject).append("|");
            }
            if (j != 0) {
              paramString1 = paramString2[i];
            } else {
              paramString1 = "unauthorized";
            }
            ((StringBuilder)localObject).append(paramString1);
            i += 1;
          }
          return paramFunction2.invoke(paramContext, ((StringBuilder)localObject).toString());
        }
        paramContext = new StringBuilder();
        paramContext.append("doWhiteListCheckBatch invalid pkgArray: ");
        paramContext.append(paramString1);
        QLog.d("PackageInstallMonitor", 1, paramContext.toString());
        return null;
      }
      QLog.d("PackageInstallMonitor", 1, "doWhiteListCheckBatch get manage config fail");
      return null;
    }
    paramContext = new StringBuilder();
    paramContext.append("doWhiteListCheckBatch pkgNameArray: ");
    paramContext.append(paramString1);
    paramContext.append(", business: ");
    paramContext.append(paramString2);
    QLog.d("PackageInstallMonitor", 1, paramContext.toString());
    return null;
  }
  
  @NotNull
  public static final String b(@NotNull Context paramContext, @Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString2, "business");
    paramContext = (String)a(paramContext, paramString1, paramString2, (Function2)PackageInstallMonitorKt.checkAppInstalled.result.1.INSTANCE);
    if (paramContext != null) {
      return paramContext;
    }
    return "0";
  }
  
  @NotNull
  public static final String c(@NotNull Context paramContext, @Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString2, "business");
    paramContext = (String)b(paramContext, paramString1, paramString2, (Function2)PackageInstallMonitorKt.checkAppInstalledBatch.result.1.INSTANCE);
    if (paramContext != null) {
      return paramContext;
    }
    return "0";
  }
  
  @NotNull
  public static final String d(@NotNull Context paramContext, @Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString2, "business");
    paramContext = (String)b(paramContext, paramString1, paramString2, (Function2)PackageInstallMonitorKt.isAppInstalledBatch.result.1.INSTANCE);
    if (paramContext != null) {
      return paramContext;
    }
    return "0";
  }
  
  @NotNull
  public static final String e(@NotNull Context paramContext, @Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString2, "business");
    paramContext = (String)b(paramContext, paramString1, paramString2, (Function2)PackageInstallMonitorKt.getAppVersionCodeBatch.result.1.INSTANCE);
    if (paramContext != null) {
      return paramContext;
    }
    return "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.privacy.PackageInstallMonitorKt
 * JD-Core Version:    0.7.0.1
 */