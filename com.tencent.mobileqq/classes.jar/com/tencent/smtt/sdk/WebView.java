package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
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
import android.webkit.WebView.FindListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.sdk.stat.HttpUtils;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.DebugTbsPlugin;
import com.tencent.smtt.utils.ReflectionUtils;
import com.tencent.smtt.utils.TbsConfigFile;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
  private static OutputStream outputStream = null;
  private static BroadcastReceiver sConnectivityChangeReceiver;
  private static Method sWebviewsetWebContentsDebuggingEnabled;
  private final int ATTRIBUTE_SCROLLBARS_HORIZONTAL = 2;
  private final int ATTRIBUTE_SCROLLBARS_NONE = 1;
  private final int ATTRIBUTE_SCROLLBARS_VERTICAL = 3;
  private final String LOG_TAG = "WebView";
  private final String deleteNightMode = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
  private boolean isPerformanceDataRecorded = false;
  private boolean isX5Core = false;
  private Object longClickListener = null;
  private Context mContext = null;
  private boolean mIsReported = false;
  private View.OnLongClickListener mOnLongClickListener = null;
  int mPv = 0;
  private TbsInitPerformanceRecorder mRecorder = null;
  private SystemWebView mSysWebView;
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
    this.mRecorder.recordPerformanceEvent("init_all", (byte)1);
    if ((QbSdk.getIsSysWebViewForcedByOuter()) && (TbsShareManager.isThirdPartyApp(paramContext)))
    {
      this.mContext = paramContext;
      this.mX5WebView = null;
      this.isX5Core = false;
      QbSdk.forceSysWebViewInner(paramContext, "failed to createTBSWebview!");
      this.mSysWebView = new SystemWebView(paramContext, paramAttributeSet);
      CookieManager.getInstance().compatiableCookieDatabaseIfNeed(paramContext, true, false);
      CookieSyncManager.createInstance(this.mContext).startSync();
    }
    try
    {
      paramAttributeSet = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
      paramAttributeSet.setAccessible(true);
      ((Handler)paramAttributeSet.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
      mSysWebviewCreated = true;
      label237:
      CookieManager.getInstance().syncCookies();
      this.mSysWebView.setFocusableInTouchMode(true);
      addView(this.mSysWebView, new FrameLayout.LayoutParams(-1, -1));
      TbsLog.i("WebView", "SystemWebView Created Success! #3");
      TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 402, new Throwable());
      for (;;)
      {
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
              this.mSysWebView = new SystemWebView(paramContext, paramAttributeSet);
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
                this.mSysWebView = new SystemWebView(paramContext);
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
          this.mX5WebView.getX5WebViewExtension().setWebViewClientExtension(new X5ProxyWebViewClientExtension(X5CoreEngine.getInstance().wizardForCoreTypeConfirmed(true).createDefaultX5WebChromeClientExtension())
          {
            public void invalidate() {}
            
            public void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
            {
              super.onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
              WebView.this.onScrollChanged(paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt1, paramAnonymousInt2);
            }
          });
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
                break label1075;
              }
              TbsInstaller.getInstance().coreShareCopyToDecouple(paramContext);
            }
          }
          if (this.mRecorder == null) {
            continue;
          }
          this.mRecorder.recordPerformanceEvent("load_url_gap", (byte)1);
          this.mRecorder.recordPerformanceEvent("init_all", (byte)2);
          return;
          this.mX5WebView = null;
          if (TbsShareManager.isThirdPartyApp(this.mContext)) {}
          for (this.mSysWebView = new SystemWebView(paramContext, paramAttributeSet);; this.mSysWebView = new SystemWebView(paramContext))
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
            label1075:
            TbsLog.i("WebView", "webview construction #1 deCoupleCoreVersion is " + paramInt + " getTbsCoreShareDecoupleCoreVersion is " + TbsInstaller.getInstance().getTbsCoreShareDecoupleCoreVersion(paramContext) + " getTbsCoreInstalledVerInNolock is " + TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext));
          }
        }
      }
    }
    catch (Exception paramAttributeSet)
    {
      break label237;
    }
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    this(paramContext, paramAttributeSet, paramInt, null, paramBoolean);
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
      paramContext = paramContext.getDir("tbs", 0);
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
    String str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(paramContext) + ";" + "tbs_sdk_version:" + 43609 + ";";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(SDKEngine.getInstance(true).getCrashExtraMessage());
    localStringBuilder.append("\n");
    localStringBuilder.append(str);
    if ((!TbsShareManager.isThirdPartyApp(paramContext)) && (QbSdk.mSettings != null) && (QbSdk.mSettings.containsKey("weapp_id")) && (QbSdk.mSettings.containsKey("weapp_name")))
    {
      paramContext = "weapp_id:" + QbSdk.mSettings.get("weapp_id") + ";" + "weapp_name" + ":" + QbSdk.mSettings.get("weapp_name") + ";";
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
    //   3: invokestatic 391	com/tencent/smtt/sdk/X5CoreEngine:getInstance	()Lcom/tencent/smtt/sdk/X5CoreEngine;
    //   6: invokevirtual 636	com/tencent/smtt/sdk/X5CoreEngine:isX5Core	()Z
    //   9: ifne +18 -> 27
    //   12: ldc_w 638
    //   15: ldc_w 706
    //   18: invokestatic 643	com/tencent/smtt/utils/ReflectionUtils:invokeStatic	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
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
    //   2: ldc_w 710
    //   5: invokestatic 716	com/tencent/smtt/utils/FileUtil:getLockFos	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   8: astore 7
    //   10: aload 7
    //   12: ifnull +16 -> 28
    //   15: aload_1
    //   16: aload 7
    //   18: invokestatic 720	com/tencent/smtt/utils/FileUtil:tryFileLock	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   21: astore 6
    //   23: aload 6
    //   25: ifnonnull +5 -> 30
    //   28: iconst_m1
    //   29: ireturn
    //   30: getstatic 123	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   33: invokeinterface 725 1 0
    //   38: ifeq +476 -> 514
    //   41: aconst_null
    //   42: astore 5
    //   44: aload_1
    //   45: ldc_w 603
    //   48: iconst_0
    //   49: invokevirtual 607	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   52: astore_1
    //   53: new 609	java/io/File
    //   56: dup
    //   57: new 543	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 544	java/lang/StringBuilder:<init>	()V
    //   64: aload_1
    //   65: invokevirtual 612	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: getstatic 615	java/io/File:separator	Ljava/lang/String;
    //   71: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 617
    //   77: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 561	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: ldc_w 619
    //   86: invokespecial 621	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: astore_1
    //   90: aload_1
    //   91: ifnull +12 -> 103
    //   94: aload_1
    //   95: invokevirtual 624	java/io/File:exists	()Z
    //   98: istore_3
    //   99: iload_3
    //   100: ifne +65 -> 165
    //   103: iconst_0
    //   104: ifeq +11 -> 115
    //   107: new 727	java/lang/NullPointerException
    //   110: dup
    //   111: invokespecial 728	java/lang/NullPointerException:<init>	()V
    //   114: athrow
    //   115: getstatic 123	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   118: invokeinterface 731 1 0
    //   123: aload 6
    //   125: aload 7
    //   127: invokestatic 735	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   130: iconst_m1
    //   131: ireturn
    //   132: astore_1
    //   133: ldc_w 629
    //   136: new 543	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 544	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 737
    //   146: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_1
    //   150: invokevirtual 738	java/io/IOException:toString	()Ljava/lang/String;
    //   153: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 561	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 740	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: goto -47 -> 115
    //   165: new 742	java/util/Properties
    //   168: dup
    //   169: invokespecial 743	java/util/Properties:<init>	()V
    //   172: astore 8
    //   174: new 745	java/io/FileInputStream
    //   177: dup
    //   178: aload_1
    //   179: invokespecial 748	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   182: astore 4
    //   184: aload 4
    //   186: astore_1
    //   187: aload 8
    //   189: aload 4
    //   191: invokevirtual 752	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   194: aload 4
    //   196: astore_1
    //   197: aload 4
    //   199: invokevirtual 755	java/io/FileInputStream:close	()V
    //   202: aload 4
    //   204: astore_1
    //   205: aload 8
    //   207: ldc_w 757
    //   210: invokevirtual 760	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   213: astore 5
    //   215: aload 5
    //   217: ifnonnull +63 -> 280
    //   220: aload 4
    //   222: ifnull +8 -> 230
    //   225: aload 4
    //   227: invokevirtual 755	java/io/FileInputStream:close	()V
    //   230: getstatic 123	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   233: invokeinterface 731 1 0
    //   238: aload 6
    //   240: aload 7
    //   242: invokestatic 735	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   245: iconst_m1
    //   246: ireturn
    //   247: astore_1
    //   248: ldc_w 629
    //   251: new 543	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 544	java/lang/StringBuilder:<init>	()V
    //   258: ldc_w 737
    //   261: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_1
    //   265: invokevirtual 738	java/io/IOException:toString	()Ljava/lang/String;
    //   268: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 561	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 740	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: goto -47 -> 230
    //   280: aload 4
    //   282: astore_1
    //   283: aload 5
    //   285: invokestatic 766	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   288: istore_2
    //   289: aload 4
    //   291: ifnull +8 -> 299
    //   294: aload 4
    //   296: invokevirtual 755	java/io/FileInputStream:close	()V
    //   299: getstatic 123	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   302: invokeinterface 731 1 0
    //   307: aload 6
    //   309: aload 7
    //   311: invokestatic 735	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   314: iload_2
    //   315: ireturn
    //   316: astore_1
    //   317: ldc_w 629
    //   320: new 543	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 544	java/lang/StringBuilder:<init>	()V
    //   327: ldc_w 737
    //   330: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_1
    //   334: invokevirtual 738	java/io/IOException:toString	()Ljava/lang/String;
    //   337: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 561	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 740	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: goto -47 -> 299
    //   349: astore 5
    //   351: aconst_null
    //   352: astore 4
    //   354: aload 4
    //   356: astore_1
    //   357: ldc_w 629
    //   360: new 543	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 544	java/lang/StringBuilder:<init>	()V
    //   367: ldc_w 631
    //   370: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload 5
    //   375: invokevirtual 632	java/lang/Exception:toString	()Ljava/lang/String;
    //   378: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 561	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 740	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   387: aload 4
    //   389: ifnull +8 -> 397
    //   392: aload 4
    //   394: invokevirtual 755	java/io/FileInputStream:close	()V
    //   397: getstatic 123	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   400: invokeinterface 731 1 0
    //   405: aload 6
    //   407: aload 7
    //   409: invokestatic 735	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   412: iconst_m1
    //   413: ireturn
    //   414: astore_1
    //   415: ldc_w 629
    //   418: new 543	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 544	java/lang/StringBuilder:<init>	()V
    //   425: ldc_w 737
    //   428: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload_1
    //   432: invokevirtual 738	java/io/IOException:toString	()Ljava/lang/String;
    //   435: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 561	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokestatic 740	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   444: goto -47 -> 397
    //   447: astore_1
    //   448: aload 5
    //   450: astore 4
    //   452: aload 4
    //   454: ifnull +8 -> 462
    //   457: aload 4
    //   459: invokevirtual 755	java/io/FileInputStream:close	()V
    //   462: getstatic 123	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   465: invokeinterface 731 1 0
    //   470: aload 6
    //   472: aload 7
    //   474: invokestatic 735	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   477: aload_1
    //   478: athrow
    //   479: astore 4
    //   481: ldc_w 629
    //   484: new 543	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 544	java/lang/StringBuilder:<init>	()V
    //   491: ldc_w 737
    //   494: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload 4
    //   499: invokevirtual 738	java/io/IOException:toString	()Ljava/lang/String;
    //   502: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 561	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 740	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: goto -49 -> 462
    //   514: aload 6
    //   516: aload 7
    //   518: invokestatic 735	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   521: iconst_m1
    //   522: ireturn
    //   523: astore 5
    //   525: aload_1
    //   526: astore 4
    //   528: aload 5
    //   530: astore_1
    //   531: goto -79 -> 452
    //   534: astore 5
    //   536: goto -182 -> 354
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	WebView
    //   0	539	1	paramContext	Context
    //   288	27	2	i	int
    //   98	2	3	bool	boolean
    //   182	276	4	localObject1	Object
    //   479	19	4	localIOException	java.io.IOException
    //   526	1	4	localContext	Context
    //   42	242	5	str	String
    //   349	100	5	localException1	Exception
    //   523	6	5	localObject2	Object
    //   534	1	5	localException2	Exception
    //   21	494	6	localFileLock	java.nio.channels.FileLock
    //   8	509	7	localFileOutputStream	java.io.FileOutputStream
    //   172	34	8	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   107	115	132	java/io/IOException
    //   225	230	247	java/io/IOException
    //   294	299	316	java/io/IOException
    //   44	90	349	java/lang/Exception
    //   94	99	349	java/lang/Exception
    //   165	184	349	java/lang/Exception
    //   392	397	414	java/io/IOException
    //   44	90	447	finally
    //   94	99	447	finally
    //   165	184	447	finally
    //   457	462	479	java/io/IOException
    //   187	194	523	finally
    //   197	202	523	finally
    //   205	215	523	finally
    //   283	289	523	finally
    //   357	387	523	finally
    //   187	194	534	java/lang/Exception
    //   197	202	534	java/lang/Exception
    //   205	215	534	java/lang/Exception
    //   283	289	534	java/lang/Exception
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
    return 43609;
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
  
  private void registerConnectivityChangedReceiverIfNeeded(final Context paramContext)
  {
    if (sConnectivityChangeReceiver != null) {
      return;
    }
    sConnectivityChangeReceiver = new ConnectivityChangedReceiver(null);
    new Thread()
    {
      public void run()
      {
        try
        {
          if (Apn.getApnType(paramContext) == 3) {}
          for (boolean bool = true;; bool = false)
          {
            QbSdk.sIsApnWifi = bool;
            QbSdk.sApnRecordTime = System.currentTimeMillis();
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            paramContext.getApplicationContext().registerReceiver(WebView.sConnectivityChangeReceiver, localIntentFilter);
            return;
          }
          return;
        }
        catch (Throwable localThrowable) {}
      }
    }.start();
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
    new Thread()
    {
      public void run()
      {
        if (WebView.mAppContext == null) {
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
        }
        SDKEngine localSDKEngine;
        int i;
        int j;
        do
        {
          return;
          localSDKEngine = SDKEngine.getInstance(true);
          if (SDKEngine.mTbsNeedReboot)
          {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
            return;
          }
          TbsCoreVerManager localTbsCoreVerManager = TbsCoreVerManager.getInstance(WebView.mAppContext);
          i = localTbsCoreVerManager.getTbsCoreInstallStatus();
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + i);
          if (i == 2)
          {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
            localSDKEngine.setCalledCountKey(String.valueOf(localTbsCoreVerManager.getTbsCoreInstallVer()));
            localSDKEngine.setTbsNeedReboot(true);
            return;
          }
          j = localTbsCoreVerManager.getIntStatus("copy_status");
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + j);
          if (j == 1)
          {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
            localSDKEngine.setCalledCountKey(String.valueOf(localTbsCoreVerManager.getIntNum("copy_core_ver")));
            localSDKEngine.setTbsNeedReboot(true);
            return;
          }
        } while ((X5CoreEngine.getInstance().isX5Core()) || ((i != 3) && (j != 3)));
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
        localSDKEngine.setCalledCountKey(String.valueOf(SDKEngine.getTbsCoreVersion()));
        localSDKEngine.setTbsNeedReboot(true);
      }
    }.start();
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
        return ((Integer)localMethod.invoke(this.mX5WebView.getView(), null)).intValue();
      }
      Method localMethod = ReflectionUtils.getParentDeclaredMethod(this.mSysWebView, "computeHorizontalScrollExtent", new Class[0]);
      localMethod.setAccessible(true);
      int i = ((Integer)localMethod.invoke(this.mSysWebView, null)).intValue();
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
        return ((Integer)localMethod.invoke(this.mX5WebView.getView(), null)).intValue();
      }
      Method localMethod = ReflectionUtils.getParentDeclaredMethod(this.mSysWebView, "computeHorizontalScrollOffset", new Class[0]);
      localMethod.setAccessible(true);
      int i = ((Integer)localMethod.invoke(this.mSysWebView, null)).intValue();
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
      int i = ((Integer)localMethod.invoke(this.mSysWebView, null)).intValue();
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
        return ((Integer)localMethod.invoke(this.mX5WebView.getView(), null)).intValue();
      }
      Method localMethod = ReflectionUtils.getParentDeclaredMethod(this.mSysWebView, "computeVerticalScrollExtent", new Class[0]);
      localMethod.setAccessible(true);
      int i = ((Integer)localMethod.invoke(this.mSysWebView, null)).intValue();
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
        return ((Integer)localMethod.invoke(this.mX5WebView.getView(), null)).intValue();
      }
      Method localMethod = ReflectionUtils.getParentDeclaredMethod(this.mSysWebView, "computeVerticalScrollOffset", new Class[0]);
      localMethod.setAccessible(true);
      int i = ((Integer)localMethod.invoke(this.mSysWebView, null)).intValue();
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
      int i = ((Integer)localMethod.invoke(this.mSysWebView, null)).intValue();
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
        new Thread("WebviewDestroy")
        {
          public void run()
          {
            WebView.this.tbsWebviewDestroy(false);
          }
        }.start();
        if (!this.isX5Core) {
          this.mSysWebView.destroy();
        }
      }
      else
      {
        tbsWebviewDestroy(true);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      tbsWebviewDestroy(true);
    }
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
  
  public HitTestResult getHitTestResult()
  {
    if (!this.isX5Core) {
      return new HitTestResult(this.mSysWebView.getHitTestResult());
    }
    return new HitTestResult(this.mX5WebView.getHitTestResult());
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
        new Thread("onDetachedFromWindow")
        {
          public void run()
          {
            WebView.this.tbsOnDetachedFromWindow();
          }
        }.start();
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
    if ((paramInt != 0) && (!this.mIsReported) && (this.mPv != 0))
    {
      this.mIsReported = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      String str3 = str4;
      String str2 = str5;
      String str1 = str6;
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
      HttpUtils.doReport(this.mContext, str3, str2, str1, this.mPv, this.isX5Core, getWifiConnectedTime());
      this.mPv = 0;
      this.mIsReported = false;
    }
    super.onVisibilityChanged(paramView, paramInt);
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
  
  public void reportInitPerformance(long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
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
    }
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
  
  public void setDownloadListener(final DownloadListener paramDownloadListener)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setDownloadListener(new android.webkit.DownloadListener()
      {
        public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
        {
          if (paramDownloadListener == null)
          {
            MttLoader.loadUrl(WebView.this.mContext, paramAnonymousString1, null, null);
            return;
          }
          paramDownloadListener.onDownloadStart(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4, paramAnonymousLong);
        }
      });
      return;
    }
    this.mX5WebView.setDownloadListener(new DownLoadListenerAdapter(this, paramDownloadListener, this.isX5Core));
  }
  
  @TargetApi(16)
  public void setFindListener(final IX5WebViewBase.FindListener paramFindListener)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.mSysWebView.setFindListener(new WebView.FindListener()
        {
          public void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
          {
            paramFindListener.onFindResultReceived(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
          }
        });
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
  
  public void setPictureListener(final PictureListener paramPictureListener)
  {
    if (!this.isX5Core)
    {
      if (paramPictureListener == null)
      {
        this.mSysWebView.setPictureListener(null);
        return;
      }
      this.mSysWebView.setPictureListener(new android.webkit.WebView.PictureListener()
      {
        public void onNewPicture(android.webkit.WebView paramAnonymousWebView, Picture paramAnonymousPicture)
        {
          WebView.this.setSysWebView(paramAnonymousWebView);
          paramPictureListener.onNewPicture(WebView.this, paramAnonymousPicture);
        }
      });
      return;
    }
    if (paramPictureListener == null)
    {
      this.mX5WebView.setPictureListener(null);
      return;
    }
    this.mX5WebView.setPictureListener(new IX5WebViewBase.PictureListener()
    {
      public void onNewPicture(IX5WebViewBase paramAnonymousIX5WebViewBase, Picture paramAnonymousPicture, boolean paramAnonymousBoolean)
      {
        WebView.this.setX5WebView(paramAnonymousIX5WebViewBase);
        paramPictureListener.onNewPicture(WebView.this, paramAnonymousPicture);
      }
      
      public void onNewPictureIfHaveContent(IX5WebViewBase paramAnonymousIX5WebViewBase, Picture paramAnonymousPicture) {}
    });
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
    SystemWebView localSystemWebView = this.mSysWebView;
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
    SystemWebView localSystemWebView = this.mSysWebView;
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
    if ((!this.mIsReported) && (this.mPv != 0))
    {
      this.mIsReported = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      String str3 = str4;
      String str2 = str5;
      String str1 = str6;
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
      HttpUtils.doReport(this.mContext, str3, str2, str1, this.mPv, this.isX5Core, getWifiConnectedTime());
      this.mPv = 0;
      this.mIsReported = false;
    }
    super.onDetachedFromWindow();
  }
  
  public void tbsWebviewDestroy(boolean paramBoolean)
  {
    Object localObject4;
    Object localObject1;
    int i;
    if ((!this.mIsReported) && (this.mPv != 0))
    {
      this.mIsReported = true;
      String str1 = "";
      String str2 = "";
      String str3 = "";
      localObject4 = str1;
      ??? = str2;
      localObject1 = str3;
      if (this.isX5Core)
      {
        Bundle localBundle = this.mX5WebView.getX5WebViewExtension().getSdkQBStatisticsInfo();
        localObject4 = str1;
        ??? = str2;
        localObject1 = str3;
        if (localBundle != null)
        {
          localObject4 = localBundle.getString("guid");
          ??? = localBundle.getString("qua2");
          localObject1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName))
      {
        int j = getTbsCorePV(this.mContext);
        i = j;
        if (j == -1) {
          i = this.mPv;
        }
        this.mPv = i;
        deletepvfile(this.mContext);
      }
      HttpUtils.doReport(this.mContext, (String)localObject4, (String)???, (String)localObject1, this.mPv, this.isX5Core, getWifiConnectedTime());
      this.mPv = 0;
      this.mIsReported = false;
    }
    if (!this.isX5Core) {}
    try
    {
      localObject1 = Class.forName("android.webkit.WebViewClassic");
      ??? = ((Class)localObject1).getMethod("fromWebView", new Class[] { android.webkit.WebView.class });
      ((Method)???).setAccessible(true);
      ??? = ((Method)???).invoke(null, new Object[] { this.mSysWebView });
      if (??? != null)
      {
        localObject1 = ((Class)localObject1).getDeclaredField("mListBoxDialog");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(???);
        if (localObject1 != null)
        {
          localObject1 = (Dialog)localObject1;
          ((Dialog)localObject1).setOnCancelListener(null);
          ??? = Class.forName("android.app.Dialog");
          localObject4 = ((Class)???).getDeclaredField("CANCEL");
          ((Field)localObject4).setAccessible(true);
          i = ((Integer)((Field)localObject4).get(localObject1)).intValue();
          ??? = ((Class)???).getDeclaredField("mListenersHandler");
          ((Field)???).setAccessible(true);
          ((Handler)((Field)???).get(localObject1)).removeMessages(i);
        }
      }
    }
    catch (Exception localException2)
    {
      label380:
      break label380;
    }
    if (paramBoolean) {
      this.mSysWebView.destroy();
    }
    for (;;)
    {
      try
      {
        ??? = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
        ((Field)???).setAccessible(true);
        localObject1 = (ComponentCallbacks)((Field)???).get(null);
        if (localObject1 != null)
        {
          ((Field)???).set(null, null);
          ??? = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
          ((Field)???).setAccessible(true);
          ??? = ((Field)???).get(null);
          if (??? == null) {}
        }
      }
      catch (Exception localException1)
      {
        continue;
      }
      synchronized ((List)???)
      {
        ((List)???).remove(localObject1);
        TbsLog.i("WebView", "X5 GUID = " + QbSdk.getGuid());
        return;
      }
      this.mX5WebView.destroy();
    }
  }
  
  /* Error */
  void writetbscorepvfile(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 1338	com/tencent/smtt/sdk/WebView:getTbsCorePV	(Landroid/content/Context;)I
    //   5: istore_2
    //   6: iload_2
    //   7: iconst_m1
    //   8: if_icmpeq +80 -> 88
    //   11: new 543	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 544	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 1820
    //   21: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_2
    //   25: iconst_1
    //   26: iadd
    //   27: invokestatic 1822	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   30: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 561	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_3
    //   37: aload_1
    //   38: ldc_w 603
    //   41: iconst_0
    //   42: invokevirtual 607	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   45: astore_1
    //   46: new 609	java/io/File
    //   49: dup
    //   50: new 543	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 544	java/lang/StringBuilder:<init>	()V
    //   57: aload_1
    //   58: invokevirtual 612	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   61: getstatic 615	java/io/File:separator	Ljava/lang/String;
    //   64: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 617
    //   70: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 561	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: ldc_w 619
    //   79: invokespecial 621	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: astore_1
    //   83: aload_1
    //   84: ifnonnull +11 -> 95
    //   87: return
    //   88: ldc_w 1824
    //   91: astore_3
    //   92: goto -55 -> 37
    //   95: aload_1
    //   96: invokevirtual 1828	java/io/File:getParentFile	()Ljava/io/File;
    //   99: invokevirtual 1831	java/io/File:mkdirs	()Z
    //   102: pop
    //   103: aload_1
    //   104: invokevirtual 1834	java/io/File:isFile	()Z
    //   107: ifeq +10 -> 117
    //   110: aload_1
    //   111: invokevirtual 624	java/io/File:exists	()Z
    //   114: ifne +8 -> 122
    //   117: aload_1
    //   118: invokevirtual 1837	java/io/File:createNewFile	()Z
    //   121: pop
    //   122: new 1839	java/io/FileOutputStream
    //   125: dup
    //   126: aload_1
    //   127: iconst_0
    //   128: invokespecial 1842	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   131: putstatic 125	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   134: getstatic 125	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   137: aload_3
    //   138: invokevirtual 1846	java/lang/String:getBytes	()[B
    //   141: invokevirtual 1852	java/io/OutputStream:write	([B)V
    //   144: getstatic 125	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   147: ifnull -60 -> 87
    //   150: getstatic 125	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   153: invokevirtual 1855	java/io/OutputStream:flush	()V
    //   156: return
    //   157: astore_1
    //   158: getstatic 125	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   161: ifnull +9 -> 170
    //   164: getstatic 125	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   167: invokevirtual 1855	java/io/OutputStream:flush	()V
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	WebView
    //   0	174	1	paramContext	Context
    //   5	22	2	i	int
    //   36	102	3	str	String
    // Exception table:
    //   from	to	target	type
    //   95	117	157	finally
    //   117	122	157	finally
    //   122	144	157	finally
    //   144	156	172	java/lang/Throwable
    //   158	170	172	java/lang/Throwable
    //   170	172	172	java/lang/Throwable
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
  
  private static class ConnectivityChangedReceiver
    extends BroadcastReceiver
  {
    public void onReceive(Context arg1, Intent paramIntent)
    {
      if (paramIntent != null) {}
      for (;;)
      {
        try
        {
          int i;
          long l;
          if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
          {
            i = Apn.getApnType(???);
            l = System.currentTimeMillis();
          }
          synchronized (QbSdk.sApnLock)
          {
            if (QbSdk.sIsApnWifi) {
              QbSdk.sWifiConnectedTime += l - QbSdk.sApnRecordTime;
            }
            QbSdk.sApnRecordTime = l;
            TbsLog.d("sdkreport", "pv report, SdkEngine.registerConnectivityChangedReceiver QbSdk.sWifiConnectTime=" + QbSdk.sWifiConnectedTime + " apnType=" + i);
            if (i == 3)
            {
              bool = true;
              QbSdk.sIsApnWifi = bool;
              return;
            }
          }
          boolean bool = false;
        }
        catch (Throwable ???)
        {
          return;
        }
      }
    }
  }
  
  public static class HitTestResult
  {
    @Deprecated
    public static final int ANCHOR_TYPE = 1;
    public static final int EDIT_TEXT_TYPE = 9;
    public static final int EMAIL_TYPE = 4;
    public static final int GEO_TYPE = 3;
    @Deprecated
    public static final int IMAGE_ANCHOR_TYPE = 6;
    public static final int IMAGE_TYPE = 5;
    public static final int PHONE_TYPE = 2;
    public static final int SRC_ANCHOR_TYPE = 7;
    public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
    public static final int UNKNOWN_TYPE = 0;
    private IX5WebViewBase.HitTestResult mHitTestResultImpl;
    private android.webkit.WebView.HitTestResult mSysHitTestResult = null;
    
    public HitTestResult()
    {
      this.mHitTestResultImpl = null;
      this.mSysHitTestResult = null;
    }
    
    public HitTestResult(android.webkit.WebView.HitTestResult paramHitTestResult)
    {
      this.mHitTestResultImpl = null;
      this.mSysHitTestResult = paramHitTestResult;
    }
    
    public HitTestResult(IX5WebViewBase.HitTestResult paramHitTestResult)
    {
      this.mHitTestResultImpl = paramHitTestResult;
      this.mSysHitTestResult = null;
    }
    
    public String getExtra()
    {
      String str = "";
      if (this.mHitTestResultImpl != null) {
        str = this.mHitTestResultImpl.getExtra();
      }
      while (this.mSysHitTestResult == null) {
        return str;
      }
      return this.mSysHitTestResult.getExtra();
    }
    
    public int getType()
    {
      int i = 0;
      if (this.mHitTestResultImpl != null) {
        i = this.mHitTestResultImpl.getType();
      }
      while (this.mSysHitTestResult == null) {
        return i;
      }
      return this.mSysHitTestResult.getType();
    }
    
    public void setExtra(String paramString)
    {
      if (this.mHitTestResultImpl != null) {
        this.mHitTestResultImpl.setExtra(paramString);
      }
    }
    
    public void setType(int paramInt)
    {
      if (this.mHitTestResultImpl != null) {
        this.mHitTestResultImpl.setType(paramInt);
      }
    }
  }
  
  public static abstract interface PictureListener
  {
    public abstract void onNewPicture(WebView paramWebView, Picture paramPicture);
  }
  
  private class SystemWebView
    extends android.webkit.WebView
  {
    public SystemWebView(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public SystemWebView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      if ((QbSdk.getIsSysWebViewForcedByOuter()) && (TbsShareManager.isThirdPartyApp(paramContext))) {
        return;
      }
      CookieSyncManager.createInstance(WebView.this.mContext).startSync();
      try
      {
        this$1 = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
        WebView.this.setAccessible(true);
        ((Handler)WebView.this.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
        WebView.mSysWebviewCreated = true;
        return;
      }
      catch (Exception this$1) {}
    }
    
    public void computeScroll()
    {
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.computeScroll(this);
        return;
      }
      super.computeScroll();
    }
    
    protected void dispatchDraw(Canvas paramCanvas)
    {
      try
      {
        super.dispatchDraw(paramCanvas);
        if ((!WebView.mIsDayMode) && (WebView.mNightModePaint != null))
        {
          paramCanvas.save();
          paramCanvas.drawPaint(WebView.mNightModePaint);
          paramCanvas.restore();
        }
        return;
      }
      catch (Throwable paramCanvas)
      {
        paramCanvas.printStackTrace();
      }
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.dispatchTouchEvent(paramMotionEvent, this);
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    
    public android.webkit.WebSettings getSettings()
    {
      try
      {
        android.webkit.WebSettings localWebSettings = super.getSettings();
        return localWebSettings;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return null;
    }
    
    public void invalidate()
    {
      super.invalidate();
      if (WebView.this.mWebViewCallbackClient != null) {
        WebView.this.mWebViewCallbackClient.invalidate();
      }
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.onInterceptTouchEvent(paramMotionEvent, this);
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    @TargetApi(9)
    public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        WebView.this.mWebViewCallbackClient.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, this);
      }
      while (Build.VERSION.SDK_INT < 9) {
        return;
      }
      super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    }
    
    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
        return;
      }
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      WebView.this.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      if (!hasFocus()) {
        requestFocus();
      }
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.onTouchEvent(paramMotionEvent, this);
      }
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      return false;
    }
    
    @TargetApi(9)
    public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, this);
      }
      if (Build.VERSION.SDK_INT >= 9) {
        return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      }
      return false;
    }
    
    public void setOverScrollMode(int paramInt)
    {
      try
      {
        super.setOverScrollMode(paramInt);
        return;
      }
      catch (Exception localException) {}
    }
    
    public void super_computeScroll()
    {
      super.computeScroll();
    }
    
    public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    
    public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    @TargetApi(9)
    public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      }
    }
    
    public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
    {
      return super.onTouchEvent(paramMotionEvent);
    }
    
    @TargetApi(9)
    public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      }
      return false;
    }
  }
  
  public class WebViewTransport
  {
    private WebView mWebview;
    
    public WebViewTransport() {}
    
    public WebView getWebView()
    {
      try
      {
        WebView localWebView = this.mWebview;
        return localWebView;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void setWebView(WebView paramWebView)
    {
      try
      {
        this.mWebview = paramWebView;
        return;
      }
      finally
      {
        paramWebView = finally;
        throw paramWebView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView
 * JD-Core Version:    0.7.0.1
 */