package com.tencent.mobileqq.mini.webview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.OnLoadServiceWebvieJsListener;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandServiceEventInterface;
import com.tencent.mobileqq.mini.appbrand.page.embedded.EmbeddedWidgetClientFactory;
import com.tencent.mobileqq.mini.appbrand.page.embedded.EmbeddedWidgetClientHolder;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm;
import com.tencent.smtt.sdk.WebView;
import common.config.service.QzoneConfig;
import cooperation.qzone.PlatformInfor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseAppBrandWebview
  extends WebView
  implements JsRuntime
{
  protected static final String JS_INTERFACE_NAME = "WeixinJSCore";
  public static final int MAX_AliveWebViewCount = 11;
  public static int PAGE_WEBVIEW_ID_FACTORY;
  private static final String TAG;
  public static int aliveWebViewCount;
  private static final boolean enableEmbeddedLiveConfig;
  private static final boolean enableEmbeddedVideoConfiog;
  public ApkgInfo apkgInfo;
  protected boolean enableEmbeddedLive;
  protected boolean enableEmbeddedVideo;
  protected EmbeddedWidgetClientFactory mEmbeddedWidgetClientFactory;
  public ConcurrentLinkedQueue<BaseAppBrandWebview.RunData> mRunData = new ConcurrentLinkedQueue();
  public int pageWebviewId = generatedWebViewId();
  private String userAgent = "QQ/MiniApp";
  
  static
  {
    boolean bool2 = true;
    TAG = BaseAppBrandWebview.class.getSimpleName();
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "enable_embedded_video", 1) == 1)
    {
      bool1 = true;
      enableEmbeddedVideoConfiog = bool1;
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "enable_embedded_live", 1) != 1) {
        break label58;
      }
    }
    label58:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      enableEmbeddedLiveConfig = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public BaseAppBrandWebview(Context paramContext)
  {
    this(paramContext, true);
  }
  
  public BaseAppBrandWebview(Context paramContext, ApkgInfo paramApkgInfo)
  {
    this(paramContext, true);
    this.apkgInfo = paramApkgInfo;
  }
  
  public BaseAppBrandWebview(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    paramContext = getSettings();
    paramContext.setSupportZoom(false);
    paramContext.setJavaScriptEnabled(true);
    paramContext.setCacheMode(-1);
    setWebContentsDebuggingEnabled(true);
    paramContext.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    if (Build.VERSION.SDK_INT >= 21) {
      paramContext.setMixedContentMode(0);
    }
    paramContext.setMediaPlaybackRequiresUserGesture(false);
    this.userAgent = (paramContext.getUserAgentString() + " QQ/MiniApp QQ/" + DeviceInfoUtil.getQQVersion());
    paramContext.setUserAgent(this.userAgent);
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
    try
    {
      if (getSettingsExtension() != null) {
        getSettingsExtension().setFirstScreenDetect(false);
      }
      try
      {
        QLog.d("miniapp-embedded", 1, "enableFromWebviewPool : " + paramBoolean);
        paramContext = getX5WebViewExtension();
        if (paramContext == null)
        {
          MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 701, "extension is null", "0");
          QLog.d("miniapp-embedded", 1, "getX5WebViewExtension is null");
        }
        if ((paramContext != null) && (paramBoolean))
        {
          long l = System.currentTimeMillis();
          paramContext = new String[1];
          paramContext[0] = "video";
          this.mEmbeddedWidgetClientFactory = new EmbeddedWidgetClientFactory();
          paramBoolean = getX5WebViewExtension().registerEmbeddedWidget(paramContext, this.mEmbeddedWidgetClientFactory);
          this.enableEmbeddedVideo = paramBoolean;
          this.enableEmbeddedLive = paramBoolean;
          QLog.d("miniapp-embedded", 1, "registerEmbeddedWidget : " + paramBoolean + "; tags:" + Arrays.toString(paramContext) + ";costTime:" + (System.currentTimeMillis() - l));
          if (!this.enableEmbeddedVideo) {
            MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 701, "registerEmbeddedWidget false", "0");
          }
          if (!this.enableEmbeddedLive) {
            MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 711, "registerEmbeddedWidget false", "0");
          }
          if (!enableEmbeddedVideoConfiog) {
            MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 701, "wns close", "0");
          }
          if (!enableEmbeddedLiveConfig) {
            MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 711, "wns close", "0");
          }
          if ((!this.enableEmbeddedVideo) || (!enableEmbeddedVideoConfiog)) {
            break label521;
          }
          paramBoolean = true;
          this.enableEmbeddedVideo = paramBoolean;
          if ((!this.enableEmbeddedLive) || (!enableEmbeddedLiveConfig)) {
            break label526;
          }
          paramBoolean = true;
          this.enableEmbeddedLive = paramBoolean;
          QLog.d("miniapp-embedded", 1, "enableEmbeddedVideo : " + this.enableEmbeddedVideo);
          QLog.d("miniapp-embedded", 1, "enableEmbeddedLiveConfig : " + enableEmbeddedLiveConfig);
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          QLog.e("miniapp-embedded", 2, "registerEmbeddedWidget error,", paramContext);
        }
      }
      aliveWebViewCount += 1;
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QLog.e(TAG, 1, "BaseAppBrandWebview init exception!", paramContext);
        continue;
        label521:
        paramBoolean = false;
        continue;
        label526:
        paramBoolean = false;
      }
    }
  }
  
  public static int generatedWebViewId()
  {
    int i = PAGE_WEBVIEW_ID_FACTORY + 1;
    PAGE_WEBVIEW_ID_FACTORY = i;
    return i;
  }
  
  public void clearUp() {}
  
  public int createNativeBuffer(byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    return 0;
  }
  
  public void destroy()
  {
    super.destroy();
    QLog.e("miniapp-start", 1, "page webview destroy@@@@@");
    aliveWebViewCount -= 1;
    if ((this.mEmbeddedWidgetClientFactory != null) && (this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap() != null))
    {
      Iterator localIterator = this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        EmbeddedWidgetClientHolder localEmbeddedWidgetClientHolder = (EmbeddedWidgetClientHolder)((Map.Entry)localIterator.next()).getValue();
        if (localEmbeddedWidgetClientHolder != null) {
          localEmbeddedWidgetClientHolder.webViewDestory();
        }
        localIterator.remove();
      }
    }
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    evaluteJs(String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString }));
  }
  
  public void evaluateSubcribeJS(String paramString1, String paramString2, int paramInt)
  {
    AppBrandTask.runTaskOnUiThread(new BaseAppBrandWebview.1(this, paramString1, paramString2, paramInt));
  }
  
  public void evaluateSubcribeJSInService(String paramString1, String paramString2, int paramInt)
  {
    if (!isReady())
    {
      QLog.i("miniapp-JS", 1, "weixinjsbridge save event  :" + paramString1 + "  id:" + paramInt);
      this.mRunData.offer(new BaseAppBrandWebview.RunData(this, paramString1, paramString2, paramInt));
      return;
    }
    AppBrandTask.runTaskOnUiThread(new BaseAppBrandWebview.2(this, paramString1, paramString2, paramInt));
  }
  
  protected void evaluteJs(String paramString)
  {
    evaluteJs(paramString, null);
  }
  
  public void evaluteJs(String paramString, ValueCallback paramValueCallback)
  {
    AppBrandTask.runTaskOnUiThread(new BaseAppBrandWebview.3(this, paramString, paramValueCallback));
  }
  
  public ApkgInfo getApkgInfo()
  {
    return this.apkgInfo;
  }
  
  public Context getContextEx()
  {
    return getContext();
  }
  
  public EmbeddedWidgetClientFactory getEmbeddedWidgetClientFactory()
  {
    return this.mEmbeddedWidgetClientFactory;
  }
  
  public String getJsDefaultConfig(boolean paramBoolean)
  {
    return "";
  }
  
  public byte[] getNativeBuffer(int paramInt)
  {
    return new byte[0];
  }
  
  public int getPageWebViewId()
  {
    return this.pageWebviewId;
  }
  
  public String getUserAgent()
  {
    return this.userAgent;
  }
  
  public boolean handleBackPressed()
  {
    return false;
  }
  
  public void initJSDefaultConfig(ValueCallback paramValueCallback)
  {
    evaluteJs(getJsDefaultConfig(true), new BaseAppBrandWebview.4(this, paramValueCallback));
  }
  
  public void initJSGlobalConfig()
  {
    if (this.apkgInfo == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.apkgInfo.appId);
      localJSONObject.put("icon", this.apkgInfo.iconUrl);
      localJSONObject.put("nickname", this.apkgInfo.apkgName);
      String str3 = "release";
      String str4 = "";
      String str2 = str4;
      String str1 = str3;
      if (this.apkgInfo != null)
      {
        str2 = str4;
        str1 = str3;
        if (this.apkgInfo.appConfig != null)
        {
          str2 = str4;
          str1 = str3;
          if (this.apkgInfo.appConfig.config != null)
          {
            str1 = this.apkgInfo.appConfig.config.getVerTypeStr();
            str2 = this.apkgInfo.appConfig.config.version;
          }
        }
      }
      str2 = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s;  __qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.accountInfo=JSON.parse('%2$s');  __qqConfig.envVersion='" + str1 + "'; __qqConfig.deviceinfo='" + PlatformInfor.g().getSimpleDeviceInfor() + "'; __qqConfig.miniapp_version='" + str2 + "';", new Object[] { this.apkgInfo.mConfigStr, localJSONObject.toString() });
      str1 = str2;
      if (StorageUtil.getPreference().getBoolean(this.apkgInfo.appId + "_debug", false)) {
        str1 = str2 + "__qqConfig.debug=true;";
      }
      str2 = QzoneConfig.getInstance().getConfig("qqminiapp", "opendatahosts", ".qlogo.com;.qlogo.cn;.qq.com;.tcb.qcloud.la");
      str1 = str1 + "__qqConfig.openDataHosts='" + str2 + "';";
      evaluteJs(str1 + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};", null);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void initService(ApkgInfo paramApkgInfo, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener) {}
  
  public void initService(ApkgInfo paramApkgInfo, String paramString, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener) {}
  
  public void initWAServiceJS(String paramString) {}
  
  public boolean isDestroyed()
  {
    return aliveWebViewCount == 0;
  }
  
  public boolean isEnableEmbeddedLive()
  {
    return this.enableEmbeddedLive;
  }
  
  public boolean isEnableEmbeddedVideo()
  {
    return this.enableEmbeddedVideo;
  }
  
  public boolean isReady()
  {
    return true;
  }
  
  public void loadAppServiceJs(String paramString) {}
  
  public void onPause(boolean paramBoolean)
  {
    super.onPause();
    if ((paramBoolean) && (this.mEmbeddedWidgetClientFactory != null) && (this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap() != null))
    {
      Iterator localIterator = this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        EmbeddedWidgetClientHolder localEmbeddedWidgetClientHolder = (EmbeddedWidgetClientHolder)((Map.Entry)localIterator.next()).getValue();
        if (localEmbeddedWidgetClientHolder != null) {
          localEmbeddedWidgetClientHolder.webViewPause();
        }
      }
    }
  }
  
  public void onResume(boolean paramBoolean)
  {
    super.onResume();
    if ((paramBoolean) && (this.mEmbeddedWidgetClientFactory != null) && (this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap() != null))
    {
      Iterator localIterator = this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        EmbeddedWidgetClientHolder localEmbeddedWidgetClientHolder = (EmbeddedWidgetClientHolder)((Map.Entry)localIterator.next()).getValue();
        if (localEmbeddedWidgetClientHolder != null) {
          localEmbeddedWidgetClientHolder.webViewResume();
        }
      }
    }
  }
  
  public void postMessageToMainThread(String paramString)
  {
    paramString = String.format("WeixinWorker.workerMsgHandler('" + Integer.valueOf(1) + "',%s)", new Object[] { paramString });
    QLog.i("miniapp-JS", 2, "[postMessageToMain] jsScript:" + paramString);
    evaluteJs(paramString, new BaseAppBrandWebview.5(this));
  }
  
  public void runDelayedEvent()
  {
    if (!isReady()) {
      return;
    }
    while (!this.mRunData.isEmpty())
    {
      BaseAppBrandWebview.RunData localRunData = (BaseAppBrandWebview.RunData)this.mRunData.poll();
      evaluateSubcribeJSInService(localRunData.event, localRunData.data, localRunData.id);
      QLog.e(TAG, 1, "weixinjsbridge  delayed evaluate:  event" + localRunData.event + "  webviewid: " + localRunData.id);
    }
    this.mRunData.clear();
  }
  
  public void setApkgInfo(ApkgInfo paramApkgInfo)
  {
    this.apkgInfo = paramApkgInfo;
  }
  
  public void setAppBrandEventInterface(AppBrandServiceEventInterface paramAppBrandServiceEventInterface) {}
  
  public void setAppServiceJsCallback(ValueCallback paramValueCallback) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.webview.BaseAppBrandWebview
 * JD-Core Version:    0.7.0.1
 */