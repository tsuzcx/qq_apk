package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
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
import com.tencent.smtt.sdk.stat.HttpUtils;
import com.tencent.smtt.utils.DebugTbsPlugin;
import com.tencent.smtt.utils.ReflectionUtils;
import com.tencent.smtt.utils.TbsConfigFile;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
  private static final String LOGTAG = "webview";
  public static int NIGHT_MODE_ALPHA = 153;
  public static final int NIGHT_MODE_COLOR = -16777216;
  public static final int NORMAL_MODE_ALPHA = 255;
  private static final String QQ_PACKAGE_NAME = "com.tencent.mobileqq";
  public static final String SCHEME_GEO = "geo:0,0?q=";
  public static final String SCHEME_MAILTO = "mailto:";
  public static final String SCHEME_TEL = "tel:";
  private static final String WX_PACKAGE_NAME = "com.tencent.mm";
  private static Context mAppContext;
  private static String mCallerAppPackageName;
  private static boolean mIsDayMode;
  private static Paint mNightModePaint;
  public static boolean mSysWebviewCreated;
  private static TbsConfigFile mTbsConfig;
  private static final Lock mTbsPvLock = new ReentrantLock();
  public static boolean mWebViewCreated;
  private static OutputStream outputStream = null;
  private static BroadcastReceiver sConnectivityChangeReceiver;
  private static Method sWebviewsetWebContentsDebuggingEnabled;
  private final int ATTRIBUTE_SCROLLBARS_HORIZONTAL = 2;
  private final int ATTRIBUTE_SCROLLBARS_NONE = 1;
  private final int ATTRIBUTE_SCROLLBARS_VERTICAL = 3;
  private final String LOG_TAG = "WebView";
  private final String deleteNightMode = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
  private boolean isPerformanceDataRecorded = false;
  protected boolean isX5Core = false;
  private Object longClickListener = null;
  private Context mContext = null;
  private boolean mIsReported = false;
  private View.OnLongClickListener mOnLongClickListener = null;
  int mPv = 0;
  private TbsInitPerformanceRecorder mRecorder = null;
  protected WebView.SystemWebView mSysWebView;
  private WebChromeClient mWebChromeClient = null;
  private WebSettings mWebSettings = null;
  public WebViewCallbackClient mWebViewCallbackClient;
  private WebViewClient mWebViewClient = null;
  private IX5WebViewBase mX5WebView;
  private final String nightMode = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
  
  static
  {
    mAppContext = null;
    sConnectivityChangeReceiver = null;
    mWebViewCreated = false;
    mTbsConfig = null;
    sWebviewsetWebContentsDebuggingEnabled = null;
    mCallerAppPackageName = null;
    mSysWebviewCreated = false;
    mNightModePaint = null;
    mIsDayMode = true;
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
    this.mRecorder = new TbsInitPerformanceRecorder();
    this.mRecorder.recordPerformanceEvent("init_all", (byte)1);
    if ((QbSdk.getIsSysWebViewForcedByOuter()) && (TbsShareManager.isThirdPartyApp(paramContext)))
    {
      this.mContext = paramContext;
      this.mX5WebView = null;
      this.isX5Core = false;
      QbSdk.forceSysWebViewInner(paramContext, "failed to createTBSWebview!");
      this.mSysWebView = new WebView.SystemWebView(this, paramContext, paramAttributeSet);
      CookieManager.getInstance().compatiableCookieDatabaseIfNeed(paramContext, true, false);
      CookieSyncManager.createInstance(this.mContext).startSync();
    }
    try
    {
      paramAttributeSet = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
      paramAttributeSet.setAccessible(true);
      ((Handler)paramAttributeSet.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
      mSysWebviewCreated = true;
      label239:
      CookieManager.getInstance().syncCookies();
      this.mSysWebView.setFocusableInTouchMode(true);
      addView(this.mSysWebView, new FrameLayout.LayoutParams(-1, -1));
      TbsLog.i("WebView", "SystemWebView Created Success! #3");
      TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 402, new Throwable());
      return;
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsLog.setWriteLogJIT(true);
      }
      for (;;)
      {
        this.mRecorder.recordPerformanceEvent("tbslog_init", (byte)1);
        TbsLog.initIfNeed(paramContext);
        this.mRecorder.recordPerformanceEvent("tbslog_init", (byte)2);
        if (paramContext != null) {
          break;
        }
        throw new IllegalArgumentException("Invalid context argument");
        TbsLog.setWriteLogJIT(false);
      }
      if (mTbsConfig == null) {
        mTbsConfig = TbsConfigFile.getInstance(paramContext);
      }
      if (mTbsConfig.mForceUseSystemWebview)
      {
        TbsLog.e("WebView", "sys WebView: debug.conf force syswebview", true);
        QbSdk.forceSysWebViewInner(paramContext, "debug.conf force syswebview!");
      }
      init(paramContext, this.mRecorder);
      this.mContext = paramContext;
      if (paramContext != null) {
        mAppContext = paramContext.getApplicationContext();
      }
      if ((this.isX5Core) && (!QbSdk.mIsSysWebViewForced))
      {
        this.mRecorder.recordPerformanceEvent("init_x5_webview", (byte)1);
        this.mX5WebView = X5CoreEngine.getInstance().wizardForCoreTypeConfirmed(true).createSDKWebview(paramContext);
        this.mRecorder.recordPerformanceEvent("init_x5_webview", (byte)2);
        if ((this.mX5WebView == null) || (this.mX5WebView.getView() == null))
        {
          TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
          this.mX5WebView = null;
          this.isX5Core = false;
          QbSdk.forceSysWebViewInner(paramContext, "failed to createTBSWebview!");
          init(paramContext, this.mRecorder);
          if (TbsShareManager.isThirdPartyApp(this.mContext)) {
            this.mSysWebView = new WebView.SystemWebView(this, paramContext, paramAttributeSet);
          }
          for (;;)
          {
            TbsLog.i("WebView", "SystemWebView Created Success! #1");
            CookieManager.getInstance().compatiableCookieDatabaseIfNeed(paramContext, true, false);
            CookieManager.getInstance().syncCookies();
            this.mSysWebView.setFocusableInTouchMode(true);
            addView(this.mSysWebView, new FrameLayout.LayoutParams(-1, -1));
            try
            {
              if (Build.VERSION.SDK_INT >= 11)
              {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
              }
              registerConnectivityChangedReceiverIfNeeded(paramContext);
              TbsLog.writeLogToDisk();
              TbsInstaller.UploadIfTempCoreExistConfError(paramContext);
              return;
              this.mSysWebView = new WebView.SystemWebView(this, paramContext);
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
        this.mX5WebView.getView().setFocusableInTouchMode(true);
        setAttributeForX5(paramAttributeSet);
        addView(this.mX5WebView.getView(), new FrameLayout.LayoutParams(-1, -1));
        this.mX5WebView.setDownloadListener(new DownLoadListenerAdapter(this, null, this.isX5Core));
        this.mX5WebView.getX5WebViewExtension().setWebViewClientExtension(new WebView.1(this, X5CoreEngine.getInstance().wizardForCoreTypeConfirmed(true).createDefaultX5WebChromeClientExtension()));
      }
      try
      {
        if (Build.VERSION.SDK_INT >= 11)
        {
          removeJavascriptInterface("searchBoxJavaBridge_");
          removeJavascriptInterface("accessibility");
          removeJavascriptInterface("accessibilityTraversal");
        }
        if ((("com.tencent.mobileqq".equals(this.mContext.getApplicationInfo().packageName)) || ("com.tencent.mm".equals(this.mContext.getApplicationInfo().packageName))) && (SDKEngine.getInstance(true).useSoftWare()) && (Build.VERSION.SDK_INT >= 11)) {
          setLayerType(1, null);
        }
        if (this.mX5WebView != null)
        {
          TbsLog.writeLogToDisk();
          if (!TbsShareManager.isThirdPartyApp(paramContext))
          {
            paramInt = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
            if ((paramInt <= 0) || (paramInt == TbsInstaller.getInstance().getTbsCoreShareDecoupleCoreVersion(paramContext)) || (paramInt != TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext))) {
              break label1081;
            }
            TbsInstaller.getInstance().coreShareCopyToDecouple(paramContext);
          }
        }
        if (this.mRecorder != null)
        {
          this.mRecorder.recordPerformanceEvent("load_url_gap", (byte)1);
          this.mRecorder.recordPerformanceEvent("init_all", (byte)2);
        }
        QbSdk.continueLoadSo(paramContext);
        return;
        this.mX5WebView = null;
        if (TbsShareManager.isThirdPartyApp(this.mContext)) {}
        for (this.mSysWebView = new WebView.SystemWebView(this, paramContext, paramAttributeSet);; this.mSysWebView = new WebView.SystemWebView(this, paramContext))
        {
          TbsLog.i("WebView", "SystemWebView Created Success! #2");
          CookieManager.getInstance().compatiableCookieDatabaseIfNeed(paramContext, true, false);
          CookieManager.getInstance().syncCookies();
          this.mSysWebView.setFocusableInTouchMode(true);
          addView(this.mSysWebView, new FrameLayout.LayoutParams(-1, -1));
          setDownloadListener(null);
          registerConnectivityChangedReceiverIfNeeded(paramContext);
          TbsLog.writeLogToDisk();
          TbsInstaller.UploadIfTempCoreExistConfError(paramContext);
          break;
        }
      }
      catch (Throwable paramAttributeSet)
      {
        for (;;)
        {
          paramAttributeSet.printStackTrace();
          continue;
          label1081:
          TbsLog.i("WebView", "webview construction #1 deCoupleCoreVersion is " + paramInt + " getTbsCoreShareDecoupleCoreVersion is " + TbsInstaller.getInstance().getTbsCoreShareDecoupleCoreVersion(paramContext) + " getTbsCoreInstalledVerInNolock is " + TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext));
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
  
  private boolean callX5CoreOnLongClick(View paramView)
  {
    if ((this.mContext != null) && (getTbsCoreVersion(this.mContext) > 36200)) {
      return false;
    }
    paramView = ReflectionUtils.invokeInstance(this.longClickListener, "onLongClick", new Class[] { View.class }, new Object[] { paramView });
    if (paramView != null) {
      return ((Boolean)paramView).booleanValue();
    }
    return false;
  }
  
  private void deletepvfile(Context paramContext)
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
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    if (!X5CoreEngine.getInstance().isX5Core()) {
      ReflectionUtils.invokeStatic("android.webkit.WebView", "disablePlatformNotifications");
    }
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    if (!X5CoreEngine.getInstance().isX5Core()) {
      ReflectionUtils.invokeStatic("android.webkit.WebView", "enablePlatformNotifications");
    }
  }
  
  public static String findAddress(String paramString)
  {
    if (!X5CoreEngine.getInstance().isX5Core()) {
      return android.webkit.WebView.findAddress(paramString);
    }
    return null;
  }
  
  public static String getCrashExtraMessage(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    String str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(paramContext) + ";tbs_sdk_version:" + 43739 + ";";
    if ("com.tencent.mm".equals(paramContext.getApplicationInfo().packageName)) {}
    for (;;)
    {
      try
      {
        Class.forName("de.robv.android.xposed.XposedBridge");
        i = 1;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        i = 0;
        continue;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        i = 0;
        continue;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(SDKEngine.getInstance(true).getCrashExtraMessage());
        localStringBuilder.append("\n");
        localStringBuilder.append(str);
        if ((TbsShareManager.isThirdPartyApp(paramContext)) || (QbSdk.mSettings == null) || (!QbSdk.mSettings.containsKey("weapp_id")) || (!QbSdk.mSettings.containsKey("weapp_name"))) {
          continue;
        }
        paramContext = "weapp_id:" + QbSdk.mSettings.get("weapp_id") + ";" + "weapp_name" + ":" + QbSdk.mSettings.get("weapp_name") + ";";
        localStringBuilder.append("\n");
        localStringBuilder.append(paramContext);
        if (localStringBuilder.length() <= 8192) {
          continue;
        }
        return localStringBuilder.substring(localStringBuilder.length() - 8192);
        return localStringBuilder.toString();
      }
      if (i != 0) {
        return str + "isXposed=true;";
      }
      int i = 0;
    }
  }
  
  public static PackageInfo getCurrentWebViewPackage()
  {
    if (!X5CoreEngine.getInstance().isX5Core())
    {
      if (Build.VERSION.SDK_INT < 26) {
        return null;
      }
      try
      {
        PackageInfo localPackageInfo = (PackageInfo)ReflectionUtils.invokeStatic("android.webkit.WebView", "getCurrentWebViewPackage");
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
    //   3: invokestatic 363	com/tencent/smtt/sdk/X5CoreEngine:getInstance	()Lcom/tencent/smtt/sdk/X5CoreEngine;
    //   6: invokevirtual 614	com/tencent/smtt/sdk/X5CoreEngine:isX5Core	()Z
    //   9: ifne +18 -> 27
    //   12: ldc_w 616
    //   15: ldc_w 690
    //   18: invokestatic 621	com/tencent/smtt/utils/ReflectionUtils:invokeStatic	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
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
  
  /* Error */
  private int getTbsCorePV(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: ldc_w 694
    //   5: invokestatic 700	com/tencent/smtt/utils/FileUtil:getLockFos	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   8: astore 6
    //   10: aload 6
    //   12: ifnull +16 -> 28
    //   15: aload_1
    //   16: aload 6
    //   18: invokestatic 704	com/tencent/smtt/utils/FileUtil:tryFileLock	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   21: astore 7
    //   23: aload 7
    //   25: ifnonnull +5 -> 30
    //   28: iconst_m1
    //   29: ireturn
    //   30: getstatic 91	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   33: invokeinterface 709 1 0
    //   38: ifeq +472 -> 510
    //   41: aconst_null
    //   42: astore 5
    //   44: aload_1
    //   45: invokestatic 585	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   48: astore_1
    //   49: new 587	java/io/File
    //   52: dup
    //   53: new 520	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 521	java/lang/StringBuilder:<init>	()V
    //   60: aload_1
    //   61: invokevirtual 590	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   64: getstatic 593	java/io/File:separator	Ljava/lang/String;
    //   67: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc_w 595
    //   73: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: ldc_w 597
    //   82: invokespecial 599	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +12 -> 99
    //   90: aload_1
    //   91: invokevirtual 602	java/io/File:exists	()Z
    //   94: istore_3
    //   95: iload_3
    //   96: ifne +65 -> 161
    //   99: iconst_0
    //   100: ifeq +11 -> 111
    //   103: new 711	java/lang/NullPointerException
    //   106: dup
    //   107: invokespecial 712	java/lang/NullPointerException:<init>	()V
    //   110: athrow
    //   111: getstatic 91	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   114: invokeinterface 715 1 0
    //   119: aload 7
    //   121: aload 6
    //   123: invokestatic 719	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   126: iconst_m1
    //   127: ireturn
    //   128: astore_1
    //   129: ldc_w 607
    //   132: new 520	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 521	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 721
    //   142: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_1
    //   146: invokevirtual 722	java/io/IOException:toString	()Ljava/lang/String;
    //   149: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 724	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: goto -47 -> 111
    //   161: new 726	java/util/Properties
    //   164: dup
    //   165: invokespecial 727	java/util/Properties:<init>	()V
    //   168: astore 8
    //   170: new 729	java/io/FileInputStream
    //   173: dup
    //   174: aload_1
    //   175: invokespecial 732	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   178: astore 4
    //   180: aload 4
    //   182: astore_1
    //   183: aload 8
    //   185: aload 4
    //   187: invokevirtual 736	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   190: aload 4
    //   192: astore_1
    //   193: aload 4
    //   195: invokevirtual 739	java/io/FileInputStream:close	()V
    //   198: aload 4
    //   200: astore_1
    //   201: aload 8
    //   203: ldc_w 741
    //   206: invokevirtual 744	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   209: astore 5
    //   211: aload 5
    //   213: ifnonnull +63 -> 276
    //   216: aload 4
    //   218: ifnull +8 -> 226
    //   221: aload 4
    //   223: invokevirtual 739	java/io/FileInputStream:close	()V
    //   226: getstatic 91	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   229: invokeinterface 715 1 0
    //   234: aload 7
    //   236: aload 6
    //   238: invokestatic 719	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   241: iconst_m1
    //   242: ireturn
    //   243: astore_1
    //   244: ldc_w 607
    //   247: new 520	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 521	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 721
    //   257: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_1
    //   261: invokevirtual 722	java/io/IOException:toString	()Ljava/lang/String;
    //   264: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 724	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: goto -47 -> 226
    //   276: aload 4
    //   278: astore_1
    //   279: aload 5
    //   281: invokestatic 750	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   284: istore_2
    //   285: aload 4
    //   287: ifnull +8 -> 295
    //   290: aload 4
    //   292: invokevirtual 739	java/io/FileInputStream:close	()V
    //   295: getstatic 91	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   298: invokeinterface 715 1 0
    //   303: aload 7
    //   305: aload 6
    //   307: invokestatic 719	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   310: iload_2
    //   311: ireturn
    //   312: astore_1
    //   313: ldc_w 607
    //   316: new 520	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 521	java/lang/StringBuilder:<init>	()V
    //   323: ldc_w 721
    //   326: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_1
    //   330: invokevirtual 722	java/io/IOException:toString	()Ljava/lang/String;
    //   333: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 724	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: goto -47 -> 295
    //   345: astore 5
    //   347: aconst_null
    //   348: astore 4
    //   350: aload 4
    //   352: astore_1
    //   353: ldc_w 607
    //   356: new 520	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 521	java/lang/StringBuilder:<init>	()V
    //   363: ldc_w 609
    //   366: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload 5
    //   371: invokevirtual 610	java/lang/Exception:toString	()Ljava/lang/String;
    //   374: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 724	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload 4
    //   385: ifnull +8 -> 393
    //   388: aload 4
    //   390: invokevirtual 739	java/io/FileInputStream:close	()V
    //   393: getstatic 91	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   396: invokeinterface 715 1 0
    //   401: aload 7
    //   403: aload 6
    //   405: invokestatic 719	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   408: iconst_m1
    //   409: ireturn
    //   410: astore_1
    //   411: ldc_w 607
    //   414: new 520	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 521	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 721
    //   424: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_1
    //   428: invokevirtual 722	java/io/IOException:toString	()Ljava/lang/String;
    //   431: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 724	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: goto -47 -> 393
    //   443: astore_1
    //   444: aload 5
    //   446: astore 4
    //   448: aload 4
    //   450: ifnull +8 -> 458
    //   453: aload 4
    //   455: invokevirtual 739	java/io/FileInputStream:close	()V
    //   458: getstatic 91	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   461: invokeinterface 715 1 0
    //   466: aload 7
    //   468: aload 6
    //   470: invokestatic 719	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   473: aload_1
    //   474: athrow
    //   475: astore 4
    //   477: ldc_w 607
    //   480: new 520	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 521	java/lang/StringBuilder:<init>	()V
    //   487: ldc_w 721
    //   490: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: aload 4
    //   495: invokevirtual 722	java/io/IOException:toString	()Ljava/lang/String;
    //   498: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokestatic 724	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: goto -49 -> 458
    //   510: aload 7
    //   512: aload 6
    //   514: invokestatic 719	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
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
    //   284	27	2	i	int
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
  
  public static int getTbsCoreVersion(Context paramContext)
  {
    return QbSdk.getTbsVersion(paramContext);
  }
  
  public static boolean getTbsNeedReboot()
  {
    updateRebootStatus();
    return SDKEngine.getInstance(true).getTbsNeedReboot();
  }
  
  public static int getTbsSDKVersion(Context paramContext)
  {
    return 43739;
  }
  
  private long getWifiConnectedTime()
  {
    synchronized (QbSdk.sApnLock)
    {
      if (QbSdk.sIsApnWifi)
      {
        QbSdk.sWifiConnectedTime += System.currentTimeMillis() - QbSdk.sApnRecordTime;
        TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.sWifiConnectedTime);
      }
      long l = QbSdk.sWifiConnectedTime / 1000L;
      QbSdk.sWifiConnectedTime = 0L;
      QbSdk.sApnRecordTime = System.currentTimeMillis();
      return l;
    }
  }
  
  private void init(Context paramContext, TbsInitPerformanceRecorder paramTbsInitPerformanceRecorder)
  {
    if ((QbSdk.mIsBuglyEnabled) && (TbsShareManager.isThirdPartyApp(paramContext))) {
      TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(paramContext);
    }
    if (paramTbsInitPerformanceRecorder != null) {
      paramTbsInitPerformanceRecorder.recordPerformanceEvent("x5_core_engine_init_sync", (byte)1);
    }
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    localX5CoreEngine.init(paramContext, paramTbsInitPerformanceRecorder);
    this.isX5Core = localX5CoreEngine.isX5Core();
  }
  
  private boolean isQQ(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageName().indexOf("com.tencent.mobileqq");
      if (i >= 0) {
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private void registerConnectivityChangedReceiverIfNeeded(Context paramContext)
  {
    if (sConnectivityChangeReceiver != null) {
      return;
    }
    sConnectivityChangeReceiver = new WebView.ConnectivityChangedReceiver(null);
    new WebView.2(this, paramContext).start();
  }
  
  private void setAttributeForX5(AttributeSet paramAttributeSet)
  {
    int i = 0;
    if (paramAttributeSet != null) {}
    for (;;)
    {
      int[] arrayOfInt;
      int k;
      try
      {
        int j = paramAttributeSet.getAttributeCount();
        if (i < j)
        {
          if (!paramAttributeSet.getAttributeName(i).equalsIgnoreCase("scrollbars")) {
            break label147;
          }
          arrayOfInt = getResources().getIntArray(16842974);
          k = paramAttributeSet.getAttributeIntValue(i, -1);
          if (k == arrayOfInt[1])
          {
            this.mX5WebView.getView().setVerticalScrollBarEnabled(false);
            this.mX5WebView.getView().setHorizontalScrollBarEnabled(false);
          }
          else if (k == arrayOfInt[2])
          {
            this.mX5WebView.getView().setVerticalScrollBarEnabled(false);
          }
        }
      }
      catch (Exception paramAttributeSet)
      {
        paramAttributeSet.printStackTrace();
      }
      return;
      if (k == arrayOfInt[3]) {
        this.mX5WebView.getView().setHorizontalScrollBarEnabled(false);
      }
      label147:
      i += 1;
    }
  }
  
  public static void setSysDayOrNight(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = mIsDayMode;
        if (paramBoolean == bool) {
          return;
        }
        mIsDayMode = paramBoolean;
        if (mNightModePaint == null)
        {
          mNightModePaint = new Paint();
          mNightModePaint.setColor(-16777216);
        }
        if (!paramBoolean)
        {
          if (mNightModePaint.getAlpha() == NIGHT_MODE_ALPHA) {
            continue;
          }
          mNightModePaint.setAlpha(NIGHT_MODE_ALPHA);
          continue;
        }
        if (mNightModePaint.getAlpha() == 255) {
          continue;
        }
      }
      finally {}
      mNightModePaint.setAlpha(255);
    }
  }
  
  public static void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      localX5CoreEngine.wizard().webview_setWebContentsDebuggingEnabled(paramBoolean);
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 19) {
        try
        {
          sWebviewsetWebContentsDebuggingEnabled = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", new Class[] { Boolean.TYPE });
          if (sWebviewsetWebContentsDebuggingEnabled != null)
          {
            sWebviewsetWebContentsDebuggingEnabled.setAccessible(true);
            sWebviewsetWebContentsDebuggingEnabled.invoke(null, new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  static void updateRebootStatus()
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
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.addJavascriptInterface(paramObject, paramString);
      return;
    }
    this.mX5WebView.addJavascriptInterface(paramObject, paramString);
  }
  
  public void addView(View paramView)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.addView(paramView);
      return;
    }
    View localView = this.mX5WebView.getView();
    try
    {
      Method localMethod = ReflectionUtils.getParentDeclaredMethod(localView, "addView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public boolean canGoBack()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.canGoBack();
    }
    return this.mX5WebView.canGoBack();
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.canGoBackOrForward(paramInt);
    }
    return this.mX5WebView.canGoBackOrForward(paramInt);
  }
  
  public boolean canGoForward()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.canGoForward();
    }
    return this.mX5WebView.canGoForward();
  }
  
  @Deprecated
  public boolean canZoomIn()
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "canZoomIn");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.mX5WebView.canZoomIn();
  }
  
  @Deprecated
  public boolean canZoomOut()
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "canZoomOut");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.mX5WebView.canZoomOut();
  }
  
  @Deprecated
  public Picture capturePicture()
  {
    if (!this.isX5Core)
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "capturePicture");
      if (localObject == null) {
        return null;
      }
      return (Picture)localObject;
    }
    return this.mX5WebView.capturePicture();
  }
  
  public void clearCache(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearCache(paramBoolean);
      return;
    }
    this.mX5WebView.clearCache(paramBoolean);
  }
  
  public void clearFormData()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearFormData();
      return;
    }
    this.mX5WebView.clearFormData();
  }
  
  public void clearHistory()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearHistory();
      return;
    }
    this.mX5WebView.clearHistory();
  }
  
  @TargetApi(3)
  public void clearMatches()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearMatches();
      return;
    }
    this.mX5WebView.clearMatches();
  }
  
  public void clearSslPreferences()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearSslPreferences();
      return;
    }
    this.mX5WebView.clearSslPreferences();
  }
  
  @Deprecated
  public void clearView()
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "clearView");
      return;
    }
    this.mX5WebView.clearView();
  }
  
  public int computeHorizontalScrollExtent()
  {
    try
    {
      if (this.isX5Core)
      {
        localMethod = ReflectionUtils.getParentDeclaredMethod(this.mX5WebView.getView(), "computeHorizontalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.mX5WebView.getView(), new Object[0])).intValue();
      }
      Method localMethod = ReflectionUtils.getParentDeclaredMethod(this.mSysWebView, "computeHorizontalScrollExtent", new Class[0]);
      localMethod.setAccessible(true);
      int i = ((Integer)localMethod.invoke(this.mSysWebView, new Object[0])).intValue();
      return i;
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
      if (this.isX5Core)
      {
        localMethod = ReflectionUtils.getParentDeclaredMethod(this.mX5WebView.getView(), "computeHorizontalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.mX5WebView.getView(), new Object[0])).intValue();
      }
      Method localMethod = ReflectionUtils.getParentDeclaredMethod(this.mSysWebView, "computeHorizontalScrollOffset", new Class[0]);
      localMethod.setAccessible(true);
      int i = ((Integer)localMethod.invoke(this.mSysWebView, new Object[0])).intValue();
      return i;
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
      if (this.isX5Core) {
        return ((Integer)ReflectionUtils.invokeInstance(this.mX5WebView.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
      }
      Method localMethod = ReflectionUtils.getParentDeclaredMethod(this.mSysWebView, "computeHorizontalScrollRange", new Class[0]);
      localMethod.setAccessible(true);
      int i = ((Integer)localMethod.invoke(this.mSysWebView, new Object[0])).intValue();
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public void computeScroll()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.computeScroll();
      return;
    }
    this.mX5WebView.computeScroll();
  }
  
  public int computeVerticalScrollExtent()
  {
    try
    {
      if (this.isX5Core)
      {
        localMethod = ReflectionUtils.getParentDeclaredMethod(this.mX5WebView.getView(), "computeVerticalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.mX5WebView.getView(), new Object[0])).intValue();
      }
      Method localMethod = ReflectionUtils.getParentDeclaredMethod(this.mSysWebView, "computeVerticalScrollExtent", new Class[0]);
      localMethod.setAccessible(true);
      int i = ((Integer)localMethod.invoke(this.mSysWebView, new Object[0])).intValue();
      return i;
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
      if (this.isX5Core)
      {
        localMethod = ReflectionUtils.getParentDeclaredMethod(this.mX5WebView.getView(), "computeVerticalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.mX5WebView.getView(), new Object[0])).intValue();
      }
      Method localMethod = ReflectionUtils.getParentDeclaredMethod(this.mSysWebView, "computeVerticalScrollOffset", new Class[0]);
      localMethod.setAccessible(true);
      int i = ((Integer)localMethod.invoke(this.mSysWebView, new Object[0])).intValue();
      return i;
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
      if (this.isX5Core) {
        return ((Integer)ReflectionUtils.invokeInstance(this.mX5WebView.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
      }
      Method localMethod = ReflectionUtils.getParentDeclaredMethod(this.mSysWebView, "computeVerticalScrollRange", new Class[0]);
      localMethod.setAccessible(true);
      int i = ((Integer)localMethod.invoke(this.mSysWebView, new Object[0])).intValue();
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    if (this.isX5Core) {
      return WebBackForwardList.wrap(this.mX5WebView.copyBackForwardList());
    }
    return WebBackForwardList.wrap(this.mSysWebView.copyBackForwardList());
  }
  
  public Object createPrintDocumentAdapter(String paramString)
  {
    Object localObject = null;
    if (this.isX5Core) {}
    while (Build.VERSION.SDK_INT < 21) {
      try
      {
        localObject = this.mX5WebView.createPrintDocumentAdapter(paramString);
        return localObject;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    return ReflectionUtils.invokeInstance(this.mSysWebView, "createPrintDocumentAdapter", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void customDiskCachePathEnabled(boolean paramBoolean, String paramString)
  {
    if ((this.isX5Core) && (getX5WebViewExtension() != null))
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
      if ("com.xunmeng.pinduoduo".equals(this.mContext.getApplicationInfo().packageName))
      {
        new WebView.3(this, "WebviewDestroy").start();
        if (this.isX5Core)
        {
          this.mX5WebView.destroy();
          return;
        }
        this.mSysWebView.destroy();
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
    if (!this.isX5Core)
    {
      this.mSysWebView.documentHasImages(paramMessage);
      return;
    }
    this.mX5WebView.documentHasImages(paramMessage);
  }
  
  public void dumpViewHierarchyWithProperties(BufferedWriter paramBufferedWriter, int paramInt)
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "dumpViewHierarchyWithProperties", new Class[] { BufferedWriter.class, Integer.TYPE }, new Object[] { paramBufferedWriter, Integer.valueOf(paramInt) });
      return;
    }
    this.mX5WebView.dumpViewHierarchyWithProperties(paramBufferedWriter, paramInt);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if (this.isX5Core) {}
    Method localMethod;
    while (Build.VERSION.SDK_INT < 19) {
      try
      {
        localMethod = ReflectionUtils.getParentDeclaredMethod(this.mX5WebView.getView(), "evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
        localMethod.setAccessible(true);
        localMethod.invoke(this.mX5WebView.getView(), new Object[] { paramString, paramValueCallback });
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
      localMethod.invoke(this.mSysWebView, new Object[] { paramString, paramValueCallback });
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
    if (!this.isX5Core)
    {
      paramString = ReflectionUtils.invokeInstance(this.mSysWebView, "findAll", new Class[] { String.class }, new Object[] { paramString });
      if (paramString == null) {
        return 0;
      }
      return ((Integer)paramString).intValue();
    }
    return this.mX5WebView.findAll(paramString);
  }
  
  @TargetApi(16)
  public void findAllAsync(String paramString)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        ReflectionUtils.invokeInstance(this.mSysWebView, "findAllAsync", new Class[] { String.class }, new Object[] { paramString });
      }
      return;
    }
    this.mX5WebView.findAllAsync(paramString);
  }
  
  public View findHierarchyView(String paramString, int paramInt)
  {
    if (!this.isX5Core) {
      return (View)ReflectionUtils.invokeInstance(this.mSysWebView, "findHierarchyView", new Class[] { String.class, Integer.TYPE }, new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    return this.mX5WebView.findHierarchyView(paramString, paramInt);
  }
  
  @TargetApi(3)
  public void findNext(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.findNext(paramBoolean);
      return;
    }
    this.mX5WebView.findNext(paramBoolean);
  }
  
  public void flingScroll(int paramInt1, int paramInt2)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.flingScroll(paramInt1, paramInt2);
      return;
    }
    this.mX5WebView.flingScroll(paramInt1, paramInt2);
  }
  
  @Deprecated
  public void freeMemory()
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "freeMemory");
      return;
    }
    this.mX5WebView.freeMemory();
  }
  
  public SslCertificate getCertificate()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getCertificate();
    }
    return this.mX5WebView.getCertificate();
  }
  
  public int getContentHeight()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getContentHeight();
    }
    return this.mX5WebView.getContentHeight();
  }
  
  public int getContentWidth()
  {
    if (!this.isX5Core)
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "getContentWidth");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.mX5WebView.getContentWidth();
  }
  
  public Bitmap getFavicon()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getFavicon();
    }
    return this.mX5WebView.getFavicon();
  }
  
  public WebView.HitTestResult getHitTestResult()
  {
    if (!this.isX5Core) {
      return new WebView.HitTestResult(this.mSysWebView.getHitTestResult());
    }
    return new WebView.HitTestResult(this.mX5WebView.getHitTestResult());
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getHttpAuthUsernamePassword(paramString1, paramString2);
    }
    return this.mX5WebView.getHttpAuthUsernamePassword(paramString1, paramString2);
  }
  
  @TargetApi(3)
  public String getOriginalUrl()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getOriginalUrl();
    }
    return this.mX5WebView.getOriginalUrl();
  }
  
  public int getProgress()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getProgress();
    }
    return this.mX5WebView.getProgress();
  }
  
  public boolean getRendererPriorityWaivedWhenNotVisible()
  {
    boolean bool;
    try
    {
      if (!this.isX5Core)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return false;
        }
        Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "getRendererPriorityWaivedWhenNotVisible");
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
    int i;
    try
    {
      if (!this.isX5Core)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return 0;
        }
        Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "getRendererRequestedPriority");
        if (localObject == null) {
          i = 0;
        } else {
          i = ((Integer)localObject).intValue();
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
    return i;
  }
  
  @Deprecated
  public float getScale()
  {
    if (!this.isX5Core)
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "getScale");
      if (localObject == null) {
        return 0.0F;
      }
      return ((Float)localObject).floatValue();
    }
    return this.mX5WebView.getScale();
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
    if (this.mWebSettings != null) {
      return this.mWebSettings;
    }
    if (this.isX5Core)
    {
      localWebSettings = new WebSettings(this.mX5WebView.getSettings());
      this.mWebSettings = localWebSettings;
      return localWebSettings;
    }
    WebSettings localWebSettings = new WebSettings(this.mSysWebView.getSettings());
    this.mWebSettings = localWebSettings;
    return localWebSettings;
  }
  
  public IX5WebSettingsExtension getSettingsExtension()
  {
    if (!this.isX5Core) {
      return null;
    }
    return this.mX5WebView.getX5WebViewExtension().getSettingsExtension();
  }
  
  public int getSysNightModeAlpha()
  {
    return NIGHT_MODE_ALPHA;
  }
  
  android.webkit.WebView getSysWebView()
  {
    if (!this.isX5Core) {
      return this.mSysWebView;
    }
    return null;
  }
  
  public String getTitle()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getTitle();
    }
    return this.mX5WebView.getTitle();
  }
  
  public String getUrl()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getUrl();
    }
    return this.mX5WebView.getUrl();
  }
  
  public View getView()
  {
    if (!this.isX5Core) {
      return this.mSysWebView;
    }
    return this.mX5WebView.getView();
  }
  
  public int getVisibleTitleHeight()
  {
    if (!this.isX5Core)
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "getVisibleTitleHeight");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.mX5WebView.getVisibleTitleHeight();
  }
  
  public WebChromeClient getWebChromeClient()
  {
    return this.mWebChromeClient;
  }
  
  public IX5WebChromeClientExtension getWebChromeClientExtension()
  {
    if (!this.isX5Core) {
      return null;
    }
    return this.mX5WebView.getX5WebViewExtension().getWebChromeClientExtension();
  }
  
  public int getWebScrollX()
  {
    if (this.isX5Core) {
      return this.mX5WebView.getView().getScrollX();
    }
    return this.mSysWebView.getScrollX();
  }
  
  public int getWebScrollY()
  {
    if (this.isX5Core) {
      return this.mX5WebView.getView().getScrollY();
    }
    return this.mSysWebView.getScrollY();
  }
  
  public WebViewClient getWebViewClient()
  {
    return this.mWebViewClient;
  }
  
  public IX5WebViewClientExtension getWebViewClientExtension()
  {
    if (!this.isX5Core) {
      return null;
    }
    return this.mX5WebView.getX5WebViewExtension().getWebViewClientExtension();
  }
  
  public IX5WebViewBase.HitTestResult getX5HitTestResult()
  {
    if (!this.isX5Core) {
      return null;
    }
    return this.mX5WebView.getHitTestResult();
  }
  
  IX5WebViewBase getX5WebView()
  {
    return this.mX5WebView;
  }
  
  public IX5WebViewExtension getX5WebViewExtension()
  {
    if (!this.isX5Core) {
      return null;
    }
    return this.mX5WebView.getX5WebViewExtension();
  }
  
  @Deprecated
  public View getZoomControls()
  {
    if (!this.isX5Core) {
      return (View)ReflectionUtils.invokeInstance(this.mSysWebView, "getZoomControls");
    }
    return this.mX5WebView.getZoomControls();
  }
  
  public void goBack()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.goBack();
      return;
    }
    this.mX5WebView.goBack();
  }
  
  public void goBackOrForward(int paramInt)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.goBackOrForward(paramInt);
      return;
    }
    this.mX5WebView.goBackOrForward(paramInt);
  }
  
  public void goForward()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.goForward();
      return;
    }
    this.mX5WebView.goForward();
  }
  
  public void invokeZoomPicker()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.invokeZoomPicker();
      return;
    }
    this.mX5WebView.invokeZoomPicker();
  }
  
  public boolean isDayMode()
  {
    return mIsDayMode;
  }
  
  public boolean isPrivateBrowsingEnabled()
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "isPrivateBrowsingEnabled");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.mX5WebView.isPrivateBrowsingEnable();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.loadData(paramString1, paramString2, paramString3);
      return;
    }
    this.mX5WebView.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
      return;
    }
    this.mX5WebView.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    if ((this.isX5Core) && (this.mRecorder != null) && (!this.isPerformanceDataRecorded)) {
      this.mRecorder.recordPerformanceEvent("load_url_gap", (byte)2);
    }
    if ((paramString == null) || (showDebugView(paramString))) {
      return;
    }
    if (!this.isX5Core)
    {
      this.mSysWebView.loadUrl(paramString);
      return;
    }
    this.mX5WebView.loadUrl(paramString);
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    if ((this.isX5Core) && (this.mRecorder != null) && (!this.isPerformanceDataRecorded)) {
      this.mRecorder.recordPerformanceEvent("load_url_gap", (byte)2);
    }
    if ((paramString == null) || (showDebugView(paramString))) {}
    do
    {
      return;
      if (this.isX5Core) {
        break;
      }
    } while (Build.VERSION.SDK_INT < 8);
    this.mSysWebView.loadUrl(paramString, paramMap);
    return;
    this.mX5WebView.loadUrl(paramString, paramMap);
  }
  
  protected void onDetachedFromWindow()
  {
    try
    {
      if ("com.xunmeng.pinduoduo".equals(this.mContext.getApplicationInfo().packageName))
      {
        new WebView.8(this, "onDetachedFromWindow").start();
        return;
      }
      tbsOnDetachedFromWindow();
      return;
    }
    catch (Throwable localThrowable)
    {
      tbsOnDetachedFromWindow();
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.mOnLongClickListener != null)
    {
      if (!this.mOnLongClickListener.onLongClick(paramView)) {
        return callX5CoreOnLongClick(paramView);
      }
      return true;
    }
    return callX5CoreOnLongClick(paramView);
  }
  
  public void onPause()
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "onPause");
      return;
    }
    this.mX5WebView.onPause();
  }
  
  public void onResume()
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "onResume");
      return;
    }
    this.mX5WebView.onResume();
  }
  
  @TargetApi(11)
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT >= 21) && (isQQ(this.mContext)) && (isHardwareAccelerated()) && (paramInt1 > 0) && (paramInt2 > 0) && (getLayerType() != 2)) {}
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (this.mContext == null)
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    if (mCallerAppPackageName == null) {
      mCallerAppPackageName = this.mContext.getApplicationInfo().packageName;
    }
    if ((mCallerAppPackageName != null) && ((mCallerAppPackageName.equals("com.tencent.mm")) || (mCallerAppPackageName.equals("com.tencent.mobileqq"))))
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    String str3;
    String str2;
    String str1;
    if ((paramInt != 0) && (!this.mIsReported) && (this.mPv != 0))
    {
      this.mIsReported = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      str3 = str4;
      str2 = str5;
      str1 = str6;
      if (this.isX5Core)
      {
        Bundle localBundle = this.mX5WebView.getX5WebViewExtension().getSdkQBStatisticsInfo();
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
      if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName))
      {
        int j = getTbsCorePV(this.mContext);
        int i = j;
        if (j == -1) {
          i = this.mPv;
        }
        this.mPv = i;
        deletepvfile(this.mContext);
      }
    }
    try
    {
      bool = this.mX5WebView.getX5WebViewExtension().isX5CoreSandboxMode();
      HttpUtils.doReport(this.mContext, str3, str2, str1, this.mPv, this.isX5Core, getWifiConnectedTime(), bool);
      this.mPv = 0;
      this.mIsReported = false;
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
    if (!this.isX5Core) {
      return this.mSysWebView.overlayHorizontalScrollbar();
    }
    return this.mX5WebView.overlayHorizontalScrollbar();
  }
  
  public boolean overlayVerticalScrollbar()
  {
    if (this.isX5Core) {
      return this.mX5WebView.overlayVerticalScrollbar();
    }
    return this.mSysWebView.overlayVerticalScrollbar();
  }
  
  public boolean pageDown(boolean paramBoolean)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.pageDown(paramBoolean);
    }
    return this.mX5WebView.pageDown(paramBoolean, -1);
  }
  
  public boolean pageUp(boolean paramBoolean)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.pageUp(paramBoolean);
    }
    return this.mX5WebView.pageUp(paramBoolean, -1);
  }
  
  public void pauseTimers()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.pauseTimers();
      return;
    }
    this.mX5WebView.pauseTimers();
  }
  
  @TargetApi(5)
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.postUrl(paramString, paramArrayOfByte);
      return;
    }
    this.mX5WebView.postUrl(paramString, paramArrayOfByte);
  }
  
  @Deprecated
  public void refreshPlugins(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "refreshPlugins", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.mX5WebView.refreshPlugins(paramBoolean);
  }
  
  public void reload()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.reload();
      return;
    }
    this.mX5WebView.reload();
  }
  
  @TargetApi(11)
  public void removeJavascriptInterface(String paramString)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        ReflectionUtils.invokeInstance(this.mSysWebView, "removeJavascriptInterface", new Class[] { String.class }, new Object[] { paramString });
      }
    }
    else {
      return;
    }
    this.mX5WebView.removeJavascriptInterface(paramString);
  }
  
  public void removeView(View paramView)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.removeView(paramView);
      return;
    }
    View localView = this.mX5WebView.getView();
    try
    {
      Method localMethod = ReflectionUtils.getParentDeclaredMethod(localView, "removeView", new Class[] { View.class });
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
      localJSONObject1.put("IS_X5", this.isX5Core);
      TbsLog.i("sdkreport", "reportInitPerformance initType is " + paramLong1 + " isX5Core is " + this.isX5Core + " isPerformanceDataRecorded" + this.isPerformanceDataRecorded);
      if ((this.isX5Core) && (this.mRecorder != null) && (!this.isPerformanceDataRecorded))
      {
        this.mRecorder.recordPerformanceEvent("init_type", paramLong1);
        this.mRecorder.recordPerformanceEvent("time_oncreate", paramLong2);
        this.mRecorder.recordPerformanceEvent("webview_type", paramInt);
        this.mRecorder.recordPerformanceEvent("time_webaccelerator", paramLong3);
        if (this.mRecorder.endRecord(this.mX5WebView.hashCode(), getUrl())) {
          this.isPerformanceDataRecorded = true;
        }
        localJSONObject2 = this.mRecorder.getInitTimeDetail();
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
    if (this.isX5Core)
    {
      localObject1 = this.mX5WebView.getView();
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
    Object localObject2 = this.mSysWebView;
    Object localObject1 = paramView;
    if (paramView == this) {
      localObject1 = this.mSysWebView;
    }
    return ((android.webkit.WebView)localObject2).requestChildRectangleOnScreen((View)localObject1, paramRect, paramBoolean);
  }
  
  public void requestFocusNodeHref(Message paramMessage)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.requestFocusNodeHref(paramMessage);
      return;
    }
    this.mX5WebView.requestFocusNodeHref(paramMessage);
  }
  
  public void requestImageRef(Message paramMessage)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.requestImageRef(paramMessage);
      return;
    }
    this.mX5WebView.requestImageRef(paramMessage);
  }
  
  @Deprecated
  public boolean restorePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.isX5Core)
    {
      paramBundle = ReflectionUtils.invokeInstance(this.mSysWebView, "restorePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.mX5WebView.restorePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList restoreState(Bundle paramBundle)
  {
    if (!this.isX5Core) {
      return WebBackForwardList.wrap(this.mSysWebView.restoreState(paramBundle));
    }
    return WebBackForwardList.wrap(this.mX5WebView.restoreState(paramBundle));
  }
  
  public void resumeTimers()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.resumeTimers();
      return;
    }
    this.mX5WebView.resumeTimers();
  }
  
  @Deprecated
  public void savePassword(String paramString1, String paramString2, String paramString3)
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "savePassword", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
      return;
    }
    this.mX5WebView.savePassword(paramString1, paramString2, paramString3);
  }
  
  @Deprecated
  public boolean savePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.isX5Core)
    {
      paramBundle = ReflectionUtils.invokeInstance(this.mSysWebView, "savePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.mX5WebView.savePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList saveState(Bundle paramBundle)
  {
    if (!this.isX5Core) {
      return WebBackForwardList.wrap(this.mSysWebView.saveState(paramBundle));
    }
    return WebBackForwardList.wrap(this.mX5WebView.saveState(paramBundle));
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        ReflectionUtils.invokeInstance(this.mSysWebView, "saveWebArchive", new Class[] { String.class }, new Object[] { paramString });
      }
      return;
    }
    this.mX5WebView.saveWebArchive(paramString);
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString, boolean paramBoolean, ValueCallback<String> paramValueCallback)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        ReflectionUtils.invokeInstance(this.mSysWebView, "saveWebArchive", new Class[] { String.class, Boolean.TYPE, android.webkit.ValueCallback.class }, new Object[] { paramString, Boolean.valueOf(paramBoolean), paramValueCallback });
      }
      return;
    }
    this.mX5WebView.saveWebArchive(paramString, paramBoolean, paramValueCallback);
  }
  
  public void setARModeEnable(boolean paramBoolean)
  {
    try
    {
      if (this.isX5Core) {
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
    if (!this.isX5Core) {
      this.mSysWebView.setBackgroundColor(paramInt);
    }
    for (;;)
    {
      super.setBackgroundColor(paramInt);
      return;
      this.mX5WebView.setBackgroundColor(paramInt);
    }
  }
  
  @Deprecated
  public void setCertificate(SslCertificate paramSslCertificate)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setCertificate(paramSslCertificate);
      return;
    }
    this.mX5WebView.setCertificate(paramSslCertificate);
  }
  
  public void setDayOrNight(boolean paramBoolean)
  {
    try
    {
      if (this.isX5Core) {
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
    if (!this.isX5Core)
    {
      this.mSysWebView.setDownloadListener(new WebView.5(this, paramDownloadListener));
      return;
    }
    this.mX5WebView.setDownloadListener(new DownLoadListenerAdapter(this, paramDownloadListener, this.isX5Core));
  }
  
  @TargetApi(16)
  public void setFindListener(IX5WebViewBase.FindListener paramFindListener)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.mSysWebView.setFindListener(new WebView.4(this, paramFindListener));
      }
      return;
    }
    this.mX5WebView.setFindListener(paramFindListener);
  }
  
  public void setHorizontalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setHorizontalScrollbarOverlay(paramBoolean);
      return;
    }
    this.mX5WebView.setHorizontalScrollbarOverlay(paramBoolean);
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
      return;
    }
    this.mX5WebView.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void setInitialScale(int paramInt)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setInitialScale(paramInt);
      return;
    }
    this.mX5WebView.setInitialScale(paramInt);
  }
  
  @Deprecated
  public void setMapTrackballToArrowKeys(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "setMapTrackballToArrowKeys", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.mX5WebView.setMapTrackballToArrowKeys(paramBoolean);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 3) {
        this.mSysWebView.setNetworkAvailable(paramBoolean);
      }
      return;
    }
    this.mX5WebView.setNetworkAvailable(paramBoolean);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setOnLongClickListener(paramOnLongClickListener);
      return;
    }
    Object localObject1 = this.mX5WebView.getView();
    try
    {
      if (this.longClickListener == null)
      {
        Object localObject2 = ReflectionUtils.getParentDeclaredMethod(localObject1, "getListenerInfo", new Class[0]);
        ((Method)localObject2).setAccessible(true);
        localObject1 = ((Method)localObject2).invoke(localObject1, (Object[])null);
        localObject2 = localObject1.getClass().getDeclaredField("mOnLongClickListener");
        ((Field)localObject2).setAccessible(true);
        this.longClickListener = ((Field)localObject2).get(localObject1);
      }
      this.mOnLongClickListener = paramOnLongClickListener;
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
    if (!this.isX5Core)
    {
      if (paramPictureListener == null)
      {
        this.mSysWebView.setPictureListener(null);
        return;
      }
      this.mSysWebView.setPictureListener(new WebView.6(this, paramPictureListener));
      return;
    }
    if (paramPictureListener == null)
    {
      this.mX5WebView.setPictureListener(null);
      return;
    }
    this.mX5WebView.setPictureListener(new WebView.7(this, paramPictureListener));
  }
  
  public void setRendererPriorityPolicy(int paramInt, boolean paramBoolean)
  {
    try
    {
      if (!this.isX5Core)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return;
        }
        ReflectionUtils.invokeInstance(this.mSysWebView, "setRendererPriorityPolicy", new Class[] { Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
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
    if (this.isX5Core)
    {
      this.mX5WebView.getView().setScrollBarStyle(paramInt);
      return;
    }
    this.mSysWebView.setScrollBarStyle(paramInt);
  }
  
  public void setSysNightModeAlpha(int paramInt)
  {
    NIGHT_MODE_ALPHA = paramInt;
  }
  
  void setSysWebView(android.webkit.WebView paramWebView)
  {
    if (!this.isX5Core) {}
  }
  
  public void setVerticalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setVerticalScrollbarOverlay(paramBoolean);
      return;
    }
    this.mX5WebView.setVerticalScrollbarOverlay(paramBoolean);
  }
  
  public boolean setVideoFullScreen(Context paramContext, boolean paramBoolean)
  {
    if ((paramContext.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader")) && (this.mX5WebView != null))
    {
      paramContext = new Bundle();
      if (paramBoolean) {
        paramContext.putInt("DefaultVideoScreen", 2);
      }
      for (;;)
      {
        this.mX5WebView.getX5WebViewExtension().invokeMiscMethod("setVideoParams", paramContext);
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
    if (this.isX5Core)
    {
      localIX5WebViewBase = this.mX5WebView;
      if (paramWebChromeClient == null) {}
      for (;;)
      {
        localIX5WebViewBase.setWebChromeClient((IX5WebChromeClient)localObject);
        this.mWebChromeClient = paramWebChromeClient;
        return;
        localObject = new SmttWebChromeClient(X5CoreEngine.getInstance().wizardForCoreTypeConfirmed(true).createDefaultX5WebChromeClient(), this, paramWebChromeClient);
      }
    }
    WebView.SystemWebView localSystemWebView = this.mSysWebView;
    if (paramWebChromeClient == null) {}
    for (localObject = localIX5WebViewBase;; localObject = new SystemWebChromeClient(this, paramWebChromeClient))
    {
      localSystemWebView.setWebChromeClient((android.webkit.WebChromeClient)localObject);
      break;
    }
  }
  
  public void setWebChromeClientExtension(IX5WebChromeClientExtension paramIX5WebChromeClientExtension)
  {
    if (!this.isX5Core) {
      return;
    }
    this.mX5WebView.getX5WebViewExtension().setWebChromeClientExtension(paramIX5WebChromeClientExtension);
  }
  
  public void setWebViewCallbackClient(WebViewCallbackClient paramWebViewCallbackClient)
  {
    this.mWebViewCallbackClient = paramWebViewCallbackClient;
    if ((this.isX5Core) && (getX5WebViewExtension() != null))
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
    if (this.isX5Core)
    {
      localIX5WebViewBase = this.mX5WebView;
      if (paramWebViewClient == null) {}
      for (;;)
      {
        localIX5WebViewBase.setWebViewClient((IX5WebViewClient)localObject);
        this.mWebViewClient = paramWebViewClient;
        return;
        localObject = new SmttWebViewClient(X5CoreEngine.getInstance().wizardForCoreTypeConfirmed(true).createDefaultX5WebViewClient(), this, paramWebViewClient);
      }
    }
    WebView.SystemWebView localSystemWebView = this.mSysWebView;
    if (paramWebViewClient == null) {}
    for (localObject = localIX5WebViewBase;; localObject = new SystemWebViewClient(this, paramWebViewClient))
    {
      localSystemWebView.setWebViewClient((android.webkit.WebViewClient)localObject);
      break;
    }
  }
  
  public void setWebViewClientExtension(IX5WebViewClientExtension paramIX5WebViewClientExtension)
  {
    if (!this.isX5Core) {
      return;
    }
    this.mX5WebView.getX5WebViewExtension().setWebViewClientExtension(paramIX5WebViewClientExtension);
  }
  
  void setX5WebView(IX5WebViewBase paramIX5WebViewBase)
  {
    this.mX5WebView = paramIX5WebViewBase;
  }
  
  @SuppressLint({"NewApi"})
  public boolean showDebugView(String paramString)
  {
    boolean bool2 = false;
    paramString = paramString.toLowerCase();
    boolean bool1;
    if (paramString.startsWith("http://debugtbs.qq.com"))
    {
      getView().setVisibility(4);
      DebugTbsPlugin.getInstance(this.mContext).showPluginView(paramString, this, this.mContext, TbsHandlerThread.getInstance().getLooper());
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!paramString.startsWith("http://debugx5.qq.com"));
      bool1 = bool2;
    } while (this.isX5Core);
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
    if (!this.isX5Core)
    {
      this.mSysWebView.stopLoading();
      return;
    }
    this.mX5WebView.stopLoading();
  }
  
  public void super_computeScroll()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.super_computeScroll();
      return;
    }
    View localView = this.mX5WebView.getView();
    try
    {
      ReflectionUtils.invokeInstance(localView, "super_computeScroll");
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.super_dispatchTouchEvent(paramMotionEvent);
    }
    View localView = this.mX5WebView.getView();
    try
    {
      paramMotionEvent = ReflectionUtils.invokeInstance(localView, "super_dispatchTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
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
    if (!this.isX5Core) {
      return this.mSysWebView.super_onInterceptTouchEvent(paramMotionEvent);
    }
    View localView = this.mX5WebView.getView();
    try
    {
      paramMotionEvent = ReflectionUtils.invokeInstance(localView, "super_onInterceptTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
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
    if (!this.isX5Core)
    {
      this.mSysWebView.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
    }
    View localView = this.mX5WebView.getView();
    try
    {
      ReflectionUtils.invokeInstance(localView, "super_onOverScrolled", new Class[] { Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    View localView = this.mX5WebView.getView();
    try
    {
      ReflectionUtils.invokeInstance(localView, "super_onScrollChanged", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.super_onTouchEvent(paramMotionEvent);
    }
    View localView = this.mX5WebView.getView();
    try
    {
      paramMotionEvent = ReflectionUtils.invokeInstance(localView, "super_onTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
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
    if (!this.isX5Core) {
      return this.mSysWebView.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    }
    Object localObject = this.mX5WebView.getView();
    try
    {
      localObject = ReflectionUtils.invokeInstance(localObject, "super_overScrollBy", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Boolean.valueOf(paramBoolean) });
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
    if (paramBoolean == mIsDayMode) {
      return;
    }
    mIsDayMode = paramBoolean;
    if (mIsDayMode)
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
    if (!mIsDayMode)
    {
      TbsLog.e("QB_SDK", "switchToNightMode");
      loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
    }
  }
  
  protected void tbsOnDetachedFromWindow()
  {
    String str3;
    String str2;
    String str1;
    if ((!this.mIsReported) && (this.mPv != 0))
    {
      this.mIsReported = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      str3 = str4;
      str2 = str5;
      str1 = str6;
      if (this.isX5Core)
      {
        Bundle localBundle = this.mX5WebView.getX5WebViewExtension().getSdkQBStatisticsInfo();
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
      if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName))
      {
        int j = getTbsCorePV(this.mContext);
        int i = j;
        if (j == -1) {
          i = this.mPv;
        }
        this.mPv = i;
        deletepvfile(this.mContext);
      }
    }
    try
    {
      bool = this.mX5WebView.getX5WebViewExtension().isX5CoreSandboxMode();
      HttpUtils.doReport(this.mContext, str3, str2, str1, this.mPv, this.isX5Core, getWifiConnectedTime(), bool);
      this.mPv = 0;
      this.mIsReported = false;
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
  public void tbsWebviewDestroy(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 147	com/tencent/smtt/sdk/WebView:mIsReported	Z
    //   4: ifne +218 -> 222
    //   7: aload_0
    //   8: getfield 145	com/tencent/smtt/sdk/WebView:mPv	I
    //   11: ifeq +211 -> 222
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 147	com/tencent/smtt/sdk/WebView:mIsReported	Z
    //   19: ldc_w 634
    //   22: astore 8
    //   24: ldc_w 634
    //   27: astore 9
    //   29: ldc_w 634
    //   32: astore 10
    //   34: aload 8
    //   36: astore 7
    //   38: aload 9
    //   40: astore 6
    //   42: aload 10
    //   44: astore 5
    //   46: aload_0
    //   47: getfield 139	com/tencent/smtt/sdk/WebView:isX5Core	Z
    //   50: ifeq +66 -> 116
    //   53: aload_0
    //   54: getfield 196	com/tencent/smtt/sdk/WebView:mX5WebView	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   57: invokeinterface 436 1 0
    //   62: invokeinterface 1327 1 0
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
    //   88: ldc_w 1329
    //   91: invokevirtual 1332	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore 7
    //   96: aload 11
    //   98: ldc_w 1334
    //   101: invokevirtual 1332	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore 6
    //   106: aload 11
    //   108: ldc_w 1336
    //   111: invokevirtual 1332	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore 5
    //   116: ldc_w 1338
    //   119: aload_0
    //   120: getfield 143	com/tencent/smtt/sdk/WebView:mContext	Landroid/content/Context;
    //   123: invokevirtual 455	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   126: getfield 460	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   129: invokevirtual 466	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   132: ifeq +37 -> 169
    //   135: aload_0
    //   136: aload_0
    //   137: getfield 143	com/tencent/smtt/sdk/WebView:mContext	Landroid/content/Context;
    //   140: invokespecial 1340	com/tencent/smtt/sdk/WebView:getTbsCorePV	(Landroid/content/Context;)I
    //   143: istore_3
    //   144: iload_3
    //   145: istore_2
    //   146: iload_3
    //   147: iconst_m1
    //   148: if_icmpne +8 -> 156
    //   151: aload_0
    //   152: getfield 145	com/tencent/smtt/sdk/WebView:mPv	I
    //   155: istore_2
    //   156: aload_0
    //   157: iload_2
    //   158: putfield 145	com/tencent/smtt/sdk/WebView:mPv	I
    //   161: aload_0
    //   162: aload_0
    //   163: getfield 143	com/tencent/smtt/sdk/WebView:mContext	Landroid/content/Context;
    //   166: invokespecial 1342	com/tencent/smtt/sdk/WebView:deletepvfile	(Landroid/content/Context;)V
    //   169: aload_0
    //   170: getfield 196	com/tencent/smtt/sdk/WebView:mX5WebView	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   173: invokeinterface 436 1 0
    //   178: invokeinterface 1345 1 0
    //   183: istore 4
    //   185: aload_0
    //   186: getfield 143	com/tencent/smtt/sdk/WebView:mContext	Landroid/content/Context;
    //   189: aload 7
    //   191: aload 6
    //   193: aload 5
    //   195: aload_0
    //   196: getfield 145	com/tencent/smtt/sdk/WebView:mPv	I
    //   199: aload_0
    //   200: getfield 139	com/tencent/smtt/sdk/WebView:isX5Core	Z
    //   203: aload_0
    //   204: invokespecial 1347	com/tencent/smtt/sdk/WebView:getWifiConnectedTime	()J
    //   207: iload 4
    //   209: invokestatic 1353	com/tencent/smtt/sdk/stat/HttpUtils:doReport	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZJZ)V
    //   212: aload_0
    //   213: iconst_0
    //   214: putfield 145	com/tencent/smtt/sdk/WebView:mPv	I
    //   217: aload_0
    //   218: iconst_0
    //   219: putfield 147	com/tencent/smtt/sdk/WebView:mIsReported	Z
    //   222: aload_0
    //   223: getfield 139	com/tencent/smtt/sdk/WebView:isX5Core	Z
    //   226: ifne +358 -> 584
    //   229: ldc_w 1811
    //   232: invokestatic 236	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   235: astore 5
    //   237: aload 5
    //   239: ldc_w 1813
    //   242: iconst_1
    //   243: anewarray 232	java/lang/Class
    //   246: dup
    //   247: iconst_0
    //   248: ldc_w 280
    //   251: aastore
    //   252: invokevirtual 1816	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   255: astore 6
    //   257: aload 6
    //   259: iconst_1
    //   260: invokevirtual 248	java/lang/reflect/Method:setAccessible	(Z)V
    //   263: aload 6
    //   265: aconst_null
    //   266: iconst_1
    //   267: anewarray 250	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: aload_0
    //   273: getfield 209	com/tencent/smtt/sdk/WebView:mSysWebView	Lcom/tencent/smtt/sdk/WebView$SystemWebView;
    //   276: aastore
    //   277: invokevirtual 254	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   280: astore 6
    //   282: aload 6
    //   284: ifnull +114 -> 398
    //   287: aload 5
    //   289: ldc_w 1818
    //   292: invokevirtual 1590	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   295: astore 5
    //   297: aload 5
    //   299: iconst_1
    //   300: invokevirtual 1593	java/lang/reflect/Field:setAccessible	(Z)V
    //   303: aload 5
    //   305: aload 6
    //   307: invokevirtual 1594	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   310: astore 5
    //   312: aload 5
    //   314: ifnull +84 -> 398
    //   317: aload 5
    //   319: checkcast 1820	android/app/Dialog
    //   322: astore 5
    //   324: aload 5
    //   326: aconst_null
    //   327: invokevirtual 1824	android/app/Dialog:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   330: ldc_w 1826
    //   333: invokestatic 236	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   336: astore 6
    //   338: aload 6
    //   340: ldc_w 1828
    //   343: invokevirtual 1590	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   346: astore 7
    //   348: aload 7
    //   350: iconst_1
    //   351: invokevirtual 1593	java/lang/reflect/Field:setAccessible	(Z)V
    //   354: aload 7
    //   356: aload 5
    //   358: invokevirtual 1594	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   361: checkcast 746	java/lang/Integer
    //   364: invokevirtual 981	java/lang/Integer:intValue	()I
    //   367: istore_2
    //   368: aload 6
    //   370: ldc_w 1830
    //   373: invokevirtual 1590	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   376: astore 6
    //   378: aload 6
    //   380: iconst_1
    //   381: invokevirtual 1593	java/lang/reflect/Field:setAccessible	(Z)V
    //   384: aload 6
    //   386: aload 5
    //   388: invokevirtual 1594	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   391: checkcast 256	android/os/Handler
    //   394: iload_2
    //   395: invokevirtual 1833	android/os/Handler:removeMessages	(I)V
    //   398: iload_1
    //   399: ifeq +10 -> 409
    //   402: aload_0
    //   403: getfield 209	com/tencent/smtt/sdk/WebView:mSysWebView	Lcom/tencent/smtt/sdk/WebView$SystemWebView;
    //   406: invokevirtual 1053	android/webkit/WebView:destroy	()V
    //   409: ldc_w 1835
    //   412: invokestatic 236	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   415: ldc_w 1837
    //   418: invokevirtual 1590	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   421: astore 6
    //   423: aload 6
    //   425: iconst_1
    //   426: invokevirtual 1593	java/lang/reflect/Field:setAccessible	(Z)V
    //   429: aload 6
    //   431: aconst_null
    //   432: invokevirtual 1594	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   435: checkcast 1839	android/content/ComponentCallbacks
    //   438: astore 5
    //   440: aload 5
    //   442: ifnull +66 -> 508
    //   445: aload 6
    //   447: aconst_null
    //   448: aconst_null
    //   449: invokevirtual 1843	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   452: ldc_w 1845
    //   455: invokestatic 236	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   458: ldc_w 1847
    //   461: invokevirtual 1590	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   464: astore 6
    //   466: aload 6
    //   468: iconst_1
    //   469: invokevirtual 1593	java/lang/reflect/Field:setAccessible	(Z)V
    //   472: aload 6
    //   474: aconst_null
    //   475: invokevirtual 1594	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   478: astore 6
    //   480: aload 6
    //   482: ifnull +26 -> 508
    //   485: aload 6
    //   487: checkcast 1849	java/util/List
    //   490: astore 6
    //   492: aload 6
    //   494: monitorenter
    //   495: aload 6
    //   497: aload 5
    //   499: invokeinterface 1852 2 0
    //   504: pop
    //   505: aload 6
    //   507: monitorexit
    //   508: ldc 135
    //   510: new 520	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 521	java/lang/StringBuilder:<init>	()V
    //   517: ldc_w 1854
    //   520: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokestatic 1857	com/tencent/smtt/sdk/QbSdk:getGuid	()Ljava/lang/String;
    //   526: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 300	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   535: return
    //   536: astore 8
    //   538: ldc_w 1858
    //   541: new 520	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 521	java/lang/StringBuilder:<init>	()V
    //   548: ldc_w 1356
    //   551: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: aload 8
    //   556: invokevirtual 590	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   559: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 1359	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   589: getfield 196	com/tencent/smtt/sdk/WebView:mX5WebView	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   592: invokeinterface 1052 1 0
    //   597: goto -89 -> 508
    //   600: astore 5
    //   602: goto -204 -> 398
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	605	0	this	WebView
    //   0	605	1	paramBoolean	boolean
    //   145	250	2	i	int
    //   143	6	3	j	int
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
  
  /* Error */
  void writetbscorepvfile(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 1340	com/tencent/smtt/sdk/WebView:getTbsCorePV	(Landroid/content/Context;)I
    //   5: istore_2
    //   6: iload_2
    //   7: iconst_m1
    //   8: if_icmpeq +76 -> 84
    //   11: new 520	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 521	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 1861
    //   21: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_2
    //   25: iconst_1
    //   26: iadd
    //   27: invokestatic 1863	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   30: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_3
    //   37: aload_1
    //   38: invokestatic 585	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   41: astore_1
    //   42: new 587	java/io/File
    //   45: dup
    //   46: new 520	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 521	java/lang/StringBuilder:<init>	()V
    //   53: aload_1
    //   54: invokevirtual 590	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: getstatic 593	java/io/File:separator	Ljava/lang/String;
    //   60: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc_w 595
    //   66: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: ldc_w 597
    //   75: invokespecial 599	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: astore_1
    //   79: aload_1
    //   80: ifnonnull +11 -> 91
    //   83: return
    //   84: ldc_w 1865
    //   87: astore_3
    //   88: goto -51 -> 37
    //   91: aload_1
    //   92: invokevirtual 1869	java/io/File:getParentFile	()Ljava/io/File;
    //   95: invokevirtual 1872	java/io/File:mkdirs	()Z
    //   98: pop
    //   99: aload_1
    //   100: invokevirtual 1875	java/io/File:isFile	()Z
    //   103: ifeq +10 -> 113
    //   106: aload_1
    //   107: invokevirtual 602	java/io/File:exists	()Z
    //   110: ifne +8 -> 118
    //   113: aload_1
    //   114: invokevirtual 1878	java/io/File:createNewFile	()Z
    //   117: pop
    //   118: new 1880	java/io/FileOutputStream
    //   121: dup
    //   122: aload_1
    //   123: iconst_0
    //   124: invokespecial 1883	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   127: putstatic 93	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   130: getstatic 93	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   133: aload_3
    //   134: invokevirtual 1887	java/lang/String:getBytes	()[B
    //   137: invokevirtual 1893	java/io/OutputStream:write	([B)V
    //   140: getstatic 93	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   143: ifnull -60 -> 83
    //   146: getstatic 93	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   149: invokevirtual 1896	java/io/OutputStream:flush	()V
    //   152: return
    //   153: astore_1
    //   154: getstatic 93	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   157: ifnull +9 -> 166
    //   160: getstatic 93	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   163: invokevirtual 1896	java/io/OutputStream:flush	()V
    //   166: aload_1
    //   167: athrow
    //   168: astore_1
    //   169: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	WebView
    //   0	170	1	paramContext	Context
    //   5	22	2	i	int
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
  
  public boolean zoomIn()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.zoomIn();
    }
    return this.mX5WebView.zoomIn();
  }
  
  public boolean zoomOut()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.zoomOut();
    }
    return this.mX5WebView.zoomOut();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView
 * JD-Core Version:    0.7.0.1
 */