package com.tencent.mobileqq.qqexpand.chat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper;
import com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper.Companion;
import com.tencent.mobileqq.qqexpand.widget.ColdPalaceTipDialog;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/chat/AioLimitColdPalaceHelper$Companion;", "", "()V", "LIMIT_CHAT_LIMIT", "", "TAG", "doOnBanishColdPalaceClick", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "context", "Landroid/content/Context;", "uinType", "", "frdUin", "iBanish", "Lcom/tencent/mobileqq/qqexpand/chat/IColdPalaceBanish;", "doOnColdPalaceLimitCancel", "doOnColdPalaceLimitConfirm", "activity", "Landroid/app/Activity;", "doOnReqThrowToColdPalace", "suc", "", "uin", "isUsedUp", "doOnShowBanishColdPalaceTipDialog", "doOnShowColdPalaceLimitTip", "onBanishColdPalaceGrayTipClick", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class AioLimitColdPalaceHelper$Companion
{
  @JvmStatic
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if ((paramContext instanceof BaseActivity))
    {
      Object localObject1 = (BaseActivity)paramContext;
      Object localObject2 = ((BaseActivity)localObject1).getChatFragment();
      if ((localObject2 != null) && (((ChatFragment)localObject2).a() != null))
      {
        localObject2 = ((ChatFragment)localObject2).a();
        if ((localObject2 instanceof LimitChatPie))
        {
          paramContext = (QBaseActivity)localObject1;
          int i = ((BaseChatPie)localObject2).a.jdField_a_of_type_Int;
          localObject2 = ((BaseChatPie)localObject2).a.jdField_a_of_type_JavaLangString;
          localObject1 = ((BaseActivity)localObject1).app;
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.app");
          NewReportPlugin.a(paramContext, i, (String)localObject2, ((QQAppInterface)localObject1).getCurrentAccountUin(), "");
          return;
        }
        paramContext = QQToast.a(paramContext, (CharSequence)paramContext.getResources().getString(2131698831), 1);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "baseChatPie");
        paramContext.b(((BaseChatPie)localObject2).a());
      }
    }
  }
  
  @JvmStatic
  public final void a(@NotNull BaseQQAppInterface paramBaseQQAppInterface, @NotNull Activity paramActivity, int paramInt, @NotNull String paramString, @NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    Intrinsics.checkParameterIsNotNull(paramIColdPalaceBanish, "iBanish");
    paramIColdPalaceBanish = paramIColdPalaceBanish.a();
    if (paramIColdPalaceBanish != null) {
      paramIColdPalaceBanish.dismiss();
    }
    NewReportPlugin.a((QBaseActivity)paramActivity, paramInt, paramString, paramBaseQQAppInterface.getCurrentAccountUin(), "");
    ReportController.b(null, "dc00898", "", "", "0X800B2D0", "0X800B2D0", 1, 0, "", "", "", "");
  }
  
  @JvmStatic
  public final void a(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Context paramContext, int paramInt, @NotNull String paramString, @NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    Intrinsics.checkParameterIsNotNull(paramIColdPalaceBanish, "iBanish");
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing()))
    {
      if (paramBaseQQAppInterface == null) {
        return;
      }
      Object localObject = paramIColdPalaceBanish.a();
      if (localObject != null) {
        ((Dialog)localObject).dismiss();
      }
      localObject = ColdPalaceHelper.a.a(paramBaseQQAppInterface);
      paramIColdPalaceBanish.a((Dialog)new ColdPalaceTipDialog(paramContext, paramBaseQQAppInterface, paramString, paramInt, String.valueOf(paramIColdPalaceBanish.a())));
      paramBaseQQAppInterface = paramIColdPalaceBanish.a();
      if (paramBaseQQAppInterface != null)
      {
        ((ColdPalaceTipDialog)paramBaseQQAppInterface).a(((ColdPalaceHelper)localObject).a(0));
        ReportController.b(null, "dc00898", "", "", "0X800B2C6", "0X800B2C6", paramIColdPalaceBanish.a(), 0, "", "", "", "");
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.widget.ColdPalaceTipDialog");
    }
  }
  
  @JvmStatic
  public final void a(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Context paramContext, @NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    Intrinsics.checkParameterIsNotNull(paramIColdPalaceBanish, "iBanish");
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing()))
    {
      if (paramBaseQQAppInterface == null) {
        return;
      }
      paramBaseQQAppInterface = ColdPalaceHelper.a.a(paramBaseQQAppInterface);
      String str = paramBaseQQAppInterface.a(1);
      if ((paramContext instanceof ChatSettingActivity))
      {
        QQToast.a(paramContext, (CharSequence)str, 1).a();
      }
      else
      {
        Dialog localDialog = paramIColdPalaceBanish.a();
        if (localDialog != null) {
          localDialog.dismiss();
        }
        paramIColdPalaceBanish.a((Dialog)DialogUtil.a(paramContext, 230, str, paramBaseQQAppInterface.a(2), 2131690728, 2131698792, (DialogInterface.OnClickListener)new AioLimitColdPalaceHelper.Companion.doOnShowColdPalaceLimitTip.1(paramIColdPalaceBanish), (DialogInterface.OnClickListener)new AioLimitColdPalaceHelper.Companion.doOnShowColdPalaceLimitTip.2(paramIColdPalaceBanish)));
        paramBaseQQAppInterface = paramIColdPalaceBanish.a();
        if (paramBaseQQAppInterface != null) {
          paramBaseQQAppInterface.show();
        }
      }
      ReportController.b(null, "dc00898", "", "", "0X800B2CA", "0X800B2CA", paramIColdPalaceBanish.a(), 0, "", "", "", "");
    }
  }
  
  @JvmStatic
  public final void a(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Context paramContext, boolean paramBoolean1, int paramInt, @NotNull String paramString, boolean paramBoolean2, @NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Intrinsics.checkParameterIsNotNull(paramIColdPalaceBanish, "iBanish");
    if ((paramBaseQQAppInterface instanceof QQAppInterface))
    {
      if (!(paramContext instanceof BaseActivity)) {
        return;
      }
      if ((paramBoolean1) && ((Intrinsics.areEqual(BaseActivity.sTopActivity, paramContext) ^ true)))
      {
        ((BaseActivity)paramContext).finish();
        return;
      }
      if (paramBoolean1)
      {
        paramBaseQQAppInterface = (Context)BaseApplicationImpl.getContext();
        paramIColdPalaceBanish = BaseApplicationImpl.getContext();
        Intrinsics.checkExpressionValueIsNotNull(paramIColdPalaceBanish, "BaseApplicationImpl.getContext()");
        paramBaseQQAppInterface = QQToast.a(paramBaseQQAppInterface, 2, (CharSequence)paramIColdPalaceBanish.getResources().getString(2131698800), 1);
        paramContext = (BaseActivity)paramContext;
        paramBaseQQAppInterface.b(paramContext.getTitleBarHeight());
        paramContext.finish();
        ReportController.b(null, "dc00898", "", "", "0X800B2C8", "0X800B2C8", 1, 0, "", "", "", "");
      }
      else if (!paramBoolean1)
      {
        if (paramBoolean2)
        {
          ((Companion)this).a(paramBaseQQAppInterface, paramContext, paramIColdPalaceBanish);
        }
        else
        {
          paramBaseQQAppInterface = (Context)BaseApplicationImpl.getContext();
          paramIColdPalaceBanish = BaseApplicationImpl.getContext();
          Intrinsics.checkExpressionValueIsNotNull(paramIColdPalaceBanish, "BaseApplicationImpl.getContext()");
          QQToast.a(paramBaseQQAppInterface, 1, (CharSequence)paramIColdPalaceBanish.getResources().getString(2131698799), 1).b(((BaseActivity)paramContext).getTitleBarHeight());
        }
        ReportController.b(null, "dc00898", "", "", "0X800B2C8", "0X800B2C8", 2, 0, "", "", "", "");
      }
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("doOnReqThrowToColdPalace suc=");
      paramBaseQQAppInterface.append(paramBoolean1);
      paramBaseQQAppInterface.append(" uinType=");
      paramBaseQQAppInterface.append(paramInt);
      paramBaseQQAppInterface.append(" uin=");
      paramBaseQQAppInterface.append(MobileQQ.getShortUinStr(paramString));
      QLog.d("AioLimitColdPalaceHelper", 1, paramBaseQQAppInterface.toString());
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
  public final void b(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Context paramContext, int paramInt, @NotNull String paramString, @NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    Intrinsics.checkParameterIsNotNull(paramIColdPalaceBanish, "iBanish");
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing()))
    {
      if (paramBaseQQAppInterface == null) {
        return;
      }
      ColdPalaceHelper localColdPalaceHelper = ColdPalaceHelper.a.a(paramBaseQQAppInterface);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnBanishColdPalaceClick skillTimesLeft:");
        localStringBuilder.append(localColdPalaceHelper.a());
        localStringBuilder.append(" from:");
        localStringBuilder.append(paramIColdPalaceBanish.a());
        QLog.i("AioLimitColdPalaceHelper", 2, localStringBuilder.toString());
      }
      if ((localColdPalaceHelper.a() <= 0) && (localColdPalaceHelper.a() != -2147483648)) {
        ((Companion)this).a(paramBaseQQAppInterface, paramContext, paramIColdPalaceBanish);
      } else {
        ((Companion)this).a(paramBaseQQAppInterface, paramContext, paramInt, paramString, paramIColdPalaceBanish);
      }
      ReportController.b(null, "dc00898", "", "", "0X800B2C4", "0X800B2C4", paramIColdPalaceBanish.a(), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.AioLimitColdPalaceHelper.Companion
 * JD-Core Version:    0.7.0.1
 */