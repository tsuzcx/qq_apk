package com.tencent.mobileqq.mini.mainpage;

import NS_COMM.COMM.StCommonExt;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.apkg.AppMode;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager;
import com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.mini.share.MiniArkShareModelBuilder;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ShareQQArkHelper;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class MainPageFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private static final String LIKE_NUM_POSTFIX = HardCodeUtil.a(2131904353);
  public static final String TAG = "MainPageFragment";
  private boolean isLike;
  private boolean isMiniGame = false;
  private ImageView mAppIcon;
  private TextView mAppName;
  private TextView mBackTextView;
  private ImageView mBackView;
  private View mComplainCallbackContainer;
  private Button mEnterMiniAppBtn;
  private TextView mIntroduction;
  private ImageView mLikeBtn;
  private View mLikeContainer;
  private COMM.StCommonExt mLikeExtInfo;
  private TextView mLikeNum;
  private int mLikeNumber = 0;
  private View.OnLongClickListener mLongClickListener = new MainPageFragment.7(this);
  private MiniAppConfig mMiniAppConfig;
  private MiniAppDialog mMiniAppDialog;
  private MiniAppInfo mMiniAppInfo;
  private ImageView mMoreView;
  private Button mRecommendMiniAppBtn;
  private View mRelativePublicAccountContainer;
  private View mSeparator;
  private Switch mSetTopSwitch;
  private TextView mSetTopText;
  private COMM.StCommonExt mTopExtInfo;
  
  private Drawable getIconDrawable(String paramString)
  {
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
    int i = ViewUtils.dpToPx(70.0F);
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i;
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = getBaseActivity().getDrawable(2130841992);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = getBaseActivity().getDrawable(2130841992);
      }
    }
    catch (Exception localException1)
    {
      QLog.e("MainPageFragment", 1, "getIconDrawable, exception!");
      localException1.printStackTrace();
    }
    Object localObject1 = null;
    try
    {
      localObject2 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject2);
      localObject1 = localObject2;
      ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.b(i, i, ViewUtils.dpToPx(12.0F)));
      localObject1 = localObject2;
      ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.j);
      return localObject2;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getIcon url: ");
        localStringBuilder.append(paramString);
        QLog.e("MainPageFragment", 2, localStringBuilder.toString());
      }
    }
    return localObject1;
  }
  
  public static String getUin()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = ((AppRuntime)localObject).getAccount();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get uin from app runtim succ:");
      localStringBuilder.append((String)localObject);
      QLog.i("CommonDataAdapter", 2, localStringBuilder.toString());
      return localObject;
    }
    return null;
  }
  
  private void handleMoreButtonEvent()
  {
    this.mMiniAppDialog = new MiniAppDialog(getBaseActivity());
    this.mMiniAppDialog.setContentView(LayoutInflater.from(getBaseActivity()).inflate(2131628805, null));
    TextView localTextView = (TextView)this.mMiniAppDialog.findViewById(2131438740);
    localTextView.setText(HardCodeUtil.a(2131904345));
    localTextView.setOnClickListener(this);
    localTextView = (TextView)this.mMiniAppDialog.findViewById(2131438734);
    localTextView.setText(HardCodeUtil.a(2131904340));
    localTextView.setVisibility(0);
    localTextView.setOnClickListener(this);
    ((TextView)this.mMiniAppDialog.findViewById(2131438707)).setOnClickListener(this);
    this.mMiniAppDialog.show();
  }
  
  private void initData()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.mMiniAppConfig = ((MiniAppConfig)localBundle.getParcelable("app_config"));
      Object localObject = this.mMiniAppConfig;
      if ((localObject != null) && (((MiniAppConfig)localObject).config != null))
      {
        this.mMiniAppInfo = this.mMiniAppConfig.config;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initData : miniAppConfig = ");
          ((StringBuilder)localObject).append(this.mMiniAppConfig.toString());
          QLog.d("MainPageFragment", 2, ((StringBuilder)localObject).toString());
        }
      }
      this.isMiniGame = localBundle.getBoolean("isMiniGame");
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
      if ((bool) || (this.mMiniAppInfo.isLimitedAccessApp()))
      {
        if (getView() != null)
        {
          localObject = getView().findViewById(2131445705);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
        }
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
    if (this.isMiniGame)
    {
      this.mSetTopText.setText(HardCodeUtil.a(2131904344));
      this.mRecommendMiniAppBtn.setText(HardCodeUtil.a(2131904347));
      this.mEnterMiniAppBtn.setText(HardCodeUtil.a(2131904343));
      this.mLikeNum.setText(HardCodeUtil.a(2131904349));
      return;
    }
    if (MiniAppConfProcessor.e()) {
      this.mSetTopText.setText(HardCodeUtil.a(2131904344));
    }
    this.mLikeNum.setText(HardCodeUtil.a(2131904352));
  }
  
  public static void launch(Context paramContext, MiniAppConfig paramMiniAppConfig, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("app_config", paramMiniAppConfig);
    localIntent.putExtra("versionType", paramInt);
    PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicFragmentActivityForMini.class, MainPageFragment.class);
  }
  
  public static void launchForMiniGame(Context paramContext, MiniAppConfig paramMiniAppConfig, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("app_config", paramMiniAppConfig);
    localIntent.putExtra("versionType", paramInt);
    localIntent.putExtra("isMiniGame", paramBoolean);
    PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicFragmentActivityForMini.class, MainPageFragment.class);
  }
  
  private void reportClick(String paramString)
  {
    MiniAppConfig localMiniAppConfig = this.mMiniAppConfig;
    MiniProgramLpReportDC04239.reportUserClick(localMiniAppConfig, MiniProgramLpReportDC04239.getAppType(localMiniAppConfig), null, "user_click", "more_about", paramString);
  }
  
  private void sendGetUserAppInfoRequest()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.mMiniAppInfo.appId);
    update(this.mMiniAppInfo);
    MiniAppCmdUtil.getInstance().getUserAppInfo(localArrayList, new MainPageFragment.2(this));
  }
  
  private void sendSetUserAppLikeRequest(boolean paramBoolean)
  {
    MiniAppCmdUtil.getInstance().setUserAppLike(paramBoolean, this.mLikeExtInfo, this.mMiniAppInfo.appId, new MainPageFragment.5(this));
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
      QLog.e("MainPageFragment", 1, "setMiniAppTop, miniAppInfo = null");
      return;
    }
    MiniAppCmdUtil.getInstance().setUserAppTop(paramMiniAppInfo.appId, paramMiniAppInfo.topType, paramMiniAppInfo.verType, this.mTopExtInfo, new MainPageFragment.4(this));
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
      QLog.e("MainPageFragment", 1, ((StringBuilder)localObject1).toString());
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
      QLog.e("MainPageFragment", 1, localStringBuilder.toString());
      localUnsupportedEncodingException.printStackTrace();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("https://tucao.qq.com/qq_miniprogram/tucao?appid=");
    ((StringBuilder)localObject2).append(this.mMiniAppInfo.appId);
    ((StringBuilder)localObject2).append("&openid=");
    ((StringBuilder)localObject2).append(getUin());
    ((StringBuilder)localObject2).append("&avatar=");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131904355));
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = new Intent(getBaseActivity(), QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", (String)localObject2);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putBoolean("hide_more_button", true);
    ((Intent)localObject1).putExtras((Bundle)localObject2);
    startActivity((Intent)localObject1);
    reportClick("feedback");
    QLog.d("MainPageFragment", 2, "feedback, prepare to upload log ");
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("appid", this.mMiniAppInfo.appId);
    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "upload_user_log", (Bundle)localObject1, new MainPageFragment.6(this));
  }
  
  private void startMiniApp()
  {
    try
    {
      MiniAppController.launchMiniAppByAppInfo(getBaseActivity(), this.mMiniAppInfo, 1024);
      return;
    }
    catch (MiniAppException localMiniAppException)
    {
      QLog.e("MainPageFragment", 1, "startMiniApp is failed !!!");
      localMiniAppException.printStackTrace();
    }
  }
  
  private void startMoreInformation()
  {
    if (this.mMiniAppInfo == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startMoreInformation, miniAppInfo = ");
      ((StringBuilder)localObject1).append(this.mMiniAppInfo);
      QLog.e("MainPageFragment", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://q.qq.com/os/store/details-more?appid=");
    ((StringBuilder)localObject1).append(this.mMiniAppInfo.appId);
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = new Intent(getBaseActivity(), QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", (String)localObject2);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putBoolean("hide_more_button", true);
    ((Intent)localObject1).putExtras((Bundle)localObject2);
    startActivity((Intent)localObject1);
  }
  
  private void startRecommendMiniApp()
  {
    if (this.mMiniAppInfo != null)
    {
      MiniArkShareModel localMiniArkShareModel = new MiniArkShareModelBuilder().setAppId(this.mMiniAppInfo.appId).setTitle(this.mMiniAppInfo.name).setDescription(this.mMiniAppInfo.desc).setShareScene(0).setShareTemplateType(0).setShareBusinessType(this.mMiniAppInfo.getReportType()).setPicUrl(this.mMiniAppInfo.iconUrl).setVidUrl(null).setIconUrl(this.mMiniAppInfo.iconUrl).setVersionType(this.mMiniAppInfo.verType).setVersionId(this.mMiniAppInfo.versionId).setWithShareTicket(false).setMiniAppShareFrom(10).setExtInfo(null).createMiniArkShareModel();
      ShareQQArkHelper.a(getBaseActivity(), localMiniArkShareModel, null);
    }
  }
  
  private void update(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(this.mMiniAppInfo.iconUrl)) {
      this.mAppIcon.setImageDrawable(getIconDrawable(this.mMiniAppInfo.iconUrl));
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
        this.mLikeNum.setText(HardCodeUtil.a(2131904341));
        return;
      }
      this.mLikeNum.setText(HardCodeUtil.a(2131904354));
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
        localStringBuilder.append(HardCodeUtil.a(2131904351));
        localStringBuilder.append(LIKE_NUM_POSTFIX);
        localTextView.setText(localStringBuilder.toString());
        return;
      }
      TextView localTextView = this.mLikeNum;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append(LIKE_NUM_POSTFIX);
      localTextView.setText(localStringBuilder.toString());
    }
  }
  
  private void updateLikeState(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mLikeBtn.setImageResource(2130841993);
      return;
    }
    this.mLikeBtn.setImageResource(2130842025);
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
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131438744: 
      handleMoreButtonEvent();
      return;
    case 2131438743: 
      getBaseActivity().finish();
      return;
    case 2131438740: 
      paramView = this.mMiniAppInfo;
      if ((paramView != null) && (!TextUtils.isEmpty(paramView.appId)))
      {
        PermissionSettingFragment.launchForResult(getBaseActivity(), this.mMiniAppInfo.appId, this.mMiniAppInfo.name, 5);
        this.mMiniAppDialog.dismiss();
        reportClick("set");
        return;
      }
      break;
    case 2131438739: 
      setTopType(this.mMiniAppInfo);
      return;
    case 2131438737: 
      startRecommendMiniApp();
      reportClick("share");
      return;
    case 2131438734: 
      startMoreInformation();
      this.mMiniAppDialog.dismiss();
      reportClick("profile");
      return;
    case 2131438726: 
      setLikeNum();
      return;
    case 2131438710: 
      startMiniApp();
      reportClick("launch");
      return;
    case 2131438707: 
      this.mMiniAppDialog.dismiss();
      return;
    case 2131438704: 
      startComplainAndCallback();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getBaseActivity()).inflate(2131628806, null);
    if (Build.VERSION.SDK_INT >= 23)
    {
      getBaseActivity().getWindow().clearFlags(67108864);
      getBaseActivity().getWindow().addFlags(-2147483648);
      getBaseActivity().getWindow().setStatusBarColor(-1);
      ImmersiveUtils.setStatusTextColor(true, getBaseActivity().getWindow());
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramLayoutInflater.setFitsSystemWindows(true);
      paramLayoutInflater.setPadding(0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()), 0, 0);
    }
    initData();
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    TaskMonitorManager.g().switchPerfmPage(getClass().getSimpleName(), true);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mAppIcon = ((ImageView)paramView.findViewById(2131438729));
    this.mAppIcon.setOnLongClickListener(this.mLongClickListener);
    this.mAppName = ((TextView)paramView.findViewById(2131438735));
    this.mIntroduction = ((TextView)paramView.findViewById(2131438706));
    this.mLikeNum = ((TextView)paramView.findViewById(2131438728));
    this.mLikeBtn = ((ImageView)paramView.findViewById(2131438727));
    this.mSetTopSwitch = ((Switch)paramView.findViewById(2131438739));
    this.mRecommendMiniAppBtn = ((Button)paramView.findViewById(2131438737));
    this.mEnterMiniAppBtn = ((Button)paramView.findViewById(2131438710));
    this.mRelativePublicAccountContainer = paramView.findViewById(2131438738);
    this.mComplainCallbackContainer = paramView.findViewById(2131438704);
    this.mLikeContainer = paramView.findViewById(2131438726);
    this.mBackView = ((ImageView)paramView.findViewById(2131438743));
    this.mMoreView = ((ImageView)paramView.findViewById(2131438744));
    this.mSetTopText = ((TextView)paramView.findViewById(2131445706));
    this.mSeparator = paramView.findViewById(2131436124);
    this.mSetTopSwitch.setOnClickListener(this);
    this.mRecommendMiniAppBtn.setOnClickListener(this);
    this.mEnterMiniAppBtn.setOnClickListener(this);
    this.mRelativePublicAccountContainer.setOnClickListener(this);
    this.mComplainCallbackContainer.setOnClickListener(this);
    this.mComplainCallbackContainer.setOnLongClickListener(new MainPageFragment.1(this));
    this.mBackView.setOnClickListener(this);
    this.mMoreView.setOnClickListener(this);
    this.mLikeContainer.setOnClickListener(this);
    initUI();
    sendGetUserAppInfoRequest();
  }
  
  public void sendSetUserAppTopRequest(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      if (QLog.isColorLevel())
      {
        paramMiniAppInfo = new StringBuilder();
        paramMiniAppInfo.append("sendSetUserAppTopRequest, miniAppInfo = ");
        paramMiniAppInfo.append(this.mMiniAppInfo);
        QLog.e("MainPageFragment", 1, paramMiniAppInfo.toString());
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", paramMiniAppInfo.appId);
    localBundle.putInt("topType", paramMiniAppInfo.topType);
    localBundle.putInt("verType", paramMiniAppInfo.verType);
    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "sync_mini_app_data", localBundle, new MainPageFragment.3(this, paramMiniAppInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.MainPageFragment
 * JD-Core Version:    0.7.0.1
 */