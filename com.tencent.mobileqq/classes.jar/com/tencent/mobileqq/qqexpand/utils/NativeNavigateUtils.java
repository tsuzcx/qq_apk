package com.tencent.mobileqq.qqexpand.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/NativeNavigateUtils;", "", "()V", "TAG", "", "navigateBySchema", "", "context", "Landroid/content/Context;", "url", "navigateMiniApp", "navigateWebView", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class NativeNavigateUtils
{
  public static final NativeNavigateUtils a = new NativeNavigateUtils();
  
  public final void a(@NotNull Context paramContext, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    StringBuilder localStringBuilder;
    if (!((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString))
    {
      localObject = LogUtils.a;
      paramContext = (Throwable)null;
      localObject = ((LogUtils)localObject).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpUrl: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" is not miniapp ");
      ((ILog)localObject).a("NativeNavigateUtils", 1, localStringBuilder.toString(), paramContext);
      return;
    }
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject = ((LogUtils)localObject).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("navigateMiniApp: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(' ');
      ((ILog)localObject).a("NativeNavigateUtils", 2, localStringBuilder.toString());
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, paramString, 2065, null);
  }
  
  public final void b(@NotNull Context paramContext, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramContext = LogUtils.a;
      paramString = (Throwable)null;
      paramContext.a().a("NativeNavigateUtils", 1, "web url is null", paramString);
      return;
    }
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject = ((LogUtils)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("navigateWebView: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(' ');
      ((ILog)localObject).a("NativeNavigateUtils", 2, localStringBuilder.toString());
    }
    localObject = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramString);
    if (!(paramContext instanceof Activity)) {
      ((Intent)localObject).addFlags(268435456);
    }
    paramContext.startActivity((Intent)localObject);
  }
  
  public final void c(@NotNull Context paramContext, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramContext = LogUtils.a;
      paramString = (Throwable)null;
      paramContext.a().a("NativeNavigateUtils", 1, "schema url is null", paramString);
      return;
    }
    paramContext = LogUtils.a;
    if (QLog.isColorLevel())
    {
      paramContext = paramContext.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("navigateBySchema: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(' ');
      paramContext.a("NativeNavigateUtils", 2, localStringBuilder.toString());
    }
    paramContext = new Bundle();
    paramContext.putString("data", paramString);
    QIPCClientHelper.getInstance().callServer("ExpandFlutterIPCServer", "notifyOpenSchema", paramContext, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.NativeNavigateUtils
 * JD-Core Version:    0.7.0.1
 */