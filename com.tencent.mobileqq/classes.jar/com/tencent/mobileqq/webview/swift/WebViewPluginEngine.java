package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasBaseWebviewUtil;
import com.tencent.mobileqq.webview.nativeapi.INativeApiMangerInjector;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("1L << ");
      localStringBuilder.append(i - str.replaceAll("0", "").length());
      return localStringBuilder.toString();
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
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramWebViewPlugin == null) {
        return;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("insertPlugin:namespace ");
        paramWebViewPlugin.append(paramString);
        paramWebViewPlugin.append(" already exists!");
        QLog.e("WebLog_WebViewPluginEngine", 1, paramWebViewPlugin.toString());
        return;
      }
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("insertPlugin:add pair [");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("] -> ");
        ((StringBuilder)localObject1).append(paramWebViewPlugin.getClass().getSimpleName());
        QLog.i("WebLog_WebViewPluginEngine", 2, ((StringBuilder)localObject1).toString());
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramWebViewPlugin);
      long l2 = paramWebViewPlugin.getWebViewEventByNameSpace(paramString);
      Object localObject2;
      if (l2 > 0L)
      {
        l1 = 1L;
        i = 1;
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
          l1 = 1L << i;
          i += 1;
        }
      }
      l2 = paramWebViewPlugin.getWebViewSchemaByNameSpace(paramString);
      long l1 = 1L;
      int i = 1;
      while ((l2 > 0L) && (l2 >= l1))
      {
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
            int j = paramWebViewPlugin.getWebViewSchemaListIndex();
            if ((j >= 0) && (j < paramString.size())) {
              paramString.add(j, paramWebViewPlugin);
            } else {
              paramString.add(paramWebViewPlugin);
            }
          }
        }
        l1 = 1L << i;
        i += 1;
      }
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
      if (!paramBoolean)
      {
        paramList.initRuntime(this.jdField_a_of_type_AndroidAppActivity, paramAppRuntime);
        paramList.onCreate();
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
          paramList.onWebViewCreated(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
        }
      }
      else
      {
        paramList.onCreate();
      }
    }
  }
  
  /* Error */
  private static boolean a(WebViewPlugin paramWebViewPlugin, JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: invokestatic 294	java/lang/System:currentTimeMillis	()J
    //   9: lstore 6
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: aload_3
    //   15: aload 4
    //   17: aload 5
    //   19: invokevirtual 298	com/tencent/mobileqq/webview/swift/WebViewPlugin:handleJsRequest	(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z
    //   22: istore 10
    //   24: iload 10
    //   26: ifeq +108 -> 134
    //   29: invokestatic 294	java/lang/System:currentTimeMillis	()J
    //   32: lstore 8
    //   34: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +294 -> 331
    //   40: new 154	java/lang/StringBuilder
    //   43: dup
    //   44: ldc_w 300
    //   47: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: astore_1
    //   51: aload_1
    //   52: aload_0
    //   53: invokevirtual 225	java/lang/Object:getClass	()Ljava/lang/Class;
    //   56: invokevirtual 230	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   59: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_1
    //   64: ldc_w 305
    //   67: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_1
    //   72: aload_3
    //   73: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_1
    //   78: ldc_w 307
    //   81: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_1
    //   86: aload 4
    //   88: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_1
    //   93: ldc_w 309
    //   96: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_1
    //   101: lload 8
    //   103: lload 6
    //   105: lsub
    //   106: invokevirtual 312	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_1
    //   111: ldc_w 314
    //   114: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: ldc 208
    //   120: iconst_2
    //   121: iconst_1
    //   122: anewarray 4	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload_1
    //   128: aastore
    //   129: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   132: iconst_1
    //   133: ireturn
    //   134: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +190 -> 327
    //   140: invokestatic 294	java/lang/System:currentTimeMillis	()J
    //   143: lstore 8
    //   145: new 154	java/lang/StringBuilder
    //   148: dup
    //   149: ldc_w 300
    //   152: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: astore_1
    //   156: aload_1
    //   157: aload_0
    //   158: invokevirtual 225	java/lang/Object:getClass	()Ljava/lang/Class;
    //   161: invokevirtual 230	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   164: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_1
    //   169: ldc_w 320
    //   172: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_1
    //   177: aload_3
    //   178: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_1
    //   183: ldc_w 307
    //   186: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload_1
    //   191: aload 4
    //   193: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_1
    //   198: ldc_w 309
    //   201: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_1
    //   206: lload 8
    //   208: lload 6
    //   210: lsub
    //   211: invokevirtual 312	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload_1
    //   216: ldc_w 314
    //   219: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: ldc 208
    //   225: iconst_2
    //   226: iconst_1
    //   227: anewarray 4	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: aload_1
    //   233: aastore
    //   234: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   237: iconst_0
    //   238: ireturn
    //   239: astore_0
    //   240: goto +89 -> 329
    //   243: astore_1
    //   244: new 154	java/lang/StringBuilder
    //   247: dup
    //   248: ldc_w 300
    //   251: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   254: astore_2
    //   255: aload_2
    //   256: aload_0
    //   257: invokevirtual 225	java/lang/Object:getClass	()Ljava/lang/Class;
    //   260: invokevirtual 230	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   263: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_2
    //   268: ldc_w 305
    //   271: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload_2
    //   276: aload_3
    //   277: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload_2
    //   282: ldc_w 307
    //   285: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload_2
    //   290: aload 4
    //   292: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_2
    //   297: ldc_w 322
    //   300: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_2
    //   305: aload_1
    //   306: invokevirtual 323	java/lang/Exception:toString	()Ljava/lang/String;
    //   309: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: ldc 208
    //   315: iconst_2
    //   316: iconst_1
    //   317: anewarray 4	java/lang/Object
    //   320: dup
    //   321: iconst_0
    //   322: aload_2
    //   323: aastore
    //   324: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   327: iconst_0
    //   328: ireturn
    //   329: aload_0
    //   330: athrow
    //   331: iconst_1
    //   332: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	paramWebViewPlugin	WebViewPlugin
    //   0	333	1	paramJsBridgeListener	JsBridgeListener
    //   0	333	2	paramString1	String
    //   0	333	3	paramString2	String
    //   0	333	4	paramString3	String
    //   0	333	5	paramArrayOfString	String[]
    //   9	200	6	l1	long
    //   32	175	8	l2	long
    //   22	3	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	24	239	finally
    //   29	132	239	finally
    //   134	237	239	finally
    //   244	327	239	finally
    //   6	24	243	java/lang/Exception
    //   29	132	243	java/lang/Exception
    //   134	237	243	java/lang/Exception
  }
  
  private static boolean a(WebViewPluginEngine paramWebViewPluginEngine, CustomWebView paramCustomWebView, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("/#");
    Object localObject3 = ((StringBuilder)localObject1).toString().split("/");
    if (localObject3.length < 5)
    {
      paramWebViewPluginEngine = new StringBuilder();
      paramWebViewPluginEngine.append("illegal jsbridge:");
      paramWebViewPluginEngine.append(paramString);
      QLog.e("WebLog_WebViewPluginEngine", 1, paramWebViewPluginEngine.toString());
      return true;
    }
    String str3 = localObject3[2];
    int i = localObject3.length;
    String str1 = "";
    long l;
    Object localObject2;
    int j;
    Object localObject4;
    if (i == 5)
    {
      localObject1 = localObject3[3].split("#");
      if (localObject1.length > 1) {
        try
        {
          i = Integer.parseInt(localObject1[1]);
          l = i;
        }
        catch (NumberFormatException paramWebViewPluginEngine)
        {
          paramCustomWebView = new StringBuilder("illegal jsbridge[");
          paramCustomWebView.append(paramString);
          paramCustomWebView.append("] error:");
          paramCustomWebView.append(paramWebViewPluginEngine.toString());
          QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { paramCustomWebView });
          return true;
        }
      } else {
        l = -1L;
      }
      localObject1 = localObject1[0].split("\\?");
      localObject3 = localObject1[0];
      if (localObject1.length > 1)
      {
        localObject2 = localObject1[1].split("&");
        localObject1 = localObject2;
        if (localObject2.length > 0)
        {
          localObject1 = new ArrayList();
          j = localObject2.length;
          i = 0;
          while (i < j)
          {
            int k = localObject2[i].indexOf('=');
            if (k != -1)
            {
              if (!"mqq_tt".equals(localObject2[i].substring(0, k)))
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append(str3);
                ((StringBuilder)localObject4).append(".");
                ((StringBuilder)localObject4).append((String)localObject3);
                localObject4 = ((StringBuilder)localObject4).toString();
                if (jdField_a_of_type_JavaUtilHashSet.contains(localObject4)) {
                  ((List)localObject1).add(localObject2[i].substring(k + 1));
                } else {
                  ((List)localObject1).add(URLDecoder.decode(localObject2[i].substring(k + 1)));
                }
              }
            }
            else {
              ((List)localObject1).add("");
            }
            i += 1;
          }
          localObject1 = (String[])((List)localObject1).toArray(new String[((List)localObject1).size()]);
        }
      }
      else
      {
        localObject1 = new String[0];
      }
      localObject2 = localObject1;
      i = 0;
      localObject1 = localObject3;
    }
    else
    {
      localObject1 = localObject3[3];
    }
    try
    {
      l = Long.parseLong(localObject3[4]);
      i = localObject3.length - 6;
      localObject2 = new String[i];
      System.arraycopy(localObject3, 5, localObject2, 0, i);
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        localObject2[i] = URLDecoder.decode(localObject2[i]);
        i += 1;
      }
      i = 1;
      localJsBridgeListener = new JsBridgeListener(paramCustomWebView, l, paramString);
      paramCustomWebView = paramCustomWebView.getUrl();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(str3);
      ((StringBuilder)localObject3).append(".");
      ((StringBuilder)localObject3).append((String)localObject1);
      str2 = ((StringBuilder)localObject3).toString();
      boolean bool = paramWebViewPluginEngine.a().a(paramCustomWebView, str2);
      localObject3 = null;
      localObject4 = null;
      Object localObject5 = null;
      if (bool)
      {
        localObject4 = paramWebViewPluginEngine.a(str3);
        if (localObject4 == null) {
          paramWebViewPluginEngine = paramWebViewPluginEngine.b(str3);
        } else {
          paramWebViewPluginEngine = (WebViewPluginEngine)localObject4;
        }
        if (paramWebViewPluginEngine != null)
        {
          a(paramWebViewPluginEngine, localJsBridgeListener, paramString, str3, (String)localObject1, (String[])localObject2);
          if (SwiftBrowserStatistics.v)
          {
            if (paramCustomWebView == null) {
              paramWebViewPluginEngine = localObject5;
            } else {
              paramWebViewPluginEngine = Uri.parse(paramCustomWebView);
            }
            if (paramWebViewPluginEngine == null) {
              paramCustomWebView = "";
            } else {
              paramCustomWebView = paramWebViewPluginEngine.getHost();
            }
            if (paramWebViewPluginEngine != null) {
              str1 = paramWebViewPluginEngine.getPath();
            }
            ReportController.b(null, "dc00899", "WV_Analysis", "", "jsapi_call", "total", 0, 0, paramCustomWebView, str1, str2, "");
          }
          return true;
        }
        if (i == 0) {
          if ((localObject2.length <= 0) || (!localObject2[0].startsWith("{"))) {}
        }
      }
    }
    catch (Exception paramWebViewPluginEngine)
    {
      JsBridgeListener localJsBridgeListener;
      String str2;
      label778:
      paramCustomWebView = new StringBuilder("illegal jsbridge[");
      paramCustomWebView.append(paramString);
      paramCustomWebView.append("] error:");
      paramCustomWebView.append(paramWebViewPluginEngine.toString());
      QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { paramCustomWebView });
      return true;
    }
    try
    {
      paramWebViewPluginEngine = new JSONObject(localObject2[0]).optString("callback");
    }
    catch (JSONException paramWebViewPluginEngine)
    {
      break label778;
    }
    paramWebViewPluginEngine = null;
    paramString = paramWebViewPluginEngine;
    if (TextUtils.isEmpty(paramWebViewPluginEngine))
    {
      paramString = paramWebViewPluginEngine;
      if (l != -1L) {
        paramString = Long.toString(l);
      }
    }
    TextUtils.isEmpty(paramString);
    if (SwiftBrowserStatistics.v)
    {
      if (paramCustomWebView == null) {
        paramWebViewPluginEngine = (WebViewPluginEngine)localObject3;
      } else {
        paramWebViewPluginEngine = Uri.parse(paramCustomWebView);
      }
      if (paramWebViewPluginEngine == null) {
        paramCustomWebView = "";
      } else {
        paramCustomWebView = paramWebViewPluginEngine.getHost();
      }
      if (paramWebViewPluginEngine != null) {
        str1 = paramWebViewPluginEngine.getPath();
      }
      ReportController.b(null, "dc00899", "WV_Analysis", "", "jsapi_call", "total", 2, 0, paramCustomWebView, str1, str2, "");
      break label1153;
      localJsBridgeListener.a();
      if (!TextUtils.isEmpty(paramCustomWebView))
      {
        if (paramCustomWebView.contains("?")) {
          paramString = paramCustomWebView.substring(0, paramCustomWebView.indexOf("?"));
        } else {
          paramString = paramCustomWebView;
        }
        i = (int)paramWebViewPluginEngine.a().a();
        j = QbSdk.getTbsVersion(BaseApplication.getContext());
        paramWebViewPluginEngine = new StringBuilder();
        paramWebViewPluginEngine.append(DeviceInfoUtil.h());
        paramWebViewPluginEngine.append(" ");
        paramWebViewPluginEngine.append(DeviceInfoUtil.i());
        paramWebViewPluginEngine = paramWebViewPluginEngine.toString();
        VasBaseWebviewUtil.reportVasStatus("JsApiRights", str3, (String)localObject1, 3, 0, j, i, paramString, paramWebViewPluginEngine);
        if (!paramString.startsWith("http"))
        {
          paramString = new StringBuilder();
          paramString.append("no plugin have right handle  ");
          paramString.append(str2);
          paramString.append(", x5 version = ");
          paramString.append(j);
          paramString.append(", phone is ");
          paramString.append(paramWebViewPluginEngine);
          QLog.d("WebLog_WebViewPluginEngine", 1, paramString.toString());
        }
      }
      if (SwiftBrowserStatistics.v)
      {
        if (paramCustomWebView == null) {
          paramCustomWebView = (CustomWebView)localObject4;
        } else {
          paramCustomWebView = Uri.parse(paramCustomWebView);
        }
        if (paramCustomWebView == null) {
          paramWebViewPluginEngine = "";
        } else {
          paramWebViewPluginEngine = paramCustomWebView.getHost();
        }
        if (paramCustomWebView == null) {
          paramCustomWebView = "";
        } else {
          paramCustomWebView = paramCustomWebView.getPath();
        }
        ReportController.b(null, "dc00899", "WV_Analysis", "", "jsapi_call", "total", 1, 0, paramWebViewPluginEngine, paramCustomWebView, str2, "");
      }
    }
    label1153:
    return true;
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
    if (paramCustomWebView == null)
    {
      QLog.e("WebLog_WebViewPluginEngine", 1, "registerJSInterface webView is null");
      return;
    }
    if (Build.VERSION.SDK_INT < 17)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewPluginEngine", 1, "registerJSInterface SDK is lower than 4.2");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine$WebViewJSInterfaceImpl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewPluginEngine", 2, "registerJSInterface");
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine$WebViewJSInterfaceImpl = new WebViewPluginEngine.WebViewJSInterfaceImpl(this);
      paramCustomWebView.addJavascriptInterface(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine$WebViewJSInterfaceImpl, "_mqqWebViewJSInterface");
    }
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
  
  private static boolean b(WebViewPluginEngine paramWebViewPluginEngine, CustomWebView paramCustomWebView, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean b(String paramString)
  {
    String str1 = SwiftWebViewUtils.b(paramString);
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
        if (QLog.isColorLevel()) {
          localObject1 = new StringBuilder(((CopyOnWriteArrayList)localObject2).size() * 64);
        } else {
          localObject1 = new StringBuilder();
        }
        localObject2 = ((CopyOnWriteArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          WebViewPlugin localWebViewPlugin = (WebViewPlugin)((Iterator)localObject2).next();
          long l1 = System.currentTimeMillis();
          if (localWebViewPlugin != null)
          {
            if (localWebViewPlugin.handleSchemaRequest(paramString, str1))
            {
              if (QLog.isColorLevel())
              {
                long l2 = System.currentTimeMillis();
                ((StringBuilder)localObject1).append("plugin[");
                ((StringBuilder)localObject1).append(localWebViewPlugin.getClass().getSimpleName());
                ((StringBuilder)localObject1).append("] handle scheme[");
                ((StringBuilder)localObject1).append(str1);
                ((StringBuilder)localObject1).append("] success cost ");
                ((StringBuilder)localObject1).append(l2 - l1);
                ((StringBuilder)localObject1).append(" ms.");
                QLog.i("WebLog_WebViewPluginEngine", 2, ((StringBuilder)localObject1).toString());
              }
              SwiftBrowserStatistics.a(paramString, str2, 0);
              return true;
            }
            if (QLog.isColorLevel())
            {
              l1 = System.currentTimeMillis() - l1;
              if (l1 > 50L)
              {
                ((StringBuilder)localObject1).append("plugin[");
                ((StringBuilder)localObject1).append(localWebViewPlugin.getClass().getSimpleName());
                ((StringBuilder)localObject1).append("] handle scheme[");
                ((StringBuilder)localObject1).append(str1);
                ((StringBuilder)localObject1).append("] cost ");
                ((StringBuilder)localObject1).append(l1);
                ((StringBuilder)localObject1).append(" ms.");
              }
            }
          }
        }
        if ((QLog.isColorLevel()) && (((StringBuilder)localObject1).length() > 0))
        {
          ((StringBuilder)localObject1).append("overrideUrlRequest error:no plugin can handle this scheme[");
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append("].");
          QLog.i("WebLog_WebViewPluginEngine", 2, ((StringBuilder)localObject1).toString());
        }
        SwiftBrowserStatistics.a(paramString, str2, 1);
      }
      return false;
    }
    localObject1 = new StringBuilder("overrideUrlRequest error:no plugin can handle this scheme[");
    ((StringBuilder)localObject1).append(str1);
    ((StringBuilder)localObject1).append("].");
    QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { localObject1 });
    SwiftBrowserStatistics.a(paramString, str2, 2);
    return false;
  }
  
  private void c()
  {
    try
    {
      if ((WebViewEngineInjectorUtil.a != null) && (WebViewEngineInjectorUtil.a.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewNativeapiINativeApiMangerInjector = ((INativeApiMangerInjector)((Class)WebViewEngineInjectorUtil.a.get(0)).newInstance());
        return;
      }
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
    Iterator localIterator1 = WebViewPluginFactory.b.entrySet().iterator();
    Object localObject1 = null;
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      if (((Integer)localEntry.getValue()).intValue() == paramInt)
      {
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        localObject2 = localObject1;
        for (;;)
        {
          localObject1 = localObject2;
          if (!localIterator2.hasNext()) {
            break;
          }
          localObject1 = (WebViewPlugin)localIterator2.next();
          if (localObject1.getClass() == localEntry.getKey()) {
            localObject2 = localObject1;
          }
        }
      }
    }
    Object localObject2 = localObject1;
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
    Object localObject2 = (List)this.b.get(Long.valueOf(paramLong));
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = a(paramLong);
    }
    else if (paramLong > 8589934592L)
    {
      localObject2 = new CopyOnWriteArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values());
      localObject1 = String.valueOf(paramLong - 8589934592L);
    }
    else
    {
      localObject1 = new StringBuilder("handleEvent error:no plugin can handle this event(");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(").");
      QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { localObject1 });
      localObject1 = "";
    }
    if ((localObject2 != null) && (((List)localObject2).size() != 0))
    {
      HashMap localHashMap = new HashMap();
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel()) {
        localStringBuilder = new StringBuilder(((List)localObject2).size() * 64);
      } else {
        localStringBuilder = new StringBuilder();
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)((Iterator)localObject2).next();
        if (localWebViewPlugin != null) {
          if (!localHashMap.containsKey(localWebViewPlugin))
          {
            long l1 = System.currentTimeMillis();
            Object localObject3 = localWebViewPlugin.handleEvent(paramString, paramLong);
            if (localObject3 != null)
            {
              if (QLog.isColorLevel())
              {
                long l2 = System.currentTimeMillis();
                localStringBuilder.append("plugin[");
                localStringBuilder.append(localWebViewPlugin.getClass().getSimpleName());
                localStringBuilder.append("] handled event[");
                localStringBuilder.append(paramLong);
                localStringBuilder.append("] success cost ");
                localStringBuilder.append(l2 - l1);
                localStringBuilder.append(" ms.");
                QLog.i("WebLog_WebViewPluginEngine", 2, localStringBuilder.toString());
              }
              return localObject3;
            }
            localHashMap.put(localWebViewPlugin, Boolean.valueOf(true));
            if (QLog.isColorLevel())
            {
              l1 = System.currentTimeMillis() - l1;
              if (l1 > 50L)
              {
                localStringBuilder.append("plugin[");
                localStringBuilder.append(localWebViewPlugin.getClass().getSimpleName());
                localStringBuilder.append("] handled event[");
                localStringBuilder.append(paramLong);
                localStringBuilder.append("] cost ");
                localStringBuilder.append(l1);
                localStringBuilder.append(" ms\r\n.");
              }
            }
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder.length() > 0))
      {
        localStringBuilder.append("handleEvent error:no plugin can handleEvent (");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(")");
        QLog.i("WebLog_WebViewPluginEngine", 2, localStringBuilder.toString());
      }
      return null;
    }
    return null;
  }
  
  public String a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if ((localObject != null) && (((ConcurrentHashMap)localObject).size() != 0))
    {
      localObject = new StringBuilder(1024);
      ((StringBuilder)localObject).append("plugin list:\n");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        ((StringBuilder)localObject).append(((WebViewPlugin)localIterator.next()).getClass().getSimpleName());
        ((StringBuilder)localObject).append("\n");
      }
      return ((StringBuilder)localObject).toString();
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewPluginEngine", 2, "-->plugin list is empty.");
    }
    return "no plugins";
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity;
    if (localObject1 != null)
    {
      Intent localIntent = ((Activity)localObject1).getIntent();
      Object localObject2 = localIntent.getStringExtra("url");
      String str = "";
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = localIntent.getStringExtra("key_params_qq");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      int i = ((String)localObject1).indexOf(":");
      if (i > 0) {
        str = ((String)localObject1).substring(0, i);
      }
      localObject2 = WebViewPluginFactory.b.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (Class)((Iterator)localObject2).next();
        if (IPreCreatePluginChecker.class.isAssignableFrom((Class)localObject3)) {
          try
          {
            localObject3 = (WebViewPlugin)((Class)localObject3).newInstance();
            if (((IPreCreatePluginChecker)localObject3).isNeedPreCreatePlugin(localIntent, (String)localObject1, str))
            {
              a((WebViewPlugin)localObject3);
              b((WebViewPlugin)localObject3);
            }
          }
          catch (Throwable localThrowable)
          {
            QLog.d("WebLog_WebViewPluginEngine", 1, "preCreatePlugin failed", localThrowable);
          }
        }
      }
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
    if (paramWebUiBaseInterface == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)localIterator.next();
      if (localWebViewPlugin != null) {
        localWebViewPlugin.setWebUiInterface(paramWebUiBaseInterface);
      }
    }
  }
  
  public void a(WebViewProvider paramWebViewProvider)
  {
    if (paramWebViewProvider == null) {
      return;
    }
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
    }
    else
    {
      str = paramString;
      if (paramString.startsWith("http://jsbridge/")) {
        str = paramString.replace("http://jsbridge/", "jsbridge://");
      }
    }
    if (QLog.isColorLevel()) {
      if ((str.startsWith("jsbridge://")) && (str.length() > 512))
      {
        paramString = new StringBuilder("handleJsInterfaceRequest:");
        paramString.append(str.substring(0, 512));
        QLog.i("WebLog_WebViewPluginEngine", 2, paramString.toString());
      }
      else
      {
        paramString = new StringBuilder("handleJsInterfaceRequest:");
        paramString.append(str);
        QLog.i("WebLog_WebViewPluginEngine", 2, paramString.toString());
      }
    }
    if (!str.startsWith("jsbridge:"))
    {
      QLog.e("WebLog_WebViewPluginEngine", 1, "handleJsInterfaceRequest requestUrl is not startsWith jsbridge");
      return;
    }
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
    if ((paramActivity != null) && (paramActivity.getIntent() != null))
    {
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
      return;
    }
    QLog.i("WebLog_WebViewPluginEngine", 1, "onRuntimeReady params activity is empty");
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
    return b(paramString);
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
    if (this.b.containsKey(Long.valueOf(paramLong)))
    {
      localObject = (List)this.b.get(Long.valueOf(paramLong));
    }
    else if (paramLong > 8589934592L)
    {
      localObject = new CopyOnWriteArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values());
    }
    else
    {
      localObject = new StringBuilder("handleEvent error:no plugin can handle this event(");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(").");
      QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { localObject });
      localObject = null;
    }
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      HashMap localHashMap = new HashMap();
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel()) {
        localStringBuilder = new StringBuilder(((List)localObject).size() * 64);
      } else {
        localStringBuilder = new StringBuilder();
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)((Iterator)localObject).next();
        if (localWebViewPlugin != null) {
          if (!localHashMap.containsKey(localWebViewPlugin))
          {
            long l = System.currentTimeMillis();
            if (localWebViewPlugin.handleEvent(paramString, paramLong, paramMap))
            {
              if (QLog.isColorLevel())
              {
                l = System.currentTimeMillis() - l;
                if (l > 50L)
                {
                  localStringBuilder.append("plugin[");
                  localStringBuilder.append(localWebViewPlugin.getClass().getSimpleName());
                  localStringBuilder.append("] handled event[");
                  localStringBuilder.append(paramLong);
                  localStringBuilder.append("] success cost ");
                  localStringBuilder.append(l);
                  localStringBuilder.append(" ms.");
                  QLog.i("WebLog_WebViewPluginEngine", 2, localStringBuilder.toString());
                }
              }
              return true;
            }
            localHashMap.put(localWebViewPlugin, Boolean.valueOf(true));
            if (QLog.isColorLevel())
            {
              l = System.currentTimeMillis() - l;
              if (l > 50L)
              {
                localStringBuilder.append("plugin[");
                localStringBuilder.append(localWebViewPlugin.getClass().getSimpleName());
                localStringBuilder.append("] handled event[");
                localStringBuilder.append(paramLong);
                localStringBuilder.append("] cost ");
                localStringBuilder.append(l);
                localStringBuilder.append(" ms\r\n.");
              }
            }
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder.length() > 0))
      {
        localStringBuilder.append("handleEvent error: no plugin can handleEvent(");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(")");
        QLog.i("WebLog_WebViewPluginEngine", 2, localStringBuilder.toString());
      }
      return false;
    }
    return false;
  }
  
  public boolean a(Map<String, Object> paramMap)
  {
    Object localObject1 = (CopyOnWriteArrayList)this.b.get(Long.valueOf(32L));
    if (localObject1 != null)
    {
      if (((CopyOnWriteArrayList)localObject1).size() == 0) {
        return false;
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel()) {
        localStringBuilder = new StringBuilder(((CopyOnWriteArrayList)localObject1).size() * 64);
      } else {
        localStringBuilder = new StringBuilder();
      }
      HashMap localHashMap = new HashMap();
      localObject1 = ((CopyOnWriteArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
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
                localStringBuilder.append("plugin [");
                localStringBuilder.append(localWebViewPlugin.getClass().getSimpleName());
                localStringBuilder.append("] handleBeforeLoad success, cost ");
                localStringBuilder.append(l2 - l1);
                localStringBuilder.append(" ms.");
                QLog.i("WebLog_WebViewPluginEngine", 2, localStringBuilder.toString());
              }
              return true;
            }
            localHashMap.put(localWebViewPlugin, Boolean.valueOf(true));
            if (QLog.isColorLevel())
            {
              l1 = System.currentTimeMillis() - l1;
              if (l1 > 50L)
              {
                localStringBuilder.append("plugin [");
                localStringBuilder.append(localWebViewPlugin.getClass().getSimpleName());
                localStringBuilder.append("] handleBeforeLoad, cost ");
                localStringBuilder.append(l1);
                localStringBuilder.append(" ms.\r\n");
              }
            }
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder.length() > 0))
      {
        localStringBuilder.append("handleBeforeLoad error:no plugin can handled!");
        QLog.i("WebLog_WebViewPluginEngine", 2, localStringBuilder.toString());
      }
    }
    return false;
  }
  
  public void b()
  {
    Object localObject = new HashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)localIterator.next();
      if ((localWebViewPlugin != null) && (!((HashMap)localObject).containsKey(localWebViewPlugin)))
      {
        long l = System.currentTimeMillis();
        try
        {
          localWebViewPlugin.onDestroy();
          ((HashMap)localObject).put(localWebViewPlugin, Boolean.valueOf(true));
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewPluginEngine", 2, QLog.getStackTraceString(localException));
          }
        }
        if (QLog.isColorLevel())
        {
          l = System.currentTimeMillis() - l;
          if (l > 50L)
          {
            StringBuilder localStringBuilder = new StringBuilder("plugin[");
            localStringBuilder.append(localWebViewPlugin.getClass().getSimpleName());
            localStringBuilder.append("] onDestroy cost ");
            localStringBuilder.append(l);
            localStringBuilder.append(" ms.");
            QLog.d("WebLog_WebViewPluginEngine", 2, new Object[] { localStringBuilder });
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.b.clear();
    this.c.clear();
    localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewNativeapiINativeApiMangerInjector;
    if (localObject != null) {
      ((INativeApiMangerInjector)localObject).a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewPluginEngine
 * JD-Core Version:    0.7.0.1
 */