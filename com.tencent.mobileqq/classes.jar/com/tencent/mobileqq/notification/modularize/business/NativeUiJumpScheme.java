package com.tencent.mobileqq.notification.modularize.business;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.notification.modularize.BaseJumpScheme;
import com.tencent.mobileqq.notification.modularize.PushComponent;
import com.tencent.mobileqq.settings.message.NotifyPushSettingFragment;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/NativeUiJumpScheme;", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "()V", "customJumpIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "nativeUiIntent", "needCustomJump", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class NativeUiJumpScheme
  extends BaseJumpScheme
{
  @NotNull
  protected PendingIntent a(@NotNull PushComponent paramPushComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramPushComponent, "pushComponent");
    return e(paramPushComponent);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  @NotNull
  public final PendingIntent e(@NotNull PushComponent paramPushComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramPushComponent, "pushComponent");
    Context localContext = (Context)BaseApplication.context;
    Intent localIntent = new Intent(localContext, NotifyPushSettingFragment.class);
    localIntent.addFlags(268435456);
    paramPushComponent = PendingIntent.getActivity(localContext, paramPushComponent.d, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramPushComponent, "PendingIntent.getActivit…tent.FLAG_UPDATE_CURRENT)");
    return paramPushComponent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.notification.modularize.business.NativeUiJumpScheme
 * JD-Core Version:    0.7.0.1
 */