package com.tencent.mobileqq.mini.manager;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Typeface;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleLaunchParam;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.config.AppDetainFreqConfig;
import com.tencent.mobileqq.mini.config.AppDetainFreqConfig.ItemConfig;
import com.tencent.mobileqq.mini.config.AppDetainFreqConfigProcessor;
import com.tencent.mobileqq.mini.config.AppDetainFreqConfigProcessor.Companion;
import com.tencent.mobileqq.mini.entity.AppDetainRecordEntity;
import com.tencent.mobileqq.mini.model.AppDetainConfig;
import com.tencent.mobileqq.mini.model.DetailConfigParseHelper;
import com.tencent.mobileqq.mini.model.DetainConfigMatchHelper;
import com.tencent.mobileqq.mini.model.OpenType;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.util.DateUtils;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.minigame.manager.GameCloseManager;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniSdkUtil;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.GetAppPageRouterActionBridge;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.PageActionBridge;
import com.tencent.qqmini.sdk.launcher.core.IAppPageRouter;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/manager/MiniAppDetainManager;", "", "()V", "TAG", "", "mRecordCached", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/mini/entity/AppDetainRecordEntity;", "getAppDetainFreqConfig", "Lcom/tencent/mobileqq/mini/config/AppDetainFreqConfig$ItemConfig;", "miniAppInfo", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "getDetainDialogConfig", "Lcom/tencent/mobileqq/mini/model/AppDetainConfig;", "miniRuntime", "Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", "getFinalJumpLink", "curPageUrl", "openLink", "getOrCreateEntityManager", "Lcom/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager;", "getOrResetAppDetainRecord", "appId", "handleJumpForMiniApp", "", "openType", "handleOnCloseBtnClick", "", "activity", "Landroid/app/Activity;", "onCloseClickedListener", "Landroid/content/DialogInterface$OnClickListener;", "preloadAppDetainRecord", "reportDialogExpose", "miniAppConfig", "Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;", "contentText", "reportDialogLeftBtnClick", "btnText", "reportDialogRightBtnClick", "shouldShowCustomizeDetainment", "showDetainDialog", "detainConfig", "updateAppDetainRecord", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class MiniAppDetainManager
{
  public static final MiniAppDetainManager INSTANCE = new MiniAppDetainManager();
  @NotNull
  public static final String TAG = "MiniAppDetainManager";
  private static final ConcurrentHashMap<String, AppDetainRecordEntity> mRecordCached = new ConcurrentHashMap();
  
  private final AppDetainFreqConfig.ItemConfig getAppDetainFreqConfig(MiniAppInfo paramMiniAppInfo)
  {
    Object localObject = (CharSequence)paramMiniAppInfo.appId;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    localObject = null;
    if (i != 0) {
      return null;
    }
    AppDetainFreqConfig localAppDetainFreqConfig = AppDetainFreqConfigProcessor.Companion.getConfig();
    if (localAppDetainFreqConfig != null)
    {
      paramMiniAppInfo = paramMiniAppInfo.appId;
      Intrinsics.checkExpressionValueIsNotNull(paramMiniAppInfo, "miniAppInfo.appId");
      localObject = localAppDetainFreqConfig.getItemConfig(paramMiniAppInfo);
    }
    return localObject;
  }
  
  private final AppDetainConfig getDetainDialogConfig(IMiniAppContext paramIMiniAppContext, MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo = paramMiniAppInfo.apkgInfo.mConfigStr;
    CharSequence localCharSequence = (CharSequence)paramMiniAppInfo;
    int j = 0;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      QLog.e("MiniAppDetainManager", 1, "getDetailDialogConfig failed: empty configJson");
      return null;
    }
    paramMiniAppInfo = new DetailConfigParseHelper().parse(paramMiniAppInfo);
    if (paramIMiniAppContext.isMiniGame()) {
      return (AppDetainConfig)CollectionsKt.firstOrNull(paramMiniAppInfo);
    }
    paramIMiniAppContext = ActionBridge.PageActionBridge.getPageUrl(paramIMiniAppContext);
    localCharSequence = (CharSequence)paramIMiniAppContext;
    if (localCharSequence != null)
    {
      i = j;
      if (localCharSequence.length() != 0) {}
    }
    else
    {
      i = 1;
    }
    if ((i == 0) && (!paramMiniAppInfo.isEmpty())) {
      return new DetainConfigMatchHelper().find(paramIMiniAppContext, paramMiniAppInfo);
    }
    return (AppDetainConfig)null;
  }
  
  private final String getFinalJumpLink(String paramString1, String paramString2)
  {
    CharSequence localCharSequence = (CharSequence)paramString2;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject = paramString2;
    if (i == 0)
    {
      localObject = (CharSequence)paramString1;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        localObject = paramString2;
      } else if (!StringsKt.startsWith$default(localCharSequence, '.', false, 2, null)) {
        localObject = paramString2;
      } else {
        try
        {
          localObject = new URI(paramString1).resolve(paramString2).toString();
        }
        catch (Exception paramString1)
        {
          QLog.e("MiniAppDetainManager", 1, "parse absoluteLink failed", (Throwable)paramString1);
          localObject = paramString2;
        }
      }
    }
    return SimpleMiniAppConfig.SimpleLaunchParam.standardEntryPath((String)localObject);
  }
  
  private final MiniAppEntityManager getOrCreateEntityManager()
  {
    try
    {
      MiniAppEntityManager localMiniAppEntityManager = MiniAppEntityManager.get();
      return localMiniAppEntityManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private final AppDetainRecordEntity getOrResetAppDetainRecord(String paramString)
  {
    AppDetainRecordEntity localAppDetainRecordEntity2 = (AppDetainRecordEntity)mRecordCached.get(paramString);
    AppDetainRecordEntity localAppDetainRecordEntity1 = localAppDetainRecordEntity2;
    if (localAppDetainRecordEntity2 == null)
    {
      localAppDetainRecordEntity1 = new AppDetainRecordEntity();
      localAppDetainRecordEntity1.appId = paramString;
      localAppDetainRecordEntity1.timestamp = System.currentTimeMillis();
      ((Map)mRecordCached).put(paramString, localAppDetainRecordEntity1);
    }
    if (!DateUtils.INSTANCE.isToday(localAppDetainRecordEntity1.timestamp))
    {
      localAppDetainRecordEntity1.timestamp = System.currentTimeMillis();
      localAppDetainRecordEntity1.showTimes = 0;
    }
    return localAppDetainRecordEntity1;
  }
  
  private final void handleJumpForMiniApp(IMiniAppContext paramIMiniAppContext, String paramString1, String paramString2)
  {
    if (!ArraysKt.contains(OpenType.INSTANCE.getALL_TYPE(), paramString2))
    {
      paramIMiniAppContext = new StringBuilder();
      paramIMiniAppContext.append("invalid config: link=");
      paramIMiniAppContext.append(paramString1);
      paramIMiniAppContext.append(", openType=");
      paramIMiniAppContext.append(paramString2);
      QLog.e("MiniAppDetainManager", 1, paramIMiniAppContext.toString());
      return;
    }
    IAppPageRouter localIAppPageRouter = (IAppPageRouter)paramIMiniAppContext.performAction((Action)ActionBridge.GetAppPageRouterActionBridge.obtain());
    paramIMiniAppContext = getFinalJumpLink(ActionBridge.PageActionBridge.getPageUrl(paramIMiniAppContext), paramString1);
    if (localIAppPageRouter != null)
    {
      if (paramString2 == null) {
        return;
      }
      switch (paramString2.hashCode())
      {
      default: 
      case 1862662092: 
        if (paramString2.equals("navigateTo"))
        {
          localIAppPageRouter.navigateTo(paramIMiniAppContext);
          return;
        }
        break;
      case 1651364801: 
        if (paramString2.equals("switchTab"))
        {
          localIAppPageRouter.switchTab(paramIMiniAppContext);
          return;
        }
        break;
      case 1449032567: 
        if (paramString2.equals("redirectTo"))
        {
          localIAppPageRouter.redirectTo(paramIMiniAppContext);
          return;
        }
        break;
      case -983638536: 
        if (paramString2.equals("navigateBack"))
        {
          localIAppPageRouter.navigateBack(1);
          return;
        }
        break;
      case -1470534714: 
        if (paramString2.equals("reLaunch")) {
          localIAppPageRouter.reLaunch(paramIMiniAppContext);
        }
        break;
      }
    }
  }
  
  private final void reportDialogExpose(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    MiniProgramLpReportDC04239.reportAsync(paramMiniAppConfig, "custom_popup", "popup", "expo", paramString);
  }
  
  private final void reportDialogLeftBtnClick(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    MiniProgramLpReportDC04239.reportAsync(paramMiniAppConfig, "custom_popup", "left_icon", "click", paramString);
  }
  
  private final void reportDialogRightBtnClick(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2)
  {
    MiniProgramLpReportDC04239.reportAsync(paramMiniAppConfig, "custom_popup", "right_icon", "click", paramString1, paramString2);
  }
  
  private final boolean shouldShowCustomizeDetainment(MiniAppInfo paramMiniAppInfo)
  {
    AppDetainFreqConfig.ItemConfig localItemConfig = getAppDetainFreqConfig(paramMiniAppInfo);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localItemConfig != null)
    {
      paramMiniAppInfo = paramMiniAppInfo.appId;
      Intrinsics.checkExpressionValueIsNotNull(paramMiniAppInfo, "miniAppInfo.appId");
      paramMiniAppInfo = getOrResetAppDetainRecord(paramMiniAppInfo);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasShowedTimes=");
      localStringBuilder.append(paramMiniAppInfo.showTimes);
      localStringBuilder.append(", limitTimes=");
      localStringBuilder.append(localItemConfig.getLimitTimes());
      QLog.d("MiniAppDetainManager", 2, localStringBuilder.toString());
      bool1 = bool2;
      if (paramMiniAppInfo.showTimes < localItemConfig.getLimitTimes()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final void showDetainDialog(Activity paramActivity, IMiniAppContext paramIMiniAppContext, MiniAppInfo paramMiniAppInfo, AppDetainConfig paramAppDetainConfig, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramMiniAppInfo = MiniSdkUtil.b(paramMiniAppInfo);
    Context localContext = (Context)paramActivity;
    paramActivity = new QQCustomDialog(localContext, 2131953338);
    paramActivity.setContentView(2131624587);
    paramActivity.setTitle(null);
    paramActivity.setMessageTextSize(17.0F);
    paramActivity.getBtnLeft().setTypeface(Typeface.DEFAULT_BOLD);
    paramActivity.getBtnight().setTypeface(Typeface.DEFAULT_BOLD);
    TextView localTextView = paramActivity.getMessageTextView();
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "messageTextView");
    Object localObject = paramActivity.getMessageTextView();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "messageTextView");
    localObject = ((TextView)localObject).getLayoutParams();
    if (localObject != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = DisplayUtil.dip2px(localContext, 24.0F);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramActivity.setMessage((CharSequence)paramAppDetainConfig.getContent());
      paramActivity.setNegativeButton(paramAppDetainConfig.getExitButton(), (DialogInterface.OnClickListener)new MiniAppDetainManager.showDetainDialog..inlined.apply.lambda.1(paramAppDetainConfig, paramOnClickListener, paramMiniAppInfo, paramIMiniAppContext));
      paramActivity.setPositiveButton(paramAppDetainConfig.getEnterButton(), (DialogInterface.OnClickListener)new MiniAppDetainManager.showDetainDialog..inlined.apply.lambda.2(paramAppDetainConfig, paramOnClickListener, paramMiniAppInfo, paramIMiniAppContext));
      paramActivity.show();
      Intrinsics.checkExpressionValueIsNotNull(paramMiniAppInfo, "miniAppConfig");
      reportDialogExpose(paramMiniAppInfo, paramAppDetainConfig.getContent());
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
  }
  
  private final void updateAppDetainRecord(String paramString)
  {
    paramString = getOrResetAppDetainRecord(paramString);
    paramString.showTimes += 1;
    ThreadManagerV2.executeOnSubThread((Runnable)new MiniAppDetainManager.updateAppDetainRecord.1(paramString));
  }
  
  public final boolean handleOnCloseBtnClick(@NotNull Activity paramActivity, @NotNull IMiniAppContext paramIMiniAppContext, @NotNull MiniAppInfo paramMiniAppInfo, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramIMiniAppContext, "miniRuntime");
    Intrinsics.checkParameterIsNotNull(paramMiniAppInfo, "miniAppInfo");
    if (shouldShowCustomizeDetainment(paramMiniAppInfo))
    {
      AppDetainConfig localAppDetainConfig = getDetainDialogConfig(paramIMiniAppContext, paramMiniAppInfo);
      if (localAppDetainConfig != null)
      {
        showDetainDialog(paramActivity, paramIMiniAppContext, paramMiniAppInfo, localAppDetainConfig, paramOnClickListener);
        paramActivity = paramMiniAppInfo.appId;
        Intrinsics.checkExpressionValueIsNotNull(paramActivity, "miniAppInfo.appId");
        updateAppDetainRecord(paramActivity);
        return true;
      }
    }
    if (!paramIMiniAppContext.isMiniGame())
    {
      QLog.d("MiniAppDetainManager", 1, "GameCloseManager: miniApp do not need to show retainGuideDialog");
      return false;
    }
    if (GameCloseManager.handleRetainGuideDialog(paramActivity, MiniSdkUtil.b(paramMiniAppInfo), paramOnClickListener))
    {
      QLog.d("MiniAppDetainManager", 1, "GameCloseManager show retainGuideDialog");
      return true;
    }
    if (GameCloseManager.handleDropGuideDialog(paramActivity, MiniSdkUtil.b(paramMiniAppInfo), paramOnClickListener))
    {
      QLog.d("MiniAppDetainManager", 1, "GameCloseManager show dropGuideDialog");
      return true;
    }
    return false;
  }
  
  public final void preloadAppDetainRecord(@Nullable MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      paramMiniAppInfo = paramMiniAppInfo.appId;
      if (paramMiniAppInfo != null) {
        ThreadManagerV2.executeOnSubThread((Runnable)new MiniAppDetainManager.preloadAppDetainRecord.1(paramMiniAppInfo));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniAppDetainManager
 * JD-Core Version:    0.7.0.1
 */