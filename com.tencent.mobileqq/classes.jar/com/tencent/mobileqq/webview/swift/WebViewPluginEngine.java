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
  protected static final HashMap<String, String> d = new HashMap();
  protected static final HashSet<String> e = new HashSet();
  public static WebViewPluginEngine f = null;
  private static int n = -1;
  public Activity a;
  public AppRuntime b;
  public WebViewProvider c;
  private final ConcurrentHashMap<String, WebViewPlugin> g = new ConcurrentHashMap();
  private final HashMap<Long, CopyOnWriteArrayList<WebViewPlugin>> h = new HashMap();
  private final HashMap<String, CopyOnWriteArrayList<WebViewPlugin>> i = new HashMap();
  private volatile CustomWebView j;
  private AuthorizeConfig k;
  private WebViewPluginEngine.WebViewJSInterfaceImpl l;
  private INativeApiMangerInjector m;
  
  static
  {
    d.put("auth.init", "Troop.init");
    d.put("device.getNetworkInfo", "qbizApi.getNetworkInfo");
    d.put("data.setShareInfo", "QQApi.setShareInfo");
    d.put("event.dispatchEvent", "event.dispatchEvent");
    d.put("media.showPicture", "troopNotice.showPicture");
    d.put("ui.popBack", "publicAccount.close");
    d.put("ui.shareMessage", "QQApi.shareMsg");
    e.add("gflive.addBarrageList");
  }
  
  public WebViewPluginEngine(CustomWebView paramCustomWebView, Activity paramActivity, AppRuntime paramAppRuntime, CommonJsPluginFactory paramCommonJsPluginFactory)
  {
    this.j = paramCustomWebView;
    this.a = paramActivity;
    this.b = paramAppRuntime;
    f();
    a(false, paramAppRuntime, paramCommonJsPluginFactory, null);
    b();
    a(paramAppRuntime, paramActivity);
  }
  
  public WebViewPluginEngine(CustomWebView paramCustomWebView, Activity paramActivity, AppRuntime paramAppRuntime, CommonJsPluginFactory paramCommonJsPluginFactory, List<WebViewPlugin> paramList)
  {
    this.j = paramCustomWebView;
    this.a = paramActivity;
    this.b = paramAppRuntime;
    f();
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
    this.b = paramAppRuntime;
    f();
    a(true, paramAppRuntime, paramCommonJsPluginFactory, paramList);
  }
  
  private String a(long paramLong)
  {
    String str = Long.toBinaryString(paramLong);
    if (!TextUtils.isEmpty(str))
    {
      int i1 = str.length();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("1L << ");
      localStringBuilder.append(i1 - str.replaceAll("0", "").length());
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private void a(WebViewPlugin paramWebViewPlugin)
  {
    if (paramWebViewPlugin != null)
    {
      paramWebViewPlugin.initRuntime(this.a, this.b);
      paramWebViewPlugin.mRuntime.a(this.c);
      paramWebViewPlugin.onCreate();
      if (this.j != null) {
        paramWebViewPlugin.onWebViewCreated(this.j);
      }
    }
  }
  
  private static void a(WebViewPluginEngine paramWebViewPluginEngine, String paramString1, String paramString2, JsBridgeListener paramJsBridgeListener, String paramString3, String paramString4)
  {
    paramJsBridgeListener.a();
    if (!TextUtils.isEmpty(paramString3))
    {
      if (paramString3.contains("?")) {
        paramJsBridgeListener = paramString3.substring(0, paramString3.indexOf("?"));
      } else {
        paramJsBridgeListener = paramString3;
      }
      int i1 = (int)paramWebViewPluginEngine.c().b();
      int i2 = QbSdk.getTbsVersion(BaseApplication.getContext());
      paramWebViewPluginEngine = new StringBuilder();
      paramWebViewPluginEngine.append(DeviceInfoUtil.t());
      paramWebViewPluginEngine.append(" ");
      paramWebViewPluginEngine.append(DeviceInfoUtil.u());
      paramWebViewPluginEngine = paramWebViewPluginEngine.toString();
      VasBaseWebviewUtil.reportVasStatus("JsApiRights", paramString1, paramString2, 3, 0, i2, i1, paramJsBridgeListener, paramWebViewPluginEngine);
      if (!paramJsBridgeListener.startsWith("http"))
      {
        paramString1 = new StringBuilder();
        paramString1.append("no plugin have right handle  ");
        paramString1.append(paramString4);
        paramString1.append(", x5 version = ");
        paramString1.append(i2);
        paramString1.append(", phone is ");
        paramString1.append(paramWebViewPluginEngine);
        QLog.d("WebLog_WebViewPluginEngine", 1, paramString1.toString());
      }
    }
    if (SwiftBrowserStatistics.aM)
    {
      if (paramString3 == null) {
        paramString1 = null;
      } else {
        paramString1 = Uri.parse(paramString3);
      }
      if (paramString1 == null) {
        paramWebViewPluginEngine = "";
      } else {
        paramWebViewPluginEngine = paramString1.getHost();
      }
      if (paramString1 == null) {
        paramString1 = "";
      } else {
        paramString1 = paramString1.getPath();
      }
      ReportController.b(null, "dc00899", "WV_Analysis", "", "jsapi_call", "total", 1, 0, paramWebViewPluginEngine, paramString1, paramString4, "");
    }
  }
  
  private void a(String paramString, WebViewPlugin paramWebViewPlugin)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramWebViewPlugin == null) {
        return;
      }
      if (this.g.containsKey(paramString))
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
      this.g.put(paramString, paramWebViewPlugin);
      long l2 = paramWebViewPlugin.getWebViewEventByNameSpace(paramString);
      Object localObject2;
      if (l2 > 0L)
      {
        l1 = 1L;
        i1 = 1;
        while (l2 >= l1)
        {
          if ((l2 & l1) != 0L)
          {
            localObject2 = (CopyOnWriteArrayList)this.h.get(Long.valueOf(l1));
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new CopyOnWriteArrayList();
              this.h.put(Long.valueOf(l1), localObject1);
            }
            ((CopyOnWriteArrayList)localObject1).add(paramWebViewPlugin);
          }
          l1 = 1L << i1;
          i1 += 1;
        }
      }
      l2 = paramWebViewPlugin.getWebViewSchemaByNameSpace(paramString);
      long l1 = 1L;
      int i1 = 1;
      while ((l2 > 0L) && (l2 >= l1))
      {
        if ((l2 & l1) != 0L)
        {
          localObject2 = WebViewPluginSchemeConfig.a(l1);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = (CopyOnWriteArrayList)this.i.get(localObject2);
            paramString = (String)localObject1;
            if (localObject1 == null)
            {
              paramString = new CopyOnWriteArrayList();
              this.i.put(localObject2, paramString);
            }
            int i2 = paramWebViewPlugin.getWebViewSchemaListIndex();
            if ((i2 >= 0) && (i2 < paramString.size())) {
              paramString.add(i2, paramWebViewPlugin);
            } else {
              paramString.add(paramWebViewPlugin);
            }
          }
        }
        l1 = 1L << i1;
        i1 += 1;
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
    paramCommonJsPluginFactory = this.g.values().iterator();
    while (paramCommonJsPluginFactory.hasNext())
    {
      paramList = (WebViewPlugin)paramCommonJsPluginFactory.next();
      paramList.onAppRuntimeReady(paramAppRuntime);
      if (!paramBoolean)
      {
        paramList.initRuntime(this.a, paramAppRuntime);
        paramList.onCreate();
        if (this.j != null) {
          paramList.onWebViewCreated(this.j);
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
    //   6: invokestatic 403	java/lang/System:currentTimeMillis	()J
    //   9: lstore 6
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: aload_3
    //   15: aload 4
    //   17: aload 5
    //   19: invokevirtual 407	com/tencent/mobileqq/webview/swift/WebViewPlugin:handleJsRequest	(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z
    //   22: istore 10
    //   24: iload 10
    //   26: ifeq +109 -> 135
    //   29: invokestatic 403	java/lang/System:currentTimeMillis	()J
    //   32: lstore 8
    //   34: invokestatic 328	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +297 -> 334
    //   40: new 165	java/lang/StringBuilder
    //   43: dup
    //   44: ldc_w 409
    //   47: invokespecial 412	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: astore_1
    //   51: aload_1
    //   52: aload_0
    //   53: invokevirtual 336	java/lang/Object:getClass	()Ljava/lang/Class;
    //   56: invokevirtual 341	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   59: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_1
    //   64: ldc_w 414
    //   67: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_1
    //   72: aload_3
    //   73: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_1
    //   78: ldc_w 416
    //   81: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_1
    //   86: aload 4
    //   88: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_1
    //   93: ldc_w 418
    //   96: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_1
    //   101: lload 8
    //   103: lload 6
    //   105: lsub
    //   106: invokevirtual 421	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_1
    //   111: ldc_w 423
    //   114: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: ldc_w 279
    //   121: iconst_2
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload_1
    //   129: aastore
    //   130: invokestatic 426	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   133: iconst_1
    //   134: ireturn
    //   135: invokestatic 328	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +192 -> 330
    //   141: invokestatic 403	java/lang/System:currentTimeMillis	()J
    //   144: lstore 8
    //   146: new 165	java/lang/StringBuilder
    //   149: dup
    //   150: ldc_w 409
    //   153: invokespecial 412	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   156: astore_1
    //   157: aload_1
    //   158: aload_0
    //   159: invokevirtual 336	java/lang/Object:getClass	()Ljava/lang/Class;
    //   162: invokevirtual 341	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   165: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_1
    //   170: ldc_w 428
    //   173: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_1
    //   178: aload_3
    //   179: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_1
    //   184: ldc_w 416
    //   187: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: aload 4
    //   194: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_1
    //   199: ldc_w 418
    //   202: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_1
    //   207: lload 8
    //   209: lload 6
    //   211: lsub
    //   212: invokevirtual 421	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_1
    //   217: ldc_w 423
    //   220: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: ldc_w 279
    //   227: iconst_2
    //   228: iconst_1
    //   229: anewarray 4	java/lang/Object
    //   232: dup
    //   233: iconst_0
    //   234: aload_1
    //   235: aastore
    //   236: invokestatic 426	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   239: iconst_0
    //   240: ireturn
    //   241: astore_0
    //   242: goto +90 -> 332
    //   245: astore_1
    //   246: new 165	java/lang/StringBuilder
    //   249: dup
    //   250: ldc_w 409
    //   253: invokespecial 412	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   256: astore_2
    //   257: aload_2
    //   258: aload_0
    //   259: invokevirtual 336	java/lang/Object:getClass	()Ljava/lang/Class;
    //   262: invokevirtual 341	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   265: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_2
    //   270: ldc_w 414
    //   273: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload_2
    //   278: aload_3
    //   279: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload_2
    //   284: ldc_w 416
    //   287: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_2
    //   292: aload 4
    //   294: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload_2
    //   299: ldc_w 430
    //   302: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload_2
    //   307: aload_1
    //   308: invokevirtual 431	java/lang/Exception:toString	()Ljava/lang/String;
    //   311: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: ldc_w 279
    //   318: iconst_2
    //   319: iconst_1
    //   320: anewarray 4	java/lang/Object
    //   323: dup
    //   324: iconst_0
    //   325: aload_2
    //   326: aastore
    //   327: invokestatic 433	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   330: iconst_0
    //   331: ireturn
    //   332: aload_0
    //   333: athrow
    //   334: iconst_1
    //   335: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	paramWebViewPlugin	WebViewPlugin
    //   0	336	1	paramJsBridgeListener	JsBridgeListener
    //   0	336	2	paramString1	String
    //   0	336	3	paramString2	String
    //   0	336	4	paramString3	String
    //   0	336	5	paramArrayOfString	String[]
    //   9	201	6	l1	long
    //   32	176	8	l2	long
    //   22	3	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	24	241	finally
    //   29	133	241	finally
    //   135	239	241	finally
    //   246	330	241	finally
    //   6	24	245	java/lang/Exception
    //   29	133	245	java/lang/Exception
    //   135	239	245	java/lang/Exception
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
    String str = localObject3[2];
    long l1 = -1L;
    int i2 = localObject3.length;
    int i1 = 0;
    boolean bool = false;
    Object localObject2;
    if (i2 == 5)
    {
      localObject1 = localObject3[3].split("#");
      if (localObject1.length > 1) {
        try
        {
          i1 = Integer.parseInt(localObject1[1]);
          l1 = i1;
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
          i2 = localObject2.length;
          i1 = 0;
          while (i1 < i2)
          {
            int i3 = localObject2[i1].indexOf('=');
            if (i3 != -1)
            {
              if (!"mqq_tt".equals(localObject2[i1].substring(0, i3)))
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append(str);
                ((StringBuilder)localObject4).append(".");
                ((StringBuilder)localObject4).append((String)localObject3);
                localObject4 = ((StringBuilder)localObject4).toString();
                if (e.contains(localObject4)) {
                  ((List)localObject1).add(localObject2[i1].substring(i3 + 1));
                } else {
                  ((List)localObject1).add(URLDecoder.decode(localObject2[i1].substring(i3 + 1)));
                }
              }
            }
            else {
              ((List)localObject1).add("");
            }
            i1 += 1;
          }
          localObject1 = (String[])((List)localObject1).toArray(new String[((List)localObject1).size()]);
        }
      }
      else
      {
        localObject1 = new String[0];
      }
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      break label532;
      localObject1 = localObject3[3];
      try
      {
        l1 = Long.parseLong(localObject3[4]);
        i2 = localObject3.length - 6;
        localObject2 = new String[i2];
        System.arraycopy(localObject3, 5, localObject2, 0, i2);
        i2 = localObject2.length;
        while (i1 < i2)
        {
          localObject2[i1] = URLDecoder.decode(localObject2[i1]);
          i1 += 1;
        }
        bool = true;
      }
      catch (Exception paramWebViewPluginEngine)
      {
        label532:
        Object localObject5;
        paramCustomWebView = new StringBuilder("illegal jsbridge[");
        paramCustomWebView.append(paramString);
        paramCustomWebView.append("] error:");
        paramCustomWebView.append(paramWebViewPluginEngine.toString());
        QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { paramCustomWebView });
      }
    }
    localObject3 = new JsBridgeListener(paramCustomWebView, l1, paramString);
    Object localObject4 = paramCustomWebView.getUrl();
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append(str);
    ((StringBuilder)localObject5).append(".");
    ((StringBuilder)localObject5).append((String)localObject1);
    localObject5 = ((StringBuilder)localObject5).toString();
    if (paramWebViewPluginEngine.c().a((String)localObject4, (String)localObject5))
    {
      if (a(paramWebViewPluginEngine, paramCustomWebView, paramString, (String[])localObject2, str, (String)localObject1, bool, l1, (JsBridgeListener)localObject3, (String)localObject4, (String)localObject5)) {
        return true;
      }
    }
    else {
      a(paramWebViewPluginEngine, str, (String)localObject1, (JsBridgeListener)localObject3, (String)localObject4, (String)localObject5);
    }
    return true;
    return true;
  }
  
  private static boolean a(WebViewPluginEngine paramWebViewPluginEngine, CustomWebView paramCustomWebView, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, boolean paramBoolean, long paramLong, JsBridgeListener paramJsBridgeListener, String paramString4, String paramString5)
  {
    paramCustomWebView = paramWebViewPluginEngine.b(paramString2);
    if (paramCustomWebView == null) {
      paramWebViewPluginEngine = paramWebViewPluginEngine.d(paramString2);
    } else {
      paramWebViewPluginEngine = paramCustomWebView;
    }
    Object localObject1 = null;
    Object localObject2 = null;
    paramCustomWebView = "";
    if (paramWebViewPluginEngine != null)
    {
      a(paramWebViewPluginEngine, paramJsBridgeListener, paramString1, paramString2, paramString3, paramArrayOfString);
      if (SwiftBrowserStatistics.aM)
      {
        if (paramString4 == null) {
          paramWebViewPluginEngine = localObject2;
        } else {
          paramWebViewPluginEngine = Uri.parse(paramString4);
        }
        if (paramWebViewPluginEngine == null) {
          paramString1 = "";
        } else {
          paramString1 = paramWebViewPluginEngine.getHost();
        }
        if (paramWebViewPluginEngine != null) {
          paramCustomWebView = paramWebViewPluginEngine.getPath();
        }
        ReportController.b(null, "dc00899", "WV_Analysis", "", "jsapi_call", "total", 0, 0, paramString1, paramCustomWebView, paramString5, "");
      }
      return true;
    }
    if ((paramBoolean) || ((paramArrayOfString.length > 0) && (paramArrayOfString[0].startsWith("{")))) {}
    try
    {
      paramWebViewPluginEngine = new JSONObject(paramArrayOfString[0]).optString("callback");
    }
    catch (JSONException paramWebViewPluginEngine)
    {
      label172:
      break label172;
    }
    paramWebViewPluginEngine = null;
    paramString1 = paramWebViewPluginEngine;
    if (TextUtils.isEmpty(paramWebViewPluginEngine))
    {
      paramString1 = paramWebViewPluginEngine;
      if (paramLong != -1L) {
        paramString1 = Long.toString(paramLong);
      }
    }
    TextUtils.isEmpty(paramString1);
    if (SwiftBrowserStatistics.aM)
    {
      if (paramString4 == null) {
        paramWebViewPluginEngine = localObject1;
      } else {
        paramWebViewPluginEngine = Uri.parse(paramString4);
      }
      if (paramWebViewPluginEngine == null) {
        paramString1 = "";
      } else {
        paramString1 = paramWebViewPluginEngine.getHost();
      }
      if (paramWebViewPluginEngine != null) {
        paramCustomWebView = paramWebViewPluginEngine.getPath();
      }
      ReportController.b(null, "dc00899", "WV_Analysis", "", "jsapi_call", "total", 2, 0, paramString1, paramCustomWebView, paramString5, "");
    }
    return false;
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
    if (this.l == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewPluginEngine", 2, "registerJSInterface");
      }
      this.l = new WebViewPluginEngine.WebViewJSInterfaceImpl(this);
      paramCustomWebView.addJavascriptInterface(this.l, "_mqqWebViewJSInterface");
    }
  }
  
  private void b(WebViewPlugin paramWebViewPlugin)
  {
    if ((paramWebViewPlugin instanceof MultiNameSpacePluginCompact))
    {
      String[] arrayOfString = ((MultiNameSpacePluginCompact)paramWebViewPlugin).getMultiNameSpace();
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int i2 = arrayOfString.length;
        int i1 = 0;
        while (i1 < i2)
        {
          String str = arrayOfString[i1];
          if (!TextUtils.isEmpty(str)) {
            a(str, paramWebViewPlugin);
          }
          i1 += 1;
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
  
  private static boolean c(WebViewPluginEngine paramWebViewPluginEngine, CustomWebView paramCustomWebView, String paramString)
  {
    if (paramWebViewPluginEngine.e() != null) {
      return paramWebViewPluginEngine.e().a(paramCustomWebView, paramString, paramWebViewPluginEngine.a);
    }
    return true;
  }
  
  private WebViewPlugin d(String paramString)
  {
    paramString = WebViewPluginFactory.a(paramString);
    b(paramString);
    a(paramString);
    return paramString;
  }
  
  private boolean e(String paramString)
  {
    String str1 = SwiftWebViewUtils.b(paramString);
    if (TextUtils.isEmpty(str1)) {
      return false;
    }
    if ("javascript".equals(str1)) {
      return false;
    }
    Object localObject1 = this.j;
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
    if ((this.i.containsKey(str1)) && (c().e(str2, str1)))
    {
      Object localObject2 = (CopyOnWriteArrayList)this.i.get(str1);
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
  
  private void f()
  {
    try
    {
      if ((WebViewEngineInjectorUtil.a != null) && (WebViewEngineInjectorUtil.a.size() > 0))
      {
        this.m = ((INativeApiMangerInjector)((Class)WebViewEngineInjectorUtil.a.get(0)).newInstance());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WebLog_WebViewPluginEngine", 1, "registerNativeApiManagerInjectors Fail,", localThrowable);
    }
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
        Iterator localIterator2 = this.g.values().iterator();
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
  
  public WebViewPlugin a(String paramString, boolean paramBoolean)
  {
    if (this.g.containsKey(paramString)) {
      return (WebViewPlugin)this.g.get(paramString);
    }
    if (paramBoolean) {
      return WebViewPluginFactory.a(paramString);
    }
    return null;
  }
  
  public Object a(String paramString, long paramLong)
  {
    Object localObject2 = (List)this.h.get(Long.valueOf(paramLong));
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = a(paramLong);
    }
    else if (paramLong > 8589934592L)
    {
      localObject2 = new CopyOnWriteArrayList(this.g.values());
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
    Object localObject = this.g;
    if ((localObject != null) && (((ConcurrentHashMap)localObject).size() != 0))
    {
      localObject = new StringBuilder(1024);
      ((StringBuilder)localObject).append("plugin list:\n");
      Iterator localIterator = this.g.values().iterator();
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
  
  public void a(CustomWebView paramCustomWebView)
  {
    if ((paramCustomWebView != null) && (this.j != paramCustomWebView))
    {
      this.j = paramCustomWebView;
      Iterator localIterator = this.g.values().iterator();
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
    Iterator localIterator = this.g.values().iterator();
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
    this.c = paramWebViewProvider;
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext())
    {
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)localIterator.next();
      if (localWebViewPlugin != null) {
        localWebViewPlugin.bindWebViewProvider(paramWebViewProvider);
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    a(paramAppRuntime, paramActivity, null);
  }
  
  public void a(AppRuntime paramAppRuntime, Activity paramActivity, List<WebViewPlugin> paramList)
  {
    if (this.a == null) {
      this.a = paramActivity;
    }
    if (this.b == null) {
      this.b = paramAppRuntime;
    }
    if ((paramList != null) && (paramList.size() > 0)) {
      b(paramAppRuntime, paramActivity, paramList);
    }
    paramList = this.g.values().iterator();
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
            if (((IPostCreatePluginChecker)localObject).a(paramActivity.getIntent(), new CopyOnWriteArrayList(this.g.values())))
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
      int i2 = paramArrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        d(paramArrayOfString[i1]);
        i1 += 1;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return e(paramString);
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
    if (this.h.containsKey(Long.valueOf(paramLong)))
    {
      localObject = (List)this.h.get(Long.valueOf(paramLong));
    }
    else if (paramLong > 8589934592L)
    {
      localObject = new CopyOnWriteArrayList(this.g.values());
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
            long l1 = System.currentTimeMillis();
            if (localWebViewPlugin.handleEvent(paramString, paramLong, paramMap))
            {
              if (QLog.isColorLevel())
              {
                l1 = System.currentTimeMillis() - l1;
                if (l1 > 50L)
                {
                  localStringBuilder.append("plugin[");
                  localStringBuilder.append(localWebViewPlugin.getClass().getSimpleName());
                  localStringBuilder.append("] handled event[");
                  localStringBuilder.append(paramLong);
                  localStringBuilder.append("] success cost ");
                  localStringBuilder.append(l1);
                  localStringBuilder.append(" ms.");
                  QLog.i("WebLog_WebViewPluginEngine", 2, localStringBuilder.toString());
                }
              }
              return true;
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
    Object localObject1 = (CopyOnWriteArrayList)this.h.get(Long.valueOf(32L));
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
  
  public WebViewPlugin b(String paramString)
  {
    return a(paramString, false);
  }
  
  public void b()
  {
    Object localObject1 = this.a;
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
      int i1 = ((String)localObject1).indexOf(":");
      if (i1 > 0) {
        str = ((String)localObject1).substring(0, i1);
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
  
  public AuthorizeConfig c()
  {
    if (this.k == null) {
      this.k = AuthorizeConfig.a();
    }
    return this.k;
  }
  
  public void c(String paramString)
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
  
  public void d()
  {
    Object localObject = new HashMap();
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext())
    {
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)localIterator.next();
      if ((localWebViewPlugin != null) && (!((HashMap)localObject).containsKey(localWebViewPlugin)))
      {
        long l1 = System.currentTimeMillis();
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
          l1 = System.currentTimeMillis() - l1;
          if (l1 > 50L)
          {
            StringBuilder localStringBuilder = new StringBuilder("plugin[");
            localStringBuilder.append(localWebViewPlugin.getClass().getSimpleName());
            localStringBuilder.append("] onDestroy cost ");
            localStringBuilder.append(l1);
            localStringBuilder.append(" ms.");
            QLog.d("WebLog_WebViewPluginEngine", 2, new Object[] { localStringBuilder });
          }
        }
      }
    }
    this.g.clear();
    this.h.clear();
    this.i.clear();
    localObject = this.m;
    if (localObject != null) {
      ((INativeApiMangerInjector)localObject).a();
    }
    this.j = null;
  }
  
  public INativeApiMangerInjector e()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewPluginEngine
 * JD-Core Version:    0.7.0.1
 */