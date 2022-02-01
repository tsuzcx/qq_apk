package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.ui.dialog.DisplayHelper;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class MiniLoadingAdLayout
  extends RelativeLayout
{
  public static final String AD_REF_ID = "biz_src_miniappD";
  private static final String REPORT_URL = "https://rpt.gdt.qq.com/mqq_log";
  private static final String TAG = "MiniLoadingAdLayout";
  private boolean autoDownload;
  private int countdownTime = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_duration", 5);
  private float densityDpi;
  private boolean isGame;
  private int lastTouchDownX;
  private int lastTouchDownY;
  private int lastTouchUpX;
  private int lastTouchUpY;
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
  private TextView mGamePublicationInfoFirstLineView;
  private LinearLayout mGamePublicationInfoLayout;
  private TextView mGamePublicationInfoSecondLineView;
  private GdtAppReceiver mGdtAppReceiver;
  private RelativeLayout mLoadingAdBar;
  private RelativeLayout mLoadingAdBarLayout;
  private ImageView mLoadingAdImgView;
  private TextView mLoadingAdSkipBtn;
  private TextView mLoadingAdTextView;
  private MiniAppConfig mMiniAppConfig;
  private RelativeLayout mRightContainer;
  private Handler mUiHandler;
  private com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo;
  private long pressInterval;
  private long requestAdTimeStamp;
  private boolean selectSecondOption;
  private long showAdStamp;
  private int showSkipTime = this.countdownTime - QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_skip_time", 0);
  private long showTimeStamp;
  private long touchStamp;
  
  public MiniLoadingAdLayout(Context paramContext)
  {
    super(paramContext);
    int i = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_auto_download", 0);
    boolean bool2 = true;
    boolean bool1;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.autoDownload = bool1;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_ad_ui_mode", 0) == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.selectSecondOption = bool1;
    this.densityDpi = 1.0F;
    initUI();
  }
  
  public MiniLoadingAdLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_auto_download", 0);
    boolean bool2 = true;
    boolean bool1;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.autoDownload = bool1;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_ad_ui_mode", 0) == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.selectSecondOption = bool1;
    this.densityDpi = 1.0F;
    initUI();
  }
  
  public MiniLoadingAdLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_auto_download", 0);
    boolean bool2 = true;
    boolean bool1;
    if (paramInt == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.autoDownload = bool1;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_ad_ui_mode", 0) == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.selectSecondOption = bool1;
    this.densityDpi = 1.0F;
    initUI();
  }
  
  private void adjustUI(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean2, AdProxy.ILoadingAdListener paramILoadingAdListener)
  {
    Object localObject = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      localObject = HardCodeUtil.a(2131891748);
    }
    this.isGame = paramBoolean1;
    this.mLoadingAdImgView.setImageDrawable(Drawable.createFromPath(paramString4));
    paramString3 = this.mGameLayout;
    int i;
    if (paramBoolean1) {
      i = 0;
    } else {
      i = 8;
    }
    paramString3.setVisibility(i);
    paramString3 = this.mAppLayout;
    if (paramBoolean1) {
      i = 8;
    } else {
      i = 0;
    }
    paramString3.setVisibility(i);
    paramString3 = this.mCountdownTextView;
    paramString4 = new StringBuilder();
    paramString4.append(this.countdownTime);
    paramString4.append("秒");
    paramString3.setText(paramString4.toString());
    paramString3 = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString3 = HardCodeUtil.a(2131891748);
    }
    paramString4 = this.mDeveloperDescView;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131903001));
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131903000));
    paramString4.setText(((StringBuilder)localObject).toString());
    localObject = (RelativeLayout.LayoutParams)this.mCountdownContainer.getLayoutParams();
    paramString3 = (RelativeLayout.LayoutParams)this.mRightContainer.getLayoutParams();
    float f = 10.0F;
    if (paramBoolean1)
    {
      if (this.selectSecondOption) {
        f = 27.5F;
      }
      if (LiuHaiUtils.b()) {
        i = ImmersiveUtils.getStatusBarHeight(getContext()) + DisplayUtil.dip2px(getContext(), f);
      } else {
        i = DisplayUtil.dip2px(getContext(), f);
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      this.mRightContainer.setVisibility(8);
      paramString3 = this.mGameNameView;
      paramString4 = this.mGameLogoView;
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = (ImmersiveUtils.getStatusBarHeight(getContext()) + DisplayUtil.dip2px(getContext(), 10.0F));
      paramString3.topMargin = (ImmersiveUtils.getStatusBarHeight(getContext()) + DisplayUtil.dip2px(getContext(), 10.0F));
      paramString3 = this.mAppNameView;
      paramString4 = this.mAppLogoView;
    }
    this.mCountdownContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramString3.setText(paramString1);
    paramString4.setImageDrawable(MiniAppUtils.getIcon(getContext(), paramString2, true, 10));
    if (!this.selectSecondOption)
    {
      this.mLoadingAdImgView.setOnClickListener(new MiniLoadingAdLayout.LoadingAdOnClickListener(this, 0, paramILoadingAdListener));
      this.mLoadingAdBarLayout.setOnClickListener(new MiniLoadingAdLayout.LoadingAdOnClickListener(this, 1, paramILoadingAdListener));
    }
    else
    {
      this.mLoadingAdBar.setOnClickListener(new MiniLoadingAdLayout.LoadingAdOnClickListener(this, 1, paramILoadingAdListener));
    }
    if (paramBoolean2) {
      this.mRightContainer.setVisibility(8);
    }
  }
  
  private JSONObject createLoadingAntiParamForClickCGI(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo)
  {
    Object localObject = createLoadingAntiParamForExpoCGI(paramMiniAppInfo);
    paramMiniAppInfo = (com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)localObject;
    if (localObject == null) {}
    try
    {
      paramMiniAppInfo = new JSONObject();
      localObject = paramMiniAppInfo;
      paramMiniAppInfo.put("aa", this.lastTouchDownX);
      localObject = paramMiniAppInfo;
      paramMiniAppInfo.put("ab", this.lastTouchDownY);
      localObject = paramMiniAppInfo;
      paramMiniAppInfo.put("ba", this.lastTouchUpX);
      localObject = paramMiniAppInfo;
      paramMiniAppInfo.put("bb", this.lastTouchUpY);
      localObject = paramMiniAppInfo;
      paramMiniAppInfo.put("g", this.pressInterval);
      return paramMiniAppInfo;
    }
    catch (Exception paramMiniAppInfo)
    {
      QLog.e("MiniLoadingAdLayout", 1, "createLoadingAntiParamForClickCGI failed", paramMiniAppInfo);
    }
    return localObject;
  }
  
  private Bundle createLoadingAntiParamForClickReportServer(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo, String paramString, int paramInt)
  {
    paramMiniAppInfo = createLoadingAntiParamForExpoReportServer(paramMiniAppInfo, paramString);
    try
    {
      long l = System.currentTimeMillis();
      paramMiniAppInfo.putLong("ud", l - this.showTimeStamp);
      paramMiniAppInfo.putInt("lt", 3);
      paramMiniAppInfo.putInt("cb", paramInt);
      paramMiniAppInfo.putLong("ct", l);
      return paramMiniAppInfo;
    }
    catch (Exception paramString)
    {
      QLog.e("MiniLoadingAdLayout", 1, "createLoadingAntiParamForClickReportServer failed", paramString);
    }
    return paramMiniAppInfo;
  }
  
  private JSONObject createLoadingAntiParamForExpoCGI(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo)
  {
    try
    {
      paramMiniAppInfo = new JSONObject();
      try
      {
        int i = DisplayHelper.getScreenWidth(getContext());
        int j = DisplayHelper.getScreenHeight(getContext());
        paramMiniAppInfo.put("da", (int)(i / this.densityDpi));
        paramMiniAppInfo.put("db", (int)(j / this.densityDpi));
        paramMiniAppInfo.put("px", 0);
        paramMiniAppInfo.put("py", 0);
        paramMiniAppInfo.put("x", 0);
        return paramMiniAppInfo;
      }
      catch (Exception localException1) {}
      QLog.e("MiniLoadingAdLayout", 1, "createLoadingAntiParamForExpoCGI failed", localException2);
    }
    catch (Exception localException2)
    {
      paramMiniAppInfo = null;
    }
    return paramMiniAppInfo;
  }
  
  private Bundle createLoadingAntiParamForExpoReportServer(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo, String paramString)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localBundle.putInt("at", 0);
        localBundle.putInt("cn_t", getNetworkType());
        localBundle.putLong("et", this.showAdStamp);
        localBundle.putInt("fh", 0);
        localBundle.putInt("ic", 0);
        if (this.isGame)
        {
          i = 1;
          localBundle.putInt("ig", i);
          localBundle.putLong("it", this.requestAdTimeStamp);
          localBundle.putInt("lt", 2);
          localBundle.putInt("s", 0);
          localBundle.putInt("sc_s", paramMiniAppInfo.launchParam.scene);
          localBundle.putString("sc_sn", getExtraInfo(paramMiniAppInfo));
          long l;
          if (paramMiniAppInfo.launchParam.launchClickTimeMillis != 0L) {
            l = paramMiniAppInfo.launchParam.launchClickTimeMillis;
          } else {
            l = this.showTimeStamp;
          }
          localBundle.putLong("st", l);
          localBundle.putString("viewid", parseViewId(paramString));
          localBundle.putString("wlv", StorageUtil.getPreference().getString("version", "1.29.0.00002"));
          return localBundle;
        }
      }
      catch (Exception paramMiniAppInfo)
      {
        QLog.e("MiniLoadingAdLayout", 1, "createLoadingAntiParamForExpoReportServer failed", paramMiniAppInfo);
        return localBundle;
      }
      int i = 0;
    }
  }
  
  private String getExtraInfo(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo)
  {
    try
    {
      if (paramMiniAppInfo.launchParam.entryModel != null) {
        return String.valueOf(paramMiniAppInfo.launchParam.entryModel.uin);
      }
      paramMiniAppInfo = paramMiniAppInfo.launchParam.fromMiniAppId;
      return paramMiniAppInfo;
    }
    catch (Exception paramMiniAppInfo)
    {
      label34:
      break label34;
    }
    return "";
  }
  
  private int getNetworkType()
  {
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext().getApplicationContext());
    if (j == 5) {
      return 0;
    }
    int i = j;
    if (j == 6) {
      i = 7;
    }
    return i;
  }
  
  private void initUI()
  {
    if (!this.selectSecondOption) {
      LayoutInflater.from(getContext()).inflate(2131625374, this, true);
    } else {
      LayoutInflater.from(getContext()).inflate(2131625375, this, true);
    }
    this.mAppLayout = ((RelativeLayout)findViewById(2131438606));
    this.mGameLayout = ((RelativeLayout)findViewById(2131438616));
    this.mRightContainer = ((RelativeLayout)findViewById(2131431318));
    this.mCloseBtn = ((ImageView)findViewById(2131429840));
    this.mCountdownContainer = ((RelativeLayout)findViewById(2131438612));
    this.mCountdownTextView = ((TextView)findViewById(2131437627));
    if (!this.selectSecondOption) {
      this.mLoadingAdSkipBtn = ((TextView)findViewById(2131438619));
    } else {
      this.mLoadingAdSkipBtn = ((TextView)findViewById(2131437629));
    }
    this.mDeveloperDescView = ((TextView)findViewById(2131431808));
    this.mAppNameView = ((TextView)findViewById(2131438607));
    this.mGameNameView = ((TextView)findViewById(2131438617));
    this.mAppLogoView = ((ImageView)findViewById(2131438605));
    this.mGameLogoView = ((ImageView)findViewById(2131438614));
    this.mLoadingAdImgView = ((ImageView)findViewById(2131437628));
    this.mLoadingAdBarLayout = ((RelativeLayout)findViewById(2131438611));
    this.mLoadingAdBar = ((RelativeLayout)findViewById(2131438609));
    this.mLoadingAdTextView = ((TextView)findViewById(2131438608));
    this.mGamePublicationInfoLayout = ((LinearLayout)findViewById(2131438618));
    this.mGamePublicationInfoFirstLineView = ((TextView)findViewById(2131434011));
    this.mGamePublicationInfoSecondLineView = ((TextView)findViewById(2131434012));
    this.densityDpi = DisplayHelper.getDensity(getContext());
  }
  
  private void negativeReport() {}
  
  private static String parseViewId(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = Uri.parse(paramString).getQueryParameter("viewid");
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    return paramString;
  }
  
  public static void report(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportParams=");
    localStringBuilder.append(paramBundle.toString());
    QLog.i("MiniLoadingAdLayout", 1, localStringBuilder.toString());
    ThreadManager.excute(new MiniLoadingAdLayout.5(paramBundle), 128, null, true);
  }
  
  private void reportToGdt(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("yuki reportToGdt LoadingAd reportUrl = ");
    localStringBuilder.append(paramString);
    QLog.i("MiniLoadingAdLayout", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      if (!URLUtil.isNetworkUrl(paramString)) {
        return;
      }
      ThreadManager.executeOnNetWorkThread(new MiniLoadingAdLayout.4(this, paramString));
    }
  }
  
  private void showAdBar()
  {
    Object localObject1 = this.mAdInfo;
    if ((localObject1 != null) && (((GdtAd)localObject1).info != null) && (this.mAdInfo.info.display_info != null) && (this.mAdInfo.info.display_info.basic_info != null) && (this.mAdInfo.info.display_info.basic_info.txt != null))
    {
      Object localObject2 = "";
      localObject1 = localObject2;
      if (this.mAdInfo.info.display_info.button_info.has())
      {
        localObject1 = localObject2;
        if (this.mAdInfo.info.display_info.button_info.get() != null)
        {
          localObject1 = localObject2;
          if (this.mAdInfo.info.display_info.button_info.get().size() > 0)
          {
            localObject1 = "";
            int i = 0;
            while (i < this.mAdInfo.info.display_info.button_info.get().size())
            {
              qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo localButtonInfo = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)this.mAdInfo.info.display_info.button_info.get(i);
              localObject2 = localObject1;
              if (localButtonInfo.pos.get() == 2)
              {
                localObject2 = localObject1;
                if (!TextUtils.isEmpty(localButtonInfo.txt.get())) {
                  localObject2 = localButtonInfo.txt.get();
                }
              }
              i += 1;
              localObject1 = localObject2;
            }
          }
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = this.mLoadingAdTextView;
        if ((localObject2 != null) && (this.mLoadingAdBarLayout != null))
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          this.mLoadingAdBarLayout.setVisibility(0);
        }
      }
    }
  }
  
  private void showPublicationInfo()
  {
    Object localObject1 = this.miniAppInfo;
    if (localObject1 == null)
    {
      this.mGamePublicationInfoLayout.setVisibility(8);
      this.mDeveloperDescView.setVisibility(0);
      return;
    }
    if ((!TextUtils.isEmpty(((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)localObject1).gamePublicationNumber)) && (!TextUtils.isEmpty(this.miniAppInfo.gameOperatingCompany)) && (!TextUtils.isEmpty(this.miniAppInfo.gameApprovalNumber)) && (!TextUtils.isEmpty(this.miniAppInfo.gameOperatingCompany)))
    {
      this.mGamePublicationInfoLayout.setVisibility(0);
      this.mDeveloperDescView.setVisibility(8);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131891759));
      ((StringBuilder)localObject1).append(this.miniAppInfo.gamePublicationNumber);
      ((StringBuilder)localObject1).append("   ");
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131891757));
      ((StringBuilder)localObject1).append(this.miniAppInfo.gameOperatingCompany);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131891751));
      ((StringBuilder)localObject2).append(this.miniAppInfo.gameApprovalNumber);
      ((StringBuilder)localObject2).append("   ");
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131891758));
      ((StringBuilder)localObject2).append(this.miniAppInfo.gamePublicationCompany);
      localObject2 = ((StringBuilder)localObject2).toString();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        this.mGamePublicationInfoFirstLineView.setText((CharSequence)localObject1);
        this.mGamePublicationInfoSecondLineView.setText((CharSequence)localObject2);
      }
      return;
    }
    this.mGamePublicationInfoLayout.setVisibility(8);
    this.mDeveloperDescView.setVisibility(0);
  }
  
  private void startAdBarAnimation()
  {
    Object localObject = this.mAdInfo;
    if ((localObject != null) && (((GdtAd)localObject).info != null) && (this.mAdInfo.info.display_info != null) && (this.mAdInfo.info.display_info.basic_info != null) && (this.mAdInfo.info.display_info.basic_info.txt != null))
    {
      localObject = this.mAdInfo.info.display_info.basic_info.txt.get();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        TextView localTextView = this.mLoadingAdTextView;
        if ((localTextView != null) && (this.mLoadingAdBarLayout != null) && (this.mUiHandler != null))
        {
          localTextView.setText((CharSequence)localObject);
          int i = QzoneConfig.getInstance().getConfig("qqminiapp", "loading_ad_bar_show_time", 1000);
          this.mUiHandler.postDelayed(new MiniLoadingAdLayout.2(this), i);
        }
      }
    }
  }
  
  private void startCountDown(MiniLoadingAdLayout.OnDismissListener paramOnDismissListener)
  {
    this.mUiHandler = new Handler(Looper.getMainLooper());
    this.mCountdownRunnable = new MiniLoadingAdLayout.3(this, paramOnDismissListener);
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
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wesley dispatchTouchEvent ");
    localStringBuilder.append(paramMotionEvent.getAction());
    localStringBuilder.append(" x:");
    localStringBuilder.append(paramMotionEvent.getX());
    localStringBuilder.append("  y:");
    localStringBuilder.append(paramMotionEvent.getY());
    QLog.d("MiniLoadingAdLayout", 1, localStringBuilder.toString());
    try
    {
      int i = (int)(paramMotionEvent.getX() / this.densityDpi);
      int j = (int)(paramMotionEvent.getY() / this.densityDpi);
      if (paramMotionEvent.getAction() == 0)
      {
        this.lastTouchDownX = i;
        this.lastTouchDownY = j;
        this.touchStamp = System.currentTimeMillis();
      }
      else if (paramMotionEvent.getAction() == 1)
      {
        this.lastTouchUpX = i;
        this.lastTouchUpY = j;
        this.pressInterval = (System.currentTimeMillis() - this.touchStamp);
      }
    }
    catch (Exception localException)
    {
      QLog.e("MiniLoadingAdLayout", 1, "dispatchTouchEvent failed,", localException);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean setupUI(MiniAppConfig paramMiniAppConfig, boolean paramBoolean, String paramString, GdtAd paramGdtAd)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramString)) && (paramGdtAd != null))
    {
      this.mAdInfo = paramGdtAd;
      this.mMiniAppConfig = paramMiniAppConfig;
      adjustUI(paramBoolean, paramMiniAppConfig.config.name, URLDecoder.decode(paramMiniAppConfig.config.iconUrl), paramMiniAppConfig.config.developerDesc, paramString, false, null);
      return true;
    }
    return false;
  }
  
  public boolean setupUIForSDK(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, long paramLong2, AdProxy.ILoadingAdListener paramILoadingAdListener)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      paramString1 = AdUtils.convertJson2GdtAds(paramString1);
      if ((paramString1 != null) && (!paramString1.isEmpty()))
      {
        this.miniAppInfo = paramMiniAppInfo;
        this.showTimeStamp = paramLong1;
        this.requestAdTimeStamp = paramLong2;
        this.mAdInfo = ((GdtAd)paramString1.get(0));
        adjustUI(paramBoolean, paramString2, paramString3, paramString4, paramString5, true, paramILoadingAdListener);
        return true;
      }
      QLog.i("MiniLoadingAdLayout", 1, "setupUIForSDK ads is empty");
      return false;
    }
    QLog.i("MiniLoadingAdLayout", 1, "setupUIForSDK adJson||name||iconUrl is empty");
    return false;
  }
  
  public void show(MiniLoadingAdLayout.OnDismissListener paramOnDismissListener)
  {
    setVisibility(0);
    this.showAdStamp = System.currentTimeMillis();
    startCountDown(paramOnDismissListener);
    if (!this.selectSecondOption) {
      startAdBarAnimation();
    } else {
      showAdBar();
    }
    showPublicationInfo();
    Object localObject = this.mAdInfo;
    if ((localObject != null) && (((GdtAd)localObject).info != null) && (this.mAdInfo.info.report_info != null) && (this.mAdInfo.info.report_info.exposure_url != null))
    {
      localObject = createLoadingAntiParamForExpoCGI(this.miniAppInfo);
      Bundle localBundle = createLoadingAntiParamForExpoReportServer(this.miniAppInfo, this.mAdInfo.info.report_info.exposure_url.get());
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("report expo antiSpamParams=");
        localStringBuilder.append(((JSONObject)localObject).toString());
        QLog.i("MiniLoadingAdLayout", 1, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mAdInfo.info.report_info.exposure_url.get());
        localStringBuilder.append("&s=");
        localStringBuilder.append(URLEncoder.encode(((JSONObject)localObject).toString(), "utf-8"));
        reportToGdt(localStringBuilder.toString(), this.showAdStamp);
        report(localBundle);
      }
      catch (Exception localException)
      {
        QLog.e("MiniLoadingAdLayout", 1, "reportToGdt failed", localException);
      }
    }
    this.mLoadingAdSkipBtn.setOnClickListener(new MiniLoadingAdLayout.1(this, paramOnDismissListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout
 * JD-Core Version:    0.7.0.1
 */