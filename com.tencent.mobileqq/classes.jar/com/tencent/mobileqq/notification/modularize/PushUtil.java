package com.tencent.mobileqq.notification.modularize;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/PushUtil;", "", "()V", "INVALID_MAIN_BUSINESS_ID", "", "KEY_MAIN_BUSINESS_ID", "", "KEY_MAIN_PUSH_ACTION", "KEY_PUSH_ID", "KEY_PUSH_TRIGGER_INFO", "KEY_SUB_BUSINESS_ID", "KEY_THIRD_PARTY_PUSH_ACTION", "addBrowserIntent", "", "intent", "Landroid/content/Intent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "getBitmapFromUrl", "Landroid/graphics/Bitmap;", "iconUrl", "reportAdBoss", "selfUin", "actionId", "pushId", "triggerInfo", "reportPushClick", "mainBusinessId", "subBusinessId", "action", "reportThirdPushClick", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PushUtil
{
  public static final PushUtil a = new PushUtil();
  
  @JvmStatic
  public static final void a(int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    a(paramInt1, paramInt2, String.valueOf(paramInt3), paramString, "0X800AE74");
  }
  
  @JvmStatic
  public static final void a(int paramInt1, int paramInt2, @Nullable String paramString1, @Nullable String paramString2)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, "0X800BBD0");
  }
  
  @JvmStatic
  public static final void a(int paramInt1, int paramInt2, @Nullable String paramString1, @Nullable String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString3, "action");
    if (paramInt1 != -1)
    {
      ReportController.b(null, "dc00898", "", "", paramString3, paramString3, paramInt1, 0, String.valueOf(paramInt2), paramString1, "", "");
      paramString3 = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(paramString3, "BaseApplicationImpl.getApplication()");
      Object localObject = paramString3.getRuntime();
      paramString3 = a;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "runtime");
      localObject = ((AppRuntime)localObject).getAccount();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "runtime.account");
      paramString3.a((String)localObject, 118, String.valueOf(paramString1), paramString2);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("no need report mainBusinessId: ");
      paramString1.append(paramInt1);
      QLog.d("PushUtil", 2, new Object[] { "reportPushClick: called. ", paramString1.toString() });
    }
  }
  
  @JvmStatic
  public static final void a(@NotNull Intent paramIntent, @NotNull PushComponent paramPushComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    Intrinsics.checkParameterIsNotNull(paramPushComponent, "pushComponent");
    paramIntent.putExtra("KEY_MAIN_BUSINESS_ID", paramPushComponent.a);
    paramIntent.putExtra("KEY_SUB_BUSINESS_ID", paramPushComponent.b);
    paramIntent.putExtra("KEY_PUSH_ID", paramPushComponent.c);
    paramIntent.putExtra("KEY_PUSH_TRIGGER_INFO", paramPushComponent.i);
  }
  
  @Nullable
  public final Bitmap a(@Nullable String paramString)
  {
    return NewMsgNotificationManager.a(paramString);
  }
  
  public final void a(@NotNull String paramString1, int paramInt, @NotNull String paramString2, @Nullable String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "selfUin");
    Intrinsics.checkParameterIsNotNull(paramString2, "pushId");
    TianShuReportData localTianShuReportData = new TianShuReportData();
    long l = System.currentTimeMillis() / 1000;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append('_');
    localStringBuilder.append(l);
    localTianShuReportData.b = localStringBuilder.toString();
    localTianShuReportData.p = paramInt;
    localTianShuReportData.q = 1;
    localTianShuReportData.h = paramString2;
    localTianShuReportData.o = l;
    if (paramString3 != null) {
      localTianShuReportData.s = paramString3;
    }
    localTianShuReportData.c = 1;
    localTianShuReportData.f = "vab_push";
    localTianShuReportData.g = "vab_push";
    localTianShuReportData.j = "";
    TianShuManager.getInstance().report(localTianShuReportData);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("pushId: ");
      paramString1.append(paramString2);
      paramString1.append("  actionId: ");
      paramString1.append(paramInt);
      QLog.d("PushUtil", 2, new Object[] { "reportAdBoss: called. ", paramString1.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.notification.modularize.PushUtil
 * JD-Core Version:    0.7.0.1
 */