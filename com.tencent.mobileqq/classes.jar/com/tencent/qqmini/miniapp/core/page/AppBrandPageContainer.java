package com.tencent.qqmini.miniapp.core.page;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.qqmini.miniapp.R.anim;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.miniapp.core.page.pool.AppBrandPagePool;
import com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientFactory;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.Preloadable;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo.Builder;
import com.tencent.qqmini.sdk.launcher.core.model.FloatDragAdInfo;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.monitor.ui.MiniAppMonitorInfoView;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.widget.CapsuleButton;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.CoverView.JsRuntimeListener;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import com.tencent.qqmini.sdk.widget.TabBar;
import com.tencent.qqmini.sdk.widget.TabBar.OnTabItemClickListener;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@MiniKeep
public class AppBrandPageContainer
  extends FrameLayout
  implements IAppBrandPageContainer, Preloadable, TabBar.OnTabItemClickListener
{
  public static final String KEY_APPID = "appId";
  public static final String KEY_SCENE = "scene";
  public static final int MAX_ALIVEWEBVIEWCOUNT = 10;
  public static final String ON_APP_ENTER_BACKGROUND = "onAppEnterBackground";
  public static final String ON_APP_ENTER_FOREGROUND = "onAppEnterForeground";
  public static final String ON_KEYBOARD_HEIGHT_CHANGE = "onKeyboardHeightChange";
  private static final String TAG = "minisdk-start-AppBrandPageContainer";
  public int aliveWebViewCount = 0;
  private LinkedList<AppBrandPage> appBrandPages = new LinkedList();
  private int curShowingInputId = -1;
  private Activity mActivity;
  private ApkgInfo mApkgInfo;
  private AppBrandPagePool mAppBrandPagePool;
  private AppBrandPageContainer.MonitorBroadcastReceiver mBroadcastReceiver;
  private IMiniAppContext mContext;
  EventListener mEventListener;
  private boolean mFromReload = false;
  private MiniAppInfo mMiniAppInfo;
  private MiniAppMonitorInfoView mMiniAppMonitorInfoView;
  private SoftKeyboardStateHelper mSoftKeyboardStateHelper;
  private List<SoftKeyboardStateHelper.SoftKeyboardStateListener> mSoftKeyboardStateListenerList = new CopyOnWriteArrayList();
  
  public AppBrandPageContainer(IMiniAppContext paramIMiniAppContext, EventListener paramEventListener)
  {
    super(paramIMiniAppContext.getContext());
    this.mContext = paramIMiniAppContext;
    this.mEventListener = paramEventListener;
    this.mSoftKeyboardStateHelper = new SoftKeyboardStateHelper(this);
    this.mAppBrandPagePool = new AppBrandPagePool(paramIMiniAppContext);
    this.mSoftKeyboardStateHelper.addSoftKeyboardStateListener(new AppBrandPageContainer.1(this));
  }
  
  private void executeDownSubPackage(String paramString1, String paramString2)
  {
    WeakReference localWeakReference = new WeakReference(this);
    if (this.mActivity != null) {}
    for (ToastView localToastView = new ToastView(this.mActivity, this);; localToastView = null)
    {
      if (localToastView != null) {
        localToastView.show(1, "loading", null, "正在加载模块...", -1, true);
      }
      com.tencent.qqmini.sdk.manager.ApkgManager.getInstance().downloadSubPack(this.mApkgInfo, this.mContext.getMiniAppInfo(), paramString1, new AppBrandPageContainer.4(this, localToastView, paramString1, localWeakReference, paramString2));
      return;
    }
  }
  
  private AppBrandPage getBrandPage()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.appBrandPages != null)
    {
      localObject1 = localObject2;
      if (this.appBrandPages.size() > 0)
      {
        localObject2 = (AppBrandPage)this.appBrandPages.poll();
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          ((AppBrandPage)localObject2).onPause();
          localObject1 = localObject2;
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = this.mAppBrandPagePool.getAppBrandPage(this.mContext, this);
      addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
    }
    return localObject2;
  }
  
  private String getMenuButtonBoundingClientRect(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    Object localObject = getCapsuleButton();
    int j;
    int i;
    if (localObject != null)
    {
      j = (int)(((View)localObject).getWidth() / DisplayUtil.getDensity(this.mActivity));
      i = (int)(((View)localObject).getHeight() / DisplayUtil.getDensity(this.mActivity));
      int k = (int)(((View)localObject).getLeft() / DisplayUtil.getDensity(this.mActivity));
      int m = (int)(((View)localObject).getTop() / DisplayUtil.getDensity(this.mActivity));
      int n = (int)(((View)localObject).getRight() / DisplayUtil.getDensity(this.mActivity));
      int i1 = (int)(((View)localObject).getBottom() / DisplayUtil.getDensity(this.mActivity));
      localObject = new Rect(267, 34, 347, 64);
      if (j == 0) {
        break label333;
      }
      localObject = new Rect(k, m, n, i1);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("width", j);
        localJSONObject.put("height", i);
        localJSONObject.put("top", ((Rect)localObject).top);
        localJSONObject.put("right", ((Rect)localObject).right);
        localJSONObject.put("bottom", ((Rect)localObject).bottom);
        localJSONObject.put("left", ((Rect)localObject).left);
        paramNativeViewRequestEvent.ok();
        QMLog.d("minisdk-start-AppBrandPageContainer", "getMenuButtonBoundingClientRect : " + localJSONObject.toString());
        localObject = localJSONObject.toString();
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        QMLog.e("minisdk-start-AppBrandPageContainer", paramNativeViewRequestEvent.event + " error.", localJSONException);
        return "";
      }
      QMLog.e("minisdk-start-AppBrandPageContainer", "EVENT_GET_MENU_BUTTON_RECT view is null.");
      paramNativeViewRequestEvent.fail();
      return getMenuButtonDefaultValue();
      label333:
      i = 30;
      j = 80;
    }
  }
  
  private String getMenuButtonDefaultValue()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("width", 80);
      ((JSONObject)localObject).put("height", 30);
      ((JSONObject)localObject).put("top", 34);
      ((JSONObject)localObject).put("right", 347);
      ((JSONObject)localObject).put("bottom", 64);
      ((JSONObject)localObject).put("left", 267);
      QMLog.d("minisdk-start-AppBrandPageContainer", "getMenuButtonDefaultValue : " + ((JSONObject)localObject).toString());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("minisdk-start-AppBrandPageContainer", "getDefaultValue error.", localJSONException);
    }
    return "";
  }
  
  private NativeViewContainer getNativeViewContainer()
  {
    PageWebviewContainer localPageWebviewContainer = getPageWebviewContainer();
    if (localPageWebviewContainer == null) {
      return null;
    }
    return localPageWebviewContainer.getNativeViewContainer();
  }
  
  private PageWebviewContainer getPageWebviewContainer()
  {
    AppBrandPage localAppBrandPage = getShowingPage();
    if (localAppBrandPage == null) {
      return null;
    }
    return localAppBrandPage.getPageWebviewContainer();
  }
  
  private void handleOnTabItemTap(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("index", paramInt);
      localJSONObject.put("pagePath", paramString1);
      localJSONObject.put("text", paramString2);
      this.mContext.performAction(ServiceSubscribeEvent.obtain("onTabItemTap", localJSONObject.toString(), getShowingPageWebViewId()));
      return;
    }
    catch (Throwable paramString1)
    {
      QMLog.e("minisdk-start-AppBrandPageContainer", "onTabItemClick error,", paramString1);
    }
  }
  
  private String handlePageEvent(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    if ("setEnableDebug".equals(paramNativeViewRequestEvent.event))
    {
      try
      {
        boolean bool = new JSONObject(paramNativeViewRequestEvent.jsonParams).optBoolean("enableDebug");
        if (bool != Boolean.valueOf(StorageUtil.getPreference().getBoolean(this.mContext.getMiniAppInfo().appId + "_debug", false)).booleanValue()) {
          this.mContext.getAttachedActivity().runOnUiThread(new AppBrandPageContainer.5(this, bool));
        } else {
          paramNativeViewRequestEvent.ok();
        }
      }
      catch (JSONException localJSONException)
      {
        paramNativeViewRequestEvent.fail();
      }
    }
    else if ("setBackgroundTextStyle".equals(paramNativeViewRequestEvent.event))
    {
      AppBrandTask.runTaskOnUiThread(new AppBrandPageContainer.6(this, paramNativeViewRequestEvent));
    }
    else if ("setBackgroundColor".equals(paramNativeViewRequestEvent.event))
    {
      AppBrandTask.runTaskOnUiThread(new AppBrandPageContainer.7(this, paramNativeViewRequestEvent));
    }
    else
    {
      if ("getMenuButtonBoundingClientRect".equals(paramNativeViewRequestEvent.event)) {
        return getMenuButtonBoundingClientRect(paramNativeViewRequestEvent);
      }
      if ("reportKeyValue".equals(paramNativeViewRequestEvent.event)) {
        reportKeyValue(paramNativeViewRequestEvent);
      }
    }
    return null;
  }
  
  private void initMonitor()
  {
    if (this.mActivity == null) {
      return;
    }
    this.mBroadcastReceiver = new AppBrandPageContainer.MonitorBroadcastReceiver(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action.qq.miniapp.show.monitorview");
    this.mActivity.registerReceiver(this.mBroadcastReceiver, localIntentFilter);
  }
  
  /* Error */
  private boolean isIndexHtmlValid(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 474	com/tencent/qqmini/miniapp/core/page/AppBrandPageContainer:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   7: getfield 478	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   10: getfield 483	com/tencent/qqmini/sdk/launcher/model/LaunchParam:isFlutterMode	Z
    //   13: istore 5
    //   15: iload 4
    //   17: istore_3
    //   18: aload_0
    //   19: getfield 166	com/tencent/qqmini/miniapp/core/page/AppBrandPageContainer:mApkgInfo	Lcom/tencent/qqmini/sdk/launcher/core/model/ApkgInfo;
    //   22: ifnull +286 -> 308
    //   25: aload_1
    //   26: astore 6
    //   28: aload_1
    //   29: invokestatic 489	com/tencent/qqmini/sdk/launcher/utils/AppBrandUtil:getUrlWithoutParams	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 7
    //   34: iload 5
    //   36: ifeq +109 -> 145
    //   39: aload 7
    //   41: astore 6
    //   43: new 491	java/io/File
    //   46: dup
    //   47: aload_0
    //   48: getfield 166	com/tencent/qqmini/miniapp/core/page/AppBrandPageContainer:mApkgInfo	Lcom/tencent/qqmini/sdk/launcher/core/model/ApkgInfo;
    //   51: aload 7
    //   53: invokevirtual 496	com/tencent/qqmini/sdk/launcher/core/model/ApkgInfo:getChildFileAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   56: invokespecial 497	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: invokestatic 503	com/tencent/qqmini/sdk/launcher/utils/FileUtils:readFileToStr	(Ljava/io/File;)Ljava/lang/String;
    //   62: astore_1
    //   63: aload 7
    //   65: astore 6
    //   67: iload 4
    //   69: istore_3
    //   70: aload_1
    //   71: invokestatic 509	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   74: ifne +234 -> 308
    //   77: aload 7
    //   79: astore 6
    //   81: aload_1
    //   82: ldc_w 511
    //   85: invokevirtual 515	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   88: iflt +74 -> 162
    //   91: aload 7
    //   93: astore 6
    //   95: aload_1
    //   96: ldc_w 517
    //   99: invokevirtual 515	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   102: iflt +60 -> 162
    //   105: iconst_1
    //   106: istore_2
    //   107: iload 4
    //   109: istore_3
    //   110: iload_2
    //   111: ifne +197 -> 308
    //   114: aload 7
    //   116: astore 6
    //   118: ldc 33
    //   120: new 281	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   127: ldc_w 519
    //   130: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_1
    //   134: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 312	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: iconst_0
    //   144: ireturn
    //   145: aload 7
    //   147: astore 6
    //   149: aload_0
    //   150: getfield 166	com/tencent/qqmini/miniapp/core/page/AppBrandPageContainer:mApkgInfo	Lcom/tencent/qqmini/sdk/launcher/core/model/ApkgInfo;
    //   153: aload 7
    //   155: invokevirtual 522	com/tencent/qqmini/sdk/launcher/core/model/ApkgInfo:readApkgToString	(Ljava/lang/String;)Ljava/lang/String;
    //   158: astore_1
    //   159: goto -96 -> 63
    //   162: iconst_0
    //   163: istore_2
    //   164: goto -57 -> 107
    //   167: astore 7
    //   169: aload 6
    //   171: invokestatic 489	com/tencent/qqmini/sdk/launcher/utils/AppBrandUtil:getUrlWithoutParams	(Ljava/lang/String;)Ljava/lang/String;
    //   174: astore 8
    //   176: iload 5
    //   178: ifeq +88 -> 266
    //   181: new 491	java/io/File
    //   184: dup
    //   185: aload_0
    //   186: getfield 166	com/tencent/qqmini/miniapp/core/page/AppBrandPageContainer:mApkgInfo	Lcom/tencent/qqmini/sdk/launcher/core/model/ApkgInfo;
    //   189: aload 8
    //   191: invokevirtual 496	com/tencent/qqmini/sdk/launcher/core/model/ApkgInfo:getChildFileAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   194: invokespecial 497	java/io/File:<init>	(Ljava/lang/String;)V
    //   197: astore_1
    //   198: iload 5
    //   200: ifeq +79 -> 279
    //   203: aload_1
    //   204: invokestatic 503	com/tencent/qqmini/sdk/launcher/utils/FileUtils:readFileToStr	(Ljava/io/File;)Ljava/lang/String;
    //   207: astore 6
    //   209: ldc 33
    //   211: new 281	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   218: ldc_w 524
    //   221: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload 8
    //   226: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc_w 526
    //   232: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_1
    //   236: invokevirtual 529	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   239: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc_w 531
    //   245: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload 6
    //   250: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: aload 7
    //   258: invokestatic 306	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   261: iconst_0
    //   262: istore_3
    //   263: goto +45 -> 308
    //   266: aload_0
    //   267: getfield 166	com/tencent/qqmini/miniapp/core/page/AppBrandPageContainer:mApkgInfo	Lcom/tencent/qqmini/sdk/launcher/core/model/ApkgInfo;
    //   270: aload 8
    //   272: invokevirtual 535	com/tencent/qqmini/sdk/launcher/core/model/ApkgInfo:getApkgFile	(Ljava/lang/String;)Ljava/io/File;
    //   275: astore_1
    //   276: goto -78 -> 198
    //   279: aload_0
    //   280: getfield 166	com/tencent/qqmini/miniapp/core/page/AppBrandPageContainer:mApkgInfo	Lcom/tencent/qqmini/sdk/launcher/core/model/ApkgInfo;
    //   283: aload 8
    //   285: invokevirtual 522	com/tencent/qqmini/sdk/launcher/core/model/ApkgInfo:readApkgToString	(Ljava/lang/String;)Ljava/lang/String;
    //   288: astore 6
    //   290: goto -81 -> 209
    //   293: astore_1
    //   294: ldc 33
    //   296: ldc_w 308
    //   299: aload_1
    //   300: invokestatic 306	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   303: iconst_0
    //   304: istore_3
    //   305: goto +3 -> 308
    //   308: iload_3
    //   309: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	AppBrandPageContainer
    //   0	310	1	paramString	String
    //   106	58	2	i	int
    //   17	292	3	bool1	boolean
    //   1	107	4	bool2	boolean
    //   13	186	5	bool3	boolean
    //   26	263	6	localObject	Object
    //   32	122	7	str1	String
    //   167	90	7	localThrowable	Throwable
    //   174	110	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   28	34	167	java/lang/Throwable
    //   43	63	167	java/lang/Throwable
    //   70	77	167	java/lang/Throwable
    //   81	91	167	java/lang/Throwable
    //   95	105	167	java/lang/Throwable
    //   118	143	167	java/lang/Throwable
    //   149	159	167	java/lang/Throwable
    //   169	176	293	java/lang/Throwable
    //   181	198	293	java/lang/Throwable
    //   203	209	293	java/lang/Throwable
    //   209	261	293	java/lang/Throwable
    //   266	276	293	java/lang/Throwable
    //   279	290	293	java/lang/Throwable
  }
  
  private boolean isMonitorViewShowing()
  {
    return (this.mMiniAppMonitorInfoView != null) && (this.mMiniAppMonitorInfoView.getVisibility() == 0);
  }
  
  private boolean isSubFileCacheValid(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    bool1 = bool2;
    if (this.mApkgInfo != null) {
      try
      {
        String str = this.mApkgInfo.getRootPath(paramString1);
        bool1 = bool2;
        if (!TextUtils.isEmpty(str))
        {
          str = new File(com.tencent.qqmini.sdk.launcher.core.model.ApkgManager.getApkgFolderPath(this.mMiniAppInfo), str).getAbsolutePath();
          if (TextUtils.isEmpty(str)) {
            return true;
          }
          if (this.mMiniAppInfo.launchParam.isFlutterMode) {}
          for (paramString1 = FileUtils.readFileToStr(new File(str + File.separator + paramString2));; paramString1 = this.mApkgInfo.readApkgToString(paramString1))
          {
            bool1 = bool2;
            if (TextUtils.isEmpty(paramString1)) {
              break;
            }
            bool1 = bool2;
            if (!paramString1.contains(new String(new byte[20]))) {
              break;
            }
            QMLog.e("minisdk-start-AppBrandPageContainer", paramString2 + " file invalid! ");
            return false;
          }
        }
        return bool1;
      }
      catch (Throwable paramString1)
      {
        QMLog.e("minisdk-start-AppBrandPageContainer", "", paramString1);
        bool1 = false;
      }
    }
  }
  
  private boolean isUrlLocalFileValid(String paramString)
  {
    return (isIndexHtmlValid(paramString)) && (isSubFileCacheValid(paramString, "app-service.js")) && (isSubFileCacheValid(paramString, "page-frame.js"));
  }
  
  private boolean isUrlReady(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mApkgInfo != null)
    {
      bool1 = bool2;
      if (this.mApkgInfo.isUrlResReady(paramString, this.mContext.getMiniAppInfo()))
      {
        bool1 = bool2;
        if (this.mApkgInfo.isUrlFileExist(paramString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void reportKeyValue(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    for (;;)
    {
      int i;
      Object localObject;
      int j;
      long l;
      try
      {
        MiniAppInfo localMiniAppInfo = this.mContext.getMiniAppInfo();
        JSONArray localJSONArray = new JSONObject(paramNativeViewRequestEvent.jsonParams).getJSONArray("dataArray");
        i = 0;
        if (i < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(i);
          j = ((JSONObject)localObject).getInt("key");
          if (15496 == j)
          {
            localObject = ((JSONObject)localObject).getString("value").split(",");
            if ((localObject.length > 8) && (!localObject[0].equals("2")))
            {
              j = Integer.parseInt(localObject[7]);
              if (j > 0)
              {
                QMLog.e("minisdk-start-AppBrandPageContainer", paramNativeViewRequestEvent.event + " REPORT_EVENT_DISPLAY: " + j);
                MiniReportManager.reportEventType(localMiniAppInfo, 638, null, null, null, 0, "0", j, null);
              }
            }
          }
          else if (13544 == j)
          {
            localObject = ((JSONObject)localObject).getString("value").split(",");
            j = Integer.parseInt(localObject[0]);
            if ((9 != j) && (6 != j)) {
              break label416;
            }
            l = Long.parseLong(localObject[1]);
            l = Long.parseLong(localObject[4]) - l;
            if (l <= 0L) {
              break label416;
            }
            QMLog.e("minisdk-start-AppBrandPageContainer", paramNativeViewRequestEvent.event + " REPORT_EVENT_SPEED: " + l);
            if (9 == j) {
              MiniReportManager.reportEventType(localMiniAppInfo, 636, null, null, null, 0, "0", l, null);
            }
          }
        }
      }
      catch (Exception localException1)
      {
        QMLog.e("minisdk-start-AppBrandPageContainer", paramNativeViewRequestEvent.event + " error.", localException1);
      }
      return;
      MiniReportManager.reportEventType(localException1, 637, null, null, null, 0, "0", l, null);
      break label416;
      if (13582 == j)
      {
        localObject = ((JSONObject)localObject).getString("value");
        try
        {
          MiniReportManager.reportJsError(localException1, getCurrentPageUrl(), (String)localObject);
        }
        catch (Exception localException2)
        {
          QMLog.e("minisdk-start-AppBrandPageContainer", paramNativeViewRequestEvent.event + " REPORT_EVENT_JS_EXCEPTION: failed:", localException2);
        }
      }
      label416:
      i += 1;
    }
  }
  
  private void sendBackGroundToJs()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("scene", this.mMiniAppInfo.launchParam.scene);
      localJSONObject.put("appId", this.mContext.getMiniAppInfo().appId);
      if (this.mEventListener != null) {
        this.mEventListener.onWebViewEvent("onAppEnterBackground", localJSONObject.toString(), 0);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        QMLog.w("minisdk-start-AppBrandPageContainer", "onPause,paramsObj", localJSONException);
      }
    }
  }
  
  private void sendForegroundToJs()
  {
    Object localObject1;
    boolean bool1;
    if ((this.mFromReload) && (this.mEventListener != null) && (this.mEventListener.isFirstDomReady()) && (!TextUtils.isEmpty(this.mMiniAppInfo.launchParam.entryPath)))
    {
      localObject1 = this.mMiniAppInfo.launchParam.entryPath;
      this.mFromReload = false;
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2 = ((Boolean)this.mContext.performAction(new AppBrandPageContainer.3(this))).booleanValue();
      if ((this.mEventListener != null) && ((this.mEventListener.isFirstDomReady()) || (bool2)))
      {
        Object localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (getShowingPage() != null) {
            localObject2 = getShowingPage().getCurShowingUrl();
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = AppBrandUtil.getAppLaunchInfo((String)localObject2, this.mMiniAppInfo);
        }
      }
      try
      {
        ((JSONObject)localObject1).put("reLaunch", bool1);
        QMLog.i("minisdk-start-AppBrandPageContainer", "appLaunchInfo : " + ((JSONObject)localObject1).toString());
        this.mEventListener.onWebViewEvent("onAppEnterForeground", ((JSONObject)localObject1).toString(), 0);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QMLog.e("minisdk-start-AppBrandPageContainer", "appLaunchInfo error.", localThrowable);
        }
      }
      bool1 = false;
      localObject1 = null;
    }
  }
  
  private void sendPageNotFoundEvent(String paramString)
  {
    for (boolean bool = false;; bool = true) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("path", paramString);
        localJSONObject.put("query", AppBrandUtil.getQueryJson(paramString));
        if ((this.appBrandPages != null) && (this.appBrandPages.size() > 0))
        {
          localJSONObject.put("isEntryPage", bool);
          QMLog.e("minisdk-start-AppBrandPageContainer", "onPageNotFound : " + localJSONObject.toString());
          this.mContext.performAction(ServiceSubscribeEvent.obtain("onPageNotFound", localJSONObject.toString(), 0));
          return;
        }
      }
      catch (JSONException paramString)
      {
        QMLog.e("minisdk-start-AppBrandPageContainer", "onPageNotFound error", paramString);
        return;
      }
    }
  }
  
  public boolean addCoverView(int paramInt1, int paramInt2, CoverView paramCoverView, boolean paramBoolean)
  {
    NativeViewContainer localNativeViewContainer = getNativeViewContainer();
    if (localNativeViewContainer != null) {
      return localNativeViewContainer.addCoverView(paramInt1, paramInt2, paramCoverView, paramBoolean);
    }
    return false;
  }
  
  public boolean addNativeView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramView == null) {}
    NativeViewContainer localNativeViewContainer;
    do
    {
      return false;
      localNativeViewContainer = getNativeViewContainer();
    } while (localNativeViewContainer == null);
    if (paramLayoutParams != null) {
      localNativeViewContainer.addView(paramView, paramLayoutParams);
    }
    for (;;)
    {
      return true;
      localNativeViewContainer.addView(paramView);
    }
  }
  
  public void cleanup(boolean paramBoolean)
  {
    Iterator localIterator = this.appBrandPages.iterator();
    while (localIterator.hasNext())
    {
      AppBrandPage localAppBrandPage = (AppBrandPage)localIterator.next();
      if ((localAppBrandPage != null) && ((!paramBoolean) || (this.mApkgInfo == null) || (!this.mApkgInfo.isTabBarPage(localAppBrandPage.getCurShowingUrl()))))
      {
        localAppBrandPage.onPause();
        localAppBrandPage.cleanUp();
        removeView(localAppBrandPage);
        localIterator.remove();
      }
    }
  }
  
  public String dispatchEventToNativeView(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramNativeViewRequestEvent.dispatchTarget == 3) {
      localObject1 = handlePageEvent(paramNativeViewRequestEvent);
    }
    Object localObject3;
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject1;
            localObject3 = getShowingPage();
            localObject1 = localObject2;
          } while (localObject3 == null);
          if (paramNativeViewRequestEvent.dispatchTarget == 0) {
            return ((AppBrandPage)localObject3).handleNativeUIEvent(paramNativeViewRequestEvent);
          }
          localObject3 = ((AppBrandPage)localObject3).getPageWebviewContainer();
          localObject1 = localObject2;
        } while (localObject3 == null);
        if (paramNativeViewRequestEvent.dispatchTarget == 1) {
          return ((PageWebviewContainer)localObject3).handleNativeUIEvent(paramNativeViewRequestEvent);
        }
        localObject3 = ((PageWebviewContainer)localObject3).getNativeViewContainer();
        localObject1 = localObject2;
      } while (localObject3 == null);
      localObject1 = localObject2;
    } while (paramNativeViewRequestEvent.dispatchTarget != 2);
    return ((NativeViewContainer)localObject3).handleNativeUIEvent(paramNativeViewRequestEvent);
  }
  
  public void dispatchEventToWebView(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      paramArrayOfInt = this.appBrandPages.iterator();
    }
    while (paramArrayOfInt.hasNext())
    {
      Object localObject = (AppBrandPage)paramArrayOfInt.next();
      if ((localObject != null) && (((AppBrandPage)localObject).getBrandPageWebview() != null))
      {
        ((AppBrandPage)localObject).getBrandPageWebview().evaluateSubscribeJSInService(paramString1, paramString2, ((AppBrandPage)localObject).getPageWebviewId());
        continue;
        int j = paramArrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          int k = paramArrayOfInt[i];
          localObject = this.appBrandPages.iterator();
          while (((Iterator)localObject).hasNext())
          {
            AppBrandPage localAppBrandPage = (AppBrandPage)((Iterator)localObject).next();
            if ((localAppBrandPage.getBrandPageWebview() != null) && (k == localAppBrandPage.getPageWebviewId())) {
              localAppBrandPage.getBrandPageWebview().evaluateSubscribeJSInService(paramString1, paramString2, k);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    try
    {
      getShowingPage().getBrandPageWebview().doDispatchKeyEvent(paramKeyEvent);
      return false;
    }
    catch (Throwable paramKeyEvent)
    {
      for (;;)
      {
        QMLog.e("minisdk-start-AppBrandPageContainer", "doDispatchKeyEvent error,", paramKeyEvent);
      }
    }
  }
  
  public AppBrandPagePool getAppBrandPagePool()
  {
    return this.mAppBrandPagePool;
  }
  
  public CapsuleButton getCapsuleButton()
  {
    AppBrandPage localAppBrandPage = getShowingPage();
    if (localAppBrandPage != null) {
      return localAppBrandPage.getCapsuleButton();
    }
    return null;
  }
  
  public View getContentView()
  {
    return this;
  }
  
  public CoverView getCoverView(int paramInt)
  {
    NativeViewContainer localNativeViewContainer = getNativeViewContainer();
    if (localNativeViewContainer != null) {
      return localNativeViewContainer.getCoverView(paramInt);
    }
    return null;
  }
  
  public int getCurShowingInputId()
  {
    return this.curShowingInputId;
  }
  
  public String getCurrentPageUrl()
  {
    if (getShowingPage() != null) {
      return getShowingPage().getCurShowingUrl();
    }
    return "";
  }
  
  public EmbeddedWidgetClientFactory getCurrentX5EmbeddedWidgetClientFactory()
  {
    AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)this.appBrandPages.peek();
    if ((localAbsAppBrandPage != null) && (localAbsAppBrandPage.getCurrentPageWebview() != null)) {
      return localAbsAppBrandPage.getCurrentPageWebview().getEmbeddedWidgetClientFactory();
    }
    return null;
  }
  
  public CoverView.JsRuntimeListener getJsRuntimeListener()
  {
    return getPageWebviewContainer();
  }
  
  public String getNaviBarStyle()
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getNavBar();
      if (localObject != null) {
        return ((NavigationBar)localObject).getNavbarStyle();
      }
      return "default";
    }
    return "default";
  }
  
  public int getNaviBarTextStyle()
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getNavBar();
      if (localObject != null) {
        return ((NavigationBar)localObject).getStatusNavigationBarTextStyle();
      }
      return -1;
    }
    return -1;
  }
  
  public int getNaviBarVisibility()
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getNavBar();
      if (localObject != null) {
        return ((NavigationBar)localObject).getVisibility();
      }
      return 8;
    }
    return 8;
  }
  
  public int getPageCount()
  {
    if (this.appBrandPages != null) {
      return this.appBrandPages.size();
    }
    return 0;
  }
  
  public AppPageInfo getPageInfo(int paramInt)
  {
    AppPageInfo.Builder localBuilder = new AppPageInfo.Builder();
    Object localObject = (AbsAppBrandPage)this.appBrandPages.peek();
    if ((AppPageInfo.enableGetPageId(paramInt)) && (localObject != null) && (((AbsAppBrandPage)localObject).getCurrentPageWebview() != null)) {
      localBuilder.setPageId(((AbsAppBrandPage)localObject).getCurrentPageWebview().getPageWebViewId());
    }
    if (AppPageInfo.enableGetPageUrl(paramInt)) {
      if (localObject == null) {
        break label114;
      }
    }
    label114:
    for (localObject = ((AbsAppBrandPage)localObject).getCurShowingUrl();; localObject = null)
    {
      localBuilder.setPageUrl((String)localObject);
      if (AppPageInfo.enableGetPageWindowWidth(paramInt)) {
        localBuilder.setWindowWidth(getPageWebviewContainer().getWidth());
      }
      if (AppPageInfo.enableGetPageWindowHeight(paramInt)) {
        localBuilder.setWindowHeight(getPageWebviewContainer().getHeight());
      }
      return localBuilder.build();
    }
  }
  
  public String getPageOrientation()
  {
    PageWebviewContainer localPageWebviewContainer = getPageWebviewContainer();
    if (localPageWebviewContainer != null) {
      return localPageWebviewContainer.getPageOrientation();
    }
    return "";
  }
  
  public AppBrandPage getShowingPage()
  {
    if (getPageCount() > 0) {
      return (AppBrandPage)this.appBrandPages.peek();
    }
    return null;
  }
  
  public int getShowingPageWebViewId()
  {
    if ((this.appBrandPages != null) && (this.appBrandPages.peek() != null)) {
      return ((AppBrandPage)this.appBrandPages.peek()).getPageWebviewId();
    }
    return -1;
  }
  
  public int getTabBarVisibility()
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getTabBar();
      if (localObject != null) {
        return ((TabBar)localObject).getVisibility();
      }
      return 8;
    }
    return 8;
  }
  
  public void hideSoftInput(View paramView)
  {
    if (paramView != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramView.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
    }
  }
  
  public void init(Object paramObject)
  {
    if (this.mAppBrandPagePool != null) {
      this.mAppBrandPagePool.preLoadAppBrandPage(this.mContext, this);
    }
  }
  
  public void initBaseJs(BaselibLoader.BaselibContent paramBaselibContent)
  {
    if (this.mAppBrandPagePool != null) {
      this.mAppBrandPagePool.initBaseJs(this, paramBaselibContent);
    }
  }
  
  public boolean isCurrentTabBarPage()
  {
    AppBrandPage localAppBrandPage = getShowingPage();
    if (localAppBrandPage != null) {
      return localAppBrandPage.isTabBarPage();
    }
    return false;
  }
  
  public void launch(String paramString1, String paramString2)
  {
    QMLog.i("minisdk-start-AppBrandPageContainer", "launch url : " + paramString1 + "; type : " + paramString2);
    if ((!isUrlReady(paramString1)) || (!isUrlLocalFileValid(paramString1)))
    {
      executeDownSubPackage(paramString1, paramString2);
      return;
    }
    AppBrandPage localAppBrandPage = this.mAppBrandPagePool.getAppBrandPage(this.mContext, this);
    this.appBrandPages.push(localAppBrandPage);
    localAppBrandPage.loadUrl(paramString1, paramString2, this.mEventListener);
    addView(localAppBrandPage, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public boolean navigateBack(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    QMLog.i("minisdk-start-AppBrandPageContainer", "navigateBack delta : " + paramInt1);
    Object localObject = getShowingPage();
    boolean bool1;
    if ((localObject != null) && (((AppBrandPage)localObject).handleBackPressed())) {
      bool1 = true;
    }
    int i;
    do
    {
      do
      {
        return bool1;
        i = getPageCount();
        bool1 = bool2;
      } while (i < 2);
      bool1 = bool2;
    } while (paramInt1 < 1);
    paramInt2 = paramInt1;
    if (paramInt1 >= i) {
      paramInt2 = i - 1;
    }
    localObject = this.appBrandPages.iterator();
    paramInt1 = 0;
    for (;;)
    {
      if ((paramInt1 >= paramInt2) || (this.appBrandPages.size() < 1))
      {
        hideSoftInput(this);
        localObject = (AppBrandPage)this.appBrandPages.peek();
        if (localObject != null)
        {
          ((AppBrandPage)localObject).onResume(true);
          if ((this.mContext != null) && (this.mContext.getAttachedActivity() != null) && (!this.mContext.getAttachedActivity().isFinishing())) {
            ((AppBrandPage)localObject).updateWidowInfo(this.mContext.getAttachedActivity());
          }
          this.mEventListener.onWebViewReady("navigateBack", ((AppBrandPage)localObject).getCurShowingUrl(), ((AppBrandPage)localObject).getPageWebviewId());
        }
        return true;
      }
      if (((Iterator)localObject).hasNext())
      {
        AppBrandPage localAppBrandPage = (AppBrandPage)((Iterator)localObject).next();
        if (localAppBrandPage != null)
        {
          Animation localAnimation = AnimationUtils.loadAnimation(AppLoaderFactory.g().getContext(), R.anim.mini_sdk_page_slide_out_to_right);
          localAnimation.setDuration(200L);
          localAnimation.setAnimationListener(new AppBrandPageContainer.2(this, localAppBrandPage));
          localAppBrandPage.startAnimation(localAnimation);
          localAppBrandPage.onPause();
          ((Iterator)localObject).remove();
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void navigateTo(String paramString, int paramInt)
  {
    QMLog.i("minisdk-start-AppBrandPageContainer", "navigateTo url : " + paramString);
    if (this.aliveWebViewCount > 10)
    {
      Toast.makeText(getContext(), "打开页面超过上限，请返回", 0).show();
      QMLog.e("minisdk-start-AppBrandPageContainer", "打开WebView数量超过上限");
      return;
    }
    if ((!isUrlReady(paramString)) || (!isUrlLocalFileValid(paramString)))
    {
      executeDownSubPackage(paramString, "navigateTo");
      return;
    }
    AppBrandPage localAppBrandPage = (AppBrandPage)this.appBrandPages.peek();
    if (localAppBrandPage != null) {
      localAppBrandPage.onPause();
    }
    localAppBrandPage = this.mAppBrandPagePool.getAppBrandPage(this.mContext, this);
    this.appBrandPages.push(localAppBrandPage);
    localAppBrandPage.loadUrl(paramString, "navigateTo", this.mEventListener);
    if (!localAppBrandPage.isHomePage()) {
      localAppBrandPage.setVisibility(4);
    }
    addView(localAppBrandPage, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void notifyOnAddColorNote()
  {
    NativeViewContainer localNativeViewContainer = getNativeViewContainer();
    if (localNativeViewContainer != null) {
      localNativeViewContainer.notifyOnColorNoteAnimStart();
    }
  }
  
  public void notifyOnPageWebViewDestory()
  {
    NativeViewContainer localNativeViewContainer = getNativeViewContainer();
    if (localNativeViewContainer != null) {
      localNativeViewContainer.notifyOnPageWebViewDestory();
    }
  }
  
  public void notifyOnPageWebViewPause()
  {
    NativeViewContainer localNativeViewContainer = getNativeViewContainer();
    if (localNativeViewContainer != null) {
      localNativeViewContainer.notifyOnPageWebViewPause();
    }
  }
  
  public void notifyOnPageWebViewResume()
  {
    NativeViewContainer localNativeViewContainer = getNativeViewContainer();
    if (localNativeViewContainer != null) {
      localNativeViewContainer.notifyOnPageWebViewResume();
    }
  }
  
  public void onAttachedToActivity(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    initMonitor();
    AppBrandPage localAppBrandPage = (AppBrandPage)this.appBrandPages.peek();
    if (localAppBrandPage != null) {
      localAppBrandPage.updateWidowInfo(paramActivity);
    }
  }
  
  public void onDestroy()
  {
    if (this.mAppBrandPagePool != null)
    {
      this.mAppBrandPagePool.destroyCachePage();
      this.mAppBrandPagePool = null;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.mBroadcastReceiver != null) && (this.mActivity != null))
    {
      this.mActivity.unregisterReceiver(this.mBroadcastReceiver);
      this.mBroadcastReceiver = null;
    }
  }
  
  public void onPause()
  {
    if (this.mMiniAppInfo == null) {
      return;
    }
    AppBrandPage localAppBrandPage = (AppBrandPage)this.appBrandPages.peek();
    if (localAppBrandPage != null) {
      localAppBrandPage.onPause();
    }
    sendBackGroundToJs();
  }
  
  public void onResume()
  {
    sendForegroundToJs();
    AppBrandPage localAppBrandPage = (AppBrandPage)this.appBrandPages.peek();
    if (localAppBrandPage != null) {
      localAppBrandPage.onResume(false);
    }
  }
  
  public void onStop() {}
  
  public void onTabItemClick(int paramInt, String paramString1, String paramString2)
  {
    switchTab(paramString1);
    handleOnTabItemTap(paramInt, paramString1, paramString2);
  }
  
  public boolean operateCustomButton(String paramString, long paramLong, JSONObject paramJSONObject, View.OnClickListener paramOnClickListener)
  {
    return false;
  }
  
  public boolean operateFloatDragAd(String paramString, FloatDragAdInfo paramFloatDragAdInfo)
  {
    return false;
  }
  
  public void recyclePreLoadAppBrandPage()
  {
    if (this.mAppBrandPagePool != null) {
      this.mAppBrandPagePool.destroyPageWebviewCache();
    }
  }
  
  public void redirectTo(String paramString, int paramInt)
  {
    QMLog.i("minisdk-start-AppBrandPageContainer", "redirectTo url : " + paramString);
    if ((!isUrlReady(paramString)) || (!isUrlLocalFileValid(paramString)))
    {
      executeDownSubPackage(paramString, "redirectTo");
      return;
    }
    if ((this.appBrandPages != null) && (this.appBrandPages.size() > 0))
    {
      localAppBrandPage = (AppBrandPage)this.appBrandPages.poll();
      if (localAppBrandPage != null)
      {
        localAppBrandPage.onPause();
        localAppBrandPage.cleanUp();
        removeView(localAppBrandPage);
      }
    }
    AppBrandPage localAppBrandPage = this.mAppBrandPagePool.getAppBrandPage(this.mContext, this);
    this.appBrandPages.push(localAppBrandPage);
    localAppBrandPage.loadUrl(paramString, "redirectTo", this.mEventListener);
    if (!localAppBrandPage.isHomePage()) {
      localAppBrandPage.setVisibility(4);
    }
    addView(localAppBrandPage, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public boolean removeCoverView(int paramInt)
  {
    NativeViewContainer localNativeViewContainer = getNativeViewContainer();
    if (localNativeViewContainer != null) {
      return localNativeViewContainer.removeCoverView(paramInt);
    }
    return false;
  }
  
  public boolean removeNativeView(View paramView)
  {
    if (paramView == null) {}
    NativeViewContainer localNativeViewContainer;
    do
    {
      return false;
      localNativeViewContainer = getNativeViewContainer();
    } while (localNativeViewContainer == null);
    localNativeViewContainer.removeView(paramView);
    return true;
  }
  
  public void removeSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    if ((paramSoftKeyboardStateListener == null) || (this.mSoftKeyboardStateListenerList == null)) {
      return;
    }
    this.mSoftKeyboardStateListenerList.remove(paramSoftKeyboardStateListener);
  }
  
  public void resetCurShowingInputId()
  {
    this.curShowingInputId = -1;
  }
  
  public void setCurShowingInputId(int paramInt)
  {
    this.curShowingInputId = paramInt;
  }
  
  public void setFromReload(boolean paramBoolean)
  {
    this.mFromReload = paramBoolean;
  }
  
  public boolean setMiniAIOEntranceVisible(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppBrandPage localAppBrandPage = getShowingPage();
    if (localAppBrandPage == null) {
      return false;
    }
    if (paramBoolean) {
      return localAppBrandPage.showMiniAIOEntrance(paramJSONObject);
    }
    localAppBrandPage.hideMiniAIOEntrance();
    return true;
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.mMiniAppInfo = paramMiniAppInfo;
    this.mApkgInfo = ((ApkgInfo)paramMiniAppInfo.apkgInfo);
  }
  
  public void setNaviBarStyle(String paramString)
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getNavBar();
      if (localObject != null) {
        ((NavigationBar)localObject).setBarStyle(paramString);
      }
    }
  }
  
  public void setNaviVisibility(int paramInt)
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getNavBar();
      if (localObject != null) {
        ((NavigationBar)localObject).setVisibility(paramInt);
      }
    }
  }
  
  public void setSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    if (paramSoftKeyboardStateListener == null) {
      return;
    }
    if (this.mSoftKeyboardStateListenerList == null) {
      this.mSoftKeyboardStateListenerList = new ArrayList();
    }
    this.mSoftKeyboardStateListenerList.add(paramSoftKeyboardStateListener);
  }
  
  public void setTabBarVisibility(int paramInt)
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getTabBar();
      if (localObject != null) {
        ((TabBar)localObject).setVisibility(paramInt);
      }
    }
  }
  
  public void showSoftInput(View paramView)
  {
    if (paramView != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramView.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.showSoftInput(paramView, 0);
      }
    }
  }
  
  public void switchTab(String paramString)
  {
    QMLog.i("minisdk-start-AppBrandPageContainer", "switchTab url : " + paramString);
    cleanup(true);
    AppBrandPage localAppBrandPage = getBrandPage();
    this.appBrandPages.push(localAppBrandPage);
    localAppBrandPage.loadUrl(paramString, "switchTab", this.mEventListener);
  }
  
  public boolean toggleDebugPanel()
  {
    MiniAppInfo localMiniAppInfo;
    if (this.mContext != null)
    {
      localMiniAppInfo = this.mContext.getMiniAppInfo();
      if (DebugUtil.getDebugEnabled(localMiniAppInfo)) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      DebugUtil.setDebugEnabled(localMiniAppInfo, bool);
      return bool;
      localMiniAppInfo = null;
      break;
    }
  }
  
  public boolean toggleMonitorPanel()
  {
    Activity localActivity = this.mContext.getAttachedActivity();
    if (localActivity != null)
    {
      if (this.mMiniAppMonitorInfoView != null) {
        break label82;
      }
      this.mMiniAppMonitorInfoView = new MiniAppMonitorInfoView(localActivity, null, 0);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 53;
      localActivity.addContentView(this.mMiniAppMonitorInfoView, localLayoutParams);
      this.mMiniAppMonitorInfoView.setVisibility(0);
      this.mMiniAppMonitorInfoView.startRefreshMonitorUi();
    }
    for (;;)
    {
      return isMonitorViewShowing();
      label82:
      if (this.mMiniAppMonitorInfoView.getVisibility() == 0)
      {
        this.mMiniAppMonitorInfoView.stopRefreshMonitorUi();
        this.mMiniAppMonitorInfoView.setVisibility(8);
      }
      else
      {
        this.mMiniAppMonitorInfoView.startRefreshMonitorUi();
        this.mMiniAppMonitorInfoView.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer
 * JD-Core Version:    0.7.0.1
 */