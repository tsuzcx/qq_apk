package com.tencent.mobileqq.mini.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import anni;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.AppMode;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.app.IAppUIProxy;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.app.MiniAppStateManager.MiniAppStateMsg;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class AppLoadingUI
  implements Handler.Callback, View.OnClickListener
{
  private static final String TAG = "miniapp-start_AppLoadingUI";
  final int WHAT_LOAD_MINIAPP_ICON_SUCCESS = 7;
  private boolean apkgInited;
  private MiniAppConfig appConfig;
  private boolean isForeground;
  private WeakReference<Activity> mActivity;
  private Bundle mBundle;
  private ImageView mCloseView;
  private ViewGroup mContentLayout;
  private View mDeveloperInfoContainer;
  private TextView mDeveloperInfoDesc;
  private TextView mDeveloperQualifications;
  boolean mIsBaseLibVersionMatch = false;
  private ImageView mLogoView;
  private ImageView mMoreView;
  private TextView mNameView;
  private ProgressBar mProgressBar;
  private ViewGroup mRootView;
  private View mStatusBar;
  private Handler mainHandler = new Handler(Looper.getMainLooper());
  private RelativeLayout rightContainer;
  Handler uiHandler;
  
  public AppLoadingUI(Activity paramActivity)
  {
    this.mActivity = new WeakReference(paramActivity);
  }
  
  private void callActivityBackPressed()
  {
    Activity localActivity = getActivity();
    if ((localActivity != null) && ((localActivity instanceof AppBrandUI))) {
      ((AppBrandUI)localActivity).doOnBackPressedWithOutReport();
    }
  }
  
  private void checkBaseLibVersionMatch()
  {
    if (this.mIsBaseLibVersionMatch) {
      return;
    }
    String str1;
    String str2;
    boolean bool;
    if ((this.appConfig != null) && (this.appConfig.config != null) && (this.appConfig.baseLibInfo != null))
    {
      str1 = this.appConfig.config.baselibMiniVersion;
      str2 = this.appConfig.baseLibInfo.baseLibVersion;
      if (QLog.isColorLevel()) {
        QLog.i("miniapp-start", 1, "checkBaseLibVersionMatch current:" + this.appConfig.baseLibInfo.baseLibVersion + ",need:" + str1);
      }
      if (TextUtils.isEmpty(str2)) {
        bool = true;
      }
    }
    for (;;)
    {
      if (bool)
      {
        String str3 = StorageUtil.getPreference().getString("version", "1.17.0.00206");
        if (QLog.isColorLevel()) {
          QLog.i("miniapp-start", 1, "checkBaseLibVersionMatch 需要升级 sp MaxVersion:" + str3);
        }
        if ((!TextUtils.isEmpty(str3)) && (!BaseLibInfo.needUpdateVersion(str1, str3)))
        {
          this.mIsBaseLibVersionMatch = true;
          ThreadManager.excute(new AppLoadingUI.9(this), 16, null, false);
          return;
          if (!TextUtils.isEmpty(str1)) {
            bool = BaseLibInfo.needUpdateVersion(str1, str2);
          }
        }
        else
        {
          ThreadManager.excute(new AppLoadingUI.10(this, str2), 16, null, false);
        }
      }
      else
      {
        this.mIsBaseLibVersionMatch = true;
        AppLoaderFactory.getAppLoaderManager().loadApkgByConfig(this.appConfig);
        return;
      }
      bool = false;
    }
  }
  
  private void cleanAnimation()
  {
    this.mRootView.setVisibility(0);
    this.mRootView.clearAnimation();
    this.mLogoView.clearAnimation();
    this.mNameView.clearAnimation();
    this.mProgressBar.clearAnimation();
  }
  
  private void doRequestByAppid(String paramString1, String paramString2, String paramString3, LaunchParam paramLaunchParam)
  {
    MiniAppCmdUtil.getInstance().getAppInfoById(null, paramString1, paramString2, paramString3, new AppLoadingUI.7(this, paramLaunchParam));
  }
  
  private void doRequestByLink(String paramString1, int paramInt, String paramString2, LaunchParam paramLaunchParam)
  {
    MiniAppCmdUtil.getInstance().getAppInfoByLink(paramString1, paramInt, new AppLoadingUI.8(this, paramLaunchParam));
  }
  
  private void initApkgByConfig()
  {
    if (this.appConfig == null) {
      return;
    }
    if (this.appConfig.baseLibInfo == null) {
      this.appConfig.baseLibInfo = AppLoaderFactory.getAppLoaderManager().getBaseLibInfo();
    }
    checkBaseLibVersionMatch();
  }
  
  private boolean isInterLoadingMode()
  {
    return (this.appConfig != null) && (this.appConfig.config != null) && (this.appConfig.config.appMode != null) && (this.appConfig.config.appMode.isInterLoading);
  }
  
  private void setSlideInAnimation()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject1 = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject1).setDuration(500L);
    ((Animation)localObject1).setInterpolator(new LinearInterpolator());
    Object localObject2 = new TranslateAnimation(0.0F, 0.0F, 40.0F, 0.0F);
    ((Animation)localObject2).setDuration(300L);
    localAnimationSet.addAnimation((Animation)localObject1);
    localAnimationSet.addAnimation((Animation)localObject2);
    localAnimationSet.setInterpolator(new LinearInterpolator());
    this.mLogoView.setVisibility(0);
    this.mLogoView.setAnimation(localAnimationSet);
    localAnimationSet = new AnimationSet(true);
    localObject1 = new TranslateAnimation(0.0F, 0.0F, 40.0F, 0.0F);
    ((Animation)localObject1).setDuration(300L);
    localObject2 = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject2).setDuration(800L);
    ((Animation)localObject2).setInterpolator(new DecelerateInterpolator());
    localAnimationSet.addAnimation((Animation)localObject1);
    localAnimationSet.addAnimation((Animation)localObject2);
    ((Animation)localObject1).setAnimationListener(new AppLoadingUI.3(this));
    this.mainHandler.postDelayed(new AppLoadingUI.4(this, localAnimationSet), 200L);
  }
  
  private void setSlideOutAnimation()
  {
    cleanAnimation();
    Object localObject1 = new AnimationSet(true);
    Object localObject2 = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject2).setDuration(300L);
    ((Animation)localObject2).setInterpolator(new LinearInterpolator());
    Object localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -80.0F);
    ((Animation)localObject3).setDuration(200L);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
    ((AnimationSet)localObject1).setInterpolator(new LinearInterpolator());
    ((AnimationSet)localObject1).setFillAfter(true);
    this.mLogoView.setVisibility(0);
    this.mLogoView.setAnimation((Animation)localObject1);
    localObject1 = new AnimationSet(true);
    localObject2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -60.0F);
    ((Animation)localObject2).setDuration(200L);
    localObject3 = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject3).setDuration(300L);
    ((Animation)localObject3).setInterpolator(new DecelerateInterpolator());
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
    ((AnimationSet)localObject1).setFillAfter(true);
    this.mainHandler.postDelayed(new AppLoadingUI.5(this, (AnimationSet)localObject1), 100L);
    this.mProgressBar.setVisibility(8);
    new AnimationSet(true);
    localObject1 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject1).setDuration(400L);
    ((AlphaAnimation)localObject1).setAnimationListener(new AppLoadingUI.6(this));
    this.mRootView.setAnimation((Animation)localObject1);
  }
  
  private void showUpdateMobileQQDialog()
  {
    localObject1 = "";
    try
    {
      Object localObject3 = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_upgrade_url", "https://m.q.qq.com/upgrade/{appid}");
      Object localObject2 = "";
      Object localObject4 = localObject2;
      localObject1 = localObject3;
      if (this.appConfig != null)
      {
        localObject4 = localObject2;
        localObject1 = localObject3;
        if (this.appConfig.config != null)
        {
          localObject1 = localObject3;
          localObject4 = this.appConfig.config.appId;
        }
      }
      localObject2 = localObject3;
      localObject1 = localObject3;
      if (((String)localObject3).contains("{appid}"))
      {
        localObject2 = localObject3;
        localObject1 = localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject1 = localObject3;
          localObject2 = ((String)localObject3).replace("{appid}", (CharSequence)localObject4);
        }
      }
      localObject1 = localObject2;
      QLog.i("miniapp-start", 1, "jump to upgrate page:" + (String)localObject2);
      localObject1 = localObject2;
      MiniProgramLpReportDC04239.reportPageView(this.appConfig, "0", null, "load_fail", "qq_version_limit_fail");
      localObject1 = localObject2;
      MiniAppReportManager2.reportPageView("2launch_fail", "qq_version_limit_fail", null, this.appConfig);
      localObject1 = localObject2;
      localObject3 = new Intent(getActivity(), QQBrowserActivity.class);
      localObject1 = localObject2;
      ((Intent)localObject3).putExtra("hide_more_button", true);
      localObject1 = localObject2;
      ((Intent)localObject3).putExtra("hide_operation_bar", true);
      localObject1 = localObject2;
      ((Intent)localObject3).putExtra("url", (String)localObject2);
      localObject1 = localObject2;
      getActivity().startActivity((Intent)localObject3);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("miniapp-start", 1, "jump to upgrate page exception! url=" + (String)localObject1, localThrowable);
      }
    }
    AppBrandTask.runTaskOnUiThreadDelay(new AppLoadingUI.12(this), 1000L);
  }
  
  private void updateBaseLib(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("miniapp-start", 1, "updateBaseLib start.");
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("version", paramString);
    AppBrandProxy.g().sendCmd("cmd_update_baselib", localBundle, new AppLoadingUI.11(this));
  }
  
  public void doOnBackPressed(boolean paramBoolean)
  {
    if (this.appConfig != null)
    {
      if (paramBoolean) {
        MiniAppReportManager2.reportPageView("2back_key", "loading_page", null, this.appConfig);
      }
      MiniAppStateManager.MiniAppStateMsg localMiniAppStateMsg = new MiniAppStateManager.MiniAppStateMsg(-1, this.appConfig.config.appId, this.appConfig.config.verType, null);
      MiniAppStateManager.getInstance().notifyChange(localMiniAppStateMsg);
    }
  }
  
  public Activity getActivity()
  {
    if (this.mActivity != null) {
      return (Activity)this.mActivity.get();
    }
    return null;
  }
  
  public Bundle getArgumentBundle()
  {
    return this.mBundle;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (URLDrawable)paramMessage.obj;
      this.mLogoView.setImageDrawable(paramMessage);
      continue;
      initApkgByConfig();
      continue;
      this.uiHandler.post(new AppLoadingUI.13(this, paramMessage));
      continue;
      this.uiHandler.post(new AppLoadingUI.14(this, paramMessage));
      continue;
      QLog.i("miniapp-start_AppLoadingUI", 1, "MSG_WHAT_APP_EVENT_APPROUTE_DONE");
      AppLoaderFactory.getAppUIProxy().completeLoading((BaseActivity)getActivity());
    }
  }
  
  public void initData(Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (paramBundle = (MiniAppConfig)paramBundle.getParcelable("CONFIG");; paramBundle = null)
    {
      this.appConfig = paramBundle;
      if ((this.appConfig != null) && (this.appConfig.launchParam != null) && (this.appConfig.config != null)) {
        break;
      }
      QLog.e("miniapp-start", 1, "LoadingFragment 小程序参数错误！");
      if (getActivity() != null) {
        Toast.makeText(getActivity(), anni.a(2131699426), 1).show();
      }
      callActivityBackPressed();
      return;
    }
    this.mIsBaseLibVersionMatch = false;
    this.mNameView.setText(this.appConfig.config.name);
    if (this.mDeveloperInfoContainer != null)
    {
      if ((this.mDeveloperInfoDesc == null) || (TextUtils.isEmpty(this.appConfig.config.developerDesc))) {
        break label330;
      }
      this.mDeveloperInfoContainer.setVisibility(0);
      this.mDeveloperInfoDesc.setText(anni.a(2131699428) + this.appConfig.config.developerDesc + anni.a(2131699430));
    }
    while ((this.mDeveloperQualifications != null) && (this.appConfig.config.qualifications != null) && (this.appConfig.config.qualifications.size() > 0))
    {
      this.mDeveloperQualifications.setVisibility(0);
      int i = 0;
      for (;;)
      {
        if (i < this.appConfig.config.qualifications.size())
        {
          paramBundle = (String)this.appConfig.config.qualifications.get(i);
          if (!TextUtils.isEmpty(paramBundle))
          {
            this.mDeveloperQualifications.append(paramBundle);
            if (i != this.appConfig.config.qualifications.size() - 1) {
              this.mDeveloperQualifications.append("\n");
            }
          }
          i += 1;
          continue;
          label330:
          this.mDeveloperInfoContainer.setVisibility(8);
          QLog.e("miniapp-start_AppLoadingUI", 1, "onViewCreated, developerDesc : " + this.appConfig.config.developerDesc);
          break;
        }
      }
      if ((this.mDeveloperInfoContainer != null) && (this.mDeveloperInfoContainer.getVisibility() == 8))
      {
        paramBundle = (RelativeLayout.LayoutParams)this.mDeveloperQualifications.getLayoutParams();
        paramBundle.bottomMargin = DisplayUtil.dip2px(getActivity(), 12.0F);
        this.mDeveloperQualifications.setLayoutParams(paramBundle);
      }
    }
    ThreadManagerV2.excute(new AppLoadingUI.1(this), 16, null, false);
    AppLoaderFactory.getAppLoaderManager().addListener(this.uiHandler);
    this.appConfig.baseLibInfo = AppLoaderFactory.getAppLoaderManager().getBaseLibInfo();
    this.apkgInited = true;
    if (this.appConfig.isShortcutFakeApp()) {
      doRequestByAppid(this.appConfig.config.appId, "", "", this.appConfig.launchParam);
    }
    for (;;)
    {
      AppLoaderFactory.getAppLoaderManager().start(getActivity());
      return;
      if (this.appConfig.isFromShowInfo())
      {
        if (this.appConfig.link != null) {
          doRequestByLink(this.appConfig.link, this.appConfig.linkType, this.appConfig.config.getVerTypeStr(), this.appConfig.launchParam);
        } else {
          doRequestByAppid(this.appConfig.config.appId, this.appConfig.entryPath, this.appConfig.config.getVerTypeStr(), this.appConfig.launchParam);
        }
      }
      else {
        initApkgByConfig();
      }
    }
  }
  
  public void initUI(ViewGroup paramViewGroup)
  {
    this.mRootView = paramViewGroup;
    this.mStatusBar = paramViewGroup.findViewById(2131377811);
    new ImmersionBar(getActivity(), 0, this.mStatusBar);
    this.uiHandler = new Handler(this);
    this.rightContainer = ((RelativeLayout)paramViewGroup.findViewById(2131364995));
    Object localObject = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getActivity(), 80.0F), DisplayUtil.dip2px(getActivity(), 30.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject).topMargin = (DisplayUtil.dip2px(paramViewGroup.getContext(), 9.0F) + ImmersiveUtils.getStatusBarHeight(getActivity()));
    ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.dip2px(paramViewGroup.getContext(), 12.5F);
    this.rightContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mMoreView = ((ImageView)paramViewGroup.findViewById(2131363832));
    this.mCloseView = ((ImageView)paramViewGroup.findViewById(2131363741));
    if (!TextUtils.isEmpty(MiniAppGlobal.CAPSULE_CLOSE_URL))
    {
      localObject = MiniAppUtils.getIcon(getActivity(), MiniAppGlobal.CAPSULE_CLOSE_URL, true, 2130841229, 40, 30);
      this.mCloseView.setImageDrawable((Drawable)localObject);
    }
    this.mProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131369524));
    this.mContentLayout = ((ViewGroup)paramViewGroup.findViewById(2131365016));
    this.mNameView = ((TextView)paramViewGroup.findViewById(2131367323));
    this.mLogoView = ((ImageView)paramViewGroup.findViewById(2131370305));
    this.mDeveloperInfoContainer = paramViewGroup.findViewById(2131365415);
    this.mDeveloperInfoDesc = ((TextView)paramViewGroup.findViewById(2131365416));
    this.mDeveloperQualifications = ((TextView)paramViewGroup.findViewById(2131365417));
    this.mMoreView.setOnClickListener(this);
    this.mCloseView.setOnClickListener(this);
  }
  
  public boolean isForeground()
  {
    return this.isForeground;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363741)
    {
      MiniReportManager.reportEventType(this.appConfig, 1026, "1");
      MiniProgramLpReportDC04239.reportPageView(this.appConfig, "0", null, "close", "loading_page");
      MiniAppReportManager2.reportPageView("2close", "loading_page", null, this.appConfig);
      callActivityBackPressed();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() != 2131363832) {}
    }
  }
  
  public void onDestroy()
  {
    QLog.d("miniapp-start", 1, "LoadingFragment onDestroy...");
    AppLoaderFactory.getAppLoaderManager().removeListner(this.uiHandler);
  }
  
  public void onResume()
  {
    this.isForeground = true;
    View localView;
    if (this.mStatusBar != null)
    {
      boolean bool = ImmersiveUtils.a(true, getActivity().getWindow());
      localView = this.mStatusBar;
      if (!bool) {
        break label131;
      }
    }
    label131:
    for (int i = 0;; i = -3684405)
    {
      localView.setBackgroundColor(i);
      cleanAnimation();
      if (!isInterLoadingMode()) {
        break label147;
      }
      this.mLogoView.setVisibility(8);
      this.mNameView.setVisibility(4);
      this.mProgressBar.setVisibility(0);
      if ((this.appConfig == null) || (this.appConfig.config == null) || (this.appConfig.config.appMode == null) || (!this.appConfig.config.appMode.closeTopRightCapsule)) {
        break;
      }
      this.rightContainer.setVisibility(4);
      return;
    }
    this.rightContainer.setVisibility(0);
    return;
    label147:
    this.rightContainer.setVisibility(0);
    this.mLogoView.setVisibility(4);
    this.mNameView.setVisibility(4);
    this.mProgressBar.setVisibility(4);
    this.mainHandler.postDelayed(new AppLoadingUI.2(this), 250L);
  }
  
  public void onStop()
  {
    this.isForeground = false;
    if (isInterLoadingMode())
    {
      this.mRootView.setVisibility(8);
      return;
    }
    setSlideOutAnimation();
  }
  
  public void setArgumentBundle(Bundle paramBundle)
  {
    this.mBundle = paramBundle;
    initData(this.mBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppLoadingUI
 * JD-Core Version:    0.7.0.1
 */