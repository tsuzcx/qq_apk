package com.tencent.qqmini.miniapp.core.page;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
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
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
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
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.manager.ApkgManager.OnInitApkgListener;
import com.tencent.qqmini.sdk.monitor.ui.MiniAppMonitorInfoView;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.ViewUtils;
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
import java.util.concurrent.ConcurrentLinkedQueue;
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
  public static final int MAX_LAST_CLICK_COUNT = 10;
  public static final String ON_APP_ENTER_BACKGROUND = "onAppEnterBackground";
  public static final String ON_APP_ENTER_FOREGROUND = "onAppEnterForeground";
  public static final String ON_KEYBOARD_HEIGHT_CHANGE = "onKeyboardHeightChange";
  private static final String TAG = "minisdk-start-AppBrandPageContainer";
  public int aliveWebViewCount = 0;
  private LinkedList<AppBrandPage> appBrandPages = new LinkedList();
  private int curShowingInputId = -1;
  private ConcurrentLinkedQueue<AppBrandPageContainer.ClickPoint> lastClicks = new ConcurrentLinkedQueue();
  private long lastTouchDownTimeStamp;
  private int lastTouchDownX;
  private int lastTouchDownY;
  private int lastTouchUpX;
  private int lastTouchUpY;
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
  private ConcurrentLinkedQueue<AppBrandPage> redirectOldPages = new ConcurrentLinkedQueue();
  
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
    Object localObject = this.mActivity;
    if (localObject != null) {
      localObject = new ToastView((Context)localObject, this);
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((ToastView)localObject).show(1, "loading", null, "正在加载模块...", -1, true);
    }
    com.tencent.qqmini.sdk.manager.ApkgManager.getInstance().downloadSubPack(this.mApkgInfo, this.mContext.getMiniAppInfo(), paramString1, getOnInitApkgListener(paramString1, paramString2, localWeakReference, (ToastView)localObject));
  }
  
  private AppBrandPage getBrandPage()
  {
    Object localObject1 = this.appBrandPages;
    if ((localObject1 != null) && (((LinkedList)localObject1).size() > 0))
    {
      localObject2 = (AppBrandPage)this.appBrandPages.poll();
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        ((AppBrandPage)localObject2).onPause();
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = this.mAppBrandPagePool.getAppBrandPage(this.mContext, this);
      addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
    }
    return localObject2;
  }
  
  private String getMenuButtonBoundingClientRect(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    Object localObject1 = getCapsuleButton();
    if (localObject1 != null)
    {
      int i = (int)(((View)localObject1).getWidth() / DisplayUtil.getDensity(this.mActivity));
      int j = (int)(((View)localObject1).getHeight() / DisplayUtil.getDensity(this.mActivity));
      int k = (int)(((View)localObject1).getLeft() / DisplayUtil.getDensity(this.mActivity));
      int m = (int)(((View)localObject1).getTop() / DisplayUtil.getDensity(this.mActivity));
      int n = (int)(((View)localObject1).getRight() / DisplayUtil.getDensity(this.mActivity));
      int i1 = (int)(((View)localObject1).getBottom() / DisplayUtil.getDensity(this.mActivity));
      localObject1 = new Rect(267, 34, 347, 64);
      if (i != 0)
      {
        localObject1 = new Rect(k, m, n, i1);
      }
      else
      {
        i = 80;
        j = 30;
      }
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("width", i);
        ((JSONObject)localObject2).put("height", j);
        ((JSONObject)localObject2).put("top", ((Rect)localObject1).top);
        ((JSONObject)localObject2).put("right", ((Rect)localObject1).right);
        ((JSONObject)localObject2).put("bottom", ((Rect)localObject1).bottom);
        ((JSONObject)localObject2).put("left", ((Rect)localObject1).left);
        paramNativeViewRequestEvent.ok();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getMenuButtonBoundingClientRect : ");
        ((StringBuilder)localObject1).append(((JSONObject)localObject2).toString());
        QMLog.d("minisdk-start-AppBrandPageContainer", ((StringBuilder)localObject1).toString());
        localObject1 = ((JSONObject)localObject2).toString();
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramNativeViewRequestEvent.event);
        ((StringBuilder)localObject2).append(" error.");
        QMLog.e("minisdk-start-AppBrandPageContainer", ((StringBuilder)localObject2).toString(), localJSONException);
        return "";
      }
    }
    QMLog.e("minisdk-start-AppBrandPageContainer", "EVENT_GET_MENU_BUTTON_RECT view is null.");
    paramNativeViewRequestEvent.fail();
    return getMenuButtonDefaultValue();
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMenuButtonDefaultValue : ");
      localStringBuilder.append(((JSONObject)localObject).toString());
      QMLog.d("minisdk-start-AppBrandPageContainer", localStringBuilder.toString());
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
  
  private ApkgManager.OnInitApkgListener getOnInitApkgListener(String paramString1, String paramString2, WeakReference<AppBrandPageContainer> paramWeakReference, ToastView paramToastView)
  {
    return new AppBrandPageContainer.6(this, paramToastView, paramString1, paramWeakReference, paramString2);
  }
  
  private AppBrandPage getPageByWebviewId(int paramInt)
  {
    Object localObject = this.appBrandPages;
    if (localObject == null)
    {
      if (((LinkedList)localObject).size() <= 0) {
        return null;
      }
      int i = 0;
      while (i < this.appBrandPages.size())
      {
        localObject = (AppBrandPage)this.appBrandPages.get(i);
        if ((localObject != null) && (((AppBrandPage)localObject).getPageWebviewId() == paramInt)) {
          return localObject;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private PageWebviewContainer getPageWebviewContainer()
  {
    AppBrandPage localAppBrandPage = getShowingPage();
    if (localAppBrandPage == null) {
      return null;
    }
    return localAppBrandPage.getPageWebviewContainer();
  }
  
  private void handleEventSetBackgroundColor(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new AppBrandPageContainer.8(this, paramNativeViewRequestEvent));
  }
  
  private void handleEventSetBackgroundTextStyle(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new AppBrandPageContainer.9(this, paramNativeViewRequestEvent));
  }
  
  private void handleEventSetEnableDebug(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      boolean bool = new JSONObject(paramNativeViewRequestEvent.jsonParams).optBoolean("enableDebug");
      SharedPreferences localSharedPreferences = StorageUtil.getPreference();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mContext.getMiniAppInfo().appId);
      localStringBuilder.append("_debug");
      if (bool != Boolean.valueOf(localSharedPreferences.getBoolean(localStringBuilder.toString(), false)).booleanValue())
      {
        this.mContext.getAttachedActivity().runOnUiThread(new AppBrandPageContainer.7(this, bool));
        return;
      }
      paramNativeViewRequestEvent.ok();
      return;
    }
    catch (JSONException localJSONException)
    {
      label108:
      break label108;
    }
    paramNativeViewRequestEvent.fail();
  }
  
  private void handleInitApkgResultSuc(ApkgInfo paramApkgInfo, String paramString1, WeakReference<AppBrandPageContainer> paramWeakReference, String paramString2)
  {
    if ((paramApkgInfo != null) && (paramApkgInfo.isUrlFileExist(paramString1)))
    {
      paramApkgInfo = (AppBrandPageContainer)paramWeakReference.get();
      if (paramApkgInfo != null)
      {
        if ("navigateTo".equals(paramString2))
        {
          paramApkgInfo.navigateTo(paramString1, -1);
          return;
        }
        if ("redirectTo".equals(paramString2))
        {
          paramApkgInfo.redirectTo(paramString1, -1);
          return;
        }
        if ("appLaunch".equals(paramString2))
        {
          paramApkgInfo.launch(paramString1, "appLaunch");
          return;
        }
        if ("reLaunch".equals(paramString2)) {
          paramApkgInfo.launch(paramString1, "reLaunch");
        }
      }
    }
    else
    {
      sendPageNotFoundEvent(paramString1);
      paramString2 = new StringBuilder();
      paramString2.append("Page not found.");
      paramString2.append(paramString1);
      QMLog.e("minisdk-start-AppBrandPageContainer", paramString2.toString());
      if ((paramApkgInfo != null) && (paramApkgInfo.mAppConfigInfo != null))
      {
        paramString1 = paramApkgInfo.mAppConfigInfo.entryPagePath;
        if (isUrlFileExist(paramApkgInfo, paramString1))
        {
          ((AppBrandPageContainer)paramWeakReference.get()).launch(paramString1, "appLaunch");
          return;
        }
        if (isActivityValid()) {
          this.mContext.getAttachedActivity().moveTaskToBack(false);
        }
      }
    }
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
      handleEventSetEnableDebug(paramNativeViewRequestEvent);
    }
    else if ("setBackgroundTextStyle".equals(paramNativeViewRequestEvent.event))
    {
      handleEventSetBackgroundTextStyle(paramNativeViewRequestEvent);
    }
    else if ("setBackgroundColor".equals(paramNativeViewRequestEvent.event))
    {
      handleEventSetBackgroundColor(paramNativeViewRequestEvent);
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
  
  private void initNetwork()
  {
    MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
    if ((localMiniAppInfo != null) && (localMiniAppInfo.apkgInfo != null) && ((this.mMiniAppInfo.apkgInfo instanceof ApkgInfo))) {
      ApkgInfo.initNetwork((ApkgInfo)this.mMiniAppInfo.apkgInfo);
    }
  }
  
  private boolean isActivityValid()
  {
    IMiniAppContext localIMiniAppContext = this.mContext;
    return (localIMiniAppContext != null) && (localIMiniAppContext.getAttachedActivity() != null) && (!this.mContext.getAttachedActivity().isFinishing());
  }
  
  private boolean isIndexHtmlValid(String paramString)
  {
    boolean bool3 = this.mMiniAppInfo.launchParam.isFlutterMode;
    Object localObject1 = this.mApkgInfo;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localObject1 != null) {
      localObject1 = paramString;
    }
    for (;;)
    {
      try
      {
        String str = AppBrandUtil.getUrlWithoutParams(paramString);
        if (bool3)
        {
          localObject1 = str;
          paramString = FileUtils.readFileToStr(new File(this.mApkgInfo.getChildFileAbsolutePath(str)));
        }
        else
        {
          localObject1 = str;
          paramString = this.mApkgInfo.readApkgToString(str);
        }
        localObject1 = str;
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString))
        {
          localObject1 = str;
          if (paramString.indexOf("<script>") < 0) {
            break label351;
          }
          localObject1 = str;
          if (paramString.indexOf("</script>") < 0) {
            break label351;
          }
          i = 1;
          bool1 = bool2;
          if (i == 0)
          {
            localObject1 = str;
            localObject2 = new StringBuilder();
            localObject1 = str;
            ((StringBuilder)localObject2).append("url file cache invalid! content: ");
            localObject1 = str;
            ((StringBuilder)localObject2).append(paramString);
            localObject1 = str;
            QMLog.e("minisdk-start-AppBrandPageContainer", ((StringBuilder)localObject2).toString());
            return false;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          Object localObject2 = AppBrandUtil.getUrlWithoutParams((String)localObject1);
          if (bool3) {
            paramString = new File(this.mApkgInfo.getChildFileAbsolutePath((String)localObject2));
          } else {
            paramString = this.mApkgInfo.getApkgFile((String)localObject2);
          }
          if (bool3) {
            localObject1 = FileUtils.readFileToStr(paramString);
          } else {
            localObject1 = this.mApkgInfo.readApkgToString((String)localObject2);
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isUrlLocalFileValid exception! url= ");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(" filePath=");
          localStringBuilder.append(paramString.getAbsolutePath());
          localStringBuilder.append(" htmlContent=");
          localStringBuilder.append((String)localObject1);
          QMLog.e("minisdk-start-AppBrandPageContainer", localStringBuilder.toString(), localThrowable);
        }
        catch (Throwable paramString)
        {
          QMLog.e("minisdk-start-AppBrandPageContainer", "", paramString);
        }
        bool1 = false;
      }
      return bool1;
      label351:
      int i = 0;
    }
  }
  
  private boolean isMonitorViewShowing()
  {
    MiniAppMonitorInfoView localMiniAppMonitorInfoView = this.mMiniAppMonitorInfoView;
    return (localMiniAppMonitorInfoView != null) && (localMiniAppMonitorInfoView.getVisibility() == 0);
  }
  
  private boolean isSubFileCacheValid(String paramString1, String paramString2)
  {
    Object localObject = this.mApkgInfo;
    if (localObject != null) {
      try
      {
        localObject = ((ApkgInfo)localObject).getRootPath(paramString1);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new File(com.tencent.qqmini.sdk.launcher.core.model.ApkgManager.getApkgFolderPath(this.mMiniAppInfo), (String)localObject).getAbsolutePath();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            return true;
          }
          if (this.mMiniAppInfo.launchParam.isFlutterMode)
          {
            paramString1 = new StringBuilder();
            paramString1.append((String)localObject);
            paramString1.append(File.separator);
            paramString1.append(paramString2);
            paramString1 = FileUtils.readFileToStr(new File(paramString1.toString()));
          }
          else
          {
            paramString1 = this.mApkgInfo.readApkgToString(paramString1);
          }
          if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains(new String(new byte[20]))))
          {
            paramString1 = new StringBuilder();
            paramString1.append(paramString2);
            paramString1.append(" file invalid! ");
            QMLog.e("minisdk-start-AppBrandPageContainer", paramString1.toString());
            return false;
          }
        }
      }
      catch (Throwable paramString1)
      {
        QMLog.e("minisdk-start-AppBrandPageContainer", "", paramString1);
        return false;
      }
    }
    return true;
  }
  
  private boolean isUrlFileExist(ApkgInfo paramApkgInfo, String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramApkgInfo.isUrlFileExist(paramString));
  }
  
  private boolean isUrlLocalFileValid(String paramString)
  {
    return (isIndexHtmlValid(paramString)) && (isSubFileCacheValid(paramString, "app-service.js")) && (isSubFileCacheValid(paramString, "page-frame.js"));
  }
  
  private boolean isUrlReady(String paramString)
  {
    ApkgInfo localApkgInfo = this.mApkgInfo;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localApkgInfo != null)
    {
      bool1 = bool2;
      if (localApkgInfo.isUrlResReady(paramString, this.mContext.getMiniAppInfo()))
      {
        bool1 = bool2;
        if (this.mApkgInfo.isUrlFileExist(paramString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void onSoftKeyClosed()
  {
    Object localObject = this.mSoftKeyboardStateListenerList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.mSoftKeyboardStateListenerList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SoftKeyboardStateHelper.SoftKeyboardStateListener localSoftKeyboardStateListener = (SoftKeyboardStateHelper.SoftKeyboardStateListener)((Iterator)localObject).next();
        if (localSoftKeyboardStateListener != null) {
          localSoftKeyboardStateListener.onSoftKeyboardClosed();
        }
      }
    }
    ThreadManager.getSubThreadHandler().postDelayed(new AppBrandPageContainer.2(this), 50L);
  }
  
  private void onSoftKeyOpened(int paramInt)
  {
    Object localObject = this.mContext;
    if (localObject != null) {
      localObject = ((IMiniAppContext)localObject).getAttachedActivity();
    } else {
      localObject = null;
    }
    int i = paramInt;
    if (localObject != null)
    {
      i = paramInt;
      if (DisplayUtil.hasNavBar((Context)localObject))
      {
        i = paramInt;
        if (DisplayUtil.isNavigationBarExist((Activity)localObject)) {
          i = paramInt - DisplayUtil.getNavigationBarHeight((Context)localObject);
        }
      }
    }
    localObject = this.mSoftKeyboardStateListenerList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.mSoftKeyboardStateListenerList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SoftKeyboardStateHelper.SoftKeyboardStateListener localSoftKeyboardStateListener = (SoftKeyboardStateHelper.SoftKeyboardStateListener)((Iterator)localObject).next();
        if (localSoftKeyboardStateListener != null) {
          localSoftKeyboardStateListener.onSoftKeyboardOpened(i);
        }
      }
    }
    ThreadManager.getSubThreadHandler().postDelayed(new AppBrandPageContainer.3(this, i), 50L);
  }
  
  private void reportEventDisplay(NativeViewRequestEvent paramNativeViewRequestEvent, MiniAppInfo paramMiniAppInfo, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getString("value").split(",");
    if ((paramJSONObject.length > 8) && (!paramJSONObject[0].equals("2")))
    {
      int i = Integer.parseInt(paramJSONObject[7]);
      if (i > 0)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append(paramNativeViewRequestEvent.event);
        paramJSONObject.append(" REPORT_EVENT_DISPLAY: ");
        paramJSONObject.append(i);
        QMLog.e("minisdk-start-AppBrandPageContainer", paramJSONObject.toString());
        MiniReportManager.reportEventType(paramMiniAppInfo, 638, null, null, null, 0, "0", i, null);
      }
    }
  }
  
  private void reportEventSpeed(NativeViewRequestEvent paramNativeViewRequestEvent, MiniAppInfo paramMiniAppInfo, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getString("value").split(",");
    int i = Integer.parseInt(paramJSONObject[0]);
    if ((9 == i) || (6 == i))
    {
      long l = Long.parseLong(paramJSONObject[1]);
      l = Long.parseLong(paramJSONObject[4]) - l;
      if (l > 0L)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append(paramNativeViewRequestEvent.event);
        paramJSONObject.append(" REPORT_EVENT_SPEED: ");
        paramJSONObject.append(l);
        QMLog.e("minisdk-start-AppBrandPageContainer", paramJSONObject.toString());
        if (9 == i)
        {
          MiniReportManager.reportEventType(paramMiniAppInfo, 636, null, null, null, 0, "0", l, null);
          return;
        }
        MiniReportManager.reportEventType(paramMiniAppInfo, 637, null, null, null, 0, "0", l, null);
      }
    }
  }
  
  private void reportKeyValue(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      MiniAppInfo localMiniAppInfo = this.mContext.getMiniAppInfo();
      Object localObject1 = new JSONObject(paramNativeViewRequestEvent.jsonParams).getJSONArray("dataArray");
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        int j = ((JSONObject)localObject2).getInt("key");
        if (15496 == j)
        {
          reportEventDisplay(paramNativeViewRequestEvent, localMiniAppInfo, (JSONObject)localObject2);
        }
        else if (13544 == j)
        {
          reportEventSpeed(paramNativeViewRequestEvent, localMiniAppInfo, (JSONObject)localObject2);
        }
        else if (13582 == j)
        {
          localObject2 = ((JSONObject)localObject2).getString("value");
          try
          {
            MiniReportManager.reportJsError(localMiniAppInfo, getCurrentPageUrl(), (String)localObject2);
          }
          catch (Exception localException2)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramNativeViewRequestEvent.event);
            localStringBuilder.append(" REPORT_EVENT_JS_EXCEPTION: failed:");
            QMLog.e("minisdk-start-AppBrandPageContainer", localStringBuilder.toString(), localException2);
          }
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramNativeViewRequestEvent.event);
      ((StringBuilder)localObject1).append(" error.");
      QMLog.e("minisdk-start-AppBrandPageContainer", ((StringBuilder)localObject1).toString(), localException1);
    }
  }
  
  private void sendBackGroundToJs()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("scene", this.mMiniAppInfo.launchParam.scene);
      localJSONObject.put("appId", this.mContext.getMiniAppInfo().appId);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      QMLog.w("minisdk-start-AppBrandPageContainer", "onPause,paramsObj", localJSONException);
    }
    EventListener localEventListener = this.mEventListener;
    if (localEventListener != null) {
      localEventListener.onWebViewEvent("onAppEnterBackground", localJSONObject.toString(), 0);
    }
  }
  
  private void sendForegroundToJs()
  {
    if (this.mFromReload)
    {
      localObject1 = this.mEventListener;
      if ((localObject1 != null) && (((EventListener)localObject1).isFirstDomReady()) && (!TextUtils.isEmpty(this.mMiniAppInfo.launchParam.entryPath)))
      {
        bool1 = true;
        localObject1 = this.mMiniAppInfo.launchParam.entryPath;
        this.mFromReload = false;
        break label64;
      }
    }
    Object localObject1 = null;
    boolean bool1 = false;
    label64:
    boolean bool2 = ((Boolean)this.mContext.performAction(new AppBrandPageContainer.5(this))).booleanValue();
    Object localObject2 = this.mEventListener;
    if ((localObject2 != null) && ((((EventListener)localObject2).isFirstDomReady()) || (bool2)))
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (getShowingPage() != null) {
          localObject2 = getShowingPage().getCurShowingUrl();
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = AppBrandUtil.getAppLaunchInfo((String)localObject2, this.mMiniAppInfo);
        try
        {
          ((JSONObject)localObject1).put("reLaunch", bool1);
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("minisdk-start-AppBrandPageContainer", "appLaunchInfo error.", localThrowable);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("appLaunchInfo : ");
        localStringBuilder.append(((JSONObject)localObject1).toString());
        QMLog.i("minisdk-start-AppBrandPageContainer", localStringBuilder.toString());
        this.mEventListener.onWebViewEvent("onAppEnterForeground", ((JSONObject)localObject1).toString(), 0);
      }
      initNetwork();
    }
  }
  
  private void sendPageNotFoundEvent(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("path", paramString);
      localJSONObject.put("query", AppBrandUtil.getQueryJson(paramString));
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (this.appBrandPages != null)
      {
        bool1 = bool2;
        if (this.appBrandPages.size() > 0) {
          bool1 = false;
        }
      }
      localJSONObject.put("isEntryPage", bool1);
      paramString = new StringBuilder();
      paramString.append("onPageNotFound : ");
      paramString.append(localJSONObject.toString());
      QMLog.e("minisdk-start-AppBrandPageContainer", paramString.toString());
      this.mContext.performAction(ServiceSubscribeEvent.obtain("onPageNotFound", localJSONObject.toString(), 0));
      return;
    }
    catch (JSONException paramString)
    {
      QMLog.e("minisdk-start-AppBrandPageContainer", "onPageNotFound error", paramString);
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
    if (paramView == null) {
      return false;
    }
    NativeViewContainer localNativeViewContainer = getNativeViewContainer();
    if (localNativeViewContainer == null) {
      return false;
    }
    if (paramLayoutParams != null) {
      localNativeViewContainer.addView(paramView, paramLayoutParams);
    } else {
      localNativeViewContainer.addView(paramView);
    }
    return true;
  }
  
  public void cleanup(boolean paramBoolean)
  {
    Iterator localIterator = this.appBrandPages.iterator();
    while (localIterator.hasNext())
    {
      AppBrandPage localAppBrandPage = (AppBrandPage)localIterator.next();
      if (localAppBrandPage != null) {
        if (paramBoolean)
        {
          ApkgInfo localApkgInfo = this.mApkgInfo;
          if ((localApkgInfo != null) && (localApkgInfo.isTabBarPage(localAppBrandPage.getCurShowingUrl()))) {}
        }
        else
        {
          localAppBrandPage.onPause();
          localAppBrandPage.cleanUp();
          removeView(localAppBrandPage);
          localIterator.remove();
        }
      }
    }
  }
  
  public String dispatchEventToNativeView(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    if (paramNativeViewRequestEvent.dispatchTarget == 3) {
      return handlePageEvent(paramNativeViewRequestEvent);
    }
    Object localObject = getShowingPage();
    if (localObject == null) {
      return null;
    }
    if (paramNativeViewRequestEvent.dispatchTarget == 0) {
      return ((AppBrandPage)localObject).handleNativeUIEvent(paramNativeViewRequestEvent);
    }
    localObject = ((AppBrandPage)localObject).getPageWebviewContainer();
    if (localObject == null) {
      return null;
    }
    if (paramNativeViewRequestEvent.dispatchTarget == 1) {
      return ((PageWebviewContainer)localObject).handleNativeUIEvent(paramNativeViewRequestEvent);
    }
    localObject = ((PageWebviewContainer)localObject).getNativeViewContainer();
    if (localObject == null) {
      return null;
    }
    if (paramNativeViewRequestEvent.dispatchTarget == 2) {
      return ((NativeViewContainer)localObject).handleNativeUIEvent(paramNativeViewRequestEvent);
    }
    return null;
  }
  
  public void dispatchEventToWebView(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    Object localObject;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0))
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        localObject = new LinkedList(this.appBrandPages).iterator();
        while (((Iterator)localObject).hasNext())
        {
          BrandPageWebview localBrandPageWebview = ((AppBrandPage)((Iterator)localObject).next()).getBrandPageWebviewById(k);
          if (localBrandPageWebview != null) {
            localBrandPageWebview.evaluateSubscribeJSInService(paramString1, paramString2, k);
          }
        }
        i += 1;
      }
      return;
    }
    paramArrayOfInt = new LinkedList(this.appBrandPages).iterator();
    while (paramArrayOfInt.hasNext())
    {
      localObject = (AppBrandPage)paramArrayOfInt.next();
      if ((localObject != null) && (((AppBrandPage)localObject).getBrandPageWebview() != null)) {
        ((AppBrandPage)localObject).getBrandPageWebview().evaluateSubscribeJSInService(paramString1, paramString2, ((AppBrandPage)localObject).getPageWebviewId());
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f = ViewUtils.getDensity();
    try
    {
      int i = (int)(paramMotionEvent.getX() / f);
      int j = (int)(paramMotionEvent.getY() / f);
      if (paramMotionEvent.getAction() == 0)
      {
        this.lastTouchDownX = i;
        this.lastTouchDownY = j;
        this.lastTouchDownTimeStamp = System.currentTimeMillis();
      }
      else if (paramMotionEvent.getAction() == 1)
      {
        this.lastTouchUpX = i;
        this.lastTouchUpY = j;
        if (this.lastClicks.size() > 10) {
          this.lastClicks.poll();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("wesley size: ");
        localStringBuilder.append(this.lastClicks.size());
        localStringBuilder.append(" x:");
        localStringBuilder.append(this.lastTouchDownX);
        localStringBuilder.append(" y:");
        localStringBuilder.append(this.lastTouchDownY);
        QMLog.d("minisdk-start-AppBrandPageContainer", localStringBuilder.toString());
        this.lastClicks.add(new AppBrandPageContainer.ClickPoint(this.lastTouchDownX, this.lastTouchDownY, this.lastTouchUpX, this.lastTouchUpY, this.lastTouchDownTimeStamp));
      }
    }
    catch (Exception localException)
    {
      QMLog.e("minisdk-start-AppBrandPageContainer", "dispatchTouchEvent failed,", localException);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    try
    {
      getShowingPage().getBrandPageWebview().doDispatchKeyEvent(paramKeyEvent);
    }
    catch (Throwable paramKeyEvent)
    {
      QMLog.e("minisdk-start-AppBrandPageContainer", "doDispatchKeyEvent error,", paramKeyEvent);
    }
    return false;
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
  
  public String getLastClicks()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    Iterator localIterator = this.lastClicks.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      AppBrandPageContainer.ClickPoint localClickPoint = (AppBrandPageContainer.ClickPoint)localIterator.next();
      if (i > 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append("[");
      localStringBuilder.append(localClickPoint.downX);
      localStringBuilder.append(",");
      localStringBuilder.append(localClickPoint.downY);
      localStringBuilder.append(",");
      localStringBuilder.append(localClickPoint.upX);
      localStringBuilder.append(",");
      localStringBuilder.append(localClickPoint.upY);
      localStringBuilder.append(",");
      localStringBuilder.append(localClickPoint.clickTimeMills);
      localStringBuilder.append("]");
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public String getNaviBarStyle()
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    String str2 = "default";
    String str1 = str2;
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getNavBar();
      str1 = str2;
      if (localObject != null) {
        str1 = ((NavigationBar)localObject).getNavbarStyle();
      }
    }
    return str1;
  }
  
  public int getNaviBarTextStyle()
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    int j = -1;
    int i = j;
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getNavBar();
      i = j;
      if (localObject != null) {
        i = ((NavigationBar)localObject).getStatusNavigationBarTextStyle();
      }
    }
    return i;
  }
  
  public int getNaviBarVisibility()
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    int j = 8;
    int i = j;
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getNavBar();
      i = j;
      if (localObject != null) {
        i = ((NavigationBar)localObject).getVisibility();
      }
    }
    return i;
  }
  
  public int getPageCount()
  {
    LinkedList localLinkedList = this.appBrandPages;
    if (localLinkedList != null) {
      return localLinkedList.size();
    }
    return 0;
  }
  
  public AppPageInfo getPageInfo(int paramInt)
  {
    AppPageInfo.Builder localBuilder = new AppPageInfo.Builder();
    AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)this.appBrandPages.peek();
    if ((AppPageInfo.enableGetPageId(paramInt)) && (localAbsAppBrandPage != null) && (localAbsAppBrandPage.getCurrentPageWebview() != null)) {
      localBuilder.setPageId(localAbsAppBrandPage.getCurrentPageWebview().getPageWebViewId());
    }
    if (AppPageInfo.enableGetPageUrl(paramInt))
    {
      String str;
      if (localAbsAppBrandPage != null) {
        str = localAbsAppBrandPage.getCurShowingUrl();
      } else {
        str = null;
      }
      localBuilder.setPageUrl(str);
    }
    if ((AppPageInfo.enableGetWebViewUrl(paramInt)) && (localAbsAppBrandPage != null) && (localAbsAppBrandPage.getRootContainer() != null) && (localAbsAppBrandPage.getRootContainer().getNativeViewContainer() != null)) {
      localBuilder.setWebViewUrl(localAbsAppBrandPage.getRootContainer().getNativeViewContainer().getInnerWebViewUrl());
    }
    if (AppPageInfo.enableGetPageWindowWidth(paramInt)) {
      localBuilder.setWindowWidth(getPageWebviewContainer().getWidth());
    }
    if (AppPageInfo.enableGetPageWindowHeight(paramInt)) {
      localBuilder.setWindowHeight(getPageWebviewContainer().getHeight());
    }
    return localBuilder.build();
  }
  
  public String getPageOrientation()
  {
    PageWebviewContainer localPageWebviewContainer = getPageWebviewContainer();
    if (localPageWebviewContainer != null) {
      return localPageWebviewContainer.getPageOrientation();
    }
    return "";
  }
  
  public String getReferPageUrl()
  {
    QMLog.i("minisdk-start-AppBrandPageContainer", "getReferPageUrl ");
    if (getPageCount() < 2) {
      return "";
    }
    Object localObject = this.appBrandPages.iterator();
    if (((Iterator)localObject).hasNext())
    {
      ((Iterator)localObject).next();
      if (((Iterator)localObject).hasNext())
      {
        localObject = (AppBrandPage)((Iterator)localObject).next();
        if (localObject != null) {
          return ((AppBrandPage)localObject).getCurShowingUrl();
        }
      }
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
    LinkedList localLinkedList = this.appBrandPages;
    if ((localLinkedList != null) && (localLinkedList.peek() != null)) {
      return ((AppBrandPage)this.appBrandPages.peek()).getPageWebviewId();
    }
    return -1;
  }
  
  public int getTabBarVisibility()
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    int j = 8;
    int i = j;
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getTabBar();
      i = j;
      if (localObject != null) {
        i = ((TabBar)localObject).getVisibility();
      }
    }
    return i;
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
    paramObject = this.mAppBrandPagePool;
    if (paramObject != null) {
      paramObject.preLoadAppBrandPage(this.mContext, this);
    }
  }
  
  public void initBaseJs(BaselibLoader.BaselibContent paramBaselibContent)
  {
    AppBrandPagePool localAppBrandPagePool = this.mAppBrandPagePool;
    if (localAppBrandPagePool != null) {
      localAppBrandPagePool.initBaseJs(this, paramBaselibContent);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launch url : ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("; type : ");
    ((StringBuilder)localObject).append(paramString2);
    QMLog.i("minisdk-start-AppBrandPageContainer", ((StringBuilder)localObject).toString());
    if ((isUrlReady(paramString1)) && (isUrlLocalFileValid(paramString1)))
    {
      localObject = this.mAppBrandPagePool.getAppBrandPage(this.mContext, this);
      this.appBrandPages.push(localObject);
      ((AppBrandPage)localObject).loadUrl(paramString1, paramString2, this.mEventListener);
      addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
      return;
    }
    executeDownSubPackage(paramString1, paramString2);
  }
  
  public boolean navigateBack(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("navigateBack delta : ");
    ((StringBuilder)localObject).append(paramInt1);
    QMLog.i("minisdk-start-AppBrandPageContainer", ((StringBuilder)localObject).toString());
    localObject = getShowingPage();
    if ((localObject != null) && (((AppBrandPage)localObject).handleBackPressed())) {
      return true;
    }
    int j = getPageCount();
    int i = 0;
    if (j >= 2)
    {
      if (paramInt1 < 1) {
        return false;
      }
      paramInt2 = paramInt1;
      if (paramInt1 >= j) {
        paramInt2 = j - 1;
      }
      localObject = this.appBrandPages.iterator();
      paramInt1 = i;
      while ((paramInt1 < paramInt2) && (this.appBrandPages.size() >= 1))
      {
        if (((Iterator)localObject).hasNext())
        {
          AppBrandPage localAppBrandPage = (AppBrandPage)((Iterator)localObject).next();
          if (localAppBrandPage != null)
          {
            Animation localAnimation = AnimationUtils.loadAnimation(AppLoaderFactory.g().getContext(), R.anim.mini_sdk_page_slide_out_to_right);
            localAnimation.setDuration(200L);
            localAnimation.setAnimationListener(new AppBrandPageContainer.4(this, localAppBrandPage));
            localAppBrandPage.startAnimation(localAnimation);
            localAppBrandPage.onPause();
            ((Iterator)localObject).remove();
          }
        }
        paramInt1 += 1;
      }
      hideSoftInput(this);
      localObject = (AppBrandPage)this.appBrandPages.peek();
      if (localObject != null)
      {
        ((AppBrandPage)localObject).onResume();
        if (isActivityValid())
        {
          ((AppBrandPage)localObject).updateWidowInfo(this.mContext.getAttachedActivity());
          ((AppBrandPage)localObject).refreshOrientation();
        }
        this.mEventListener.onWebViewReady("navigateBack", ((AppBrandPage)localObject).getCurShowingUrl(), ((AppBrandPage)localObject).getPageWebviewId());
      }
      return true;
    }
    return false;
  }
  
  public void navigateTo(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("navigateTo url : ");
    ((StringBuilder)localObject).append(paramString);
    QMLog.i("minisdk-start-AppBrandPageContainer", ((StringBuilder)localObject).toString());
    if (this.aliveWebViewCount > 10)
    {
      Toast.makeText(getContext(), "打开页面超过上限，请返回", 0).show();
      QMLog.e("minisdk-start-AppBrandPageContainer", "打开WebView数量超过上限");
      return;
    }
    if ((isUrlReady(paramString)) && (isUrlLocalFileValid(paramString)))
    {
      localObject = (AppBrandPage)this.appBrandPages.peek();
      if (localObject != null) {
        ((AppBrandPage)localObject).onPause();
      }
      localObject = this.mAppBrandPagePool.getAppBrandPage(this.mContext, this);
      this.appBrandPages.push(localObject);
      ((AppBrandPage)localObject).loadUrl(paramString, "navigateTo", this.mEventListener);
      if (!((AppBrandPage)localObject).isHomePage()) {
        ((AppBrandPage)localObject).setVisibility(4);
      }
      addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
      return;
    }
    executeDownSubPackage(paramString, "navigateTo");
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
  
  public void notifyOnPageWebViewPause(int paramInt)
  {
    Object localObject = getPageByWebviewId(paramInt);
    if ((localObject != null) && (((AppBrandPage)localObject).getPageWebviewContainer() != null)) {
      localObject = ((AppBrandPage)localObject).getPageWebviewContainer().getNativeViewContainer();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((NativeViewContainer)localObject).notifyOnPageWebViewPause();
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
    AppBrandPagePool localAppBrandPagePool = this.mAppBrandPagePool;
    if (localAppBrandPagePool != null)
    {
      localAppBrandPagePool.destroyCachePage();
      this.mAppBrandPagePool = null;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    AppBrandPageContainer.MonitorBroadcastReceiver localMonitorBroadcastReceiver = this.mBroadcastReceiver;
    if (localMonitorBroadcastReceiver != null)
    {
      Activity localActivity = this.mActivity;
      if (localActivity != null)
      {
        localActivity.unregisterReceiver(localMonitorBroadcastReceiver);
        this.mBroadcastReceiver = null;
      }
    }
  }
  
  public void onNewPageCompleted()
  {
    while (!this.redirectOldPages.isEmpty())
    {
      AppBrandPage localAppBrandPage = (AppBrandPage)this.redirectOldPages.poll();
      if (localAppBrandPage != null)
      {
        localAppBrandPage.onPause();
        localAppBrandPage.cleanUp();
        removeView(localAppBrandPage);
      }
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
      localAppBrandPage.onResume();
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
  
  public boolean operatePendantAd(String paramString, PendantAdInfo paramPendantAdInfo)
  {
    return false;
  }
  
  public void recyclePreLoadAppBrandPage()
  {
    AppBrandPagePool localAppBrandPagePool = this.mAppBrandPagePool;
    if (localAppBrandPagePool != null) {
      localAppBrandPagePool.destroyPageWebviewCache();
    }
  }
  
  public void redirectTo(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("redirectTo url : ");
    ((StringBuilder)localObject).append(paramString);
    QMLog.i("minisdk-start-AppBrandPageContainer", ((StringBuilder)localObject).toString());
    if ((isUrlReady(paramString)) && (isUrlLocalFileValid(paramString)))
    {
      localObject = this.appBrandPages;
      if ((localObject != null) && (((LinkedList)localObject).size() > 0))
      {
        localObject = (AppBrandPage)this.appBrandPages.poll();
        this.redirectOldPages.add(localObject);
      }
      localObject = this.mAppBrandPagePool.getAppBrandPage(this.mContext, this);
      this.appBrandPages.push(localObject);
      ((AppBrandPage)localObject).loadUrl(paramString, "redirectTo", this.mEventListener);
      if (!((AppBrandPage)localObject).isHomePage()) {
        ((AppBrandPage)localObject).setVisibility(4);
      }
      addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
      return;
    }
    executeDownSubPackage(paramString, "redirectTo");
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
    if (paramView == null) {
      return false;
    }
    NativeViewContainer localNativeViewContainer = getNativeViewContainer();
    if (localNativeViewContainer == null) {
      return false;
    }
    localNativeViewContainer.removeView(paramView);
    return true;
  }
  
  public void removeSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    if (paramSoftKeyboardStateListener != null)
    {
      List localList = this.mSoftKeyboardStateListenerList;
      if (localList == null) {
        return;
      }
      localList.remove(paramSoftKeyboardStateListener);
    }
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("switchTab url : ");
    ((StringBuilder)localObject).append(paramString);
    QMLog.i("minisdk-start-AppBrandPageContainer", ((StringBuilder)localObject).toString());
    cleanup(true);
    localObject = getBrandPage();
    this.appBrandPages.push(localObject);
    ((AppBrandPage)localObject).loadUrl(paramString, "switchTab", this.mEventListener);
  }
  
  public boolean toggleDebugPanel()
  {
    Object localObject = this.mContext;
    if (localObject != null) {
      localObject = ((IMiniAppContext)localObject).getMiniAppInfo();
    } else {
      localObject = null;
    }
    boolean bool = DebugUtil.getDebugEnabled((MiniAppInfo)localObject) ^ true;
    DebugUtil.setDebugEnabled((MiniAppInfo)localObject, bool);
    return bool;
  }
  
  public boolean toggleMonitorPanel()
  {
    Activity localActivity = this.mContext.getAttachedActivity();
    if (localActivity != null)
    {
      Object localObject = this.mMiniAppMonitorInfoView;
      if (localObject == null)
      {
        this.mMiniAppMonitorInfoView = new MiniAppMonitorInfoView(localActivity, null, 0);
        localObject = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject).gravity = 53;
        localActivity.addContentView(this.mMiniAppMonitorInfoView, (ViewGroup.LayoutParams)localObject);
        this.mMiniAppMonitorInfoView.setVisibility(0);
        this.mMiniAppMonitorInfoView.startRefreshMonitorUi();
      }
      else if (((MiniAppMonitorInfoView)localObject).getVisibility() == 0)
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
    return isMonitorViewShowing();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer
 * JD-Core Version:    0.7.0.1
 */