package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.X5ApiPlugin;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vaswebviewplugin.VasBaseWebviewUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.injector.ISwiftBrowserTBSInjector;
import com.tencent.mobileqq.webview.swift.injector.SwiftBrowserTBSInjectorUtil;
import com.tencent.mobileqq.webview.util.ITbsDownloader;
import com.tencent.mobileqq.webview.webso.SHA1Util;
import com.tencent.open.api.WebViewOpenSdkApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class SwiftBrowserTBSHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
  implements Handler.Callback
{
  private static ISwiftBrowserTBSInjector m = ;
  Activity a;
  WebViewProvider c;
  MqqHandler d = null;
  final Object e = new Object();
  Dialog f = null;
  Boolean g = Boolean.valueOf(false);
  long h = 0L;
  String i = null;
  boolean j = false;
  BroadcastReceiver k;
  private HashSet<String> l;
  
  private static Pair<Integer, Integer> a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i1 = 0;
    if (!bool)
    {
      paramString = Uri.parse(paramString);
      if (paramString.isHierarchical())
      {
        paramString = paramString.getHost();
        if ((!TextUtils.isEmpty(paramString)) && (AuthorizeConfig.a().r(paramString)))
        {
          i1 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
          n = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
          if (!paramString.contains("cmshow"))
          {
            n -= Utils.a(54.0F, BaseApplication.getContext().getResources());
            break label102;
          }
          break label102;
        }
      }
    }
    int n = 0;
    label102:
    return new Pair(Integer.valueOf(i1), Integer.valueOf(n));
  }
  
  private ITbsDownloader a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof ITbsDownloader)) {
      return (ITbsDownloader)paramAppRuntime;
    }
    return null;
  }
  
  public static void a(String paramString, WebView paramWebView)
  {
    ThreadManager.post(new SwiftBrowserTBSHandler.9(paramString, paramWebView), 5, null, true);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  private void b(Bundle paramBundle)
  {
    if (paramBundle.containsKey("url"))
    {
      String str1 = paramBundle.getString("url");
      if ((!TextUtils.isEmpty(str1)) && (str1.startsWith("http")))
      {
        String str2 = Uri.parse(str1).getQueryParameter("_bid");
        if (!TextUtils.isEmpty(str2))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("ServiceWorkerOffline Notify Resource RequestURL: ");
            localStringBuilder.append(paramBundle.getString("url"));
            QLog.i("SwiftBrowserTBSHandler", 2, localStringBuilder.toString());
          }
          if (this.l == null) {
            this.l = new HashSet(6);
          }
          if (!this.l.contains(str2))
          {
            this.l.add(str2);
            ThreadManager.getUIHandler().postDelayed(new SwiftBrowserTBSHandler.4(this, str1), 5000L);
          }
        }
      }
    }
  }
  
  private static void b(WebView paramWebView, String paramString1, String paramString2)
  {
    Object localObject = a(paramString1);
    int n = ((Integer)((Pair)localObject).first).intValue();
    int i1 = ((Integer)((Pair)localObject).second).intValue();
    if ((n > 0) && (i1 > 0) && (paramWebView != null))
    {
      if (paramWebView.getX5WebViewExtension() == null) {
        return;
      }
      if (TextUtils.isEmpty(paramString2)) {
        localObject = "";
      } else {
        localObject = SHA1Util.a(paramString2);
      }
      ThreadManager.getUIHandler().post(new SwiftBrowserTBSHandler.10(paramString2, paramString1, paramWebView, n, i1, (String)localObject));
    }
  }
  
  /* Error */
  private void c(Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 207
    //   8: iconst_2
    //   9: ldc_w 278
    //   12: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: ldc_w 280
    //   19: invokevirtual 182	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   22: ifeq +405 -> 427
    //   25: aload_1
    //   26: ldc_w 280
    //   29: invokevirtual 186	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 15
    //   34: aload_1
    //   35: ldc_w 282
    //   38: invokevirtual 186	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: astore 16
    //   43: aload_1
    //   44: ldc_w 284
    //   47: invokevirtual 186	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_1
    //   51: aload 15
    //   53: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: istore_2
    //   57: lconst_0
    //   58: lstore 11
    //   60: iload_2
    //   61: ifne +367 -> 428
    //   64: aload 15
    //   66: invokestatic 290	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   69: lstore_3
    //   70: goto +3 -> 73
    //   73: aload 16
    //   75: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifne +355 -> 433
    //   81: aload 16
    //   83: invokestatic 290	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   86: lstore 5
    //   88: goto +3 -> 91
    //   91: aload_1
    //   92: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   95: ifne +344 -> 439
    //   98: aload_1
    //   99: invokestatic 290	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   102: lstore 7
    //   104: goto +3 -> 107
    //   107: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq +29 -> 139
    //   113: ldc 207
    //   115: iconst_2
    //   116: ldc_w 292
    //   119: iconst_2
    //   120: anewarray 48	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload 15
    //   127: aastore
    //   128: dup
    //   129: iconst_1
    //   130: aload 16
    //   132: aastore
    //   133: invokestatic 296	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   136: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload_0
    //   140: getfield 299	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:b	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserComponentsProvider$SwiftBrowserComponentContext;
    //   143: invokeinterface 304 1 0
    //   148: bipush 254
    //   150: invokevirtual 309	com/tencent/mobileqq/webview/swift/component/SwiftBrowserComponentsProvider:a	(I)Ljava/lang/Object;
    //   153: checkcast 311	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull +295 -> 453
    //   161: aload_1
    //   162: getfield 313	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:c	J
    //   165: lstore 11
    //   167: aload_1
    //   168: getfield 315	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:d	J
    //   171: lstore 9
    //   173: aload_1
    //   174: getfield 318	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:u	J
    //   177: lstore 13
    //   179: aload_1
    //   180: lload_3
    //   181: putfield 320	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:i	J
    //   184: aload_1
    //   185: lload 5
    //   187: putfield 322	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:j	J
    //   190: aload_1
    //   191: lload 7
    //   193: putfield 323	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:h	J
    //   196: goto +3 -> 199
    //   199: aload_1
    //   200: invokestatic 329	com/tencent/mobileqq/vaswebviewplugin/VasBaseWebviewUtil:reportX5SpeedData	(Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics;)V
    //   203: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +257 -> 463
    //   209: ldc_w 331
    //   212: iconst_4
    //   213: anewarray 48	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: lload 9
    //   220: lload 11
    //   222: lsub
    //   223: invokestatic 334	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   226: aastore
    //   227: dup
    //   228: iconst_1
    //   229: lload 13
    //   231: lload 9
    //   233: lsub
    //   234: invokestatic 334	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   237: aastore
    //   238: dup
    //   239: iconst_2
    //   240: lload_3
    //   241: lload 13
    //   243: lsub
    //   244: invokestatic 334	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   247: aastore
    //   248: dup
    //   249: iconst_3
    //   250: lload 5
    //   252: lload_3
    //   253: lsub
    //   254: invokestatic 334	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   257: aastore
    //   258: invokestatic 296	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   261: astore_1
    //   262: ldc 207
    //   264: iconst_2
    //   265: aload_1
    //   266: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: goto +3 -> 272
    //   272: ldc 207
    //   274: astore_1
    //   275: new 198	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   282: astore 15
    //   284: aload 15
    //   286: ldc_w 336
    //   289: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 15
    //   295: lload_3
    //   296: lload 13
    //   298: lsub
    //   299: invokevirtual 339	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload_1
    //   304: iconst_1
    //   305: aload 15
    //   307: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: new 198	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   320: astore 15
    //   322: aload 15
    //   324: ldc_w 341
    //   327: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 15
    //   333: lload 5
    //   335: lload_3
    //   336: lsub
    //   337: invokevirtual 339	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_1
    //   342: iconst_1
    //   343: aload 15
    //   345: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: new 198	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   358: astore 15
    //   360: aload 15
    //   362: ldc_w 343
    //   365: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 15
    //   371: lload 7
    //   373: lload 11
    //   375: lsub
    //   376: invokevirtual 339	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_1
    //   381: iconst_1
    //   382: aload 15
    //   384: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: return
    //   391: ldc 207
    //   393: astore 15
    //   395: astore_1
    //   396: goto +20 -> 416
    //   399: astore_1
    //   400: ldc 207
    //   402: astore 15
    //   404: goto +12 -> 416
    //   407: astore_1
    //   408: goto +4 -> 412
    //   411: astore_1
    //   412: ldc 207
    //   414: astore 15
    //   416: aload 15
    //   418: iconst_2
    //   419: ldc_w 262
    //   422: aload_1
    //   423: invokestatic 346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   426: return
    //   427: return
    //   428: lconst_0
    //   429: lstore_3
    //   430: goto -357 -> 73
    //   433: lconst_0
    //   434: lstore 5
    //   436: goto -345 -> 91
    //   439: lconst_0
    //   440: lstore 7
    //   442: goto -335 -> 107
    //   445: astore_1
    //   446: ldc 207
    //   448: astore 15
    //   450: goto -34 -> 416
    //   453: lconst_0
    //   454: lstore 9
    //   456: lload 9
    //   458: lstore 13
    //   460: goto -261 -> 199
    //   463: goto -191 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	466	0	this	SwiftBrowserTBSHandler
    //   0	466	1	paramBundle	Bundle
    //   56	5	2	bool	boolean
    //   69	361	3	l1	long
    //   86	349	5	l2	long
    //   102	339	7	l3	long
    //   171	286	9	l4	long
    //   58	316	11	l5	long
    //   177	282	13	l6	long
    //   32	417	15	localObject	Object
    //   41	90	16	str	String
    // Exception table:
    //   from	to	target	type
    //   262	269	391	java/lang/Exception
    //   275	390	391	java/lang/Exception
    //   173	196	399	java/lang/Exception
    //   199	262	399	java/lang/Exception
    //   139	157	407	java/lang/Exception
    //   161	167	407	java/lang/Exception
    //   25	57	411	java/lang/Exception
    //   64	70	411	java/lang/Exception
    //   73	88	411	java/lang/Exception
    //   91	104	411	java/lang/Exception
    //   107	139	411	java/lang/Exception
    //   167	173	445	java/lang/Exception
  }
  
  private Object d(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("download_id");
    paramBundle = (DownloadInfo)WebViewOpenSdkApi.a().a(paramBundle);
    Integer localInteger = Integer.valueOf(0);
    if (paramBundle == null) {
      return localInteger;
    }
    int n = paramBundle.a();
    if (n != 2)
    {
      if (n != 3)
      {
        if (n != 4)
        {
          if (n != 10) {
            return localInteger;
          }
          return Integer.valueOf(5);
        }
        return Integer.valueOf(3);
      }
      return Integer.valueOf(2);
    }
    return Integer.valueOf(1);
  }
  
  public Object a(String paramString, Bundle paramBundle)
  {
    if (this.a == null) {
      return null;
    }
    if ("openBrowserList".equals(paramString))
    {
      QLog.d("SwiftBrowserTBSHandler", 1, "XChooserActivity 已在725下架");
      return null;
    }
    Object localObject1;
    if ("addDownloadTask".equals(paramString))
    {
      if (paramBundle == null) {
        return null;
      }
      localObject1 = paramBundle.getString("task_name");
      Object localObject2 = paramBundle.getString("task_url");
      paramString = paramBundle.getString("appid");
      this.i = ((String)localObject2);
      if ((paramString != null) && (localObject1 != null))
      {
        paramBundle = (DownloadInfo)WebViewOpenSdkApi.a().a(paramString);
        if (paramBundle != null)
        {
          localObject2 = paramBundle.d;
          paramBundle = new Bundle();
          paramBundle.putString(DownloadConstants.b, paramString);
          paramBundle.putString(DownloadConstants.j, (String)localObject2);
          paramBundle.putInt(DownloadConstants.k, 2);
          paramBundle.putString(DownloadConstants.l, (String)localObject1);
          paramBundle.putBoolean(DownloadConstants.s, false);
          paramBundle.putBoolean(DownloadConstants.y, false);
          localObject1 = DownloadConstants.m;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("_");
          ((StringBuilder)localObject2).append(paramString);
          paramBundle.putString((String)localObject1, ((StringBuilder)localObject2).toString());
          WebViewOpenSdkApi.a().a(this.a, paramBundle);
          return paramString;
        }
        ThreadManager.post(new SwiftBrowserTBSHandler.3(this, paramString, (String)localObject1), 8, null, true);
      }
      return paramString;
    }
    if ("cancelDownloadTask".equals(paramString))
    {
      paramString = paramBundle.getString("download_id");
      if (!WebViewOpenSdkApi.a().b(paramString)) {
        return Boolean.valueOf(false);
      }
      paramBundle = WebViewOpenSdkApi.a();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(paramString);
      paramBundle.a(paramString, ((StringBuilder)localObject1).toString(), true);
      return Boolean.valueOf(true);
    }
    if ("queryDownloadTask".equals(paramString)) {
      return d(paramBundle);
    }
    if ("installDownloadTask".equals(paramString))
    {
      paramString = paramBundle.getString("download_id");
      paramBundle = (DownloadInfo)WebViewOpenSdkApi.a().a(paramString);
      if ((paramBundle != null) && (paramBundle.a() == 4))
      {
        paramBundle = new Bundle();
        paramBundle.putString(DownloadConstants.b, paramString);
        paramBundle.putInt(DownloadConstants.k, 5);
        paramBundle.putBoolean(DownloadConstants.s, false);
        paramBundle.putBoolean(DownloadConstants.y, false);
        WebViewOpenSdkApi.a().a(this.a, paramBundle);
        return Boolean.valueOf(true);
      }
      return Boolean.valueOf(false);
    }
    if ("notifyQBiconShine".equals(paramString))
    {
      paramString = (SwiftBrowserUIStyleHandler)this.b.d().a(2);
      if (paramString != null)
      {
        paramString.f.K = true;
        if (QLog.isColorLevel())
        {
          QLog.d("SwiftBrowserTBSHandler", 2, "QQBrowser has related content.");
          return null;
        }
      }
    }
    else
    {
      if ("netTimeConsumingReport".equals(paramString))
      {
        c(paramBundle);
        return null;
      }
      if (paramString.equalsIgnoreCase("onReportStgwTime"))
      {
        a(paramBundle);
        return null;
      }
      if ("onNotifyResourceRequestURL".equals(paramString))
      {
        b(paramBundle);
        return null;
      }
      localObject1 = m;
      if (localObject1 != null) {
        ((ISwiftBrowserTBSInjector)localObject1).a(paramString, paramBundle);
      }
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    Activity localActivity = this.b.b();
    if ((localActivity instanceof QQBrowserActivity)) {
      this.a = localActivity;
    } else {
      this.a = null;
    }
    this.c = this.b.c();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    paramBundle = null;
    if (paramInt != 3)
    {
      if (paramInt != 7) {
        return;
      }
      if (!this.j)
      {
        this.j = true;
        Object localObject = m;
        if (localObject != null) {
          ((ISwiftBrowserTBSInjector)localObject).a(this.b);
        }
        localObject = this.c;
        if (localObject != null) {
          paramBundle = ((WebViewProvider)localObject).getWebView();
        }
        if (paramBundle != null)
        {
          paramBundle = (X5ApiPlugin)paramBundle.getPluginEngine().b("x5");
          if (paramBundle != null) {
            paramBundle.b();
          }
        }
      }
    }
    else
    {
      paramBundle = this.f;
      if ((paramBundle != null) && (paramBundle.isShowing())) {
        this.f.dismiss();
      }
      paramBundle = this.k;
      if (paramBundle != null)
      {
        this.a.unregisterReceiver(paramBundle);
        this.k = null;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    VasBaseWebviewUtil.reportVasStatus("WebViewStatus", "x5_preload", "0", 0, 0, paramInt, 0, paramString, "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlePreloadCallback: type=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", url=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SwiftBrowserTBSHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
    if (localObject != null) {
      localObject = ((WebViewProvider)localObject).getWebView();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = (X5ApiPlugin)((CustomWebView)localObject).getPluginEngine().b("x5");
      if (localObject != null) {
        ((X5ApiPlugin)localObject).b(paramInt, paramString);
      }
    }
  }
  
  /* Error */
  void a(Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 262
    //   3: astore 7
    //   5: aload_1
    //   6: ifnull +199 -> 205
    //   9: aload_1
    //   10: ldc 177
    //   12: invokevirtual 182	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   15: ifeq +13 -> 28
    //   18: aload_1
    //   19: ldc 177
    //   21: invokevirtual 186	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_2
    //   25: goto +7 -> 32
    //   28: ldc_w 262
    //   31: astore_2
    //   32: aload_1
    //   33: ldc_w 547
    //   36: invokevirtual 182	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   39: ifeq +14 -> 53
    //   42: aload_1
    //   43: ldc_w 547
    //   46: invokevirtual 186	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore_3
    //   50: goto +7 -> 57
    //   53: ldc_w 262
    //   56: astore_3
    //   57: aload_3
    //   58: astore 6
    //   60: aload_2
    //   61: astore 4
    //   63: aload 7
    //   65: astore 5
    //   67: aload_1
    //   68: ldc_w 549
    //   71: invokevirtual 182	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   74: ifeq +60 -> 134
    //   77: aload_1
    //   78: ldc_w 549
    //   81: invokevirtual 186	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore 5
    //   86: aload_3
    //   87: astore 6
    //   89: aload_2
    //   90: astore 4
    //   92: goto +42 -> 134
    //   95: astore_1
    //   96: goto +18 -> 114
    //   99: astore_1
    //   100: ldc_w 262
    //   103: astore_3
    //   104: goto +10 -> 114
    //   107: astore_1
    //   108: ldc_w 262
    //   111: astore_3
    //   112: aload_3
    //   113: astore_2
    //   114: ldc 207
    //   116: iconst_1
    //   117: ldc_w 551
    //   120: aload_1
    //   121: invokestatic 346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload 7
    //   126: astore 5
    //   128: aload_2
    //   129: astore 4
    //   131: aload_3
    //   132: astore 6
    //   134: new 198	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   141: astore_1
    //   142: aload_1
    //   143: ldc_w 553
    //   146: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_1
    //   151: aload 6
    //   153: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_1
    //   158: ldc_w 555
    //   161: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_1
    //   166: aload 5
    //   168: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_1
    //   173: ldc_w 557
    //   176: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_1
    //   181: aload 4
    //   183: iconst_0
    //   184: anewarray 126	java/lang/String
    //   187: invokestatic 562	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   190: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: ldc 207
    //   196: iconst_1
    //   197: aload_1
    //   198: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: return
    //   205: ldc 207
    //   207: iconst_1
    //   208: ldc_w 564
    //   211: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	SwiftBrowserTBSHandler
    //   0	215	1	paramBundle	Bundle
    //   24	105	2	localObject1	Object
    //   49	83	3	str1	String
    //   61	121	4	localObject2	Object
    //   65	102	5	str2	String
    //   58	94	6	str3	String
    //   3	122	7	str4	String
    // Exception table:
    //   from	to	target	type
    //   67	86	95	java/lang/Throwable
    //   32	50	99	java/lang/Throwable
    //   9	25	107	java/lang/Throwable
  }
  
  void a(String paramString, int paramInt)
  {
    if (paramInt < 12) {
      try
      {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
        localHttpURLConnection.setDoInput(true);
        localHttpURLConnection.setConnectTimeout(20000);
        localHttpURLConnection.setRequestMethod("GET");
        localHttpURLConnection.connect();
        int n = localHttpURLConnection.getResponseCode();
        if ((n != 301) && (n != 302))
        {
          if (n == 200)
          {
            this.h = localHttpURLConnection.getContentLength();
            this.i = localHttpURLConnection.getURL().toString();
          }
        }
        else
        {
          paramString = localHttpURLConnection.getHeaderFields().keySet();
          Object localObject = null;
          Iterator localIterator = paramString.iterator();
          do
          {
            paramString = localObject;
            if (!localIterator.hasNext()) {
              break;
            }
            paramString = (String)localIterator.next();
          } while (!"location".equalsIgnoreCase(paramString));
          paramString = localHttpURLConnection.getHeaderField(paramString);
          if (paramString != null)
          {
            a(MsfSdkUtils.insertMtype("Web", paramString), paramInt + 1);
            return;
          }
        }
        localHttpURLConnection.disconnect();
        return;
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SwiftBrowserTBSHandler", 2, paramString.getMessage());
        }
      }
    }
  }
  
  public void b()
  {
    if (this.c != null)
    {
      if (this.a == null) {
        return;
      }
      Object localObject1 = WebAccelerateHelper.getInstance().getTBSDpcParam();
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      int i1 = 1;
      Object localObject2;
      if (!bool)
      {
        if (((String)localObject1).charAt(0) != '1')
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("warning: disable tbs, ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.i("SwiftBrowserTBSHandler", 2, ((StringBuilder)localObject2).toString());
          }
          n = 0;
          break label105;
        }
      }
      else {
        QLog.e("SwiftBrowserTBSHandler", 1, "error: no dpc param!");
      }
      int n = 1;
      label105:
      if ((a(this.c.getAppRuntime()) != null) && (n != 0))
      {
        if ("CN".equals(Locale.getDefault().getCountry()))
        {
          localObject1 = a(this.c.getAppRuntime());
          if (TbsDownloader.needDownload(BaseApplication.getContext(), false, false, new SwiftBrowserTBSHandler.TbsDownloadCallback((ITbsDownloader)localObject1)))
          {
            a("TBS_update", "tbs need download");
            QbSdk.setUploadCode(BaseApplication.getContext(), 150);
            ((ITbsDownloader)localObject1).a(false);
            n = i1;
            break label247;
          }
          a("TBS_update", "tbs no need download");
          n = i1;
          break label247;
        }
        a("TBS_update", "tbs loc/tz not match");
      }
      else
      {
        a("TBS_update", "tbs update disabled");
      }
      n = 0;
      label247:
      localObject1 = null;
      if (this.b != null) {
        localObject1 = (SwiftBrowserStatistics)this.b.d().a(-2);
      }
      if (((localObject1 != null) && (((SwiftBrowserStatistics)localObject1).as)) || (QLog.isColorLevel()))
      {
        i1 = QbSdk.getTbsVersion(BaseApplication.getContext());
        bool = QLog.isColorLevel();
        String str = "sys";
        if (bool)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("tbs current webview:");
          if (i1 == 0)
          {
            localObject2 = "sys";
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("x5_");
            ((StringBuilder)localObject2).append(i1);
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          localStringBuilder.append((String)localObject2);
          QLog.d("TBS_update", 2, localStringBuilder.toString());
        }
        if ((localObject1 != null) && (((SwiftBrowserStatistics)localObject1).as))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("tbs_cover_");
          if (n != 0)
          {
            localObject1 = str;
            if (i1 > 0) {
              localObject1 = "tbs";
            }
          }
          else
          {
            localObject1 = "dis";
          }
          ((StringBuilder)localObject2).append((String)localObject1);
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", ((StringBuilder)localObject2).toString(), 0, 1, i1, "", "", "", "");
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 104: 
      paramMessage = (String)paramMessage.obj;
      localObject1 = this.f;
      if ((localObject1 != null) && (((Dialog)localObject1).isShowing()) && (paramMessage != null))
      {
        ((TextView)this.f.findViewById(2131449094)).setText(paramMessage);
        return true;
      }
      break;
    case 103: 
      paramMessage = (Drawable)paramMessage.obj;
      localObject1 = this.f;
      if ((localObject1 != null) && (((Dialog)localObject1).isShowing()) && (paramMessage != null))
      {
        localObject1 = (ImageView)this.f.findViewById(2131449092);
        ((ImageView)localObject1).setImageDrawable(null);
        ((ImageView)localObject1).setImageDrawable(paramMessage);
        return true;
      }
      break;
    case 102: 
      ThreadManager.post(new SwiftBrowserTBSHandler.2(this), 8, null, true);
      return true;
    case 101: 
      if (!this.a.isFinishing())
      {
        localObject1 = this.c;
        if ((localObject1 != null) && (!((WebViewProvider)localObject1).isDestroyed()))
        {
          paramMessage = (Bundle)paramMessage.obj;
          WebViewOpenSdkApi.a().a(paramMessage, this.a, this.c.getWebView().getUrl(), this.c.getWebView().getSettings().getUserAgentString());
          ((SwiftBrowserUIStyleHandler)this.c.getComponentProvider().a(2)).B.setVisibility(8);
          return true;
        }
      }
      break;
    case 100: 
      paramMessage = (String)paramMessage.obj;
    }
    try
    {
      paramMessage = new JSONObject(paramMessage);
      localObject1 = paramMessage.getJSONObject("icon");
      Object localObject2 = paramMessage.getJSONObject("content");
      paramMessage = ((JSONObject)localObject1).getString("timestamp");
      localObject1 = ((JSONObject)localObject1).getString("url");
      String str = ((JSONObject)localObject2).getString("timestamp");
      localObject2 = ((JSONObject)localObject2).getString("memo");
      Object localObject3 = BaseApplication.getContext().getSharedPreferences("qb_info", 0);
      if (localObject3 != null)
      {
        localObject3 = ((SharedPreferences)localObject3).edit();
        ((SharedPreferences.Editor)localObject3).putString("icon_time", paramMessage);
        ((SharedPreferences.Editor)localObject3).putString("icon_url", (String)localObject1);
        ((SharedPreferences.Editor)localObject3).putString("content_time", str);
        ((SharedPreferences.Editor)localObject3).putString("content_memo", (String)localObject2);
        ((SharedPreferences.Editor)localObject3).commit();
      }
      return true;
    }
    catch (Exception paramMessage) {}
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler
 * JD-Core Version:    0.7.0.1
 */