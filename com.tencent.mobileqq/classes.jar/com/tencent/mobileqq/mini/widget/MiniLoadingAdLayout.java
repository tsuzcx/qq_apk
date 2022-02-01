package com.tencent.mobileqq.mini.widget;

import amtj;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.net.URLDecoder;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class MiniLoadingAdLayout
  extends RelativeLayout
{
  private static final String TAG = "MiniLoadingAdLayout";
  private boolean autoDownload;
  private int countdownTime = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_duration", 5);
  private GdtAd mAdInfo;
  private RelativeLayout mAppLayout;
  private ImageView mAppLogoView;
  private TextView mAppNameView;
  private ImageView mCloseBtn;
  private RelativeLayout mCountdownContainer;
  private Runnable mCountdownRunnable;
  private TextView mCountdownTextView;
  private TextView mDeveloperDescView;
  private RelativeLayout mGameLayout;
  private ImageView mGameLogoView;
  private TextView mGameNameView;
  private GdtAppReceiver mGdtAppReceiver;
  private ImageView mLoadingAdImgView;
  private TextView mLoadingAdSkipBtn;
  private MiniAppConfig mMiniAppConfig;
  private RelativeLayout mRightContainer;
  private Handler mUiHandler;
  private int showSkipTime = this.countdownTime - QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_skip_time", 1);
  
  public MiniLoadingAdLayout(Context paramContext)
  {
    super(paramContext);
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_auto_download", 0) == 1) {}
    for (;;)
    {
      this.autoDownload = bool;
      initUI();
      return;
      bool = false;
    }
  }
  
  public MiniLoadingAdLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_auto_download", 0) == 1) {}
    for (;;)
    {
      this.autoDownload = bool;
      initUI();
      return;
      bool = false;
    }
  }
  
  public MiniLoadingAdLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_auto_download", 0) == 1) {}
    for (;;)
    {
      this.autoDownload = bool;
      initUI();
      return;
      bool = false;
    }
  }
  
  private void adjustUI(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean2, AdProxy.ILoadingAdListener paramILoadingAdListener)
  {
    int j = 0;
    Object localObject = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      localObject = amtj.a(2131693779);
    }
    this.mLoadingAdImgView.setImageDrawable(Drawable.createFromPath(paramString4));
    paramString3 = this.mGameLayout;
    int i;
    if (paramBoolean1)
    {
      i = 0;
      paramString3.setVisibility(i);
      paramString3 = this.mAppLayout;
      i = j;
      if (paramBoolean1) {
        i = 8;
      }
      paramString3.setVisibility(i);
      this.mCountdownTextView.setText(this.countdownTime + "秒");
      paramString3 = (String)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramString3 = amtj.a(2131693779);
      }
      this.mDeveloperDescView.setText(amtj.a(2131704136) + paramString3 + amtj.a(2131704135));
      localObject = (RelativeLayout.LayoutParams)this.mCountdownContainer.getLayoutParams();
      paramString3 = (RelativeLayout.LayoutParams)this.mRightContainer.getLayoutParams();
      if (!paramBoolean1) {
        break label332;
      }
      if (!LiuHaiUtils.b()) {
        break label318;
      }
      i = ImmersiveUtils.getStatusBarHeight(getContext()) + DisplayUtil.dip2px(getContext(), 10.0F);
      label218:
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      this.mRightContainer.setVisibility(8);
      paramString4 = this.mGameNameView;
    }
    for (paramString3 = this.mGameLogoView;; paramString3 = this.mAppLogoView)
    {
      this.mCountdownContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramString4.setText(paramString1);
      paramString3.setImageDrawable(MiniAppUtils.getIcon(getContext(), paramString2, true, 10));
      this.mLoadingAdImgView.setOnClickListener(new MiniLoadingAdLayout.1(this, paramBoolean2, paramILoadingAdListener));
      if (!paramBoolean2) {
        break label391;
      }
      this.mRightContainer.setVisibility(8);
      return;
      i = 8;
      break;
      label318:
      i = DisplayUtil.dip2px(getContext(), 10.0F);
      break label218;
      label332:
      ((RelativeLayout.LayoutParams)localObject).topMargin = (ImmersiveUtils.getStatusBarHeight(getContext()) + DisplayUtil.dip2px(getContext(), 10.0F));
      paramString3.topMargin = (ImmersiveUtils.getStatusBarHeight(getContext()) + DisplayUtil.dip2px(getContext(), 10.0F));
      paramString4 = this.mAppNameView;
    }
    label391:
    this.mCloseBtn.setOnClickListener(new MiniLoadingAdLayout.2(this, paramBoolean1));
  }
  
  private void initUI()
  {
    LayoutInflater.from(getContext()).inflate(2131559432, this, true);
    this.mAppLayout = ((RelativeLayout)findViewById(2131371171));
    this.mGameLayout = ((RelativeLayout)findViewById(2131371177));
    this.mRightContainer = ((RelativeLayout)findViewById(2131365069));
    this.mCloseBtn = ((ImageView)findViewById(2131363794));
    this.mCountdownContainer = ((RelativeLayout)findViewById(2131371173));
    this.mCountdownTextView = ((TextView)findViewById(2131370272));
    this.mLoadingAdSkipBtn = ((TextView)findViewById(2131371179));
    this.mDeveloperDescView = ((TextView)findViewById(2131365489));
    this.mAppNameView = ((TextView)findViewById(2131371172));
    this.mGameNameView = ((TextView)findViewById(2131371178));
    this.mAppLogoView = ((ImageView)findViewById(2131371170));
    this.mGameLogoView = ((ImageView)findViewById(2131371175));
    this.mLoadingAdImgView = ((ImageView)findViewById(2131370273));
  }
  
  private void negativeReport() {}
  
  private void reportToGdt(String paramString, long paramLong)
  {
    QLog.i("MiniLoadingAdLayout", 1, "yuki reportToGdt LoadingAd reportUrl = " + paramString);
    if ((TextUtils.isEmpty(paramString)) || (!URLUtil.isNetworkUrl(paramString))) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(new MiniLoadingAdLayout.5(this, paramString));
  }
  
  private void startCountDown(MiniLoadingAdLayout.OnDismissListener paramOnDismissListener)
  {
    this.mUiHandler = new Handler(Looper.getMainLooper());
    this.mCountdownRunnable = new MiniLoadingAdLayout.4(this, paramOnDismissListener);
    this.mUiHandler.postDelayed(this.mCountdownRunnable, 1000L);
  }
  
  public void dismiss(boolean paramBoolean, MiniLoadingAdLayout.OnDismissListener paramOnDismissListener)
  {
    setVisibility(8);
    if (paramBoolean) {
      negativeReport();
    }
    this.mUiHandler.removeCallbacks(this.mCountdownRunnable);
    if (paramOnDismissListener != null) {
      paramOnDismissListener.onDismiss(paramBoolean);
    }
  }
  
  public boolean setupUI(MiniAppConfig paramMiniAppConfig, boolean paramBoolean, String paramString, GdtAd paramGdtAd)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null) || (TextUtils.isEmpty(paramString)) || (paramGdtAd == null)) {
      return false;
    }
    this.mAdInfo = paramGdtAd;
    this.mMiniAppConfig = paramMiniAppConfig;
    adjustUI(paramBoolean, paramMiniAppConfig.config.name, URLDecoder.decode(paramMiniAppConfig.config.iconUrl), paramMiniAppConfig.config.developerDesc, paramString, false, null);
    return true;
  }
  
  public boolean setupUIForSDK(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, AdProxy.ILoadingAdListener paramILoadingAdListener)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      QLog.i("MiniLoadingAdLayout", 1, "setupUIForSDK adJson||name||iconUrl is empty");
      return false;
    }
    paramString1 = AdUtils.convertJson2GdtAds(paramString1);
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      QLog.i("MiniLoadingAdLayout", 1, "setupUIForSDK ads is empty");
      return false;
    }
    this.mAdInfo = ((GdtAd)paramString1.get(0));
    adjustUI(paramBoolean, paramString2, paramString3, paramString4, paramString5, true, paramILoadingAdListener);
    return true;
  }
  
  public void show(MiniLoadingAdLayout.OnDismissListener paramOnDismissListener)
  {
    setVisibility(0);
    startCountDown(paramOnDismissListener);
    if ((this.mAdInfo != null) && (this.mAdInfo.info != null) && (this.mAdInfo.info.report_info != null) && (this.mAdInfo.info.report_info.exposure_url != null)) {
      reportToGdt(this.mAdInfo.info.report_info.exposure_url.get(), System.currentTimeMillis());
    }
    this.mLoadingAdSkipBtn.setOnClickListener(new MiniLoadingAdLayout.3(this, paramOnDismissListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout
 * JD-Core Version:    0.7.0.1
 */