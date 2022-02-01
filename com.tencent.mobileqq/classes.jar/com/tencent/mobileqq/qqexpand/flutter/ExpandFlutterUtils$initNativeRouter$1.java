package com.tencent.mobileqq.qqexpand.flutter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.qflutter.qflutter_native_router.NativeRouter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqexpand.flutter.router.BaseRouter;
import com.tencent.mobileqq.qqexpand.flutter.router.RouterManager;
import com.tencent.mobileqq.qqexpand.flutter.router.RouterManager.Companion;
import com.tencent.mobileqq.qqexpand.utils.ILog;
import com.tencent.mobileqq.qqexpand.utils.LogUtils;
import com.tencent.mobileqq.qqexpand.utils.NativeNavigateUtils;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils$initNativeRouter$1", "Lcom/qflutter/qflutter_native_router/NativeRouter;", "openNativePage", "", "nativeType", "", "url", "urlParams", "", "", "exts", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandFlutterUtils$initNativeRouter$1
  implements NativeRouter
{
  public void openNativePage(@Nullable String paramString1, @Nullable String paramString2, @Nullable Map<Object, ? extends Object> paramMap1, @Nullable Map<Object, ? extends Object> paramMap2, @NotNull MethodChannel.Result paramResult)
  {
    Intrinsics.checkParameterIsNotNull(paramResult, "result");
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject = ((LogUtils)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("native router type: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", url: ");
      localStringBuilder.append(paramString2);
      ((ILog)localObject).a("ExpandFlutterUtils", 2, localStringBuilder.toString());
    }
    if (paramString1 != null) {
      switch (paramString1.hashCode())
      {
      default: 
        break;
      case 1481330904: 
        if (paramString1.equals("bySchema"))
        {
          paramString1 = QBaseActivity.sTopActivity;
          if (paramString1 == null) {
            return;
          }
          NativeNavigateUtils.a.c((Context)paramString1, paramString2);
          return;
        }
        break;
      case 1223471129: 
        if (paramString1.equals("webView"))
        {
          paramString1 = QBaseActivity.sTopActivity;
          if (paramString1 == null) {
            return;
          }
          NativeNavigateUtils.a.b((Context)paramString1, paramString2);
          return;
        }
        break;
      case 1064495690: 
        if (paramString1.equals("miniApp"))
        {
          paramString1 = QBaseActivity.sTopActivity;
          if (paramString1 == null) {
            return;
          }
          NativeNavigateUtils.a.a((Context)paramString1, paramString2);
          return;
        }
        break;
      case 191523977: 
        if (paramString1.equals("withoutSchema"))
        {
          if (TextUtils.isEmpty((CharSequence)paramString2)) {
            return;
          }
          paramString1 = Uri.parse(paramString2);
          if (paramString1 != null)
          {
            if (!TextUtils.equals((CharSequence)paramString1.getScheme(), (CharSequence)"mqqapi")) {
              return;
            }
            paramString2 = RouterManager.a.a().a(paramString1.getAuthority());
            if (paramString2 == null) {
              return;
            }
            paramString2.a(paramString1, paramMap1, paramMap2);
            return;
          }
          return;
        }
        break;
      }
    }
    paramMap1 = LogUtils.a;
    paramString2 = (Throwable)null;
    paramMap1 = paramMap1.a();
    paramMap2 = new StringBuilder();
    paramMap2.append("error native type: ");
    paramMap2.append(paramString1);
    paramMap1.a("ExpandFlutterUtils", 1, paramMap2.toString(), paramString2);
    paramResult.error("error type", null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.ExpandFlutterUtils.initNativeRouter.1
 * JD-Core Version:    0.7.0.1
 */