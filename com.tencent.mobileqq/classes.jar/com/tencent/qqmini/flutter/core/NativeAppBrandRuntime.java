package com.tencent.qqmini.flutter.core;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qflutter.log.qflutter_log.QflutterLogPlugin;
import com.tencent.qqmini.flutter.core.page.tissue.TissuePageContainer;
import com.tencent.qqmini.flutter.core.task.IChannelInitCallback;
import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.miniapp.core.service.AppV8JsService;
import com.tencent.qqmini.miniapp.core.service.IAppBrandService;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryCodec;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.view.FlutterNativeView;
import java.util.HashMap;
import java.util.Map;

public class NativeAppBrandRuntime
  extends BaseAppBrandRuntime
{
  private static final int PAGE_STATE_APPEAR = 1;
  private static final int PAGE_STATE_BACKGROUND = 5;
  private static final int PAGE_STATE_BECAME_ACTIVE = 7;
  private static final int PAGE_STATE_DESTROY = 4;
  private static final int PAGE_STATE_DISAPPEAR = 3;
  private static final int PAGE_STATE_FOREGROUND = 6;
  private static final int PAGE_STATE_INIT = 0;
  private static final int PAGE_STATE_RESIGN_ACTIVE = 8;
  private static final int PAGE_STATE_WILL_DISAPPEAR = 2;
  private static final String TAG = "AppBrandRuntime";
  private int appPtr = -1;
  private boolean firstPageShown = false;
  Map<String, NativeAppBrandRuntime.TissueEventHandler> handlers = new NativeAppBrandRuntime.2(this);
  private BaselibLoader.BaselibContent mBaselibContent;
  private BasicMessageChannel messageChannel;
  private MethodChannel methodChannel;
  private FlutterNativeView nativeView;
  
  public NativeAppBrandRuntime(Context paramContext)
  {
    super(paramContext);
    this.mEventListener = new NativeEventListener(this);
  }
  
  private void onTimeCostReport(Map paramMap)
  {
    Object localObject = (Map)paramMap.get("data");
    if (localObject != null)
    {
      Integer localInteger3 = (Integer)((Map)localObject).get("matchTimeCost");
      Integer localInteger2 = (Integer)((Map)localObject).get("setDataTimeCost");
      Integer localInteger1 = (Integer)((Map)localObject).get("renderTimeCost");
      if (localInteger3 != null)
      {
        if (getMiniAppInfo() == null) {
          paramMap = MiniProgramReportHelper.miniAppConfigForPreload();
        } else {
          paramMap = getMiniAppInfo();
        }
        MiniReportManager.reportEventType(paramMap, 217, "0", localInteger3.intValue());
      }
      if (localInteger2 != null)
      {
        if (getMiniAppInfo() == null) {
          paramMap = MiniProgramReportHelper.miniAppConfigForPreload();
        } else {
          paramMap = getMiniAppInfo();
        }
        MiniReportManager.reportEventType(paramMap, 218, "0", localInteger2.intValue());
      }
      if (localInteger1 != null)
      {
        if (getMiniAppInfo() == null) {
          paramMap = MiniProgramReportHelper.miniAppConfigForPreload();
        } else {
          paramMap = getMiniAppInfo();
        }
        MiniReportManager.reportEventType(paramMap, 219, "0", localInteger1.intValue());
      }
      localObject = (Integer)((Map)localObject).get("totalTimeCost");
      if (localObject != null)
      {
        if (getMiniAppInfo() == null) {
          paramMap = MiniProgramReportHelper.miniAppConfigForPreload();
        } else {
          paramMap = getMiniAppInfo();
        }
        MiniReportManager.reportEventType(paramMap, 220, "0", ((Integer)localObject).intValue());
      }
    }
  }
  
  private void onViewDidAppear(Map paramMap)
  {
    performAction(AppStateEvent.obtain(11));
    Integer localInteger2 = Integer.valueOf(0);
    Integer localInteger1 = localInteger2;
    if (paramMap.containsKey("data"))
    {
      localInteger1 = localInteger2;
      if ((paramMap.get("data") instanceof Map))
      {
        paramMap = (Map)paramMap.get("data");
        localInteger1 = localInteger2;
        if (paramMap.containsKey("pageID"))
        {
          localInteger1 = localInteger2;
          if ((paramMap.get("pageID") instanceof Integer)) {
            localInteger1 = (Integer)paramMap.get("pageID");
          }
        }
      }
    }
    paramMap = new StringBuilder();
    paramMap.append("flutter page ");
    paramMap.append(localInteger1);
    paramMap.append(" shown");
    paramMap.append(System.currentTimeMillis());
    paramMap.append("runtime: ");
    paramMap.append(hashCode());
    QMLog.w("miniapp-start-TISSUE", paramMap.toString());
    if (!this.firstPageShown)
    {
      if (getMiniAppInfo() == null) {
        paramMap = MiniProgramReportHelper.miniAppConfigForPreload();
      } else {
        paramMap = getMiniAppInfo();
      }
      MiniAppReportManager2.reportLaunchPiecewise(216, "", paramMap);
      this.firstPageShown = true;
    }
  }
  
  private void sendPageState(int paramInt)
  {
    sendMsgToFlutter("messagePageState", new NativeAppBrandRuntime.7(this, paramInt));
  }
  
  public void flutterLoadData(String paramString)
  {
    paramString = JSONUtil.toMap(JSONUtil.parse(paramString));
    if (paramString != null)
    {
      sendMsgToFlutter("appLoadData", paramString);
      return;
    }
    QMLog.e("AppBrandRuntime", "null load params");
  }
  
  public BaselibLoader.BaselibContent getBaselibContent()
  {
    return this.mBaselibContent;
  }
  
  public FlutterNativeView getFlutterNativeView()
  {
    return this.nativeView;
  }
  
  public void init(IAppBrandService paramIAppBrandService)
  {
    super.init(paramIAppBrandService);
    if ((paramIAppBrandService instanceof AppV8JsService)) {
      this.appPtr = ((AppV8JsService)paramIAppBrandService).getEngineId();
    }
    paramIAppBrandService = new TissuePageContainer(this, this.mEventListener);
    paramIAppBrandService.init(null);
    this.pageContainer = paramIAppBrandService;
    paramIAppBrandService.setNativeView(this.nativeView);
  }
  
  public void initTissueChannels(IChannelInitCallback paramIChannelInitCallback)
  {
    this.methodChannel = new MethodChannel(this.nativeView, "flutter_method_channel");
    this.methodChannel.setMethodCallHandler(new NativeAppBrandRuntime.3(this));
    this.messageChannel = new BasicMessageChannel(this.nativeView, "com.tencent.tissue/basic_channel", StandardMessageCodec.INSTANCE);
    this.messageChannel.setMessageHandler(new NativeAppBrandRuntime.4(this, paramIChannelInitCallback));
    new BasicMessageChannel(this.nativeView, "com.tencent.tissue/log_channel", BinaryCodec.INSTANCE).setMessageHandler(new NativeAppBrandRuntime.5(this));
    QflutterLogPlugin.setLog(new NativeAppBrandRuntime.6(this));
  }
  
  public void onLoadMiniAppInfo(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString)
  {
    QMLog.i("AppBrandRuntime", " [MiniLifecycle] onLoadMiniAppInfo");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadMiniAppInfo miniAppInfo=");
    localStringBuilder.append(paramMiniAppInfo);
    localStringBuilder.append(",fromReload=");
    localStringBuilder.append(paramBoolean);
    QMLog.i("AppBrandRuntime", localStringBuilder.toString());
    this.mMiniAppInfo = paramMiniAppInfo;
    this.jsPluginEngine.onCreate(this);
    this.appBrandService.setApkgInfo((ApkgInfo)paramMiniAppInfo.apkgInfo);
    this.pageContainer.setMiniAppInfo(paramMiniAppInfo);
    launchPage(paramMiniAppInfo, paramBoolean, paramString);
  }
  
  public void onRuntimeDestroy() {}
  
  public void onRuntimeDetachActivity(Activity paramActivity)
  {
    super.onRuntimeDetachActivity(paramActivity);
    if (this.nativeView.getPluginRegistry().getPlatformViewsController() != null) {
      try
      {
        this.nativeView.detachFromFlutterView();
        return;
      }
      catch (Throwable paramActivity)
      {
        QMLog.e("AppBrandRuntime", "nativeView.detachFromFlutterView err, ", paramActivity);
      }
    }
  }
  
  public void onRuntimePause()
  {
    if (this.messageChannel != null)
    {
      sendMsgToFlutter("appDidDisappear");
      sendPageState(2);
      sendPageState(8);
    }
    super.onRuntimePause();
  }
  
  public void onRuntimeResume()
  {
    if (this.messageChannel != null)
    {
      sendPageState(7);
      sendPageState(1);
    }
    super.onRuntimeResume();
  }
  
  public void sendMsgToFlutter(String paramString)
  {
    sendMsgToFlutter(paramString, new HashMap());
  }
  
  public void sendMsgToFlutter(String paramString, Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appPtr", Integer.valueOf(this.appPtr));
    localHashMap.put("method", paramString);
    localHashMap.put("data", paramMap);
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
    {
      this.messageChannel.send(localHashMap);
      return;
    }
    ThreadManager.getUIHandler().post(new NativeAppBrandRuntime.1(this, localHashMap));
  }
  
  public void setBaselibContent(BaselibLoader.BaselibContent paramBaselibContent)
  {
    this.mBaselibContent = paramBaselibContent;
  }
  
  public void setFlutterNativeView(FlutterNativeView paramFlutterNativeView)
  {
    this.nativeView = paramFlutterNativeView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeAppBrandRuntime
 * JD-Core Version:    0.7.0.1
 */