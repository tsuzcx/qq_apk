package com.tencent.mobileqq.webprocess;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.View;
import antj;
import bihf;
import biit;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.sonic.SonicRuntimeImpl;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicConfig.Builder;
import com.tencent.sonic.sdk.SonicEngine;
import java.util.Arrays;
import java.util.List;
import nwo;
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
  private static WebAccelerateHelper instance;
  public static boolean isWebViewCache;
  private static final Object lock = new Object();
  public static View preloadBrowserView;
  static volatile ArrayMap<String, String> sWebViewFeatureConfigs;
  static volatile Integer[] sWebViewFeatureParams;
  public WebAccelerateHelper.TicketInfoListener mTicketInfoListener;
  public volatile String param;
  private final Object sDPCLock = new Object();
  
  public static WebAccelerateHelper getInstance()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new WebAccelerateHelper();
      }
      return instance;
    }
  }
  
  public static SonicEngine getSonicEngine()
  {
    try
    {
      if (SonicEngine.isGetInstanceAllowed()) {
        return SonicEngine.getInstance();
      }
      SonicEngine localSonicEngine = SonicEngine.createInstance(new SonicRuntimeImpl(BaseApplicationImpl.getApplication()), new SonicConfig.Builder().build());
      return localSonicEngine;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WebAccelerateHelper", 1, "get sonic engine error: " + localThrowable);
    }
    return null;
  }
  
  public static void preInflaterBrowserView()
  {
    long l = System.currentTimeMillis();
    if (preloadBrowserView == null) {}
    try
    {
      preloadBrowserView = new WebBrowserViewContainer(BaseApplicationImpl.sApplication);
      ((WebBrowserViewContainer)preloadBrowserView).a(false);
      if (QLog.isColorLevel()) {
        QLog.d("WebAccelerateHelper", 2, "Pre_Load_init_browser_view cost = " + (System.currentTimeMillis() - l));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("WebAccelerateHelper", 1, "preInflaterBrowserView error:" + localException.getMessage());
      }
    }
  }
  
  public void bindFragment(WebViewPluginEngine paramWebViewPluginEngine, WebViewFragment paramWebViewFragment)
  {
    long l = System.currentTimeMillis();
    paramWebViewPluginEngine.a(paramWebViewFragment);
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "bindFragment cost : " + (System.currentTimeMillis() - l));
    }
  }
  
  public void checkCookie(String paramString)
  {
    if ((isCheckCookie()) && (!TextUtils.isEmpty(paramString))) {
      ThreadManager.post(new WebAccelerateHelper.3(this, paramString), 5, null, true);
    }
  }
  
  public WebViewPluginEngine createWebViewPluginEngine(AppInterface paramAppInterface, Activity paramActivity, CustomWebView paramCustomWebView, WebAccelerateHelper.CommonJsPluginFactory paramCommonJsPluginFactory, List<WebViewPlugin> paramList)
  {
    nwo.a("createWebViewPluginEngine");
    if ((paramAppInterface != null) && (paramActivity == null) && (paramCustomWebView == null) && (paramList == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebAccelerateHelper", 2, "preload webview engine(with no plugin list)");
      }
      paramAppInterface = new WebViewPluginEngine(paramAppInterface, paramCommonJsPluginFactory, null);
    }
    for (;;)
    {
      nwo.b("createWebViewPluginEngine");
      if (paramAppInterface != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebAccelerateHelper", 2, "plugin list:" + paramAppInterface.a());
        }
        return paramAppInterface;
        if ((paramAppInterface != null) && (paramActivity == null) && (paramCustomWebView == null) && (paramList != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebAccelerateHelper", 2, "preload webview engine(with plugin list");
          }
          paramAppInterface = new WebViewPluginEngine(paramAppInterface, paramCommonJsPluginFactory, paramList);
          continue;
        }
        if ((paramAppInterface != null) && (paramList == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebAccelerateHelper", 2, "create webview engine(with no plugin list");
          }
          paramAppInterface = new WebViewPluginEngine(paramCustomWebView, paramActivity, paramAppInterface, paramCommonJsPluginFactory);
          continue;
        }
        if ((paramAppInterface != null) && (paramList != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebAccelerateHelper", 2, "create webview engine(with plugin list");
          }
          paramAppInterface = new WebViewPluginEngine(paramCustomWebView, paramActivity, paramAppInterface, paramCommonJsPluginFactory, paramList);
        }
      }
      else
      {
        throw new IllegalArgumentException("No contructor to create webview engine,check your arguments!");
      }
      paramAppInterface = null;
    }
  }
  
  public WebViewPluginEngine createWebViewPluginEngine(AppInterface paramAppInterface, Activity paramActivity, CustomWebView paramCustomWebView, List<WebViewPlugin> paramList)
  {
    return createWebViewPluginEngine(paramAppInterface, paramActivity, paramCustomWebView, new WebAccelerateHelper.CommonJsPluginFactory(), paramList);
  }
  
  public String getTBSDpcParam()
  {
    if (TextUtils.isEmpty(this.param)) {}
    synchronized (this.sDPCLock)
    {
      if (TextUtils.isEmpty(this.param)) {
        this.param = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.tbs_switch.name(), "1|1");
      }
      return this.param;
    }
  }
  
  public ArrayMap<String, String> getWebViewFeatureConfigs()
  {
    if (sWebViewFeatureConfigs == null) {}
    try
    {
      if (sWebViewFeatureConfigs == null)
      {
        Object localObject2 = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.WebViewConfig.name());
        if (QLog.isColorLevel()) {
          QLog.d("WebAccelerateHelper", 2, "WebViewConfig:" + (String)localObject2);
        }
        ArrayMap localArrayMap = new ArrayMap(2);
        boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
        if (!bool) {
          try
          {
            localObject2 = new JSONObject((String)localObject2);
            String[] arrayOfString = CFG_KEYS;
            int j = arrayOfString.length;
            int i = 0;
            while (i < j)
            {
              String str = arrayOfString[i];
              localArrayMap.put(str, ((JSONObject)localObject2).optString(str));
              i += 1;
            }
            sWebViewFeatureConfigs = localArrayMap;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("WebAccelerateHelper", 2, "WebView feature configs=" + sWebViewFeatureConfigs);
        }
      }
      return sWebViewFeatureConfigs;
    }
    finally {}
  }
  
  public Integer[] getWebViewFeatureParams()
  {
    if (sWebViewFeatureParams == null) {}
    try
    {
      if (sWebViewFeatureParams == null)
      {
        String str = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.WebViewFeature.name());
        if (QLog.isColorLevel()) {
          QLog.d("WebAccelerateHelper", 2, "WebViewFeature:" + str);
        }
        Integer[] arrayOfInteger = new Integer[15];
        Arrays.fill(arrayOfInteger, Integer.valueOf(-1));
        DeviceProfileManager.a(str, arrayOfInteger, new antj());
        sWebViewFeatureParams = arrayOfInteger;
        if (QLog.isColorLevel()) {
          QLog.d("WebAccelerateHelper", 2, "WebView feature params=" + Arrays.toString(sWebViewFeatureParams));
        }
      }
      return sWebViewFeatureParams;
    }
    finally {}
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
    return getWebViewFeatureParams()[0].intValue() == 1;
  }
  
  public void onPluginRuntimeReady(WebViewPluginEngine paramWebViewPluginEngine, AppInterface paramAppInterface, Activity paramActivity)
  {
    long l = System.currentTimeMillis();
    paramWebViewPluginEngine.a(paramAppInterface, paramActivity);
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "-->prepare plugin runtime cost:" + (System.currentTimeMillis() - l) + "(ms)");
    }
  }
  
  public void preCheckOffline(String paramString)
  {
    bihf localbihf = bihf.a(paramString);
    if (localbihf != null) {
      localbihf.a(new WebAccelerateHelper.4(this), paramString);
    }
  }
  
  public void preFetchResource(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = Uri.parse(paramString);
        if ((localObject == null) || (!((Uri)localObject).isHierarchical())) {
          break;
        }
        if (!"1".equals(((Uri)localObject).getQueryParameter("x5PreFetch"))) {
          break label94;
        }
        localObject = SwiftBrowserCookieMonster.a(paramString);
        if ((localObject == null) || (!((SwiftBrowserCookieMonster)localObject).a())) {
          break label120;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      ThreadManager.post(new WebAccelerateHelper.1(this, bool1, paramString, bool2), 5, null, true);
      return;
      label94:
      bool1 = "1".equals(((Uri)localObject).getQueryParameter("x5PreConnect"));
      if (bool1)
      {
        bool1 = false;
        bool2 = true;
      }
      else
      {
        label120:
        bool1 = false;
      }
      if (!bool2) {
        if (!bool1) {
          break;
        }
      }
    }
  }
  
  public void preGetKey(Intent paramIntent, AppInterface paramAppInterface)
  {
    preGetKey(biit.a(paramIntent), paramIntent, paramAppInterface);
  }
  
  public void preGetKey(String paramString, Intent paramIntent, AppInterface paramAppInterface)
  {
    SwiftBrowserCookieMonster localSwiftBrowserCookieMonster = SwiftBrowserCookieMonster.a(paramString);
    if (localSwiftBrowserCookieMonster != null) {
      localSwiftBrowserCookieMonster.a(paramString, null, paramAppInterface, paramIntent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebAccelerateHelper
 * JD-Core Version:    0.7.0.1
 */