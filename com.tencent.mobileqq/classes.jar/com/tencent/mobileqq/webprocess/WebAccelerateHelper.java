package com.tencent.mobileqq.webprocess;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.sonic.SonicRuntimeImpl;
import com.tencent.mobileqq.webview.swift.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicConfig.Builder;
import com.tencent.sonic.sdk.SonicEngine;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class WebAccelerateHelper
{
  private static final String[] CFG_KEYS = { "preloadUrl" };
  public static final String CREATE_WEB_VIEW_PLUGIN_ENGINE = "createWebViewPluginEngine";
  public static final String KEY_PRELOAD_URL = "preloadUrl";
  public static final int NEED_CHECK_COOKIE = 1;
  public static final int NEED_ENABLE_WEB_AIO = 1;
  public static final int NEED_PREGET_KEY = 1;
  public static final int SW_DISABLE_SONIC_HTTPS_DNS_PREFETCH = 10;
  public static final int SW_ENABLE_EMOJI_STICKER = 11;
  public static final int SW_ENABLE_PRELOAD_IN_PUBLIC_ACCOUNT = 9;
  public static final int SW_ENABLE_PRE_REND = 14;
  @Deprecated
  public static final int SW_ENABLE_SERVICE_WORKER = 12;
  public static final int SW_ENABLE_SERVICE_WORKER_NEW_VERSION = 13;
  public static final int SW_ENABLE_SONIC = 8;
  public static final int SW_ENABLE_WEB_AIO = 5;
  public static final int SW_HIDE_BOTTOM_BAR_IN_LANDSCAPE = 7;
  public static final int SW_PRELOAD_PT4TOKEN_SKEY = 3;
  public static final int SW_PRELOAD_TICKETS = 0;
  public static final int SW_QQBROWSER_ICON_ANIM = 4;
  public static final int SW_THUMBNAIL_WIDTH = 2;
  public static final int SW_TOTAL_NUM = 15;
  public static final int SW_VERIFY_COOKIE = 1;
  public static final int SW_WEB_CORE_DUMP_MASK = 6;
  private static final String TAG = "WebAccelerateHelper";
  private static WebAccelerateHelper instance = null;
  public static boolean isWebViewCache = false;
  private static final Object lock = new Object();
  public static View preloadBrowserView;
  static volatile ArrayMap<String, String> sWebViewFeatureConfigs;
  static volatile Integer[] sWebViewFeatureParams;
  public WebAccelerateHelper.TicketInfoListener mTicketInfoListener;
  public volatile String param;
  private final Object sDPCLock = new Object();
  
  public static WebAccelerateHelper getInstance()
  {
    if (instance == null) {
      synchronized (lock)
      {
        if (instance == null) {
          instance = new WebAccelerateHelper();
        }
      }
    }
    return instance;
  }
  
  public static SonicEngine getSonicEngine()
  {
    try
    {
      if (SonicEngine.isGetInstanceAllowed()) {
        return SonicEngine.getInstance();
      }
      SonicEngine localSonicEngine = SonicEngine.createInstance(new SonicRuntimeImpl(MobileQQ.getContext()), new SonicConfig.Builder().build());
      return localSonicEngine;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get sonic engine error: ");
      localStringBuilder.append(localThrowable);
      QLog.e("WebAccelerateHelper", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  public static void preInflaterBrowserView()
  {
    long l = System.currentTimeMillis();
    if (preloadBrowserView == null) {
      try
      {
        WebBrowserViewContainer localWebBrowserViewContainer = new WebBrowserViewContainer(MobileQQ.sMobileQQ);
        localWebBrowserViewContainer.a(false);
        preloadBrowserView = localWebBrowserViewContainer;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("preInflaterBrowserView error:");
        localStringBuilder2.append(localException.getMessage());
        QLog.e("WebAccelerateHelper", 1, localStringBuilder2.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Pre_Load_init_browser_view cost = ");
      localStringBuilder1.append(System.currentTimeMillis() - l);
      QLog.d("WebAccelerateHelper", 2, localStringBuilder1.toString());
    }
  }
  
  public void bindFragment(WebViewPluginEngine paramWebViewPluginEngine, WebViewProvider paramWebViewProvider)
  {
    long l = System.currentTimeMillis();
    paramWebViewPluginEngine.a(paramWebViewProvider);
    if (QLog.isColorLevel())
    {
      paramWebViewPluginEngine = new StringBuilder();
      paramWebViewPluginEngine.append("bindFragment cost : ");
      paramWebViewPluginEngine.append(System.currentTimeMillis() - l);
      QLog.d("WebAccelerateHelper", 2, paramWebViewPluginEngine.toString());
    }
  }
  
  public WebViewPluginEngine createWebViewPluginEngine(AppRuntime paramAppRuntime, Activity paramActivity, CustomWebView paramCustomWebView, CommonJsPluginFactory paramCommonJsPluginFactory, List<WebViewPlugin> paramList)
  {
    Util.f("createWebViewPluginEngine");
    Object localObject2 = null;
    Object localObject1;
    if ((paramAppRuntime != null) && (paramActivity == null) && (paramCustomWebView == null) && (paramList == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebAccelerateHelper", 2, "preload webview engine(with no plugin list)");
      }
      localObject1 = new WebViewPluginEngine(paramAppRuntime, paramCommonJsPluginFactory, null);
    }
    else if ((paramAppRuntime != null) && (paramActivity == null) && (paramCustomWebView == null) && (paramList != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebAccelerateHelper", 2, "preload webview engine(with plugin list");
      }
      localObject1 = new WebViewPluginEngine(paramAppRuntime, paramCommonJsPluginFactory, paramList);
    }
    else if ((paramAppRuntime != null) && (paramList == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebAccelerateHelper", 2, "create webview engine(with no plugin list");
      }
      localObject1 = new WebViewPluginEngine(paramCustomWebView, paramActivity, paramAppRuntime, paramCommonJsPluginFactory);
    }
    else
    {
      localObject1 = localObject2;
      if (paramAppRuntime != null)
      {
        localObject1 = localObject2;
        if (paramList != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebAccelerateHelper", 2, "create webview engine(with plugin list");
          }
          localObject1 = new WebViewPluginEngine(paramCustomWebView, paramActivity, paramAppRuntime, paramCommonJsPluginFactory, paramList);
        }
      }
    }
    Util.g("createWebViewPluginEngine");
    if (localObject1 != null)
    {
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("plugin list:");
        paramAppRuntime.append(((WebViewPluginEngine)localObject1).a());
        QLog.d("WebAccelerateHelper", 2, paramAppRuntime.toString());
      }
      return localObject1;
    }
    throw new IllegalArgumentException("No contructor to create webview engine,check your arguments!");
  }
  
  public WebViewPluginEngine createWebViewPluginEngine(AppRuntime paramAppRuntime, Activity paramActivity, CustomWebView paramCustomWebView, List<WebViewPlugin> paramList)
  {
    return createWebViewPluginEngine(paramAppRuntime, paramActivity, paramCustomWebView, new CommonJsPluginFactory(), paramList);
  }
  
  public String getTBSDpcParam()
  {
    if (TextUtils.isEmpty(this.param)) {
      synchronized (this.sDPCLock)
      {
        if (TextUtils.isEmpty(this.param)) {
          this.param = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.tbs_switch.name(), "1|1");
        }
      }
    }
    return this.param;
  }
  
  public ArrayMap<String, String> getWebViewFeatureConfigs()
  {
    if (sWebViewFeatureConfigs == null) {
      try
      {
        if (sWebViewFeatureConfigs == null)
        {
          Object localObject3 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.WebViewConfig.name());
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("WebViewConfig:");
            ((StringBuilder)localObject1).append((String)localObject3);
            QLog.d("WebAccelerateHelper", 2, ((StringBuilder)localObject1).toString());
          }
          Object localObject1 = new ArrayMap(2);
          boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
          if (!bool) {
            try
            {
              localObject3 = new JSONObject((String)localObject3);
              String[] arrayOfString = CFG_KEYS;
              int j = arrayOfString.length;
              int i = 0;
              while (i < j)
              {
                String str = arrayOfString[i];
                ((ArrayMap)localObject1).put(str, ((JSONObject)localObject3).optString(str));
                i += 1;
              }
              sWebViewFeatureConfigs = (ArrayMap)localObject1;
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
            }
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("WebView feature configs=");
            ((StringBuilder)localObject1).append(sWebViewFeatureConfigs);
            QLog.d("WebAccelerateHelper", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
      finally {}
    }
    return sWebViewFeatureConfigs;
  }
  
  public Integer[] getWebViewFeatureParams()
  {
    if (sWebViewFeatureParams == null) {
      try
      {
        if (sWebViewFeatureParams == null)
        {
          Object localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.WebViewFeature.name());
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("WebViewFeature:");
            ((StringBuilder)localObject3).append((String)localObject1);
            QLog.d("WebAccelerateHelper", 2, ((StringBuilder)localObject3).toString());
          }
          Object localObject3 = new Integer[15];
          Arrays.fill((Object[])localObject3, Integer.valueOf(-1));
          ((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser((String)localObject1, (Integer[])localObject3);
          sWebViewFeatureParams = (Integer[])localObject3;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("WebView feature params=");
            ((StringBuilder)localObject1).append(Arrays.toString(sWebViewFeatureParams));
            QLog.d("WebAccelerateHelper", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
      finally {}
    }
    return sWebViewFeatureParams;
  }
  
  public boolean isCheckCookie()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "isCheckCookie");
    }
    return getWebViewFeatureParams()[1].intValue() == 1;
  }
  
  public boolean isPreGetKey()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "isPreGetKey");
    }
    Integer[] arrayOfInteger = getWebViewFeatureParams();
    boolean bool = false;
    if (arrayOfInteger[0].intValue() == 1) {
      bool = true;
    }
    return bool;
  }
  
  public void onPluginRuntimeReady(WebViewPluginEngine paramWebViewPluginEngine, AppRuntime paramAppRuntime, Activity paramActivity)
  {
    long l = System.currentTimeMillis();
    paramWebViewPluginEngine.a(paramAppRuntime, paramActivity);
    if (QLog.isColorLevel())
    {
      paramWebViewPluginEngine = new StringBuilder();
      paramWebViewPluginEngine.append("-->prepare plugin runtime cost:");
      paramWebViewPluginEngine.append(System.currentTimeMillis() - l);
      paramWebViewPluginEngine.append("(ms)");
      QLog.d("WebAccelerateHelper", 2, paramWebViewPluginEngine.toString());
    }
  }
  
  public void preCheckOffline(String paramString)
  {
    SwiftBrowserOfflineHandler localSwiftBrowserOfflineHandler = SwiftBrowserOfflineHandler.a(paramString);
    if (localSwiftBrowserOfflineHandler != null) {
      localSwiftBrowserOfflineHandler.a(new WebAccelerateHelper.3(this), paramString);
    }
  }
  
  public void preFetchResource(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    boolean bool1;
    boolean bool2;
    label119:
    label120:
    do
    {
      try
      {
        Object localObject = Uri.parse(paramString);
        if ((localObject == null) || (!((Uri)localObject).isHierarchical())) {
          break label119;
        }
        bool1 = "1".equals(((Uri)localObject).getQueryParameter("x5PreFetch"));
        bool2 = false;
        if (bool1)
        {
          localObject = SwiftBrowserCookieMonster.c(paramString);
          if ((localObject == null) || (!((SwiftBrowserCookieMonster)localObject).e())) {
            break label120;
          }
          bool1 = true;
          continue;
        }
        if (!"1".equals(((Uri)localObject).getQueryParameter("x5PreConnect"))) {
          break label120;
        }
        bool1 = false;
        bool2 = true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      ThreadManager.post(new WebAccelerateHelper.1(this, bool1, paramString, bool2), 5, null, true);
      return;
      return;
      bool1 = false;
    } while ((bool2) || (bool1));
  }
  
  public void preGetKey(Intent paramIntent, AppRuntime paramAppRuntime)
  {
    preGetKey(SwiftWebViewUtils.a(paramIntent), paramIntent, paramAppRuntime);
  }
  
  public void preGetKey(String paramString, Intent paramIntent, AppRuntime paramAppRuntime)
  {
    SwiftBrowserCookieMonster localSwiftBrowserCookieMonster = SwiftBrowserCookieMonster.c(paramString);
    if (localSwiftBrowserCookieMonster != null) {
      localSwiftBrowserCookieMonster.a(paramString, null, paramAppRuntime, paramIntent);
    }
  }
  
  public Integer[] queryWebViewFeatureParams()
  {
    if (sWebViewFeatureParams == null) {
      ThreadManager.post(new WebAccelerateHelper.2(this), 5, null, true);
    }
    return sWebViewFeatureParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebAccelerateHelper
 * JD-Core Version:    0.7.0.1
 */