package com.tencent.mobileqq.notification.modularize;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.Style;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/NotificationBuilder;", "", "()V", "build", "Landroid/app/Notification;", "contentIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class NotificationBuilder
{
  public static final NotificationBuilder a = new NotificationBuilder();
  
  @RequiresApi(16)
  @NotNull
  public final Notification a(@Nullable PendingIntent paramPendingIntent, @NotNull PushComponent paramPushComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramPushComponent, "pushComponent");
    NotificationCompat.BigTextStyle localBigTextStyle = new NotificationCompat.BigTextStyle();
    localBigTextStyle.bigText((CharSequence)paramPushComponent.c);
    paramPendingIntent = new NotificationCompat.Builder((Context)BaseApplication.context).setSmallIcon(2130841471).setAutoCancel(true).setContentText((CharSequence)paramPushComponent.c).setWhen(System.currentTimeMillis()).setTicker((CharSequence)paramPushComponent.c).setContentIntent(paramPendingIntent).setPriority(2).setStyle((NotificationCompat.Style)localBigTextStyle);
    if (!TextUtils.isEmpty((CharSequence)paramPushComponent.a)) {
      paramPendingIntent.setContentTitle((CharSequence)paramPushComponent.a);
    }
    if ((SdkInfoUtil.isOreo()) && (SdkInfoUtil.isTargetSDKOreo())) {
      paramPendingIntent.setChannelId("CHANNEL_ID_OTHER");
    }
    paramPushComponent = PushUtil.a.a(paramPushComponent.b);
    if (paramPushComponent != null) {
      paramPendingIntent.setLargeIcon(paramPushComponent);
    }
    paramPendingIntent = paramPendingIntent.build();
    Intrinsics.checkExpressionValueIsNotNull(paramPendingIntent, "notifyBuilder.build()");
    return paramPendingIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.notification.modularize.NotificationBuilder
 * JD-Core Version:    0.7.0.1
 */