package com.tencent.mobileqq.mini.sdk;

import NS_COMM.COMM.StCommonExt;
import abju;
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
import android.util.SparseArray;
import aqeb;
import badq;
import befm;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class MiniAppController
{
  public static final int ACTION_REQUEST_API_PERMISSION = 5;
  public static final int ACTION_REQUEST_CODE_CAMERA = 4;
  public static final int ACTION_REQUEST_CODE_CHOOSE_LOCATION = 3;
  public static final int ACTION_REQUEST_CODE_GAME_PAY_THROUGH_TOOL = 3002;
  public static final int ACTION_REQUEST_CODE_GET_VIDEO = 2;
  public static final int ACTION_REQUEST_CODE_LOAD_MINI_CONF = 1;
  public static final int ACTION_REQUEST_CODE_PAY = 3001;
  public static final int ACTION_REQUEST_OPEN_BLUETOOTH = 6;
  public static final int ACTION_REQUEST_OPEN_GROUP_API = 9;
  public static final int ACTION_REQUEST_OPEN_GROUP_SELECTMEMBERS = 10;
  public static final int ACTION_REQUEST_SELECT_PHOTO = 8;
  public static final int ACTION_REQUEST_SHARE = 7;
  public static final String TAG = "MiniAppController";
  private static aqeb hitPluginSession = new aqeb("mini_myfile", "com.tencent.mobileqq:mini");
  private static MiniAppController instance;
  private static byte[] lock = new byte[0];
  private static Handler mainHander = new Handler(Looper.getMainLooper());
  private static COMM.StCommonExt sUseExtInfo;
  private static final AtomicInteger seqFactory = new AtomicInteger(new Random().nextInt(100000));
  private ArrayList<MiniAppController.ActivityResultListener> activityResultListenerList;
  private SparseArray<MiniAppController.IBridgeListener> bridgeListenerMap = new SparseArray();
  private SparseArray<BridgeInfo> bridgeMap = new SparseArray();
  private List<OutBaseJsPlugin> outJsPluginList = new ArrayList();
  
  private static int checkIfCameraPreviewingOrAVConversationForeground(Context paramContext)
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
              QLog.d("MiniAppController", 2, new Object[] { "checkIfCameraPreviewingOrAVConversationForeground ", localObject });
              if (QIMCameraCaptureActivity.class.getName().equals(localObject)) {
                return 3;
              }
              if ((!AVActivity.class.getName().equals(localObject)) && (!VideoInviteActivity.class.getName().equals(localObject)))
              {
                boolean bool = GaInviteLockActivity.class.getName().equals(localObject);
                if (!bool) {
                  break;
                }
              }
              else
              {
                return 4;
              }
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("MiniAppController", 2, "checkIfCameraPreviewingOrAVConversationForeground", paramContext);
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
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new MiniAppController();
      }
      return instance;
    }
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
    VACDReportUtil.a("no_catch_crash", "MiniAppStat", "MiniAppCrashReport", "NoCatch", null, 88889, paramString);
  }
  
  private static boolean isArkBattleUrl(String paramString, LaunchParam paramLaunchParam)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((paramLaunchParam != null) && (paramLaunchParam.scene == 2072)) {
      return true;
    }
    paramString = befm.a(paramString);
    return (paramString.containsKey("scene")) && (((String)paramString.get("scene")).equals(String.valueOf(2072)));
  }
  
  public static void launchMiniAppByAppInfo(Activity paramActivity, MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.scene = paramInt;
    launchMiniAppByAppInfo(paramActivity, paramMiniAppInfo, localLaunchParam);
  }
  
  public static void launchMiniAppByAppInfo(Activity paramActivity, MiniAppInfo paramMiniAppInfo, LaunchParam paramLaunchParam)
  {
    MiniAppConfig localMiniAppConfig = new MiniAppConfig(paramMiniAppInfo);
    localMiniAppConfig.launchParam = paramLaunchParam;
    localMiniAppConfig.launchParam.miniAppId = paramMiniAppInfo.appId;
    if (paramMiniAppInfo.reportData != null)
    {
      if (localMiniAppConfig.launchParam.reportData == null) {
        localMiniAppConfig.launchParam.reportData = new HashMap();
      }
      localMiniAppConfig.launchParam.reportData.putAll(paramMiniAppInfo.reportData);
    }
    startApp(paramActivity, localMiniAppConfig, null);
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
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    if ((paramContext != null) && ((paramContext instanceof Activity)))
    {
      abju.a(paramContext, localIntent, PublicTransFragmentActivity.class, PreloadingFragment.class);
      ((Activity)paramContext).overridePendingTransition(0, 0);
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
    localIntent.putExtra("mini_receiver", new MiniAppController.9(new Handler(Looper.getMainLooper()), paramMiniAppLaunchListener));
    localIntent.putExtra("public_fragment_window_feature", 1);
    if ((paramContext != null) && ((paramContext instanceof Activity)))
    {
      abju.a(paramContext, localIntent, PublicTransFragmentActivity.class, PreloadingFragment.class);
      ((Activity)paramContext).overridePendingTransition(0, 0);
    }
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
    AppBrandProxy.g().preloadPackage(paramMiniAppInfo);
  }
  
  private static void reportShareInfo(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppController", 2, "reportShareInfo appId=" + paramString1 + "pagePath=" + paramString2);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("miniAppId", paramString1);
      localJSONObject.put("page", paramString2);
      VACDReportUtil.a(localJSONObject.toString(), "MiniAppStat", "MiniAppShareReport", null, null, 0, null);
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  public static void startApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver)
  {
    AppBrandProxy.g().startMiniApp(paramActivity, paramMiniAppConfig, paramResultReceiver);
    ThreadManager.excute(new MiniAppController.8(), 16, null, true);
  }
  
  public static void startAppByAppid(Context paramContext, String paramString1, String paramString2, String paramString3, LaunchParam paramLaunchParam, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    if (!badq.g(paramContext)) {
      AppBrandTask.runTaskOnUiThread(new MiniAppController.2(paramContext));
    }
    do
    {
      return;
      if (TextUtils.isEmpty(paramString1))
      {
        AppBrandTask.runTaskOnUiThread(new MiniAppController.3(paramContext));
        return;
      }
      paramLaunchParam.timestamp = System.currentTimeMillis();
      Intent localIntent = new Intent();
      localIntent.putExtra("mini_appid", paramString1);
      localIntent.putExtra("mini_entryPath", paramString2);
      localIntent.putExtra("mini_envVersion", paramString3);
      localIntent.putExtra("mini_launch_param", paramLaunchParam);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      if (paramMiniAppLaunchListener != null) {
        localIntent.putExtra("mini_receiver", new MiniAppController.4(new Handler(Looper.getMainLooper()), paramMiniAppLaunchListener));
      }
      localIntent.putExtra("public_fragment_window_feature", 1);
      abju.a(paramContext, localIntent, PublicTransFragmentActivity.class, PreloadingFragment.class);
    } while (!(paramContext instanceof Activity));
    ((Activity)paramContext).overridePendingTransition(0, 0);
  }
  
  public static void startAppByLink(Context paramContext, String paramString, int paramInt, LaunchParam paramLaunchParam, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    if (!badq.g(paramContext))
    {
      AppBrandTask.runTaskOnUiThread(new MiniAppController.6(paramContext));
      return;
    }
    int i = checkIfCameraPreviewingOrAVConversationForeground(paramContext);
    int j = AppBrandLaunchManager.g().checkIfAnyMiniProcessForeground();
    if ((isArkBattleUrl(paramString, paramLaunchParam)) && ((j != 0) || (i != 0)))
    {
      QLog.e("MiniAppController", 1, "startAppByLink prohibit battle mini game open from ark, link:" + paramString);
      if (j != 0) {}
      for (paramInt = j;; paramInt = i)
      {
        MiniProgramLpReportDC04239.reportByQQ("ark", "ark_battle", "fail", String.valueOf(paramInt), "", "", "");
        return;
      }
    }
    if (TextUtils.isEmpty(paramString))
    {
      AppBrandTask.runTaskOnUiThread(new MiniAppController.7(paramContext));
      return;
    }
    launchMiniAppByLink(paramContext, paramString, paramInt, paramLaunchParam, paramMiniAppLaunchListener);
  }
  
  public static void tryReportShare(MessageForStructing paramMessageForStructing)
  {
    AbsStructMsg localAbsStructMsg = paramMessageForStructing.structingMsg;
    if ((paramMessageForStructing.structingMsg != null) && ("micro_app".equals(localAbsStructMsg.mMsg_A_ActionData))) {
      ThreadManager.excute(new MiniAppController.10(localAbsStructMsg.mMsgActionData), 16, null, false);
    }
  }
  
  public String handleNativeRequest(Activity paramActivity, ApkgInfo paramApkgInfo, String paramString1, String paramString2, MiniAppController.IBridgeListener paramIBridgeListener)
  {
    QLog.d("MiniAppController", 1, "handleNativeRequest appInfo=" + paramApkgInfo + ",eventName=" + paramString1 + ",jsonParams=" + paramString2 + ",listener=" + paramIBridgeListener);
    synchronized (this.outJsPluginList)
    {
      ??? = this.outJsPluginList.iterator();
      while (((Iterator)???).hasNext())
      {
        OutBaseJsPlugin localOutBaseJsPlugin = (OutBaseJsPlugin)((Iterator)???).next();
        if (localOutBaseJsPlugin.canHandleJsRequest(paramString1))
        {
          int i = getNextSeq();
          if (paramIBridgeListener != null) {}
          synchronized (this.bridgeListenerMap)
          {
            this.bridgeListenerMap.put(i, paramIBridgeListener);
            paramActivity = localOutBaseJsPlugin.handleNativeRequest(paramActivity, paramApkgInfo, paramString1, paramString2, i);
            return paramActivity;
          }
        }
      }
    }
    return "";
  }
  
  public String handleNativeRequest(Activity paramActivity, ApkgInfo paramApkgInfo, String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("MiniAppController", 1, "handleNativeRequest appInfo=" + paramApkgInfo + ",eventName=" + paramString1 + ",jsonParams=" + paramString2 + ",webview=" + paramJsRuntime + ",callbackId=" + paramInt);
    synchronized (this.outJsPluginList)
    {
      ??? = this.outJsPluginList.iterator();
      while (((Iterator)???).hasNext())
      {
        OutBaseJsPlugin localOutBaseJsPlugin = (OutBaseJsPlugin)((Iterator)???).next();
        if (localOutBaseJsPlugin.canHandleJsRequest(paramString1))
        {
          int i = getNextSeq();
          synchronized (this.bridgeMap)
          {
            paramJsRuntime = new BridgeInfo(paramJsRuntime, paramInt);
            this.bridgeMap.put(i, paramJsRuntime);
            paramActivity = localOutBaseJsPlugin.handleNativeRequest(paramActivity, paramApkgInfo, paramString1, paramString2, i);
            return paramActivity;
          }
        }
      }
    }
    return "";
  }
  
  public void handleNativeResponse(OutBaseJsPlugin arg1, String arg2, String paramString2, int paramInt)
  {
    MiniAppController.IBridgeListener localIBridgeListener;
    if ((??? instanceof OutBaseBridgeJsPlugin))
    {
      localIBridgeListener = (MiniAppController.IBridgeListener)this.bridgeListenerMap.get(paramInt);
      if (localIBridgeListener == null) {}
    }
    for (;;)
    {
      synchronized (this.bridgeListenerMap)
      {
        this.bridgeListenerMap.remove(paramInt);
        localIBridgeListener.onResult(???, paramString2);
        return;
      }
      ??? = (BridgeInfo)this.bridgeMap.get(paramInt);
      if (??? == null) {
        continue;
      }
      synchronized (this.bridgeMap)
      {
        this.bridgeMap.remove(paramInt);
        ??? = ???.getWebView();
        if (??? == null) {
          continue;
        }
        ???.evaluateCallbackJs(???.callbackId, paramString2);
        return;
      }
    }
  }
  
  public void notifyResultListener(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("MiniAppController", 1, new Object[] { "notifyResultListener requestCode:", Integer.valueOf(paramInt1), " resultCode:", Integer.valueOf(paramInt2) });
    if ((this.activityResultListenerList == null) || (this.activityResultListenerList.size() == 0))
    {
      QLog.e("MiniAppController", 1, "activityResultListenerList == null || activityResultListenerList.size() == 0");
      return;
    }
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
      }
    }
    catch (Throwable paramIntent)
    {
      QLog.e("MiniAppController", 1, paramIntent, new Object[0]);
      return;
    }
  }
  
  public void onDestory()
  {
    synchronized (this.outJsPluginList)
    {
      this.outJsPluginList.clear();
      synchronized (this.bridgeMap)
      {
        this.bridgeMap.clear();
        synchronized (this.bridgeListenerMap)
        {
          this.bridgeListenerMap.clear();
          if (this.activityResultListenerList == null) {}
        }
      }
    }
    synchronized (this.activityResultListenerList)
    {
      this.activityResultListenerList.clear();
      return;
      localObject2 = finally;
      throw localObject2;
      localObject3 = finally;
      throw localObject3;
      localObject4 = finally;
      throw localObject4;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppController
 * JD-Core Version:    0.7.0.1
 */