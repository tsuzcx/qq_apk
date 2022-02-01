package com.tencent.mobileqq.extendfriend.limitchat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.utils.ColdPalaceHelper;
import com.tencent.mobileqq.extendfriend.utils.ColdPalaceHelper.Companion;
import com.tencent.mobileqq.extendfriend.wiget.ColdPalaceTipDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/extendfriend/limitchat/AioLimitColdPalaceHelper$Companion;", "", "()V", "LIMIT_CHAT_LIMIT", "", "TAG", "doOnBanishColdPalaceClick", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "context", "Landroid/content/Context;", "uinType", "", "frdUin", "iBanish", "Lcom/tencent/mobileqq/extendfriend/limitchat/IColdPalaceBanish;", "doOnColdPalaceLimitCancel", "doOnColdPalaceLimitConfirm", "activity", "Landroid/app/Activity;", "doOnReqThrowToColdPalace", "suc", "", "uin", "isUsedUp", "doOnShowBanishColdPalaceTipDialog", "doOnShowColdPalaceLimitTip", "onBanishColdPalaceGrayTipClick", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AioLimitColdPalaceHelper$Companion
{
  @JvmStatic
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Object localObject;
    if ((paramContext instanceof FragmentActivity))
    {
      localObject = ((FragmentActivity)paramContext).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).a() != null))
      {
        localObject = ((ChatFragment)localObject).a();
        if (!(localObject instanceof LimitChatPie)) {
          break label96;
        }
        AioLimitColdPalaceHelper localAioLimitColdPalaceHelper = (AioLimitColdPalaceHelper)((BaseChatPie)localObject).a(77);
        if (localAioLimitColdPalaceHelper != null)
        {
          QQAppInterface localQQAppInterface = ((FragmentActivity)paramContext).app;
          Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "context.app");
          localAioLimitColdPalaceHelper.a(localQQAppInterface, paramContext, ((BaseChatPie)localObject).a.jdField_a_of_type_Int, ((BaseChatPie)localObject).a.jdField_a_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      return;
      label96:
      paramContext = QQToast.a(paramContext, (CharSequence)paramContext.getResources().getString(2131698720), 1);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "baseChatPie");
      paramContext.b(((BaseChatPie)localObject).a());
    }
  }
  
  @JvmStatic
  public final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull Activity paramActivity, int paramInt, @NotNull String paramString, @NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    Intrinsics.checkParameterIsNotNull(paramIColdPalaceBanish, "iBanish");
    paramIColdPalaceBanish = paramIColdPalaceBanish.a();
    if (paramIColdPalaceBanish != null) {
      paramIColdPalaceBanish.dismiss();
    }
    NewReportPlugin.a((BaseActivity)paramActivity, paramInt, paramString, paramQQAppInterface.getCurrentAccountUin(), "");
    ReportController.b(null, "dc00898", "", "", "0X800B2D0", "0X800B2D0", 1, 0, "", "", "", "");
  }
  
  @JvmStatic
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, int paramInt, @NotNull String paramString, @NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    Intrinsics.checkParameterIsNotNull(paramIColdPalaceBanish, "iBanish");
    if ((!(paramContext instanceof Activity)) || (((Activity)paramContext).isFinishing()) || (paramQQAppInterface == null)) {
      return;
    }
    Object localObject = paramIColdPalaceBanish.a();
    if (localObject != null) {
      ((Dialog)localObject).dismiss();
    }
    localObject = ColdPalaceHelper.a.a(paramQQAppInterface);
    paramIColdPalaceBanish.a((Dialog)new ColdPalaceTipDialog(paramContext, paramQQAppInterface, paramString, paramInt, String.valueOf(paramIColdPalaceBanish.a())));
    paramQQAppInterface = paramIColdPalaceBanish.a();
    if (paramQQAppInterface == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.extendfriend.wiget.ColdPalaceTipDialog");
    }
    ((ColdPalaceTipDialog)paramQQAppInterface).a(((ColdPalaceHelper)localObject).a(0));
    ReportController.b(null, "dc00898", "", "", "0X800B2C6", "0X800B2C6", paramIColdPalaceBanish.a(), 0, "", "", "", "");
  }
  
  @JvmStatic
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, @NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    Intrinsics.checkParameterIsNotNull(paramIColdPalaceBanish, "iBanish");
    if ((!(paramContext instanceof Activity)) || (((Activity)paramContext).isFinishing()) || (paramQQAppInterface == null)) {
      return;
    }
    paramQQAppInterface = ColdPalaceHelper.a.a(paramQQAppInterface);
    String str = paramQQAppInterface.a(1);
    if ((paramContext instanceof ChatSettingActivity)) {
      QQToast.a(paramContext, (CharSequence)str, 1).a();
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B2CA", "0X800B2CA", paramIColdPalaceBanish.a(), 0, "", "", "", "");
      return;
      Dialog localDialog = paramIColdPalaceBanish.a();
      if (localDialog != null) {
        localDialog.dismiss();
      }
      paramIColdPalaceBanish.a((Dialog)DialogUtil.a(paramContext, 230, str, paramQQAppInterface.a(2), 2131690800, 2131698717, (DialogInterface.OnClickListener)new AioLimitColdPalaceHelper.Companion.doOnShowColdPalaceLimitTip.1(paramIColdPalaceBanish), (DialogInterface.OnClickListener)new AioLimitColdPalaceHelper.Companion.doOnShowColdPalaceLimitTip.2(paramIColdPalaceBanish)));
      paramQQAppInterface = paramIColdPalaceBanish.a();
      if (paramQQAppInterface != null) {
        paramQQAppInterface.show();
      }
    }
  }
  
  @JvmStatic
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, boolean paramBoolean1, int paramInt, @NotNull String paramString, boolean paramBoolean2, @NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Intrinsics.checkParameterIsNotNull(paramIColdPalaceBanish, "iBanish");
    if ((!(paramQQAppInterface instanceof QQAppInterface)) || (!(paramContext instanceof BaseActivity))) {
      return;
    }
    if ((paramBoolean1) && ((Intrinsics.areEqual(BaseActivity.sTopActivity, paramContext) ^ true)))
    {
      ((BaseActivity)paramContext).finish();
      return;
    }
    if (paramBoolean1)
    {
      paramQQAppInterface = (Context)BaseApplicationImpl.getContext();
      paramIColdPalaceBanish = BaseApplicationImpl.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramIColdPalaceBanish, "BaseApplicationImpl.getContext()");
      QQToast.a(paramQQAppInterface, 2, (CharSequence)paramIColdPalaceBanish.getResources().getString(2131698725), 1).b(((BaseActivity)paramContext).getTitleBarHeight());
      ((BaseActivity)paramContext).finish();
      ReportController.b(null, "dc00898", "", "", "0X800B2C8", "0X800B2C8", 1, 0, "", "", "", "");
    }
    while (paramBoolean1)
    {
      QLog.d("AioLimitColdPalaceHelper", 1, "doOnReqThrowToColdPalace suc=" + paramBoolean1 + " uinType=" + paramInt + " uin=" + MobileQQ.getShortUinStr(paramString));
      return;
    }
    if (paramBoolean2) {
      ((Companion)this).a(paramQQAppInterface, paramContext, paramIColdPalaceBanish);
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B2C8", "0X800B2C8", 2, 0, "", "", "", "");
      break;
      paramQQAppInterface = (Context)BaseApplicationImpl.getContext();
      paramIColdPalaceBanish = BaseApplicationImpl.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramIColdPalaceBanish, "BaseApplicationImpl.getContext()");
      QQToast.a(paramQQAppInterface, 1, (CharSequence)paramIColdPalaceBanish.getResources().getString(2131698724), 1).b(((BaseActivity)paramContext).getTitleBarHeight());
    }
  }
  
  @JvmStatic
  public final void a(@NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    Intrinsics.checkParameterIsNotNull(paramIColdPalaceBanish, "iBanish");
    paramIColdPalaceBanish = paramIColdPalaceBanish.a();
    if (paramIColdPalaceBanish != null) {
      paramIColdPalaceBanish.dismiss();
    }
    ReportController.b(null, "dc00898", "", "", "0X800B2D0", "0X800B2D0", 2, 0, "", "", "", "");
  }
  
  @JvmStatic
  public final void b(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, int paramInt, @NotNull String paramString, @NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    Intrinsics.checkParameterIsNotNull(paramIColdPalaceBanish, "iBanish");
    if ((!(paramContext instanceof Activity)) || (((Activity)paramContext).isFinishing()) || (paramQQAppInterface == null)) {
      return;
    }
    ColdPalaceHelper localColdPalaceHelper = ColdPalaceHelper.a.a(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.i("AioLimitColdPalaceHelper", 2, "doOnBanishColdPalaceClick skillTimesLeft:" + localColdPalaceHelper.a() + " from:" + paramIColdPalaceBanish.a());
    }
    if ((localColdPalaceHelper.a() > 0) || (localColdPalaceHelper.a() == -2147483648)) {
      ((Companion)this).a(paramQQAppInterface, paramContext, paramInt, paramString, paramIColdPalaceBanish);
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B2C4", "0X800B2C4", paramIColdPalaceBanish.a(), 0, "", "", "", "");
      return;
      ((Companion)this).a(paramQQAppInterface, paramContext, paramIColdPalaceBanish);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.AioLimitColdPalaceHelper.Companion
 * JD-Core Version:    0.7.0.1
 */