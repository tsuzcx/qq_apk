package com.tencent.mobileqq.qqexpand.entrance.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qqexpand.flutter.ExpandFlutterContainerFragment;
import com.tencent.mobileqq.qqexpand.flutter.ExpandFlutterContainerFragment.Companion;
import com.tencent.mobileqq.qqexpand.fragment.ExpandPublicFragmentActivity;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLauncher;
import com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLauncher.Companion;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/entrance/impl/ExpandEntranceImpl;", "Lcom/tencent/mobileqq/qqexpand/entrance/IExpandEntrance;", "()V", "checkABTestPassTime", "", "app", "Lcom/tencent/common/app/AppInterface;", "enterExpand", "activityContext", "Landroid/content/Context;", "sourceType", "", "enterExpandByJumpAction", "activity", "jumpUrl", "", "enterExpandLimitMatch", "Landroid/app/Activity;", "enterExpandPlugin", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "enterFlutterExpand", "getQuietMode", "getUserCategoryConfig", "jump2FlutterExpandByWidgetName", "entry", "page", "preloadConfigData", "reportData", "eventName", "reportGetAbTestCost", "success", "", "abTestLastPullTime", "", "Companion", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandEntranceImpl
  implements IExpandEntrance
{
  public static final ExpandEntranceImpl.Companion Companion = new ExpandEntranceImpl.Companion(null);
  @NotNull
  public static final String TAG = "ExpandEntranceImpl";
  private static long mLastOpenExpandTime;
  
  private final void checkABTestPassTime(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return;
    }
    ThreadManager.getSubThreadHandler().post((Runnable)new ExpandEntranceImpl.checkABTestPassTime.1(this, paramAppInterface));
  }
  
  private final void enterFlutterExpand(Context paramContext, AppInterface paramAppInterface, int paramInt, String paramString)
  {
    Object localObject = paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (localObject != null)
    {
      localObject = (IExpandManager)localObject;
      ((IExpandManager)localObject).a(paramInt);
      if (((IExpandManager)localObject).g())
      {
        preloadConfigData(paramAppInterface);
        paramAppInterface = new HashMap();
        ((Map)paramAppInterface).put("sourceType", Integer.valueOf(paramInt));
        if (paramString == null) {
          paramString = "";
        }
        enterExpandPlugin(paramContext, paramAppInterface, paramString);
        return;
      }
      ((IExpandManager)localObject).b();
      jump2FlutterExpandByWidgetName(paramContext, paramAppInterface, "qqExpandWidget", "QQExpandWidget", paramInt, paramString);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.manager.IExpandManager");
  }
  
  private final void getQuietMode(AppInterface paramAppInterface)
  {
    ThreadManager.getSubThreadHandler().post((Runnable)new ExpandEntranceImpl.getQuietMode.1(paramAppInterface));
  }
  
  private final void getUserCategoryConfig(AppInterface paramAppInterface)
  {
    ThreadManager.getSubThreadHandler().post((Runnable)new ExpandEntranceImpl.getUserCategoryConfig.1(paramAppInterface));
  }
  
  private final void jump2FlutterExpandByWidgetName(Context paramContext, AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (System.currentTimeMillis() - mLastOpenExpandTime < 1000)
    {
      QLog.i("ExpandEntranceImpl", 4, "jump2Expand wait a while");
      return;
    }
    mLastOpenExpandTime = System.currentTimeMillis();
    preloadConfigData(paramAppInterface);
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    localMap.put("hostId", "8531243");
    localMap.put("uid", paramAppInterface.getCurrentAccountUin());
    if (paramInt == 6) {
      localMap.put("isPresent", Integer.valueOf(1));
    } else {
      localMap.put("isPresent", Integer.valueOf(0));
    }
    localMap.put("from", ExpandPublicFragmentActivity.getReportFromPage(paramInt));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.valueOf(System.currentTimeMillis()));
    String str1 = "";
    ((StringBuilder)localObject).append("");
    localMap.put("startTime", ((StringBuilder)localObject).toString());
    boolean bool1 = QLog.isDebugVersion();
    String str2 = "0";
    if (bool1) {
      localObject = "0";
    } else {
      localObject = "1";
    }
    localMap.put("isRelease", localObject);
    if (QLog.isDebugVersion()) {
      localObject = "0";
    } else {
      localObject = "1";
    }
    localMap.put("serverEnv", localObject);
    localMap.put("statusBarHeight", Integer.valueOf(ViewUtils.c(ImmersiveUtils.getStatusBarHeight(paramContext))));
    localObject = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplication.getContext()");
    localObject = ((BaseApplication)localObject).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplication.getContext().resources");
    localMap.put("screenWidth", Integer.valueOf(ViewUtils.c(((Resources)localObject).getDisplayMetrics().widthPixels)));
    localObject = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplication.getContext()");
    localObject = ((BaseApplication)localObject).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplication.getContext().resources");
    localMap.put("screenHeight", Integer.valueOf(ViewUtils.c(((Resources)localObject).getDisplayMetrics().heightPixels)));
    paramAppInterface = paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (paramAppInterface != null)
    {
      localObject = (IExpandManager)paramAppInterface;
      if (((IExpandManager)localObject).a() != null)
      {
        localMap.put("centerBannerList", ((IExpandManager)localObject).a().centerBannerList);
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("jump2FlutterExpandByWidgetName ");
        paramAppInterface.append(localHashMap.get("centerBannerList"));
        QLog.d("ExpandEntranceImpl", 4, paramAppInterface.toString());
        if (!TextUtils.isEmpty((CharSequence)((IExpandManager)localObject).a().testStrId))
        {
          localMap.put("testId", ((IExpandManager)localObject).a().testStrId);
        }
        else
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append(String.valueOf(((IExpandManager)localObject).a().testId));
          paramAppInterface.append("");
          localMap.put("testId", paramAppInterface.toString());
        }
      }
      if (((IExpandManager)localObject).m()) {
        paramAppInterface = "1";
      } else {
        paramAppInterface = "0";
      }
      localMap.put("isHasPersonalLabels", paramAppInterface);
      bool1 = ((IExpandManager)localObject).l();
      boolean bool2 = ((IExpandManager)localObject).n();
      if ((bool1 == bool2) && (QLog.isColorLevel())) {
        QLog.w("ExpandEntranceImpl", 2, "usedNewMatch and firstPromptExtendFriendNewUser flag is the same");
      }
      if ((!bool1) && (bool2))
      {
        localMap.put("isUsedNewExpand", "0");
        ((IExpandManager)localObject).d(false);
      }
      else
      {
        localMap.put("isUsedNewExpand", "1");
      }
      paramAppInterface = new StringBuilder();
      paramAppInterface.append(String.valueOf(((IExpandManager)localObject).h()));
      paramAppInterface.append("");
      localMap.put("userCategory", paramAppInterface.toString());
      paramAppInterface = str2;
      if (((IExpandManager)localObject).c()) {
        paramAppInterface = "1";
      }
      localMap.put("isHasNewUserMoment", paramAppInterface);
      paramAppInterface = new StringBuilder();
      paramAppInterface.append(String.valueOf(((IExpandManager)localObject).b()));
      paramAppInterface.append("");
      localMap.put("isHasUpgradeIntroduce", paramAppInterface.toString());
      paramAppInterface = str1;
      if (paramInt == 2) {
        paramAppInterface = ((IExpandManager)localObject).k();
      }
      localMap.put("wavesId", paramAppInterface);
      localMap.put("jump", paramString3);
      localMap.put("serverTime", Long.valueOf(NetConnInfoCenter.getServerTime()));
      if (QLog.isColorLevel())
      {
        paramAppInterface = StringCompanionObject.INSTANCE;
        paramAppInterface = new Object[1];
        paramAppInterface[0] = localHashMap.toString();
        paramAppInterface = String.format("jump2FlutterExpandByWidgetName params=%s", Arrays.copyOf(paramAppInterface, paramAppInterface.length));
        Intrinsics.checkExpressionValueIsNotNull(paramAppInterface, "java.lang.String.format(format, *args)");
        QLog.d("ExpandEntranceImpl", 2, paramAppInterface);
      }
      paramAppInterface = new byte[1];
      paramString3 = ExpandFlutterContainerFragment.a;
      if (paramString1 == null) {
        Intrinsics.throwNpe();
      }
      paramString3.a(paramContext, paramString1, paramString2, localMap, paramAppInterface);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.manager.IExpandManager");
  }
  
  private final void preloadConfigData(AppInterface paramAppInterface)
  {
    checkABTestPassTime(paramAppInterface);
    getUserCategoryConfig(paramAppInterface);
    getQuietMode(paramAppInterface);
  }
  
  private final void reportData(String paramString, HashMap<String, String> paramHashMap)
  {
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel(paramString, true, -1L, -1L, (Map)paramHashMap, true, true);
  }
  
  private final void reportGetAbTestCost(boolean paramBoolean, long paramLong)
  {
    long l = System.currentTimeMillis();
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("time_cost", String.valueOf(l - paramLong));
    localHashMap.put("result_code", String.valueOf(i));
    reportData("expand_quality#exp_info#exp_callback", localHashMap);
  }
  
  public void enterExpand(@Nullable Context paramContext, @Nullable AppInterface paramAppInterface, int paramInt)
  {
    if ((paramContext != null) && (paramAppInterface != null))
    {
      localObject = paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (localObject != null)
      {
        localObject = (ExpandManager)localObject;
        QLog.i("ExpandEntranceImpl", 4, "jump2AB850Expand go to a page with field <expandVersion>");
        ((ExpandManager)localObject).b();
        ((ExpandManager)localObject).h();
        enterFlutterExpand(paramContext, paramAppInterface, paramInt, "");
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.manager.ExpandManager");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enterExpand context is null ");
    boolean bool2 = true;
    boolean bool1;
    if (paramContext == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(" or app is null ");
    if (paramAppInterface == null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    ((StringBuilder)localObject).append(bool1);
    QLog.e("ExpandEntranceImpl", 2, ((StringBuilder)localObject).toString());
  }
  
  public void enterExpandByJumpAction(@Nullable Context paramContext, @Nullable AppInterface paramAppInterface, int paramInt, @Nullable String paramString)
  {
    if ((paramContext != null) && (paramAppInterface != null))
    {
      Object localObject = paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (localObject != null)
      {
        localObject = (IExpandManager)localObject;
        QLog.i("ExpandEntranceImpl", 4, "jump2AB850Expand go to a page with field <expandVersion>");
        ((IExpandManager)localObject).b();
        enterFlutterExpand(paramContext, paramAppInterface, paramInt, paramString);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.manager.IExpandManager");
    }
    paramString = new StringBuilder();
    paramString.append("enterExpandByJumpAction context is null ");
    boolean bool2 = true;
    boolean bool1;
    if (paramContext == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramString.append(bool1);
    paramString.append(" or app is null ");
    if (paramAppInterface == null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    paramString.append(bool1);
    QLog.e("ExpandEntranceImpl", 2, paramString.toString());
  }
  
  public void enterExpandLimitMatch(@Nullable Activity paramActivity, @Nullable AppInterface paramAppInterface, int paramInt)
  {
    boolean bool1 = paramAppInterface instanceof QQAppInterface;
    if ((bool1) && (paramActivity != null))
    {
      enterFlutterExpand((Context)paramActivity, paramAppInterface, 6, "");
      paramActivity.overridePendingTransition(1912668161, 1912668160);
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).reportEnterExpandClick("5");
      return;
    }
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("enterExpandLimitMatch app is not QQAppInterface ");
    boolean bool2 = true;
    if (!bool1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramAppInterface.append(bool1);
    paramAppInterface.append(" or activity is null ");
    if (paramActivity == null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    paramAppInterface.append(bool1);
    QLog.e("ExpandEntranceImpl", 2, paramAppInterface.toString());
  }
  
  public void enterExpandPlugin(@NotNull Context paramContext, @NotNull HashMap<String, Object> paramHashMap, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "activityContext");
    Intrinsics.checkParameterIsNotNull(paramHashMap, "params");
    ExpandPluginLauncher.a.a().a(paramContext, paramHashMap, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.entrance.impl.ExpandEntranceImpl
 * JD-Core Version:    0.7.0.1
 */