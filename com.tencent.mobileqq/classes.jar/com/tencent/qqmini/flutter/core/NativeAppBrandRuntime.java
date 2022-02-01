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
import com.tencent.qqmini.miniapp.core.service.IAppBrandService;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
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
  private static final String TAG = "AppBrandRuntime";
  private boolean firstPageShown = false;
  private BaselibLoader.BaselibContent mBaselibContent;
  private BasicMessageChannel messageChannel;
  private MethodChannel methodChannel;
  private FlutterNativeView nativeView;
  
  public NativeAppBrandRuntime(Context paramContext)
  {
    super(paramContext);
    this.mEventListener = new NativeEventListener(this);
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
    paramIAppBrandService = new TissuePageContainer(this, this.mEventListener);
    paramIAppBrandService.init(null);
    this.pageContainer = paramIAppBrandService;
    paramIAppBrandService.setNativeView(this.nativeView);
  }
  
  public void initTissueChannels(IChannelInitCallback paramIChannelInitCallback)
  {
    this.methodChannel = new MethodChannel(this.nativeView, "flutter_method_channel");
    this.methodChannel.setMethodCallHandler(new NativeAppBrandRuntime.2(this));
    this.messageChannel = new BasicMessageChannel(this.nativeView, "com.tencent.tissue/basic_channel", StandardMessageCodec.INSTANCE);
    this.messageChannel.setMessageHandler(new NativeAppBrandRuntime.3(this, paramIChannelInitCallback));
    new BasicMessageChannel(this.nativeView, "com.tencent.tissue/log_channel", BinaryCodec.INSTANCE).setMessageHandler(new NativeAppBrandRuntime.4(this));
    QflutterLogPlugin.setLog(new NativeAppBrandRuntime.5(this));
  }
  
  public void onLoadMiniAppInfo(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString)
  {
    QMLog.i("AppBrandRuntime", " [MiniLifecycle] onLoadMiniAppInfo");
    QMLog.i("AppBrandRuntime", "onLoadMiniAppInfo miniAppInfo=" + paramMiniAppInfo + ",fromReload=" + paramBoolean);
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
    if (this.nativeView.isAttached()) {
      this.nativeView.detachFromFlutterView();
    }
  }
  
  public void onRuntimePause()
  {
    if (this.messageChannel != null) {
      sendMsgToFlutter("appDidDisappear");
    }
    super.onRuntimePause();
  }
  
  public void sendMsgToFlutter(String paramString)
  {
    sendMsgToFlutter(paramString, new HashMap());
  }
  
  public void sendMsgToFlutter(String paramString, Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appPtr", Integer.valueOf(2333));
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