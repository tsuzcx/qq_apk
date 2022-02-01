package com.tencent.mobileqq.kandian.biz.push;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity;
import com.tencent.mobileqq.kandian.biz.push.api.IPushNotifyDialogCallback;
import com.tencent.mobileqq.kandian.biz.push.api.IRIJPushNotifyManager;
import com.tencent.mobileqq.kandian.biz.push.mvp.RIJPushNotifyDialog;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/push/RIJPushNotifyManager;", "Lcom/tencent/mobileqq/kandian/biz/push/api/IRIJPushNotifyManager;", "()V", "checkBoxText", "", "getCheckBoxText", "()Ljava/lang/String;", "dialogShowDuration", "", "getDialogShowDuration", "()J", "shouldShowDialog", "", "type1ButtonText", "getType1ButtonText", "type1HeaderText", "getType1HeaderText", "type2HeaderText", "getType2HeaderText", "type2LeftButtonText", "getType2LeftButtonText", "type2RightButtonText", "getType2RightButtonText", "dismiss", "", "needAnimation", "uin", "getParam", "Lcom/tencent/mobileqq/kandian/biz/push/RIJPushNotifyParam;", "guideType", "", "topActivity", "Landroid/app/Activity;", "avatarUrl", "isDarkMode", "hasNightMode", "logicAction", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isOpenPushNotify", "isDefaultOpen", "buttonId", "reportDialogButtonClicked", "bizType", "uniqueId", "reportDialogCloseIconClicked", "reportDialogExposure", "showPushNotifyDialog", "isForceDarkMode", "showPushNotifyDialogForWeb", "callback", "Lcom/tencent/mobileqq/kandian/biz/push/api/IPushNotifyDialogCallback;", "showToast", "activity", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPushNotifyManager
  implements IRIJPushNotifyManager
{
  public static final RIJPushNotifyManager.Companion Companion = new RIJPushNotifyManager.Companion(null);
  private static final String TAG = "RIJPushNotifyManager";
  @NotNull
  private static final Lazy instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)RIJPushNotifyManager.Companion.instance.2.INSTANCE);
  @NotNull
  private final String checkBoxText;
  private final long dialogShowDuration;
  private final boolean shouldShowDialog;
  @NotNull
  private final String type1ButtonText;
  @NotNull
  private final String type1HeaderText;
  @NotNull
  private final String type2HeaderText;
  @NotNull
  private final String type2LeftButtonText;
  @NotNull
  private final String type2RightButtonText;
  
  public RIJPushNotifyManager()
  {
    Object localObject = Aladdin.getConfig(340);
    boolean bool = false;
    if (((AladdinConfig)localObject).getIntegerFromString("enable_alert", 0) == 1) {
      bool = true;
    }
    this.shouldShowDialog = bool;
    this.dialogShowDuration = (Aladdin.getConfig(340).getIntegerFromString("show_duration", 10) * 1000L);
    localObject = Aladdin.getConfig(340).getString("checkbox_text", ReadInJoyUtils.a(2131717843));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Aladdin.getConfig(QQAlad…efault_open_push_notify))");
    this.checkBoxText = ((String)localObject);
    localObject = Aladdin.getConfig(340).getString("type1_header_text", ReadInJoyUtils.a(2131717938));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Aladdin.getConfig(QQAlad…_has_closed_push_notify))");
    this.type1HeaderText = ((String)localObject);
    localObject = Aladdin.getConfig(340).getString("type1_button_text", ReadInJoyUtils.a(2131717981));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Aladdin.getConfig(QQAlad…injoy_open_it_right_now))");
    this.type1ButtonText = ((String)localObject);
    localObject = Aladdin.getConfig(340).getString("type2_header_text", ReadInJoyUtils.a(2131717939));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Aladdin.getConfig(QQAlad…_has_opened_push_notify))");
    this.type2HeaderText = ((String)localObject);
    localObject = Aladdin.getConfig(340).getString("type2_left_button_text", ReadInJoyUtils.a(2131690874));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Aladdin.getConfig(QQAlad…etString(R.string.close))");
    this.type2LeftButtonText = ((String)localObject);
    localObject = Aladdin.getConfig(340).getString("type2_right_button_text", ReadInJoyUtils.a(2131717941));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Aladdin.getConfig(QQAlad…g.readinjoy_i_dont_need))");
    this.type2RightButtonText = ((String)localObject);
  }
  
  private final RIJPushNotifyParam getParam(int paramInt, Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, Function3<? super Boolean, ? super Boolean, ? super Integer, Unit> paramFunction3)
  {
    int i;
    if ((paramActivity instanceof SplashActivity)) {
      i = DisplayUtil.a((Context)paramActivity, 72.0F);
    } else {
      i = DisplayUtil.a((Context)paramActivity, 16.0F);
    }
    if ((ThemeUtil.isNowThemeIsNight(ReadInJoyUtils.a(), false, null)) && (paramBoolean2)) {
      paramBoolean2 = true;
    } else {
      paramBoolean2 = false;
    }
    if (paramInt == 1) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    return new RIJPushNotifyParam(paramInt, paramBoolean1, paramString1, paramString2, i, paramBoolean2, paramFunction3);
  }
  
  private final void reportDialogButtonClicked(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private final void reportDialogCloseIconClicked(int paramInt1, String paramString, int paramInt2)
  {
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    AppInterface localAppInterface = (AppInterface)RIJQQAppInterfaceUtil.a();
    String str;
    if (paramInt1 == 1) {
      str = "2";
    } else {
      str = "1";
    }
    localIPublicAccountReportUtils.publicAccountReportClickEvent(localAppInterface, "", "0X800AFFD", "0X800AFFD", 0, 0, str, paramString, String.valueOf(paramInt2), "", false);
  }
  
  private final void reportDialogExposure(int paramInt1, String paramString, int paramInt2)
  {
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    AppInterface localAppInterface = (AppInterface)RIJQQAppInterfaceUtil.a();
    String str;
    if (paramInt1 == 1) {
      str = "2";
    } else {
      str = "1";
    }
    localIPublicAccountReportUtils.publicAccountReportClickEvent(localAppInterface, "", "0X800AFFC", "0X800AFFC", 0, 0, str, paramString, String.valueOf(paramInt2), "", false);
  }
  
  private final void showToast(boolean paramBoolean1, boolean paramBoolean2, Activity paramActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean1) {
      localStringBuilder.append(ReadInJoyUtils.a(2131717982));
    } else {
      localStringBuilder.append(ReadInJoyUtils.a(2131717766));
    }
    if (paramBoolean2) {
      localStringBuilder.append(ReadInJoyUtils.a(2131717844));
    }
    QQToast.a((Context)paramActivity, 2, (CharSequence)localStringBuilder, 0).a();
  }
  
  public void dismiss(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    ReadInJoyLogicEngineEventDispatcher.a().a(paramBoolean, paramString);
  }
  
  @NotNull
  public final String getCheckBoxText()
  {
    return this.checkBoxText;
  }
  
  public final long getDialogShowDuration()
  {
    return this.dialogShowDuration;
  }
  
  @NotNull
  public final String getType1ButtonText()
  {
    return this.type1ButtonText;
  }
  
  @NotNull
  public final String getType1HeaderText()
  {
    return this.type1HeaderText;
  }
  
  @NotNull
  public final String getType2HeaderText()
  {
    return this.type2HeaderText;
  }
  
  @NotNull
  public final String getType2LeftButtonText()
  {
    return this.type2LeftButtonText;
  }
  
  @NotNull
  public final String getType2RightButtonText()
  {
    return this.type2RightButtonText;
  }
  
  public void showPushNotifyDialog(int paramInt1, @NotNull String paramString1, @NotNull String paramString2, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "avatarUrl");
    Intrinsics.checkParameterIsNotNull(paramString2, "uniqueId");
    showPushNotifyDialog(paramInt1, paramString1, paramString2, paramInt2, false);
  }
  
  public final void showPushNotifyDialog(int paramInt1, @NotNull String paramString1, @NotNull String paramString2, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "avatarUrl");
    Intrinsics.checkParameterIsNotNull(paramString2, "uniqueId");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showPushNotifyDialog guideType: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" avatarUrl: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" uin: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" shouldShowDialog: ");
    ((StringBuilder)localObject).append(this.shouldShowDialog);
    QLog.i("RIJPushNotifyManager", 1, ((StringBuilder)localObject).toString());
    if ((paramInt1 != 0) && (this.shouldShowDialog))
    {
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity != null)
      {
        localObject = localBaseActivity.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          break label147;
        }
      }
      localObject = null;
      label147:
      if ((localObject instanceof ViewGroup))
      {
        boolean bool = localBaseActivity instanceof VideoFeedsPlayActivity;
        if ((!bool) && (!(localBaseActivity instanceof PublicTransFragmentActivity)) && (!paramBoolean)) {
          paramBoolean = false;
        } else {
          paramBoolean = true;
        }
        if ((!bool) && (!(localBaseActivity instanceof PublicTransFragmentActivity))) {
          bool = true;
        } else {
          bool = false;
        }
        paramString1 = getParam(paramInt1, (Activity)localBaseActivity, paramString1, paramString2, paramBoolean, bool, (Function3)new RIJPushNotifyManager.showPushNotifyDialog.param.1(this, localBaseActivity, paramString2, paramInt2, paramInt1));
        ReadInJoyLogicEngineEventDispatcher.a().a(false, "MATCH_ALL_UIN");
        new RIJPushNotifyDialog((ViewGroup)localObject, paramString1).a(true);
        reportDialogExposure(paramInt2, paramString2, paramInt1);
      }
    }
  }
  
  public void showPushNotifyDialogForWeb(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, @NotNull String paramString1, int paramInt2, @NotNull String paramString2, @NotNull IPushNotifyDialogCallback paramIPushNotifyDialogCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "avatarUrl");
    Intrinsics.checkParameterIsNotNull(paramString2, "uniqueId");
    Intrinsics.checkParameterIsNotNull(paramIPushNotifyDialogCallback, "callback");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showPushNotifyDialogForWeb guideType: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" avatarUrl: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" uin: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("isDarkMode: ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" hasNightMode: ");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append(" bizType: ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" shouldShowDialog: ");
    ((StringBuilder)localObject).append(this.shouldShowDialog);
    QLog.i("RIJPushNotifyManager", 1, ((StringBuilder)localObject).toString());
    if ((paramInt1 != 0) && (this.shouldShowDialog))
    {
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity != null)
      {
        localObject = localBaseActivity.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          break label208;
        }
      }
      localObject = null;
      label208:
      if ((localObject instanceof ViewGroup))
      {
        paramString1 = getParam(paramInt1, (Activity)localBaseActivity, paramString1, paramString2, paramBoolean1, paramBoolean2, (Function3)new RIJPushNotifyManager.showPushNotifyDialogForWeb.param.1(this, localBaseActivity, paramString2, paramInt2, paramIPushNotifyDialogCallback, paramInt1));
        ReadInJoyLogicEngineEventDispatcher.a().a(false, "MATCH_ALL_UIN");
        new RIJPushNotifyDialog((ViewGroup)localObject, paramString1).a(true);
        reportDialogExposure(paramInt2, paramString2, paramInt1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager
 * JD-Core Version:    0.7.0.1
 */