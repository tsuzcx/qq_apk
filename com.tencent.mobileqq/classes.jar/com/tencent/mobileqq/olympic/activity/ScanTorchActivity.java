package com.tencent.mobileqq.olympic.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARArguments;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.NeonControl;
import com.tencent.mobileqq.ar.RemoteArConfigManager;
import com.tencent.mobileqq.ar.ScanEntranceDPC;
import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate;
import com.tencent.mobileqq.ar.utils.PromotionUtils.ARTransferDoorInfo;
import com.tencent.mobileqq.ar.utils.PromotionUtils.BasePromotionInfo;
import com.tencent.mobileqq.ar.utils.PromotionUtils.NonePromotion;
import com.tencent.mobileqq.ar.utils.PromotionUtils.NormalPromotionInfo;
import com.tencent.mobileqq.ar.utils.QRScreenUtil;
import com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView;
import com.tencent.mobileqq.ar.view.ScanGLRenderEnvFragment;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qrscan.utils.QRUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AppIntefaceReportWrap;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import mqq.app.QQBroadcastReceiver;
import mqq.os.MqqHandler;

@RoutePage(desc="扫一扫AR火炬", path="/base/activity/ScanTorchActivity")
public class ScanTorchActivity
  extends OlympicToolBaseActivity
  implements Handler.Callback, ScreenshotObserver.Listener
{
  public static boolean IMMERSE_AR_SOFTWARE = false;
  public static final String KEY_ICON_TEXT = "icon_text";
  public static final String KEY_ICON_URL = "icon_url";
  public static final String KEY_JUMP_FROM_WEB = "jump_from_web";
  public static final String KEY_LOG_NO = "log_on";
  public static final String KEY_URL_FROM_WEB_SWITCH = "web_url_switch";
  public static final String TAG = "ScanTorchActivity";
  public static boolean specialTestOn = false;
  long firstGetFaceTrackResultTime = -1L;
  volatile boolean isPause = false;
  private long mARInitBeginTime;
  private long mActivityLastVisibleTime;
  private long mActivityVisibleTime;
  public long mAddFragmentTime = -1L;
  public ARArguments mArArguments;
  private boolean mArEnabled = true;
  public RemoteArConfigManager mArconfigManager;
  private long mConfigManagerBindTime;
  private long mConfigManagerInitTime;
  private long mConfigReadyTime;
  private int mCountBroadcast;
  public String mCurrentNickName;
  private String mGalleryFilePath;
  public boolean mHasArAnimStarted = false;
  private boolean mHasDestroy = false;
  boolean mHasDisplayMultiWindowTip = false;
  private boolean mHasFirstWindowFocus;
  private boolean mHideAlbum = false;
  private boolean mIsARViewLazyInit = false;
  public int mLastArAnimState = -1;
  private int mLastScreenH = 0;
  private int mLastScreenW;
  private boolean mLaunchDataReported;
  public String mLinkUrl = null;
  private HashMap<String, Integer> mLotteryMap = new HashMap();
  private boolean mNeedDownloadARResource;
  public long mOnStartTime;
  PromotionUtils.BasePromotionInfo mPromotionInfo = null;
  private QQBroadcastReceiver mReceiver = new ScanTorchActivity.3(this);
  private long mResourceCheckEndTime;
  public RelativeLayout mRoot;
  public ScanEntryResourceDelegate mScanEntryResManager;
  private ScanEntryProviderContainerView mScanEntryRootView;
  private ScanGLRenderEnvFragment mScanGLRenderFragment;
  Rect mScanRect;
  private ScreenshotObserver mScreenshotObserver;
  private boolean mShowDebugTips;
  public long mTimeArReady = -1L;
  private long mTimeOnCreate = -1L;
  public Handler mUiHandler;
  volatile boolean needReportRedDot;
  
  private void addScanGLEnvFragment()
  {
    if (!this.mHasDestroy)
    {
      if (this.mScanGLRenderFragment != null) {
        return;
      }
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      this.mScanGLRenderFragment = ScanGLRenderEnvFragment.a(null);
      localFragmentTransaction.add(2131428691, this.mScanGLRenderFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      if (this.mAddFragmentTime < 0L) {
        this.mAddFragmentTime = System.currentTimeMillis();
      }
    }
  }
  
  private static String format(int paramInt)
  {
    return String.format("%.2f", new Object[] { Float.valueOf(paramInt / 1000.0F) });
  }
  
  private void initArConfig()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("initArConfig mArEnabled=%s", new Object[] { Boolean.valueOf(this.mArEnabled) }));
    }
    if (!this.mArEnabled) {
      return;
    }
    RemoteArConfigManager localRemoteArConfigManager = this.mArconfigManager;
    ScanEntryResourceDelegate localScanEntryResourceDelegate = this.mScanEntryResManager;
    localRemoteArConfigManager.a(this, true, localScanEntryResourceDelegate, localScanEntryResourceDelegate, localScanEntryResourceDelegate);
    this.mConfigManagerInitTime = System.currentTimeMillis();
  }
  
  private void initData()
  {
    this.mUiHandler = new Handler(this);
    Object localObject1 = getIntent();
    Object localObject2;
    if (localObject1 != null)
    {
      ((Intent)localObject1).setExtrasClassLoader(ScanTorchActivity.class.getClassLoader());
      ScanTorchConstants.a = ((Intent)localObject1).getBooleanExtra("log_on", false);
      this.mCurrentNickName = ((Intent)localObject1).getStringExtra("CurrentNickname");
      localObject2 = ((Intent)localObject1).getBundleExtra("web_invoke_params");
      if (QLog.isDevelopLevel()) {
        QQAudioHelper.a("ScanTorchActivity.initData", (Bundle)localObject2);
      }
      long l;
      if (localObject2 != null) {
        l = ((Bundle)localObject2).getLong("PromotionType", 0L);
      } else {
        l = 0L;
      }
      if (l == 2L)
      {
        localObject1 = localObject2;
      }
      else if (l == 3L)
      {
        this.mPromotionInfo = new PromotionUtils.ARTransferDoorInfo();
        this.mPromotionInfo.b(this.app, (Bundle)localObject2);
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = localObject2;
        if (l == 1L)
        {
          this.mPromotionInfo = new PromotionUtils.NormalPromotionInfo();
          this.mPromotionInfo.b(this.app, (Bundle)localObject2);
          localObject1 = localObject2;
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    if (this.mPromotionInfo == null)
    {
      this.mPromotionInfo = new PromotionUtils.NonePromotion();
      QLog.w("ScanTorchActivity", 1, "initData, 没有运营数据");
    }
    this.mArArguments = new ARArguments(false);
    this.mArconfigManager = new RemoteArConfigManager();
    this.mScanEntryResManager = new ScanEntryResourceDelegate(this, this.mArconfigManager);
    initArConfig();
    if (localObject1 != null)
    {
      localObject2 = this.mPromotionInfo;
      if (((localObject2 instanceof PromotionUtils.NormalPromotionInfo)) && ((((PromotionUtils.BasePromotionInfo)localObject2).g & 0x1000) != 0L))
      {
        this.mPromotionInfo = new PromotionUtils.ARTransferDoorInfo();
        this.mPromotionInfo.b(this.app, (Bundle)localObject1);
        if (TextUtils.isEmpty(((PromotionUtils.ARTransferDoorInfo)this.mPromotionInfo).a)) {
          ((PromotionUtils.ARTransferDoorInfo)this.mPromotionInfo).a = "-1";
        }
        if (QLog.isColorLevel()) {
          QLog.i("ScanTorchActivity", 2, "transfer Promotion to AR TransferPromotion");
        }
      }
    }
    this.mScanEntryRootView.a(this.mPromotionInfo, this.mArEnabled ^ true);
  }
  
  private void initQrScanRectDisplay()
  {
    ImmersiveUtils.getScreenWidth();
    ImmersiveUtils.getScreenHeight();
    int j;
    int i;
    if (QRScreenUtil.a < QRScreenUtil.b)
    {
      j = QRScreenUtil.a;
      i = QRScreenUtil.b;
    }
    else
    {
      i = QRScreenUtil.a;
      j = QRScreenUtil.b;
    }
    boolean bool;
    if (ImmersiveUtils.isSupporImmersive() != 1)
    {
      i -= ImmersiveUtils.getStatusBarHeight(this);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("initQrScanRectDisplay screenWidth=%s, screenHeight=%s, exclude=%b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool) }));
    }
    float f = ScanEntranceDPC.a().c;
    int m = (int)(Math.min(i, j) * f);
    int k = m;
    if (m <= 0) {
      k = AIOUtils.b(248.0F, getResources());
    }
    this.mScanRect = new Rect(0, 0, k, k);
    Rect localRect = this.mScanRect;
    localRect.offset(j / 2 - localRect.centerX(), (int)(i / 2 - this.mScanRect.height() * 0.55F));
  }
  
  private void initView()
  {
    this.mRoot = ((RelativeLayout)findViewById(2131445137));
    initQrScanRectDisplay();
    addScanGLEnvFragment();
    this.mScanEntryRootView = ((ScanEntryProviderContainerView)findViewById(2131445272));
    this.mScanEntryRootView.setScanRect(this.mScanRect, this.mHideAlbum ^ true);
    this.mScanEntryRootView.setRenderEngine(this.mScanGLRenderFragment.c());
    this.mScanEntryRootView.setInitEnv(this.app, this);
    this.mScanEntryRootView.setEntranceType(getIntent().getIntExtra("key_entrance_type", 0));
    this.mScanEntryRootView.a();
    ThreadManager.getUIHandler().postDelayed(new ScanTorchActivity.2(this), 100L);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnBackPressed");
    }
    ScanEntryProviderContainerView localScanEntryProviderContainerView = this.mScanEntryRootView;
    if ((localScanEntryProviderContainerView != null) && (localScanEntryProviderContainerView.d())) {
      return;
    }
    doOnBackPressed(true);
  }
  
  public void doOnBackPressed(boolean paramBoolean)
  {
    ARVideoRecordUIControllerImpl.a().b(4);
    setResult(11);
    finish();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels;
    boolean bool;
    if ((i == this.mLastScreenW) && (j == this.mLastScreenH)) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, String.format("doOnConfigurationChanged [%d,%d,%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) }));
    }
    if (bool)
    {
      this.mLastScreenW = i;
      this.mLastScreenH = j;
      ThreadManager.getUIHandler().postDelayed(new ScanTorchActivity.4(this), 100L);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnCreate");
    }
    getWindow().setFormat(-3);
    getWindow().addFlags(128);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      if (Build.VERSION.SDK_INT > 28)
      {
        super.getWindow().addFlags(1024);
      }
      else
      {
        super.getWindow().addFlags(256);
        super.getWindow().addFlags(512);
      }
    }
    this.mHasDestroy = false;
    this.mTimeOnCreate = System.currentTimeMillis();
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    if (paramBundle != null) {}
    try
    {
      paramBundle.setClassLoader(ArConfigInfo.class.getClassLoader());
      long l2 = System.currentTimeMillis();
      if ((!Build.MODEL.equalsIgnoreCase("STF-AL10")) && (!Build.MODEL.equalsIgnoreCase("LON-AL00-PD")) && (!Build.MODEL.equalsIgnoreCase("vivo Y55A")) && (!Build.MODEL.equalsIgnoreCase("OPPO_R11st")) && (!Build.MODEL.equalsIgnoreCase("vivo_Xplay5A")) && (!Build.MODEL.equalsIgnoreCase("EML-AL00")) && (!Build.MODEL.equalsIgnoreCase("SM-G9250")) && (!Build.MODEL.equalsIgnoreCase("Pixel 2"))) {
        this.isClearCoverLayer = false;
      }
      super.doOnCreate(paramBundle);
      if (QLog.isColorLevel()) {
        QLog.i("ScanTorchActivity", 2, String.format("super.doOnCreate time cost:%sms SDK version %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), Integer.valueOf(Build.VERSION.SDK_INT) }));
      }
      setContentView(2131627621);
      if (isInMultiWindow())
      {
        QQToast.makeText(this, HardCodeUtil.a(2131910996), 0).show();
        finish();
        return true;
      }
      hideTitleBar();
      paramBundle = getIntent();
      if (paramBundle != null)
      {
        if (paramBundle.getBooleanExtra("from_qr", false)) {
          this.mArEnabled = paramBundle.getBooleanExtra("ar_enabled", false);
        }
        if (!this.mArEnabled) {
          this.mHideAlbum = paramBundle.getBooleanExtra("hide_album", false);
        }
      }
      initView();
      initData();
      if (this.mReceiver != null)
      {
        paramBundle = new IntentFilter();
        paramBundle.addAction("com.tencent.mobileqq__alive");
        registerReceiver(this.mReceiver, paramBundle);
      }
      this.mScreenshotObserver = new ScreenshotObserver(this.mUiHandler, this);
      this.mScreenshotObserver.a(this);
      this.mScanEntryRootView.setUniformResManager(this.mScanEntryResManager);
      ScanEntranceReport.a().b();
      if (Build.VERSION.SDK_INT >= 23) {
        if (checkSelfPermission("android.permission.CAMERA") != 0)
        {
          QLog.d("ScanTorchActivity", 1, "checkSelfPermission. not grant");
          requestPermissions(new ScanTorchActivity.1(this), 1, new String[] { "android.permission.CAMERA" });
        }
        else
        {
          QLog.d("ScanTorchActivity", 1, "checkSelfPermission. grant");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("ScanTorchActivity", 2, String.format("doOnCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
      }
      QQAudioHelper.a(this.mApp);
      return true;
    }
    catch (Exception paramBundle)
    {
      QLog.d("ScanTorchActivity", 1, "doOnCreate fail!", paramBundle);
      this.mReceiver = null;
      finish();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnDestroy,  needReportRedDot = ");
      localStringBuilder.append(this.needReportRedDot);
      QLog.i("ScanTorchActivity", 2, localStringBuilder.toString());
    }
    if (this.needReportRedDot) {
      AppIntefaceReportWrap.a(this.app, "dc00898", "", this.app.getCurrentAccountUin(), "0X8008614", "0X8008614", 0, 0, "", "", "", "");
    }
    if (NeonControl.b) {
      NeonControl.a().c();
    }
    try
    {
      if (this.mReceiver != null) {
        unregisterReceiver(this.mReceiver);
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    Object localObject = this.mUiHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.mLotteryMap;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    doReport();
    try
    {
      if (this.mArconfigManager != null)
      {
        this.mArconfigManager.a();
        this.mArconfigManager = null;
      }
    }
    catch (Exception localException2)
    {
      QLog.d("ScanTorchActivity", 2, "doOnDestroy mArconfigManager unbind fail. ", localException2);
    }
    ScanEntryProviderContainerView localScanEntryProviderContainerView = this.mScanEntryRootView;
    if (localScanEntryProviderContainerView != null) {
      localScanEntryProviderContainerView.g();
    }
    super.doOnDestroy();
    if (isNowSimpleUI()) {
      ImmersiveUtils.setStatusTextColor(true, getWindow());
    }
    this.mHasDestroy = true;
    QRUtils.a(this);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("doOnNewIntent filePath=%s", new Object[] { paramIntent }));
    }
    this.mGalleryFilePath = paramIntent;
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnPause");
    }
    this.isPause = true;
    ScanEntryProviderContainerView localScanEntryProviderContainerView = this.mScanEntryRootView;
    if (localScanEntryProviderContainerView != null) {
      localScanEntryProviderContainerView.c();
    }
    super.doOnPause();
  }
  
  protected void doOnPostResume()
  {
    super.doOnPostResume();
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnResume");
    }
    super.doOnResume();
    ScanEntryProviderContainerView localScanEntryProviderContainerView = this.mScanEntryRootView;
    if (localScanEntryProviderContainerView != null) {
      localScanEntryProviderContainerView.b();
    }
    if (!TextUtils.isEmpty(this.mGalleryFilePath))
    {
      localScanEntryProviderContainerView = this.mScanEntryRootView;
      if (localScanEntryProviderContainerView != null)
      {
        localScanEntryProviderContainerView.a(this.mGalleryFilePath);
        this.mGalleryFilePath = null;
      }
    }
    if ((isInMultiWindow()) && (!this.mHasDisplayMultiWindowTip))
    {
      QQToast.makeText(this, HardCodeUtil.a(2131910995), 1).show();
      this.mHasDisplayMultiWindowTip = true;
    }
    if (isNowSimpleUI()) {
      ImmersiveUtils.setStatusTextColor(false, getWindow());
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnStart");
    }
    this.mOnStartTime = System.currentTimeMillis();
    ScreenshotObserver localScreenshotObserver = this.mScreenshotObserver;
    if (localScreenshotObserver != null) {
      localScreenshotObserver.a();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnStop");
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.mOnStartTime;
    AppIntefaceReportWrap.a(this.app, "CliOper", "", "", "0X80069CB", "0X80069CB", 0, 0, "1", String.valueOf(l1 - l2), "", "");
    ScreenshotObserver localScreenshotObserver = this.mScreenshotObserver;
    if (localScreenshotObserver != null) {
      localScreenshotObserver.b();
    }
  }
  
  /* Error */
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 860	com/tencent/mobileqq/olympic/activity/OlympicToolBaseActivity:doOnWindowFocusChanged	(Z)V
    //   5: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +36 -> 44
    //   11: ldc 35
    //   13: iconst_2
    //   14: ldc_w 862
    //   17: iconst_2
    //   18: anewarray 190	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: iload_1
    //   24: invokestatic 216	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: aload_0
    //   31: getfield 123	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:mIsARViewLazyInit	Z
    //   34: invokestatic 216	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   37: aastore
    //   38: invokestatic 202	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   41: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: monitorenter
    //   46: iload_1
    //   47: ifeq +29 -> 76
    //   50: aload_0
    //   51: getfield 864	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:mHasFirstWindowFocus	Z
    //   54: ifne +22 -> 76
    //   57: aload_0
    //   58: iconst_1
    //   59: putfield 864	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:mHasFirstWindowFocus	Z
    //   62: aload_0
    //   63: getfield 360	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:mScanEntryRootView	Lcom/tencent/mobileqq/ar/view/ScanEntryProviderContainerView;
    //   66: ifnull +10 -> 76
    //   69: aload_0
    //   70: getfield 360	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:mScanEntryRootView	Lcom/tencent/mobileqq/ar/view/ScanEntryProviderContainerView;
    //   73: invokevirtual 867	com/tencent/mobileqq/ar/view/ScanEntryProviderContainerView:e	()V
    //   76: aload_0
    //   77: monitorexit
    //   78: iload_1
    //   79: ifeq +10 -> 89
    //   82: aload_0
    //   83: invokestatic 184	java/lang/System:currentTimeMillis	()J
    //   86: putfield 869	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:mActivityLastVisibleTime	J
    //   89: iload_1
    //   90: ifeq +141 -> 231
    //   93: aload_0
    //   94: getfield 871	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:mLaunchDataReported	Z
    //   97: ifne +134 -> 231
    //   100: aload_0
    //   101: invokevirtual 243	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:getIntent	()Landroid/content/Intent;
    //   104: astore 6
    //   106: aload 6
    //   108: ifnull +111 -> 219
    //   111: aload 6
    //   113: ldc_w 873
    //   116: iconst_0
    //   117: invokevirtual 259	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   120: istore_1
    //   121: aload 6
    //   123: ldc_w 875
    //   126: lconst_0
    //   127: invokevirtual 878	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   130: lstore_2
    //   131: aload 6
    //   133: ldc_w 880
    //   136: lconst_0
    //   137: invokevirtual 878	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   140: lstore 4
    //   142: aload 6
    //   144: ldc_w 882
    //   147: invokevirtual 269	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   150: astore 6
    //   152: invokestatic 698	com/tencent/mobileqq/ar/ScanEntranceReport:a	()Lcom/tencent/mobileqq/ar/ScanEntranceReport;
    //   155: iload_1
    //   156: lload_2
    //   157: lload 4
    //   159: aload 6
    //   161: invokevirtual 885	com/tencent/mobileqq/ar/ScanEntranceReport:a	(ZJJLjava/lang/String;)V
    //   164: aload_0
    //   165: getfield 887	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:mShowDebugTips	Z
    //   168: ifeq +51 -> 219
    //   171: lload_2
    //   172: lconst_0
    //   173: lcmp
    //   174: ifle +45 -> 219
    //   177: invokestatic 184	java/lang/System:currentTimeMillis	()J
    //   180: lstore 4
    //   182: ldc_w 888
    //   185: invokestatic 643	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   188: iconst_1
    //   189: anewarray 190	java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: lload 4
    //   196: lload_2
    //   197: lsub
    //   198: invokestatic 631	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   201: aastore
    //   202: invokestatic 202	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   205: astore 6
    //   207: aload_0
    //   208: iconst_0
    //   209: aload 6
    //   211: iconst_0
    //   212: invokestatic 891	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   215: invokevirtual 653	com/tencent/mobileqq/widget/QQToast:show	()Landroid/widget/Toast;
    //   218: pop
    //   219: aload_0
    //   220: iconst_1
    //   221: putfield 871	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:mLaunchDataReported	Z
    //   224: aload_0
    //   225: invokestatic 184	java/lang/System:currentTimeMillis	()J
    //   228: putfield 893	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:mActivityVisibleTime	J
    //   231: return
    //   232: astore 6
    //   234: aload_0
    //   235: monitorexit
    //   236: aload 6
    //   238: athrow
    //   239: astore 6
    //   241: goto -22 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	ScanTorchActivity
    //   0	244	1	paramBoolean	boolean
    //   130	67	2	l1	long
    //   140	55	4	l2	long
    //   104	106	6	localObject1	Object
    //   232	5	6	localObject2	Object
    //   239	1	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   50	76	232	finally
    //   76	78	232	finally
    //   234	236	232	finally
    //   207	219	239	java/lang/Exception
  }
  
  public void doReport()
  {
    Intent localIntent = getIntent();
    long l1;
    if ((localIntent != null) && (this.mTimeOnCreate > 0L) && (this.mAddFragmentTime > 0L) && (this.mTimeArReady > 0L))
    {
      l1 = localIntent.getLongExtra("click_time", 0L);
      int i = (int)(this.mTimeOnCreate - l1);
      long l2 = this.mTimeArReady;
      long l3 = this.mAddFragmentTime;
      int j = (int)(l2 - l3);
      int k = (int)(l3 - l1);
      if ((i > 0) && (j > 0) && (k > 0))
      {
        HashMap localHashMap = new HashMap();
        boolean bool = localIntent.getBooleanExtra("proc_exist", false);
        String str2 = "1";
        String str1;
        if (bool) {
          str1 = "1";
        } else {
          str1 = "0";
        }
        localHashMap.put("proc_exist", str1);
        if (localIntent.getBooleanExtra("first_click", false)) {
          str1 = str2;
        } else {
          str1 = "0";
        }
        localHashMap.put("first_click", str1);
        localHashMap.put("rcv_kill_broadcast", String.valueOf(this.mCountBroadcast));
        localHashMap.put("time_oncreate", format(i));
        localHashMap.put("time_ar_ready", format(j));
        localHashMap.put("time_add_fragment", format(k));
        StatisticCollector.getInstance(this).collectPerformance("", "olympic_tool_proc_report", true, j, 0L, localHashMap, "", true);
        if (QLog.isColorLevel()) {
          QLog.d("ScanTorchActivity", 2, new Object[] { "doReport, params=", localHashMap });
        }
      }
    }
    if (this.firstGetFaceTrackResultTime > 0L)
    {
      l1 = (System.currentTimeMillis() - this.firstGetFaceTrackResultTime) / 1000L;
      if (l1 < 7200L) {
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actARFaceRecog", true, l1, 0L, null, "", true);
      }
    }
  }
  
  public long getTimeActivityVisible()
  {
    return this.mActivityVisibleTime;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return true;
  }
  
  public void initNavigationBarColor() {}
  
  public final boolean isNowSimpleUI()
  {
    return QQTheme.isThemeSimpleDayUI(ThemeUtil.getCurrentThemeId());
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void notifyRenderReady()
  {
    ScanEntryProviderContainerView localScanEntryProviderContainerView = this.mScanEntryRootView;
    if (localScanEntryProviderContainerView != null) {
      localScanEntryProviderContainerView.f();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDetectScreenshot(Uri paramUri)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = paramUri;
      if (paramUri == null) {
        localObject = "null";
      }
      QLog.d("ScanTorchActivity", 2, new Object[] { "onDetectScreenshot, uri=", localObject });
    }
    if (!this.mHasArAnimStarted) {
      return;
    }
    AppIntefaceReportWrap.a(this.app, "CliOper", "", "", "0X8006ABD", "0X8006ABD", 0, 0, "1", "", "", "");
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMultiWindowModeChanged");
    localStringBuilder.append(paramBoolean);
    QLog.i("ScanTorchActivity", 2, localStringBuilder.toString());
  }
  
  protected void updateQRRect()
  {
    if (isFinishing()) {
      return;
    }
    int i = this.mRoot.getWidth();
    int j = this.mRoot.getHeight();
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, String.format("updateQRRect [%d,%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    if ((i > 0) && (j > 0) && ((QRScreenUtil.a != i) || (QRScreenUtil.b != j)))
    {
      QRScreenUtil.a = i;
      QRScreenUtil.b = j;
      initQrScanRectDisplay();
      ScanEntryProviderContainerView localScanEntryProviderContainerView = this.mScanEntryRootView;
      if (localScanEntryProviderContainerView != null) {
        localScanEntryProviderContainerView.a(this.mScanRect);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ScanTorchActivity
 * JD-Core Version:    0.7.0.1
 */