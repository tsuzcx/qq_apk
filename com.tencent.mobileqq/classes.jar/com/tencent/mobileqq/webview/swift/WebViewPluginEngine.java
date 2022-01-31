package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.ecshopassit.BusinessReporter;
import com.tencent.biz.webviewplugin.BusinessReportPlugin;
import com.tencent.biz.webviewplugin.PubAccountUIPlugin;
import com.tencent.biz.webviewplugin.QzonePlugin;
import com.tencent.biz.webviewplugin.ReadInJoyWebRenderPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.ApolloGamePlugin;
import com.tencent.mobileqq.campuscircle.CampusCirclePlugin;
import com.tencent.mobileqq.jsp.DocxApiPlugin;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vashealth.HealthPathTracePlugin;
import com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qidian.plugin.QidianWpaWebviewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import cooperation.weiyun.WeiyunJsPlugin;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebViewPluginEngine
{
  public static WebViewPluginEngine a;
  protected static final HashMap a;
  public Activity a;
  private AuthorizeConfig jdField_a_of_type_ComTencentBizAuthorizeConfig;
  private volatile CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  public AppInterface a;
  public WebViewFragment a;
  private final ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final HashMap b = new HashMap();
  private final HashMap c = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("auth.init", "Troop.init");
    jdField_a_of_type_JavaUtilHashMap.put("device.getNetworkInfo", "qbizApi.getNetworkInfo");
    jdField_a_of_type_JavaUtilHashMap.put("data.setShareInfo", "QQApi.setShareInfo");
    jdField_a_of_type_JavaUtilHashMap.put("event.dispatchEvent", "event.dispatchEvent");
    jdField_a_of_type_JavaUtilHashMap.put("media.showPicture", "troopNotice.showPicture");
    jdField_a_of_type_JavaUtilHashMap.put("ui.popBack", "publicAccount.close");
    jdField_a_of_type_JavaUtilHashMap.put("ui.shareMessage", "QQApi.shareMsg");
  }
  
  public WebViewPluginEngine(CustomWebView paramCustomWebView, Activity paramActivity, AppInterface paramAppInterface, WebAccelerateHelper.CommonJsPluginFactory paramCommonJsPluginFactory)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a(false, paramAppInterface, paramCommonJsPluginFactory, null);
    a();
    a(paramAppInterface, paramActivity);
  }
  
  public WebViewPluginEngine(CustomWebView paramCustomWebView, Activity paramActivity, AppInterface paramAppInterface, WebAccelerateHelper.CommonJsPluginFactory paramCommonJsPluginFactory, List paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a(false, paramAppInterface, paramCommonJsPluginFactory, null);
    paramCustomWebView = paramList.iterator();
    while (paramCustomWebView.hasNext())
    {
      paramCommonJsPluginFactory = (WebViewPlugin)paramCustomWebView.next();
      b(paramCommonJsPluginFactory);
      a(paramCommonJsPluginFactory);
    }
    a(paramAppInterface, paramActivity);
  }
  
  public WebViewPluginEngine(AppInterface paramAppInterface, WebAccelerateHelper.CommonJsPluginFactory paramCommonJsPluginFactory, List paramList)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a(true, paramAppInterface, paramCommonJsPluginFactory, paramList);
  }
  
  public static int a(WebViewPlugin paramWebViewPlugin)
  {
    if (paramWebViewPlugin == null) {}
    label37:
    label60:
    do
    {
      do
      {
        return -1;
        if (!(paramWebViewPlugin instanceof MultiNameSpacePluginCompact)) {
          break;
        }
        paramWebViewPlugin = ((MultiNameSpacePluginCompact)paramWebViewPlugin).getMultiNameSpace();
      } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.length <= 0));
      int j = paramWebViewPlugin.length;
      int i = 0;
      CharSequence localCharSequence;
      if (i < j)
      {
        localCharSequence = paramWebViewPlugin[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          break label60;
        }
      }
      while (!WebViewPluginFactory.jdField_a_of_type_JavaUtilHashMap.containsKey(localCharSequence))
      {
        i += 1;
        break label37;
        break;
      }
      return ((Integer)WebViewPluginFactory.jdField_a_of_type_JavaUtilHashMap.get(localCharSequence)).intValue();
      if (TextUtils.isEmpty(paramWebViewPlugin.mPluginNameSpace)) {
        break;
      }
    } while (!WebViewPluginFactory.jdField_a_of_type_JavaUtilHashMap.containsKey(paramWebViewPlugin.mPluginNameSpace));
    return ((Integer)WebViewPluginFactory.jdField_a_of_type_JavaUtilHashMap.get(paramWebViewPlugin.mPluginNameSpace)).intValue();
    a(paramWebViewPlugin.toString() + " have no namespace!!!!");
    return -1;
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
      paramWebViewPlugin.initRuntime(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      paramWebViewPlugin.mRuntime.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment);
      paramWebViewPlugin.onCreate();
      if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
        paramWebViewPlugin.onWebViewCreated(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
      }
    }
  }
  
  private static void a(String paramString)
  {
    QLog.e("WebLog_WebViewPluginEngine", 1, paramString);
  }
  
  private void a(String paramString, WebViewPlugin paramWebViewPlugin)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramWebViewPlugin == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        QLog.e("WebLog_WebViewPluginEngine", 1, "insertPlugin:namespace " + paramString + " already exists!");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewPluginEngine", 2, "insertPlugin:add pair [" + paramString + "] -> " + paramWebViewPlugin.getClass().getSimpleName());
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramWebViewPlugin);
      long l2;
      int i;
      long l1;
      Object localObject2;
      Object localObject1;
      if (WebviewPluginEventConfig.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        l2 = ((Long)WebviewPluginEventConfig.jdField_a_of_type_JavaUtilHashMap.get(paramString)).longValue();
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
            int j = i + 1;
            l1 = 1L << i;
            i = j;
          }
        }
      }
      if (WebViewPluginSchemeConfig.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        l2 = ((Long)WebViewPluginSchemeConfig.jdField_a_of_type_JavaUtilHashMap.get(paramString)).longValue();
        i = 1;
        l1 = 1L;
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
              paramString.add(paramWebViewPlugin);
            }
          }
          l1 = 1L << i;
          i += 1;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, AppInterface paramAppInterface, WebAccelerateHelper.CommonJsPluginFactory paramCommonJsPluginFactory, List paramList)
  {
    paramCommonJsPluginFactory = paramCommonJsPluginFactory.a().iterator();
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
      paramList.onAppRuntimeReady(paramAppInterface);
      paramList.onCreate();
      if (!paramBoolean)
      {
        paramList.initRuntime(this.jdField_a_of_type_AndroidAppActivity, paramAppInterface);
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
    String str = localObject3[2];
    int j = 1;
    Object localObject1;
    if (localObject3.length == 5)
    {
      j = 0;
      localObject1 = localObject3[3].split("#");
      if (localObject1.length <= 1) {
        break label840;
      }
    }
    for (;;)
    {
      int k;
      try
      {
        i = Integer.parseInt(localObject1[1]);
        l = i;
        localObject3 = localObject1[0].split("\\?");
        if (localObject3.length <= 1) {
          break label436;
        }
        localObject2 = localObject3[1].split("&");
        localObject1 = localObject2;
        if (localObject2.length <= 0) {
          break label319;
        }
        localObject1 = new ArrayList();
        i = 0;
        k = localObject2.length;
        if (i >= k) {
          break label297;
        }
        int m = localObject2[i].indexOf('=');
        if (m != -1)
        {
          if (!"mqq_tt".equals(localObject2[i].substring(0, m))) {
            ((List)localObject1).add(URLDecoder.decode(localObject2[i].substring(m + 1)));
          }
          i += 1;
          continue;
        }
        ((List)localObject1).add("");
      }
      catch (NumberFormatException paramWebViewPluginEngine)
      {
        QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { new StringBuilder("illegal jsbridge[").append(paramString).append("] error:").append(paramWebViewPluginEngine.toString()) });
        return true;
      }
      continue;
      label297:
      localObject1 = (String[])((List)localObject1).toArray(new String[((List)localObject1).size()]);
      label319:
      localObject3 = localObject3[0];
      Object localObject2 = localObject1;
      localObject1 = localObject3;
      for (int i = j;; i = j)
      {
        JsBridgeListener localJsBridgeListener = new JsBridgeListener(paramCustomWebView, l, paramString);
        localObject3 = paramCustomWebView.getUrl();
        if (paramWebViewPluginEngine.a().a((String)localObject3, str + "." + (String)localObject1))
        {
          localObject3 = paramWebViewPluginEngine.a(str);
          paramCustomWebView = (CustomWebView)localObject3;
          if (localObject3 == null) {
            paramCustomWebView = paramWebViewPluginEngine.b(str);
          }
          if (paramCustomWebView != null)
          {
            a(paramCustomWebView, localJsBridgeListener, paramString, str, (String)localObject1, (String[])localObject2);
            return true;
            label436:
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
              if (i == 0) {
                break label572;
              }
            }
            catch (Exception paramWebViewPluginEngine)
            {
              QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { new StringBuilder("illegal jsbridge[").append(paramString).append("] error:").append(paramWebViewPluginEngine.toString()) });
              return true;
            }
          }
          if (l == -1L) {}
        }
        for (;;)
        {
          return true;
          label572:
          paramCustomWebView = null;
          paramWebViewPluginEngine = paramCustomWebView;
          if (localObject2.length > 0)
          {
            paramWebViewPluginEngine = paramCustomWebView;
            if (!localObject2[0].startsWith("{")) {}
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
              localJsBridgeListener.a();
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                paramCustomWebView = (CustomWebView)localObject3;
                if (((String)localObject3).contains("?")) {
                  paramCustomWebView = ((String)localObject3).substring(0, ((String)localObject3).indexOf("?"));
                }
                i = (int)paramWebViewPluginEngine.a().a();
                j = QbSdk.getTbsVersion(BaseApplication.getContext());
                paramWebViewPluginEngine = DeviceInfoUtil.i() + " " + DeviceInfoUtil.j();
                VasWebviewUtil.reportVasStatus("JsApiRights", str, (String)localObject1, 3, 0, j, i, paramCustomWebView, paramWebViewPluginEngine);
                if (!paramCustomWebView.startsWith("http")) {
                  QLog.d("WebLog_WebViewPluginEngine", 1, "no plugin have right handle  " + str + "." + (String)localObject1 + ", x5 version = " + j + ", phone is " + paramWebViewPluginEngine);
                }
              }
            }
          }
          catch (JSONException paramWebViewPluginEngine)
          {
            for (;;)
            {
              paramWebViewPluginEngine = paramCustomWebView;
            }
          }
        }
      }
      label840:
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
  
  private void b(AppInterface paramAppInterface, Activity paramActivity, List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)paramList.next();
        localWebViewPlugin.initRuntime(paramActivity, paramAppInterface);
        localWebViewPlugin.onCreate();
        localWebViewPlugin.onAppRuntimeReady(paramAppInterface);
        b(localWebViewPlugin);
      }
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
  
  /* Error */
  private static boolean b(WebViewPluginEngine paramWebViewPluginEngine, CustomWebView paramCustomWebView, String paramString)
  {
    // Byte code:
    //   0: new 141	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   7: aload_2
    //   8: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11: ldc_w 322
    //   14: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: ldc_w 324
    //   23: invokevirtual 328	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   26: astore 6
    //   28: aload 6
    //   30: arraylength
    //   31: iconst_5
    //   32: if_icmpge +31 -> 63
    //   35: ldc 204
    //   37: iconst_1
    //   38: new 141	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 330
    //   48: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_2
    //   52: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 210	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: iconst_1
    //   62: ireturn
    //   63: aload 6
    //   65: iconst_2
    //   66: aaload
    //   67: astore 11
    //   69: ldc2_w 409
    //   72: lstore 4
    //   74: aload 6
    //   76: arraylength
    //   77: iconst_5
    //   78: if_icmpne +368 -> 446
    //   81: aload 6
    //   83: iconst_3
    //   84: aaload
    //   85: ldc_w 332
    //   88: invokevirtual 328	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   91: astore 6
    //   93: aload 6
    //   95: arraylength
    //   96: iconst_1
    //   97: if_icmple +15 -> 112
    //   100: aload 6
    //   102: iconst_1
    //   103: aaload
    //   104: invokestatic 336	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   107: istore_3
    //   108: iload_3
    //   109: i2l
    //   110: lstore 4
    //   112: aload 6
    //   114: iconst_0
    //   115: aaload
    //   116: ldc_w 338
    //   119: invokevirtual 328	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   122: astore 7
    //   124: aload 7
    //   126: arraylength
    //   127: iconst_1
    //   128: if_icmple +309 -> 437
    //   131: aload 7
    //   133: iconst_1
    //   134: aaload
    //   135: bipush 61
    //   137: invokevirtual 347	java/lang/String:indexOf	(I)I
    //   140: istore_3
    //   141: iload_3
    //   142: iconst_m1
    //   143: if_icmpeq +285 -> 428
    //   146: aload 7
    //   148: iconst_1
    //   149: aaload
    //   150: iload_3
    //   151: iconst_1
    //   152: iadd
    //   153: invokevirtual 359	java/lang/String:substring	(I)Ljava/lang/String;
    //   156: invokestatic 365	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   159: astore 8
    //   161: ldc_w 481
    //   164: aload 8
    //   166: invokevirtual 356	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifeq +244 -> 413
    //   172: iconst_0
    //   173: anewarray 164	java/lang/String
    //   176: astore 6
    //   178: aload 7
    //   180: iconst_0
    //   181: aaload
    //   182: astore 12
    //   184: new 141	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   191: aload 11
    //   193: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc_w 297
    //   199: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 12
    //   204: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: astore 16
    //   212: new 377	com/tencent/mobileqq/webview/swift/JsBridgeListener
    //   215: dup
    //   216: aload_1
    //   217: lload 4
    //   219: iconst_1
    //   220: invokespecial 484	com/tencent/mobileqq/webview/swift/JsBridgeListener:<init>	(Lcom/tencent/smtt/sdk/WebView;JZ)V
    //   223: astore 15
    //   225: aconst_null
    //   226: astore 8
    //   228: aconst_null
    //   229: astore 13
    //   231: aconst_null
    //   232: astore 7
    //   234: aconst_null
    //   235: astore 9
    //   237: aconst_null
    //   238: astore 10
    //   240: aconst_null
    //   241: astore 14
    //   243: aload 6
    //   245: arraylength
    //   246: iconst_1
    //   247: if_icmpne +565 -> 812
    //   250: ldc 26
    //   252: aload 16
    //   254: invokevirtual 356	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   257: ifne +555 -> 812
    //   260: new 418	org/json/JSONObject
    //   263: dup
    //   264: aload 6
    //   266: iconst_0
    //   267: aaload
    //   268: invokespecial 419	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   271: astore 14
    //   273: aload 14
    //   275: ldc_w 486
    //   278: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   281: checkcast 164	java/lang/String
    //   284: invokestatic 336	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   287: istore_3
    //   288: aload 14
    //   290: ldc_w 492
    //   293: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   296: checkcast 164	java/lang/String
    //   299: astore 7
    //   301: aload 14
    //   303: ldc_w 494
    //   306: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   309: checkcast 164	java/lang/String
    //   312: astore 8
    //   314: aload 14
    //   316: ldc_w 496
    //   319: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   322: pop
    //   323: aload 14
    //   325: invokevirtual 497	org/json/JSONObject:toString	()Ljava/lang/String;
    //   328: astore 9
    //   330: ldc_w 481
    //   333: aload 9
    //   335: invokevirtual 356	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   338: ifeq +126 -> 464
    //   341: iconst_0
    //   342: anewarray 164	java/lang/String
    //   345: astore 9
    //   347: aload 9
    //   349: astore 6
    //   351: aload_1
    //   352: aload_1
    //   353: iload_3
    //   354: aload 7
    //   356: aload 8
    //   358: aload 16
    //   360: aload 15
    //   362: invokevirtual 500	com/tencent/biz/pubaccount/CustomWebView:a	(Lcom/tencent/biz/pubaccount/CustomWebView;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)Z
    //   365: ifne +211 -> 576
    //   368: iconst_1
    //   369: ireturn
    //   370: astore_0
    //   371: ldc 204
    //   373: iconst_1
    //   374: iconst_1
    //   375: anewarray 4	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: new 141	java/lang/StringBuilder
    //   383: dup
    //   384: ldc_w 368
    //   387: invokespecial 293	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: aload_2
    //   391: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: ldc_w 312
    //   397: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_0
    //   401: invokevirtual 369	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   404: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aastore
    //   408: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   411: iconst_1
    //   412: ireturn
    //   413: iconst_1
    //   414: anewarray 164	java/lang/String
    //   417: astore 6
    //   419: aload 6
    //   421: iconst_0
    //   422: aload 8
    //   424: aastore
    //   425: goto -247 -> 178
    //   428: iconst_0
    //   429: anewarray 164	java/lang/String
    //   432: astore 6
    //   434: goto -256 -> 178
    //   437: iconst_0
    //   438: anewarray 164	java/lang/String
    //   441: astore 6
    //   443: goto -265 -> 178
    //   446: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +13 -> 462
    //   452: ldc_w 502
    //   455: iconst_2
    //   456: ldc_w 504
    //   459: invokestatic 210	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: iconst_0
    //   463: ireturn
    //   464: iconst_1
    //   465: anewarray 164	java/lang/String
    //   468: dup
    //   469: iconst_0
    //   470: aload 9
    //   472: aastore
    //   473: astore 6
    //   475: goto -124 -> 351
    //   478: astore 7
    //   480: iconst_0
    //   481: istore_3
    //   482: ldc 204
    //   484: iconst_1
    //   485: new 141	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   492: ldc_w 506
    //   495: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload 7
    //   500: invokevirtual 369	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   503: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 210	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: aload 8
    //   514: astore 7
    //   516: aload 9
    //   518: astore 8
    //   520: goto -169 -> 351
    //   523: astore 7
    //   525: iconst_0
    //   526: istore_3
    //   527: aload 10
    //   529: astore 9
    //   531: aload 13
    //   533: astore 8
    //   535: ldc 204
    //   537: iconst_1
    //   538: new 141	java/lang/StringBuilder
    //   541: dup
    //   542: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   545: ldc_w 508
    //   548: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload 7
    //   553: invokevirtual 509	org/json/JSONException:toString	()Ljava/lang/String;
    //   556: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 210	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: aload 8
    //   567: astore 7
    //   569: aload 9
    //   571: astore 8
    //   573: goto -222 -> 351
    //   576: aload 11
    //   578: astore 8
    //   580: aload 12
    //   582: astore 7
    //   584: getstatic 24	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   587: aload 16
    //   589: invokevirtual 125	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   592: ifeq +49 -> 641
    //   595: getstatic 24	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   598: aload 16
    //   600: invokevirtual 129	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   603: checkcast 164	java/lang/String
    //   606: ldc_w 511
    //   609: invokevirtual 328	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   612: astore 9
    //   614: aload 11
    //   616: astore 8
    //   618: aload 12
    //   620: astore 7
    //   622: aload 9
    //   624: arraylength
    //   625: iconst_2
    //   626: if_icmpne +15 -> 641
    //   629: aload 9
    //   631: iconst_0
    //   632: aaload
    //   633: astore 8
    //   635: aload 9
    //   637: iconst_1
    //   638: aaload
    //   639: astore 7
    //   641: aload_0
    //   642: aload 8
    //   644: invokevirtual 396	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   647: astore 10
    //   649: aload 10
    //   651: astore 9
    //   653: aload 10
    //   655: ifnonnull +11 -> 666
    //   658: aload_0
    //   659: aload 8
    //   661: invokespecial 398	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   664: astore 9
    //   666: aload 9
    //   668: ifnull +22 -> 690
    //   671: aload 9
    //   673: aload 15
    //   675: aload_2
    //   676: aload 8
    //   678: aload 7
    //   680: aload 6
    //   682: invokestatic 400	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z
    //   685: ifeq +5 -> 690
    //   688: iconst_1
    //   689: ireturn
    //   690: aload_1
    //   691: aload 15
    //   693: iconst_3
    //   694: iconst_1
    //   695: anewarray 164	java/lang/String
    //   698: dup
    //   699: iconst_0
    //   700: iconst_3
    //   701: aconst_null
    //   702: ldc_w 513
    //   705: invokestatic 516	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(ILjava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
    //   708: aastore
    //   709: invokevirtual 519	com/tencent/biz/pubaccount/CustomWebView:a	(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;I[Ljava/lang/String;)V
    //   712: iconst_1
    //   713: ireturn
    //   714: astore 7
    //   716: aload 13
    //   718: astore 8
    //   720: aload 10
    //   722: astore 9
    //   724: goto -189 -> 535
    //   727: astore 9
    //   729: aload 7
    //   731: astore 8
    //   733: aload 9
    //   735: astore 7
    //   737: aload 10
    //   739: astore 9
    //   741: goto -206 -> 535
    //   744: astore 10
    //   746: aload 8
    //   748: astore 9
    //   750: aload 10
    //   752: astore 8
    //   754: aload 7
    //   756: astore 10
    //   758: aload 8
    //   760: astore 7
    //   762: aload 10
    //   764: astore 8
    //   766: goto -231 -> 535
    //   769: astore 7
    //   771: goto -289 -> 482
    //   774: astore 10
    //   776: aload 7
    //   778: astore 8
    //   780: aload 10
    //   782: astore 7
    //   784: goto -302 -> 482
    //   787: astore 10
    //   789: aload 8
    //   791: astore 9
    //   793: aload 10
    //   795: astore 8
    //   797: aload 7
    //   799: astore 10
    //   801: aload 8
    //   803: astore 7
    //   805: aload 10
    //   807: astore 8
    //   809: goto -327 -> 482
    //   812: iconst_0
    //   813: istore_3
    //   814: aload 14
    //   816: astore 8
    //   818: goto -467 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	821	0	paramWebViewPluginEngine	WebViewPluginEngine
    //   0	821	1	paramCustomWebView	CustomWebView
    //   0	821	2	paramString	String
    //   107	707	3	i	int
    //   72	146	4	l	long
    //   26	655	6	localObject1	Object
    //   122	233	7	localObject2	Object
    //   478	21	7	localNumberFormatException1	NumberFormatException
    //   514	1	7	localObject3	Object
    //   523	29	7	localJSONException1	JSONException
    //   567	112	7	localObject4	Object
    //   714	16	7	localJSONException2	JSONException
    //   735	26	7	localObject5	Object
    //   769	8	7	localNumberFormatException2	NumberFormatException
    //   782	22	7	localObject6	Object
    //   159	658	8	localObject7	Object
    //   235	488	9	localObject8	Object
    //   727	7	9	localJSONException3	JSONException
    //   739	53	9	localObject9	Object
    //   238	500	10	localWebViewPlugin	WebViewPlugin
    //   744	7	10	localJSONException4	JSONException
    //   756	7	10	localObject10	Object
    //   774	7	10	localNumberFormatException3	NumberFormatException
    //   787	7	10	localNumberFormatException4	NumberFormatException
    //   799	7	10	localObject11	Object
    //   67	548	11	str1	String
    //   182	437	12	str2	String
    //   229	488	13	localObject12	Object
    //   241	574	14	localJSONObject	JSONObject
    //   223	469	15	localJsBridgeListener	JsBridgeListener
    //   210	389	16	str3	String
    // Exception table:
    //   from	to	target	type
    //   100	108	370	java/lang/NumberFormatException
    //   260	288	478	java/lang/NumberFormatException
    //   260	288	523	org/json/JSONException
    //   288	301	714	org/json/JSONException
    //   301	314	727	org/json/JSONException
    //   314	347	744	org/json/JSONException
    //   288	301	769	java/lang/NumberFormatException
    //   301	314	774	java/lang/NumberFormatException
    //   314	347	787	java/lang/NumberFormatException
  }
  
  private boolean b(String paramString)
  {
    String str = SwiftWebViewUtils.a(paramString);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if ("javascript".equals(str)) {
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
    if (localObject1 == null) {
      return false;
    }
    if ("jsbridge".equals(str)) {
      return a(this, (CustomWebView)localObject1, paramString);
    }
    if ("openapi".equals(str)) {
      return b(this, (CustomWebView)localObject1, paramString);
    }
    localObject1 = ((CustomWebView)localObject1).getUrl();
    if ((this.c.containsKey(str)) && (a().c((String)localObject1, str)))
    {
      Object localObject2 = (CopyOnWriteArrayList)this.c.get(str);
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
            break label368;
          }
          WebViewPlugin localWebViewPlugin = (WebViewPlugin)((Iterator)localObject2).next();
          long l1 = System.currentTimeMillis();
          if (localWebViewPlugin != null)
          {
            if (localWebViewPlugin.handleSchemaRequest(paramString, str))
            {
              if (QLog.isColorLevel())
              {
                long l2 = System.currentTimeMillis();
                ((StringBuilder)localObject1).append("plugin[").append(localWebViewPlugin.getClass().getSimpleName()).append("] handle scheme[").append(str).append("] success cost ").append(l2 - l1).append(" ms.");
                QLog.i("WebLog_WebViewPluginEngine", 2, ((StringBuilder)localObject1).toString());
              }
              return true;
              localObject1 = new StringBuilder();
              break;
            }
            if (QLog.isColorLevel())
            {
              l1 = System.currentTimeMillis() - l1;
              if (l1 > 50L) {
                ((StringBuilder)localObject1).append("plugin[").append(localWebViewPlugin.getClass().getSimpleName()).append("] handle scheme[").append(str).append("] cost ").append(l1).append(" ms.");
              }
            }
          }
        }
        label368:
        if ((QLog.isColorLevel()) && (((StringBuilder)localObject1).length() > 0))
        {
          ((StringBuilder)localObject1).append("overrideUrlRequest error:no plugin can handle this scheme[").append(str).append("].");
          QLog.i("WebLog_WebViewPluginEngine", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    for (;;)
    {
      return false;
      QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { new StringBuilder("overrideUrlRequest error:no plugin can handle this scheme[").append(str).append("].") });
    }
  }
  
  public AuthorizeConfig a()
  {
    if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
      this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    }
    return this.jdField_a_of_type_ComTencentBizAuthorizeConfig;
  }
  
  public WebViewPlugin a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = WebViewPluginFactory.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (((Integer)((Map.Entry)localObject2).getValue()).intValue() == paramInt) {
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((Map.Entry)localObject2).getKey())) {
          break;
        }
      }
    }
    for (localObject1 = (WebViewPlugin)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(((Map.Entry)localObject2).getKey());; localObject1 = null)
    {
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
    }
  }
  
  public WebViewPlugin a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return (WebViewPlugin)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
    Object localObject3;
    Object localObject1;
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      localObject3 = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      localObject2 = ((Intent)localObject3).getStringExtra("url");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = ((Intent)localObject3).getStringExtra("key_params_qq");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    else
    {
      return;
    }
    int i = ((String)localObject1).indexOf(":");
    if (i > 0) {}
    for (Object localObject2 = ((String)localObject1).substring(0, i);; localObject2 = "")
    {
      if (((Intent)localObject3).getIntExtra("uintype", -1) == 1030)
      {
        CampusCirclePlugin localCampusCirclePlugin = new CampusCirclePlugin();
        a(localCampusCirclePlugin);
        a("campus_circle", localCampusCirclePlugin);
      }
      if ((((Intent)localObject3).getBooleanExtra("fromQZone", false)) && ((((String)localObject2).equals("http")) || (((String)localObject2).equals("https"))))
      {
        localObject3 = new QzonePlugin();
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if (MusicGeneWebViewPlugin.a((String)localObject1))
      {
        localObject3 = new MusicGeneWebViewPlugin();
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if (WeiyunJsPlugin.a((String)localObject1))
      {
        localObject3 = new WeiyunJsPlugin();
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if (PubAccountUIPlugin.a((String)localObject1))
      {
        localObject3 = new PubAccountUIPlugin();
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if ((((String)localObject1).startsWith("http://clientui.3g.qq.com/mqqapi/im/roam")) || (((String)localObject1).startsWith("http://mapp.3g.qq.com/touch/psw/verify.jsp")) || (((String)localObject1).startsWith("http://mapp.3g.qq.com/touch/psw/create.jsp")))
      {
        localObject3 = new MessageRoamJsPlugin();
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if (((String)localObject2).equals("qqjsbridge"))
      {
        localObject2 = new QWalletPayJsPlugin();
        a((WebViewPlugin)localObject2);
        b((WebViewPlugin)localObject2);
      }
      if ((BusinessReporter.a()) && (BusinessReporter.a((String)localObject1)))
      {
        localObject2 = new BusinessReportPlugin();
        a((WebViewPlugin)localObject2);
        b((WebViewPlugin)localObject2);
      }
      if (((String)localObject1).contains("thunder_id"))
      {
        localObject2 = new ApolloJsPlugin((String)localObject1);
        a((WebViewPlugin)localObject2);
        b((WebViewPlugin)localObject2);
      }
      if (((String)localObject1).contains("apollo_bk"))
      {
        localObject2 = new ApolloGamePlugin();
        a((WebViewPlugin)localObject2);
        b((WebViewPlugin)localObject2);
      }
      if ((((String)localObject1).contains("docx.qq.com")) || (((String)localObject1).contains("docs.qq.com")))
      {
        localObject2 = new DocxApiPlugin();
        a((WebViewPlugin)localObject2);
        b((WebViewPlugin)localObject2);
      }
      if (HealthPathTracePlugin.a((String)localObject1))
      {
        localObject2 = new HealthPathTracePlugin();
        a((WebViewPlugin)localObject2);
        b((WebViewPlugin)localObject2);
      }
      if (((String)localObject1).contains("lbs.qidian.qq.com/authorize/voiceShow"))
      {
        localObject2 = new QidianWpaWebviewPlugin();
        a((WebViewPlugin)localObject2);
        b((WebViewPlugin)localObject2);
      }
      if (!((String)localObject1).contains("kandian.qq.com")) {
        break;
      }
      localObject1 = new ReadInJoyWebRenderPlugin();
      a((WebViewPlugin)localObject1);
      b((WebViewPlugin)localObject1);
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
    }
  }
  
  public void a(AppInterface paramAppInterface, Activity paramActivity)
  {
    a(paramAppInterface, paramActivity, null);
  }
  
  public void a(AppInterface paramAppInterface, Activity paramActivity, List paramList)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    }
    if ((paramList != null) && (paramList.size() > 0)) {
      b(paramAppInterface, paramActivity, paramList);
    }
    boolean bool = paramActivity.getIntent().getBooleanExtra("fromQZone", false);
    paramList = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)paramList.next();
      if (localWebViewPlugin != null)
      {
        if (localWebViewPlugin.mRuntime == null) {
          localWebViewPlugin.initRuntime(paramActivity, paramAppInterface);
        }
        localWebViewPlugin.onActivityReady();
        if (!(localWebViewPlugin instanceof QzonePlugin)) {
          break label171;
        }
        i = 1;
      }
    }
    label171:
    for (;;)
    {
      break;
      if ((bool) && (i == 0))
      {
        paramList = new QzonePlugin();
        paramList.initRuntime(paramActivity, paramAppInterface);
        paramList.onCreate();
        paramList.onAppRuntimeReady(paramAppInterface);
        b(paramList);
      }
      return;
    }
  }
  
  public void a(WebViewFragment paramWebViewFragment)
  {
    if (paramWebViewFragment == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = paramWebViewFragment;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)localIterator.next();
        if (localWebViewPlugin != null) {
          localWebViewPlugin.bindFragment(paramWebViewFragment);
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
  
  public boolean a(String paramString, long paramLong, Map paramMap)
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
  
  public boolean a(Map paramMap)
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
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewPluginEngine
 * JD-Core Version:    0.7.0.1
 */