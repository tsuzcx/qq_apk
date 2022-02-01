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

public class ScanTorchActivity
  extends OlympicToolBaseActivity
  implements Handler.Callback, ScreenshotObserver.Listener
{
  public static boolean a = false;
  public static boolean b = false;
  public static boolean c = false;
  public int a;
  public long a;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  public Handler a;
  public RelativeLayout a;
  public ARArguments a;
  public RemoteArConfigManager a;
  public ScanEntryResourceDelegate a;
  PromotionUtils.BasePromotionInfo jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo = null;
  private ScanEntryProviderContainerView jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView;
  private ScanGLRenderEnvFragment jdField_a_of_type_ComTencentMobileqqArViewScanGLRenderEnvFragment;
  private ScreenshotObserver jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver;
  public String a;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private QQBroadcastReceiver jdField_a_of_type_MqqAppQQBroadcastReceiver = new ScanTorchActivity.3(this);
  private int b;
  public long b;
  public String b;
  private int jdField_c_of_type_Int;
  public long c;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int = 0;
  long jdField_d_of_type_Long = -1L;
  public boolean d;
  private long jdField_e_of_type_Long = -1L;
  volatile boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long;
  volatile boolean jdField_f_of_type_Boolean = false;
  private long jdField_g_of_type_Long;
  boolean jdField_g_of_type_Boolean = false;
  private long jdField_h_of_type_Long;
  private boolean jdField_h_of_type_Boolean = false;
  private boolean i = false;
  private boolean j = true;
  private boolean k = false;
  private boolean l;
  private boolean m;
  private boolean n;
  
  public ScanTorchActivity()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_Long = -1L;
  }
  
  private static String a(int paramInt)
  {
    return String.format("%.2f", new Object[] { Float.valueOf(paramInt / 1000.0F) });
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    Object localObject1 = getIntent();
    Object localObject2;
    if (localObject1 != null)
    {
      ((Intent)localObject1).setExtrasClassLoader(ScanTorchActivity.class.getClassLoader());
      jdField_b_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("log_on", false);
      this.jdField_b_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("CurrentNickname");
      localObject2 = ((Intent)localObject1).getBundleExtra("web_invoke_params");
      if (QLog.isDevelopLevel()) {
        QQAudioHelper.a("ScanTorchActivity.initData", (Bundle)localObject2);
      }
      long l1;
      if (localObject2 != null) {
        l1 = ((Bundle)localObject2).getLong("PromotionType", 0L);
      } else {
        l1 = 0L;
      }
      if (l1 == 2L)
      {
        localObject1 = localObject2;
      }
      else if (l1 == 3L)
      {
        this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo = new PromotionUtils.ARTransferDoorInfo();
        this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (Bundle)localObject2);
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = localObject2;
        if (l1 == 1L)
        {
          this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo = new PromotionUtils.NormalPromotionInfo();
          this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (Bundle)localObject2);
          localObject1 = localObject2;
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo = new PromotionUtils.NonePromotion();
      QLog.w("ScanTorchActivity", 1, "initData, 没有运营数据");
    }
    this.jdField_a_of_type_ComTencentMobileqqArARArguments = new ARArguments(false);
    this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager = new RemoteArConfigManager();
    this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate = new ScanEntryResourceDelegate(this, this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager);
    f();
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo;
      if (((localObject2 instanceof PromotionUtils.NormalPromotionInfo)) && ((((PromotionUtils.BasePromotionInfo)localObject2).jdField_a_of_type_Long & 0x1000) != 0L))
      {
        this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo = new PromotionUtils.ARTransferDoorInfo();
        this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (Bundle)localObject1);
        if (TextUtils.isEmpty(((PromotionUtils.ARTransferDoorInfo)this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo).jdField_a_of_type_JavaLangString)) {
          ((PromotionUtils.ARTransferDoorInfo)this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo).jdField_a_of_type_JavaLangString = "-1";
        }
        if (QLog.isColorLevel()) {
          QLog.i("ScanTorchActivity", 2, "transfer Promotion to AR TransferPromotion");
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.a(this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo, this.j ^ true);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("initArConfig mArEnabled=%s", new Object[] { Boolean.valueOf(this.j) }));
    }
    if (!this.j) {
      return;
    }
    RemoteArConfigManager localRemoteArConfigManager = this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager;
    ScanEntryResourceDelegate localScanEntryResourceDelegate = this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate;
    localRemoteArConfigManager.a(this, true, localScanEntryResourceDelegate, localScanEntryResourceDelegate, localScanEntryResourceDelegate);
    this.jdField_h_of_type_Long = System.currentTimeMillis();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376809));
    h();
    i();
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView = ((ScanEntryProviderContainerView)findViewById(2131376918));
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.setScanRect(this.jdField_a_of_type_AndroidGraphicsRect, this.k ^ true);
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.setRenderEngine(this.jdField_a_of_type_ComTencentMobileqqArViewScanGLRenderEnvFragment.a());
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.setInitEnv(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.a();
    ThreadManager.getUIHandler().postDelayed(new ScanTorchActivity.2(this), 100L);
  }
  
  private void h()
  {
    ImmersiveUtils.getScreenWidth();
    ImmersiveUtils.getScreenHeight();
    int i2;
    int i1;
    if (QRScreenUtil.jdField_a_of_type_Int < QRScreenUtil.jdField_b_of_type_Int)
    {
      i2 = QRScreenUtil.jdField_a_of_type_Int;
      i1 = QRScreenUtil.jdField_b_of_type_Int;
    }
    else
    {
      i1 = QRScreenUtil.jdField_a_of_type_Int;
      i2 = QRScreenUtil.jdField_b_of_type_Int;
    }
    boolean bool;
    if (ImmersiveUtils.isSupporImmersive() != 1)
    {
      i1 -= ImmersiveUtils.getStatusBarHeight(this);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("initQrScanRectDisplay screenWidth=%s, screenHeight=%s, exclude=%b", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Boolean.valueOf(bool) }));
    }
    float f1 = ScanEntranceDPC.a().a;
    int i4 = (int)(Math.min(i1, i2) * f1);
    int i3 = i4;
    if (i4 <= 0) {
      i3 = AIOUtils.b(248.0F, getResources());
    }
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, i3, i3);
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    localRect.offset(i2 / 2 - localRect.centerX(), (int)(i1 / 2 - this.jdField_a_of_type_AndroidGraphicsRect.height() * 0.55F));
  }
  
  private void i()
  {
    if (!this.jdField_h_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArViewScanGLRenderEnvFragment != null) {
        return;
      }
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      this.jdField_a_of_type_ComTencentMobileqqArViewScanGLRenderEnvFragment = ScanGLRenderEnvFragment.a(null);
      localFragmentTransaction.add(2131362893, this.jdField_a_of_type_ComTencentMobileqqArViewScanGLRenderEnvFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      if (this.jdField_c_of_type_Long < 0L) {
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
    }
  }
  
  public long a()
  {
    return this.jdField_f_of_type_Long;
  }
  
  public void a(Uri paramUri)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = paramUri;
      if (paramUri == null) {
        localObject = "null";
      }
      QLog.d("ScanTorchActivity", 2, new Object[] { "onDetectScreenshot, uri=", localObject });
    }
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8006ABD", "0X8006ABD", 0, 0, "1", "", "", "");
  }
  
  public void a(boolean paramBoolean)
  {
    ARVideoRecordUIControllerImpl.a().b(4);
    setResult(11);
    finish();
  }
  
  public final boolean a()
  {
    return QQTheme.d(ThemeUtil.getCurrentThemeId());
  }
  
  public void b()
  {
    Intent localIntent = getIntent();
    long l1;
    if ((localIntent != null) && (this.jdField_e_of_type_Long > 0L) && (this.jdField_c_of_type_Long > 0L) && (this.jdField_b_of_type_Long > 0L))
    {
      l1 = localIntent.getLongExtra("click_time", 0L);
      int i1 = (int)(this.jdField_e_of_type_Long - l1);
      long l2 = this.jdField_b_of_type_Long;
      long l3 = this.jdField_c_of_type_Long;
      int i2 = (int)(l2 - l3);
      int i3 = (int)(l3 - l1);
      if ((i1 > 0) && (i2 > 0) && (i3 > 0))
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
        localHashMap.put("rcv_kill_broadcast", String.valueOf(this.jdField_b_of_type_Int));
        localHashMap.put("time_oncreate", a(i1));
        localHashMap.put("time_ar_ready", a(i2));
        localHashMap.put("time_add_fragment", a(i3));
        StatisticCollector.getInstance(this).collectPerformance("", "olympic_tool_proc_report", true, i2, 0L, localHashMap, "", true);
        if (QLog.isColorLevel()) {
          QLog.d("ScanTorchActivity", 2, new Object[] { "doReport, params=", localHashMap });
        }
      }
    }
    if (this.jdField_d_of_type_Long > 0L)
    {
      l1 = (System.currentTimeMillis() - this.jdField_d_of_type_Long) / 1000L;
      if (l1 < 7200L) {
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actARFaceRecog", true, l1, 0L, null, "", true);
      }
    }
  }
  
  public void c()
  {
    ScanEntryProviderContainerView localScanEntryProviderContainerView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView;
    if (localScanEntryProviderContainerView != null) {
      localScanEntryProviderContainerView.e();
    }
  }
  
  protected void d()
  {
    if (isFinishing()) {
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth();
    int i2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, String.format("updateQRRect [%d,%d]", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) }));
    }
    if ((i1 > 0) && (i2 > 0) && ((QRScreenUtil.jdField_a_of_type_Int != i1) || (QRScreenUtil.jdField_b_of_type_Int != i2)))
    {
      QRScreenUtil.jdField_a_of_type_Int = i1;
      QRScreenUtil.jdField_b_of_type_Int = i2;
      h();
      ScanEntryProviderContainerView localScanEntryProviderContainerView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView;
      if (localScanEntryProviderContainerView != null) {
        localScanEntryProviderContainerView.a(this.jdField_a_of_type_AndroidGraphicsRect);
      }
    }
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
    ScanEntryProviderContainerView localScanEntryProviderContainerView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView;
    if ((localScanEntryProviderContainerView != null) && (localScanEntryProviderContainerView.a())) {
      return;
    }
    a(true);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    int i1 = getResources().getDisplayMetrics().widthPixels;
    int i2 = getResources().getDisplayMetrics().heightPixels;
    boolean bool;
    if ((i1 == this.jdField_c_of_type_Int) && (i2 == this.jdField_d_of_type_Int)) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, String.format("doOnConfigurationChanged [%d,%d,%b]", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Boolean.valueOf(bool) }));
    }
    if (bool)
    {
      this.jdField_c_of_type_Int = i1;
      this.jdField_d_of_type_Int = i2;
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
    this.jdField_h_of_type_Boolean = false;
    this.jdField_e_of_type_Long = System.currentTimeMillis();
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
      setContentView(2131561265);
      if (isInMultiWindow())
      {
        QQToast.a(this, HardCodeUtil.a(2131713445), 0).a();
        finish();
        return true;
      }
      hideTitleBar();
      paramBundle = getIntent();
      if (paramBundle != null)
      {
        if (paramBundle.getBooleanExtra("from_qr", false)) {
          this.j = paramBundle.getBooleanExtra("ar_enabled", false);
        }
        if (!this.j) {
          this.k = paramBundle.getBooleanExtra("hide_album", false);
        }
      }
      g();
      e();
      if (this.jdField_a_of_type_MqqAppQQBroadcastReceiver != null)
      {
        paramBundle = new IntentFilter();
        paramBundle.addAction("com.tencent.mobileqq__alive");
        registerReceiver(this.jdField_a_of_type_MqqAppQQBroadcastReceiver, paramBundle);
      }
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver = new ScreenshotObserver(this.jdField_a_of_type_AndroidOsHandler, this);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver.a(this);
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.setUniformResManager(this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate);
      ScanEntranceReport.a().a();
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
      this.jdField_a_of_type_MqqAppQQBroadcastReceiver = null;
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
      localStringBuilder.append(this.jdField_e_of_type_Boolean);
      QLog.i("ScanTorchActivity", 2, localStringBuilder.toString());
    }
    if (this.jdField_e_of_type_Boolean) {
      AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8008614", "0X8008614", 0, 0, "", "", "", "");
    }
    if (NeonControl.a) {
      NeonControl.a().a();
    }
    try
    {
      if (this.jdField_a_of_type_MqqAppQQBroadcastReceiver != null) {
        unregisterReceiver(this.jdField_a_of_type_MqqAppQQBroadcastReceiver);
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    b();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.a();
        this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager = null;
      }
    }
    catch (Exception localException2)
    {
      QLog.d("ScanTorchActivity", 2, "doOnDestroy mArconfigManager unbind fail. ", localException2);
    }
    ScanEntryProviderContainerView localScanEntryProviderContainerView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView;
    if (localScanEntryProviderContainerView != null) {
      localScanEntryProviderContainerView.f();
    }
    super.doOnDestroy();
    if (a()) {
      ImmersiveUtils.setStatusTextColor(true, getWindow());
    }
    this.jdField_h_of_type_Boolean = true;
    QRUtils.a(this);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("doOnNewIntent filePath=%s", new Object[] { paramIntent }));
    }
    this.jdField_c_of_type_JavaLangString = paramIntent;
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnPause");
    }
    this.jdField_f_of_type_Boolean = true;
    ScanEntryProviderContainerView localScanEntryProviderContainerView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView;
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
    ScanEntryProviderContainerView localScanEntryProviderContainerView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView;
    if (localScanEntryProviderContainerView != null) {
      localScanEntryProviderContainerView.b();
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      localScanEntryProviderContainerView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView;
      if (localScanEntryProviderContainerView != null)
      {
        localScanEntryProviderContainerView.a(this.jdField_c_of_type_JavaLangString);
        this.jdField_c_of_type_JavaLangString = null;
      }
    }
    if ((isInMultiWindow()) && (!this.jdField_g_of_type_Boolean))
    {
      QQToast.a(this, HardCodeUtil.a(2131713444), 1).a();
      this.jdField_g_of_type_Boolean = true;
    }
    if (a()) {
      ImmersiveUtils.setStatusTextColor(false, getWindow());
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnStart");
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ScreenshotObserver localScreenshotObserver = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver;
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
    long l2 = this.jdField_a_of_type_Long;
    AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X80069CB", "0X80069CB", 0, 0, "1", String.valueOf(l1 - l2), "", "");
    ScreenshotObserver localScreenshotObserver = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver;
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
    //   2: invokespecial 862	com/tencent/mobileqq/olympic/activity/OlympicToolBaseActivity:doOnWindowFocusChanged	(Z)V
    //   5: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +36 -> 44
    //   11: ldc 200
    //   13: iconst_2
    //   14: ldc_w 864
    //   17: iconst_2
    //   18: anewarray 98	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: iload_1
    //   24: invokestatic 261	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: aload_0
    //   31: getfield 69	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:i	Z
    //   34: invokestatic 261	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   37: aastore
    //   38: invokestatic 111	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   41: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: monitorenter
    //   46: iload_1
    //   47: ifeq +29 -> 76
    //   50: aload_0
    //   51: getfield 866	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:n	Z
    //   54: ifne +22 -> 76
    //   57: aload_0
    //   58: iconst_1
    //   59: putfield 866	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:n	Z
    //   62: aload_0
    //   63: getfield 249	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView	Lcom/tencent/mobileqq/ar/view/ScanEntryProviderContainerView;
    //   66: ifnull +10 -> 76
    //   69: aload_0
    //   70: getfield 249	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView	Lcom/tencent/mobileqq/ar/view/ScanEntryProviderContainerView;
    //   73: invokevirtual 868	com/tencent/mobileqq/ar/view/ScanEntryProviderContainerView:d	()V
    //   76: aload_0
    //   77: monitorexit
    //   78: iload_1
    //   79: ifeq +10 -> 89
    //   82: aload_0
    //   83: invokestatic 272	java/lang/System:currentTimeMillis	()J
    //   86: putfield 870	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_g_of_type_Long	J
    //   89: iload_1
    //   90: ifeq +141 -> 231
    //   93: aload_0
    //   94: getfield 872	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:m	Z
    //   97: ifne +134 -> 231
    //   100: aload_0
    //   101: invokevirtual 122	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:getIntent	()Landroid/content/Intent;
    //   104: astore 6
    //   106: aload 6
    //   108: ifnull +111 -> 219
    //   111: aload 6
    //   113: ldc_w 473
    //   116: iconst_0
    //   117: invokevirtual 140	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   120: istore_1
    //   121: aload 6
    //   123: ldc_w 468
    //   126: lconst_0
    //   127: invokevirtual 471	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   130: lstore_2
    //   131: aload 6
    //   133: ldc_w 874
    //   136: lconst_0
    //   137: invokevirtual 471	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   140: lstore 4
    //   142: aload 6
    //   144: ldc_w 876
    //   147: invokevirtual 148	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   150: astore 6
    //   152: invokestatic 718	com/tencent/mobileqq/ar/ScanEntranceReport:a	()Lcom/tencent/mobileqq/ar/ScanEntranceReport;
    //   155: iload_1
    //   156: lload_2
    //   157: lload 4
    //   159: aload 6
    //   161: invokevirtual 879	com/tencent/mobileqq/ar/ScanEntranceReport:a	(ZJJLjava/lang/String;)V
    //   164: aload_0
    //   165: getfield 881	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:l	Z
    //   168: ifeq +51 -> 219
    //   171: lload_2
    //   172: lconst_0
    //   173: lcmp
    //   174: ifle +45 -> 219
    //   177: invokestatic 272	java/lang/System:currentTimeMillis	()J
    //   180: lstore 4
    //   182: ldc_w 882
    //   185: invokestatic 666	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   188: iconst_1
    //   189: anewarray 98	java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: lload 4
    //   196: lload_2
    //   197: lsub
    //   198: invokestatic 655	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   201: aastore
    //   202: invokestatic 111	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   205: astore 6
    //   207: aload_0
    //   208: iconst_0
    //   209: aload 6
    //   211: iconst_0
    //   212: invokestatic 885	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   215: invokevirtual 674	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   218: pop
    //   219: aload_0
    //   220: iconst_1
    //   221: putfield 872	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:m	Z
    //   224: aload_0
    //   225: invokestatic 272	java/lang/System:currentTimeMillis	()J
    //   228: putfield 420	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_f_of_type_Long	J
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
  
  public boolean handleMessage(Message paramMessage)
  {
    return true;
  }
  
  public void initNavigationBarColor() {}
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMultiWindowModeChanged");
    localStringBuilder.append(paramBoolean);
    QLog.i("ScanTorchActivity", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ScanTorchActivity
 * JD-Core Version:    0.7.0.1
 */