package com.tencent.mobileqq.qqexpand.flutter;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.flutter.router.PageRouter;
import com.tencent.mobileqq.flutter.router.PageRouterBuilder;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.qqexpand.utils.ILog;
import com.tencent.mobileqq.qqexpand.utils.LogUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/flutter/ExpandFlutterContainerFragment$Companion;", "", "()V", "DELAY_PROGRESS_UPDATE", "", "DELAY_SPLASH_GONE", "LOAD_EXIT", "", "LOAD_SUCCESS", "TAG", "", "openFlutterPage", "", "context", "Landroid/content/Context;", "entry", "pageName", "params", "", "reportSession", "", "url", "openPageInner", "pageRouter", "Lcom/tencent/mobileqq/flutter/router/PageRouter;", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandFlutterContainerFragment$Companion
{
  public final void a(@Nullable Context paramContext, @Nullable PageRouter paramPageRouter, @Nullable byte[] paramArrayOfByte)
  {
    if (paramPageRouter == null)
    {
      QLog.d("QFlutterPageRouter", 2, "openPage, pageRouter is null");
      return;
    }
    boolean bool = PreloadProcHitSession.a("com.tencent.mobileqq:tool");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openPage: ");
      ((StringBuilder)localObject).append(paramPageRouter);
      ((StringBuilder)localObject).append(", isProcessExist: ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("QFlutterPageRouter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("entry_point", paramPageRouter.a);
    ((Intent)localObject).putExtra("page_name", paramPageRouter.b);
    ((Intent)localObject).putExtra("unique_id", paramPageRouter.d);
    ((Intent)localObject).putExtra("params", (Serializable)paramPageRouter.c);
    ((Intent)localObject).putExtra("status_bar_transparent", paramPageRouter.e);
    ((Intent)localObject).putExtra("status_text_dark", paramPageRouter.f);
    ((Intent)localObject).putExtra("preload_process", bool);
    ((Intent)localObject).putExtra("open_page_time", SystemClock.elapsedRealtime());
    ((Intent)localObject).putExtra("moduleId", "expand_flutter");
    ((Intent)localObject).putExtra("report_session", paramArrayOfByte);
    QPublicFragmentActivityForTool.a(paramContext, (Intent)localObject, ExpandFlutterContainerFragment.class);
  }
  
  public final void a(@Nullable Context paramContext, @NotNull String paramString1, @Nullable String paramString2, @Nullable Map<String, Object> paramMap, @Nullable byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "entry");
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject = ((LogUtils)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openPage: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(' ');
      localStringBuilder.append(paramString2);
      ((ILog)localObject).a("ExpandFlutterContainerFragment", 2, localStringBuilder.toString());
    }
    paramString1 = new PageRouterBuilder().a(paramMap).a(paramString1).b(paramString2).b(true).c(true).a();
    ((Companion)this).a(paramContext, paramString1, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.ExpandFlutterContainerFragment.Companion
 * JD-Core Version:    0.7.0.1
 */