package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.i;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

public class WebView
  extends FrameLayout
  implements View.OnLongClickListener
{
  public static final int GETPVERROR = -1;
  public static int NIGHT_MODE_ALPHA = 153;
  public static final int NIGHT_MODE_COLOR = -16777216;
  public static final int NORMAL_MODE_ALPHA = 255;
  public static final String SCHEME_GEO = "geo:0,0?q=";
  public static final String SCHEME_MAILTO = "mailto:";
  public static final String SCHEME_TEL = "tel:";
  private static final Lock c = new ReentrantLock();
  private static OutputStream d = null;
  private static Context j = null;
  public static boolean mSysWebviewCreated;
  public static boolean mWebViewCreated;
  private static BroadcastReceiver n = null;
  private static com.tencent.smtt.utils.m o;
  private static Method p;
  private static String s;
  private static Paint y;
  private static boolean z;
  private Object A = null;
  private View.OnLongClickListener B = null;
  int a = 0;
  private final String b = "WebView";
  private boolean e = false;
  private IX5WebViewBase f;
  private WebView.b g;
  private WebSettings h = null;
  private Context i = null;
  private boolean k = false;
  private m l = null;
  private boolean m = false;
  public WebViewCallbackClient mWebViewCallbackClient;
  private WebViewClient q = null;
  private WebChromeClient r = null;
  private final int t = 1;
  private final int u = 2;
  private final int v = 3;
  private final String w = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
  private final String x = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
  
  static
  {
    mWebViewCreated = false;
    o = null;
    p = null;
    s = null;
    mSysWebviewCreated = false;
    y = null;
    z = true;
  }
  
  public WebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, false);
  }
  
  @TargetApi(11)
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, Map<String, Object> paramMap, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt);
    mWebViewCreated = true;
    this.l = new m();
    this.l.a("init_all", (byte)1);
    if ((QbSdk.getIsSysWebViewForcedByOuter()) && (TbsShareManager.isThirdPartyApp(paramContext)))
    {
      this.i = paramContext;
      this.f = null;
      this.e = false;
      QbSdk.a(paramContext, "failed to createTBSWebview!");
      this.g = new WebView.b(this, paramContext, paramAttributeSet);
      CookieManager.getInstance().a(paramContext, true, false);
      CookieSyncManager.createInstance(this.i).startSync();
    }
    try
    {
      paramAttributeSet = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
      paramAttributeSet.setAccessible(true);
      ((Handler)paramAttributeSet.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new e());
      mSysWebviewCreated = true;
      label239:
      CookieManager.getInstance().a();
      this.g.setFocusableInTouchMode(true);
      addView(this.g, new FrameLayout.LayoutParams(-1, -1));
      TbsLog.i("WebView", "SystemWebView Created Success! #3");
      TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
      TbsCoreLoadStat.getInstance().a(paramContext, 402, new Throwable());
      return;
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsLog.setWriteLogJIT(true);
      }
      for (;;)
      {
        this.l.a("tbslog_init", (byte)1);
        TbsLog.initIfNeed(paramContext);
        this.l.a("tbslog_init", (byte)2);
        if (paramContext != null) {
          break;
        }
        throw new IllegalArgumentException("Invalid context argument");
        TbsLog.setWriteLogJIT(false);
      }
      if (o == null) {
        o = com.tencent.smtt.utils.m.a(paramContext);
      }
      if (o.a)
      {
        TbsLog.e("WebView", "sys WebView: debug.conf force syswebview", true);
        QbSdk.a(paramContext, "debug.conf force syswebview!");
      }
      a(paramContext, this.l);
      this.i = paramContext;
      if (paramContext != null) {
        j = paramContext.getApplicationContext();
      }
      if ((this.e) && (!QbSdk.a))
      {
        this.l.a("init_x5_webview", (byte)1);
        this.f = v.a().a(true).a(paramContext);
        this.l.a("init_x5_webview", (byte)2);
        if ((this.f == null) || (this.f.getView() == null))
        {
          TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
          this.f = null;
          this.e = false;
          QbSdk.a(paramContext, "failed to createTBSWebview!");
          a(paramContext, this.l);
          if (TbsShareManager.isThirdPartyApp(this.i)) {
            this.g = new WebView.b(this, paramContext, paramAttributeSet);
          }
          for (;;)
          {
            TbsLog.i("WebView", "SystemWebView Created Success! #1");
            CookieManager.getInstance().a(paramContext, true, false);
            CookieManager.getInstance().a();
            this.g.setFocusableInTouchMode(true);
            addView(this.g, new FrameLayout.LayoutParams(-1, -1));
            try
            {
              if (Build.VERSION.SDK_INT >= 11)
              {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
              }
              b(paramContext);
              TbsLog.writeLogToDisk();
              n.a(paramContext);
              return;
              this.g = new WebView.b(this, paramContext);
            }
            catch (Throwable paramAttributeSet)
            {
              for (;;)
              {
                paramAttributeSet.printStackTrace();
              }
            }
          }
        }
        TbsLog.i("WebView", "X5 WebView Created Success!!");
        this.f.getView().setFocusableInTouchMode(true);
        a(paramAttributeSet);
        addView(this.f.getView(), new FrameLayout.LayoutParams(-1, -1));
        this.f.setDownloadListener(new b(this, null, this.e));
        this.f.getX5WebViewExtension().setWebViewClientExtension(new WebView.1(this, v.a().a(true).k()));
      }
      try
      {
        if (Build.VERSION.SDK_INT >= 11)
        {
          removeJavascriptInterface("searchBoxJavaBridge_");
          removeJavascriptInterface("accessibility");
          removeJavascriptInterface("accessibilityTraversal");
        }
        if ((("com.tencent.mobileqq".equals(this.i.getApplicationInfo().packageName)) || ("com.tencent.mm".equals(this.i.getApplicationInfo().packageName))) && (d.a(true).g()) && (Build.VERSION.SDK_INT >= 11)) {
          setLayerType(1, null);
        }
        if (this.f != null)
        {
          TbsLog.writeLogToDisk();
          if (!TbsShareManager.isThirdPartyApp(paramContext))
          {
            paramInt = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
            if ((paramInt <= 0) || (paramInt == n.a().h(paramContext)) || (paramInt != n.a().i(paramContext))) {
              break label1083;
            }
            n.a().n(paramContext);
          }
        }
        if (this.l != null)
        {
          this.l.a("load_url_gap", (byte)1);
          this.l.a("init_all", (byte)2);
        }
        QbSdk.continueLoadSo(paramContext);
        return;
        this.f = null;
        if (TbsShareManager.isThirdPartyApp(this.i)) {}
        for (this.g = new WebView.b(this, paramContext, paramAttributeSet);; this.g = new WebView.b(this, paramContext))
        {
          TbsLog.i("WebView", "SystemWebView Created Success! #2");
          CookieManager.getInstance().a(paramContext, true, false);
          CookieManager.getInstance().a();
          this.g.setFocusableInTouchMode(true);
          addView(this.g, new FrameLayout.LayoutParams(-1, -1));
          setDownloadListener(null);
          b(paramContext);
          TbsLog.writeLogToDisk();
          n.a(paramContext);
          break;
        }
      }
      catch (Throwable paramAttributeSet)
      {
        for (;;)
        {
          paramAttributeSet.printStackTrace();
          continue;
          label1083:
          TbsLog.i("WebView", "webview construction #1 deCoupleCoreVersion is " + paramInt + " getTbsCoreShareDecoupleCoreVersion is " + n.a().h(paramContext) + " getTbsCoreInstalledVerInNolock is " + n.a().i(paramContext));
        }
      }
    }
    catch (Exception paramAttributeSet)
    {
      break label239;
    }
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    this(paramContext, paramAttributeSet, paramInt, null, paramBoolean);
  }
  
  public WebView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
  }
  
  private void a(Context paramContext, m paramm)
  {
    if ((QbSdk.i) && (TbsShareManager.isThirdPartyApp(paramContext))) {
      TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(paramContext);
    }
    if (paramm != null) {
      paramm.a("x5_core_engine_init_sync", (byte)1);
    }
    v localv = v.a();
    localv.a(paramContext, paramm);
    this.e = localv.b();
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    int i1 = 0;
    if (paramAttributeSet != null) {}
    for (;;)
    {
      int[] arrayOfInt;
      int i3;
      try
      {
        int i2 = paramAttributeSet.getAttributeCount();
        if (i1 < i2)
        {
          if (!paramAttributeSet.getAttributeName(i1).equalsIgnoreCase("scrollbars")) {
            break label147;
          }
          arrayOfInt = getResources().getIntArray(16842974);
          i3 = paramAttributeSet.getAttributeIntValue(i1, -1);
          if (i3 == arrayOfInt[1])
          {
            this.f.getView().setVerticalScrollBarEnabled(false);
            this.f.getView().setHorizontalScrollBarEnabled(false);
          }
          else if (i3 == arrayOfInt[2])
          {
            this.f.getView().setVerticalScrollBarEnabled(false);
          }
        }
      }
      catch (Exception paramAttributeSet)
      {
        paramAttributeSet.printStackTrace();
      }
      return;
      if (i3 == arrayOfInt[3]) {
        this.f.getView().setHorizontalScrollBarEnabled(false);
      }
      label147:
      i1 += 1;
    }
  }
  
  private boolean a(View paramView)
  {
    if ((this.i != null) && (getTbsCoreVersion(this.i) > 36200)) {
      return false;
    }
    paramView = i.a(this.A, "onLongClick", new Class[] { View.class }, new Object[] { paramView });
    if (paramView != null) {
      return ((Boolean)paramView).booleanValue();
    }
    return false;
  }
  
  private void b(Context paramContext)
  {
    if (n != null) {
      return;
    }
    n = new WebView.a(null);
    new WebView.2(this, paramContext).start();
  }
  
  private boolean c(Context paramContext)
  {
    try
    {
      int i1 = paramContext.getPackageName().indexOf("com.tencent.mobileqq");
      if (i1 >= 0) {
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private Context d(Context paramContext)
  {
    Context localContext = paramContext;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localContext = paramContext;
      if (Build.VERSION.SDK_INT <= 22) {
        localContext = paramContext.createConfigurationContext(new Configuration());
      }
    }
    return localContext;
  }
  
  static void d()
  {
    WebView.9 local9 = new WebView.9();
    try
    {
      new Thread(local9).start();
      return;
    }
    catch (Throwable localThrowable)
    {
      TbsLog.e("webview", "updateRebootStatus excpetion: " + localThrowable);
    }
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    if (!v.a().b()) {
      i.a("android.webkit.WebView", "disablePlatformNotifications");
    }
  }
  
  /* Error */
  private int e(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: ldc_w 654
    //   5: invokestatic 659	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   8: astore 6
    //   10: aload 6
    //   12: ifnull +16 -> 28
    //   15: aload_1
    //   16: aload 6
    //   18: invokestatic 662	com/tencent/smtt/utils/FileUtil:a	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   21: astore 7
    //   23: aload 7
    //   25: ifnonnull +5 -> 30
    //   28: iconst_m1
    //   29: ireturn
    //   30: getstatic 82	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   33: invokeinterface 667 1 0
    //   38: ifeq +472 -> 510
    //   41: aconst_null
    //   42: astore 5
    //   44: aload_1
    //   45: invokestatic 671	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   48: astore_1
    //   49: new 673	java/io/File
    //   52: dup
    //   53: new 494	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   60: aload_1
    //   61: invokevirtual 639	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   64: getstatic 676	java/io/File:separator	Ljava/lang/String;
    //   67: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc_w 678
    //   73: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: ldc_w 680
    //   82: invokespecial 682	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +12 -> 99
    //   90: aload_1
    //   91: invokevirtual 685	java/io/File:exists	()Z
    //   94: istore_3
    //   95: iload_3
    //   96: ifne +65 -> 161
    //   99: iconst_0
    //   100: ifeq +11 -> 111
    //   103: new 687	java/lang/NullPointerException
    //   106: dup
    //   107: invokespecial 688	java/lang/NullPointerException:<init>	()V
    //   110: athrow
    //   111: getstatic 82	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   114: invokeinterface 691 1 0
    //   119: aload 7
    //   121: aload 6
    //   123: invokestatic 694	com/tencent/smtt/utils/FileUtil:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   126: iconst_m1
    //   127: ireturn
    //   128: astore_1
    //   129: ldc_w 696
    //   132: new 494	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 698
    //   142: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_1
    //   146: invokevirtual 699	java/io/IOException:toString	()Ljava/lang/String;
    //   149: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 641	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: goto -47 -> 111
    //   161: new 701	java/util/Properties
    //   164: dup
    //   165: invokespecial 702	java/util/Properties:<init>	()V
    //   168: astore 8
    //   170: new 704	java/io/FileInputStream
    //   173: dup
    //   174: aload_1
    //   175: invokespecial 707	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   178: astore 4
    //   180: aload 4
    //   182: astore_1
    //   183: aload 8
    //   185: aload 4
    //   187: invokevirtual 711	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   190: aload 4
    //   192: astore_1
    //   193: aload 4
    //   195: invokevirtual 714	java/io/FileInputStream:close	()V
    //   198: aload 4
    //   200: astore_1
    //   201: aload 8
    //   203: ldc_w 716
    //   206: invokevirtual 720	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   209: astore 5
    //   211: aload 5
    //   213: ifnonnull +63 -> 276
    //   216: aload 4
    //   218: ifnull +8 -> 226
    //   221: aload 4
    //   223: invokevirtual 714	java/io/FileInputStream:close	()V
    //   226: getstatic 82	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   229: invokeinterface 691 1 0
    //   234: aload 7
    //   236: aload 6
    //   238: invokestatic 694	com/tencent/smtt/utils/FileUtil:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   241: iconst_m1
    //   242: ireturn
    //   243: astore_1
    //   244: ldc_w 696
    //   247: new 494	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 698
    //   257: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_1
    //   261: invokevirtual 699	java/io/IOException:toString	()Ljava/lang/String;
    //   264: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 641	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: goto -47 -> 226
    //   276: aload 4
    //   278: astore_1
    //   279: aload 5
    //   281: invokestatic 725	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   284: istore_2
    //   285: aload 4
    //   287: ifnull +8 -> 295
    //   290: aload 4
    //   292: invokevirtual 714	java/io/FileInputStream:close	()V
    //   295: getstatic 82	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   298: invokeinterface 691 1 0
    //   303: aload 7
    //   305: aload 6
    //   307: invokestatic 694	com/tencent/smtt/utils/FileUtil:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   310: iload_2
    //   311: ireturn
    //   312: astore_1
    //   313: ldc_w 696
    //   316: new 494	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   323: ldc_w 698
    //   326: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_1
    //   330: invokevirtual 699	java/io/IOException:toString	()Ljava/lang/String;
    //   333: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 641	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: goto -47 -> 295
    //   345: astore 5
    //   347: aconst_null
    //   348: astore 4
    //   350: aload 4
    //   352: astore_1
    //   353: ldc_w 696
    //   356: new 494	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   363: ldc_w 727
    //   366: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload 5
    //   371: invokevirtual 728	java/lang/Exception:toString	()Ljava/lang/String;
    //   374: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 641	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload 4
    //   385: ifnull +8 -> 393
    //   388: aload 4
    //   390: invokevirtual 714	java/io/FileInputStream:close	()V
    //   393: getstatic 82	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   396: invokeinterface 691 1 0
    //   401: aload 7
    //   403: aload 6
    //   405: invokestatic 694	com/tencent/smtt/utils/FileUtil:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   408: iconst_m1
    //   409: ireturn
    //   410: astore_1
    //   411: ldc_w 696
    //   414: new 494	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 698
    //   424: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_1
    //   428: invokevirtual 699	java/io/IOException:toString	()Ljava/lang/String;
    //   431: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 641	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: goto -47 -> 393
    //   443: astore_1
    //   444: aload 5
    //   446: astore 4
    //   448: aload 4
    //   450: ifnull +8 -> 458
    //   453: aload 4
    //   455: invokevirtual 714	java/io/FileInputStream:close	()V
    //   458: getstatic 82	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   461: invokeinterface 691 1 0
    //   466: aload 7
    //   468: aload 6
    //   470: invokestatic 694	com/tencent/smtt/utils/FileUtil:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   473: aload_1
    //   474: athrow
    //   475: astore 4
    //   477: ldc_w 696
    //   480: new 494	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   487: ldc_w 698
    //   490: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: aload 4
    //   495: invokevirtual 699	java/io/IOException:toString	()Ljava/lang/String;
    //   498: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokestatic 641	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: goto -49 -> 458
    //   510: aload 7
    //   512: aload 6
    //   514: invokestatic 694	com/tencent/smtt/utils/FileUtil:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   517: iconst_m1
    //   518: ireturn
    //   519: astore 5
    //   521: aload_1
    //   522: astore 4
    //   524: aload 5
    //   526: astore_1
    //   527: goto -79 -> 448
    //   530: astore 5
    //   532: goto -182 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	535	0	this	WebView
    //   0	535	1	paramContext	Context
    //   284	27	2	i1	int
    //   94	2	3	bool	boolean
    //   178	276	4	localObject1	Object
    //   475	19	4	localIOException	java.io.IOException
    //   522	1	4	localContext	Context
    //   42	238	5	str	String
    //   345	100	5	localException1	Exception
    //   519	6	5	localObject2	Object
    //   530	1	5	localException2	Exception
    //   8	505	6	localFileOutputStream	java.io.FileOutputStream
    //   21	490	7	localFileLock	java.nio.channels.FileLock
    //   168	34	8	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   103	111	128	java/io/IOException
    //   221	226	243	java/io/IOException
    //   290	295	312	java/io/IOException
    //   44	86	345	java/lang/Exception
    //   90	95	345	java/lang/Exception
    //   161	180	345	java/lang/Exception
    //   388	393	410	java/io/IOException
    //   44	86	443	finally
    //   90	95	443	finally
    //   161	180	443	finally
    //   453	458	475	java/io/IOException
    //   183	190	519	finally
    //   193	198	519	finally
    //   201	211	519	finally
    //   279	285	519	finally
    //   353	383	519	finally
    //   183	190	530	java/lang/Exception
    //   193	198	530	java/lang/Exception
    //   201	211	530	java/lang/Exception
    //   279	285	530	java/lang/Exception
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    if (!v.a().b()) {
      i.a("android.webkit.WebView", "enablePlatformNotifications");
    }
  }
  
  private void f(Context paramContext)
  {
    try
    {
      paramContext = QbSdk.getTbsFolderDir(paramContext);
      paramContext = new File(paramContext + File.separator + "core_private", "pv.db");
      if (paramContext != null)
      {
        if (!paramContext.exists()) {
          return;
        }
        paramContext.delete();
        return;
      }
    }
    catch (Exception paramContext)
    {
      TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + paramContext.toString());
    }
  }
  
  public static String findAddress(String paramString)
  {
    if (!v.a().b()) {
      return android.webkit.WebView.findAddress(paramString);
    }
    return null;
  }
  
  public static String getCrashExtraMessage(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    String str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(paramContext) + ";" + "tbs_sdk_version:" + 43936 + ";";
    if ("com.tencent.mm".equals(paramContext.getApplicationInfo().packageName)) {}
    for (;;)
    {
      try
      {
        Class.forName("de.robv.android.xposed.XposedBridge");
        i1 = 1;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        i1 = 0;
        continue;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        i1 = 0;
        continue;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(d.a(true).d());
        localStringBuilder.append("\n");
        localStringBuilder.append(str);
        if ((TbsShareManager.isThirdPartyApp(paramContext)) || (QbSdk.n == null) || (!QbSdk.n.containsKey("weapp_id")) || (!QbSdk.n.containsKey("weapp_name"))) {
          continue;
        }
        paramContext = "weapp_id:" + QbSdk.n.get("weapp_id") + ";" + "weapp_name" + ":" + QbSdk.n.get("weapp_name") + ";";
        localStringBuilder.append("\n");
        localStringBuilder.append(paramContext);
        if (localStringBuilder.length() <= 8192) {
          continue;
        }
        return localStringBuilder.substring(localStringBuilder.length() - 8192);
        return localStringBuilder.toString();
      }
      if (i1 != 0) {
        return str + "isXposed=true;";
      }
      int i1 = 0;
    }
  }
  
  public static PackageInfo getCurrentWebViewPackage()
  {
    if (!v.a().b())
    {
      if (Build.VERSION.SDK_INT < 26) {
        return null;
      }
      try
      {
        PackageInfo localPackageInfo = (PackageInfo)i.a("android.webkit.WebView", "getCurrentWebViewPackage");
        return localPackageInfo;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  /* Error */
  @Deprecated
  public static Object getPluginList()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 343	com/tencent/smtt/sdk/v:a	()Lcom/tencent/smtt/sdk/v;
    //   6: invokevirtual 540	com/tencent/smtt/sdk/v:b	()Z
    //   9: ifne +18 -> 27
    //   12: ldc_w 645
    //   15: ldc_w 796
    //   18: invokestatic 649	com/tencent/smtt/utils/i:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   21: astore_0
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: aconst_null
    //   28: astore_0
    //   29: goto -7 -> 22
    //   32: astore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	8	0	localObject1	Object
    //   32	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	22	32	finally
  }
  
  public static int getTbsCoreVersion(Context paramContext)
  {
    return QbSdk.getTbsVersion(paramContext);
  }
  
  public static boolean getTbsNeedReboot()
  {
    d();
    return d.a(true).e();
  }
  
  public static int getTbsSDKVersion(Context paramContext)
  {
    return 43936;
  }
  
  private long i()
  {
    synchronized (QbSdk.h)
    {
      if (QbSdk.e)
      {
        QbSdk.g += System.currentTimeMillis() - QbSdk.f;
        TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.g);
      }
      long l1 = QbSdk.g / 1000L;
      QbSdk.g = 0L;
      QbSdk.f = System.currentTimeMillis();
      return l1;
    }
  }
  
  public static void setDataDirectorySuffix(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 28) {}
    try
    {
      i.a(Class.forName("android.webkit.WebView"), "setDataDirectorySuffix", new Class[] { String.class }, new Object[] { paramString });
      HashMap localHashMap = new HashMap();
      localHashMap.put("data_directory_suffix", paramString);
      QbSdk.initTbsSettings(localHashMap);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void setSysDayOrNight(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = z;
        if (paramBoolean == bool) {
          return;
        }
        z = paramBoolean;
        if (y == null)
        {
          y = new Paint();
          y.setColor(-16777216);
        }
        if (!paramBoolean)
        {
          if (y.getAlpha() == NIGHT_MODE_ALPHA) {
            continue;
          }
          y.setAlpha(NIGHT_MODE_ALPHA);
          continue;
        }
        if (y.getAlpha() == 255) {
          continue;
        }
      }
      finally {}
      y.setAlpha(255);
    }
  }
  
  public static void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    v localv = v.a();
    if ((localv != null) && (localv.b())) {
      localv.c().a(paramBoolean);
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 19) {
        try
        {
          p = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", new Class[] { Boolean.TYPE });
          if (p != null)
          {
            p.setAccessible(true);
            p.invoke(null, new Object[] { Boolean.valueOf(paramBoolean) });
            return;
          }
        }
        catch (Exception localException)
        {
          TbsLog.e("QbSdk", "Exception:" + localException.getStackTrace());
          localException.printStackTrace();
        }
      }
    }
  }
  
  protected void a()
  {
    String str3;
    String str2;
    String str1;
    if ((!this.k) && (this.a != 0))
    {
      this.k = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      str3 = str4;
      str2 = str5;
      str1 = str6;
      if (this.e)
      {
        Bundle localBundle = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo();
        str3 = str4;
        str2 = str5;
        str1 = str6;
        if (localBundle != null)
        {
          str3 = localBundle.getString("guid");
          str2 = localBundle.getString("qua2");
          str1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.i.getApplicationInfo().packageName))
      {
        int i2 = e(this.i);
        int i1 = i2;
        if (i2 == -1) {
          i1 = this.a;
        }
        this.a = i1;
        f(this.i);
      }
    }
    try
    {
      bool = this.f.getX5WebViewExtension().isX5CoreSandboxMode();
      com.tencent.smtt.sdk.stat.b.a(this.i, str3, str2, str1, this.a, this.e, i(), bool);
      this.a = 0;
      this.k = false;
      super.onDetachedFromWindow();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TbsLog.w("tbsOnDetachedFromWindow", "exception: " + localThrowable);
        boolean bool = false;
      }
    }
  }
  
  /* Error */
  void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 904	com/tencent/smtt/sdk/WebView:e	(Landroid/content/Context;)I
    //   5: istore_2
    //   6: iload_2
    //   7: iconst_m1
    //   8: if_icmpeq +76 -> 84
    //   11: new 494	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 927
    //   21: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_2
    //   25: iconst_1
    //   26: iadd
    //   27: invokestatic 929	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   30: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_3
    //   37: aload_1
    //   38: invokestatic 671	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   41: astore_1
    //   42: new 673	java/io/File
    //   45: dup
    //   46: new 494	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   53: aload_1
    //   54: invokevirtual 639	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: getstatic 676	java/io/File:separator	Ljava/lang/String;
    //   60: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc_w 678
    //   66: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: ldc_w 680
    //   75: invokespecial 682	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: astore_1
    //   79: aload_1
    //   80: ifnonnull +11 -> 91
    //   83: return
    //   84: ldc_w 931
    //   87: astore_3
    //   88: goto -51 -> 37
    //   91: aload_1
    //   92: invokevirtual 935	java/io/File:getParentFile	()Ljava/io/File;
    //   95: invokevirtual 938	java/io/File:mkdirs	()Z
    //   98: pop
    //   99: aload_1
    //   100: invokevirtual 941	java/io/File:isFile	()Z
    //   103: ifeq +10 -> 113
    //   106: aload_1
    //   107: invokevirtual 685	java/io/File:exists	()Z
    //   110: ifne +8 -> 118
    //   113: aload_1
    //   114: invokevirtual 944	java/io/File:createNewFile	()Z
    //   117: pop
    //   118: new 946	java/io/FileOutputStream
    //   121: dup
    //   122: aload_1
    //   123: iconst_0
    //   124: invokespecial 949	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   127: putstatic 84	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   130: getstatic 84	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   133: aload_3
    //   134: invokevirtual 953	java/lang/String:getBytes	()[B
    //   137: invokevirtual 959	java/io/OutputStream:write	([B)V
    //   140: getstatic 84	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   143: ifnull -60 -> 83
    //   146: getstatic 84	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   149: invokevirtual 962	java/io/OutputStream:flush	()V
    //   152: return
    //   153: astore_1
    //   154: getstatic 84	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   157: ifnull +9 -> 166
    //   160: getstatic 84	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   163: invokevirtual 962	java/io/OutputStream:flush	()V
    //   166: aload_1
    //   167: athrow
    //   168: astore_1
    //   169: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	WebView
    //   0	170	1	paramContext	Context
    //   5	22	2	i1	int
    //   36	98	3	str	String
    // Exception table:
    //   from	to	target	type
    //   91	113	153	finally
    //   113	118	153	finally
    //   118	140	153	finally
    //   140	152	168	java/lang/Throwable
    //   154	166	168	java/lang/Throwable
    //   166	168	168	java/lang/Throwable
  }
  
  void a(android.webkit.WebView paramWebView)
  {
    if (!this.e) {}
  }
  
  void a(IX5WebViewBase paramIX5WebViewBase)
  {
    this.f = paramIX5WebViewBase;
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    if (!this.e)
    {
      this.g.addJavascriptInterface(paramObject, paramString);
      return;
    }
    this.f.addJavascriptInterface(paramObject, paramString);
  }
  
  public void addView(View paramView)
  {
    if (!this.e)
    {
      this.g.addView(paramView);
      return;
    }
    View localView = this.f.getView();
    try
    {
      Method localMethod = i.a(localView, "addView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    catch (Throwable paramView) {}
  }
  
  android.webkit.WebView b()
  {
    if (!this.e) {
      return this.g;
    }
    return null;
  }
  
  IX5WebViewBase c()
  {
    return this.f;
  }
  
  public boolean canGoBack()
  {
    if (!this.e) {
      return this.g.canGoBack();
    }
    return this.f.canGoBack();
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    if (!this.e) {
      return this.g.canGoBackOrForward(paramInt);
    }
    return this.f.canGoBackOrForward(paramInt);
  }
  
  public boolean canGoForward()
  {
    if (!this.e) {
      return this.g.canGoForward();
    }
    return this.f.canGoForward();
  }
  
  @Deprecated
  public boolean canZoomIn()
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = i.a(this.g, "canZoomIn");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.f.canZoomIn();
  }
  
  @Deprecated
  public boolean canZoomOut()
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = i.a(this.g, "canZoomOut");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.f.canZoomOut();
  }
  
  @Deprecated
  public Picture capturePicture()
  {
    if (!this.e)
    {
      Object localObject = i.a(this.g, "capturePicture");
      if (localObject == null) {
        return null;
      }
      return (Picture)localObject;
    }
    return this.f.capturePicture();
  }
  
  public void clearCache(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.g.clearCache(paramBoolean);
      return;
    }
    this.f.clearCache(paramBoolean);
  }
  
  public void clearFormData()
  {
    if (!this.e)
    {
      this.g.clearFormData();
      return;
    }
    this.f.clearFormData();
  }
  
  public void clearHistory()
  {
    if (!this.e)
    {
      this.g.clearHistory();
      return;
    }
    this.f.clearHistory();
  }
  
  @TargetApi(3)
  public void clearMatches()
  {
    if (!this.e)
    {
      this.g.clearMatches();
      return;
    }
    this.f.clearMatches();
  }
  
  public void clearSslPreferences()
  {
    if (!this.e)
    {
      this.g.clearSslPreferences();
      return;
    }
    this.f.clearSslPreferences();
  }
  
  @Deprecated
  public void clearView()
  {
    if (!this.e)
    {
      i.a(this.g, "clearView");
      return;
    }
    this.f.clearView();
  }
  
  public int computeHorizontalScrollExtent()
  {
    try
    {
      if (this.e)
      {
        localMethod = i.a(this.f.getView(), "computeHorizontalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
      }
      Method localMethod = i.a(this.g, "computeHorizontalScrollExtent", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public int computeHorizontalScrollOffset()
  {
    try
    {
      if (this.e)
      {
        localMethod = i.a(this.f.getView(), "computeHorizontalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
      }
      Method localMethod = i.a(this.g, "computeHorizontalScrollOffset", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public int computeHorizontalScrollRange()
  {
    try
    {
      if (this.e) {
        return ((Integer)i.a(this.f.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
      }
      Method localMethod = i.a(this.g, "computeHorizontalScrollRange", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public void computeScroll()
  {
    if (!this.e)
    {
      this.g.computeScroll();
      return;
    }
    this.f.computeScroll();
  }
  
  public int computeVerticalScrollExtent()
  {
    try
    {
      if (this.e)
      {
        localMethod = i.a(this.f.getView(), "computeVerticalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
      }
      Method localMethod = i.a(this.g, "computeVerticalScrollExtent", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public int computeVerticalScrollOffset()
  {
    try
    {
      if (this.e)
      {
        localMethod = i.a(this.f.getView(), "computeVerticalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
      }
      Method localMethod = i.a(this.g, "computeVerticalScrollOffset", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public int computeVerticalScrollRange()
  {
    try
    {
      if (this.e) {
        return ((Integer)i.a(this.f.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
      }
      Method localMethod = i.a(this.g, "computeVerticalScrollRange", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    if (this.e) {
      return WebBackForwardList.a(this.f.copyBackForwardList());
    }
    return WebBackForwardList.a(this.g.copyBackForwardList());
  }
  
  public Object createPrintDocumentAdapter(String paramString)
  {
    Object localObject = null;
    if (this.e) {}
    while (Build.VERSION.SDK_INT < 21) {
      try
      {
        localObject = this.f.createPrintDocumentAdapter(paramString);
        return localObject;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    return i.a(this.g, "createPrintDocumentAdapter", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void customDiskCachePathEnabled(boolean paramBoolean, String paramString)
  {
    if ((this.e) && (getX5WebViewExtension() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("enabled", paramBoolean);
      localBundle.putString("path", paramString);
      getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", localBundle);
    }
  }
  
  public void destroy()
  {
    try
    {
      if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName))
      {
        new WebView.3(this, "WebviewDestroy").start();
        if (this.e)
        {
          this.f.destroy();
          return;
        }
        this.g.destroy();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      tbsWebviewDestroy(true);
      return;
    }
    tbsWebviewDestroy(true);
  }
  
  public void documentHasImages(Message paramMessage)
  {
    if (!this.e)
    {
      this.g.documentHasImages(paramMessage);
      return;
    }
    this.f.documentHasImages(paramMessage);
  }
  
  public void dumpViewHierarchyWithProperties(BufferedWriter paramBufferedWriter, int paramInt)
  {
    if (!this.e)
    {
      i.a(this.g, "dumpViewHierarchyWithProperties", new Class[] { BufferedWriter.class, Integer.TYPE }, new Object[] { paramBufferedWriter, Integer.valueOf(paramInt) });
      return;
    }
    this.f.dumpViewHierarchyWithProperties(paramBufferedWriter, paramInt);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if (this.e) {}
    Method localMethod;
    while (Build.VERSION.SDK_INT < 19) {
      try
      {
        localMethod = i.a(this.f.getView(), "evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
        localMethod.setAccessible(true);
        localMethod.invoke(this.f.getView(), new Object[] { paramString, paramValueCallback });
        return;
      }
      catch (Exception paramValueCallback)
      {
        paramValueCallback.printStackTrace();
        loadUrl(paramString);
        return;
      }
    }
    try
    {
      localMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
      localMethod.setAccessible(true);
      localMethod.invoke(this.g, new Object[] { paramString, paramValueCallback });
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  @Deprecated
  public int findAll(String paramString)
  {
    if (!this.e)
    {
      paramString = i.a(this.g, "findAll", new Class[] { String.class }, new Object[] { paramString });
      if (paramString == null) {
        return 0;
      }
      return ((Integer)paramString).intValue();
    }
    return this.f.findAll(paramString);
  }
  
  @TargetApi(16)
  public void findAllAsync(String paramString)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        i.a(this.g, "findAllAsync", new Class[] { String.class }, new Object[] { paramString });
      }
      return;
    }
    this.f.findAllAsync(paramString);
  }
  
  public View findHierarchyView(String paramString, int paramInt)
  {
    if (!this.e) {
      return (View)i.a(this.g, "findHierarchyView", new Class[] { String.class, Integer.TYPE }, new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    return this.f.findHierarchyView(paramString, paramInt);
  }
  
  @TargetApi(3)
  public void findNext(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.g.findNext(paramBoolean);
      return;
    }
    this.f.findNext(paramBoolean);
  }
  
  public void flingScroll(int paramInt1, int paramInt2)
  {
    if (!this.e)
    {
      this.g.flingScroll(paramInt1, paramInt2);
      return;
    }
    this.f.flingScroll(paramInt1, paramInt2);
  }
  
  @Deprecated
  public void freeMemory()
  {
    if (!this.e)
    {
      i.a(this.g, "freeMemory");
      return;
    }
    this.f.freeMemory();
  }
  
  public SslCertificate getCertificate()
  {
    if (!this.e) {
      return this.g.getCertificate();
    }
    return this.f.getCertificate();
  }
  
  public int getContentHeight()
  {
    if (!this.e) {
      return this.g.getContentHeight();
    }
    return this.f.getContentHeight();
  }
  
  public int getContentWidth()
  {
    if (!this.e)
    {
      Object localObject = i.a(this.g, "getContentWidth");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.f.getContentWidth();
  }
  
  public Bitmap getFavicon()
  {
    if (!this.e) {
      return this.g.getFavicon();
    }
    return this.f.getFavicon();
  }
  
  public WebView.HitTestResult getHitTestResult()
  {
    if (!this.e) {
      return new WebView.HitTestResult(this.g.getHitTestResult());
    }
    return new WebView.HitTestResult(this.f.getHitTestResult());
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    if (!this.e) {
      return this.g.getHttpAuthUsernamePassword(paramString1, paramString2);
    }
    return this.f.getHttpAuthUsernamePassword(paramString1, paramString2);
  }
  
  @TargetApi(3)
  public String getOriginalUrl()
  {
    if (!this.e) {
      return this.g.getOriginalUrl();
    }
    return this.f.getOriginalUrl();
  }
  
  public int getProgress()
  {
    if (!this.e) {
      return this.g.getProgress();
    }
    return this.f.getProgress();
  }
  
  public boolean getRendererPriorityWaivedWhenNotVisible()
  {
    boolean bool;
    try
    {
      if (!this.e)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return false;
        }
        Object localObject = i.a(this.g, "getRendererPriorityWaivedWhenNotVisible");
        if (localObject == null) {
          bool = false;
        } else {
          bool = ((Boolean)localObject).booleanValue();
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
    return bool;
  }
  
  public int getRendererRequestedPriority()
  {
    int i1;
    try
    {
      if (!this.e)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return 0;
        }
        Object localObject = i.a(this.g, "getRendererRequestedPriority");
        if (localObject == null) {
          i1 = 0;
        } else {
          i1 = ((Integer)localObject).intValue();
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
    return i1;
  }
  
  @Deprecated
  public float getScale()
  {
    if (!this.e)
    {
      Object localObject = i.a(this.g, "getScale");
      if (localObject == null) {
        return 0.0F;
      }
      return ((Float)localObject).floatValue();
    }
    return this.f.getScale();
  }
  
  public int getScrollBarDefaultDelayBeforeFade()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarDefaultDelayBeforeFade();
  }
  
  public int getScrollBarFadeDuration()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarFadeDuration();
  }
  
  public int getScrollBarSize()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarSize();
  }
  
  public int getScrollBarStyle()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarStyle();
  }
  
  public WebSettings getSettings()
  {
    if (this.h != null) {
      return this.h;
    }
    if (this.e)
    {
      localWebSettings = new WebSettings(this.f.getSettings());
      this.h = localWebSettings;
      return localWebSettings;
    }
    WebSettings localWebSettings = new WebSettings(this.g.getSettings());
    this.h = localWebSettings;
    return localWebSettings;
  }
  
  public IX5WebSettingsExtension getSettingsExtension()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getX5WebViewExtension().getSettingsExtension();
  }
  
  public int getSysNightModeAlpha()
  {
    return NIGHT_MODE_ALPHA;
  }
  
  public String getTitle()
  {
    if (!this.e) {
      return this.g.getTitle();
    }
    return this.f.getTitle();
  }
  
  public String getUrl()
  {
    if (!this.e) {
      return this.g.getUrl();
    }
    return this.f.getUrl();
  }
  
  public View getView()
  {
    if (!this.e) {
      return this.g;
    }
    return this.f.getView();
  }
  
  public int getVisibleTitleHeight()
  {
    if (!this.e)
    {
      Object localObject = i.a(this.g, "getVisibleTitleHeight");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.f.getVisibleTitleHeight();
  }
  
  public WebChromeClient getWebChromeClient()
  {
    return this.r;
  }
  
  public IX5WebChromeClientExtension getWebChromeClientExtension()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getX5WebViewExtension().getWebChromeClientExtension();
  }
  
  public int getWebScrollX()
  {
    if (this.e) {
      return this.f.getView().getScrollX();
    }
    return this.g.getScrollX();
  }
  
  public int getWebScrollY()
  {
    if (this.e) {
      return this.f.getView().getScrollY();
    }
    return this.g.getScrollY();
  }
  
  public WebViewClient getWebViewClient()
  {
    return this.q;
  }
  
  public IX5WebViewClientExtension getWebViewClientExtension()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getX5WebViewExtension().getWebViewClientExtension();
  }
  
  public IX5WebViewBase.HitTestResult getX5HitTestResult()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getHitTestResult();
  }
  
  public IX5WebViewExtension getX5WebViewExtension()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getX5WebViewExtension();
  }
  
  @Deprecated
  public View getZoomControls()
  {
    if (!this.e) {
      return (View)i.a(this.g, "getZoomControls");
    }
    return this.f.getZoomControls();
  }
  
  public void goBack()
  {
    if (!this.e)
    {
      this.g.goBack();
      return;
    }
    this.f.goBack();
  }
  
  public void goBackOrForward(int paramInt)
  {
    if (!this.e)
    {
      this.g.goBackOrForward(paramInt);
      return;
    }
    this.f.goBackOrForward(paramInt);
  }
  
  public void goForward()
  {
    if (!this.e)
    {
      this.g.goForward();
      return;
    }
    this.f.goForward();
  }
  
  public void invokeZoomPicker()
  {
    if (!this.e)
    {
      this.g.invokeZoomPicker();
      return;
    }
    this.f.invokeZoomPicker();
  }
  
  public boolean isDayMode()
  {
    return z;
  }
  
  public boolean isPrivateBrowsingEnabled()
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = i.a(this.g, "isPrivateBrowsingEnabled");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.f.isPrivateBrowsingEnable();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    if (!this.e)
    {
      this.g.loadData(paramString1, paramString2, paramString3);
      return;
    }
    this.f.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!this.e)
    {
      this.g.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
      return;
    }
    this.f.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    if ((this.e) && (this.l != null) && (!this.m)) {
      this.l.a("load_url_gap", (byte)2);
    }
    if ((paramString == null) || (showDebugView(paramString))) {
      return;
    }
    if (!this.e)
    {
      this.g.loadUrl(paramString);
      return;
    }
    this.f.loadUrl(paramString);
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    if ((this.e) && (this.l != null) && (!this.m)) {
      this.l.a("load_url_gap", (byte)2);
    }
    if ((paramString == null) || (showDebugView(paramString))) {}
    do
    {
      return;
      if (this.e) {
        break;
      }
    } while (Build.VERSION.SDK_INT < 8);
    this.g.loadUrl(paramString, paramMap);
    return;
    this.f.loadUrl(paramString, paramMap);
  }
  
  protected void onDetachedFromWindow()
  {
    try
    {
      if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName))
      {
        new WebView.8(this, "onDetachedFromWindow").start();
        return;
      }
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      a();
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.B != null)
    {
      if (!this.B.onLongClick(paramView)) {
        return a(paramView);
      }
      return true;
    }
    return a(paramView);
  }
  
  public void onPause()
  {
    if (!this.e)
    {
      i.a(this.g, "onPause");
      return;
    }
    this.f.onPause();
  }
  
  public void onResume()
  {
    if (!this.e)
    {
      i.a(this.g, "onResume");
      return;
    }
    this.f.onResume();
  }
  
  @TargetApi(11)
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT >= 21) && (c(this.i)) && (isHardwareAccelerated()) && (paramInt1 > 0) && (paramInt2 > 0) && (getLayerType() != 2)) {}
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (this.i == null)
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    if (s == null) {
      s = this.i.getApplicationInfo().packageName;
    }
    if ((s != null) && ((s.equals("com.tencent.mm")) || (s.equals("com.tencent.mobileqq"))))
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    String str3;
    String str2;
    String str1;
    if ((paramInt != 0) && (!this.k) && (this.a != 0))
    {
      this.k = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      str3 = str4;
      str2 = str5;
      str1 = str6;
      if (this.e)
      {
        Bundle localBundle = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo();
        str3 = str4;
        str2 = str5;
        str1 = str6;
        if (localBundle != null)
        {
          str3 = localBundle.getString("guid");
          str2 = localBundle.getString("qua2");
          str1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.i.getApplicationInfo().packageName))
      {
        int i2 = e(this.i);
        int i1 = i2;
        if (i2 == -1) {
          i1 = this.a;
        }
        this.a = i1;
        f(this.i);
      }
    }
    try
    {
      bool = this.f.getX5WebViewExtension().isX5CoreSandboxMode();
      com.tencent.smtt.sdk.stat.b.a(this.i, str3, str2, str1, this.a, this.e, i(), bool);
      this.a = 0;
      this.k = false;
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TbsLog.w("onVisibilityChanged", "exception: " + localThrowable);
        boolean bool = false;
      }
    }
  }
  
  public boolean overlayHorizontalScrollbar()
  {
    if (!this.e) {
      return this.g.overlayHorizontalScrollbar();
    }
    return this.f.overlayHorizontalScrollbar();
  }
  
  public boolean overlayVerticalScrollbar()
  {
    if (this.e) {
      return this.f.overlayVerticalScrollbar();
    }
    return this.g.overlayVerticalScrollbar();
  }
  
  public boolean pageDown(boolean paramBoolean)
  {
    if (!this.e) {
      return this.g.pageDown(paramBoolean);
    }
    return this.f.pageDown(paramBoolean, -1);
  }
  
  public boolean pageUp(boolean paramBoolean)
  {
    if (!this.e) {
      return this.g.pageUp(paramBoolean);
    }
    return this.f.pageUp(paramBoolean, -1);
  }
  
  public void pauseTimers()
  {
    if (!this.e)
    {
      this.g.pauseTimers();
      return;
    }
    this.f.pauseTimers();
  }
  
  @TargetApi(5)
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    if (!this.e)
    {
      this.g.postUrl(paramString, paramArrayOfByte);
      return;
    }
    this.f.postUrl(paramString, paramArrayOfByte);
  }
  
  @Deprecated
  public void refreshPlugins(boolean paramBoolean)
  {
    if (!this.e)
    {
      i.a(this.g, "refreshPlugins", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.f.refreshPlugins(paramBoolean);
  }
  
  public void reload()
  {
    if (!this.e)
    {
      this.g.reload();
      return;
    }
    this.f.reload();
  }
  
  @TargetApi(11)
  public void removeJavascriptInterface(String paramString)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        i.a(this.g, "removeJavascriptInterface", new Class[] { String.class }, new Object[] { paramString });
      }
      return;
    }
    this.f.removeJavascriptInterface(paramString);
  }
  
  public void removeView(View paramView)
  {
    if (!this.e)
    {
      this.g.removeView(paramView);
      return;
    }
    View localView = this.f.getView();
    try
    {
      Method localMethod = i.a(localView, "removeView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public JSONObject reportInitPerformance(long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("IS_X5", this.e);
      TbsLog.i("sdkreport", "reportInitPerformance initType is " + paramLong1 + " isX5Core is " + this.e + " isPerformanceDataRecorded" + this.m);
      if ((this.e) && (this.l != null) && (!this.m))
      {
        this.l.a("init_type", paramLong1);
        this.l.a("time_oncreate", paramLong2);
        this.l.a("webview_type", paramInt);
        this.l.a("time_webaccelerator", paramLong3);
        if (this.l.a(this.f.hashCode(), getUrl())) {
          this.m = true;
        }
        localJSONObject2 = this.l.a();
      }
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        try
        {
          JSONObject localJSONObject2;
          localJSONObject1.put("DETAIL", localJSONObject2);
          return localJSONObject1;
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
        localJSONException1 = localJSONException1;
        localJSONException1.printStackTrace();
      }
    }
    return localJSONObject1;
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    if (this.e)
    {
      localObject1 = this.f.getView();
      if ((localObject1 instanceof ViewGroup))
      {
        localObject2 = (ViewGroup)localObject1;
        if (paramView == this) {
          paramView = (View)localObject1;
        }
        for (;;)
        {
          return ((ViewGroup)localObject2).requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
        }
      }
      return false;
    }
    Object localObject2 = this.g;
    Object localObject1 = paramView;
    if (paramView == this) {
      localObject1 = this.g;
    }
    return ((android.webkit.WebView)localObject2).requestChildRectangleOnScreen((View)localObject1, paramRect, paramBoolean);
  }
  
  public void requestFocusNodeHref(Message paramMessage)
  {
    if (!this.e)
    {
      this.g.requestFocusNodeHref(paramMessage);
      return;
    }
    this.f.requestFocusNodeHref(paramMessage);
  }
  
  public void requestImageRef(Message paramMessage)
  {
    if (!this.e)
    {
      this.g.requestImageRef(paramMessage);
      return;
    }
    this.f.requestImageRef(paramMessage);
  }
  
  @Deprecated
  public boolean restorePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.e)
    {
      paramBundle = i.a(this.g, "restorePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.f.restorePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList restoreState(Bundle paramBundle)
  {
    if (!this.e) {
      return WebBackForwardList.a(this.g.restoreState(paramBundle));
    }
    return WebBackForwardList.a(this.f.restoreState(paramBundle));
  }
  
  public void resumeTimers()
  {
    if (!this.e)
    {
      this.g.resumeTimers();
      return;
    }
    this.f.resumeTimers();
  }
  
  @Deprecated
  public void savePassword(String paramString1, String paramString2, String paramString3)
  {
    if (!this.e)
    {
      i.a(this.g, "savePassword", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
      return;
    }
    this.f.savePassword(paramString1, paramString2, paramString3);
  }
  
  @Deprecated
  public boolean savePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.e)
    {
      paramBundle = i.a(this.g, "savePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.f.savePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList saveState(Bundle paramBundle)
  {
    if (!this.e) {
      return WebBackForwardList.a(this.g.saveState(paramBundle));
    }
    return WebBackForwardList.a(this.f.saveState(paramBundle));
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        i.a(this.g, "saveWebArchive", new Class[] { String.class }, new Object[] { paramString });
      }
      return;
    }
    this.f.saveWebArchive(paramString);
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString, boolean paramBoolean, ValueCallback<String> paramValueCallback)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        i.a(this.g, "saveWebArchive", new Class[] { String.class, Boolean.TYPE, android.webkit.ValueCallback.class }, new Object[] { paramString, Boolean.valueOf(paramBoolean), paramValueCallback });
      }
      return;
    }
    this.f.saveWebArchive(paramString, paramBoolean, paramValueCallback);
  }
  
  public void setARModeEnable(boolean paramBoolean)
  {
    try
    {
      if (this.e) {
        getSettingsExtension().setARModeEnable(paramBoolean);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (!this.e) {
      this.g.setBackgroundColor(paramInt);
    }
    for (;;)
    {
      super.setBackgroundColor(paramInt);
      return;
      this.f.setBackgroundColor(paramInt);
    }
  }
  
  @Deprecated
  public void setCertificate(SslCertificate paramSslCertificate)
  {
    if (!this.e)
    {
      this.g.setCertificate(paramSslCertificate);
      return;
    }
    this.f.setCertificate(paramSslCertificate);
  }
  
  public void setDayOrNight(boolean paramBoolean)
  {
    try
    {
      if (this.e) {
        getSettingsExtension().setDayOrNight(paramBoolean);
      }
      setSysDayOrNight(paramBoolean);
      getView().postInvalidate();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    if (!this.e)
    {
      this.g.setDownloadListener(new WebView.5(this, paramDownloadListener));
      return;
    }
    this.f.setDownloadListener(new b(this, paramDownloadListener, this.e));
  }
  
  @TargetApi(16)
  public void setFindListener(IX5WebViewBase.FindListener paramFindListener)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.g.setFindListener(new WebView.4(this, paramFindListener));
      }
      return;
    }
    this.f.setFindListener(paramFindListener);
  }
  
  public void setHorizontalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.g.setHorizontalScrollbarOverlay(paramBoolean);
      return;
    }
    this.f.setHorizontalScrollbarOverlay(paramBoolean);
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!this.e)
    {
      this.g.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
      return;
    }
    this.f.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void setInitialScale(int paramInt)
  {
    if (!this.e)
    {
      this.g.setInitialScale(paramInt);
      return;
    }
    this.f.setInitialScale(paramInt);
  }
  
  @Deprecated
  public void setMapTrackballToArrowKeys(boolean paramBoolean)
  {
    if (!this.e)
    {
      i.a(this.g, "setMapTrackballToArrowKeys", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.f.setMapTrackballToArrowKeys(paramBoolean);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 3) {
        this.g.setNetworkAvailable(paramBoolean);
      }
      return;
    }
    this.f.setNetworkAvailable(paramBoolean);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    if (!this.e)
    {
      this.g.setOnLongClickListener(paramOnLongClickListener);
      return;
    }
    Object localObject1 = this.f.getView();
    try
    {
      if (this.A == null)
      {
        Object localObject2 = i.a(localObject1, "getListenerInfo", new Class[0]);
        ((Method)localObject2).setAccessible(true);
        localObject1 = ((Method)localObject2).invoke(localObject1, (Object[])null);
        localObject2 = localObject1.getClass().getDeclaredField("mOnLongClickListener");
        ((Field)localObject2).setAccessible(true);
        this.A = ((Field)localObject2).get(localObject1);
      }
      this.B = paramOnLongClickListener;
      getView().setOnLongClickListener(this);
      return;
    }
    catch (Throwable paramOnLongClickListener) {}
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    getView().setOnTouchListener(paramOnTouchListener);
  }
  
  public void setPictureListener(WebView.PictureListener paramPictureListener)
  {
    if (!this.e)
    {
      if (paramPictureListener == null)
      {
        this.g.setPictureListener(null);
        return;
      }
      this.g.setPictureListener(new WebView.6(this, paramPictureListener));
      return;
    }
    if (paramPictureListener == null)
    {
      this.f.setPictureListener(null);
      return;
    }
    this.f.setPictureListener(new WebView.7(this, paramPictureListener));
  }
  
  public void setRendererPriorityPolicy(int paramInt, boolean paramBoolean)
  {
    try
    {
      if (!this.e)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return;
        }
        i.a(this.g, "setRendererPriorityPolicy", new Class[] { Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setScrollBarStyle(int paramInt)
  {
    if (this.e)
    {
      this.f.getView().setScrollBarStyle(paramInt);
      return;
    }
    this.g.setScrollBarStyle(paramInt);
  }
  
  public void setSysNightModeAlpha(int paramInt)
  {
    NIGHT_MODE_ALPHA = paramInt;
  }
  
  public void setVerticalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.g.setVerticalScrollbarOverlay(paramBoolean);
      return;
    }
    this.f.setVerticalScrollbarOverlay(paramBoolean);
  }
  
  public boolean setVideoFullScreen(Context paramContext, boolean paramBoolean)
  {
    if ((paramContext.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader")) && (this.f != null))
    {
      paramContext = new Bundle();
      if (paramBoolean) {
        paramContext.putInt("DefaultVideoScreen", 2);
      }
      for (;;)
      {
        this.f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", paramContext);
        return true;
        paramContext.putInt("DefaultVideoScreen", 1);
      }
    }
    return false;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (getView() == null) {
      return;
    }
    getView().setVisibility(paramInt);
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    IX5WebViewBase localIX5WebViewBase = null;
    Object localObject = null;
    if (this.e)
    {
      localIX5WebViewBase = this.f;
      if (paramWebChromeClient == null) {}
      for (;;)
      {
        localIX5WebViewBase.setWebChromeClient((IX5WebChromeClient)localObject);
        this.r = paramWebChromeClient;
        return;
        localObject = new f(v.a().a(true).i(), this, paramWebChromeClient);
      }
    }
    WebView.b localb = this.g;
    if (paramWebChromeClient == null) {}
    for (localObject = localIX5WebViewBase;; localObject = new SystemWebChromeClient(this, paramWebChromeClient))
    {
      localb.setWebChromeClient((android.webkit.WebChromeClient)localObject);
      break;
    }
  }
  
  public void setWebChromeClientExtension(IX5WebChromeClientExtension paramIX5WebChromeClientExtension)
  {
    if (!this.e) {
      return;
    }
    this.f.getX5WebViewExtension().setWebChromeClientExtension(paramIX5WebChromeClientExtension);
  }
  
  public void setWebViewCallbackClient(WebViewCallbackClient paramWebViewCallbackClient)
  {
    this.mWebViewCallbackClient = paramWebViewCallbackClient;
    if ((this.e) && (getX5WebViewExtension() != null))
    {
      paramWebViewCallbackClient = new Bundle();
      paramWebViewCallbackClient.putBoolean("flag", true);
      getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", paramWebViewCallbackClient);
    }
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    IX5WebViewBase localIX5WebViewBase = null;
    Object localObject = null;
    if (this.e)
    {
      localIX5WebViewBase = this.f;
      if (paramWebViewClient == null) {}
      for (;;)
      {
        localIX5WebViewBase.setWebViewClient((IX5WebViewClient)localObject);
        this.q = paramWebViewClient;
        return;
        localObject = new g(v.a().a(true).j(), this, paramWebViewClient);
      }
    }
    WebView.b localb = this.g;
    if (paramWebViewClient == null) {}
    for (localObject = localIX5WebViewBase;; localObject = new SystemWebViewClient(this, paramWebViewClient))
    {
      localb.setWebViewClient((android.webkit.WebViewClient)localObject);
      break;
    }
  }
  
  public void setWebViewClientExtension(IX5WebViewClientExtension paramIX5WebViewClientExtension)
  {
    if (!this.e) {
      return;
    }
    this.f.getX5WebViewExtension().setWebViewClientExtension(paramIX5WebViewClientExtension);
  }
  
  @SuppressLint({"NewApi"})
  public boolean showDebugView(String paramString)
  {
    boolean bool2 = false;
    paramString = paramString.toLowerCase();
    boolean bool1;
    if (paramString.startsWith("https://debugtbs.qq.com"))
    {
      getView().setVisibility(4);
      com.tencent.smtt.utils.d.a(this.i).a(paramString, this, this.i, l.a().getLooper());
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!paramString.startsWith("https://debugx5.qq.com"));
      bool1 = bool2;
    } while (this.e);
    paramString = new StringBuilder();
    paramString.append("<!DOCTYPE html><html><body>");
    paramString.append("<head>");
    paramString.append("<title>无法打开debugx5</title>");
    paramString.append("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" />");
    paramString.append("</head>");
    paramString.append("<br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />");
    paramString.append("尝试<a href=\"http://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a>");
    paramString.append("</body></html>");
    loadDataWithBaseURL(null, paramString.toString(), "text/html", "utf-8", null);
    return true;
  }
  
  public boolean showFindDialog(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public void stopLoading()
  {
    if (!this.e)
    {
      this.g.stopLoading();
      return;
    }
    this.f.stopLoading();
  }
  
  public void super_computeScroll()
  {
    if (!this.e)
    {
      this.g.a();
      return;
    }
    View localView = this.f.getView();
    try
    {
      i.a(localView, "super_computeScroll");
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.e) {
      return this.g.b(paramMotionEvent);
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = i.a(localView, "super_dispatchTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.e) {
      return this.g.c(paramMotionEvent);
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = i.a(localView, "super_onInterceptTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.e)
    {
      this.g.a(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
    }
    View localView = this.f.getView();
    try
    {
      i.a(localView, "super_onOverScrolled", new Class[] { Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.e)
    {
      this.g.a(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    View localView = this.f.getView();
    try
    {
      i.a(localView, "super_onScrollChanged", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.e) {
      return this.g.a(paramMotionEvent);
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = i.a(localView, "super_onTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (!this.e) {
      return this.g.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    }
    Object localObject = this.f.getView();
    try
    {
      localObject = i.a(localObject, "super_overScrollBy", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Boolean.valueOf(paramBoolean) });
      if (localObject == null) {
        return false;
      }
      paramBoolean = ((Boolean)localObject).booleanValue();
      return paramBoolean;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public void switchNightMode(boolean paramBoolean)
  {
    if (paramBoolean == z) {
      return;
    }
    z = paramBoolean;
    if (z)
    {
      TbsLog.e("QB_SDK", "deleteNightMode");
      loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
      return;
    }
    TbsLog.e("QB_SDK", "nightMode");
    loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
  }
  
  public void switchToNightMode()
  {
    TbsLog.e("QB_SDK", "switchToNightMode 01");
    if (!z)
    {
      TbsLog.e("QB_SDK", "switchToNightMode");
      loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
    }
  }
  
  /* Error */
  public void tbsWebviewDestroy(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 138	com/tencent/smtt/sdk/WebView:k	Z
    //   4: ifne +218 -> 222
    //   7: aload_0
    //   8: getfield 136	com/tencent/smtt/sdk/WebView:a	I
    //   11: ifeq +211 -> 222
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 138	com/tencent/smtt/sdk/WebView:k	Z
    //   19: ldc_w 744
    //   22: astore 8
    //   24: ldc_w 744
    //   27: astore 9
    //   29: ldc_w 744
    //   32: astore 10
    //   34: aload 8
    //   36: astore 7
    //   38: aload 9
    //   40: astore 6
    //   42: aload 10
    //   44: astore 5
    //   46: aload_0
    //   47: getfield 130	com/tencent/smtt/sdk/WebView:e	Z
    //   50: ifeq +66 -> 116
    //   53: aload_0
    //   54: getfield 186	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   57: invokeinterface 411 1 0
    //   62: invokeinterface 889 1 0
    //   67: astore 11
    //   69: aload 8
    //   71: astore 7
    //   73: aload 9
    //   75: astore 6
    //   77: aload 10
    //   79: astore 5
    //   81: aload 11
    //   83: ifnull +33 -> 116
    //   86: aload 11
    //   88: ldc_w 891
    //   91: invokevirtual 896	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore 7
    //   96: aload 11
    //   98: ldc_w 898
    //   101: invokevirtual 896	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore 6
    //   106: aload 11
    //   108: ldc_w 900
    //   111: invokevirtual 896	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore 5
    //   116: ldc_w 902
    //   119: aload_0
    //   120: getfield 134	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   123: invokevirtual 431	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   126: getfield 436	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   129: invokevirtual 442	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   132: ifeq +37 -> 169
    //   135: aload_0
    //   136: aload_0
    //   137: getfield 134	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   140: invokespecial 904	com/tencent/smtt/sdk/WebView:e	(Landroid/content/Context;)I
    //   143: istore_3
    //   144: iload_3
    //   145: istore_2
    //   146: iload_3
    //   147: iconst_m1
    //   148: if_icmpne +8 -> 156
    //   151: aload_0
    //   152: getfield 136	com/tencent/smtt/sdk/WebView:a	I
    //   155: istore_2
    //   156: aload_0
    //   157: iload_2
    //   158: putfield 136	com/tencent/smtt/sdk/WebView:a	I
    //   161: aload_0
    //   162: aload_0
    //   163: getfield 134	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   166: invokespecial 906	com/tencent/smtt/sdk/WebView:f	(Landroid/content/Context;)V
    //   169: aload_0
    //   170: getfield 186	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   173: invokeinterface 411 1 0
    //   178: invokeinterface 909 1 0
    //   183: istore 4
    //   185: aload_0
    //   186: getfield 134	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   189: aload 7
    //   191: aload 6
    //   193: aload 5
    //   195: aload_0
    //   196: getfield 136	com/tencent/smtt/sdk/WebView:a	I
    //   199: aload_0
    //   200: getfield 130	com/tencent/smtt/sdk/WebView:e	Z
    //   203: aload_0
    //   204: invokespecial 911	com/tencent/smtt/sdk/WebView:i	()J
    //   207: iload 4
    //   209: invokestatic 916	com/tencent/smtt/sdk/stat/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZJZ)V
    //   212: aload_0
    //   213: iconst_0
    //   214: putfield 136	com/tencent/smtt/sdk/WebView:a	I
    //   217: aload_0
    //   218: iconst_0
    //   219: putfield 138	com/tencent/smtt/sdk/WebView:k	Z
    //   222: aload_0
    //   223: getfield 130	com/tencent/smtt/sdk/WebView:e	Z
    //   226: ifne +358 -> 584
    //   229: ldc_w 1813
    //   232: invokestatic 224	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   235: astore 5
    //   237: aload 5
    //   239: ldc_w 1815
    //   242: iconst_1
    //   243: anewarray 220	java/lang/Class
    //   246: dup
    //   247: iconst_0
    //   248: ldc_w 267
    //   251: aastore
    //   252: invokevirtual 1818	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   255: astore 6
    //   257: aload 6
    //   259: iconst_1
    //   260: invokevirtual 236	java/lang/reflect/Method:setAccessible	(Z)V
    //   263: aload 6
    //   265: aconst_null
    //   266: iconst_1
    //   267: anewarray 238	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: aload_0
    //   273: getfield 198	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$b;
    //   276: aastore
    //   277: invokevirtual 242	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   280: astore 6
    //   282: aload 6
    //   284: ifnull +114 -> 398
    //   287: aload 5
    //   289: ldc_w 1820
    //   292: invokevirtual 1601	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   295: astore 5
    //   297: aload 5
    //   299: iconst_1
    //   300: invokevirtual 1604	java/lang/reflect/Field:setAccessible	(Z)V
    //   303: aload 5
    //   305: aload 6
    //   307: invokevirtual 1605	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   310: astore 5
    //   312: aload 5
    //   314: ifnull +84 -> 398
    //   317: aload 5
    //   319: checkcast 1822	android/app/Dialog
    //   322: astore 5
    //   324: aload 5
    //   326: aconst_null
    //   327: invokevirtual 1826	android/app/Dialog:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   330: ldc_w 1828
    //   333: invokestatic 224	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   336: astore 6
    //   338: aload 6
    //   340: ldc_w 1830
    //   343: invokevirtual 1601	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   346: astore 7
    //   348: aload 7
    //   350: iconst_1
    //   351: invokevirtual 1604	java/lang/reflect/Field:setAccessible	(Z)V
    //   354: aload 7
    //   356: aload 5
    //   358: invokevirtual 1605	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   361: checkcast 722	java/lang/Integer
    //   364: invokevirtual 1039	java/lang/Integer:intValue	()I
    //   367: istore_2
    //   368: aload 6
    //   370: ldc_w 1832
    //   373: invokevirtual 1601	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   376: astore 6
    //   378: aload 6
    //   380: iconst_1
    //   381: invokevirtual 1604	java/lang/reflect/Field:setAccessible	(Z)V
    //   384: aload 6
    //   386: aload 5
    //   388: invokevirtual 1605	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   391: checkcast 244	android/os/Handler
    //   394: iload_2
    //   395: invokevirtual 1835	android/os/Handler:removeMessages	(I)V
    //   398: iload_1
    //   399: ifeq +10 -> 409
    //   402: aload_0
    //   403: getfield 198	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$b;
    //   406: invokevirtual 1108	android/webkit/WebView:destroy	()V
    //   409: ldc_w 1837
    //   412: invokestatic 224	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   415: ldc_w 1839
    //   418: invokevirtual 1601	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   421: astore 6
    //   423: aload 6
    //   425: iconst_1
    //   426: invokevirtual 1604	java/lang/reflect/Field:setAccessible	(Z)V
    //   429: aload 6
    //   431: aconst_null
    //   432: invokevirtual 1605	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   435: checkcast 1841	android/content/ComponentCallbacks
    //   438: astore 5
    //   440: aload 5
    //   442: ifnull +66 -> 508
    //   445: aload 6
    //   447: aconst_null
    //   448: aconst_null
    //   449: invokevirtual 1845	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   452: ldc_w 1847
    //   455: invokestatic 224	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   458: ldc_w 1849
    //   461: invokevirtual 1601	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   464: astore 6
    //   466: aload 6
    //   468: iconst_1
    //   469: invokevirtual 1604	java/lang/reflect/Field:setAccessible	(Z)V
    //   472: aload 6
    //   474: aconst_null
    //   475: invokevirtual 1605	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   478: astore 6
    //   480: aload 6
    //   482: ifnull +26 -> 508
    //   485: aload 6
    //   487: checkcast 1851	java/util/List
    //   490: astore 6
    //   492: aload 6
    //   494: monitorenter
    //   495: aload 6
    //   497: aload 5
    //   499: invokeinterface 1854 2 0
    //   504: pop
    //   505: aload 6
    //   507: monitorexit
    //   508: ldc 126
    //   510: new 494	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   517: ldc_w 1856
    //   520: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokestatic 1858	com/tencent/smtt/sdk/QbSdk:b	()Ljava/lang/String;
    //   526: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 286	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   535: return
    //   536: astore 8
    //   538: ldc_w 1859
    //   541: new 494	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   548: ldc_w 923
    //   551: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: aload 8
    //   556: invokevirtual 639	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   559: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 925	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   565: iconst_0
    //   566: istore 4
    //   568: goto -383 -> 185
    //   571: astore 5
    //   573: aload 6
    //   575: monitorexit
    //   576: aload 5
    //   578: athrow
    //   579: astore 5
    //   581: goto -73 -> 508
    //   584: iload_1
    //   585: ifeq -77 -> 508
    //   588: aload_0
    //   589: getfield 186	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   592: invokeinterface 1107 1 0
    //   597: goto -89 -> 508
    //   600: astore 5
    //   602: goto -204 -> 398
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	605	0	this	WebView
    //   0	605	1	paramBoolean	boolean
    //   145	250	2	i1	int
    //   143	6	3	i2	int
    //   183	384	4	bool	boolean
    //   44	454	5	localObject1	Object
    //   571	6	5	localObject2	Object
    //   579	1	5	localException1	Exception
    //   600	1	5	localException2	Exception
    //   36	319	7	localObject4	Object
    //   22	48	8	str1	String
    //   536	19	8	localThrowable	Throwable
    //   27	47	9	str2	String
    //   32	46	10	str3	String
    //   67	40	11	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   169	185	536	java/lang/Throwable
    //   495	508	571	finally
    //   573	576	571	finally
    //   409	440	579	java/lang/Exception
    //   445	480	579	java/lang/Exception
    //   485	495	579	java/lang/Exception
    //   576	579	579	java/lang/Exception
    //   229	282	600	java/lang/Exception
    //   287	312	600	java/lang/Exception
    //   317	398	600	java/lang/Exception
  }
  
  public boolean zoomIn()
  {
    if (!this.e) {
      return this.g.zoomIn();
    }
    return this.f.zoomIn();
  }
  
  public boolean zoomOut()
  {
    if (!this.e) {
      return this.g.zoomOut();
    }
    return this.f.zoomOut();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView
 * JD-Core Version:    0.7.0.1
 */