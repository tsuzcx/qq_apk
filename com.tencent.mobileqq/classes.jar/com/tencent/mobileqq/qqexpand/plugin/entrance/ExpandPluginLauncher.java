package com.tencent.mobileqq.qqexpand.plugin.entrance;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.qflutter.ExpandModuleKey;
import com.tencent.mobileqq.flutter.report.QFlutterReporter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qqexpand.bean.common.GenericSerializable;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.fragment.ExpandPublicFragmentActivity;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.utils.ExpandPreloadUtils;
import com.tencent.mobileqq.qqexpand.utils.ILog;
import com.tencent.mobileqq.qqexpand.utils.LogUtils;
import com.tencent.mobileqq.qqexpand.utils.NetSpeedChecker;
import com.tencent.mobileqq.qqexpand.utils.ProcessUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin.OnOpenResultListener;
import com.tencent.mobileqq.qroute.module.IQRoutePluginInstallListener;
import com.tencent.mobileqq.qroute.module.QRoutePluginActivityParams.Builder;
import com.tencent.mobileqq.qroute.module.QRoutePluginServiceParams;
import com.tencent.mobileqq.qroute.module.QRoutePluginServiceParams.Builder;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "()V", "mComputeRemainTimeOnce", "", "mDownloadStartTime", "", "mExtraParams", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "mHasDownload", "mIsDownloading", "mJumpUrl", "mLastEnterTime", "mLoadingFragment", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLoadingFragment;", "mNetSpeedChecker", "Lcom/tencent/mobileqq/qqexpand/utils/NetSpeedChecker;", "mPluginPid", "", "mServiceStartedPid", "mServiceState", "Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher$PluginServiceState;", "mTotalRxBytes", "checkAndLoadPlugin", "", "checkAndUpdateNetworkStatus", "checkPluginInstalled", "closeLoading", "params", "Landroid/os/Bundle;", "computeRemainTime", "remainSize", "startDownloadSize", "createExpandIntent", "Landroid/content/Intent;", "hasDownload", "createNamedWidget", "name", "enterPlugin", "activityContext", "Landroid/content/Context;", "jumpUrl", "getExtendFriendManager", "Lcom/tencent/mobileqq/qqexpand/manager/ExpandManager;", "installPlugin", "manager", "Lcom/tencent/mobileqq/qroute/module/IQRoutePlugin;", "loadPlugin", "markServiceStartPid", "pid", "onNetMobile2None", "onNetMobile2Wifi", "p0", "onNetNone2Mobile", "onNetNone2Wifi", "onNetWifi2Mobile", "onNetWifi2None", "preloadPlugin", "registerLoadingFragment", "loadFragment", "resetData", "unregisterLoadingFragment", "Companion", "PluginMode", "PluginServiceState", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandPluginLauncher
  implements INetInfoHandler
{
  private static Intent jdField_a_of_type_AndroidContentIntent;
  public static final ExpandPluginLauncher.Companion a;
  @NotNull
  private static final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)ExpandPluginLauncher.Companion.instance.2.INSTANCE);
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ExpandPluginLauncher.PluginServiceState jdField_a_of_type_ComTencentMobileqqQqexpandPluginEntranceExpandPluginLauncher$PluginServiceState = ExpandPluginLauncher.PluginServiceState.NOT_STARTED;
  private final NetSpeedChecker jdField_a_of_type_ComTencentMobileqqQqexpandUtilsNetSpeedChecker = new NetSpeedChecker();
  private String jdField_a_of_type_JavaLangString = "";
  private WeakReference<ExpandPluginLoadingFragment> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
  private HashMap<String, Object> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqQqexpandPluginEntranceExpandPluginLauncher$Companion = new ExpandPluginLauncher.Companion(null);
  }
  
  private final Intent a(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    ExpandManager localExpandManager = a();
    if (localExpandManager == null) {
      Intrinsics.throwNpe();
    }
    HashMap localHashMap = new HashMap();
    Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap.get("sourceType");
    if ((localObject2 != null) && (Intrinsics.areEqual(localObject2, Integer.valueOf(6)))) {
      ((Map)localHashMap).put("isPresent", Integer.valueOf(1));
    } else {
      ((Map)localHashMap).put("isPresent", Integer.valueOf(0));
    }
    if (localObject2 != null)
    {
      localObject1 = (Map)localHashMap;
      localObject2 = ExpandPublicFragmentActivity.getReportFromPage(((Integer)localObject2).intValue());
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "ExpandPublicFragmentActi…omPage(sourceType as Int)");
      ((Map)localObject1).put("from", localObject2);
    }
    Map localMap = (Map)localHashMap;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(String.valueOf(System.currentTimeMillis()));
    localObject2 = "";
    ((StringBuilder)localObject1).append("");
    localMap.put("startTime", ((StringBuilder)localObject1).toString());
    boolean bool1 = QLog.isDebugVersion();
    String str = "0";
    if (bool1) {
      localObject1 = "0";
    } else {
      localObject1 = "1";
    }
    localMap.put("isRelease", localObject1);
    if (QLog.isDebugVersion()) {
      localObject1 = "0";
    } else {
      localObject1 = "1";
    }
    localMap.put("serverEnv", localObject1);
    localObject1 = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplication.getContext()");
    localObject1 = ((BaseApplication)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplication.getContext().resources");
    localMap.put("screenWidth", Integer.valueOf(ViewUtils.c(((Resources)localObject1).getDisplayMetrics().widthPixels)));
    localObject1 = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplication.getContext()");
    localObject1 = ((BaseApplication)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplication.getContext().resources");
    localMap.put("screenHeight", Integer.valueOf(ViewUtils.c(((Resources)localObject1).getDisplayMetrics().heightPixels)));
    int i;
    if (localExpandManager.a() != null)
    {
      localObject1 = localExpandManager.a();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((ExpandConfig)localObject1).centerBannerList;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "extendFriendManager.exte…Config!!.centerBannerList");
      localMap.put("centerBannerList", localObject1);
      localObject1 = localExpandManager.a();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = (CharSequence)((ExpandConfig)localObject1).testStrId;
      if ((localObject1 != null) && (!StringsKt.isBlank((CharSequence)localObject1))) {
        i = 0;
      } else {
        i = 1;
      }
      i ^= 0x1;
      if (i == 1)
      {
        localObject1 = localExpandManager.a();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = ((ExpandConfig)localObject1).testStrId;
      }
      else
      {
        if (i != 0) {
          break label553;
        }
        localObject1 = localExpandManager.a();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = String.valueOf(((ExpandConfig)localObject1).testId);
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "when (hasTestStrId) {\n  ….toString()\n            }");
      localMap.put("testId", localObject1);
      break label561;
      label553:
      throw new NoWhenBranchMatchedException();
    }
    label561:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("jump2FlutterExpandByWidgetName ");
    ((StringBuilder)localObject1).append(localIntent.getStringExtra("centerBannerList"));
    QLog.d("ExpandPluginLauncher", 4, ((StringBuilder)localObject1).toString());
    if (localExpandManager.m()) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localMap.put("isHasPersonalLabels", localObject1);
    bool1 = localExpandManager.l();
    boolean bool2 = localExpandManager.n();
    if (bool1 == bool2)
    {
      localObject1 = LogUtils.a;
      if (QLog.isColorLevel()) {
        ((LogUtils)localObject1).a().a("ExpandPluginLauncher", 2, "usedNewMatch and firstPromptExtendFriendNewUser flag is the same");
      }
    }
    if ((!bool1) && (bool2))
    {
      localMap.put("isUsedNewExpand", "0");
      localExpandManager.d(false);
    }
    else
    {
      localMap.put("isUsedNewExpand", "1");
    }
    localMap.put("userCategory", String.valueOf(localExpandManager.h()));
    localObject1 = str;
    if (localExpandManager.c()) {
      localObject1 = "1";
    }
    localMap.put("isHasNewUserMoment", localObject1);
    localMap.put("isHasUpgradeIntroduce", String.valueOf(localExpandManager.b()));
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("sourceType")) && (Intrinsics.areEqual(this.jdField_a_of_type_JavaUtilHashMap.get("sourceType"), Integer.valueOf(2)))) {
      i = 1;
    } else {
      i = 0;
    }
    localObject1 = localObject2;
    if (i != 0) {
      localObject1 = localExpandManager.k();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "if (isLebaSource) extend…ndManager.wavesId else \"\"");
    localMap.put("wavesId", localObject1);
    localIntent.putExtra("QFLUTTER_NEEDREPORT", QFlutterReporter.a());
    localIntent.putExtra("isDownloadPlugin", paramBoolean);
    localMap.put("jump", this.jdField_a_of_type_JavaLangString);
    localMap.put("serverTime", Long.valueOf(NetConnInfoCenter.getServerTime()));
    if (QLog.isColorLevel())
    {
      localObject1 = StringCompanionObject.INSTANCE;
      localObject1 = new Object[1];
      localObject1[0] = localIntent.toString();
      localObject1 = String.format("jump2FlutterExpandByWidgetName params=%s", Arrays.copyOf((Object[])localObject1, localObject1.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
      QLog.d("ExpandPluginLauncher", 2, (String)localObject1);
    }
    localObject1 = new GenericSerializable();
    ((GenericSerializable)localObject1).set(localHashMap);
    localIntent.putExtra("params", (Serializable)localObject1);
    localObject1 = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject1 = ((LogUtils)localObject1).a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("jump2FlutterExpandByWidgetName params=");
      ((StringBuilder)localObject2).append(localHashMap);
      ((ILog)localObject1).a("ExpandPluginLauncher", 2, ((StringBuilder)localObject2).toString());
    }
    return localIntent;
  }
  
  private final ExpandManager a()
  {
    Object localObject1 = BaseApplicationImpl.sApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.sApplication");
    Object localObject2 = ((BaseApplicationImpl)localObject1).getRuntime();
    localObject1 = localObject2;
    if (!(localObject2 instanceof AppInterface)) {
      localObject1 = null;
    }
    localObject1 = (AppInterface)localObject1;
    if (localObject1 != null) {
      localObject1 = ((AppInterface)localObject1).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    } else {
      localObject1 = null;
    }
    localObject2 = localObject1;
    if (!(localObject1 instanceof ExpandManager)) {
      localObject2 = null;
    }
    return (ExpandManager)localObject2;
  }
  
  @NotNull
  public static final ExpandPluginLauncher a()
  {
    return jdField_a_of_type_ComTencentMobileqqQqexpandPluginEntranceExpandPluginLauncher$Companion.a();
  }
  
  private final void a(int paramInt, long paramLong)
  {
    double d = this.jdField_a_of_type_ComTencentMobileqqQqexpandUtilsNetSpeedChecker.a(0.3D, paramInt, paramLong);
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject = ((LogUtils)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("remainTime ");
      localStringBuilder.append(d);
      ((ILog)localObject).a("ExpandPluginLauncher", 2, localStringBuilder.toString());
    }
    localObject = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null) {
      ExpandPluginLoadingFragment.a((ExpandPluginLoadingFragment)localObject, d, 0.0D, 2, null);
    }
  }
  
  private final void a(IQRoutePlugin paramIQRoutePlugin)
  {
    paramIQRoutePlugin.install((IQRoutePluginInstallListener)new ExpandPluginLauncher.installPlugin.1(this));
  }
  
  private final void a(boolean paramBoolean)
  {
    Object localObject1 = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 != null) {
      ((ExpandPluginLoadingFragment)localObject1).b(0);
    }
    Object localObject2 = new QRoutePluginActivityParams.Builder((Context)QBaseActivity.sTopActivity).setActivityName("com.tencent.mobileqq.shadowplugins.expand.ExpandMainActivity").setSubModule("expand-plugin");
    localObject1 = jdField_a_of_type_AndroidContentIntent;
    if (localObject1 == null) {
      localObject1 = a(paramBoolean);
    }
    localObject1 = ((QRoutePluginActivityParams.Builder)localObject2).setIntent((Intent)localObject1).setOpenResultListener((IQRoutePlugin.OnOpenResultListener)new ExpandPluginLauncher.loadPlugin.params.1(this));
    localObject2 = QRoute.plugin("expand");
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "qrouteModule");
    if (((IQRoutePlugin)localObject2).isInstalled()) {
      ((IQRoutePlugin)localObject2).startActivityForResult(((QRoutePluginActivityParams.Builder)localObject1).build());
    }
  }
  
  private final boolean a()
  {
    Object localObject1 = BaseApplicationImpl.sApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.sApplication");
    Object localObject2;
    if ((((BaseApplicationImpl)localObject1).getRuntime() instanceof QQAppInterface))
    {
      localObject1 = QRoute.plugin("expand");
      if (((IQRoutePlugin)localObject1).exist())
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "qrouteModule");
        if (((IQRoutePlugin)localObject1).isInstalled())
        {
          localObject1 = LogUtils.a;
          if (QLog.isColorLevel()) {
            ((LogUtils)localObject1).a().a("ExpandPluginLauncher", 2, "plugin has  installed");
          }
          return true;
        }
        localObject2 = LogUtils.a;
        if (QLog.isColorLevel()) {
          ((LogUtils)localObject2).a().a("ExpandPluginLauncher", 2, "plugin not installed");
        }
        localObject2 = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject2 != null) {
          ((ExpandPluginLoadingFragment)localObject2).a();
        }
        b();
        a((IQRoutePlugin)localObject1);
        return false;
      }
      localObject1 = LogUtils.a;
      localObject2 = (Throwable)null;
      ((LogUtils)localObject1).a().a("ExpandPluginLauncher", 1, "plugin info is null", (Throwable)localObject2);
    }
    else
    {
      localObject1 = LogUtils.a;
      localObject2 = (Throwable)null;
      ((LogUtils)localObject1).a().a("ExpandPluginLauncher", 1, "runtime not instance of QQAppInterface", (Throwable)localObject2);
    }
    localObject1 = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 != null) {
      ((ExpandPluginLoadingFragment)localObject1).a();
    }
    localObject1 = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 != null) {
      ExpandPluginLoadingFragment.a((ExpandPluginLoadingFragment)localObject1, LoadingStatus.LOADING_ERROR, 1, 0, 4, null);
    }
    return false;
  }
  
  private final boolean b()
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      Object localObject = LogUtils.a;
      Throwable localThrowable = (Throwable)null;
      ((LogUtils)localObject).a().a("ExpandPluginLauncher", 1, "onInstallError network error", localThrowable);
      localObject = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        ExpandPluginLoadingFragment.a((ExpandPluginLoadingFragment)localObject, LoadingStatus.LOADING_ERROR_NETWORK, 0, 0, 6, null);
      }
      return false;
    }
    return true;
  }
  
  private final void c()
  {
    QLog.d("ExpandPluginLauncher", 2, "checkAndLoadPlugin");
    d();
    if (a())
    {
      LogUtils localLogUtils = LogUtils.a;
      if (QLog.isColorLevel()) {
        localLogUtils.a().a("ExpandPluginLauncher", 2, "load plugin");
      }
      a(this, false, 1, null);
    }
  }
  
  private final void d()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public final void a()
  {
    Object localObject1 = BaseApplicationImpl.sApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.sApplication");
    if (!(((BaseApplicationImpl)localObject1).getRuntime() instanceof QQAppInterface))
    {
      LogUtils.a.a().a("ExpandPluginLauncher", 1, "preloadPlugin: fail, runtime is not QQAppInterface");
      return;
    }
    if (!ExpandPreloadUtils.a(ExpandModuleKey.ExpandPluginPreload))
    {
      LogUtils.a.a().a("ExpandPluginLauncher", 1, "preloadPlugin: should not preload Expand Plugin");
      return;
    }
    localObject1 = QRoute.plugin("expand");
    if ((localObject1 != null) && (((IQRoutePlugin)localObject1).exist() == true))
    {
      if (!((IQRoutePlugin)localObject1).isInstalled())
      {
        LogUtils.a.a().a("ExpandPluginLauncher", 1, "preloadPlugin: fail, plugin is not installed");
        return;
      }
      LogUtils.a.a().a("ExpandPluginLauncher", 1, "preloadPlugin: start service...");
      Object localObject2 = new QRoutePluginServiceParams.Builder((Context)QBaseActivity.sTopActivity);
      ((QRoutePluginServiceParams.Builder)localObject2).setServiceName("com.tencent.plugins.services.ExpandPreloadService");
      ((QRoutePluginServiceParams.Builder)localObject2).setSubModule("expand-plugin");
      Intent localIntent = a(false);
      localIntent.setClassName("com.tencent.plugins.services", "ExpandPreloadService");
      ((QRoutePluginServiceParams.Builder)localObject2).setIntent(localIntent);
      ((QRoutePluginServiceParams.Builder)localObject2).setOpenResultListener((IQRoutePlugin.OnOpenResultListener)ExpandPluginLauncher.preloadPlugin.params.1.2.a);
      localObject2 = ((QRoutePluginServiceParams.Builder)localObject2).build();
      int i = this.jdField_b_of_type_Int;
      if ((i == 0) || (i != ProcessUtils.a("com.tencent.mobileqq:plugins"))) {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandPluginEntranceExpandPluginLauncher$PluginServiceState = ExpandPluginLauncher.PluginServiceState.STARTING;
      }
      ((IQRoutePlugin)localObject1).startService((QRoutePluginServiceParams)localObject2);
      return;
    }
    LogUtils.a.a().a("ExpandPluginLauncher", 1, "preloadPlugin: fail, plugin not exist");
  }
  
  public final void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public final void a(@NotNull Context paramContext, @NotNull HashMap<String, Object> paramHashMap, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "activityContext");
    Intrinsics.checkParameterIsNotNull(paramHashMap, "params");
    QLog.d("ExpandPluginLauncher", 1, "enterPlugin");
    if (System.currentTimeMillis() - this.jdField_c_of_type_Long < 1000)
    {
      QLog.e("ExpandPluginLauncher", 2, "error double enter");
      return;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (paramString == null) {
      paramString = "";
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    int i = this.jdField_b_of_type_Int;
    if ((i != 0) && (i == ProcessUtils.a("com.tencent.mobileqq:plugins"))) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandPluginEntranceExpandPluginLauncher$PluginServiceState = ExpandPluginLauncher.PluginServiceState.STARTED;
    }
    paramHashMap = new Intent();
    paramHashMap.putExtra("plugin_process_id", this.jdField_a_of_type_Int);
    paramHashMap.putExtra("public_fragment_window_feature", 1);
    QPublicTransFragmentActivity.a(paramContext, paramHashMap, ExpandPluginLoadingFragment.class);
  }
  
  public final void a(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "params");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("closeLoading ");
    localStringBuilder.append(System.identityHashCode(this.jdField_a_of_type_JavaLangRefWeakReference.get()));
    localStringBuilder.append(' ');
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQqexpandPluginEntranceExpandPluginLauncher$PluginServiceState);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    QLog.d("ExpandPluginLauncher", 2, localStringBuilder.toString());
    boolean bool = false;
    int i = paramBundle.getInt("pluginPid", 0);
    if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandPluginEntranceExpandPluginLauncher$PluginServiceState == ExpandPluginLauncher.PluginServiceState.STARTED) && (this.jdField_b_of_type_Int != i)) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandPluginEntranceExpandPluginLauncher$PluginServiceState = ExpandPluginLauncher.PluginServiceState.NOT_STARTED;
    }
    paramBundle = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramBundle != null)
    {
      if (this.jdField_a_of_type_Int == i) {
        bool = true;
      }
      paramBundle.a(bool, this.jdField_a_of_type_ComTencentMobileqqQqexpandPluginEntranceExpandPluginLauncher$PluginServiceState);
      paramBundle.d(2);
    }
    this.jdField_a_of_type_Int = i;
  }
  
  public final void a(@NotNull ExpandPluginLoadingFragment paramExpandPluginLoadingFragment)
  {
    Intrinsics.checkParameterIsNotNull(paramExpandPluginLoadingFragment, "loadFragment");
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      QLog.e("ExpandPluginLauncher", 2, "loading already exits!!");
      paramExpandPluginLoadingFragment.d(5);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registerLoadingFragment ");
    localStringBuilder.append(System.identityHashCode(paramExpandPluginLoadingFragment));
    QLog.d("ExpandPluginLauncher", 2, localStringBuilder.toString());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramExpandPluginLoadingFragment);
    paramExpandPluginLoadingFragment = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramExpandPluginLoadingFragment != null) {
      paramExpandPluginLoadingFragment.a((View.OnClickListener)new ExpandPluginLauncher.registerLoadingFragment.1(this));
    }
    AppNetConnInfo.registerConnectionChangeReceiver((Context)BaseApplicationImpl.sApplication, (INetInfoHandler)this);
    c();
  }
  
  public final void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unregisterLoadingFragment ");
    localStringBuilder.append(System.identityHashCode(this.jdField_a_of_type_JavaLangRefWeakReference.get()));
    QLog.d("ExpandPluginLauncher", 2, localStringBuilder.toString());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
    AppNetConnInfo.registerConnectionChangeReceiver((Context)BaseApplicationImpl.sApplication, (INetInfoHandler)this);
  }
  
  public void onNetMobile2None()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      ExpandPluginLoadingFragment localExpandPluginLoadingFragment = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localExpandPluginLoadingFragment != null) {
        ExpandPluginLoadingFragment.a(localExpandPluginLoadingFragment, LoadingStatus.LOADING_ERROR_NETWORK, 0, 0, 6, null);
      }
    }
  }
  
  public void onNetMobile2Wifi(@Nullable String paramString) {}
  
  public void onNetNone2Mobile(@Nullable String paramString)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      d();
      paramString = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramString != null) {
        ExpandPluginLoadingFragment.a(paramString, LoadingStatus.LOADING, 0, 0, 6, null);
      }
    }
  }
  
  public void onNetNone2Wifi(@Nullable String paramString)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      d();
      paramString = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramString != null) {
        ExpandPluginLoadingFragment.a(paramString, LoadingStatus.LOADING, 0, 0, 6, null);
      }
    }
  }
  
  public void onNetWifi2Mobile(@Nullable String paramString) {}
  
  public void onNetWifi2None()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      ExpandPluginLoadingFragment localExpandPluginLoadingFragment = (ExpandPluginLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localExpandPluginLoadingFragment != null) {
        ExpandPluginLoadingFragment.a(localExpandPluginLoadingFragment, LoadingStatus.LOADING_ERROR_NETWORK, 0, 0, 6, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLauncher
 * JD-Core Version:    0.7.0.1
 */