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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.ui.dialog.DisplayHelper;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
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
  private GdtAppReceiver mGdtAppReceiver;
  private ImageView mLoadingAdImgView;
  private TextView mLoadingAdSkipBtn;
  private MiniAppConfig mMiniAppConfig;
  private RelativeLayout mRightContainer;
  private Handler mUiHandler;
  private com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo;
  private long pressInterval;
  private long requestAdTimeStamp;
  private long showAdStamp;
  private int showSkipTime = this.countdownTime - QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_skip_time", 1);
  private long showTimeStamp;
  private long touchStamp;
  
  public MiniLoadingAdLayout(Context paramContext)
  {
    super(paramContext);
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_auto_download", 0) == 1) {}
    for (;;)
    {
      this.autoDownload = bool;
      this.densityDpi = 1.0F;
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
      this.densityDpi = 1.0F;
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
      this.densityDpi = 1.0F;
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
      localObject = anvx.a(2131693963);
    }
    this.isGame = paramBoolean1;
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
        paramString3 = anvx.a(2131693963);
      }
      this.mDeveloperDescView.setText(anvx.a(2131704487) + paramString3 + anvx.a(2131704486));
      localObject = (RelativeLayout.LayoutParams)this.mCountdownContainer.getLayoutParams();
      paramString3 = (RelativeLayout.LayoutParams)this.mRightContainer.getLayoutParams();
      if (!paramBoolean1) {
        break label337;
      }
      if (!LiuHaiUtils.b()) {
        break label323;
      }
      i = ImmersiveUtils.getStatusBarHeight(getContext()) + DisplayUtil.dip2px(getContext(), 10.0F);
      label223:
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
      if (paramBoolean2) {
        this.mRightContainer.setVisibility(8);
      }
      return;
      i = 8;
      break;
      label323:
      i = DisplayUtil.dip2px(getContext(), 10.0F);
      break label223;
      label337:
      ((RelativeLayout.LayoutParams)localObject).topMargin = (ImmersiveUtils.getStatusBarHeight(getContext()) + DisplayUtil.dip2px(getContext(), 10.0F));
      paramString3.topMargin = (ImmersiveUtils.getStatusBarHeight(getContext()) + DisplayUtil.dip2px(getContext(), 10.0F));
      paramString4 = this.mAppNameView;
    }
  }
  
  /* Error */
  private JSONObject createLoadingAntiParamForClickCGI(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 276	com/tencent/mobileqq/mini/widget/MiniLoadingAdLayout:createLoadingAntiParamForExpoCGI	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)Lorg/json/JSONObject;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnonnull +92 -> 99
    //   10: new 278	org/json/JSONObject
    //   13: dup
    //   14: invokespecial 279	org/json/JSONObject:<init>	()V
    //   17: astore_2
    //   18: aload_2
    //   19: astore_1
    //   20: aload_1
    //   21: ldc_w 281
    //   24: aload_0
    //   25: getfield 283	com/tencent/mobileqq/mini/widget/MiniLoadingAdLayout:lastTouchDownX	I
    //   28: invokevirtual 287	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   31: pop
    //   32: aload_1
    //   33: ldc_w 289
    //   36: aload_0
    //   37: getfield 291	com/tencent/mobileqq/mini/widget/MiniLoadingAdLayout:lastTouchDownY	I
    //   40: invokevirtual 287	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload_1
    //   45: ldc_w 293
    //   48: aload_0
    //   49: getfield 295	com/tencent/mobileqq/mini/widget/MiniLoadingAdLayout:lastTouchUpX	I
    //   52: invokevirtual 287	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   55: pop
    //   56: aload_1
    //   57: ldc_w 297
    //   60: aload_0
    //   61: getfield 299	com/tencent/mobileqq/mini/widget/MiniLoadingAdLayout:lastTouchUpY	I
    //   64: invokevirtual 287	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   67: pop
    //   68: aload_1
    //   69: ldc_w 301
    //   72: aload_0
    //   73: getfield 303	com/tencent/mobileqq/mini/widget/MiniLoadingAdLayout:pressInterval	J
    //   76: invokevirtual 306	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   79: pop
    //   80: aload_1
    //   81: areturn
    //   82: astore_2
    //   83: ldc 14
    //   85: iconst_1
    //   86: ldc_w 308
    //   89: aload_2
    //   90: invokestatic 314	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   93: aload_1
    //   94: areturn
    //   95: astore_2
    //   96: goto -13 -> 83
    //   99: goto -79 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	MiniLoadingAdLayout
    //   0	102	1	paramMiniAppInfo	com.tencent.qqmini.sdk.launcher.model.MiniAppInfo
    //   17	2	2	localJSONObject	JSONObject
    //   82	8	2	localException1	Exception
    //   95	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   10	18	82	java/lang/Exception
    //   20	80	95	java/lang/Exception
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
      int i;
      int j;
      QLog.e("MiniLoadingAdLayout", 1, "createLoadingAntiParamForExpoCGI failed", localException1);
    }
    catch (Exception localException1)
    {
      try
      {
        i = DisplayHelper.getScreenWidth(getContext());
        j = DisplayHelper.getScreenHeight(getContext());
        paramMiniAppInfo.put("da", (int)(i / this.densityDpi));
        paramMiniAppInfo.put("db", (int)(j / this.densityDpi));
        paramMiniAppInfo.put("px", 0);
        paramMiniAppInfo.put("py", 0);
        paramMiniAppInfo.put("x", 0);
        return paramMiniAppInfo;
      }
      catch (Exception localException2)
      {
        break label89;
      }
      localException1 = localException1;
      paramMiniAppInfo = null;
    }
    label89:
    return paramMiniAppInfo;
  }
  
  private Bundle createLoadingAntiParamForExpoReportServer(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo, String paramString)
  {
    int i = 0;
    localBundle = new Bundle();
    try
    {
      localBundle.putInt("at", 0);
      localBundle.putInt("cn_t", getNetworkType());
      localBundle.putLong("et", this.showAdStamp);
      localBundle.putInt("fh", 0);
      localBundle.putInt("ic", 0);
      if (this.isGame) {
        i = 1;
      }
      localBundle.putInt("ig", i);
      localBundle.putLong("it", this.requestAdTimeStamp);
      localBundle.putInt("lt", 2);
      localBundle.putInt("s", 0);
      localBundle.putInt("sc_s", paramMiniAppInfo.launchParam.scene);
      localBundle.putString("sc_sn", getExtraInfo(paramMiniAppInfo));
      if (paramMiniAppInfo.launchParam.launchClickTimeMillis != 0L) {}
      for (long l = paramMiniAppInfo.launchParam.launchClickTimeMillis;; l = this.showTimeStamp)
      {
        localBundle.putLong("st", l);
        localBundle.putString("viewid", parseViewId(paramString));
        localBundle.putString("wlv", StorageUtil.getPreference().getString("version", "1.19.0.00043"));
        return localBundle;
      }
      return localBundle;
    }
    catch (Exception paramMiniAppInfo)
    {
      QLog.e("MiniLoadingAdLayout", 1, "createLoadingAntiParamForExpoReportServer failed", paramMiniAppInfo);
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
    catch (Exception paramMiniAppInfo) {}
    return "";
  }
  
  private int getNetworkType()
  {
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext().getApplicationContext());
    int i;
    if (j == 5) {
      i = 0;
    }
    do
    {
      return i;
      i = j;
    } while (j != 6);
    return 7;
  }
  
  private void initUI()
  {
    LayoutInflater.from(getContext()).inflate(2131559465, this, true);
    this.mAppLayout = ((RelativeLayout)findViewById(2131371357));
    this.mGameLayout = ((RelativeLayout)findViewById(2131371363));
    this.mRightContainer = ((RelativeLayout)findViewById(2131365153));
    this.mCloseBtn = ((ImageView)findViewById(2131363866));
    this.mCountdownContainer = ((RelativeLayout)findViewById(2131371359));
    this.mCountdownTextView = ((TextView)findViewById(2131370451));
    this.mLoadingAdSkipBtn = ((TextView)findViewById(2131371365));
    this.mDeveloperDescView = ((TextView)findViewById(2131365582));
    this.mAppNameView = ((TextView)findViewById(2131371358));
    this.mGameNameView = ((TextView)findViewById(2131371364));
    this.mAppLogoView = ((ImageView)findViewById(2131371356));
    this.mGameLogoView = ((ImageView)findViewById(2131371361));
    this.mLoadingAdImgView = ((ImageView)findViewById(2131370452));
    this.densityDpi = DisplayHelper.getDensity(getContext());
  }
  
  private void negativeReport() {}
  
  private static String parseViewId(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = Uri.parse(paramString).getQueryParameter("viewid");
      paramString = str;
    } while (str != null);
    return "";
  }
  
  public static void report(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    QLog.i("MiniLoadingAdLayout", 1, "reportParams=" + paramBundle.toString());
    ThreadManager.excute(new MiniLoadingAdLayout.5(paramBundle), 128, null, true);
  }
  
  private void reportToGdt(String paramString, long paramLong)
  {
    QLog.i("MiniLoadingAdLayout", 1, "yuki reportToGdt LoadingAd reportUrl = " + paramString);
    if ((TextUtils.isEmpty(paramString)) || (!URLUtil.isNetworkUrl(paramString))) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(new MiniLoadingAdLayout.4(this, paramString));
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
    QLog.d("MiniLoadingAdLayout", 1, "wesley dispatchTouchEvent " + paramMotionEvent.getAction() + " x:" + paramMotionEvent.getX() + "  y:" + paramMotionEvent.getY());
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
      for (;;)
      {
        return super.dispatchTouchEvent(paramMotionEvent);
        if (paramMotionEvent.getAction() == 1)
        {
          this.lastTouchUpX = i;
          this.lastTouchUpY = j;
          this.pressInterval = (System.currentTimeMillis() - this.touchStamp);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MiniLoadingAdLayout", 1, "dispatchTouchEvent failed,", localException);
      }
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
  
  public boolean setupUIForSDK(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, long paramLong2, AdProxy.ILoadingAdListener paramILoadingAdListener)
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
    this.miniAppInfo = paramMiniAppInfo;
    this.showTimeStamp = paramLong1;
    this.requestAdTimeStamp = paramLong2;
    this.mAdInfo = ((GdtAd)paramString1.get(0));
    adjustUI(paramBoolean, paramString2, paramString3, paramString4, paramString5, true, paramILoadingAdListener);
    return true;
  }
  
  public void show(MiniLoadingAdLayout.OnDismissListener paramOnDismissListener)
  {
    setVisibility(0);
    this.showAdStamp = System.currentTimeMillis();
    startCountDown(paramOnDismissListener);
    JSONObject localJSONObject;
    Bundle localBundle;
    if ((this.mAdInfo != null) && (this.mAdInfo.info != null) && (this.mAdInfo.info.report_info != null) && (this.mAdInfo.info.report_info.exposure_url != null))
    {
      localJSONObject = createLoadingAntiParamForExpoCGI(this.miniAppInfo);
      localBundle = createLoadingAntiParamForExpoReportServer(this.miniAppInfo, this.mAdInfo.info.report_info.exposure_url.get());
    }
    try
    {
      QLog.i("MiniLoadingAdLayout", 1, "report expo antiSpamParams=" + localJSONObject.toString());
      reportToGdt(this.mAdInfo.info.report_info.exposure_url.get() + "&s=" + URLEncoder.encode(localJSONObject.toString(), "utf-8"), this.showAdStamp);
      report(localBundle);
      this.mLoadingAdSkipBtn.setOnClickListener(new MiniLoadingAdLayout.2(this, paramOnDismissListener));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MiniLoadingAdLayout", 1, "reportToGdt failed", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout
 * JD-Core Version:    0.7.0.1
 */