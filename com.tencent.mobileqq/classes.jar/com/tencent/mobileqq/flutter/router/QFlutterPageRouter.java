package com.tencent.mobileqq.flutter.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.flutter.channel.qqcircle.QCircleFlutterContainerFragment;
import com.tencent.mobileqq.flutter.channel.qqgame.GamePAFlutterContainerFragment;
import com.tencent.mobileqq.flutter.container.QFlutterContainerFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class QFlutterPageRouter
{
  private static Class<? extends QPublicBaseFragment> a(String paramString)
  {
    if (paramString.equals("qqGamePageRouter")) {
      return GamePAFlutterContainerFragment.class;
    }
    return QFlutterContainerFragment.class;
  }
  
  public static void a(Activity paramActivity, PageRouter paramPageRouter, int paramInt)
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
    ((Intent)localObject).putExtra("params", paramPageRouter.c);
    ((Intent)localObject).putExtra("status_bar_transparent", paramPageRouter.e);
    ((Intent)localObject).putExtra("status_text_dark", paramPageRouter.f);
    ((Intent)localObject).putExtra("preload_process", bool);
    ((Intent)localObject).putExtra("open_page_time", SystemClock.elapsedRealtime());
    QPublicFragmentActivityForTool.a(paramActivity, (Intent)localObject, QFlutterContainerFragment.class, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    a(paramActivity, new PageRouterBuilder().a(paramString1).b(paramString2).a(paramMap).a(), 1000);
  }
  
  public static void a(@NonNull Context paramContext, PageRouter paramPageRouter, @Nullable Bundle paramBundle)
  {
    a(paramContext, paramPageRouter, paramBundle, QCircleFlutterContainerFragment.class);
  }
  
  public static void a(@NonNull Context paramContext, PageRouter paramPageRouter, @Nullable Bundle paramBundle, Class<? extends QPublicBaseFragment> paramClass)
  {
    if (paramPageRouter == null)
    {
      QLog.d("QFlutterPageRouter", 2, "openPage, pageRouter is null");
      return;
    }
    Intent localIntent = new Intent();
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("entry_point", paramPageRouter.a);
    localIntent.putExtra("page_name", paramPageRouter.b);
    localIntent.putExtra("unique_id", paramPageRouter.d);
    localIntent.putExtra("params", paramPageRouter.c);
    localIntent.putExtra("background_transparent", paramPageRouter.g);
    localIntent.putExtra("status_bar_transparent", paramPageRouter.e);
    localIntent.putExtra("status_text_dark", paramPageRouter.f);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("preload_process", true);
    localIntent.putExtra("open_page_time", SystemClock.elapsedRealtime());
    QPublicTransFragmentActivity.a(paramContext, localIntent, paramClass);
  }
  
  public static void b(@NonNull Context paramContext, PageRouter paramPageRouter, @Nullable Bundle paramBundle)
  {
    if (paramPageRouter != null)
    {
      String str = paramPageRouter.b;
      if (TextUtils.isEmpty(str))
      {
        QLog.w("QFlutterPageRouter", 4, "pageName is null ");
        return;
      }
      Class localClass = a(str);
      if (localClass != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("pageName = ");
          localStringBuilder.append(str);
          localStringBuilder.append(" getBisFlutterFragment=");
          localStringBuilder.append(localClass.getSimpleName());
          QLog.d("QFlutterPageRouter", 4, localStringBuilder.toString());
        }
        a(paramContext, paramPageRouter, paramBundle, localClass);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.router.QFlutterPageRouter
 * JD-Core Version:    0.7.0.1
 */