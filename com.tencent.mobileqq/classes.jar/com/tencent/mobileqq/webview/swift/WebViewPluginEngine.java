package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtils;
import com.tencent.mobileqq.webprocess.temp.api.IWebviewApi;
import com.tencent.mobileqq.webview.nativeapi.INativeApiMangerInjector;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatisticss;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtilss;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebViewPluginEngine
{
  private static int jdField_a_of_type_Int = -1;
  public static WebViewPluginEngine a;
  protected static final HashMap<String, String> a;
  protected static final HashSet<String> a;
  public Activity a;
  private AuthorizeConfig jdField_a_of_type_ComTencentBizAuthorizeConfig;
  private volatile CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  private INativeApiMangerInjector jdField_a_of_type_ComTencentMobileqqWebviewNativeapiINativeApiMangerInjector;
  private WebViewPluginEngine.WebViewJSInterfaceImpl jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine$WebViewJSInterfaceImpl;
  public WebViewProvider a;
  private final ConcurrentHashMap<String, WebViewPlugin> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public AppRuntime a;
  private final HashMap<Long, CopyOnWriteArrayList<WebViewPlugin>> b = new HashMap();
  private final HashMap<String, CopyOnWriteArrayList<WebViewPlugin>> c = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_JavaUtilHashMap.put("auth.init", "Troop.init");
    jdField_a_of_type_JavaUtilHashMap.put("device.getNetworkInfo", "qbizApi.getNetworkInfo");
    jdField_a_of_type_JavaUtilHashMap.put("data.setShareInfo", "QQApi.setShareInfo");
    jdField_a_of_type_JavaUtilHashMap.put("event.dispatchEvent", "event.dispatchEvent");
    jdField_a_of_type_JavaUtilHashMap.put("media.showPicture", "troopNotice.showPicture");
    jdField_a_of_type_JavaUtilHashMap.put("ui.popBack", "publicAccount.close");
    jdField_a_of_type_JavaUtilHashMap.put("ui.shareMessage", "QQApi.shareMsg");
    jdField_a_of_type_JavaUtilHashSet.add("gflive.addBarrageList");
    jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = null;
  }
  
  public WebViewPluginEngine(CustomWebView paramCustomWebView, Activity paramActivity, AppRuntime paramAppRuntime, CommonJsPluginFactory paramCommonJsPluginFactory)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    c();
    a(false, paramAppRuntime, paramCommonJsPluginFactory, null);
    a();
    a(paramAppRuntime, paramActivity);
  }
  
  public WebViewPluginEngine(CustomWebView paramCustomWebView, Activity paramActivity, AppRuntime paramAppRuntime, CommonJsPluginFactory paramCommonJsPluginFactory, List<WebViewPlugin> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    c();
    a(false, paramAppRuntime, paramCommonJsPluginFactory, null);
    paramCustomWebView = paramList.iterator();
    while (paramCustomWebView.hasNext())
    {
      paramCommonJsPluginFactory = (WebViewPlugin)paramCustomWebView.next();
      b(paramCommonJsPluginFactory);
      a(paramCommonJsPluginFactory);
    }
    a(paramAppRuntime, paramActivity);
  }
  
  public WebViewPluginEngine(AppRuntime paramAppRuntime, CommonJsPluginFactory paramCommonJsPluginFactory, List<WebViewPlugin> paramList)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    c();
    a(true, paramAppRuntime, paramCommonJsPluginFactory, paramList);
  }
  
  private String a(long paramLong)
  {
    String str = Long.toBinaryString(paramLong);
    if (!TextUtils.isEmpty(str))
    {
      int i = str.length();
      return "1L << " + (i - str.replaceAll("0", "").length());
    }
    return "";
  }
  
  private void a(WebViewPlugin paramWebViewPlugin)
  {
    if (paramWebViewPlugin != null)
    {
      paramWebViewPlugin.initRuntime(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_MqqAppAppRuntime);
      paramWebViewPlugin.mRuntime.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider);
      paramWebViewPlugin.onCreate();
      if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
        paramWebViewPlugin.onWebViewCreated(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
      }
    }
  }
  
  private void a(String paramString, WebViewPlugin paramWebViewPlugin)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramWebViewPlugin == null)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      QLog.e("WebLog_WebViewPluginEngine", 1, "insertPlugin:namespace " + paramString + " already exists!");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("WebLog_WebViewPluginEngine", 2, "insertPlugin:add pair [" + paramString + "] -> " + paramWebViewPlugin.getClass().getSimpleName());
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramWebViewPlugin);
    long l2 = paramWebViewPlugin.getWebViewEventByNameSpace(paramString);
    Object localObject2;
    Object localObject1;
    int j;
    if (l2 > 0L)
    {
      i = 1;
      l1 = 1L;
      while (l2 >= l1)
      {
        if ((l2 & l1) != 0L)
        {
          localObject2 = (CopyOnWriteArrayList)this.b.get(Long.valueOf(l1));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new CopyOnWriteArrayList();
            this.b.put(Long.valueOf(l1), localObject1);
          }
          ((CopyOnWriteArrayList)localObject1).add(paramWebViewPlugin);
        }
        j = i + 1;
        l1 = 1L << i;
        i = j;
      }
    }
    l2 = paramWebViewPlugin.getWebViewSchemaByNameSpace(paramString);
    int i = 1;
    long l1 = 1L;
    label232:
    if ((l2 > 0L) && (l2 >= l1)) {
      if ((l2 & l1) != 0L)
      {
        localObject2 = WebViewPluginSchemeConfig.a(l1);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = (CopyOnWriteArrayList)this.c.get(localObject2);
          paramString = (String)localObject1;
          if (localObject1 == null)
          {
            paramString = new CopyOnWriteArrayList();
            this.c.put(localObject2, paramString);
          }
          j = paramWebViewPlugin.getWebViewSchemaListIndex();
          if ((j < 0) || (j >= paramString.size())) {
            break label352;
          }
          paramString.add(j, paramWebViewPlugin);
        }
      }
    }
    for (;;)
    {
      l1 = 1L << i;
      i += 1;
      break label232;
      break;
      label352:
      paramString.add(paramWebViewPlugin);
    }
  }
  
  private void a(boolean paramBoolean, AppRuntime paramAppRuntime, CommonJsPluginFactory paramCommonJsPluginFactory, List<WebViewPlugin> paramList)
  {
    paramCommonJsPluginFactory = paramCommonJsPluginFactory.getCommonJsPlugin().iterator();
    while (paramCommonJsPluginFactory.hasNext()) {
      b((WebViewPlugin)paramCommonJsPluginFactory.next());
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramCommonJsPluginFactory = paramList.iterator();
      while (paramCommonJsPluginFactory.hasNext()) {
        b((WebViewPlugin)paramCommonJsPluginFactory.next());
      }
    }
    paramCommonJsPluginFactory = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (paramCommonJsPluginFactory.hasNext())
    {
      paramList = (WebViewPlugin)paramCommonJsPluginFactory.next();
      paramList.onAppRuntimeReady(paramAppRuntime);
      paramList.onCreate();
      if (!paramBoolean)
      {
        paramList.initRuntime(this.jdField_a_of_type_AndroidAppActivity, paramAppRuntime);
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
          paramList.onWebViewCreated(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
        }
      }
    }
  }
  
  private static boolean a(WebViewPlugin paramWebViewPlugin, JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    if (paramWebViewPlugin == null) {}
    for (;;)
    {
      return false;
      try
      {
        long l1 = System.currentTimeMillis();
        long l2;
        if (paramWebViewPlugin.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramArrayOfString))
        {
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewPluginEngine", 2, new Object[] { new StringBuilder("plugin[").append(paramWebViewPlugin.getClass().getSimpleName()).append("] handle JsApi[").append(paramString2).append(".").append(paramString3).append("] cost ").append(l2 - l1).append(" ms.") });
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          l2 = System.currentTimeMillis();
          QLog.d("WebLog_WebViewPluginEngine", 2, new Object[] { new StringBuilder("plugin[").append(paramWebViewPlugin.getClass().getSimpleName()).append("] ignore JsApi[").append(paramString2).append(".").append(paramString3).append("] cost ").append(l2 - l1).append(" ms.") });
          return false;
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener = paramJsBridgeListener;
        QLog.e("WebLog_WebViewPluginEngine", 2, new Object[] { new StringBuilder("plugin[").append(paramWebViewPlugin.getClass().getSimpleName()).append("] handle JsApi[").append(paramString2).append(".").append(paramString3).append("] error:").append(paramJsBridgeListener.toString()) });
        return false;
      }
      finally {}
    }
    return true;
  }
  
  private static boolean a(WebViewPluginEngine paramWebViewPluginEngine, CustomWebView paramCustomWebView, String paramString)
  {
    Object localObject3 = (paramString + "/#").split("/");
    if (localObject3.length < 5)
    {
      QLog.e("WebLog_WebViewPluginEngine", 1, "illegal jsbridge:" + paramString);
      return true;
    }
    String str2 = localObject3[2];
    int j = 1;
    Object localObject1;
    if (localObject3.length == 5)
    {
      j = 0;
      localObject1 = localObject3[3].split("#");
      if (localObject1.length <= 1) {
        break label1131;
      }
    }
    for (;;)
    {
      int k;
      Object localObject4;
      try
      {
        i = Integer.parseInt(localObject1[1]);
        l = i;
        localObject1 = localObject1[0].split("\\?");
        localObject3 = localObject1[0];
        if (localObject1.length <= 1) {
          break label554;
        }
        localObject2 = localObject1[1].split("&");
        localObject1 = localObject2;
        if (localObject2.length <= 0) {
          break label386;
        }
        localObject1 = new ArrayList();
        i = 0;
        k = localObject2.length;
        if (i >= k) {
          break label364;
        }
        int m = localObject2[i].indexOf('=');
        if (m == -1) {
          break label351;
        }
        if (!"mqq_tt".equals(localObject2[i].substring(0, m)))
        {
          localObject4 = str2 + "." + (String)localObject3;
          if (jdField_a_of_type_JavaUtilHashSet.contains(localObject4)) {
            ((List)localObject1).add(localObject2[i].substring(m + 1));
          }
        }
        else
        {
          i += 1;
          continue;
        }
        ((List)localObject1).add(URLDecoder.decode(localObject2[i].substring(m + 1)));
      }
      catch (NumberFormatException paramWebViewPluginEngine)
      {
        QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { new StringBuilder("illegal jsbridge[").append(paramString).append("] error:").append(paramWebViewPluginEngine.toString()) });
        return true;
      }
      continue;
      label351:
      ((List)localObject1).add("");
      continue;
      label364:
      localObject1 = (String[])((List)localObject1).toArray(new String[((List)localObject1).size()]);
      label386:
      Object localObject2 = localObject1;
      localObject1 = localObject3;
      for (int i = j;; i = j)
      {
        JsBridgeListener localJsBridgeListener = new JsBridgeListener(paramCustomWebView, l, paramString);
        localObject3 = paramCustomWebView.getUrl();
        String str1 = str2 + "." + (String)localObject1;
        if (paramWebViewPluginEngine.a().a((String)localObject3, str1))
        {
          localObject4 = paramWebViewPluginEngine.a(str2);
          paramCustomWebView = (CustomWebView)localObject4;
          if (localObject4 == null) {
            paramCustomWebView = paramWebViewPluginEngine.b(str2);
          }
          label512:
          label519:
          label675:
          if (paramCustomWebView != null)
          {
            a(paramCustomWebView, localJsBridgeListener, paramString, str2, (String)localObject1, (String[])localObject2);
            if (SwiftBrowserStatisticss.b)
            {
              if (localObject3 != null) {
                break label675;
              }
              paramCustomWebView = null;
              if (paramCustomWebView != null) {
                break label684;
              }
              paramWebViewPluginEngine = "";
              if (paramCustomWebView != null) {
                break label692;
              }
            }
            label554:
            label684:
            label692:
            for (paramCustomWebView = "";; paramCustomWebView = paramCustomWebView.getPath())
            {
              ReportController.b(null, "dc00899", "WV_Analysis", "", "jsapi_call", "total", 0, 0, paramWebViewPluginEngine, paramCustomWebView, str1, "");
              return true;
              localObject1 = new String[0];
              break;
              localObject1 = localObject3[3];
              try
              {
                l = Long.parseLong(localObject3[4]);
                i = localObject3.length - 6;
                localObject2 = new String[i];
                System.arraycopy(localObject3, 5, localObject2, 0, i);
                i = 0;
                k = localObject2.length;
                while (i < k)
                {
                  localObject2[i] = URLDecoder.decode(localObject2[i]);
                  i += 1;
                }
                paramCustomWebView = Uri.parse((String)localObject3);
              }
              catch (Exception paramWebViewPluginEngine)
              {
                QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { new StringBuilder("illegal jsbridge[").append(paramString).append("] error:").append(paramWebViewPluginEngine.toString()) });
                return true;
              }
              break label512;
              paramWebViewPluginEngine = paramCustomWebView.getHost();
              break label519;
            }
          }
          if (i == 0) {}
        }
        for (;;)
        {
          if ((l == -1L) || (SwiftBrowserStatisticss.b))
          {
            if (localObject3 == null)
            {
              paramCustomWebView = null;
              label726:
              if (paramCustomWebView != null) {
                break label856;
              }
              paramWebViewPluginEngine = "";
              label733:
              if (paramCustomWebView != null) {
                break label864;
              }
              paramCustomWebView = "";
              label740:
              ReportController.b(null, "dc00899", "WV_Analysis", "", "jsapi_call", "total", 2, 0, paramWebViewPluginEngine, paramCustomWebView, str1, "");
            }
          }
          else
          {
            label766:
            return true;
            paramCustomWebView = null;
            paramWebViewPluginEngine = paramCustomWebView;
            if (localObject2.length > 0)
            {
              paramWebViewPluginEngine = paramCustomWebView;
              if (!localObject2[0].startsWith("{")) {}
            }
          }
          try
          {
            paramWebViewPluginEngine = new JSONObject(localObject2[0]).optString("callback");
            paramCustomWebView = paramWebViewPluginEngine;
            if (TextUtils.isEmpty(paramWebViewPluginEngine))
            {
              paramCustomWebView = paramWebViewPluginEngine;
              if (l != -1L) {
                paramCustomWebView = Long.toString(l);
              }
            }
            if (!TextUtils.isEmpty(paramCustomWebView))
            {
              continue;
              paramCustomWebView = Uri.parse((String)localObject3);
              break label726;
              label856:
              paramWebViewPluginEngine = paramCustomWebView.getHost();
              break label733;
              label864:
              paramCustomWebView = paramCustomWebView.getPath();
              break label740;
              localJsBridgeListener.a();
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                if (!((String)localObject3).contains("?")) {
                  break label1119;
                }
                paramCustomWebView = ((String)localObject3).substring(0, ((String)localObject3).indexOf("?"));
                i = (int)paramWebViewPluginEngine.a().a();
                j = QbSdk.getTbsVersion(BaseApplication.getContext());
                paramWebViewPluginEngine = DeviceInfoUtil.h() + " " + DeviceInfoUtil.i();
                VasWebviewUtils.a("JsApiRights", str2, (String)localObject1, 3, 0, j, i, paramCustomWebView, paramWebViewPluginEngine);
                if (!paramCustomWebView.startsWith("http")) {
                  QLog.d("WebLog_WebViewPluginEngine", 1, "no plugin have right handle  " + str1 + ", x5 version = " + j + ", phone is " + paramWebViewPluginEngine);
                }
              }
              if (!SwiftBrowserStatisticss.b) {
                break label766;
              }
              if (localObject3 == null)
              {
                paramCustomWebView = null;
                label1045:
                if (paramCustomWebView != null) {
                  break label1097;
                }
                paramWebViewPluginEngine = "";
                label1052:
                if (paramCustomWebView != null) {
                  break label1105;
                }
              }
              label1097:
              label1105:
              for (paramCustomWebView = "";; paramCustomWebView = paramCustomWebView.getPath())
              {
                ReportController.b(null, "dc00899", "WV_Analysis", "", "jsapi_call", "total", 1, 0, paramWebViewPluginEngine, paramCustomWebView, str1, "");
                break;
                paramCustomWebView = Uri.parse((String)localObject3);
                break label1045;
                paramWebViewPluginEngine = paramCustomWebView.getHost();
                break label1052;
              }
            }
          }
          catch (JSONException paramWebViewPluginEngine)
          {
            for (;;)
            {
              paramWebViewPluginEngine = paramCustomWebView;
              continue;
              label1119:
              paramCustomWebView = (CustomWebView)localObject3;
            }
          }
        }
      }
      label1131:
      long l = -1L;
    }
  }
  
  private WebViewPlugin b(String paramString)
  {
    paramString = WebViewPluginFactory.a(paramString);
    b(paramString);
    a(paramString);
    return paramString;
  }
  
  private void b(CustomWebView paramCustomWebView)
  {
    if (paramCustomWebView == null) {
      QLog.e("WebLog_WebViewPluginEngine", 1, "registerJSInterface webView is null");
    }
    do
    {
      do
      {
        return;
        if (Build.VERSION.SDK_INT >= 17) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("WebLog_WebViewPluginEngine", 1, "registerJSInterface SDK is lower than 4.2");
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine$WebViewJSInterfaceImpl != null);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewPluginEngine", 2, "registerJSInterface");
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine$WebViewJSInterfaceImpl = new WebViewPluginEngine.WebViewJSInterfaceImpl(this);
    paramCustomWebView.addJavascriptInterface(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine$WebViewJSInterfaceImpl, "_mqqWebViewJSInterface");
  }
  
  private void b(WebViewPlugin paramWebViewPlugin)
  {
    if ((paramWebViewPlugin instanceof MultiNameSpacePluginCompact))
    {
      String[] arrayOfString = ((MultiNameSpacePluginCompact)paramWebViewPlugin).getMultiNameSpace();
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (!TextUtils.isEmpty(str)) {
            a(str, paramWebViewPlugin);
          }
          i += 1;
        }
      }
    }
    else if ((paramWebViewPlugin != null) && (!TextUtils.isEmpty(paramWebViewPlugin.mPluginNameSpace)))
    {
      a(paramWebViewPlugin.mPluginNameSpace, paramWebViewPlugin);
    }
  }
  
  private void b(AppRuntime paramAppRuntime, Activity paramActivity, List<WebViewPlugin> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)paramList.next();
        localWebViewPlugin.initRuntime(paramActivity, paramAppRuntime);
        localWebViewPlugin.onCreate();
        localWebViewPlugin.onAppRuntimeReady(paramAppRuntime);
        b(localWebViewPlugin);
      }
    }
  }
  
  /* Error */
  private static boolean b(WebViewPluginEngine paramWebViewPluginEngine, CustomWebView paramCustomWebView, String paramString)
  {
    // Byte code:
    //   0: new 154	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   7: aload_2
    //   8: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11: ldc_w 332
    //   14: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: ldc_w 334
    //   23: invokevirtual 338	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   26: astore 9
    //   28: aload 9
    //   30: arraylength
    //   31: iconst_5
    //   32: if_icmpge +31 -> 63
    //   35: ldc 204
    //   37: iconst_1
    //   38: new 154	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 340
    //   48: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_2
    //   52: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 214	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: iconst_1
    //   62: ireturn
    //   63: aload 9
    //   65: iconst_2
    //   66: aaload
    //   67: astore 14
    //   69: ldc2_w 453
    //   72: lstore 7
    //   74: aload 9
    //   76: arraylength
    //   77: iconst_5
    //   78: if_icmpne +502 -> 580
    //   81: aload 9
    //   83: iconst_3
    //   84: aaload
    //   85: ldc_w 342
    //   88: invokevirtual 338	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   91: astore 9
    //   93: aload 9
    //   95: arraylength
    //   96: iconst_1
    //   97: if_icmple +15 -> 112
    //   100: aload 9
    //   102: iconst_1
    //   103: aaload
    //   104: invokestatic 348	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   107: istore_3
    //   108: iload_3
    //   109: i2l
    //   110: lstore 7
    //   112: aload 9
    //   114: iconst_0
    //   115: aaload
    //   116: ldc_w 350
    //   119: invokevirtual 338	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   122: astore 10
    //   124: aload 10
    //   126: arraylength
    //   127: iconst_1
    //   128: if_icmple +443 -> 571
    //   131: aload 10
    //   133: iconst_1
    //   134: aaload
    //   135: bipush 61
    //   137: invokevirtual 359	java/lang/String:indexOf	(I)I
    //   140: istore_3
    //   141: iload_3
    //   142: iconst_m1
    //   143: if_icmpeq +419 -> 562
    //   146: aload 10
    //   148: iconst_1
    //   149: aaload
    //   150: iload_3
    //   151: iconst_1
    //   152: iadd
    //   153: invokevirtual 374	java/lang/String:substring	(I)Ljava/lang/String;
    //   156: invokestatic 384	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   159: astore 11
    //   161: ldc_w 560
    //   164: aload 11
    //   166: invokevirtual 368	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifeq +378 -> 547
    //   172: iconst_0
    //   173: anewarray 148	java/lang/String
    //   176: astore 9
    //   178: aload 9
    //   180: astore 11
    //   182: aload 10
    //   184: iconst_0
    //   185: aaload
    //   186: astore 15
    //   188: new 154	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   195: aload 14
    //   197: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 307
    //   203: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 15
    //   208: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: astore 22
    //   216: new 392	com/tencent/mobileqq/webview/swift/JsBridgeListener
    //   219: dup
    //   220: aload_1
    //   221: lload 7
    //   223: iconst_1
    //   224: invokespecial 563	com/tencent/mobileqq/webview/swift/JsBridgeListener:<init>	(Lcom/tencent/smtt/sdk/WebView;JZ)V
    //   227: astore 21
    //   229: getstatic 78	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:jdField_a_of_type_Int	I
    //   232: iconst_m1
    //   233: if_icmpne +17 -> 250
    //   236: iconst_3
    //   237: iconst_1
    //   238: invokestatic 568	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatisticsConfigUtils:a	(IZ)Z
    //   241: ifeq +357 -> 598
    //   244: iconst_1
    //   245: istore_3
    //   246: iload_3
    //   247: putstatic 78	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:jdField_a_of_type_Int	I
    //   250: getstatic 78	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:jdField_a_of_type_Int	I
    //   253: iconst_1
    //   254: if_icmpne +62 -> 316
    //   257: aload_1
    //   258: invokevirtual 400	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   261: astore 9
    //   263: aload 9
    //   265: ifnonnull +338 -> 603
    //   268: aconst_null
    //   269: astore 10
    //   271: aload 10
    //   273: ifnonnull +340 -> 613
    //   276: ldc 165
    //   278: astore 9
    //   280: aload 10
    //   282: ifnonnull +341 -> 623
    //   285: ldc 165
    //   287: astore 10
    //   289: aconst_null
    //   290: ldc_w 422
    //   293: ldc_w 424
    //   296: ldc 165
    //   298: ldc_w 570
    //   301: aload 22
    //   303: iconst_0
    //   304: iconst_0
    //   305: aload 9
    //   307: aload 10
    //   309: ldc 165
    //   311: ldc 165
    //   313: invokestatic 433	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   316: iconst_0
    //   317: istore 4
    //   319: iconst_0
    //   320: istore 5
    //   322: iconst_0
    //   323: istore 6
    //   325: aconst_null
    //   326: astore 18
    //   328: aconst_null
    //   329: astore 17
    //   331: aconst_null
    //   332: astore 19
    //   334: aconst_null
    //   335: astore 13
    //   337: aconst_null
    //   338: astore 16
    //   340: aconst_null
    //   341: astore 20
    //   343: iload 6
    //   345: istore_3
    //   346: aload 19
    //   348: astore 9
    //   350: aload 20
    //   352: astore 10
    //   354: aload 11
    //   356: astore 12
    //   358: aload 11
    //   360: arraylength
    //   361: iconst_1
    //   362: if_icmpne +123 -> 485
    //   365: iload 6
    //   367: istore_3
    //   368: aload 19
    //   370: astore 9
    //   372: aload 20
    //   374: astore 10
    //   376: aload 11
    //   378: astore 12
    //   380: ldc 40
    //   382: aload 22
    //   384: invokevirtual 368	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   387: ifne +98 -> 485
    //   390: new 462	org/json/JSONObject
    //   393: dup
    //   394: aload 11
    //   396: iconst_0
    //   397: aaload
    //   398: invokespecial 463	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   401: astore 12
    //   403: aload 12
    //   405: ldc_w 572
    //   408: invokevirtual 576	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   411: checkcast 148	java/lang/String
    //   414: invokestatic 348	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   417: istore_3
    //   418: aload 12
    //   420: ldc_w 578
    //   423: invokevirtual 576	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   426: checkcast 148	java/lang/String
    //   429: astore 9
    //   431: aload 12
    //   433: ldc_w 580
    //   436: invokevirtual 576	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   439: checkcast 148	java/lang/String
    //   442: astore 10
    //   444: aload 12
    //   446: ldc_w 582
    //   449: invokevirtual 576	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   452: pop
    //   453: aload 12
    //   455: invokevirtual 583	org/json/JSONObject:toString	()Ljava/lang/String;
    //   458: astore 13
    //   460: ldc_w 560
    //   463: aload 13
    //   465: invokevirtual 368	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   468: ifeq +165 -> 633
    //   471: iconst_0
    //   472: anewarray 148	java/lang/String
    //   475: astore 12
    //   477: aload 12
    //   479: astore 11
    //   481: aload 11
    //   483: astore 12
    //   485: aload_1
    //   486: aload_1
    //   487: iload_3
    //   488: aload 9
    //   490: aload 10
    //   492: aload 22
    //   494: aload 21
    //   496: invokevirtual 587	com/tencent/biz/pubaccount/CustomWebView:checkToken	(Lcom/tencent/biz/pubaccount/CustomWebView;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)Z
    //   499: ifne +270 -> 769
    //   502: iconst_1
    //   503: ireturn
    //   504: astore_0
    //   505: ldc 204
    //   507: iconst_1
    //   508: iconst_1
    //   509: anewarray 4	java/lang/Object
    //   512: dup
    //   513: iconst_0
    //   514: new 154	java/lang/StringBuilder
    //   517: dup
    //   518: ldc_w 377
    //   521: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   524: aload_2
    //   525: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: ldc_w 322
    //   531: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_0
    //   535: invokevirtual 378	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   538: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aastore
    //   542: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   545: iconst_1
    //   546: ireturn
    //   547: iconst_1
    //   548: anewarray 148	java/lang/String
    //   551: astore 9
    //   553: aload 9
    //   555: iconst_0
    //   556: aload 11
    //   558: aastore
    //   559: goto -381 -> 178
    //   562: iconst_0
    //   563: anewarray 148	java/lang/String
    //   566: astore 9
    //   568: goto -390 -> 178
    //   571: iconst_0
    //   572: anewarray 148	java/lang/String
    //   575: astore 11
    //   577: goto -395 -> 182
    //   580: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   583: ifeq +13 -> 596
    //   586: ldc_w 589
    //   589: iconst_2
    //   590: ldc_w 591
    //   593: invokestatic 214	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   596: iconst_0
    //   597: ireturn
    //   598: iconst_0
    //   599: istore_3
    //   600: goto -354 -> 246
    //   603: aload 9
    //   605: invokestatic 446	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   608: astore 10
    //   610: goto -339 -> 271
    //   613: aload 10
    //   615: invokevirtual 449	android/net/Uri:getHost	()Ljava/lang/String;
    //   618: astore 9
    //   620: goto -340 -> 280
    //   623: aload 10
    //   625: invokevirtual 452	android/net/Uri:getPath	()Ljava/lang/String;
    //   628: astore 10
    //   630: goto -341 -> 289
    //   633: iconst_1
    //   634: anewarray 148	java/lang/String
    //   637: astore 12
    //   639: aload 12
    //   641: iconst_0
    //   642: aload 13
    //   644: aastore
    //   645: aload 12
    //   647: astore 11
    //   649: goto -168 -> 481
    //   652: astore 13
    //   654: aload 10
    //   656: astore 12
    //   658: aload 9
    //   660: astore 10
    //   662: aload 13
    //   664: astore 9
    //   666: ldc 204
    //   668: iconst_1
    //   669: new 154	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   676: ldc_w 593
    //   679: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: aload 9
    //   684: invokevirtual 378	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   687: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokestatic 214	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   696: aload 10
    //   698: astore 9
    //   700: aload 12
    //   702: astore 10
    //   704: aload 11
    //   706: astore 12
    //   708: goto -223 -> 485
    //   711: astore 9
    //   713: aload 16
    //   715: astore 12
    //   717: aload 17
    //   719: astore 10
    //   721: iload 5
    //   723: istore_3
    //   724: ldc 204
    //   726: iconst_1
    //   727: new 154	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   734: ldc_w 595
    //   737: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: aload 9
    //   742: invokevirtual 596	org/json/JSONException:toString	()Ljava/lang/String;
    //   745: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokestatic 214	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   754: aload 10
    //   756: astore 9
    //   758: aload 12
    //   760: astore 10
    //   762: aload 11
    //   764: astore 12
    //   766: goto -281 -> 485
    //   769: getstatic 33	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   772: aload 22
    //   774: invokevirtual 597	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   777: ifeq +207 -> 984
    //   780: getstatic 33	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   783: aload 22
    //   785: invokevirtual 246	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   788: checkcast 148	java/lang/String
    //   791: ldc_w 599
    //   794: invokevirtual 338	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   797: astore 10
    //   799: aload 10
    //   801: arraylength
    //   802: iconst_2
    //   803: if_icmpne +181 -> 984
    //   806: aload 10
    //   808: iconst_0
    //   809: aaload
    //   810: astore 9
    //   812: aload 10
    //   814: iconst_1
    //   815: aaload
    //   816: astore 10
    //   818: aload_0
    //   819: aload 9
    //   821: invokevirtual 411	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   824: astore 13
    //   826: aload 13
    //   828: astore 11
    //   830: aload 13
    //   832: ifnonnull +11 -> 843
    //   835: aload_0
    //   836: aload 9
    //   838: invokespecial 413	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   841: astore 11
    //   843: aload 11
    //   845: ifnull +22 -> 867
    //   848: aload 11
    //   850: aload 21
    //   852: aload_2
    //   853: aload 9
    //   855: aload 10
    //   857: aload 12
    //   859: invokestatic 415	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z
    //   862: ifeq +5 -> 867
    //   865: iconst_1
    //   866: ireturn
    //   867: aload_1
    //   868: aload 21
    //   870: iconst_3
    //   871: iconst_1
    //   872: anewarray 148	java/lang/String
    //   875: dup
    //   876: iconst_0
    //   877: iconst_3
    //   878: aconst_null
    //   879: ldc_w 601
    //   882: invokestatic 604	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(ILjava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
    //   885: aastore
    //   886: invokevirtual 608	com/tencent/biz/pubaccount/CustomWebView:callJs4OpenApi	(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;I[Ljava/lang/String;)V
    //   889: iconst_1
    //   890: ireturn
    //   891: astore 9
    //   893: aload 17
    //   895: astore 10
    //   897: aload 16
    //   899: astore 12
    //   901: goto -177 -> 724
    //   904: astore 12
    //   906: aload 9
    //   908: astore 10
    //   910: aload 12
    //   912: astore 9
    //   914: aload 16
    //   916: astore 12
    //   918: goto -194 -> 724
    //   921: astore 13
    //   923: aload 10
    //   925: astore 12
    //   927: aload 9
    //   929: astore 10
    //   931: aload 13
    //   933: astore 9
    //   935: goto -211 -> 724
    //   938: astore 9
    //   940: iload 4
    //   942: istore_3
    //   943: aload 18
    //   945: astore 10
    //   947: aload 13
    //   949: astore 12
    //   951: goto -285 -> 666
    //   954: astore 9
    //   956: aload 18
    //   958: astore 10
    //   960: aload 13
    //   962: astore 12
    //   964: goto -298 -> 666
    //   967: astore 12
    //   969: aload 9
    //   971: astore 10
    //   973: aload 12
    //   975: astore 9
    //   977: aload 13
    //   979: astore 12
    //   981: goto -315 -> 666
    //   984: aload 15
    //   986: astore 10
    //   988: aload 14
    //   990: astore 9
    //   992: goto -174 -> 818
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	995	0	paramWebViewPluginEngine	WebViewPluginEngine
    //   0	995	1	paramCustomWebView	CustomWebView
    //   0	995	2	paramString	String
    //   107	836	3	i	int
    //   317	624	4	j	int
    //   320	402	5	k	int
    //   323	43	6	m	int
    //   72	150	7	l	long
    //   26	673	9	localObject1	Object
    //   711	30	9	localJSONException1	JSONException
    //   756	98	9	localObject2	Object
    //   891	16	9	localJSONException2	JSONException
    //   912	22	9	localObject3	Object
    //   938	1	9	localNumberFormatException1	NumberFormatException
    //   954	16	9	localNumberFormatException2	NumberFormatException
    //   975	16	9	localObject4	Object
    //   122	865	10	localObject5	Object
    //   159	690	11	localObject6	Object
    //   356	544	12	localObject7	Object
    //   904	7	12	localJSONException3	JSONException
    //   916	47	12	localObject8	Object
    //   967	7	12	localNumberFormatException3	NumberFormatException
    //   979	1	12	localJSONException4	JSONException
    //   335	308	13	str1	String
    //   652	11	13	localNumberFormatException4	NumberFormatException
    //   824	7	13	localWebViewPlugin	WebViewPlugin
    //   921	57	13	localJSONException5	JSONException
    //   67	922	14	str2	String
    //   186	799	15	str3	String
    //   338	577	16	localObject9	Object
    //   329	565	17	localObject10	Object
    //   326	631	18	localObject11	Object
    //   332	37	19	localObject12	Object
    //   341	32	20	localObject13	Object
    //   227	642	21	localJsBridgeListener	JsBridgeListener
    //   214	570	22	str4	String
    // Exception table:
    //   from	to	target	type
    //   100	108	504	java/lang/NumberFormatException
    //   444	477	652	java/lang/NumberFormatException
    //   633	639	652	java/lang/NumberFormatException
    //   390	418	711	org/json/JSONException
    //   418	431	891	org/json/JSONException
    //   431	444	904	org/json/JSONException
    //   444	477	921	org/json/JSONException
    //   633	639	921	org/json/JSONException
    //   390	418	938	java/lang/NumberFormatException
    //   418	431	954	java/lang/NumberFormatException
    //   431	444	967	java/lang/NumberFormatException
  }
  
  private boolean b(String paramString)
  {
    String str1 = SwiftWebViewUtilss.a(paramString);
    if (TextUtils.isEmpty(str1)) {
      return false;
    }
    if ("javascript".equals(str1)) {
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
    if (localObject1 == null) {
      return false;
    }
    if ("jsbridge".equals(str1)) {
      return a(this, (CustomWebView)localObject1, paramString);
    }
    if ("openapi".equals(str1)) {
      return b(this, (CustomWebView)localObject1, paramString);
    }
    if ("nativeapi".equals(str1)) {
      return c(this, (CustomWebView)localObject1, paramString);
    }
    String str2 = ((CustomWebView)localObject1).getUrl();
    if ((this.c.containsKey(str1)) && (a().c(str2, str1)))
    {
      Object localObject2 = (CopyOnWriteArrayList)this.c.get(str1);
      if ((localObject2 != null) && (!((CopyOnWriteArrayList)localObject2).isEmpty()))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder(((CopyOnWriteArrayList)localObject2).size() * 64);
          localObject2 = ((CopyOnWriteArrayList)localObject2).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label405;
          }
          WebViewPlugin localWebViewPlugin = (WebViewPlugin)((Iterator)localObject2).next();
          long l1 = System.currentTimeMillis();
          if (localWebViewPlugin != null)
          {
            if (localWebViewPlugin.handleSchemaRequest(paramString, str1))
            {
              if (QLog.isColorLevel())
              {
                long l2 = System.currentTimeMillis();
                ((StringBuilder)localObject1).append("plugin[").append(localWebViewPlugin.getClass().getSimpleName()).append("] handle scheme[").append(str1).append("] success cost ").append(l2 - l1).append(" ms.");
                QLog.i("WebLog_WebViewPluginEngine", 2, ((StringBuilder)localObject1).toString());
              }
              ((IWebviewApi)QRoute.api(IWebviewApi.class)).reportSchema(paramString, str2, 0);
              return true;
              localObject1 = new StringBuilder();
              break;
            }
            if (QLog.isColorLevel())
            {
              l1 = System.currentTimeMillis() - l1;
              if (l1 > 50L) {
                ((StringBuilder)localObject1).append("plugin[").append(localWebViewPlugin.getClass().getSimpleName()).append("] handle scheme[").append(str1).append("] cost ").append(l1).append(" ms.");
              }
            }
          }
        }
        label405:
        if ((QLog.isColorLevel()) && (((StringBuilder)localObject1).length() > 0))
        {
          ((StringBuilder)localObject1).append("overrideUrlRequest error:no plugin can handle this scheme[").append(str1).append("].");
          QLog.i("WebLog_WebViewPluginEngine", 2, ((StringBuilder)localObject1).toString());
        }
        ((IWebviewApi)QRoute.api(IWebviewApi.class)).reportSchema(paramString, str2, 1);
      }
    }
    for (;;)
    {
      return false;
      QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { new StringBuilder("overrideUrlRequest error:no plugin can handle this scheme[").append(str1).append("].") });
      ((IWebviewApi)QRoute.api(IWebviewApi.class)).reportSchema(paramString, str2, 2);
    }
  }
  
  private void c()
  {
    try
    {
      if ((WebViewEngineInjectorUtil.a != null) && (WebViewEngineInjectorUtil.a.size() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewNativeapiINativeApiMangerInjector = ((INativeApiMangerInjector)((Class)WebViewEngineInjectorUtil.a.get(0)).newInstance());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WebLog_WebViewPluginEngine", 1, "registerNativeApiManagerInjectors Fail,", localThrowable);
    }
  }
  
  private static boolean c(WebViewPluginEngine paramWebViewPluginEngine, CustomWebView paramCustomWebView, String paramString)
  {
    if (paramWebViewPluginEngine.a() != null) {
      return paramWebViewPluginEngine.a().a(paramCustomWebView, paramString, paramWebViewPluginEngine.jdField_a_of_type_AndroidAppActivity);
    }
    return true;
  }
  
  public AuthorizeConfig a()
  {
    if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
      this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    }
    return this.jdField_a_of_type_ComTencentBizAuthorizeConfig;
  }
  
  public INativeApiMangerInjector a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewNativeapiINativeApiMangerInjector;
  }
  
  public WebViewPlugin a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    Iterator localIterator1 = WebViewPluginFactory.b.entrySet().iterator();
    Object localObject2;
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      if (((Integer)localEntry.getValue()).intValue() == paramInt)
      {
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        localObject2 = localObject1;
        localObject1 = localObject2;
        if (localIterator2.hasNext())
        {
          localObject1 = (WebViewPlugin)localIterator2.next();
          if (localObject1.getClass() != localEntry.getKey()) {
            break label157;
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      break;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (paramBoolean)
        {
          localObject1 = WebViewPluginFactory.a(paramInt);
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            b((WebViewPlugin)localObject1);
            a((WebViewPlugin)localObject1);
            localObject2 = localObject1;
          }
        }
      }
      return localObject2;
      label157:
      localObject1 = localObject2;
    }
  }
  
  public WebViewPlugin a(String paramString)
  {
    return a(paramString, false);
  }
  
  public WebViewPlugin a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return (WebViewPlugin)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    if (paramBoolean) {
      return WebViewPluginFactory.a(paramString);
    }
    return null;
  }
  
  public Object a(String paramString, long paramLong)
  {
    Object localObject1 = (List)this.b.get(Long.valueOf(paramLong));
    Object localObject3;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject3 = a(paramLong);
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    while ((localObject2 == null) || (((List)localObject2).size() == 0))
    {
      return null;
      if (paramLong > 8589934592L)
      {
        localObject2 = new CopyOnWriteArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values());
        localObject1 = String.valueOf(paramLong - 8589934592L);
      }
      else
      {
        QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { new StringBuilder("handleEvent error:no plugin can handle this event(").append(paramLong).append(").") });
        localObject3 = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    HashMap localHashMap = new HashMap();
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder(((List)localObject2).size() * 64);
      localObject2 = ((List)localObject2).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label409;
      }
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)((Iterator)localObject2).next();
      if ((localWebViewPlugin != null) && (!localHashMap.containsKey(localWebViewPlugin)))
      {
        long l1 = System.currentTimeMillis();
        Object localObject4 = localWebViewPlugin.handleEvent(paramString, paramLong);
        if (localObject4 != null)
        {
          if (QLog.isColorLevel())
          {
            long l2 = System.currentTimeMillis();
            ((StringBuilder)localObject3).append("plugin[").append(localWebViewPlugin.getClass().getSimpleName()).append("] handled event[").append(paramLong).append("] success cost ").append(l2 - l1).append(" ms.");
            QLog.i("WebLog_WebViewPluginEngine", 2, ((StringBuilder)localObject3).toString());
          }
          return localObject4;
          localObject3 = new StringBuilder();
          break;
        }
        localHashMap.put(localWebViewPlugin, Boolean.valueOf(true));
        if (QLog.isColorLevel())
        {
          l1 = System.currentTimeMillis() - l1;
          if (l1 > 50L) {
            ((StringBuilder)localObject3).append("plugin[").append(localWebViewPlugin.getClass().getSimpleName()).append("] handled event[").append(paramLong).append("] cost ").append(l1).append(" ms\r\n.");
          }
        }
      }
    }
    label409:
    if ((QLog.isColorLevel()) && (((StringBuilder)localObject3).length() > 0))
    {
      ((StringBuilder)localObject3).append("handleEvent error:no plugin can handleEvent (").append((String)localObject1).append(")");
      QLog.i("WebLog_WebViewPluginEngine", 2, ((StringBuilder)localObject3).toString());
    }
    return null;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewPluginEngine", 2, "-->plugin list is empty.");
      }
      return "no plugins";
    }
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("plugin list:\n");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((WebViewPlugin)localIterator.next()).getClass().getSimpleName()).append("\n");
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    Intent localIntent;
    String str2;
    String str1;
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      str2 = localIntent.getStringExtra("url");
      str1 = str2;
      if (str2 != null) {
        break label194;
      }
      str2 = localIntent.getStringExtra("key_params_qq");
      str1 = str2;
      if (str2 != null) {
        break label194;
      }
      str1 = "";
    }
    label194:
    for (;;)
    {
      if (TextUtils.isEmpty(str1)) {
        return;
      }
      int i = str1.indexOf(":");
      if (i > 0) {}
      for (str2 = str1.substring(0, i);; str2 = "")
      {
        Iterator localIterator = WebViewPluginFactory.b.keySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Class)localIterator.next();
          if (IPreCreatePluginChecker.class.isAssignableFrom((Class)localObject)) {
            try
            {
              localObject = (WebViewPlugin)((Class)localObject).newInstance();
              if (((IPreCreatePluginChecker)localObject).isNeedPreCreatePlugin(localIntent, str1, str2))
              {
                a((WebViewPlugin)localObject);
                b((WebViewPlugin)localObject);
              }
            }
            catch (Throwable localThrowable)
            {
              QLog.d("WebLog_WebViewPluginEngine", 1, "preCreatePlugin failed", localThrowable);
            }
          }
        }
      }
      QRoute.api(IQQGameConfigService.class);
      return;
    }
  }
  
  public void a(CustomWebView paramCustomWebView)
  {
    if ((paramCustomWebView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != paramCustomWebView))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext()) {
        ((WebViewPlugin)localIterator.next()).onWebViewCreated(paramCustomWebView);
      }
      b(paramCustomWebView);
    }
  }
  
  public void a(WebUiBaseInterface paramWebUiBaseInterface)
  {
    if (paramWebUiBaseInterface == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)localIterator.next();
        if (localWebViewPlugin != null) {
          localWebViewPlugin.setWebUiInterface(paramWebUiBaseInterface);
        }
      }
    }
  }
  
  public void a(WebViewProvider paramWebViewProvider)
  {
    if (paramWebViewProvider == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider = paramWebViewProvider;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)localIterator.next();
        if (localWebViewPlugin != null) {
          localWebViewPlugin.bindWebViewProvider(paramWebViewProvider);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("WebLog_WebViewPluginEngine", 1, "handleJsInterfaceRequest requestUrl is null");
      return;
    }
    String str;
    if (paramString.startsWith("https://jsbridge/"))
    {
      str = paramString.replace("https://jsbridge/", "jsbridge://");
      if (QLog.isColorLevel())
      {
        if ((!str.startsWith("jsbridge://")) || (str.length() <= 512)) {
          break label140;
        }
        QLog.i("WebLog_WebViewPluginEngine", 2, "handleJsInterfaceRequest:" + str.substring(0, 512));
      }
    }
    for (;;)
    {
      if (str.startsWith("jsbridge:")) {
        break label166;
      }
      QLog.e("WebLog_WebViewPluginEngine", 1, "handleJsInterfaceRequest requestUrl is not startsWith jsbridge");
      return;
      str = paramString;
      if (!paramString.startsWith("http://jsbridge/")) {
        break;
      }
      str = paramString.replace("http://jsbridge/", "jsbridge://");
      break;
      label140:
      QLog.i("WebLog_WebViewPluginEngine", 2, "handleJsInterfaceRequest:" + str);
    }
    label166:
    ThreadManagerV2.getUIHandlerV2().post(new WebViewPluginEngine.2(this, str));
  }
  
  public void a(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    a(paramAppRuntime, paramActivity, null);
  }
  
  public void a(AppRuntime paramAppRuntime, Activity paramActivity, List<WebViewPlugin> paramList)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    }
    if ((paramList != null) && (paramList.size() > 0)) {
      b(paramAppRuntime, paramActivity, paramList);
    }
    paramList = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = (WebViewPlugin)paramList.next();
      if (localObject != null)
      {
        if (((WebViewPlugin)localObject).mRuntime == null) {
          ((WebViewPlugin)localObject).initRuntime(paramActivity, paramAppRuntime);
        }
        ((WebViewPlugin)localObject).onActivityReady();
      }
    }
    if ((paramActivity == null) || (paramActivity.getIntent() == null)) {
      QLog.i("WebLog_WebViewPluginEngine", 1, "onRuntimeReady params activity is empty");
    }
    for (;;)
    {
      return;
      paramList = WebViewPluginFactory.b.keySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Class)paramList.next();
        if (IPostCreatePluginChecker.class.isAssignableFrom((Class)localObject)) {
          try
          {
            localObject = (WebViewPlugin)((Class)localObject).newInstance();
            if (((IPostCreatePluginChecker)localObject).a(paramActivity.getIntent(), new CopyOnWriteArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values())))
            {
              ((WebViewPlugin)localObject).initRuntime(paramActivity, paramAppRuntime);
              ((WebViewPlugin)localObject).onCreate();
              ((WebViewPlugin)localObject).onAppRuntimeReady(paramAppRuntime);
              b((WebViewPlugin)localObject);
            }
          }
          catch (Throwable localThrowable)
          {
            QLog.d("WebLog_WebViewPluginEngine", 1, "onPluginRuntimeReady failed", localThrowable);
          }
        }
      }
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        b(paramArrayOfString[i]);
        i += 1;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool = b(paramString);
    if (bool) {}
    return bool;
  }
  
  public boolean a(String paramString, long paramLong, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorCode", Integer.valueOf(paramInt));
    return a(paramString, paramLong, localHashMap);
  }
  
  public boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    Object localObject;
    if (this.b.containsKey(Long.valueOf(paramLong))) {
      localObject = (List)this.b.get(Long.valueOf(paramLong));
    }
    while ((localObject == null) || (((List)localObject).size() == 0))
    {
      return false;
      if (paramLong > 8589934592L)
      {
        localObject = new CopyOnWriteArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values());
      }
      else
      {
        QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { new StringBuilder("handleEvent error:no plugin can handle this event(").append(paramLong).append(").") });
        localObject = null;
      }
    }
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(((List)localObject).size() * 64);
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label390;
      }
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)((Iterator)localObject).next();
      if ((localWebViewPlugin != null) && (!localHashMap.containsKey(localWebViewPlugin)))
      {
        long l = System.currentTimeMillis();
        if (localWebViewPlugin.handleEvent(paramString, paramLong, paramMap))
        {
          if (QLog.isColorLevel())
          {
            l = System.currentTimeMillis() - l;
            if (l > 50L)
            {
              localStringBuilder.append("plugin[").append(localWebViewPlugin.getClass().getSimpleName()).append("] handled event[").append(paramLong).append("] success cost ").append(l).append(" ms.");
              QLog.i("WebLog_WebViewPluginEngine", 2, localStringBuilder.toString());
            }
          }
          return true;
          localStringBuilder = new StringBuilder();
          break;
        }
        localHashMap.put(localWebViewPlugin, Boolean.valueOf(true));
        if (QLog.isColorLevel())
        {
          l = System.currentTimeMillis() - l;
          if (l > 50L) {
            localStringBuilder.append("plugin[").append(localWebViewPlugin.getClass().getSimpleName()).append("] handled event[").append(paramLong).append("] cost ").append(l).append(" ms\r\n.");
          }
        }
      }
    }
    label390:
    if ((QLog.isColorLevel()) && (localStringBuilder.length() > 0))
    {
      localStringBuilder.append("handleEvent error: no plugin can handleEvent(").append(paramLong).append(")");
      QLog.i("WebLog_WebViewPluginEngine", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean a(Map<String, Object> paramMap)
  {
    Object localObject1 = (CopyOnWriteArrayList)this.b.get(Long.valueOf(32L));
    if ((localObject1 == null) || (((CopyOnWriteArrayList)localObject1).size() == 0)) {
      return false;
    }
    StringBuilder localStringBuilder;
    HashMap localHashMap;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(((CopyOnWriteArrayList)localObject1).size() * 64);
      localHashMap = new HashMap();
      localObject1 = ((CopyOnWriteArrayList)localObject1).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label295;
      }
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)((Iterator)localObject1).next();
      if ((localWebViewPlugin != null) && (!localHashMap.containsKey(localWebViewPlugin)))
      {
        Object localObject2 = paramMap.get("url");
        if ((localObject2 instanceof String))
        {
          long l1 = System.currentTimeMillis();
          if (localWebViewPlugin.handleEvent((String)localObject2, 32L, paramMap))
          {
            if (QLog.isColorLevel())
            {
              long l2 = System.currentTimeMillis();
              localStringBuilder.append("plugin [").append(localWebViewPlugin.getClass().getSimpleName()).append("] handleBeforeLoad success, cost ").append(l2 - l1).append(" ms.");
              QLog.i("WebLog_WebViewPluginEngine", 2, localStringBuilder.toString());
            }
            return true;
            localStringBuilder = new StringBuilder();
            break;
          }
          localHashMap.put(localWebViewPlugin, Boolean.valueOf(true));
          if (QLog.isColorLevel())
          {
            l1 = System.currentTimeMillis() - l1;
            if (l1 > 50L) {
              localStringBuilder.append("plugin [").append(localWebViewPlugin.getClass().getSimpleName()).append("] handleBeforeLoad, cost ").append(l1).append(" ms.\r\n");
            }
          }
        }
      }
    }
    label295:
    if ((QLog.isColorLevel()) && (localStringBuilder.length() > 0))
    {
      localStringBuilder.append("handleBeforeLoad error:no plugin can handled!");
      QLog.i("WebLog_WebViewPluginEngine", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public void b()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)localIterator.next();
        if ((localWebViewPlugin == null) || (localHashMap.containsKey(localWebViewPlugin))) {
          continue;
        }
        long l = System.currentTimeMillis();
        try
        {
          localWebViewPlugin.onDestroy();
          localHashMap.put(localWebViewPlugin, Boolean.valueOf(true));
          if (QLog.isColorLevel())
          {
            l = System.currentTimeMillis() - l;
            if (l > 50L) {
              QLog.d("WebLog_WebViewPluginEngine", 2, new Object[] { new StringBuilder("plugin[").append(localWebViewPlugin.getClass().getSimpleName()).append("] onDestroy cost ").append(l).append(" ms.") });
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("WebLog_WebViewPluginEngine", 2, QLog.getStackTraceString(localException));
            }
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.b.clear();
    this.c.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewNativeapiINativeApiMangerInjector != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewNativeapiINativeApiMangerInjector.a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewPluginEngine
 * JD-Core Version:    0.7.0.1
 */