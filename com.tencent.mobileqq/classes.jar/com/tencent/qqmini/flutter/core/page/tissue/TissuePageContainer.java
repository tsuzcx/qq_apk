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
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramNativeViewRequestEvent.event);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramNativeViewRequestEvent.jsonParams);
    QMLog.d("miniapp-TISSUE", localStringBuilder.toString());
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
    Object localObject;
    if ("operateVideoPlayer".equals(paramString1))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" from app-service operateVideoPlayer:");
      ((StringBuilder)localObject).append(paramString2);
      QMLog.d("QFV", ((StringBuilder)localObject).toString());
      sendMsgToFlutter("operateVideoPlayer", JSONUtil.toMap(JSONUtil.parse(paramString2)));
    }
    try
    {
      localObject = JSONUtil.parse(paramString2);
      HashMap localHashMap = new HashMap();
      localHashMap.put("event", paramString1);
      if (localObject == null) {
        localObject = new HashMap();
      } else {
        localObject = JSONUtil.toMap((JSONObject)localObject);
      }
      localHashMap.put("data", localObject);
      if (paramArrayOfInt != null) {
        localHashMap.put("pageIDs", paramArrayOfInt);
      }
      sendMsgToFlutter("publishHandler", localHashMap);
    }
    catch (Exception paramArrayOfInt)
    {
      QMLog.e("miniapp-TISSUE", "", paramArrayOfInt);
    }
    paramArrayOfInt = new StringBuilder();
    paramArrayOfInt.append(paramString1);
    paramArrayOfInt.append(": ");
    paramArrayOfInt.append(paramString2);
    QMLog.d("miniapp-TISSUE", paramArrayOfInt.toString());
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
    Object localObject2 = new AppPageInfo.Builder();
    Object localObject1 = this.mStartUpURL;
    if (localObject1 != null) {
      localObject1 = ((URL)localObject1).getFullUrl();
    } else {
      localObject1 = null;
    }
    localObject1 = ((AppPageInfo.Builder)localObject2).setPageUrl((String)localObject1);
    localObject2 = this.flutterView;
    if (localObject2 != null) {
      paramInt = ((FlutterView)localObject2).getHeight();
    } else {
      paramInt = 0;
    }
    return ((AppPageInfo.Builder)localObject1).setWindowHeight(paramInt).build();
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
    ToastView localToastView = this.toastView;
    return (localToastView != null) && (localToastView.shown());
  }
  
  public void hideSoftInput(View paramView) {}
  
  public void hideToastView()
  {
    if (QMLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideToastView toastView=");
      ((StringBuilder)localObject).append(this.toastView);
      QMLog.d("TissueRenderer", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.toastView;
    if (localObject != null)
    {
      ((ToastView)localObject).hide();
      this.toastView = null;
    }
  }
  
  public void init(Object paramObject) {}
  
  public void launch(String paramString1, String paramString2)
  {
    this.mStartUpURL = new URL(paramString1);
    if (this.mApkgInfo != null)
    {
      if (this.isV8AfterFlutter) {
        paramString1 = "1";
      } else {
        paramString1 = "0";
      }
      if (this.mMiniAppContext.getMiniAppInfo() == null) {
        localObject = MiniProgramReportHelper.miniAppConfigForPreload();
      } else {
        localObject = this.mMiniAppContext.getMiniAppInfo();
      }
      MiniAppReportManager2.reportLaunchPiecewise(215, paramString1, (MiniAppInfo)localObject);
      paramString1 = new HashMap();
      paramString1.put("apkgUnpackPath", this.mApkgInfo.apkgFolderPath);
      paramString1.put("appName", this.mApkgInfo.apkgName);
      paramString1.put("pagePath", this.mStartUpURL.getPath());
      paramString1.put("query", this.mStartUpURL.getQueryParam());
      paramString1.put("logLevel", Integer.valueOf(6 - QMLog.getLogLevel()));
      boolean bool2 = false;
      Object localObject = this.mMiniAppContext;
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((IMiniAppContext)localObject).getMiniAppInfo() != null)
        {
          bool1 = bool2;
          if (this.mMiniAppContext.getMiniAppInfo().appMode != null) {
            bool1 = this.mMiniAppContext.getMiniAppInfo().appMode.closeTopRightCapsule;
          }
        }
      }
      paramString1.put("topRightBtnHidden", Boolean.valueOf(bool1));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" miniapp launch");
      ((StringBuilder)localObject).append(this.mApkgInfo.appId);
      QMLog.w("miniapp-start-TISSUE", ((StringBuilder)localObject).toString());
      sendMsgToFlutter(paramString2, paramString1);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("flutterView start run");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    QMLog.w("miniapp-start-TISSUE", ((StringBuilder)localObject).toString());
    MiniAppReportManager2.reportLaunchPiecewise(212, "", this.mMiniAppContext.getMiniAppInfo());
    FlutterMain.setNativeLibDir(TissueGlobal.tissueEnv.getNativeLibDir());
    localObject = this.flutterView;
    if (localObject != null)
    {
      this.mNativeView.attachViewAndActivity((FlutterView)localObject, paramActivity);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start create flutterView ");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    QMLog.w("miniapp-start-TISSUE", ((StringBuilder)localObject).toString());
    this.flutterView = Flutter.createView(paramActivity, "", this.mNativeView);
    this.flutterView.onStart();
    this.flutterView.onPostResume();
    paramActivity = new StringBuilder();
    paramActivity.append("flutterView run end");
    paramActivity.append(System.currentTimeMillis());
    QMLog.w("miniapp-start-TISSUE", paramActivity.toString());
    MiniAppReportManager2.reportLaunchPiecewise(213, "", this.mMiniAppContext.getMiniAppInfo());
  }
  
  public void onDestroy() {}
  
  public void onPause()
  {
    Object localObject = this.mEventListener;
    if (localObject != null) {
      ((EventListener)localObject).onWebViewEvent("onAppEnterBackground", "{}", 0);
    }
    localObject = this.flutterView;
    if (localObject != null) {
      ((FlutterView)localObject).onPause();
    }
  }
  
  public void onResume()
  {
    Object localObject = this.flutterView;
    if (localObject != null) {
      ((FlutterView)localObject).onPostResume();
    }
    localObject = null;
    if (this.mFromReload)
    {
      localEventListener = this.mEventListener;
      if ((localEventListener != null) && (localEventListener.isFirstDomReady()) && (!TextUtils.isEmpty(this.mMiniAppInfo.launchParam.entryPath)))
      {
        localObject = this.mMiniAppInfo.launchParam.entryPath;
        this.mEventListener.reload(this.mMiniAppInfo.launchParam.entryPath);
        bool = true;
        break label89;
      }
    }
    boolean bool = false;
    label89:
    EventListener localEventListener = this.mEventListener;
    if ((localEventListener != null) && (localEventListener.isFirstDomReady()) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      localObject = AppBrandUtil.getAppLaunchInfo((String)localObject, this.mMiniAppInfo);
      try
      {
        ((JSONObject)localObject).put("reLaunch", bool);
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("TissueRenderer", "appLaunchInfo error.", localThrowable);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("appLaunchInfo : ");
      localStringBuilder.append(((JSONObject)localObject).toString());
      QMLog.i("TissueRenderer", localStringBuilder.toString());
      this.mEventListener.onWebViewEvent("onAppEnterForeground", ((JSONObject)localObject).toString(), 0);
    }
  }
  
  public void onStop()
  {
    FlutterView localFlutterView = this.flutterView;
    if (localFlutterView != null) {
      localFlutterView.onStop();
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
  
  public boolean operatePendantAd(String paramString, PendantAdInfo paramPendantAdInfo)
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
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showToastView toastView=");
      localStringBuilder.append(this.toastView);
      QMLog.d("TissueRenderer", localStringBuilder.toString());
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
    Object localObject = this.mMiniAppContext;
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
    return false;
  }
  
  public void updateToastMsg(String paramString)
  {
    if (QMLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateToastMsg toastView=");
      ((StringBuilder)localObject).append(this.toastView);
      QMLog.d("TissueRenderer", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.toastView;
    if (localObject == null) {
      return;
    }
    ((ToastView)localObject).updateMsg(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.page.tissue.TissuePageContainer
 * JD-Core Version:    0.7.0.1
 */