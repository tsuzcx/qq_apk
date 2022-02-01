package com.tencent.mobileqq.notification.modularize;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "", "()V", "customJumpIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "fallbackJumpIntent", "jumpActionIntent", "jumpIntent", "jumpMsgTabIntent", "needCustomJump", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class BaseJumpScheme
{
  private final PendingIntent e(PushComponent paramPushComponent)
  {
    Context localContext = (Context)BaseApplication.context;
    Intent localIntent = new Intent(localContext, SplashActivity.class);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    localIntent.putExtra("fragment_id", 1);
    localIntent.setFlags(335544320);
    paramPushComponent = PendingIntent.getActivity(localContext, paramPushComponent.jdField_d_of_type_Int, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramPushComponent, "jumpPendingIntent");
    return paramPushComponent;
  }
  
  @NotNull
  protected abstract PendingIntent a(@NotNull PushComponent paramPushComponent);
  
  protected boolean a()
  {
    return false;
  }
  
  @NotNull
  public final PendingIntent b(@NotNull PushComponent paramPushComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramPushComponent, "pushComponent");
    if (a()) {
      return a(paramPushComponent);
    }
    return c(paramPushComponent);
  }
  
  @NotNull
  public final PendingIntent c(@NotNull PushComponent paramPushComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramPushComponent, "pushComponent");
    if (Intrinsics.areEqual(paramPushComponent.jdField_d_of_type_JavaLangString, "")) {
      return e(paramPushComponent);
    }
    Context localContext = (Context)BaseApplication.context;
    Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramPushComponent.jdField_d_of_type_JavaLangString);
    localIntent.addFlags(268435456);
    PushUtil.a(localIntent, paramPushComponent);
    localIntent.putExtra("param_notifyid", paramPushComponent.jdField_d_of_type_Int);
    paramPushComponent = PendingIntent.getActivity(localContext, paramPushComponent.jdField_d_of_type_Int, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramPushComponent, "jumpPendingIntent");
    return paramPushComponent;
  }
  
  @NotNull
  public final PendingIntent d(@NotNull PushComponent paramPushComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramPushComponent, "pushComponent");
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramPushComponent.jdField_d_of_type_JavaLangString));
    localIntent.setFlags(268435456);
    paramPushComponent = PendingIntent.getActivity((Context)BaseApplication.context, paramPushComponent.jdField_d_of_type_Int, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramPushComponent, "PendingIntent.getActivit…tent.FLAG_UPDATE_CURRENT)");
    return paramPushComponent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.notification.modularize.BaseJumpScheme
 * JD-Core Version:    0.7.0.1
 */