package com.tencent.mobileqq.mini.sdk;

import NS_COMM.COMM.StCommonExt;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.api.IQIMCameraCapture;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI1;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI2;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI4;
import com.tencent.mobileqq.mini.appbrand.ui.InternalAppBrandUI;
import com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.launch.MiniAppStartUtils;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.ui.GameActivity2;
import com.tencent.mobileqq.minigame.ui.GameActivity3;
import com.tencent.mobileqq.minigame.ui.GameActivity4;
import com.tencent.mobileqq.minigame.ui.GameActivity5;
import com.tencent.mobileqq.minigame.ui.GameActivity6;
import com.tencent.mobileqq.minigame.ui.InternalGameActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniSdkUtil;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class MiniAppController
{
  public static final int ACTION_REQUEST_API_PERMISSION = 5;
  public static final int ACTION_REQUEST_CODE_CAMERA = 4;
  public static final int ACTION_REQUEST_CODE_CHOOSE_LOCATION = 3;
  public static final int ACTION_REQUEST_CODE_GAME_PAY_BY_FRIEND_H5 = 3004;
  public static final int ACTION_REQUEST_CODE_GAME_PAY_BY_H5 = 3003;
  public static final int ACTION_REQUEST_CODE_GAME_PAY_BY_WX_H5 = 3005;
  public static final int ACTION_REQUEST_CODE_GAME_PAY_THROUGH_TOOL = 3002;
  public static final int ACTION_REQUEST_CODE_GET_VIDEO = 2;
  public static final int ACTION_REQUEST_CODE_LOAD_MINI_CONF = 1;
  public static final int ACTION_REQUEST_CODE_PAY = 3001;
  public static final int ACTION_REQUEST_OPEN_BLUETOOTH = 6;
  public static final int ACTION_REQUEST_OPEN_GROUP_API = 9;
  public static final int ACTION_REQUEST_OPEN_GROUP_SELECTMEMBERS = 10;
  public static final int ACTION_REQUEST_SELECT_PHOTO = 8;
  public static final int ACTION_REQUEST_SHARE = 7;
  private static final Set<String> MINI_GAME_ACTIVITY_SET;
  private static final Set<String> MINI_PROGRAM_ACTIVITY_SET;
  private static final int REPORT_FOREGROUND_RESERVES_AV_CONVERSATION = 4;
  private static final int REPORT_FOREGROUND_RESERVES_CAMERA_PREVIEW = 3;
  private static final int REPORT_FOREGROUND_RESERVES_MINI_GAME = 2;
  private static final int REPORT_FOREGROUND_RESERVES_MINI_PROGRAM = 1;
  private static final int REPORT_NO_FOREGROUND = 0;
  public static final String TAG = "MiniAppController";
  private static List<Integer> arkBattleScenes = Arrays.asList(new Integer[] { Integer.valueOf(2072), Integer.valueOf(4016), Integer.valueOf(4017) });
  private static PreloadProcHitSession hitPluginSession;
  private static MiniAppController instance;
  private static byte[] lock = new byte[0];
  private static Handler mainHander = new Handler(Looper.getMainLooper());
  private static COMM.StCommonExt sUseExtInfo;
  private static final AtomicInteger seqFactory = new AtomicInteger(new Random().nextInt(100000));
  private ArrayList<MiniAppController.ActivityResultListener> activityResultListenerList;
  private List<OutBaseJsPlugin> outJsPluginList = new ArrayList();
  
  static
  {
    hitPluginSession = new PreloadProcHitSession("mini_myfile", "com.tencent.mobileqq:mini");
    MINI_PROGRAM_ACTIVITY_SET = new HashSet();
    MINI_GAME_ACTIVITY_SET = new HashSet();
    MINI_PROGRAM_ACTIVITY_SET.addAll(Arrays.asList(new String[] { AppBrandLaunchUI.class.getName(), InternalAppBrandUI.class.getName(), AppBrandUI.class.getName(), AppBrandUI1.class.getName(), AppBrandUI2.class.getName(), AppBrandUI3.class.getName(), AppBrandUI4.class.getName() }));
    MINI_GAME_ACTIVITY_SET.addAll(Arrays.asList(new String[] { InternalGameActivity.class.getName(), GameActivity.class.getName(), GameActivity1.class.getName(), GameActivity2.class.getName(), GameActivity3.class.getName(), GameActivity4.class.getName(), GameActivity5.class.getName(), GameActivity6.class.getName() }));
  }
  
  @MiniAppController.ReportForegroundType
  private static int checkIfCameraPreviewingOrAVConversationOrMiniAppForeground(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        paramContext = (ActivityManager)paramContext.getSystemService("activity");
        if (paramContext != null)
        {
          paramContext = paramContext.getRunningTasks(1).iterator();
          while (paramContext.hasNext())
          {
            Object localObject = (ActivityManager.RunningTaskInfo)paramContext.next();
            if ((localObject != null) && (((ActivityManager.RunningTaskInfo)localObject).topActivity != null))
            {
              localObject = ((ActivityManager.RunningTaskInfo)localObject).topActivity.getClassName();
              QLog.d("MiniAppController", 1, new Object[] { "checkIfCameraPreviewingOrAVConversationOrMiniAppForeground ", localObject });
              if ((!((IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class)).getQIMCameraCaptureActivityClass().getName().equals(localObject)) && (!"com.android.camera.CaptureCameraActivity".equals(localObject)))
              {
                if ((!AVActivity.class.getName().equals(localObject)) && (!VideoInviteActivity.class.getName().equals(localObject)) && (!GaInviteLockActivity.class.getName().equals(localObject)))
                {
                  if (MINI_PROGRAM_ACTIVITY_SET.contains(localObject)) {
                    return 1;
                  }
                  boolean bool = MINI_GAME_ACTIVITY_SET.contains(localObject);
                  if (bool) {
                    return 2;
                  }
                }
                else
                {
                  return 4;
                }
              }
              else {
                return 3;
              }
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("MiniAppController", 1, "checkIfCameraPreviewingOrAVConversationOrMiniAppForeground", paramContext);
      }
    }
    return 0;
  }
  
  private static void checkMiniAppEntityDB()
  {
    ThreadManagerV2.excute(new MiniAppController.1(), 32, null, true);
  }
  
  public static MiniAppController getInstance()
  {
    if (instance == null) {
      synchronized (lock)
      {
        if (instance == null) {
          instance = new MiniAppController();
        }
      }
    }
    return instance;
  }
  
  private static int getNextSeq()
  {
    try
    {
      int i = seqFactory.incrementAndGet();
      if (i > 1000000) {
        seqFactory.set(new Random().nextInt(100000) + 60000);
      }
      return i;
    }
    finally {}
  }
  
  public static void handleNoCatchCrash(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MiniAppController", 2, paramString);
    }
    VACDReportUtil.b("no_catch_crash", "MiniAppStat", "MiniAppCrashReport", "NoCatch", null, 88889, paramString);
  }
  
  private static boolean isArkBattleUrl(String paramString, LaunchParam paramLaunchParam)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((paramLaunchParam != null) && (arkBattleScenes.contains(Integer.valueOf(paramLaunchParam.scene)))) {
      return true;
    }
    paramString = URLUtil.a(paramString);
    if (paramString.containsKey("scene")) {
      paramString = (String)paramString.get("scene");
    } else {
      paramString = null;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramLaunchParam = arkBattleScenes.iterator();
      while (paramLaunchParam.hasNext()) {
        if (String.valueOf((Integer)paramLaunchParam.next()).equals(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static void launchMiniAppByAppInfo(Activity paramActivity, MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.scene = paramInt;
    launchMiniAppByAppInfo(paramActivity, paramMiniAppInfo, localLaunchParam);
  }
  
  public static void launchMiniAppByAppInfo(Activity paramActivity, MiniAppInfo paramMiniAppInfo, LaunchParam paramLaunchParam)
  {
    launchMiniAppByAppInfo(paramActivity, paramMiniAppInfo, paramLaunchParam, null);
  }
  
  public static void launchMiniAppByAppInfo(Activity paramActivity, MiniAppInfo paramMiniAppInfo, LaunchParam paramLaunchParam, ResultReceiver paramResultReceiver)
  {
    MiniAppConfig localMiniAppConfig = new MiniAppConfig(paramMiniAppInfo);
    localMiniAppConfig.launchParam = paramLaunchParam;
    localMiniAppConfig.launchParam.miniAppId = paramMiniAppInfo.appId;
    if (TextUtils.isEmpty(localMiniAppConfig.launchParam.reportData))
    {
      localMiniAppConfig.launchParam.reportData = paramMiniAppInfo.reportData;
    }
    else if (!TextUtils.isEmpty(paramMiniAppInfo.reportData))
    {
      paramLaunchParam = localMiniAppConfig.launchParam;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localMiniAppConfig.launchParam.reportData);
      localStringBuilder.append("&");
      localStringBuilder.append(paramMiniAppInfo.reportData);
      paramLaunchParam.reportData = localStringBuilder.toString();
    }
    startApp(paramActivity, localMiniAppConfig, paramResultReceiver);
  }
  
  private static void launchMiniAppByLink(Context paramContext, String paramString, int paramInt, LaunchParam paramLaunchParam, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("mini_link", paramString);
    localIntent.putExtra("mini_link_type", paramInt);
    if (paramLaunchParam != null) {
      localIntent.putExtra("mini_launch_param", paramLaunchParam);
    }
    if (paramMiniAppLaunchListener != null) {
      localIntent.putExtra("mini_receiver", new MiniAppController.5(new Handler(Looper.getMainLooper()), paramMiniAppLaunchListener));
    }
    localIntent.putExtra("public_fragment_window_feature", 1);
    if (paramContext != null)
    {
      boolean bool = paramContext instanceof Activity;
      if (!bool) {
        localIntent.addFlags(402653184);
      }
      PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicTransFragmentActivity.class, PreloadingFragment.class);
      if (bool) {
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
    }
  }
  
  public static void navigateBackMiniApp(Context paramContext, String paramString, LaunchParam paramLaunchParam, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("mini_appid", paramString);
    if (paramLaunchParam != null)
    {
      paramLaunchParam.fromBackToMiniApp = 1;
      localIntent.putExtra("mini_launch_param", paramLaunchParam);
    }
    localIntent.putExtra("mini_receiver", new MiniAppController.10(new Handler(Looper.getMainLooper()), paramMiniAppLaunchListener));
    localIntent.putExtra("public_fragment_window_feature", 1);
    if (paramContext != null)
    {
      boolean bool = paramContext instanceof Activity;
      if (!bool) {
        localIntent.addFlags(268435456);
      }
      PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicTransFragmentActivity.class, PreloadingFragment.class);
      if (bool) {
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
    }
  }
  
  public static void preDownloadPkg(String paramString1, String paramString2, IMiniCallback paramIMiniCallback)
  {
    AppBrandProxy.g().preDownloadPkg(paramString1, paramString2, paramIMiniCallback);
  }
  
  public static void preloadMiniProcess()
  {
    MiniAppReportManager.registerActivityLifecycleCallbacks();
    AppBrandProxy.g().preloadMiniApp();
    checkMiniAppEntityDB();
    hitPluginSession.a();
  }
  
  public static void preloadPackage(@NonNull MiniAppInfo paramMiniAppInfo)
  {
    if (MiniSdkUtil.a(paramMiniAppInfo.isEngineTypeMiniApp()))
    {
      QLog.w("MiniAppController", 1, "preloadPackage disable for sdk mode.");
      return;
    }
    AppBrandProxy.g().preloadPackage(paramMiniAppInfo);
  }
  
  private static void reportShareInfo(String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportShareInfo appId=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("pagePath=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("MiniAppController", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("miniAppId", paramString1);
      ((JSONObject)localObject).put("page", paramString2);
      VACDReportUtil.b(((JSONObject)localObject).toString(), "MiniAppStat", "MiniAppShareReport", null, null, 0, null);
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  public static void startApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver)
  {
    AppBrandProxy.g().startMiniApp(paramActivity, paramMiniAppConfig, paramResultReceiver);
    ThreadManager.excute(new MiniAppController.9(), 16, null, true);
  }
  
  public static void startAppByAppid(Context paramContext, String paramString1, String paramString2, String paramString3, LaunchParam paramLaunchParam, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startAppByAppid appid:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" entryPath:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" envVersion:");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append("  param:");
    ((StringBuilder)localObject).append(paramLaunchParam);
    QLog.i("MiniAppController", 1, ((StringBuilder)localObject).toString());
    if (BaseActivity.sTopActivity != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cur Activity:");
      ((StringBuilder)localObject).append(BaseActivity.sTopActivity.getActivityName());
      ((StringBuilder)localObject).append("  class :");
      ((StringBuilder)localObject).append(BaseActivity.sTopActivity.getLocalClassName());
      QLog.d("MiniAppController", 1, ((StringBuilder)localObject).toString());
    }
    if (!NetworkUtil.isNetworkAvailable(paramContext))
    {
      AppBrandTask.runTaskOnUiThread(new MiniAppController.2(paramContext));
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      AppBrandTask.runTaskOnUiThread(new MiniAppController.3(paramContext));
      return;
    }
    paramLaunchParam.timestamp = System.currentTimeMillis();
    localObject = new Intent();
    ((Intent)localObject).putExtra("mini_appid", paramString1);
    ((Intent)localObject).putExtra("mini_entryPath", paramString2);
    ((Intent)localObject).putExtra("mini_envVersion", paramString3);
    ((Intent)localObject).putExtra("mini_launch_param", paramLaunchParam);
    boolean bool = paramContext instanceof Activity;
    if (!bool) {
      ((Intent)localObject).addFlags(402653184);
    }
    if (paramMiniAppLaunchListener != null) {
      ((Intent)localObject).putExtra("mini_receiver", new MiniAppController.4(new Handler(Looper.getMainLooper()), paramMiniAppLaunchListener));
    }
    ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.Launcher.a(paramContext, (Intent)localObject, PublicTransFragmentActivity.class, PreloadingFragment.class);
    if (bool) {
      ((Activity)paramContext).overridePendingTransition(0, 0);
    }
  }
  
  public static void startAppByLink(Context paramContext, String paramString, int paramInt, LaunchParam paramLaunchParam, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startAppByLink link:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" linkType:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("  param:");
    ((StringBuilder)localObject).append(paramLaunchParam);
    QLog.i("MiniAppController", 1, ((StringBuilder)localObject).toString());
    if (BaseActivity.sTopActivity != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cur Activity:");
      ((StringBuilder)localObject).append(BaseActivity.sTopActivity.getActivityName());
      ((StringBuilder)localObject).append("  class :");
      ((StringBuilder)localObject).append(BaseActivity.sTopActivity.getLocalClassName());
      QLog.d("MiniAppController", 1, ((StringBuilder)localObject).toString());
    }
    if (!NetworkUtil.isNetworkAvailable(paramContext))
    {
      AppBrandTask.runTaskOnUiThread(new MiniAppController.6(paramContext));
      return;
    }
    int i = checkIfCameraPreviewingOrAVConversationOrMiniAppForeground(paramContext);
    if ((isArkBattleUrl(paramString, paramLaunchParam)) && (i != 0))
    {
      paramContext = new StringBuilder();
      paramContext.append("startAppByLink prohibit battle mini game open from ark, link:");
      paramContext.append(paramString);
      paramContext.append(" check result ");
      paramContext.append(i);
      QLog.e("MiniAppController", 1, paramContext.toString());
      MiniProgramLpReportDC04239.reportByQQ("ark", "ark_battle", "fail", String.valueOf(i), "", "", "");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      AppBrandTask.runTaskOnUiThread(new MiniAppController.7(paramContext));
      return;
    }
    if (paramLaunchParam != null) {
      localObject = String.valueOf(paramLaunchParam.scene);
    } else {
      localObject = "";
    }
    if (MiniAppStartUtils.shouldInterceptStartMiniApp(paramString, (String)localObject))
    {
      QLog.i("MiniAppController", 1, "study mode, can not start by link");
      ThreadManagerV2.getUIHandlerV2().post(new MiniAppController.8());
      return;
    }
    launchMiniAppByLink(paramContext, paramString, paramInt, paramLaunchParam, paramMiniAppLaunchListener);
  }
  
  public static void tryReportShare(MessageForStructing paramMessageForStructing)
  {
    AbsStructMsg localAbsStructMsg = paramMessageForStructing.structingMsg;
    if ((paramMessageForStructing.structingMsg != null) && ("micro_app".equals(localAbsStructMsg.mMsg_A_ActionData))) {
      ThreadManager.excute(new MiniAppController.11(localAbsStructMsg.mMsgActionData), 16, null, false);
    }
  }
  
  public void notifyResultListener(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("MiniAppController", 1, new Object[] { "notifyResultListener requestCode:", Integer.valueOf(paramInt1), " resultCode:", Integer.valueOf(paramInt2) });
    ??? = this.activityResultListenerList;
    if ((??? != null) && (???.size() != 0)) {
      try
      {
        synchronized (this.activityResultListenerList)
        {
          Iterator localIterator = this.activityResultListenerList.iterator();
          while (localIterator.hasNext())
          {
            MiniAppController.ActivityResultListener localActivityResultListener = (MiniAppController.ActivityResultListener)localIterator.next();
            if (localActivityResultListener.doOnActivityResult(paramInt1, paramInt2, paramIntent))
            {
              QLog.d("MiniAppController", 1, new Object[] { "triggerListener", localActivityResultListener });
              return;
            }
          }
          return;
        }
        QLog.e("MiniAppController", 1, "activityResultListenerList == null || activityResultListenerList.size() == 0");
      }
      catch (Throwable paramIntent)
      {
        QLog.e("MiniAppController", 1, paramIntent, new Object[0]);
        return;
      }
    }
  }
  
  public void onDestory()
  {
    synchronized (this.outJsPluginList)
    {
      this.outJsPluginList.clear();
      ??? = this.activityResultListenerList;
      if (??? != null) {
        try
        {
          this.activityResultListenerList.clear();
          return;
        }
        finally {}
      }
      return;
    }
  }
  
  public void registeJsPlugin(List<OutBaseJsPlugin> paramList)
  {
    if (paramList == null) {
      return;
    }
    synchronized (this.outJsPluginList)
    {
      this.outJsPluginList.clear();
      this.outJsPluginList.addAll(paramList);
      return;
    }
  }
  
  public void removeActivityResultListener(MiniAppController.ActivityResultListener paramActivityResultListener)
  {
    QLog.d("MiniAppController", 1, new Object[] { "removeActivityResultListener", paramActivityResultListener });
    if (paramActivityResultListener != null) {
      try
      {
        if (this.activityResultListenerList == null) {
          return;
        }
        this.activityResultListenerList.remove(paramActivityResultListener);
        return;
      }
      catch (Throwable paramActivityResultListener)
      {
        QLog.e("MiniAppController", 1, paramActivityResultListener, new Object[0]);
      }
    }
  }
  
  public void setActivityResultListener(MiniAppController.ActivityResultListener paramActivityResultListener)
  {
    QLog.d("MiniAppController", 1, new Object[] { "setActivityResultListener", paramActivityResultListener });
    if (paramActivityResultListener == null) {
      return;
    }
    try
    {
      if (this.activityResultListenerList == null) {
        this.activityResultListenerList = new ArrayList();
      }
      this.activityResultListenerList.add(paramActivityResultListener);
      return;
    }
    catch (Throwable paramActivityResultListener)
    {
      QLog.e("MiniAppController", 1, paramActivityResultListener, new Object[0]);
    }
  }
  
  public void unRegisterActivityResultListener()
  {
    QLog.d("MiniAppController", 1, "unRegisterActivityResultListener");
    ArrayList localArrayList = this.activityResultListenerList;
    if (localArrayList != null)
    {
      localArrayList.clear();
      this.activityResultListenerList = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppController
 * JD-Core Version:    0.7.0.1
 */