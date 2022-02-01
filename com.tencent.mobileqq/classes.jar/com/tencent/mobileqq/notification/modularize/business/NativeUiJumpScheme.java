package com.tencent.mobileqq.notification.modularize.business;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.notification.modularize.BaseJumpScheme;
import com.tencent.mobileqq.notification.modularize.PushComponent;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/NativeUiJumpScheme;", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "()V", "customJumpIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "nativeUiIntent", "needCustomJump", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class NativeUiJumpScheme
  extends BaseJumpScheme
{
  @NotNull
  public PendingIntent a(@NotNull PushComponent paramPushComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramPushComponent, "pushComponent");
    return e(paramPushComponent);
  }
  
  public boolean a()
  {
    return true;
  }
  
  @NotNull
  public final PendingIntent e(@NotNull PushComponent paramPushComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramPushComponent, "pushComponent");
    BaseApplication localBaseApplication = BaseApplication.context;
    Intent localIntent = new Intent((Context)localBaseApplication, NotifyPushSettingActivity.class);
    localIntent.addFlags(268435456);
    paramPushComponent = PendingIntent.getActivity((Context)localBaseApplication, paramPushComponent.d, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramPushComponent, "PendingIntent.getActivit…tent.FLAG_UPDATE_CURRENT)");
    return paramPushComponent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.notification.modularize.business.NativeUiJumpScheme
 * JD-Core Version:    0.7.0.1
 */