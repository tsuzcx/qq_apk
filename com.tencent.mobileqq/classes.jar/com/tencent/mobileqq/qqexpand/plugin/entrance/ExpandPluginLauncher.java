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
  public static final ExpandPluginLauncher.Companion a = new ExpandPluginLauncher.Companion(null);
  private static Intent o;
  @NotNull
  private static final Lazy p = LazyKt.lazy((Function0)ExpandPluginLauncher.Companion.instance.2.INSTANCE);
  private WeakReference<ExpandPluginLoadingFragment> b = new WeakReference(null);
  private final NetSpeedChecker c = new NetSpeedChecker();
  private int d;
  private int e;
  private ExpandPluginLauncher.PluginServiceState f = ExpandPluginLauncher.PluginServiceState.NOT_STARTED;
  private HashMap<String, Object> g = new HashMap();
  private String h = "";
  private long i;
  private boolean j;
  private long k;
  private boolean l;
  private boolean m;
  private long n;
  
  private final void a(int paramInt, long paramLong)
  {
    double d1 = this.c.a(0.3D, paramInt, paramLong);
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject = ((LogUtils)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("remainTime ");
      localStringBuilder.append(d1);
      ((ILog)localObject).a("ExpandPluginLauncher", 2, localStringBuilder.toString());
    }
    localObject = (ExpandPluginLoadingFragment)this.b.get();
    if (localObject != null) {
      ExpandPluginLoadingFragment.a((ExpandPluginLoadingFragment)localObject, d1, 0.0D, 2, null);
    }
  }
  
  private final void a(IQRoutePlugin paramIQRoutePlugin)
  {
    paramIQRoutePlugin.install((IQRoutePluginInstallListener)new ExpandPluginLauncher.installPlugin.1(this));
  }
  
  private final void a(boolean paramBoolean)
  {
    Object localObject1 = (ExpandPluginLoadingFragment)this.b.get();
    if (localObject1 != null) {
      ((ExpandPluginLoadingFragment)localObject1).b(0);
    }
    Object localObject2 = new QRoutePluginActivityParams.Builder((Context)QBaseActivity.sTopActivity).setActivityName("com.tencent.mobileqq.shadowplugins.expand.ExpandMainActivity").setSubModule("expand-plugin");
    localObject1 = o;
    if (localObject1 == null) {
      localObject1 = b(paramBoolean);
    }
    localObject1 = ((QRoutePluginActivityParams.Builder)localObject2).setIntent((Intent)localObject1).setOpenResultListener((IQRoutePlugin.OnOpenResultListener)new ExpandPluginLauncher.loadPlugin.params.1(this));
    localObject2 = QRoute.plugin("expand");
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "qrouteModule");
    if (((IQRoutePlugin)localObject2).isInstalled()) {
      ((IQRoutePlugin)localObject2).startActivityForResult(((QRoutePluginActivityParams.Builder)localObject1).build());
    }
  }
  
  private final Intent b(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    ExpandManager localExpandManager = i();
    if (localExpandManager == null) {
      Intrinsics.throwNpe();
    }
    HashMap localHashMap = new HashMap();
    Object localObject2 = this.g.get("sourceType");
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
    localMap.put("screenWidth", Integer.valueOf(ViewUtils.pxToDp(((Resources)localObject1).getDisplayMetrics().widthPixels)));
    localObject1 = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplication.getContext()");
    localObject1 = ((BaseApplication)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplication.getContext().resources");
    localMap.put("screenHeight", Integer.valueOf(ViewUtils.pxToDp(((Resources)localObject1).getDisplayMetrics().heightPixels)));
    int i1;
    if (localExpandManager.t() != null)
    {
      localObject1 = localExpandManager.t();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((ExpandConfig)localObject1).centerBannerList;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "extendFriendManager.exte…Config!!.centerBannerList");
      localMap.put("centerBannerList", localObject1);
      localObject1 = localExpandManager.t();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = (CharSequence)((ExpandConfig)localObject1).testStrId;
      if ((localObject1 != null) && (!StringsKt.isBlank((CharSequence)localObject1))) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      i1 ^= 0x1;
      if (i1 == 1)
      {
        localObject1 = localExpandManager.t();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = ((ExpandConfig)localObject1).testStrId;
      }
      else
      {
        if (i1 != 0) {
          break label568;
        }
        localObject1 = localExpandManager.t();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = String.valueOf(((ExpandConfig)localObject1).testId);
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "when (hasTestStrId) {\n  ….toString()\n            }");
      localMap.put("testId", localObject1);
      break label576;
      label568:
      throw new NoWhenBranchMatchedException();
    }
    label576:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("jump2FlutterExpandByWidgetName ");
    ((StringBuilder)localObject1).append(localIntent.getStringExtra("centerBannerList"));
    QLog.d("ExpandPluginLauncher", 4, ((StringBuilder)localObject1).toString());
    if (localExpandManager.Z()) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localMap.put("isHasPersonalLabels", localObject1);
    bool1 = localExpandManager.Y();
    boolean bool2 = localExpandManager.aa();
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
      localExpandManager.e(false);
    }
    else
    {
      localMap.put("isUsedNewExpand", "1");
    }
    localMap.put("userCategory", String.valueOf(localExpandManager.X()));
    localObject1 = str;
    if (localExpandManager.r()) {
      localObject1 = "1";
    }
    localMap.put("isHasNewUserMoment", localObject1);
    localMap.put("isHasUpgradeIntroduce", String.valueOf(localExpandManager.s()));
    if ((this.g.containsKey("sourceType")) && (Intrinsics.areEqual(this.g.get("sourceType"), Integer.valueOf(2)))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    localObject1 = localObject2;
    if (i1 != 0) {
      localObject1 = localExpandManager.ab();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "if (isLebaSource) extend…ndManager.wavesId else \"\"");
    localMap.put("wavesId", localObject1);
    localIntent.putExtra("QFLUTTER_NEEDREPORT", QFlutterReporter.a());
    localIntent.putExtra("isDownloadPlugin", paramBoolean);
    localMap.put("jump", this.h);
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
  
  @NotNull
  public static final ExpandPluginLauncher d()
  {
    return a.a();
  }
  
  private final void e()
  {
    QLog.d("ExpandPluginLauncher", 2, "checkAndLoadPlugin");
    f();
    if (g())
    {
      LogUtils localLogUtils = LogUtils.a;
      if (QLog.isColorLevel()) {
        localLogUtils.a().a("ExpandPluginLauncher", 2, "load plugin");
      }
      a(this, false, 1, null);
    }
  }
  
  private final void f()
  {
    this.j = false;
    this.i = 0L;
    this.k = 0L;
    this.l = false;
    this.m = false;
  }
  
  private final boolean g()
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
        localObject2 = (ExpandPluginLoadingFragment)this.b.get();
        if (localObject2 != null) {
          ((ExpandPluginLoadingFragment)localObject2).a();
        }
        h();
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
    localObject1 = (ExpandPluginLoadingFragment)this.b.get();
    if (localObject1 != null) {
      ((ExpandPluginLoadingFragment)localObject1).a();
    }
    localObject1 = (ExpandPluginLoadingFragment)this.b.get();
    if (localObject1 != null) {
      ExpandPluginLoadingFragment.a((ExpandPluginLoadingFragment)localObject1, LoadingStatus.LOADING_ERROR, 1, 0, 4, null);
    }
    return false;
  }
  
  private final boolean h()
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      Object localObject = LogUtils.a;
      Throwable localThrowable = (Throwable)null;
      ((LogUtils)localObject).a().a("ExpandPluginLauncher", 1, "onInstallError network error", localThrowable);
      localObject = (ExpandPluginLoadingFragment)this.b.get();
      if (localObject != null) {
        ExpandPluginLoadingFragment.a((ExpandPluginLoadingFragment)localObject, LoadingStatus.LOADING_ERROR_NETWORK, 0, 0, 6, null);
      }
      return false;
    }
    return true;
  }
  
  private final ExpandManager i()
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
      Intent localIntent = b(false);
      localIntent.setClassName("com.tencent.plugins.services", "ExpandPreloadService");
      ((QRoutePluginServiceParams.Builder)localObject2).setIntent(localIntent);
      ((QRoutePluginServiceParams.Builder)localObject2).setOpenResultListener((IQRoutePlugin.OnOpenResultListener)ExpandPluginLauncher.preloadPlugin.params.1.2.a);
      localObject2 = ((QRoutePluginServiceParams.Builder)localObject2).build();
      int i1 = this.e;
      if ((i1 == 0) || (i1 != ProcessUtils.b("com.tencent.mobileqq:plugins"))) {
        this.f = ExpandPluginLauncher.PluginServiceState.STARTING;
      }
      ((IQRoutePlugin)localObject1).startService((QRoutePluginServiceParams)localObject2);
      return;
    }
    LogUtils.a.a().a("ExpandPluginLauncher", 1, "preloadPlugin: fail, plugin not exist");
  }
  
  public final void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void a(@NotNull Context paramContext, @NotNull HashMap<String, Object> paramHashMap, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "activityContext");
    Intrinsics.checkParameterIsNotNull(paramHashMap, "params");
    QLog.d("ExpandPluginLauncher", 1, "enterPlugin");
    if (System.currentTimeMillis() - this.n < 1000)
    {
      QLog.e("ExpandPluginLauncher", 2, "error double enter");
      return;
    }
    this.n = System.currentTimeMillis();
    if (paramString == null) {
      paramString = "";
    }
    this.h = paramString;
    this.g = paramHashMap;
    int i1 = this.e;
    if ((i1 != 0) && (i1 == ProcessUtils.b("com.tencent.mobileqq:plugins"))) {
      this.f = ExpandPluginLauncher.PluginServiceState.STARTED;
    }
    paramHashMap = new Intent();
    paramHashMap.putExtra("plugin_process_id", this.d);
    paramHashMap.putExtra("public_fragment_window_feature", 1);
    QPublicTransFragmentActivity.a(paramContext, paramHashMap, ExpandPluginLoadingFragment.class);
  }
  
  public final void a(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "params");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("closeLoading ");
    localStringBuilder.append(System.identityHashCode(this.b.get()));
    localStringBuilder.append(' ');
    localStringBuilder.append(this.f);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.e);
    QLog.d("ExpandPluginLauncher", 2, localStringBuilder.toString());
    boolean bool = false;
    int i1 = paramBundle.getInt("pluginPid", 0);
    if ((this.f == ExpandPluginLauncher.PluginServiceState.STARTED) && (this.e != i1)) {
      this.f = ExpandPluginLauncher.PluginServiceState.NOT_STARTED;
    }
    paramBundle = (ExpandPluginLoadingFragment)this.b.get();
    if (paramBundle != null)
    {
      if (this.d == i1) {
        bool = true;
      }
      paramBundle.a(bool, this.f);
      paramBundle.d(2);
    }
    this.d = i1;
  }
  
  public final void a(@NotNull ExpandPluginLoadingFragment paramExpandPluginLoadingFragment)
  {
    Intrinsics.checkParameterIsNotNull(paramExpandPluginLoadingFragment, "loadFragment");
    if (this.b.get() != null)
    {
      QLog.e("ExpandPluginLauncher", 2, "loading already exits!!");
      paramExpandPluginLoadingFragment.d(5);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registerLoadingFragment ");
    localStringBuilder.append(System.identityHashCode(paramExpandPluginLoadingFragment));
    QLog.d("ExpandPluginLauncher", 2, localStringBuilder.toString());
    this.b = new WeakReference(paramExpandPluginLoadingFragment);
    paramExpandPluginLoadingFragment = (ExpandPluginLoadingFragment)this.b.get();
    if (paramExpandPluginLoadingFragment != null) {
      paramExpandPluginLoadingFragment.a((View.OnClickListener)new ExpandPluginLauncher.registerLoadingFragment.1(this));
    }
    AppNetConnInfo.registerConnectionChangeReceiver((Context)BaseApplicationImpl.sApplication, (INetInfoHandler)this);
    e();
  }
  
  public final void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unregisterLoadingFragment ");
    localStringBuilder.append(System.identityHashCode(this.b.get()));
    QLog.d("ExpandPluginLauncher", 2, localStringBuilder.toString());
    this.b = new WeakReference(null);
    AppNetConnInfo.registerConnectionChangeReceiver((Context)BaseApplicationImpl.sApplication, (INetInfoHandler)this);
  }
  
  public void onNetMobile2None()
  {
    if (this.m)
    {
      ExpandPluginLoadingFragment localExpandPluginLoadingFragment = (ExpandPluginLoadingFragment)this.b.get();
      if (localExpandPluginLoadingFragment != null) {
        ExpandPluginLoadingFragment.a(localExpandPluginLoadingFragment, LoadingStatus.LOADING_ERROR_NETWORK, 0, 0, 6, null);
      }
    }
  }
  
  public void onNetMobile2Wifi(@Nullable String paramString) {}
  
  public void onNetNone2Mobile(@Nullable String paramString)
  {
    if (this.m)
    {
      f();
      paramString = (ExpandPluginLoadingFragment)this.b.get();
      if (paramString != null) {
        ExpandPluginLoadingFragment.a(paramString, LoadingStatus.LOADING, 0, 0, 6, null);
      }
    }
  }
  
  public void onNetNone2Wifi(@Nullable String paramString)
  {
    if (this.m)
    {
      f();
      paramString = (ExpandPluginLoadingFragment)this.b.get();
      if (paramString != null) {
        ExpandPluginLoadingFragment.a(paramString, LoadingStatus.LOADING, 0, 0, 6, null);
      }
    }
  }
  
  public void onNetWifi2Mobile(@Nullable String paramString) {}
  
  public void onNetWifi2None()
  {
    if (this.m)
    {
      ExpandPluginLoadingFragment localExpandPluginLoadingFragment = (ExpandPluginLoadingFragment)this.b.get();
      if (localExpandPluginLoadingFragment != null) {
        ExpandPluginLoadingFragment.a(localExpandPluginLoadingFragment, LoadingStatus.LOADING_ERROR_NETWORK, 0, 0, 6, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLauncher
 * JD-Core Version:    0.7.0.1
 */