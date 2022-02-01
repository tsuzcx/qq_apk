package com.tencent.mobileqq.kandian.ad.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.qwallet.temp.IQQAppInterfaceTemp;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.alphaplayer.AlphaPlayerListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.alphaplayer.AlphaPlayerView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdMiniGuide;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdReporter;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdShakeManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.backgroundcpu.BackgroundCpuMonitor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RIJAdShakeManagerImpl
  implements IRIJAdShakeManager
{
  private static final double EGG_H_W_R = 1.77857D;
  private static final double EGG_W_R = 0.787D;
  private static final int FLAG_EGG = 1;
  private static final int FLAG_TRANS = 0;
  private static final int SKIP_BTN_HEIGHT = 60;
  private static final int SKIP_BTN_WIDTH = 125;
  private static final int STAGE_2_DURATION = 2000;
  private static final int STAGE_2_DURATION_OUT = 6000;
  private static final String TAG = "RIJAdShakeManager";
  private static final long[] VIBRATOR_PATTERN = { 100L, 200L, 200L, 100L };
  private static int egg_h;
  private static int egg_w;
  private static boolean hasEgg;
  private static boolean isOutJumpLocal;
  private static boolean isShowJump;
  private static boolean isUserRsp;
  private static String landUrl;
  private View bgMask;
  private AlphaPlayerView bgVideoView;
  private ImageView bgView;
  private String chainId;
  private String eggBgImgPath;
  private String eggBgPath;
  private RelativeLayout eggCard;
  private String eggImgPath;
  private MediaPlayer eggMediaPlayer;
  private String eggVideoPath;
  private boolean forceHide;
  private boolean hasShake;
  private boolean isAdDismiss;
  private boolean isEggClickReported;
  private boolean isLooseReported;
  private boolean isSurpriseVideoPlaying;
  private View.OnClickListener mClickListener = new RIJAdShakeManagerImpl.1(this);
  private Context mContext;
  private IVideoPlayManager mVideoPlayManager;
  private VideoPlayParam mVideoPlayParam;
  private ReadInJoyAdMiniGuide miniGuideView;
  private String requestId;
  private FrameLayout rootView;
  private ShakeListener shakeListener = new RIJAdShakeManagerImpl.2(this);
  private TextView skipBtn;
  private RelativeLayout skipLayout;
  private String transPath;
  private AlphaPlayerView transView;
  
  private void buildEggBgView(FrameLayout paramFrameLayout)
  {
    this.bgView = new ImageView(this.mContext);
    this.bgView.setImageDrawable(getImageDrawable(this.eggBgImgPath));
    this.bgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.bgView.setOnClickListener(this.mClickListener);
    paramFrameLayout.addView(this.bgView, new FrameLayout.LayoutParams(-1, -1));
    this.bgMask = new View(this.mContext);
    this.bgMask.setBackgroundColor(Color.parseColor("#1A000000"));
    this.bgMask.setOnClickListener(this.mClickListener);
    paramFrameLayout.addView(this.bgMask, new FrameLayout.LayoutParams(-1, -1));
    this.bgVideoView = buildFullScreenVideoView(paramFrameLayout, this.eggBgPath, false, 1);
    this.bgVideoView.setOnClickListener(this.mClickListener);
  }
  
  private void buildEggCard(FrameLayout paramFrameLayout)
  {
    isUserRsp = false;
    this.isEggClickReported = false;
    if (!TextUtils.isEmpty(this.eggVideoPath))
    {
      buildEggVideoView(paramFrameLayout, this.eggVideoPath, false, egg_w, egg_h);
      reportEggCardVideoPlay();
    }
    else if (!TextUtils.isEmpty(this.eggImgPath))
    {
      buildEggImgView(paramFrameLayout, egg_w, egg_h);
      reportEggCardShow();
    }
    buildSkipBtn(paramFrameLayout);
  }
  
  private void buildEggImgView(FrameLayout paramFrameLayout, int paramInt1, int paramInt2)
  {
    Object localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setImageDrawable(getImageDrawable(this.eggImgPath));
    RoundCorneredRelativeLayout localRoundCorneredRelativeLayout = new RoundCorneredRelativeLayout(this.mContext);
    localRoundCorneredRelativeLayout.setRadius(16.0F, 16.0F, 16.0F, 16.0F);
    if (Build.VERSION.SDK_INT >= 21) {
      localRoundCorneredRelativeLayout.setElevation(7.0F);
    }
    localRoundCorneredRelativeLayout.addView((View)localObject, new RelativeLayout.LayoutParams(paramInt1, paramInt2));
    this.eggCard = new RelativeLayout(this.mContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.eggCard.addView(localRoundCorneredRelativeLayout, (ViewGroup.LayoutParams)localObject);
    this.eggCard.setOnClickListener(this.mClickListener);
    paramFrameLayout.addView(this.eggCard);
    handleUserNotRsp(false);
  }
  
  private void buildEggVideoView(FrameLayout paramFrameLayout, String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    SurfaceView localSurfaceView = new SurfaceView(this.mContext);
    localSurfaceView.getHolder().addCallback(new RIJAdShakeManagerImpl.4(this, paramString, paramBoolean));
    if (Build.VERSION.SDK_INT >= 21)
    {
      localSurfaceView.setOutlineProvider(new RIJAdShakeManagerImpl.5(this));
      localSurfaceView.setClipToOutline(true);
      localSurfaceView.setElevation(7.0F);
    }
    this.eggCard = new RelativeLayout(this.mContext);
    paramString = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    paramString.addRule(13);
    this.eggCard.addView(localSurfaceView, paramString);
    this.eggCard.setOnClickListener(this.mClickListener);
    paramFrameLayout.addView(this.eggCard);
  }
  
  private AlphaPlayerView buildFullScreenVideoView(FrameLayout paramFrameLayout, String paramString, boolean paramBoolean, int paramInt)
  {
    AlphaPlayerView localAlphaPlayerView = new AlphaPlayerView(this.mContext);
    localAlphaPlayerView.a(paramString, true, paramBoolean, true, createAlphaPlayerListener(paramInt));
    paramString = new FrameLayout.LayoutParams(-1, -1);
    paramString.gravity = 17;
    localAlphaPlayerView.setLayoutParams(paramString);
    paramFrameLayout.addView(localAlphaPlayerView);
    localAlphaPlayerView.a();
    return localAlphaPlayerView;
  }
  
  private void buildSkipBtn(FrameLayout paramFrameLayout)
  {
    this.skipBtn = new TextView(this.mContext);
    this.skipBtn.setText("跳过");
    this.skipBtn.setGravity(17);
    this.skipBtn.setTextSize(2, 12.0F);
    this.skipBtn.setTextColor(-1);
    this.skipBtn.setBackgroundColor(Color.parseColor("#4D000000"));
    this.skipBtn.setOnClickListener(this.mClickListener);
    RoundCorneredRelativeLayout localRoundCorneredRelativeLayout = new RoundCorneredRelativeLayout(this.mContext);
    localRoundCorneredRelativeLayout.setRadius(12.0F, 12.0F, 12.0F, 12.0F);
    localRoundCorneredRelativeLayout.addView(this.skipBtn, new RelativeLayout.LayoutParams(125, 60));
    this.skipLayout = new RelativeLayout(this.mContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11);
    localLayoutParams.setMargins(0, 200, 30, 0);
    this.skipLayout.addView(localRoundCorneredRelativeLayout, localLayoutParams);
    paramFrameLayout.addView(this.skipLayout);
  }
  
  private boolean checkAudio()
  {
    if ((!TextUtils.isEmpty(this.transPath)) && (!hasEgg)) {
      return true;
    }
    return (!TextUtils.isEmpty(this.transPath)) && (!TextUtils.isEmpty(this.eggBgImgPath)) && (!TextUtils.isEmpty(this.eggBgPath)) && ((!TextUtils.isEmpty(this.eggImgPath)) || (!TextUtils.isEmpty(this.eggVideoPath)));
  }
  
  private AlphaPlayerListener createAlphaPlayerListener(int paramInt)
  {
    return new RIJAdShakeManagerImpl.9(this, paramInt);
  }
  
  private void doJump(Activity paramActivity, VideoPlayParam paramVideoPlayParam, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (isShowJump) {
      return;
    }
    isShowJump = true;
    if ((paramBoolean1) && (!paramBoolean2))
    {
      if (!TextUtils.isEmpty(landUrl))
      {
        ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl(this.mContext, paramString);
        if (hasEgg)
        {
          reportEggAutoJump();
          return;
        }
        reportNoEggAutoJump();
      }
    }
    else
    {
      if (paramVideoPlayParam == null) {
        return;
      }
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).doActionAndReport(paramActivity, paramVideoPlayParam.D, null, 0, false, false, null);
    }
  }
  
  private void doShakeInteractiveReport(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (((paramAdvertisementInfo instanceof AdvertisementInfo)) && (hasEgg)) {
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramContext).a(1).b(31).a(paramAdvertisementInfo));
    }
  }
  
  private void doVibrate()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof AppInterface))
    {
      localObject = (AppInterface)localObject;
      int i;
      if (((IQQAppInterfaceTemp)QRoute.api(IQQAppInterfaceTemp.class)).getALLGeneralSettingVibrate((AppInterface)localObject) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject = (Vibrator)((AppInterface)localObject).getApp().getSystemService("vibrator");
        if (localObject != null) {
          ((Vibrator)localObject).vibrate(VIBRATOR_PATTERN, -1);
        }
      }
    }
  }
  
  private String getFilePath(String paramString)
  {
    int i = paramString.lastIndexOf('/');
    if (i != -1)
    {
      paramString = paramString.substring(i + 1);
      if (!TextUtils.isEmpty(paramString))
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(AppConstants.SDCARD_PATH);
        localStringBuilder2.append(".readInjoy/resource/shakeVideo/");
        localStringBuilder1.append(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder2.toString()));
        localStringBuilder1.append(paramString);
        return localStringBuilder1.toString();
      }
    }
    return "";
  }
  
  private BitmapDrawable getImageDrawable(String paramString)
  {
    try
    {
      Object localObject2 = new File(paramString);
      if (!((File)localObject2).exists()) {
        return null;
      }
      paramString = new ByteArrayOutputStream();
      localObject1 = new byte[1024];
      localObject2 = new FileInputStream((File)localObject2);
      for (int i = ((InputStream)localObject2).read((byte[])localObject1); i != -1; i = ((InputStream)localObject2).read((byte[])localObject1)) {
        paramString.write((byte[])localObject1, 0, i);
      }
      paramString = paramString.toByteArray();
      paramString = new BitmapDrawable(BitmapFactory.decodeByteArray(paramString, 0, paramString.length));
      return paramString;
    }
    catch (IOException paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getImageDrawable, IOException:");
      ((StringBuilder)localObject1).append(paramString.toString());
      QLog.e("RIJAdShakeManager", 2, ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  private String getPlayUri(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = getFilePath(paramString);
    if (!TextUtils.isEmpty(str))
    {
      File localFile = new File(str);
      if (localFile.exists()) {
        return localFile.getAbsolutePath();
      }
      ThreadManagerV2.executeOnSubThread(new -..Lambda.RIJAdShakeManagerImpl.QmNvUzx7sP1ar39p4UE4mkSU2d0(paramString, localFile));
    }
    return str;
  }
  
  private void handleUserNotRsp(boolean paramBoolean)
  {
    int i;
    if (isOutJumpLocal) {
      i = 6000;
    } else {
      i = 2000;
    }
    if (((!TextUtils.isEmpty(this.eggVideoPath)) && (!isOutJumpLocal)) || (paramBoolean)) {
      i = 0;
    }
    new Handler(Looper.getMainLooper()).postDelayed(new RIJAdShakeManagerImpl.3(this, paramBoolean), i);
  }
  
  private void playEggVideo(FrameLayout paramFrameLayout)
  {
    buildEggBgView(paramFrameLayout);
    buildEggCard(paramFrameLayout);
  }
  
  private void playEggVideo(String paramString, SurfaceHolder paramSurfaceHolder, boolean paramBoolean)
  {
    this.eggMediaPlayer = new MediaPlayer();
    try
    {
      this.eggMediaPlayer.setDataSource(paramString);
      this.eggMediaPlayer.setDisplay(paramSurfaceHolder);
      this.eggMediaPlayer.prepare();
      this.eggMediaPlayer.setVolume(1.0F, 1.0F);
      this.eggMediaPlayer.setLooping(paramBoolean);
      this.eggMediaPlayer.setOnPreparedListener(new RIJAdShakeManagerImpl.6(this, paramSurfaceHolder));
      this.eggMediaPlayer.setOnCompletionListener(new RIJAdShakeManagerImpl.7(this));
      return;
    }
    catch (Throwable paramString)
    {
      paramSurfaceHolder = new StringBuilder();
      paramSurfaceHolder.append("buildCenterVideoView Throwable:");
      paramSurfaceHolder.append(paramString.getMessage());
      QLog.e("RIJAdShakeManager", 2, paramSurfaceHolder.toString());
    }
  }
  
  private void prepareAudio(VideoPlayParam paramVideoPlayParam)
  {
    paramVideoPlayParam = (AdvertisementInfo)paramVideoPlayParam.D;
    this.transPath = getPlayUri(paramVideoPlayParam.shakeTransUrl);
    this.eggBgPath = getPlayUri(paramVideoPlayParam.shakeEggBgUrl);
    this.eggImgPath = getPlayUri(paramVideoPlayParam.shakeEggImgUrl);
    this.eggVideoPath = getPlayUri(paramVideoPlayParam.shakeEggVideoUrl);
    this.eggBgImgPath = getPlayUri(paramVideoPlayParam.shakeEggBgImgUrl);
  }
  
  private void removeAllView()
  {
    removeSingleView(this.skipLayout);
    removeSingleView(this.eggCard);
    removeSingleView(this.bgVideoView);
    removeSingleView(this.bgMask);
    removeSingleView(this.bgView);
    MediaPlayer localMediaPlayer = this.eggMediaPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.release();
      this.eggMediaPlayer = null;
    }
  }
  
  private void removeAllViewDelay(int paramInt)
  {
    new Handler().postDelayed(new RIJAdShakeManagerImpl.8(this), paramInt);
  }
  
  private void removeSingleView(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null)) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
  }
  
  private void reportEggAutoJump()
  {
    ((IRIJAdReporter)QRoute.api(IRIJAdReporter.class)).reportAdShake("click", "0", "0", "0", "0", "2", "0", "0");
  }
  
  private void reportEggCardClick()
  {
    IRIJAdReporter localIRIJAdReporter = (IRIJAdReporter)QRoute.api(IRIJAdReporter.class);
    String str;
    if (isOutJumpLocal) {
      str = "2";
    } else {
      str = "1";
    }
    localIRIJAdReporter.reportAdShake("click", "0", "0", "0", "2", "0", "0", str);
  }
  
  private void reportEggCardShow()
  {
    ((IRIJAdReporter)QRoute.api(IRIJAdReporter.class)).reportAdShake("expose", "0", "3", "0", "0", "0", "0", "0");
  }
  
  private void reportEggCardVideoPlay()
  {
    ((IRIJAdReporter)QRoute.api(IRIJAdReporter.class)).reportAdShake("interact", "0", "0", "1", "0", "0", "0", "0");
  }
  
  private void reportNoEggAutoJump()
  {
    ((IRIJAdReporter)QRoute.api(IRIJAdReporter.class)).reportAdShake("click", "0", "0", "0", "0", "3", "0", "0");
  }
  
  private void reportShake()
  {
    ((IRIJAdReporter)QRoute.api(IRIJAdReporter.class)).reportAdShake("interact", "0", "0", "0", "0", "0", "1", "0");
  }
  
  private void reportSkipClick()
  {
    ((IRIJAdReporter)QRoute.api(IRIJAdReporter.class)).reportAdShake("click", "0", "0", "0", "0", "1", "0", "0");
  }
  
  private void setEggSize(Context paramContext)
  {
    double d = paramContext.getResources().getDisplayMetrics().widthPixels;
    Double.isNaN(d);
    d *= 0.787D;
    egg_w = (int)d;
    egg_h = (int)(1.77857D * d);
  }
  
  public boolean hasEggReport()
  {
    return this.isEggClickReported;
  }
  
  public boolean hasShake()
  {
    return this.hasShake;
  }
  
  public boolean isComplainBackToFeeds()
  {
    return this.forceHide;
  }
  
  public boolean isSurpriseVideoPlaying()
  {
    return this.isSurpriseVideoPlaying;
  }
  
  public void onComplainBackToFeeds()
  {
    this.forceHide = true;
  }
  
  public void onDestory()
  {
    this.isAdDismiss = true;
    this.isLooseReported = false;
  }
  
  public void registerListener(Context paramContext, VideoPlayParam paramVideoPlayParam)
  {
    this.mContext = paramContext;
    this.mVideoPlayParam = paramVideoPlayParam;
    paramContext = this.mVideoPlayParam;
    if ((paramContext != null) && (paramContext.D != null))
    {
      isOutJumpLocal = ((AdvertisementInfo)this.mVideoPlayParam.D).isOutJump;
      landUrl = ((AdvertisementInfo)this.mVideoPlayParam.D).mAdLandingPage;
      boolean bool;
      if (((AdvertisementInfo)this.mVideoPlayParam.D).isShakeEggPage == 1) {
        bool = true;
      } else {
        bool = false;
      }
      hasEgg = bool;
      this.requestId = ((AdvertisementInfo)this.mVideoPlayParam.D).request_id;
      this.chainId = ((AdvertisementInfo)this.mVideoPlayParam.D).chain_id;
      ((IRIJAdReporter)QRoute.api(IRIJAdReporter.class)).init(this.requestId, this.chainId);
    }
    setEggSize(this.mContext);
    paramContext = (SensorManager)this.mContext.getSystemService("sensor");
    ShakeListener localShakeListener = this.shakeListener;
    Sensor localSensor = paramContext.getDefaultSensor(1);
    int i;
    if (BackgroundCpuMonitor.a().b()) {
      i = 2;
    } else {
      i = 0;
    }
    paramContext.registerListener(localShakeListener, localSensor, i);
    if (paramVideoPlayParam != null) {
      prepareAudio(paramVideoPlayParam);
    }
    this.forceHide = false;
    this.isAdDismiss = false;
    this.isEggClickReported = false;
  }
  
  public void reportAdClick()
  {
    ((IRIJAdReporter)QRoute.api(IRIJAdReporter.class)).reportAdShake("click", "0", "0", "0", "1", "0", "0", "0");
  }
  
  public void reportBigGuideShow()
  {
    ((IRIJAdReporter)QRoute.api(IRIJAdReporter.class)).reportAdShake("expose", "0", "2", "0", "0", "0", "0", "0");
  }
  
  public void reportExposeLoose()
  {
    if (this.isLooseReported) {
      return;
    }
    this.isLooseReported = true;
    ((IRIJAdReporter)QRoute.api(IRIJAdReporter.class)).reportAdShake("expose", "2", "0", "0", "0", "0", "0", "0");
  }
  
  public void reportExposeStrict()
  {
    ((IRIJAdReporter)QRoute.api(IRIJAdReporter.class)).reportAdShake("expose", "1", "0", "0", "0", "0", "0", "0");
  }
  
  public void reportMiniGuideShow()
  {
    ((IRIJAdReporter)QRoute.api(IRIJAdReporter.class)).reportAdShake("expose", "0", "1", "0", "0", "0", "0", "0");
  }
  
  public void reportNegative()
  {
    if (this.isAdDismiss) {
      return;
    }
    ((IRIJAdReporter)QRoute.api(IRIJAdReporter.class)).reportAdShake("negative_feedback", "0", "0", "0", "0", "0", "0", "0");
  }
  
  public void resetShake()
  {
    this.hasShake = false;
  }
  
  public void setEggVideoState(boolean paramBoolean)
  {
    try
    {
      if ((this.eggMediaPlayer != null) && (paramBoolean))
      {
        this.eggMediaPlayer.pause();
        return;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setEggVideoState:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", error=");
      localStringBuilder.append(localIllegalStateException.getMessage());
      QLog.e("RIJAdShakeManager", 2, localStringBuilder.toString());
    }
  }
  
  public void setGuideView(ReadInJoyAdMiniGuide paramReadInJoyAdMiniGuide)
  {
    this.miniGuideView = paramReadInJoyAdMiniGuide;
  }
  
  public void setSurpriseVideoPlayingState(boolean paramBoolean)
  {
    this.isSurpriseVideoPlaying = paramBoolean;
  }
  
  public void setVideoPlayerManager(IVideoPlayManager paramIVideoPlayManager)
  {
    this.mVideoPlayManager = paramIVideoPlayManager;
  }
  
  public void unRegisterListener()
  {
    Context localContext = this.mContext;
    if (localContext == null) {
      return;
    }
    ((SensorManager)localContext.getSystemService("sensor")).unregisterListener(this.shakeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdShakeManagerImpl
 * JD-Core Version:    0.7.0.1
 */