package com.tencent.mobileqq.microapp.sdk;

import Wallet.ApkgConfig;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.apkg.AppInfo;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.apkg.UsedAppListManager;
import com.tencent.mobileqq.microapp.app.AppBrandTaskPreloadReceiver;
import com.tencent.mobileqq.microapp.appbrand.b.b;
import com.tencent.mobileqq.microapp.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class MiniAppController
{
  public static final int ACTION_REQUEST_API_PERMISSION = 5;
  public static final int ACTION_REQUEST_CODE_CAMERA = 4;
  public static final int ACTION_REQUEST_CODE_CHOOSE_LOCATION = 3;
  public static final int ACTION_REQUEST_CODE_GET_VIDEO = 2;
  public static final int ACTION_REQUEST_CODE_LOAD_MINI_CONF = 1;
  public static final int ACTION_REQUEST_CODE_PAY = 3001;
  public static final int ACTION_REQUEST_OPEN_BLUETOOTH = 6;
  public static final int ACTION_REQUEST_SHARE = 7;
  public static final String TAG = "MiniAppController";
  private static MiniAppController instance;
  private static byte[] lock = new byte[0];
  private static final AtomicInteger seqFactory = new AtomicInteger(new Random().nextInt(100000));
  private MiniAppController.ActivityResultListener activityResultListener;
  private SparseArray bridgeListenerMap = new SparseArray();
  private SparseArray bridgeMap = new SparseArray();
  private List outJsPluginList = new ArrayList();
  
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
    VACDReportUtil.singleReport("no_catch_crash", "MiniAppStat", "MiniAppCrashReport", "NoCatch", null, 88889, paramString);
  }
  
  private static void preDownApkgResources(MiniAppConfig paramMiniAppConfig)
  {
    ThreadManager.excute(new MiniAppController.1(paramMiniAppConfig), 16, null, true);
  }
  
  public static void preloadMiniProcess(Application paramApplication)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramApplication, AppBrandTaskPreloadReceiver.class);
    paramApplication.sendBroadcast(localIntent);
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
      VACDReportUtil.singleReport(((JSONObject)localObject).toString(), "MiniAppStat", "MiniAppShareReport", null, null, 0, null);
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  public static void startApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver)
  {
    if ((paramActivity != null) && (paramMiniAppConfig != null))
    {
      Intent localIntent = new Intent(paramActivity, AppBrandUI.class);
      localIntent.addFlags(536936448);
      localIntent.putExtra("CONFIG", paramMiniAppConfig);
      localIntent.putExtra("receiver", paramResultReceiver);
      paramActivity.startActivity(localIntent);
      c.a(paramActivity);
      preDownApkgResources(paramMiniAppConfig);
      UsedAppListManager.recordAppStart(new AppInfo(2, paramMiniAppConfig.config.mini_appid, paramMiniAppConfig.config.icon_url, paramMiniAppConfig.config.app_name));
      return;
    }
    paramResultReceiver = new StringBuilder();
    paramResultReceiver.append("params is empty! activity=");
    paramResultReceiver.append(paramActivity);
    paramResultReceiver.append(",appConfig=");
    paramResultReceiver.append(paramMiniAppConfig);
    paramActivity = paramResultReceiver.toString();
    QLog.e("MiniAppController", 1, paramActivity);
    throw new MiniAppException(paramActivity);
  }
  
  public static void tryReportShare(MessageForStructing paramMessageForStructing)
  {
    AbsStructMsg localAbsStructMsg = paramMessageForStructing.structingMsg;
    if ((paramMessageForStructing.structingMsg != null) && ("micro_app".equals(localAbsStructMsg.mMsg_A_ActionData))) {
      ThreadManager.excute(new MiniAppController.2(localAbsStructMsg.mMsgActionData), 16, null, false);
    }
  }
  
  public String getAppInfoFromScheme()
  {
    try
    {
      String str = b.a().a.f.launchParam.appInfo;
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public String handleNativeRequest(Activity paramActivity, String paramString1, String paramString2, String paramString3, MiniAppController.IBridgeListener paramIBridgeListener)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("handleNativeRequest appid=");
    ((StringBuilder)???).append(paramString1);
    ((StringBuilder)???).append(",eventName=");
    ((StringBuilder)???).append(paramString2);
    ((StringBuilder)???).append(",jsonParams=");
    ((StringBuilder)???).append(paramString3);
    ((StringBuilder)???).append(",listener=");
    ((StringBuilder)???).append(paramIBridgeListener);
    QLog.d("MiniAppController", 1, ((StringBuilder)???).toString());
    synchronized (this.outJsPluginList)
    {
      ??? = this.outJsPluginList.iterator();
      while (((Iterator)???).hasNext())
      {
        OutBaseJsPlugin localOutBaseJsPlugin = (OutBaseJsPlugin)((Iterator)???).next();
        if (localOutBaseJsPlugin.canHandleJsRequest(paramString2))
        {
          int i = getNextSeq();
          if (paramIBridgeListener != null) {
            synchronized (this.bridgeListenerMap)
            {
              this.bridgeListenerMap.put(i, paramIBridgeListener);
            }
          }
          paramActivity = localOutBaseJsPlugin.handleNativeRequest(paramActivity, paramString1, paramString2, paramString3, i);
          return paramActivity;
        }
      }
      return "";
    }
    for (;;)
    {
      throw paramActivity;
    }
  }
  
  public String handleNativeRequest(Activity paramActivity, String paramString1, String paramString2, String paramString3, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("handleNativeRequest appid=");
    ((StringBuilder)???).append(paramString1);
    ((StringBuilder)???).append(",eventName=");
    ((StringBuilder)???).append(paramString2);
    ((StringBuilder)???).append(",jsonParams=");
    ((StringBuilder)???).append(paramString3);
    ((StringBuilder)???).append(",webview=");
    ((StringBuilder)???).append(paramBaseAppBrandWebview);
    ((StringBuilder)???).append(",callbackId=");
    ((StringBuilder)???).append(paramInt);
    QLog.d("MiniAppController", 1, ((StringBuilder)???).toString());
    synchronized (this.outJsPluginList)
    {
      ??? = this.outJsPluginList.iterator();
      while (((Iterator)???).hasNext())
      {
        OutBaseJsPlugin localOutBaseJsPlugin = (OutBaseJsPlugin)((Iterator)???).next();
        if (localOutBaseJsPlugin.canHandleJsRequest(paramString2))
        {
          int i = getNextSeq();
          synchronized (this.bridgeMap)
          {
            paramBaseAppBrandWebview = new BridgeInfo(paramBaseAppBrandWebview, paramInt);
            this.bridgeMap.put(i, paramBaseAppBrandWebview);
            paramActivity = localOutBaseJsPlugin.handleNativeRequest(paramActivity, paramString1, paramString2, paramString3, i);
            return paramActivity;
          }
        }
      }
      return "";
    }
    for (;;)
    {
      throw paramActivity;
    }
  }
  
  public void handleNativeResponse(OutBaseJsPlugin arg1, String arg2, String paramString2, int paramInt)
  {
    if ((??? instanceof OutBaseBridgeJsPlugin))
    {
      MiniAppController.IBridgeListener localIBridgeListener = (MiniAppController.IBridgeListener)this.bridgeListenerMap.get(paramInt);
      if (localIBridgeListener != null) {
        synchronized (this.bridgeListenerMap)
        {
          this.bridgeListenerMap.remove(paramInt);
          localIBridgeListener.onResult(???, paramString2);
          return;
        }
      }
      return;
    }
    ??? = (BridgeInfo)this.bridgeMap.get(paramInt);
    if (??? == null) {
      return;
    }
    synchronized (this.bridgeMap)
    {
      this.bridgeMap.remove(paramInt);
      ??? = ???.getWebView();
      if (??? != null) {
        ???.evaluateCallbackJs(???.callbackId, paramString2);
      }
      return;
    }
  }
  
  public void notifyResultListener(int paramInt1, int paramInt2, Intent paramIntent)
  {
    MiniAppController.ActivityResultListener localActivityResultListener = this.activityResultListener;
    if (localActivityResultListener != null)
    {
      localActivityResultListener.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      this.activityResultListener = null;
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
          return;
        }
      }
    }
  }
  
  public void registeJsPlugin(List paramList)
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
  
  public void setActivityResultListener(MiniAppController.ActivityResultListener paramActivityResultListener)
  {
    if (paramActivityResultListener == null) {
      return;
    }
    this.activityResultListener = paramActivityResultListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.MiniAppController
 * JD-Core Version:    0.7.0.1
 */