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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/PushUtil;", "", "()V", "INVALID_MAIN_BUSINESS_ID", "", "KEY_MAIN_BUSINESS_ID", "", "KEY_PUSH_ID", "KEY_PUSH_TRIGGER_INFO", "KEY_SUB_BUSINESS_ID", "addBrowserIntent", "", "intent", "Landroid/content/Intent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "getBitmapFromUrl", "Landroid/graphics/Bitmap;", "iconUrl", "reportAdBoss", "selfUin", "actionId", "pushId", "triggerInfo", "reportPushClick", "mainBusinessId", "subBusinessId", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PushUtil
{
  public static final PushUtil a = new PushUtil();
  
  @JvmStatic
  public static final void a(int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    if (paramInt1 != -1)
    {
      ReportController.b(null, "dc00898", "", "", "0X800AE74", "0X800AE74", paramInt1, 0, String.valueOf(paramInt2), String.valueOf(paramInt3), "", "");
      localObject1 = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
      localObject2 = ((BaseApplicationImpl)localObject1).getRuntime();
      localObject1 = a;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "runtime");
      localObject2 = ((AppRuntime)localObject2).getAccount();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "runtime.account");
      ((PushUtil)localObject1).a((String)localObject2, 118, String.valueOf(paramInt3), paramString);
    }
    while (!QLog.isColorLevel())
    {
      Object localObject1;
      Object localObject2;
      return;
    }
    QLog.d("PushUtil", 2, new Object[] { "reportPushClick: called. ", "no need report mainBusinessId: " + paramInt1 });
  }
  
  @JvmStatic
  public static final void a(@NotNull Intent paramIntent, @NotNull PushComponent paramPushComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    Intrinsics.checkParameterIsNotNull(paramPushComponent, "pushComponent");
    paramIntent.putExtra("KEY_MAIN_BUSINESS_ID", paramPushComponent.jdField_a_of_type_Int);
    paramIntent.putExtra("KEY_SUB_BUSINESS_ID", paramPushComponent.b);
    paramIntent.putExtra("KEY_PUSH_ID", paramPushComponent.c);
    paramIntent.putExtra("KEY_PUSH_TRIGGER_INFO", paramPushComponent.jdField_e_of_type_JavaLangString);
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
    localTianShuReportData.b = (paramString1 + '_' + l);
    localTianShuReportData.d = paramInt;
    localTianShuReportData.jdField_e_of_type_Int = 1;
    localTianShuReportData.g = paramString2;
    localTianShuReportData.jdField_a_of_type_Long = l;
    if (paramString3 != null) {
      localTianShuReportData.l = paramString3;
    }
    localTianShuReportData.jdField_a_of_type_Int = 1;
    localTianShuReportData.jdField_e_of_type_JavaLangString = "vab_push";
    localTianShuReportData.f = "vab_push";
    localTianShuReportData.i = "";
    TianShuManager.getInstance().report(localTianShuReportData);
    if (QLog.isColorLevel()) {
      QLog.d("PushUtil", 2, new Object[] { "reportAdBoss: called. ", "pushId: " + paramString2 + "  actionId: " + paramInt });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.notification.modularize.PushUtil
 * JD-Core Version:    0.7.0.1
 */