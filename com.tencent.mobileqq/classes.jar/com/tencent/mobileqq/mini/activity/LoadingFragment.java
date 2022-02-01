package com.tencent.mobileqq.mini.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import anni;
import awlz;
import awma;
import biau;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.app.IAppUIProxy;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.app.MiniAppStateManager.MiniAppStateMsg;
import com.tencent.mobileqq.mini.appbrand.page.BrandPagePool;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;

public class LoadingFragment
  extends ReportFragment
  implements DialogInterface.OnDismissListener, Handler.Callback, View.OnClickListener
{
  private static final long LOAD_TIMEOUT = 30000L;
  private static final String TAG = "LoadingActivity";
  final int CONF_LOAD_TIME_OUT = 60000;
  final int WHAT_LOAD_MINIAPP_ICON_SUCCESS = 7;
  private boolean apkgInited;
  private MiniAppConfig appConfig;
  private String appid;
  private String entryPath;
  boolean hasLoadApkg;
  private boolean isKill;
  boolean isLoadConf;
  private Bundle mBundle;
  private ImageView mCloseView;
  private View mDeveloperInfoContainer;
  private TextView mDeveloperInfoDesc;
  private EngineChannel mEngineChannel;
  boolean mIsBaseLibVersionMatch = false;
  private ImageView mLogoView;
  private awma mMiniLibLoadListener = new LoadingFragment.2(this);
  private ImageView mMoreView;
  private TextView mNameView;
  private View mRootView = BrandPagePool.g().getLoadingRootView();
  private View mStatusBar;
  private boolean needRetryTbs;
  private RelativeLayout rightContainer;
  private RelativeLayout root;
  Handler uiHandler;
  private biau x5LoadingDialog;
  
  public LoadingFragment()
  {
    initUI(this.mRootView);
  }
  
  private void callActivityBackPressed()
  {
    Activity localActivity = getActivity();
    if ((localActivity != null) && ((localActivity instanceof AppBrandUI))) {
      ((AppBrandUI)localActivity).doOnBackPressed();
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
          ThreadManager.excute(new LoadingFragment.4(this), 16, null, false);
          return;
          if (!TextUtils.isEmpty(str1)) {
            bool = BaseLibInfo.needUpdateVersion(str1, str2);
          }
        }
        else
        {
          ThreadManager.excute(new LoadingFragment.5(this, str2), 16, null, false);
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
  
  private void doRequestByAppid(String paramString1, String paramString2, String paramString3, LaunchParam paramLaunchParam)
  {
    MiniAppCmdUtil.getInstance().getAppInfoById(null, paramString1, paramString2, paramString3, new LoadingFragment.3(this, paramLaunchParam));
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
  
  private void initUI(View paramView)
  {
    this.root = ((RelativeLayout)paramView.findViewById(2131370224));
    this.rightContainer = ((RelativeLayout)paramView.findViewById(2131364995));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(paramView.getContext(), 80.0F), DisplayUtil.dip2px(paramView.getContext(), 30.0F));
    localLayoutParams.addRule(11, -1);
    localLayoutParams.topMargin = (DisplayUtil.dip2px(paramView.getContext(), 9.0F) + ImmersiveUtils.getStatusBarHeight(paramView.getContext()));
    localLayoutParams.rightMargin = DisplayUtil.dip2px(paramView.getContext(), 12.5F);
    this.rightContainer.setLayoutParams(localLayoutParams);
    this.mMoreView = ((ImageView)paramView.findViewById(2131363832));
    this.mCloseView = ((ImageView)paramView.findViewById(2131363741));
    this.mNameView = ((TextView)paramView.findViewById(2131367323));
    this.mLogoView = ((ImageView)paramView.findViewById(2131370305));
    this.mDeveloperInfoContainer = paramView.findViewById(2131365415);
    this.mDeveloperInfoDesc = ((TextView)paramView.findViewById(2131365416));
    this.mMoreView.setOnClickListener(this);
    this.mCloseView.setOnClickListener(this);
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
    AppBrandTask.runTaskOnUiThreadDelay(new LoadingFragment.7(this), 1000L);
  }
  
  private void updateBaseLib(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("miniapp-start", 1, "updateBaseLib start.");
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("version", paramString);
    AppBrandProxy.g().sendCmd("cmd_update_baselib", localBundle, new LoadingFragment.6(this));
  }
  
  public void doOnBackPressed()
  {
    this.isKill = true;
    if (this.appConfig != null)
    {
      MiniAppStateManager.MiniAppStateMsg localMiniAppStateMsg = new MiniAppStateManager.MiniAppStateMsg(-1, this.appConfig.config.appId, this.appConfig.config.verType, null);
      MiniAppStateManager.getInstance().notifyChange(localMiniAppStateMsg);
    }
    if (this.x5LoadingDialog != null) {
      this.x5LoadingDialog.dismiss();
    }
  }
  
  public Bundle getArgumentBundle()
  {
    return this.mBundle;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 7: 
    case 304: 
    case 306: 
    case 305: 
    case 303: 
      do
      {
        do
        {
          return false;
          paramMessage = (URLDrawable)paramMessage.obj;
          this.mLogoView.setImageDrawable(paramMessage);
          return false;
        } while (this.apkgInited);
        initApkgByConfig();
        return false;
        Toast.makeText(getActivity().getApplicationContext(), anni.a(2131705042), 0).show();
        this.uiHandler.postDelayed(new LoadingFragment.8(this), 1500L);
        return false;
        Toast.makeText(getActivity().getApplicationContext(), anni.a(2131705044), 0).show();
        this.uiHandler.postDelayed(new LoadingFragment.9(this), 1500L);
        return false;
      } while (this.x5LoadingDialog == null);
      this.x5LoadingDialog.a(anni.a(2131705045) + paramMessage.arg1 + "%");
      return false;
    case 311: 
      initApkgByConfig();
      return false;
    case 315: 
      this.uiHandler.post(new LoadingFragment.10(this, paramMessage));
      return false;
    case 310: 
      this.uiHandler.post(new LoadingFragment.11(this, paramMessage));
      return false;
    }
    QLog.i("LoadingActivity", 1, "MSG_WHAT_APP_EVENT_APPROUTE_DONE");
    AppLoaderFactory.getAppUIProxy().completeLoading((BaseActivity)getActivity());
    return false;
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.i("miniapp-start", 1, "LoadingFragment onCreate");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.i("miniapp-start", 1, "LoadingFragment onCreateView");
    if (this.mRootView == null)
    {
      this.mRootView = LayoutInflater.from(getActivity()).inflate(2131559375, null);
      initUI(this.mRootView);
    }
    paramLayoutInflater = this.mRootView;
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.d("miniapp-start", 1, "LoadingFragment onDestroy...");
    awlz.a().a(this.mMiniLibLoadListener);
    AppLoaderFactory.getAppLoaderManager().removeListner(this.uiHandler);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onResume()
  {
    super.onResume();
    View localView;
    if (this.mStatusBar != null)
    {
      boolean bool = ImmersiveUtils.a(true, getActivity().getWindow());
      localView = this.mStatusBar;
      if (!bool) {
        break label40;
      }
    }
    label40:
    for (int i = 0;; i = -3684405)
    {
      localView.setBackgroundColor(i);
      return;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    QLog.i("miniapp-start", 1, "LoadingFragment onViewCreated");
    this.mStatusBar = paramView.findViewById(2131377811);
    new ImmersionBar(getActivity(), 0, this.mStatusBar);
    this.uiHandler = new Handler(this);
    paramView = getArgumentBundle();
    if (paramView != null)
    {
      paramView = (MiniAppConfig)paramView.getParcelable("CONFIG");
      this.appConfig = paramView;
      paramView = getActivity().getIntent();
      if (paramView == null) {
        break label178;
      }
    }
    label178:
    for (paramView = (EngineChannel)paramView.getParcelableExtra("engineChannel");; paramView = null)
    {
      this.mEngineChannel = paramView;
      if ((this.appConfig != null) && (this.appConfig.launchParam != null) && (this.appConfig.config != null)) {
        break label183;
      }
      QLog.e("miniapp-start", 1, "LoadingFragment 小程序参数错误！");
      if (getActivity() != null) {
        Toast.makeText(getActivity(), anni.a(2131705046), 1).show();
      }
      callActivityBackPressed();
      return;
      paramView = null;
      break;
    }
    label183:
    this.appid = this.appConfig.config.appId;
    this.entryPath = this.appConfig.launchParam.entryPath;
    this.mIsBaseLibVersionMatch = false;
    this.mNameView.setText(this.appConfig.config.name);
    if (this.mDeveloperInfoContainer != null)
    {
      if ((this.mDeveloperInfoDesc != null) && (!TextUtils.isEmpty(this.appConfig.config.developerDesc)))
      {
        this.mDeveloperInfoContainer.setVisibility(0);
        this.mDeveloperInfoDesc.setText(anni.a(2131705040) + this.appConfig.config.developerDesc + anni.a(2131705043));
      }
    }
    else
    {
      ThreadManagerV2.excute(new LoadingFragment.1(this), 16, null, false);
      AppLoaderFactory.getAppLoaderManager().addListener(this.uiHandler);
      this.appConfig.baseLibInfo = AppLoaderFactory.getAppLoaderManager().getBaseLibInfo();
      this.apkgInited = true;
      if (!this.appConfig.isShortcutFakeApp()) {
        break label463;
      }
      doRequestByAppid(this.appConfig.config.appId, "", "", this.appConfig.launchParam);
    }
    for (;;)
    {
      AppLoaderFactory.getAppLoaderManager().start(getActivity());
      return;
      this.mDeveloperInfoContainer.setVisibility(8);
      QLog.e("LoadingActivity", 1, "onViewCreated, developerDesc : " + this.appConfig.config.developerDesc);
      break;
      label463:
      initApkgByConfig();
    }
  }
  
  public void setArgumentBundle(Bundle paramBundle)
  {
    this.mBundle = paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.LoadingFragment
 * JD-Core Version:    0.7.0.1
 */