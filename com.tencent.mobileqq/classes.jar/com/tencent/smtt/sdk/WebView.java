package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
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
import com.tencent.smtt.utils.d;
import com.tencent.smtt.utils.q;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
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
  private static com.tencent.smtt.utils.o o;
  private static Method p;
  private static String s;
  private static Paint y;
  private static boolean z;
  private Object A = null;
  private View.OnLongClickListener B = null;
  volatile int a = 0;
  private final String b = "WebView";
  private boolean e = false;
  private IX5WebViewBase f;
  private WebView.b g;
  private WebSettings h = null;
  private Context i = null;
  private volatile boolean k = false;
  private o l = null;
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
    this.l = new o();
    this.l.a("init_all", (byte)1);
    q.a("0");
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
      ((Handler)paramAttributeSet.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new g());
      mSysWebviewCreated = true;
      label244:
      CookieManager.getInstance().a();
      this.g.setFocusableInTouchMode(true);
      addView(this.g, new FrameLayout.LayoutParams(-1, -1));
      TbsLog.i("WebView", "SystemWebView Created Success! #3");
      TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
      TbsCoreLoadStat.getInstance().a(paramContext, 402, new Throwable());
      return;
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsLog.setWriteLogJIT(true);
      } else {
        TbsLog.setWriteLogJIT(false);
      }
      this.l.a("tbslog_init", (byte)1);
      TbsLog.initIfNeed(paramContext);
      this.l.a("tbslog_init", (byte)2);
      if (paramContext != null)
      {
        if (o == null) {
          o = com.tencent.smtt.utils.o.a(paramContext);
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
          this.f = x.a().a(true).a(paramContext);
          this.l.a("init_x5_webview", (byte)2);
          paramMap = this.f;
          if ((paramMap != null) && (paramMap.getView() != null))
          {
            TbsLog.i("WebView", "X5 WebView Created Success!!");
            q.a("20");
            this.f.getView().setFocusableInTouchMode(true);
            a(paramAttributeSet);
            addView(this.f.getView(), new FrameLayout.LayoutParams(-1, -1));
            this.f.setDownloadListener(new b(this, null, this.e));
            this.f.getX5WebViewExtension().setWebViewClientExtension(new WebView.1(this, x.a().a(true).k()));
          }
          else
          {
            TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
            this.f = null;
            this.e = false;
            QbSdk.a(paramContext, "failed to createTBSWebview!");
            a(paramContext, this.l);
            if (TbsShareManager.isThirdPartyApp(this.i)) {
              this.g = new WebView.b(this, paramContext, paramAttributeSet);
            } else {
              this.g = new WebView.b(this, paramContext);
            }
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
            }
            catch (Throwable paramAttributeSet)
            {
              paramAttributeSet.printStackTrace();
            }
            b(paramContext);
            TbsLog.writeLogToDisk();
            p.a(paramContext);
          }
        }
        else
        {
          this.f = null;
          if (TbsShareManager.isThirdPartyApp(this.i)) {
            this.g = new WebView.b(this, paramContext, paramAttributeSet);
          } else {
            this.g = new WebView.b(this, paramContext);
          }
          TbsLog.i("WebView", "SystemWebView Created Success! #2");
          CookieManager.getInstance().a(paramContext, true, false);
          CookieManager.getInstance().a();
          this.g.setFocusableInTouchMode(true);
          addView(this.g, new FrameLayout.LayoutParams(-1, -1));
          setDownloadListener(null);
          b(paramContext);
          TbsLog.writeLogToDisk();
          p.a(paramContext);
        }
        try
        {
          if (Build.VERSION.SDK_INT >= 11)
          {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
          }
        }
        catch (Throwable paramAttributeSet)
        {
          paramAttributeSet.printStackTrace();
        }
        if ((("com.tencent.mobileqq".equals(this.i.getApplicationInfo().packageName)) || ("com.tencent.mm".equals(this.i.getApplicationInfo().packageName))) && (f.a(true).g()) && (Build.VERSION.SDK_INT >= 11)) {
          setLayerType(1, null);
        }
        if (this.f != null)
        {
          TbsLog.writeLogToDisk();
          if (!TbsShareManager.isThirdPartyApp(paramContext))
          {
            paramInt = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
            if ((paramInt > 0) && (paramInt != p.a().i(paramContext)) && (paramInt == p.a().j(paramContext)))
            {
              p.a().o(paramContext);
            }
            else
            {
              paramAttributeSet = new StringBuilder();
              paramAttributeSet.append("webview construction #1 deCoupleCoreVersion is ");
              paramAttributeSet.append(paramInt);
              paramAttributeSet.append(" getTbsCoreShareDecoupleCoreVersion is ");
              paramAttributeSet.append(p.a().i(paramContext));
              paramAttributeSet.append(" getTbsCoreInstalledVerInNolock is ");
              paramAttributeSet.append(p.a().j(paramContext));
              TbsLog.i("WebView", paramAttributeSet.toString());
            }
          }
        }
        paramAttributeSet = this.l;
        if (paramAttributeSet != null)
        {
          paramAttributeSet.a("load_url_gap", (byte)1);
          this.l.a("init_all", (byte)2);
        }
        QbSdk.continueLoadSo(paramContext);
        return;
      }
      throw new IllegalArgumentException("Invalid context argument");
    }
    catch (Exception paramAttributeSet)
    {
      break label244;
    }
  }
  
  @Deprecated
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    this(paramContext, paramAttributeSet, paramInt, null, paramBoolean);
  }
  
  public WebView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
  }
  
  private void a(Context paramContext, o paramo)
  {
    if ((QbSdk.i) && (TbsShareManager.isThirdPartyApp(paramContext))) {
      TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(paramContext);
    }
    if (paramo != null) {
      paramo.a("x5_core_engine_init_sync", (byte)1);
    }
    x localx = x.a();
    localx.a(paramContext, paramo);
    this.e = localx.b();
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null) {
      try
      {
        int i2 = paramAttributeSet.getAttributeCount();
        int i1 = 0;
        while (i1 < i2)
        {
          if (paramAttributeSet.getAttributeName(i1).equalsIgnoreCase("scrollbars"))
          {
            Object localObject = getResources().getIntArray(16842974);
            int i3 = paramAttributeSet.getAttributeIntValue(i1, -1);
            if (i3 == localObject[1]) {
              this.f.getView().setVerticalScrollBarEnabled(false);
            }
            for (localObject = this.f.getView();; localObject = this.f.getView())
            {
              ((View)localObject).setHorizontalScrollBarEnabled(false);
              break;
              if (i3 == localObject[2])
              {
                this.f.getView().setVerticalScrollBarEnabled(false);
                break;
              }
              if (i3 != localObject[3]) {
                break;
              }
            }
          }
          i1 += 1;
        }
        return;
      }
      catch (Exception paramAttributeSet)
      {
        paramAttributeSet.printStackTrace();
      }
    }
  }
  
  private boolean a(View paramView)
  {
    Context localContext = this.i;
    if ((localContext != null) && (getTbsCoreVersion(localContext) > 36200)) {
      return false;
    }
    paramView = com.tencent.smtt.utils.i.a(this.A, "onLongClick", new Class[] { View.class }, new Object[] { paramView });
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
  
  static void c()
  {
    WebView.8 local8 = new WebView.8();
    try
    {
      new Thread(local8).start();
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateRebootStatus excpetion: ");
      localStringBuilder.append(localThrowable);
      TbsLog.e("webview", localStringBuilder.toString());
    }
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
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    if (!x.a().b()) {
      com.tencent.smtt.utils.i.a("android.webkit.WebView", "disablePlatformNotifications");
    }
  }
  
  /* Error */
  private int e(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: ldc_w 671
    //   5: invokestatic 676	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   8: astore 7
    //   10: aload 7
    //   12: ifnull +493 -> 505
    //   15: aload_1
    //   16: aload 7
    //   18: invokestatic 679	com/tencent/smtt/utils/FileUtil:a	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   21: astore 8
    //   23: aload 8
    //   25: ifnonnull +5 -> 30
    //   28: iconst_m1
    //   29: ireturn
    //   30: getstatic 82	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   33: invokeinterface 684 1 0
    //   38: ifeq +460 -> 498
    //   41: aconst_null
    //   42: astore 6
    //   44: aconst_null
    //   45: astore 5
    //   47: aload 5
    //   49: astore 4
    //   51: aload_1
    //   52: invokestatic 688	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   55: astore_1
    //   56: aload 5
    //   58: astore 4
    //   60: new 491	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 492	java/lang/StringBuilder:<init>	()V
    //   67: astore 9
    //   69: aload 5
    //   71: astore 4
    //   73: aload 9
    //   75: aload_1
    //   76: invokevirtual 640	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 5
    //   82: astore 4
    //   84: aload 9
    //   86: getstatic 693	java/io/File:separator	Ljava/lang/String;
    //   89: invokevirtual 498	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 5
    //   95: astore 4
    //   97: aload 9
    //   99: ldc_w 695
    //   102: invokevirtual 498	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 5
    //   108: astore 4
    //   110: new 690	java/io/File
    //   113: dup
    //   114: aload 9
    //   116: invokevirtual 509	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: ldc_w 697
    //   122: invokespecial 699	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: astore_1
    //   126: aload 5
    //   128: astore 4
    //   130: aload_1
    //   131: invokevirtual 702	java/io/File:exists	()Z
    //   134: istore_3
    //   135: iload_3
    //   136: ifne +20 -> 156
    //   139: getstatic 82	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   142: invokeinterface 705 1 0
    //   147: aload 8
    //   149: aload 7
    //   151: invokestatic 708	com/tencent/smtt/utils/FileUtil:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   154: iconst_m1
    //   155: ireturn
    //   156: aload 5
    //   158: astore 4
    //   160: new 710	java/util/Properties
    //   163: dup
    //   164: invokespecial 711	java/util/Properties:<init>	()V
    //   167: astore 9
    //   169: aload 5
    //   171: astore 4
    //   173: new 713	java/io/FileInputStream
    //   176: dup
    //   177: aload_1
    //   178: invokespecial 716	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   181: astore_1
    //   182: aload 9
    //   184: aload_1
    //   185: invokevirtual 720	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   188: aload_1
    //   189: invokevirtual 723	java/io/FileInputStream:close	()V
    //   192: aload 9
    //   194: ldc_w 725
    //   197: invokevirtual 729	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   200: astore 4
    //   202: aload 4
    //   204: ifnonnull +51 -> 255
    //   207: aload_1
    //   208: invokevirtual 723	java/io/FileInputStream:close	()V
    //   211: goto -72 -> 139
    //   214: astore 4
    //   216: new 491	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 492	java/lang/StringBuilder:<init>	()V
    //   223: astore_1
    //   224: aload_1
    //   225: ldc_w 731
    //   228: invokevirtual 498	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload_1
    //   233: aload 4
    //   235: invokevirtual 732	java/io/IOException:toString	()Ljava/lang/String;
    //   238: invokevirtual 498	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: ldc_w 734
    //   245: aload_1
    //   246: invokevirtual 509	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 644	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: goto -113 -> 139
    //   255: aload 4
    //   257: invokestatic 739	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   260: istore_2
    //   261: aload_1
    //   262: invokevirtual 723	java/io/FileInputStream:close	()V
    //   265: goto +43 -> 308
    //   268: astore_1
    //   269: new 491	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 492	java/lang/StringBuilder:<init>	()V
    //   276: astore 4
    //   278: aload 4
    //   280: ldc_w 731
    //   283: invokevirtual 498	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 4
    //   289: aload_1
    //   290: invokevirtual 732	java/io/IOException:toString	()Ljava/lang/String;
    //   293: invokevirtual 498	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: ldc_w 734
    //   300: aload 4
    //   302: invokevirtual 509	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 644	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: getstatic 82	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   311: invokeinterface 705 1 0
    //   316: aload 8
    //   318: aload 7
    //   320: invokestatic 708	com/tencent/smtt/utils/FileUtil:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   323: iload_2
    //   324: ireturn
    //   325: astore 5
    //   327: aload_1
    //   328: astore 4
    //   330: aload 5
    //   332: astore_1
    //   333: goto +93 -> 426
    //   336: astore 5
    //   338: goto +12 -> 350
    //   341: astore_1
    //   342: goto +84 -> 426
    //   345: astore 5
    //   347: aload 6
    //   349: astore_1
    //   350: aload_1
    //   351: astore 4
    //   353: new 491	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 492	java/lang/StringBuilder:<init>	()V
    //   360: astore 6
    //   362: aload_1
    //   363: astore 4
    //   365: aload 6
    //   367: ldc_w 741
    //   370: invokevirtual 498	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload_1
    //   375: astore 4
    //   377: aload 6
    //   379: aload 5
    //   381: invokevirtual 742	java/lang/Exception:toString	()Ljava/lang/String;
    //   384: invokevirtual 498	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: aload_1
    //   389: astore 4
    //   391: ldc_w 734
    //   394: aload 6
    //   396: invokevirtual 509	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 644	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: aload_1
    //   403: ifnull -264 -> 139
    //   406: aload_1
    //   407: invokevirtual 723	java/io/FileInputStream:close	()V
    //   410: goto -271 -> 139
    //   413: astore 4
    //   415: new 491	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 492	java/lang/StringBuilder:<init>	()V
    //   422: astore_1
    //   423: goto -199 -> 224
    //   426: aload 4
    //   428: ifnull +53 -> 481
    //   431: aload 4
    //   433: invokevirtual 723	java/io/FileInputStream:close	()V
    //   436: goto +45 -> 481
    //   439: astore 4
    //   441: new 491	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 492	java/lang/StringBuilder:<init>	()V
    //   448: astore 5
    //   450: aload 5
    //   452: ldc_w 731
    //   455: invokevirtual 498	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload 5
    //   461: aload 4
    //   463: invokevirtual 732	java/io/IOException:toString	()Ljava/lang/String;
    //   466: invokevirtual 498	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: ldc_w 734
    //   473: aload 5
    //   475: invokevirtual 509	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: invokestatic 644	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   481: getstatic 82	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   484: invokeinterface 705 1 0
    //   489: aload 8
    //   491: aload 7
    //   493: invokestatic 708	com/tencent/smtt/utils/FileUtil:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   496: aload_1
    //   497: athrow
    //   498: aload 8
    //   500: aload 7
    //   502: invokestatic 708	com/tencent/smtt/utils/FileUtil:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   505: iconst_m1
    //   506: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	this	WebView
    //   0	507	1	paramContext	Context
    //   260	64	2	i1	int
    //   134	2	3	bool	boolean
    //   49	154	4	localObject1	Object
    //   214	42	4	localIOException1	java.io.IOException
    //   276	114	4	localObject2	Object
    //   413	19	4	localIOException2	java.io.IOException
    //   439	23	4	localIOException3	java.io.IOException
    //   45	125	5	localObject3	Object
    //   325	6	5	localObject4	Object
    //   336	1	5	localException1	Exception
    //   345	35	5	localException2	Exception
    //   448	26	5	localStringBuilder1	StringBuilder
    //   42	353	6	localStringBuilder2	StringBuilder
    //   8	493	7	localFileOutputStream	java.io.FileOutputStream
    //   21	478	8	localFileLock	java.nio.channels.FileLock
    //   67	126	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   207	211	214	java/io/IOException
    //   261	265	268	java/io/IOException
    //   182	202	325	finally
    //   255	261	325	finally
    //   182	202	336	java/lang/Exception
    //   255	261	336	java/lang/Exception
    //   51	56	341	finally
    //   60	69	341	finally
    //   73	80	341	finally
    //   84	93	341	finally
    //   97	106	341	finally
    //   110	126	341	finally
    //   130	135	341	finally
    //   160	169	341	finally
    //   173	182	341	finally
    //   353	362	341	finally
    //   365	374	341	finally
    //   377	388	341	finally
    //   391	402	341	finally
    //   51	56	345	java/lang/Exception
    //   60	69	345	java/lang/Exception
    //   73	80	345	java/lang/Exception
    //   84	93	345	java/lang/Exception
    //   97	106	345	java/lang/Exception
    //   110	126	345	java/lang/Exception
    //   130	135	345	java/lang/Exception
    //   160	169	345	java/lang/Exception
    //   173	182	345	java/lang/Exception
    //   406	410	413	java/io/IOException
    //   431	436	439	java/io/IOException
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    if (!x.a().b()) {
      com.tencent.smtt.utils.i.a("android.webkit.WebView", "enablePlatformNotifications");
    }
  }
  
  private void f(Context paramContext)
  {
    try
    {
      paramContext = QbSdk.getTbsFolderDir(paramContext);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("core_private");
      paramContext = new File(localStringBuilder.toString(), "pv.db");
      if (!paramContext.exists()) {
        return;
      }
      paramContext.delete();
      return;
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TbsInstaller--getTbsCorePV Exception=");
      localStringBuilder.append(paramContext.toString());
      TbsLog.i("getTbsCorePV", localStringBuilder.toString());
    }
  }
  
  @Deprecated
  public static String findAddress(String paramString)
  {
    if (!x.a().b()) {
      return android.webkit.WebView.findAddress(paramString);
    }
    return null;
  }
  
  public static String getCrashExtraMessage(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tbs_core_version:");
    ((StringBuilder)localObject).append(QbSdk.getTbsVersionForCrash(paramContext));
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("tbs_sdk_version:");
    ((StringBuilder)localObject).append(44069);
    ((StringBuilder)localObject).append(";");
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = "com.tencent.mm".equals(paramContext.getApplicationInfo().packageName);
    i2 = 0;
    i1 = i2;
    if (bool) {}
    try
    {
      try
      {
        Class.forName("de.robv.android.xposed.XposedBridge");
        i1 = 1;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        i1 = i2;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        i1 = i2;
      }
    }
    if (i1 != 0)
    {
      paramContext = new StringBuilder();
      paramContext.append((String)localObject);
      paramContext.append("isXposed=true;");
      return paramContext.toString();
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(f.a(true).d());
    localStringBuilder.append("\n");
    localStringBuilder.append((String)localObject);
    if ((!TbsShareManager.isThirdPartyApp(paramContext)) && (QbSdk.n != null) && (QbSdk.n.containsKey("weapp_id")) && (QbSdk.n.containsKey("weapp_name")))
    {
      paramContext = new StringBuilder();
      paramContext.append("weapp_id:");
      paramContext.append(QbSdk.n.get("weapp_id"));
      paramContext.append(";");
      paramContext.append("weapp_name");
      paramContext.append(":");
      paramContext.append(QbSdk.n.get("weapp_name"));
      paramContext.append(";");
      paramContext = paramContext.toString();
      localStringBuilder.append("\n");
      localStringBuilder.append(paramContext);
    }
    if (localStringBuilder.length() > 8192) {
      return localStringBuilder.substring(localStringBuilder.length() - 8192);
    }
    return localStringBuilder.toString();
  }
  
  public static PackageInfo getCurrentWebViewPackage()
  {
    if (!x.a().b())
    {
      if (Build.VERSION.SDK_INT < 26) {
        return null;
      }
      try
      {
        PackageInfo localPackageInfo = (PackageInfo)com.tencent.smtt.utils.i.a("android.webkit.WebView", "getCurrentWebViewPackage");
        return localPackageInfo;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  @Deprecated
  public static Object getPluginList()
  {
    try
    {
      if (!x.a().b())
      {
        Object localObject1 = com.tencent.smtt.utils.i.a("android.webkit.WebView", "getPluginList");
        return localObject1;
      }
      return null;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public static int getTbsCoreVersion(Context paramContext)
  {
    return QbSdk.getTbsVersion(paramContext);
  }
  
  public static boolean getTbsNeedReboot()
  {
    c();
    return f.a(true).e();
  }
  
  public static int getTbsSDKVersion(Context paramContext)
  {
    return 44069;
  }
  
  private long h()
  {
    synchronized (QbSdk.h)
    {
      if (QbSdk.e)
      {
        QbSdk.g += System.currentTimeMillis() - QbSdk.f;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=");
        localStringBuilder.append(QbSdk.g);
        TbsLog.d("sdkreport", localStringBuilder.toString());
      }
      long l1 = QbSdk.g / 1000L;
      QbSdk.g = 0L;
      QbSdk.f = System.currentTimeMillis();
      return l1;
    }
  }
  
  private void i()
  {
    new Thread(new WebView.7(this)).start();
  }
  
  public static void setDataDirectorySuffix(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      try
      {
        com.tencent.smtt.utils.i.a(Class.forName("android.webkit.WebView"), "setDataDirectorySuffix", new Class[] { String.class }, new Object[] { paramString });
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("data_directory_suffix", paramString);
    QbSdk.initTbsSettings(localHashMap);
  }
  
  public static void setSysDayOrNight(boolean paramBoolean)
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
      Paint localPaint;
      int i1;
      if (!paramBoolean)
      {
        if (y.getAlpha() != NIGHT_MODE_ALPHA)
        {
          localPaint = y;
          i1 = NIGHT_MODE_ALPHA;
        }
      }
      else {
        for (;;)
        {
          localPaint.setAlpha(i1);
          break;
          int i2 = y.getAlpha();
          i1 = 255;
          if (i2 == 255) {
            break;
          }
          localPaint = y;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().a(paramBoolean);
      return;
    }
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Exception:");
        localStringBuilder.append(localException.getStackTrace());
        TbsLog.e("QbSdk", localStringBuilder.toString());
        localException.printStackTrace();
      }
    }
  }
  
  android.webkit.WebView a()
  {
    if (!this.e) {
      return this.g;
    }
    return null;
  }
  
  /* Error */
  void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 533	com/tencent/smtt/sdk/WebView:e	(Landroid/content/Context;)I
    //   5: istore_2
    //   6: iload_2
    //   7: iconst_m1
    //   8: if_icmpeq +38 -> 46
    //   11: new 491	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 492	java/lang/StringBuilder:<init>	()V
    //   18: astore_3
    //   19: aload_3
    //   20: ldc_w 909
    //   23: invokevirtual 498	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_3
    //   28: iload_2
    //   29: iconst_1
    //   30: iadd
    //   31: invokestatic 911	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   34: invokevirtual 498	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_3
    //   39: invokevirtual 509	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore_3
    //   43: goto +7 -> 50
    //   46: ldc_w 913
    //   49: astore_3
    //   50: aload_1
    //   51: invokestatic 688	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   54: astore_1
    //   55: new 491	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 492	java/lang/StringBuilder:<init>	()V
    //   62: astore 4
    //   64: aload 4
    //   66: aload_1
    //   67: invokevirtual 640	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 4
    //   73: getstatic 693	java/io/File:separator	Ljava/lang/String;
    //   76: invokevirtual 498	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 4
    //   82: ldc_w 695
    //   85: invokevirtual 498	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: new 690	java/io/File
    //   92: dup
    //   93: aload 4
    //   95: invokevirtual 509	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: ldc_w 697
    //   101: invokespecial 699	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 917	java/io/File:getParentFile	()Ljava/io/File;
    //   109: invokevirtual 920	java/io/File:mkdirs	()Z
    //   112: pop
    //   113: aload_1
    //   114: invokevirtual 923	java/io/File:isFile	()Z
    //   117: ifeq +10 -> 127
    //   120: aload_1
    //   121: invokevirtual 702	java/io/File:exists	()Z
    //   124: ifne +8 -> 132
    //   127: aload_1
    //   128: invokevirtual 926	java/io/File:createNewFile	()Z
    //   131: pop
    //   132: new 928	java/io/FileOutputStream
    //   135: dup
    //   136: aload_1
    //   137: iconst_0
    //   138: invokespecial 931	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   141: putstatic 84	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   144: getstatic 84	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   147: aload_3
    //   148: invokevirtual 935	java/lang/String:getBytes	()[B
    //   151: invokevirtual 941	java/io/OutputStream:write	([B)V
    //   154: getstatic 84	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   157: ifnull +25 -> 182
    //   160: getstatic 84	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   163: invokevirtual 944	java/io/OutputStream:flush	()V
    //   166: return
    //   167: astore_1
    //   168: getstatic 84	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   171: ifnull +9 -> 180
    //   174: getstatic 84	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   177: invokevirtual 944	java/io/OutputStream:flush	()V
    //   180: aload_1
    //   181: athrow
    //   182: return
    //   183: astore_1
    //   184: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	WebView
    //   0	185	1	paramContext	Context
    //   5	26	2	i1	int
    //   18	130	3	localObject	Object
    //   62	32	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   105	127	167	finally
    //   127	132	167	finally
    //   132	154	167	finally
    //   154	166	183	java/lang/Throwable
    //   168	180	183	java/lang/Throwable
    //   180	182	183	java/lang/Throwable
  }
  
  void a(android.webkit.WebView paramWebView)
  {
    boolean bool = this.e;
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
      Method localMethod = com.tencent.smtt.utils.i.a(localView, "addView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    catch (Throwable paramView) {}
  }
  
  IX5WebViewBase b()
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
      int i1 = Build.VERSION.SDK_INT;
      boolean bool = false;
      if (i1 >= 11)
      {
        Object localObject = com.tencent.smtt.utils.i.a(this.g, "canZoomIn");
        if (localObject == null) {
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
      }
      return bool;
    }
    return this.f.canZoomIn();
  }
  
  @Deprecated
  public boolean canZoomOut()
  {
    if (!this.e)
    {
      int i1 = Build.VERSION.SDK_INT;
      boolean bool = false;
      if (i1 >= 11)
      {
        Object localObject = com.tencent.smtt.utils.i.a(this.g, "canZoomOut");
        if (localObject == null) {
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
      }
      return bool;
    }
    return this.f.canZoomOut();
  }
  
  @Deprecated
  public Picture capturePicture()
  {
    if (!this.e)
    {
      Object localObject = com.tencent.smtt.utils.i.a(this.g, "capturePicture");
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
      com.tencent.smtt.utils.i.a(this.g, "clearView");
      return;
    }
    this.f.clearView();
  }
  
  public int computeHorizontalScrollExtent()
  {
    try
    {
      boolean bool = this.e;
      if (bool)
      {
        localMethod = com.tencent.smtt.utils.i.a(this.f.getView(), "computeHorizontalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.i.a(this.g, "computeHorizontalScrollExtent", new Class[0]);
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
      boolean bool = this.e;
      if (bool)
      {
        localMethod = com.tencent.smtt.utils.i.a(this.f.getView(), "computeHorizontalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.i.a(this.g, "computeHorizontalScrollOffset", new Class[0]);
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
      boolean bool = this.e;
      if (bool) {
        return ((Integer)com.tencent.smtt.utils.i.a(this.f.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.i.a(this.g, "computeHorizontalScrollRange", new Class[0]);
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
      boolean bool = this.e;
      if (bool)
      {
        localMethod = com.tencent.smtt.utils.i.a(this.f.getView(), "computeVerticalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.i.a(this.g, "computeVerticalScrollExtent", new Class[0]);
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
      boolean bool = this.e;
      if (bool)
      {
        localMethod = com.tencent.smtt.utils.i.a(this.f.getView(), "computeVerticalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.i.a(this.g, "computeVerticalScrollOffset", new Class[0]);
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
      boolean bool = this.e;
      if (bool) {
        return ((Integer)com.tencent.smtt.utils.i.a(this.f.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.i.a(this.g, "computeVerticalScrollRange", new Class[0]);
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
    if (this.e) {
      try
      {
        paramString = this.f.createPrintDocumentAdapter(paramString);
        return paramString;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    if (Build.VERSION.SDK_INT < 21) {
      return null;
    }
    return com.tencent.smtt.utils.i.a(this.g, "createPrintDocumentAdapter", new Class[] { String.class }, new Object[] { paramString });
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
      if ((!this.k) && (this.a != 0)) {
        i();
      }
      if (!this.e) {
        this.g.destroy();
      }
      ComponentCallbacks localComponentCallbacks;
      return;
    }
    finally
    {
      try
      {
        ??? = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
        ((Field)???).setAccessible(true);
        localComponentCallbacks = (ComponentCallbacks)((Field)???).get(null);
        if (localComponentCallbacks != null)
        {
          ((Field)???).set(null, null);
          ??? = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
          ((Field)???).setAccessible(true);
          ??? = ((Field)???).get(null);
          if (??? != null)
          {
            synchronized ((List)???)
            {
              ((List)???).remove(localComponentCallbacks);
              return;
            }
            this.f.destroy();
          }
        }
        return;
      }
      catch (Exception localException) {}
      localObject2 = finally;
    }
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
      com.tencent.smtt.utils.i.a(this.g, "dumpViewHierarchyWithProperties", new Class[] { BufferedWriter.class, Integer.TYPE }, new Object[] { paramBufferedWriter, Integer.valueOf(paramInt) });
      return;
    }
    this.f.dumpViewHierarchyWithProperties(paramBufferedWriter, paramInt);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    Method localMethod;
    if (this.e) {
      try
      {
        localMethod = com.tencent.smtt.utils.i.a(this.f.getView(), "evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
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
    if (Build.VERSION.SDK_INT >= 19) {
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
  }
  
  @Deprecated
  public int findAll(String paramString)
  {
    if (!this.e)
    {
      paramString = com.tencent.smtt.utils.i.a(this.g, "findAll", new Class[] { String.class }, new Object[] { paramString });
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
        com.tencent.smtt.utils.i.a(this.g, "findAllAsync", new Class[] { String.class }, new Object[] { paramString });
      }
    }
    else {
      this.f.findAllAsync(paramString);
    }
  }
  
  public View findHierarchyView(String paramString, int paramInt)
  {
    if (!this.e) {
      return (View)com.tencent.smtt.utils.i.a(this.g, "findHierarchyView", new Class[] { String.class, Integer.TYPE }, new Object[] { paramString, Integer.valueOf(paramInt) });
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
      com.tencent.smtt.utils.i.a(this.g, "freeMemory");
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
      Object localObject = com.tencent.smtt.utils.i.a(this.g, "getContentWidth");
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
    boolean bool = false;
    try
    {
      if (!this.e)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return false;
        }
        Object localObject = com.tencent.smtt.utils.i.a(this.g, "getRendererPriorityWaivedWhenNotVisible");
        if (localObject == null) {
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
      }
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public int getRendererRequestedPriority()
  {
    int i1 = 0;
    try
    {
      if (!this.e)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return 0;
        }
        Object localObject = com.tencent.smtt.utils.i.a(this.g, "getRendererRequestedPriority");
        if (localObject == null) {
          return 0;
        }
        i1 = ((Integer)localObject).intValue();
      }
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  @Deprecated
  public float getScale()
  {
    if (!this.e)
    {
      Object localObject = com.tencent.smtt.utils.i.a(this.g, "getScale");
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
    WebSettings localWebSettings = this.h;
    if (localWebSettings != null) {
      return localWebSettings;
    }
    if (this.e) {}
    for (localWebSettings = new WebSettings(this.f.getSettings());; localWebSettings = new WebSettings(this.g.getSettings()))
    {
      this.h = localWebSettings;
      return localWebSettings;
    }
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
      Object localObject = com.tencent.smtt.utils.i.a(this.g, "getVisibleTitleHeight");
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
      return (View)com.tencent.smtt.utils.i.a(this.g, "getZoomControls");
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
      int i1 = Build.VERSION.SDK_INT;
      boolean bool = false;
      if (i1 >= 11)
      {
        Object localObject = com.tencent.smtt.utils.i.a(this.g, "isPrivateBrowsingEnabled");
        if (localObject == null) {
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
      }
      return bool;
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
    if (this.e)
    {
      o localo = this.l;
      if ((localo != null) && (!this.m)) {
        localo.a("load_url_gap", (byte)2);
      }
    }
    if (paramString != null)
    {
      if (showDebugView(paramString)) {
        return;
      }
      if (!this.e)
      {
        this.g.loadUrl(paramString);
        return;
      }
      this.f.loadUrl(paramString);
    }
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    if (this.e)
    {
      o localo = this.l;
      if ((localo != null) && (!this.m)) {
        localo.a("load_url_gap", (byte)2);
      }
    }
    if (paramString != null)
    {
      if (showDebugView(paramString)) {
        return;
      }
      if (!this.e)
      {
        if (Build.VERSION.SDK_INT >= 8) {
          this.g.loadUrl(paramString, paramMap);
        }
      }
      else {
        this.f.loadUrl(paramString, paramMap);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((!this.k) && (this.a != 0)) {
      i();
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    View.OnLongClickListener localOnLongClickListener = this.B;
    if (localOnLongClickListener != null)
    {
      if (!localOnLongClickListener.onLongClick(paramView)) {
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
      com.tencent.smtt.utils.i.a(this.g, "onPause");
      return;
    }
    this.f.onPause();
  }
  
  public void onResume()
  {
    if (!this.e)
    {
      com.tencent.smtt.utils.i.a(this.g, "onResume");
      return;
    }
    this.f.onResume();
  }
  
  @TargetApi(11)
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT >= 21) && (c(this.i)) && (isHardwareAccelerated()) && (paramInt1 > 0) && (paramInt2 > 0)) {
      getLayerType();
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    Object localObject = this.i;
    if (localObject == null)
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    if (s == null) {
      s = ((Context)localObject).getApplicationInfo().packageName;
    }
    localObject = s;
    if ((localObject != null) && ((((String)localObject).equals("com.tencent.mm")) || (s.equals("com.tencent.mobileqq"))))
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    if ((paramInt != 0) && (!this.k) && (this.a != 0)) {
      i();
    }
    super.onVisibilityChanged(paramView, paramInt);
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
      com.tencent.smtt.utils.i.a(this.g, "refreshPlugins", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
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
        com.tencent.smtt.utils.i.a(this.g, "removeJavascriptInterface", new Class[] { String.class }, new Object[] { paramString });
      }
    }
    else {
      this.f.removeJavascriptInterface(paramString);
    }
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
      Method localMethod = com.tencent.smtt.utils.i.a(localView, "removeView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public JSONObject reportInitPerformance(long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("IS_X5", this.e);
    }
    catch (JSONException localJSONException1)
    {
      localJSONException1.printStackTrace();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportInitPerformance initType is ");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(" isX5Core is ");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(" isPerformanceDataRecorded");
    ((StringBuilder)localObject).append(this.m);
    TbsLog.i("sdkreport", ((StringBuilder)localObject).toString());
    if (this.e)
    {
      localObject = this.l;
      if ((localObject != null) && (!this.m))
      {
        ((o)localObject).a("init_type", paramLong1);
        this.l.a("time_oncreate", paramLong2);
        this.l.a("webview_type", paramInt);
        this.l.a("time_webaccelerator", paramLong3);
        if (this.l.a(this.f.hashCode(), getUrl())) {
          this.m = true;
        }
        localObject = this.l.a();
        try
        {
          localJSONObject.put("DETAIL", localObject);
          return localJSONObject;
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
    return localJSONObject;
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    if (this.e)
    {
      localObject2 = this.f.getView();
      if ((localObject2 instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)localObject2;
        localObject1 = paramView;
        if (paramView == this) {
          localObject1 = localObject2;
        }
        return localViewGroup.requestChildRectangleOnScreen((View)localObject1, paramRect, paramBoolean);
      }
      return false;
    }
    Object localObject2 = this.g;
    Object localObject1 = paramView;
    if (paramView == this) {
      localObject1 = localObject2;
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
      paramBundle = com.tencent.smtt.utils.i.a(this.g, "restorePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
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
      com.tencent.smtt.utils.i.a(this.g, "savePassword", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
      return;
    }
    this.f.savePassword(paramString1, paramString2, paramString3);
  }
  
  @Deprecated
  public boolean savePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.e)
    {
      paramBundle = com.tencent.smtt.utils.i.a(this.g, "savePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
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
        com.tencent.smtt.utils.i.a(this.g, "saveWebArchive", new Class[] { String.class }, new Object[] { paramString });
      }
    }
    else {
      this.f.saveWebArchive(paramString);
    }
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString, boolean paramBoolean, ValueCallback<String> paramValueCallback)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        com.tencent.smtt.utils.i.a(this.g, "saveWebArchive", new Class[] { String.class, Boolean.TYPE, android.webkit.ValueCallback.class }, new Object[] { paramString, Boolean.valueOf(paramBoolean), paramValueCallback });
      }
    }
    else {
      this.f.saveWebArchive(paramString, paramBoolean, paramValueCallback);
    }
  }
  
  public void setARModeEnable(boolean paramBoolean)
  {
    try
    {
      if (this.e)
      {
        getSettingsExtension().setARModeEnable(paramBoolean);
        return;
      }
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
    } else {
      this.f.setBackgroundColor(paramInt);
    }
    super.setBackgroundColor(paramInt);
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
    boolean bool = this.e;
    if (!bool)
    {
      this.g.setDownloadListener(new WebView.4(this, paramDownloadListener));
      return;
    }
    this.f.setDownloadListener(new b(this, paramDownloadListener, bool));
  }
  
  @TargetApi(16)
  public void setFindListener(IX5WebViewBase.FindListener paramFindListener)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.g.setFindListener(new WebView.3(this, paramFindListener));
      }
    }
    else {
      this.f.setFindListener(paramFindListener);
    }
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
      com.tencent.smtt.utils.i.a(this.g, "setMapTrackballToArrowKeys", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
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
    }
    else {
      this.f.setNetworkAvailable(paramBoolean);
    }
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
        Object localObject2 = com.tencent.smtt.utils.i.a(localObject1, "getListenerInfo", new Class[0]);
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
  
  @Deprecated
  public void setPictureListener(WebView.PictureListener paramPictureListener)
  {
    if (!this.e)
    {
      if (paramPictureListener == null)
      {
        this.g.setPictureListener(null);
        return;
      }
      this.g.setPictureListener(new WebView.5(this, paramPictureListener));
      return;
    }
    if (paramPictureListener == null)
    {
      this.f.setPictureListener(null);
      return;
    }
    this.f.setPictureListener(new WebView.6(this, paramPictureListener));
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
        com.tencent.smtt.utils.i.a(this.g, "setRendererPriorityPolicy", new Class[] { Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      }
      return;
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
      } else {
        paramContext.putInt("DefaultVideoScreen", 1);
      }
      this.f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", paramContext);
      return true;
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
    boolean bool = this.e;
    IX5WebViewBase localIX5WebViewBase = null;
    Object localObject = null;
    if (bool)
    {
      localIX5WebViewBase = this.f;
      if (paramWebChromeClient != null) {
        localObject = new h(x.a().a(true).i(), this, paramWebChromeClient);
      }
      localIX5WebViewBase.setWebChromeClient((IX5WebChromeClient)localObject);
    }
    else
    {
      WebView.b localb = this.g;
      if (paramWebChromeClient == null) {
        localObject = localIX5WebViewBase;
      } else {
        localObject = new SystemWebChromeClient(this, paramWebChromeClient);
      }
      localb.setWebChromeClient((android.webkit.WebChromeClient)localObject);
    }
    this.r = paramWebChromeClient;
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
    boolean bool = this.e;
    IX5WebViewBase localIX5WebViewBase = null;
    Object localObject = null;
    if (bool)
    {
      localIX5WebViewBase = this.f;
      if (paramWebViewClient != null) {
        localObject = new i(x.a().a(true).j(), this, paramWebViewClient);
      }
      localIX5WebViewBase.setWebViewClient((IX5WebViewClient)localObject);
    }
    else
    {
      WebView.b localb = this.g;
      if (paramWebViewClient == null) {
        localObject = localIX5WebViewBase;
      } else {
        localObject = new SystemWebViewClient(this, paramWebViewClient);
      }
      localb.setWebViewClient((android.webkit.WebViewClient)localObject);
    }
    this.q = paramWebViewClient;
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
    paramString = paramString.toLowerCase();
    if (paramString.startsWith("https://debugtbs.qq.com"))
    {
      getView().setVisibility(4);
      d.a(this.i).a(paramString, this, this.i, n.a().getLooper());
      return true;
    }
    if ((paramString.startsWith("https://debugx5.qq.com")) && (!this.e))
    {
      paramString = new StringBuilder();
      paramString.append("<!DOCTYPE html><html><body>");
      paramString.append("<head>");
      paramString.append("<title>无法打开debugx5</title>");
      paramString.append("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" />");
      paramString.append("</head>");
      paramString.append("<br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />");
      paramString.append("尝试<a href=\"https://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a>");
      paramString.append("</body></html>");
      loadDataWithBaseURL(null, paramString.toString(), "text/html", "utf-8", null);
      return true;
    }
    return false;
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
      com.tencent.smtt.utils.i.a(localView, "super_computeScroll");
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
      paramMotionEvent = com.tencent.smtt.utils.i.a(localView, "super_dispatchTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
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
      paramMotionEvent = com.tencent.smtt.utils.i.a(localView, "super_onInterceptTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
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
      com.tencent.smtt.utils.i.a(localView, "super_onOverScrolled", new Class[] { Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
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
      com.tencent.smtt.utils.i.a(localView, "super_onScrollChanged", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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
      paramMotionEvent = com.tencent.smtt.utils.i.a(localView, "super_onTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
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
      localObject = com.tencent.smtt.utils.i.a(localObject, "super_overScrollBy", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Boolean.valueOf(paramBoolean) });
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
    String str;
    if (z)
    {
      TbsLog.e("QB_SDK", "deleteNightMode");
      str = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
    }
    else
    {
      TbsLog.e("QB_SDK", "nightMode");
      str = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
    }
    loadUrl(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView
 * JD-Core Version:    0.7.0.1
 */