package com.tencent.mobileqq.notification.modularize.business;

import android.app.PendingIntent;
import com.tencent.mobileqq.notification.modularize.BaseJumpScheme;
import com.tencent.mobileqq.notification.modularize.PushComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/DefaultJumpScheme;", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "()V", "customJumpIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "needCustomJump", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class DefaultJumpScheme
  extends BaseJumpScheme
{
  @NotNull
  public PendingIntent a(@NotNull PushComponent paramPushComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramPushComponent, "pushComponent");
    return d(paramPushComponent);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.notification.modularize.business.DefaultJumpScheme
 * JD-Core Version:    0.7.0.1
 */