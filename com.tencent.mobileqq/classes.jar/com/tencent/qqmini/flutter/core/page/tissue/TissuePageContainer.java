package com.tencent.qqmini.flutter.core.page.tissue;

import android.app.Activity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.miniapp.util.URL;
import com.tencent.qqmini.sdk.core.Preloadable;
import com.tencent.qqmini.sdk.core.tissue.TissueEnv;
import com.tencent.qqmini.sdk.core.tissue.TissueGlobal;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo.Builder;
import com.tencent.qqmini.sdk.launcher.core.model.FloatDragAdInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.widget.CapsuleButton;
import com.tencent.qqmini.sdk.widget.ToastView;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class TissuePageContainer
  implements IAppBrandPageContainer, Preloadable
{
  private static final String TAG = "TissueRenderer";
  public static Activity activity;
  private FlutterView flutterView;
  private boolean isV8AfterFlutter = false;
  private ApkgInfo mApkgInfo;
  private EventListener mEventListener;
  private boolean mFromReload = false;
  private IMiniAppContext mMiniAppContext;
  private MiniAppInfo mMiniAppInfo;
  private FlutterNativeView mNativeView;
  private URL mStartUpURL;
  private int pageCount = 0;
  private ToastView toastView;
  
  public TissuePageContainer(IMiniAppContext paramIMiniAppContext, EventListener paramEventListener)
  {
    this.mMiniAppContext = paramIMiniAppContext;
    this.mEventListener = paramEventListener;
  }
  
  public void cleanup(boolean paramBoolean) {}
  
  public String dispatchEventToNativeView(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    QMLog.d("miniapp-TISSUE", paramNativeViewRequestEvent.event + ": " + paramNativeViewRequestEvent.jsonParams);
    return null;
  }
  
  public void dispatchEventToWebView(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if ("flutter_launch".equals(paramString1))
    {
      QMLog.d("miniapp-TISSUE", " app service load done");
      this.mMiniAppContext.performAction(new TissuePageContainer.4(this, paramString2));
      return;
    }
    if ("operateVideoPlayer".equals(paramString1))
    {
      QMLog.d("QFV", " from app-service operateVideoPlayer:" + paramString2);
      sendMsgToFlutter("operateVideoPlayer", JSONUtil.toMap(JSONUtil.parse(paramString2)));
    }
    for (;;)
    {
      try
      {
        localObject = JSONUtil.parse(paramString2);
        HashMap localHashMap = new HashMap();
        localHashMap.put("event", paramString1);
        if (localObject != null) {
          continue;
        }
        localObject = new HashMap();
        localHashMap.put("data", localObject);
        if (paramArrayOfInt != null) {
          localHashMap.put("pageIDs", paramArrayOfInt);
        }
        sendMsgToFlutter("publishHandler", localHashMap);
      }
      catch (Exception paramArrayOfInt)
      {
        Object localObject;
        QMLog.e("miniapp-TISSUE", "", paramArrayOfInt);
        continue;
      }
      QMLog.d("miniapp-TISSUE", paramString1 + ": " + paramString2);
      return;
      localObject = JSONUtil.toMap((JSONObject)localObject);
    }
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public CapsuleButton getCapsuleButton()
  {
    return null;
  }
  
  public View getContentView()
  {
    return this.flutterView;
  }
  
  public int getNaviBarTextStyle()
  {
    return -1;
  }
  
  public int getNaviBarVisibility()
  {
    return 0;
  }
  
  public AppPageInfo getPageInfo(int paramInt)
  {
    AppPageInfo.Builder localBuilder = new AppPageInfo.Builder();
    Object localObject;
    if (this.mStartUpURL != null)
    {
      localObject = this.mStartUpURL.getFullUrl();
      localObject = localBuilder.setPageUrl((String)localObject);
      if (this.flutterView == null) {
        break label58;
      }
    }
    label58:
    for (paramInt = this.flutterView.getHeight();; paramInt = 0)
    {
      return ((AppPageInfo.Builder)localObject).setWindowHeight(paramInt).build();
      localObject = null;
      break;
    }
  }
  
  public String getPageOrientation()
  {
    return "";
  }
  
  public int getTabBarVisibility()
  {
    return 0;
  }
  
  public boolean hasToastView()
  {
    return (this.toastView != null) && (this.toastView.shown());
  }
  
  public void hideSoftInput(View paramView) {}
  
  public void hideToastView()
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("TissueRenderer", "hideToastView toastView=" + this.toastView);
    }
    if (this.toastView != null)
    {
      this.toastView.hide();
      this.toastView = null;
    }
  }
  
  public void init(Object paramObject) {}
  
  public void launch(String paramString1, String paramString2)
  {
    this.mStartUpURL = new URL(paramString1);
    if (this.mApkgInfo != null)
    {
      if (!this.isV8AfterFlutter) {
        break label263;
      }
      paramString1 = "1";
      if (this.mMiniAppContext.getMiniAppInfo() != null) {
        break label270;
      }
    }
    label263:
    label270:
    for (paramString2 = MiniProgramReportHelper.miniAppConfigForPreload();; paramString2 = this.mMiniAppContext.getMiniAppInfo())
    {
      MiniAppReportManager2.reportLaunchPiecewise(215, paramString1, paramString2);
      paramString1 = new HashMap();
      paramString1.put("apkgUnpackPath", this.mApkgInfo.apkgFolderPath);
      paramString1.put("appName", this.mApkgInfo.apkgName);
      paramString1.put("pagePath", this.mStartUpURL.getPath());
      paramString1.put("query", this.mStartUpURL.getQueryParam());
      paramString1.put("logLevel", Integer.valueOf(6 - QMLog.getLogLevel()));
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.mMiniAppContext != null)
      {
        bool1 = bool2;
        if (this.mMiniAppContext.getMiniAppInfo() != null)
        {
          bool1 = bool2;
          if (this.mMiniAppContext.getMiniAppInfo().appMode != null) {
            bool1 = this.mMiniAppContext.getMiniAppInfo().appMode.closeTopRightCapsule;
          }
        }
      }
      paramString1.put("topRightBtnHidden", Boolean.valueOf(bool1));
      QMLog.w("miniapp-start-TISSUE", " miniapp launch" + this.mApkgInfo.appId);
      sendMsgToFlutter("appLaunch", paramString1);
      return;
      paramString1 = "0";
      break;
    }
  }
  
  public boolean navigateBack(int paramInt1, int paramInt2)
  {
    if (this.pageCount == 0) {
      return false;
    }
    sendMsgToFlutter("navigateBack", new TissuePageContainer.3(this, paramInt1, paramInt2));
    this.pageCount = Math.max(this.pageCount - paramInt1, 0);
    return true;
  }
  
  public void navigateTo(String paramString, int paramInt)
  {
    Object localObject = new URL(paramString);
    paramString = ((URL)localObject).getPath();
    localObject = ((URL)localObject).getQueryParam();
    this.pageCount += 1;
    sendMsgToFlutter("navigateTo", new TissuePageContainer.1(this, paramString, (Map)localObject, paramInt));
  }
  
  public void onAttachedToActivity(Activity paramActivity)
  {
    activity = paramActivity;
    QMLog.w("miniapp-start-TISSUE", "flutterView start run" + System.currentTimeMillis());
    MiniAppReportManager2.reportLaunchPiecewise(212, "", this.mMiniAppContext.getMiniAppInfo());
    FlutterMain.setNativeLibDir(TissueGlobal.tissueEnv.getNativeLibDir());
    if (this.flutterView != null) {
      return;
    }
    QMLog.w("miniapp-start-TISSUE", "start create flutterView " + System.currentTimeMillis());
    this.flutterView = Flutter.createView(paramActivity, "", this.mNativeView);
    this.flutterView.onStart();
    this.flutterView.onPostResume();
    QMLog.w("miniapp-start-TISSUE", "flutterView run end" + System.currentTimeMillis());
    MiniAppReportManager2.reportLaunchPiecewise(213, "", this.mMiniAppContext.getMiniAppInfo());
  }
  
  public void onDestroy() {}
  
  public void onPause()
  {
    if (this.mEventListener != null) {
      this.mEventListener.onWebViewEvent("onAppEnterBackground", "{}", 0);
    }
    if (this.flutterView != null) {
      this.flutterView.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.flutterView != null) {
      this.flutterView.onPostResume();
    }
    Object localObject = null;
    boolean bool;
    if ((this.mFromReload) && (this.mEventListener != null) && (this.mEventListener.isFirstDomReady()) && (!TextUtils.isEmpty(this.mMiniAppInfo.launchParam.entryPath)))
    {
      bool = true;
      localObject = this.mMiniAppInfo.launchParam.entryPath;
      this.mEventListener.reload(this.mMiniAppInfo.launchParam.entryPath);
    }
    for (;;)
    {
      if ((this.mEventListener != null) && (this.mEventListener.isFirstDomReady()) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        localObject = AppBrandUtil.getAppLaunchInfo((String)localObject, this.mMiniAppInfo);
      }
      try
      {
        ((JSONObject)localObject).put("reLaunch", bool);
        QMLog.i("TissueRenderer", "appLaunchInfo : " + ((JSONObject)localObject).toString());
        this.mEventListener.onWebViewEvent("onAppEnterForeground", ((JSONObject)localObject).toString(), 0);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QMLog.e("TissueRenderer", "appLaunchInfo error.", localThrowable);
        }
      }
      bool = false;
    }
  }
  
  public void onStop()
  {
    if (this.flutterView != null) {
      this.flutterView.onStop();
    }
  }
  
  public boolean operateCustomButton(String paramString, long paramLong, JSONObject paramJSONObject, View.OnClickListener paramOnClickListener)
  {
    return false;
  }
  
  public boolean operateFloatDragAd(String paramString, FloatDragAdInfo paramFloatDragAdInfo)
  {
    return false;
  }
  
  public void redirectTo(String paramString, int paramInt)
  {
    paramString = new URL(paramString);
    sendMsgToFlutter("redirectTo", new TissuePageContainer.2(this, paramString.getPath(), paramString.getQueryParam(), paramInt));
  }
  
  public void sendMsgToFlutter(String paramString)
  {
    sendMsgToFlutter(paramString, new HashMap());
  }
  
  public void sendMsgToFlutter(String paramString, Map<String, Object> paramMap)
  {
    this.mMiniAppContext.performAction(new TissuePageContainer.5(this, paramString, paramMap));
  }
  
  public void setFromReload(boolean paramBoolean)
  {
    this.mFromReload = paramBoolean;
  }
  
  public boolean setMiniAIOEntranceVisible(boolean paramBoolean, JSONObject paramJSONObject)
  {
    return false;
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.mMiniAppInfo = paramMiniAppInfo;
    this.mApkgInfo = ((ApkgInfo)paramMiniAppInfo.apkgInfo);
  }
  
  public void setNativeView(FlutterNativeView paramFlutterNativeView)
  {
    this.mNativeView = paramFlutterNativeView;
  }
  
  public void setNaviVisibility(int paramInt) {}
  
  public void setTabBarVisibility(int paramInt) {}
  
  public void showToastView(int paramInt1, String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt2, boolean paramBoolean)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("TissueRenderer", "showToastView toastView=" + this.toastView);
    }
    if (this.mMiniAppContext.getAttachedActivity() == null)
    {
      QMLog.w("TissueRenderer", "Failed to showToastView, activity is null");
      return;
    }
    if (this.toastView == null) {
      this.toastView = new ToastView(this.mMiniAppContext.getContext(), (ViewGroup)this.mMiniAppContext.getAttachedActivity().findViewById(16908290));
    }
    this.toastView.show(paramInt1, paramString1, paramString2, paramCharSequence, paramInt2, paramBoolean);
  }
  
  public void switchTab(String paramString) {}
  
  public boolean toggleDebugPanel()
  {
    MiniAppInfo localMiniAppInfo;
    if (this.mMiniAppContext != null)
    {
      localMiniAppInfo = this.mMiniAppContext.getMiniAppInfo();
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
    return false;
  }
  
  public void updateToastMsg(String paramString)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("TissueRenderer", "updateToastMsg toastView=" + this.toastView);
    }
    if (this.toastView == null) {
      return;
    }
    this.toastView.updateMsg(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.page.tissue.TissuePageContainer
 * JD-Core Version:    0.7.0.1
 */