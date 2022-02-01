package com.tencent.qqmini.sdk.ui;

import NS_COMM.COMM.StCommonExt;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.utils.WnsUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

@MiniKeep
public class MainPageFragment
  extends MiniBaseFragment
  implements View.OnClickListener
{
  private static final String LIKE_NUM_POSTFIX = "个赞";
  private static final String MINI_FILE_SUB_PATH = "/tencent/mini/files/";
  private static final String MINI_LOG_PATH;
  public static final String TAG = "MainPageFragment";
  private boolean isLike;
  private boolean isMiniGame = false;
  private ImageView mAppIcon;
  private TextView mAppName;
  private TextView mBackTextView;
  private ImageView mBackView;
  private ChannelProxy mChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
  private View mComplainCallbackContainer;
  private Button mEnterMiniAppBtn;
  private TextView mIntroduction;
  private ImageView mLikeBtn;
  private View mLikeContainer;
  private COMM.StCommonExt mLikeExtInfo;
  private TextView mLikeNum;
  private int mLikeNumber = 0;
  private View.OnLongClickListener mLongClickListener = new MainPageFragment.1(this);
  private MiniAppDialog mMiniAppDialog;
  private MiniAppInfo mMiniAppInfo;
  private MiniAppProxy mMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  private ImageView mMoreView;
  private Button mRecommendMiniAppBtn;
  private View mRelativePublicAccountContainer;
  private View mSeparator;
  private View mSetTopContainer;
  private Switch mSetTopSwitch;
  private TextView mSetTopText;
  private COMM.StCommonExt mTopExtInfo;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/tencent/mini/files/");
    MINI_LOG_PATH = localStringBuilder.toString();
  }
  
  private Drawable getIconDrawable(String paramString)
  {
    int i = DisplayUtil.dip2px(getActivity(), 70.0F);
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2;
    try
    {
      if (Build.VERSION.SDK_INT >= 21) {
        localObject1 = getActivity().getDrawable(R.drawable.mini_sdk_icon_loading_default);
      }
    }
    catch (Exception localException)
    {
      QMLog.e("MainPageFragment", "getIconDrawable, exception!");
      localException.printStackTrace();
      localObject2 = localObject3;
    }
    return this.mMiniAppProxy.getDrawable(getActivity(), paramString, i, i, localObject2);
  }
  
  private void handleMiniappMoreInfo()
  {
    if (QUAUtil.isQQApp())
    {
      startMoreInformation(null);
    }
    else
    {
      ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (localChannelProxy != null) {
        localChannelProxy.getSDKOpenKeyToken(null, new MainPageFragment.3(this));
      }
    }
    this.mMiniAppDialog.dismiss();
    reportClick("profile");
  }
  
  private void handleMiniappSetting()
  {
    MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
    if ((localMiniAppInfo != null) && (!TextUtils.isEmpty(localMiniAppInfo.appId)))
    {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openPermissionSettingsActivity(getActivity(), this.mMiniAppInfo.appId, this.mMiniAppInfo.name);
      this.mMiniAppDialog.dismiss();
      reportClick("set");
    }
  }
  
  private void handleMoreButtonEvent()
  {
    this.mMiniAppDialog = new MiniAppDialog(getActivity());
    this.mMiniAppDialog.setContentView(LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_main_page_dialog_layout, null));
    TextView localTextView = (TextView)this.mMiniAppDialog.findViewById(R.id.miniapp_seting);
    localTextView.setText("设置");
    localTextView.setOnClickListener(this);
    localTextView = (TextView)this.mMiniAppDialog.findViewById(R.id.miniapp_more_information);
    localTextView.setText("更多资料");
    localTextView.setOnClickListener(this);
    ((TextView)this.mMiniAppDialog.findViewById(R.id.miniapp_dialog_cancel)).setOnClickListener(this);
    this.mMiniAppDialog.show();
  }
  
  private void initData()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.mMiniAppInfo = ((MiniAppInfo)localBundle.getParcelable("mini_app_info"));
      this.isMiniGame = this.mMiniAppInfo.isEngineTypeMiniGame();
    }
  }
  
  private void initUI()
  {
    Object localObject = this.mMiniAppInfo;
    if (localObject != null)
    {
      if (!TextUtils.isEmpty(((MiniAppInfo)localObject).iconUrl)) {
        this.mAppIcon.setImageDrawable(getIconDrawable(this.mMiniAppInfo.iconUrl));
      }
      this.mAppName.setText(this.mMiniAppInfo.name);
      this.mIntroduction.setText(this.mMiniAppInfo.desc);
      boolean bool = this.mMiniAppInfo.appMode.disableAddToMyApp;
      if ((bool) || (this.mMiniAppInfo.isInternalApp()))
      {
        this.mSetTopContainer.setVisibility(8);
        if (bool)
        {
          this.mRecommendMiniAppBtn.setVisibility(8);
          localObject = this.mSeparator;
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
        }
      }
    }
    updateUIText();
    if ((!QUAUtil.isQQApp()) && (!QUAUtil.isDemoApp()))
    {
      this.mSetTopContainer.setVisibility(8);
      this.mLikeContainer.setVisibility(8);
    }
    if (QUAUtil.isQQBrowseApp()) {
      this.mEnterMiniAppBtn.setVisibility(8);
    }
  }
  
  private void reportClick(String paramString)
  {
    MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
    SDKMiniProgramLpReportDC04239.reportUserClick(localMiniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(localMiniAppInfo), null, "user_click", "more_about", paramString);
  }
  
  private void sendGetUserAppInfoRequest()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.mMiniAppInfo.appId);
    update(this.mMiniAppInfo);
    this.mChannelProxy.getUserAppInfo(null, localArrayList, new MainPageFragment.4(this));
  }
  
  private void sendSetUserAppLikeRequest(boolean paramBoolean)
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).setUserAppLike(paramBoolean, this.mLikeExtInfo, this.mMiniAppInfo.appId, new MainPageFragment.6(this));
  }
  
  private void setLikeNum()
  {
    if (this.isLike)
    {
      this.isLike = false;
      this.mLikeNumber -= 1;
    }
    else
    {
      this.isLike = true;
      this.mLikeNumber += 1;
    }
    updateLikeNum(this.mLikeNumber);
    updateLikeState(this.isLike);
    sendSetUserAppLikeRequest(this.isLike);
    String str;
    if (this.isLike) {
      str = "like_on";
    } else {
      str = "like_off";
    }
    reportClick(str);
  }
  
  private void setMiniAppTop(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.e("MainPageFragment", "setMiniAppTop, miniAppInfo = null");
      return;
    }
    this.mChannelProxy.setUserAppTop(paramMiniAppInfo, new MainPageFragment.5(this));
  }
  
  private void setTopType(MiniAppInfo paramMiniAppInfo)
  {
    int i;
    if (paramMiniAppInfo.topType == 0) {
      i = 1;
    } else {
      i = 0;
    }
    paramMiniAppInfo.topType = i;
    updateTopTypeState(paramMiniAppInfo);
    sendSetUserAppTopRequest(paramMiniAppInfo);
    if (paramMiniAppInfo.topType == 0) {
      paramMiniAppInfo = "settop_off";
    } else {
      paramMiniAppInfo = "settop_on";
    }
    reportClick(paramMiniAppInfo);
  }
  
  private void startComplainAndCallback()
  {
    if (this.mMiniAppInfo == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startComplainAndCallback, mApkgConfig = ");
      ((StringBuilder)localObject1).append(this.mMiniAppInfo);
      QMLog.e("MainPageFragment", ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject1 = "";
    try
    {
      String str = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
      localObject1 = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startComplainAndCallback, url = ");
      localStringBuilder.append("");
      QMLog.e("MainPageFragment", localStringBuilder.toString());
      localUnsupportedEncodingException.printStackTrace();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("https://tucao.qq.com/qq_miniprogram/tucao?appid=");
    ((StringBuilder)localObject2).append(this.mMiniAppInfo.appId);
    ((StringBuilder)localObject2).append("&openid=");
    ((StringBuilder)localObject2).append(getUin());
    ((StringBuilder)localObject2).append("&avatar=");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("&nickname=游客");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    if (!QUAUtil.isQQApp())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("&customInfo=-");
      ((StringBuilder)localObject1).append(this.mMiniAppProxy.getPlatformId());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("title", "投诉与反馈");
    localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("hide_more_button", true);
    ((Intent)localObject2).putExtras((Bundle)localObject1);
    this.mMiniAppProxy.startBrowserActivity(getActivity(), (Intent)localObject2);
    reportClick("feedback");
    QMLog.d("MainPageFragment", "feedback, prepare to upload log ");
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).uploadUserLog(this.mMiniAppInfo.appId);
  }
  
  private void startMiniApp()
  {
    this.mMiniAppInfo.launchParam.scene = 1024;
    MiniSDK.startMiniApp(getActivity(), this.mMiniAppInfo);
  }
  
  private void startMoreInformation(String paramString)
  {
    if (this.mMiniAppInfo == null)
    {
      paramString = new StringBuilder();
      paramString.append("startMoreInformation, miniAppInfo = ");
      paramString.append(this.mMiniAppInfo);
      QMLog.e("MainPageFragment", paramString.toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://q.qq.com/os/store/details-more?appid=");
    ((StringBuilder)localObject).append(this.mMiniAppInfo.appId);
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("&token=");
      localStringBuilder.append(paramString);
      localStringBuilder.append("&uin=");
      localStringBuilder.append(((MiniAppProxy)localObject).getAccount());
      localStringBuilder.append("&pid=");
      localStringBuilder.append(((MiniAppProxy)localObject).getPlatformId());
      localObject = localStringBuilder.toString();
    }
    paramString = new Intent();
    paramString.putExtra("url", (String)localObject);
    paramString.putExtra("title", "更多资料");
    new Bundle().putBoolean("hide_more_button", true);
    this.mMiniAppProxy.startBrowserActivity(getActivity(), paramString);
  }
  
  private void startRecommendMiniApp() {}
  
  private void update(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(this.mMiniAppInfo.name)) {
      this.mAppName.setText(this.mMiniAppInfo.name);
    }
    if (!TextUtils.isEmpty(this.mMiniAppInfo.desc)) {
      this.mIntroduction.setText(this.mMiniAppInfo.desc);
    }
    updateTopTypeState(paramMiniAppInfo);
  }
  
  private void updateLikeNum(int paramInt)
  {
    if (!this.isLike)
    {
      if (this.isMiniGame)
      {
        this.mLikeNum.setText("为小游戏点赞");
        return;
      }
      this.mLikeNum.setText("为小程序点赞");
      return;
    }
    if (paramInt > 0)
    {
      if (paramInt > 9999)
      {
        float f = paramInt / 10000.0F;
        localTextView = this.mLikeNum;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(String.format("%.2f", new Object[] { Float.valueOf(f) }));
        localStringBuilder.append("万");
        localStringBuilder.append("个赞");
        localTextView.setText(localStringBuilder.toString());
        return;
      }
      TextView localTextView = this.mLikeNum;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("个赞");
      localTextView.setText(localStringBuilder.toString());
    }
  }
  
  private void updateLikeState(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mLikeBtn.setImageResource(R.drawable.mini_sdk_like_button);
      return;
    }
    this.mLikeBtn.setImageResource(R.drawable.mini_sdk_not_like_button);
  }
  
  private void updateTopTypeState(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo.topType == 0)
    {
      this.mSetTopSwitch.setChecked(false);
      return;
    }
    this.mSetTopSwitch.setChecked(true);
  }
  
  private void updateUIText()
  {
    if (this.isMiniGame)
    {
      this.mSetTopText.setText("置顶");
      this.mRecommendMiniAppBtn.setText("推荐小游戏");
      this.mEnterMiniAppBtn.setText("进入小游戏");
      this.mLikeNum.setText("为小游戏点赞");
      return;
    }
    if (WnsUtil.needShowMiniAppFullScreen()) {
      this.mSetTopText.setText("置顶");
    }
    this.mLikeNum.setText("为小程序点赞");
  }
  
  public String getUin()
  {
    return LoginManager.getInstance().getAccount();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.miniapp_enter_miniapp_btn)
    {
      startMiniApp();
      reportClick("launch");
    }
    else if (i == R.id.miniapp_like_container)
    {
      setLikeNum();
    }
    else if (i == R.id.miniapp_set_top_switch)
    {
      setTopType(this.mMiniAppInfo);
    }
    else if (i == R.id.miniapp_recommend_miniapp_btn)
    {
      startRecommendMiniApp();
      reportClick("share");
    }
    else if (i != R.id.miniapp_relative_public_account_container)
    {
      if (i == R.id.miniapp_complain_callback_container) {
        startComplainAndCallback();
      } else if (i == R.id.miniapp_title_back) {
        getActivity().finish();
      } else if (i == R.id.miniapp_title_more) {
        handleMoreButtonEvent();
      } else if (i == R.id.miniapp_seting) {
        handleMiniappSetting();
      } else if (i == R.id.miniapp_more_information) {
        handleMiniappMoreInfo();
      } else if (i == R.id.miniapp_dialog_cancel) {
        this.mMiniAppDialog.dismiss();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_main_page_layout, null);
    if (Build.VERSION.SDK_INT >= 23)
    {
      getActivity().getWindow().clearFlags(67108864);
      getActivity().getWindow().addFlags(-2147483648);
      getActivity().getWindow().setStatusBarColor(-1);
      ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
    }
    if (DisplayUtil.isImmersiveSupported)
    {
      paramLayoutInflater.setFitsSystemWindows(true);
      paramLayoutInflater.setPadding(0, DisplayUtil.getStatusBarHeight(getActivity()), 0, 0);
    }
    initData();
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    TaskMonitorManager.g().switchPerfmPage(getClass().getSimpleName(), true);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mAppIcon = ((ImageView)paramView.findViewById(R.id.miniapp_logo));
    this.mAppIcon.setOnLongClickListener(this.mLongClickListener);
    this.mAppName = ((TextView)paramView.findViewById(R.id.miniapp_name));
    this.mIntroduction = ((TextView)paramView.findViewById(R.id.miniapp_desc));
    this.mLikeNum = ((TextView)paramView.findViewById(R.id.miniapp_like_num_text));
    this.mLikeBtn = ((ImageView)paramView.findViewById(R.id.miniapp_like_image));
    this.mSetTopContainer = paramView.findViewById(R.id.set_top_layout);
    this.mSetTopSwitch = ((Switch)paramView.findViewById(R.id.miniapp_set_top_switch));
    this.mRecommendMiniAppBtn = ((Button)paramView.findViewById(R.id.miniapp_recommend_miniapp_btn));
    this.mEnterMiniAppBtn = ((Button)paramView.findViewById(R.id.miniapp_enter_miniapp_btn));
    this.mRelativePublicAccountContainer = paramView.findViewById(R.id.miniapp_relative_public_account_container);
    this.mComplainCallbackContainer = paramView.findViewById(R.id.miniapp_complain_callback_container);
    this.mLikeContainer = paramView.findViewById(R.id.miniapp_like_container);
    this.mBackView = ((ImageView)paramView.findViewById(R.id.miniapp_title_back));
    this.mMoreView = ((ImageView)paramView.findViewById(R.id.miniapp_title_more));
    this.mSetTopText = ((TextView)paramView.findViewById(R.id.set_top_text));
    this.mSeparator = paramView.findViewById(R.id.item_separator);
    this.mSetTopSwitch.setOnClickListener(this);
    this.mRecommendMiniAppBtn.setOnClickListener(this);
    this.mEnterMiniAppBtn.setOnClickListener(this);
    this.mRelativePublicAccountContainer.setOnClickListener(this);
    this.mComplainCallbackContainer.setOnClickListener(this);
    this.mComplainCallbackContainer.setOnLongClickListener(new MainPageFragment.2(this));
    this.mBackView.setOnClickListener(this);
    this.mMoreView.setOnClickListener(this);
    this.mLikeContainer.setOnClickListener(this);
    initUI();
    sendGetUserAppInfoRequest();
  }
  
  public void sendSetUserAppTopRequest(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) && (QMLog.isColorLevel()))
    {
      paramMiniAppInfo = new StringBuilder();
      paramMiniAppInfo.append("sendSetUserAppTopRequest, miniAppInfo = ");
      paramMiniAppInfo.append(this.mMiniAppInfo);
      QMLog.e("MainPageFragment", paramMiniAppInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MainPageFragment
 * JD-Core Version:    0.7.0.1
 */