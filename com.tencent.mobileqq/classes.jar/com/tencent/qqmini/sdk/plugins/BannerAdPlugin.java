package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.MiniAdPosInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.IGetAdPosInfo;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.AdUtil;
import com.tencent.qqmini.sdk.utils.BannerAdPosInfo;
import com.tencent.qqmini.sdk.utils.MiniSDKConst.AdConst;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class BannerAdPlugin
  extends BaseJsPlugin
  implements IGetAdPosInfo
{
  private static final HashMap<Integer, String> AD_ERROR_MSG = MiniSDKConst.AdConst.CODE_MSG_MAP;
  public static final String API_AD_CREATE_BANNER_AD = "createBannerAd";
  public static final String API_AD_OPERATE_BANNER_AD = "operateBannerAd";
  public static final String API_AD_UPDATE_BANNER_AD_SIZE = "updateBannerAdSize";
  public static final String EVENT_BANNER_AD_SHOW_DONE = "onBannerAdShowDone";
  public static final String EVENT_BANNER_AD_STATE_CHANGE = "onBannerAdStateChange";
  private static final String TAG = "BannerAdPlugin";
  private FrameLayout mBannerAdContainer;
  private BannerAdPosInfo mBannerAdPosInfo;
  private AdProxy.AbsBannerAdView mBannerAdView;
  private Bundle mCreateViewExt;
  private RequestEvent mCreateViewReq;
  private float mGameDensity = -1.0F;
  private int mGameHeight = 0;
  private int mGameWidth = 0;
  private boolean mHasNewAd = false;
  private long mRecordShowedTime;
  private long mShowBannerAdStartTime;
  private Runnable refreshAdRunnable = new BannerAdPlugin.5(this);
  
  private void bannerErrorStateCallbackDelay(RequestEvent paramRequestEvent, int paramInt1, String paramString, int paramInt2)
  {
    AppBrandTask.runTaskOnUiThreadDelay(new BannerAdPlugin.10(this, paramString, paramInt1, paramRequestEvent), paramInt2);
  }
  
  private boolean checkShowValid()
  {
    Object localObject = this.mBannerAdView;
    if ((localObject != null) && (((AdProxy.AbsBannerAdView)localObject).getView() != null))
    {
      localObject = this.mBannerAdPosInfo;
      if (localObject != null)
      {
        if (!((BannerAdPosInfo)localObject).isValid())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("showBannerAd error, adPosInfo is invalid.");
          ((StringBuilder)localObject).append(this.mBannerAdPosInfo);
          QMLog.e("BannerAdPlugin", ((StringBuilder)localObject).toString());
          return false;
        }
        if ((this.mMiniAppContext != null) && (this.mMiniAppContext.getAttachedActivity() != null)) {
          return true;
        }
        QMLog.e("BannerAdPlugin", "showBannerAd error, mGdtBannerView == null");
        return false;
      }
    }
    QMLog.e("BannerAdPlugin", "showBannerAd error, data is null");
    return false;
  }
  
  private void createBannerAdView(RequestEvent paramRequestEvent, String paramString, BannerAdPosInfo paramBannerAdPosInfo, Bundle paramBundle)
  {
    AppBrandTask.runTaskOnUiThread(new BannerAdPlugin.1(this, paramRequestEvent, paramString, paramBannerAdPosInfo, paramBundle));
  }
  
  private void createRefreshAdView(RequestEvent paramRequestEvent, String paramString, BannerAdPosInfo paramBannerAdPosInfo, Bundle paramBundle)
  {
    try
    {
      QMLog.i("BannerAdPlugin", "refresh : start create bannerAd view.");
      AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
      if ((localAdProxy != null) && (this.mBannerAdPosInfo != null))
      {
        Activity localActivity = this.mMiniAppContext.getAttachedActivity();
        if (localActivity == null)
        {
          QMLog.i("BannerAdPlugin", "start create, activity null");
          bannerErrorStateCallbackDelay(paramRequestEvent, 1003, (String)AD_ERROR_MSG.get(Integer.valueOf(1003)), 300);
          return;
        }
        this.mBannerAdView = localAdProxy.createBannerAdView(localActivity, paramString, paramBannerAdPosInfo.mAdUnitId, Math.round(this.mBannerAdPosInfo.mAdRealWidth * this.mGameDensity), Math.round(this.mBannerAdPosInfo.mAdRealHeight * this.mGameDensity), new BannerAdPlugin.7(this, paramRequestEvent, paramBannerAdPosInfo), paramBundle, this.mMiniAppContext, this);
        paramRequestEvent = this.mBannerAdView;
        if (paramRequestEvent != null) {
          try
          {
            this.mBannerAdView.loadAD();
          }
          catch (Throwable paramRequestEvent)
          {
            QMLog.i("BannerAdPlugin", "loadAd error", paramRequestEvent);
          }
        }
        return;
      }
      QMLog.i("BannerAdPlugin", "start create, null");
      return;
    }
    finally {}
  }
  
  private void destroyBannerAd()
  {
    try
    {
      if (this.mBannerAdContainer != null) {
        this.mBannerAdContainer.removeAllViews();
      }
      if (this.mBannerAdView != null)
      {
        this.mBannerAdView.destroy(this.mMiniAppContext.getAttachedActivity());
        this.mBannerAdView = null;
      }
      this.mBannerAdContainer = null;
      this.mBannerAdPosInfo = null;
      this.mRecordShowedTime = 0L;
      ThreadManager.getUIHandler().removeCallbacks(this.refreshAdRunnable);
      return;
    }
    finally {}
  }
  
  private void doRefresh()
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new BannerAdPlugin.6(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean doRefreshBannerView()
  {
    this.mBannerAdContainer.removeAllViews();
    Object localObject = this.mBannerAdView;
    if ((localObject != null) && (((AdProxy.AbsBannerAdView)localObject).getView() != null))
    {
      localObject = new FrameLayout.LayoutParams(gameDpTopx(this.mBannerAdPosInfo.mAdRealWidth), gameDpTopx(this.mBannerAdPosInfo.mAdRealHeight));
      ((FrameLayout.LayoutParams)localObject).leftMargin = gameDpTopx(this.mBannerAdPosInfo.mAdLeft);
      ((FrameLayout.LayoutParams)localObject).topMargin = gameDpTopx(this.mBannerAdPosInfo.mAdTop);
      this.mBannerAdContainer.addView(this.mBannerAdView.getView(), (ViewGroup.LayoutParams)localObject);
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("state", "refresh");
        informJs(this.mCreateViewReq, (JSONObject)localObject, "onBannerAdStateChange");
      }
      catch (JSONException localJSONException)
      {
        QMLog.e("BannerAdPlugin", "informJs refresh success", localJSONException);
      }
      String str = this.mBannerAdView.getReportUrl();
      if ((this.mHasNewAd) && (this.mBannerAdPosInfo != null) && (!TextUtils.isEmpty(str))) {
        this.mBannerAdView.onExposure();
      }
      this.mHasNewAd = false;
      return true;
    }
    QMLog.e("BannerAdPlugin", "showBannerAd error, mGdtBannerView is null");
    return false;
  }
  
  private boolean doUpdateBannerView()
  {
    this.mBannerAdContainer.removeAllViews();
    Object localObject = this.mBannerAdView;
    if ((localObject != null) && (((AdProxy.AbsBannerAdView)localObject).getView() != null))
    {
      localObject = new FrameLayout.LayoutParams(gameDpTopx(this.mBannerAdPosInfo.mAdRealWidth), gameDpTopx(this.mBannerAdPosInfo.mAdRealHeight));
      ((FrameLayout.LayoutParams)localObject).leftMargin = gameDpTopx(this.mBannerAdPosInfo.mAdLeft);
      ((FrameLayout.LayoutParams)localObject).topMargin = gameDpTopx(this.mBannerAdPosInfo.mAdTop);
      this.mBannerAdContainer.addView(this.mBannerAdView.getView(), (ViewGroup.LayoutParams)localObject);
      this.mBannerAdContainer.setVisibility(0);
      localObject = this.mBannerAdView.getReportUrl();
      if ((this.mHasNewAd) && (this.mBannerAdPosInfo != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        this.mBannerAdView.onExposure();
      }
      this.mHasNewAd = false;
      return true;
    }
    QMLog.e("BannerAdPlugin", "showBannerAd error, mGdtBannerView is null");
    return false;
  }
  
  private int gameDpTopx(float paramFloat)
  {
    return Math.round(paramFloat * this.mGameDensity);
  }
  
  private float getDensity(float paramFloat)
  {
    float f = this.mGameDensity;
    if (f > 0.0F) {
      paramFloat = f;
    }
    return paramFloat;
  }
  
  @NotNull
  private String getEntryPathFromAppConfig(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo.launchParam.entryPath != null) {
      return paramMiniAppInfo.launchParam.entryPath;
    }
    return "";
  }
  
  private int getScreenHeight(int paramInt)
  {
    int i = this.mGameHeight;
    if (i > 0) {
      paramInt = i;
    }
    return paramInt;
  }
  
  private int getScreenWidth(int paramInt)
  {
    int i = this.mGameWidth;
    if (i > 0) {
      paramInt = i;
    }
    return paramInt;
  }
  
  @NotNull
  private String getViaFromAppConfig(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.via != null)) {
      return paramMiniAppInfo.via;
    }
    return "";
  }
  
  private void informJs(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString)
  {
    paramRequestEvent.jsService.evaluateSubscribeJS(paramString, paramJSONObject.toString(), 0);
  }
  
  private boolean isAdParamValid(BannerAdPosInfo paramBannerAdPosInfo, String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramBannerAdPosInfo.mAdUnitId));
  }
  
  private boolean makeSureContainerAdded()
  {
    Object localObject = this.mBannerAdContainer;
    if ((localObject != null) && (((FrameLayout)localObject).getParent() != null)) {
      return true;
    }
    localObject = (ViewGroup)this.mMiniAppContext.getAttachedActivity().getWindow().getDecorView();
    if (localObject == null)
    {
      QMLog.e("BannerAdPlugin", "makeSureContainerAdded, root view is null");
      return false;
    }
    if (this.mBannerAdContainer == null) {
      this.mBannerAdContainer = new FrameLayout(this.mMiniAppContext.getAttachedActivity());
    }
    if ((localObject instanceof FrameLayout))
    {
      ((ViewGroup)localObject).addView(this.mBannerAdContainer, new FrameLayout.LayoutParams(-1, -1));
      return true;
    }
    if ((localObject instanceof RelativeLayout)) {
      ((ViewGroup)localObject).addView(this.mBannerAdContainer, new RelativeLayout.LayoutParams(-1, -1));
    }
    return true;
  }
  
  private boolean refreshBannerAdView()
  {
    if (!checkShowValid()) {
      return false;
    }
    return doRefreshBannerView();
  }
  
  private void refreshViewCountTimeDown()
  {
    try
    {
      if (this.mBannerAdContainer.getVisibility() == 0)
      {
        this.mShowBannerAdStartTime = System.currentTimeMillis();
        long l = this.mBannerAdPosInfo.mAdIntervals * 1000L - this.mRecordShowedTime;
        this.mRecordShowedTime = 0L;
        if (l > 0L)
        {
          ThreadManager.getUIHandler().removeCallbacks(this.refreshAdRunnable);
          ThreadManager.getUIHandler().postDelayed(this.refreshAdRunnable, l);
        }
        else
        {
          doRefresh();
        }
      }
      return;
    }
    finally {}
  }
  
  private void reportBannerAd(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportBannerAd reportUrl = ");
    localStringBuilder.append(paramString);
    QMLog.i("BannerAdPlugin", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      if (!URLUtil.isNetworkUrl(paramString)) {
        return;
      }
      ThreadManager.executeOnNetworkIOThreadPool(new BannerAdPlugin.8(this, paramString));
    }
  }
  
  private boolean showBannerAd()
  {
    try
    {
      boolean bool = checkShowValid();
      if (!bool) {
        return false;
      }
      makeSureContainerAdded();
      if ((!this.mHasNewAd) && (this.mBannerAdContainer.getChildCount() > 0))
      {
        this.mBannerAdContainer.setVisibility(0);
        return true;
      }
      this.mRecordShowedTime = 0L;
      bool = doUpdateBannerView();
      return bool;
    }
    finally {}
  }
  
  private void updateBannerAdPosition(RequestEvent paramRequestEvent, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != -1) && (this.mIsMiniGame))
    {
      BannerAdPosInfo localBannerAdPosInfo = this.mBannerAdPosInfo;
      if (localBannerAdPosInfo != null)
      {
        int i = 1;
        if (paramInt1 != 1) {
          if (paramInt1 != 2) {
            if ((paramInt1 != 3) || (localBannerAdPosInfo.mAdRealWidth != paramInt2)) {
              break label83;
            }
          }
        }
        while (localBannerAdPosInfo.mAdLeft == paramInt2)
        {
          do
          {
            i = 0;
            break;
          } while (localBannerAdPosInfo.mAdTop == paramInt2);
          break;
        }
        label83:
        if (i == 0)
        {
          if (QMLog.isColorLevel()) {
            QMLog.i("BannerAdPlugin", "updateBannerAd no need to resize");
          }
          return;
        }
      }
      AppBrandTask.runTaskOnUiThread(new BannerAdPlugin.9(this, paramInt1, paramInt2, paramRequestEvent));
    }
  }
  
  private void updateBannerSize(RequestEvent paramRequestEvent)
  {
    int j;
    label359:
    do
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
        boolean bool = localJSONObject.has("left");
        j = 1;
        int k = 1;
        if (bool)
        {
          i = localJSONObject.getInt("left");
          continue;
        }
        if (localJSONObject.has("top"))
        {
          j = 2;
          i = localJSONObject.getInt("top");
          continue;
        }
        if (!localJSONObject.has("width")) {
          break label359;
        }
        float f2 = ViewUtils.getDensity();
        int n = ViewUtils.getScreenWidth();
        int m = ViewUtils.getScreenHeight();
        BannerAdPosInfo localBannerAdPosInfo = this.mBannerAdPosInfo;
        Activity localActivity = this.mMiniAppContext.getAttachedActivity();
        float f1 = f2;
        j = n;
        i = m;
        if (localActivity != null)
        {
          k = MiniAppEnv.g().getContext().getResources().getConfiguration().orientation;
          initActivitySize(localActivity);
          f1 = getDensity(f2);
          j = getScreenWidth(n);
          i = getScreenHeight(m);
        }
        m = localJSONObject.getInt("width");
        i = BannerAdPosInfo.calculateLegalWidth(m, k, f1, j, i);
        if ((localBannerAdPosInfo != null) && (m != localBannerAdPosInfo.mAdWidth) && (i == localBannerAdPosInfo.mAdRealWidth))
        {
          localBannerAdPosInfo.mAdWidth = m;
          try
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("state", "resize");
            localJSONObject.put("width", localBannerAdPosInfo.mAdRealWidth);
            localJSONObject.put("height", localBannerAdPosInfo.mAdRealHeight);
            informJs(paramRequestEvent, localJSONObject, "onBannerAdStateChange");
            return;
          }
          catch (JSONException paramRequestEvent)
          {
            QMLog.e("BannerAdPlugin", "updateBannerAd informJs error", paramRequestEvent);
            return;
          }
          if (i < 0)
          {
            bannerErrorStateCallbackDelay(paramRequestEvent, 1003, (String)AD_ERROR_MSG.get(Integer.valueOf(1003)), 0);
            return;
          }
          updateBannerAdPosition(paramRequestEvent, j, i);
          return;
        }
      }
      catch (JSONException paramRequestEvent)
      {
        QMLog.e("BannerAdPlugin", "handle updateBannerAdSize parse json error", paramRequestEvent);
        return;
      }
      j = 3;
      continue;
      int i = -1;
      j = -1;
    } while (j != -1);
  }
  
  @JsEvent({"createBannerAd"})
  public String createBannerAd(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        QMLog.i("BannerAdPlugin", "receive createBannerAd event");
        try
        {
          localObject1 = BannerAdPosInfo.parseBannerAdPosInfoFromJson(paramRequestEvent.jsonParams);
          if (localObject1 == null)
          {
            bannerErrorStateCallbackDelay(paramRequestEvent, 1001, (String)AD_ERROR_MSG.get(Integer.valueOf(1001)), 300);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("handle createBannerAd error params, ");
            ((StringBuilder)localObject1).append(paramRequestEvent.jsonParams);
            QMLog.i("BannerAdPlugin", ((StringBuilder)localObject1).toString());
            return "";
          }
          String str2 = LoginManager.getInstance().getAccount();
          int k = 1;
          float f2 = ViewUtils.getDensity();
          int n = ViewUtils.getScreenWidth();
          int m = ViewUtils.getScreenHeight();
          String str1 = this.mApkgInfo.appId;
          Object localObject2 = this.mMiniAppContext.getAttachedActivity();
          float f1 = f2;
          int j = n;
          i = m;
          if (localObject2 != null)
          {
            k = MiniAppEnv.g().getContext().getResources().getConfiguration().orientation;
            initActivitySize((Activity)localObject2);
            f1 = getDensity(f2);
            j = getScreenWidth(n);
            i = getScreenHeight(m);
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handle createBannerAd appId = ");
          ((StringBuilder)localObject2).append(str1);
          ((StringBuilder)localObject2).append(", posid = ");
          ((StringBuilder)localObject2).append(((BannerAdPosInfo)localObject1).mAdUnitId);
          QMLog.i("BannerAdPlugin", ((StringBuilder)localObject2).toString());
          if (isAdParamValid((BannerAdPosInfo)localObject1, str1))
          {
            bannerErrorStateCallbackDelay(paramRequestEvent, 1001, (String)AD_ERROR_MSG.get(Integer.valueOf(1001)), 300);
            return "";
          }
          BannerAdPosInfo localBannerAdPosInfo = BannerAdPosInfo.buildFormatInfo((BannerAdPosInfo)localObject1, k, f1, j, i);
          if ((localBannerAdPosInfo != null) && (localBannerAdPosInfo.isValid()))
          {
            this.mBannerAdPosInfo = localBannerAdPosInfo;
            String str3 = AdUtil.getSpAdGdtCookie(0);
            Object localObject4 = this.mMiniAppInfo;
            localObject1 = "";
            localObject2 = "";
            localObject3 = "";
            if (localObject4 != null)
            {
              localObject1 = getEntryPathFromAppConfig((MiniAppInfo)localObject4);
              localObject2 = ((MiniAppInfo)localObject4).launchParam.reportData;
              localObject3 = String.valueOf(((MiniAppInfo)localObject4).launchParam.scene);
            }
            localObject4 = getViaFromAppConfig((MiniAppInfo)localObject4);
            Bundle localBundle = new Bundle();
            localBundle.putString(AdProxy.KEY_ACCOUNT, str2);
            localBundle.putInt(AdProxy.KEY_AD_TYPE, 0);
            str2 = AdProxy.KEY_ORIENTATION;
            if (k != 2) {
              break label715;
            }
            i = 90;
            localBundle.putInt(str2, i);
            localBundle.putString(AdProxy.KEY_GDT_COOKIE, str3);
            localBundle.putString(AdProxy.KEY_ENTRY_PATH, (String)localObject1);
            localBundle.putString(AdProxy.KEY_REPORT_DATA, (String)localObject2);
            localBundle.putString(AdProxy.KEY_REFER, (String)localObject3);
            localBundle.putString(AdProxy.KEY_VIA, (String)localObject4);
            this.mCreateViewReq = paramRequestEvent;
            this.mCreateViewExt = localBundle;
            createBannerAdView(paramRequestEvent, str1, localBannerAdPosInfo, localBundle);
            continue;
          }
          bannerErrorStateCallbackDelay(paramRequestEvent, 1001, (String)AD_ERROR_MSG.get(Integer.valueOf(1001)), 300);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handle createBannerAd invalid adInfo = ");
          ((StringBuilder)localObject1).append(localBannerAdPosInfo);
          QMLog.i("BannerAdPlugin", ((StringBuilder)localObject1).toString());
          return "";
        }
        catch (Exception localException)
        {
          localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
          if (localObject1 == null) {
            break label721;
          }
        }
        localObject1 = ((JSONObject)localObject1).toString();
        bannerErrorStateCallbackDelay(paramRequestEvent, 1003, (String)AD_ERROR_MSG.get(Integer.valueOf(1003)), 0);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("handle createBannerAd parse json error");
        ((StringBuilder)localObject3).append(paramRequestEvent.jsonParams);
        QMLog.i("BannerAdPlugin", ((StringBuilder)localObject3).toString(), localException);
        if (localObject1 != null) {
          return localObject1;
        }
        return "";
      }
      finally {}
      label715:
      int i = 0;
      continue;
      label721:
      Object localObject1 = "";
    }
  }
  
  public MiniAdPosInfo getPosInfo()
  {
    BannerAdPosInfo localBannerAdPosInfo = this.mBannerAdPosInfo;
    if (localBannerAdPosInfo == null) {
      return null;
    }
    return new MiniAdPosInfo(localBannerAdPosInfo.mAdLeft, this.mBannerAdPosInfo.mAdTop, this.mBannerAdPosInfo.mAdRealWidth, this.mBannerAdPosInfo.mAdRealHeight);
  }
  
  public boolean hideBannerAd()
  {
    try
    {
      if (this.mBannerAdView == null)
      {
        QMLog.e("BannerAdPlugin", "hideBannerAd error, no data");
        return false;
      }
      FrameLayout localFrameLayout = this.mBannerAdContainer;
      if (localFrameLayout == null) {
        return false;
      }
      if ((this.mBannerAdContainer != null) && (this.mBannerAdContainer.getVisibility() == 0))
      {
        this.mBannerAdContainer.setVisibility(8);
        ThreadManager.getUIHandler().removeCallbacks(this.refreshAdRunnable);
        if (this.mBannerAdPosInfo.mAdIntervals != 0) {
          this.mRecordShowedTime += System.currentTimeMillis() - this.mShowBannerAdStartTime;
        }
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public void initActivitySize(Activity paramActivity)
  {
    if ((this.mGameDensity > 0.0F) && (this.mGameWidth > 0) && (this.mGameHeight > 0)) {
      return;
    }
    DisplayMetrics localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17)
    {
      localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    }
    this.mGameDensity = localDisplayMetrics.density;
    this.mGameWidth = localDisplayMetrics.widthPixels;
    this.mGameHeight = localDisplayMetrics.heightPixels;
    paramActivity = new StringBuilder();
    paramActivity.append("density = ");
    paramActivity.append(localDisplayMetrics.density);
    paramActivity.append(", ViewUtils.density = ");
    paramActivity.append(ViewUtils.getDensity());
    paramActivity.append(", screenW = ");
    paramActivity.append(localDisplayMetrics.widthPixels);
    paramActivity.append(", screenH = ");
    paramActivity.append(localDisplayMetrics.heightPixels);
    QMLog.i("BannerAdPlugin", paramActivity.toString());
  }
  
  public void onDestroy()
  {
    if ((this.mBannerAdView != null) && (this.mMiniAppContext != null) && (this.mMiniAppContext.getAttachedActivity() != null)) {
      this.mBannerAdView.destroy(this.mMiniAppContext.getAttachedActivity());
    }
    AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
    if ((localAdProxy != null) && (this.mMiniAppContext != null) && (this.mMiniAppContext.getAttachedActivity() != null)) {
      localAdProxy.destroy(this.mMiniAppContext.getAttachedActivity());
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if ((this.mBannerAdView != null) && (this.mMiniAppContext != null) && (this.mMiniAppContext.getAttachedActivity() != null)) {
      this.mBannerAdView.pause(this.mMiniAppContext.getAttachedActivity());
    }
  }
  
  public void onResume()
  {
    if ((this.mBannerAdView != null) && (this.mMiniAppContext != null) && (this.mMiniAppContext.getAttachedActivity() != null)) {
      this.mBannerAdView.resume(this.mMiniAppContext.getAttachedActivity());
    }
  }
  
  @JsEvent({"operateBannerAd"})
  public String operateBannerAd(RequestEvent paramRequestEvent)
  {
    QMLog.i("BannerAdPlugin", "receive operateBannerAd event");
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).getString("type");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handle operateBannerAd type = ");
      localStringBuilder.append(str);
      QMLog.i("BannerAdPlugin", localStringBuilder.toString());
      if ("show".equals(str))
      {
        AppBrandTask.runTaskOnUiThreadDelay(new BannerAdPlugin.2(this, paramRequestEvent), 300L);
      }
      else if ("hide".equals(str))
      {
        AppBrandTask.runTaskOnUiThread(new BannerAdPlugin.3(this));
      }
      else if ("destroy".equals(str))
      {
        AppBrandTask.runTaskOnUiThread(new BannerAdPlugin.4(this));
      }
      else
      {
        paramRequestEvent = new StringBuilder();
        paramRequestEvent.append("handle operateBannerAd not define type = ");
        paramRequestEvent.append(str);
        QMLog.i("BannerAdPlugin", paramRequestEvent.toString());
      }
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.i("BannerAdPlugin", "handle operateBannerAd parse json error", paramRequestEvent);
    }
    return "";
  }
  
  public boolean updateBannerAdPosition(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        QMLog.i("BannerAdPlugin", "updateBannerAdPosition");
        if (this.mBannerAdView != null)
        {
          if (this.mBannerAdPosInfo != null) {
            break label229;
          }
          continue;
          this.mBannerAdPosInfo.mAdRealWidth = paramInt2;
          this.mBannerAdPosInfo.mAdRealHeight = BannerAdPosInfo.getHeight(paramInt2);
          continue;
          this.mBannerAdPosInfo.mAdTop = paramInt2;
          continue;
          this.mBannerAdPosInfo.mAdLeft = paramInt2;
          if ((this.mBannerAdContainer != null) && (this.mBannerAdContainer.getChildCount() > 0))
          {
            View localView = this.mBannerAdContainer.getChildAt(0);
            FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
            localLayoutParams.leftMargin = gameDpTopx(this.mBannerAdPosInfo.mAdLeft);
            localLayoutParams.topMargin = gameDpTopx(this.mBannerAdPosInfo.mAdTop);
            localLayoutParams.width = gameDpTopx(this.mBannerAdPosInfo.mAdRealWidth);
            localLayoutParams.height = gameDpTopx(this.mBannerAdPosInfo.mAdRealHeight);
            this.mBannerAdView.setSize(gameDpTopx(this.mBannerAdPosInfo.mAdRealWidth), gameDpTopx(this.mBannerAdPosInfo.mAdRealHeight));
            localView.setLayoutParams(localLayoutParams);
          }
          return true;
        }
        QMLog.e("BannerAdPlugin", "updateBannerAdPosition error, no data");
        return false;
      }
      finally {}
      label229:
      if (paramInt1 != 1) {
        if (paramInt1 != 2) {
          if (paramInt1 == 3) {}
        }
      }
    }
  }
  
  @JsEvent({"updateBannerAdSize"})
  public void updateBannerAdSize(RequestEvent paramRequestEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateBannerAdSize ");
    localStringBuilder.append(paramRequestEvent.jsonParams);
    QMLog.i("BannerAdPlugin", localStringBuilder.toString());
    updateBannerSize(paramRequestEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BannerAdPlugin
 * JD-Core Version:    0.7.0.1
 */