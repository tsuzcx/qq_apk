package com.tencent.mobileqq.olympic.activity;

import aekt;
import alpo;
import amnx;
import amqa;
import amtr;
import amtv;
import amuc;
import amud;
import anbr;
import ancc;
import ancd;
import ance;
import ancf;
import anch;
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
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.RelativeLayout;
import avxv;
import avxw;
import avxx;
import avxy;
import azib;
import azmz;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARArguments;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView;
import com.tencent.mobileqq.ar.view.ScanGLRenderEnvFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import mqq.app.QQBroadcastReceiver;
import mqq.os.MqqHandler;
import xwb;

public class ScanTorchActivity
  extends OlympicToolBaseActivity
  implements Handler.Callback, avxy
{
  public static boolean h;
  public static boolean i;
  public int a;
  public long a;
  public amtv a;
  public anbr a;
  ancd jdField_a_of_type_Ancd = null;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  public Handler a;
  public RelativeLayout a;
  private avxx jdField_a_of_type_Avxx;
  public ARArguments a;
  private ScanEntryProviderContainerView jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView;
  private ScanGLRenderEnvFragment jdField_a_of_type_ComTencentMobileqqArViewScanGLRenderEnvFragment;
  public String a;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private QQBroadcastReceiver jdField_a_of_type_MqqAppQQBroadcastReceiver = new avxw(this);
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  private int d;
  public long f = -1L;
  public long g = -1L;
  long h = -1L;
  private long i;
  private long j;
  public boolean j;
  private long jdField_k_of_type_Long;
  volatile boolean jdField_k_of_type_Boolean;
  private long jdField_l_of_type_Long;
  volatile boolean jdField_l_of_type_Boolean = false;
  boolean m = false;
  private boolean n;
  private boolean o;
  private boolean p = true;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  
  public ScanTorchActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_i_of_type_Long = -1L;
  }
  
  private static String a(int paramInt)
  {
    return String.format("%.2f", new Object[] { Float.valueOf(paramInt / 1000.0F) });
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    Object localObject2 = getIntent();
    Object localObject1 = null;
    if (localObject2 != null)
    {
      ((Intent)localObject2).setExtrasClassLoader(ScanTorchActivity.class.getClassLoader());
      jdField_i_of_type_Boolean = ((Intent)localObject2).getBooleanExtra("log_on", false);
      this.jdField_a_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("CurrentNickname");
      localObject2 = ((Intent)localObject2).getBundleExtra("web_invoke_params");
      if (QLog.isDevelopLevel()) {
        AudioHelper.a("ScanTorchActivity.initData", (Bundle)localObject2);
      }
      if (localObject2 == null) {
        break label387;
      }
    }
    label387:
    for (long l1 = ((Bundle)localObject2).getLong("PromotionType", 0L);; l1 = 0L)
    {
      if (l1 == 2L)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Ancd == null)
        {
          this.jdField_a_of_type_Ancd = new ance();
          QLog.w("ScanTorchActivity", 1, "initData, 没有运营数据");
        }
        this.jdField_a_of_type_ComTencentMobileqqArARArguments = new ARArguments(false);
        this.jdField_a_of_type_Amtv = new amtv();
        this.jdField_a_of_type_Anbr = new anbr(this, this.jdField_a_of_type_Amtv);
        l();
        if ((localObject1 != null) && ((this.jdField_a_of_type_Ancd instanceof ancf)) && ((this.jdField_a_of_type_Ancd.jdField_a_of_type_Long & 0x1000) != 0L))
        {
          this.jdField_a_of_type_Ancd = new ancc();
          this.jdField_a_of_type_Ancd.b(this.jdField_b_of_type_ComTencentCommonAppAppInterface, (Bundle)localObject1);
          if (TextUtils.isEmpty(((ancc)this.jdField_a_of_type_Ancd).jdField_a_of_type_JavaLangString)) {
            ((ancc)this.jdField_a_of_type_Ancd).jdField_a_of_type_JavaLangString = "-1";
          }
          if (QLog.isColorLevel()) {
            QLog.i("ScanTorchActivity", 2, "transfer Promotion to AR TransferPromotion");
          }
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView;
        localObject2 = this.jdField_a_of_type_Ancd;
        if (this.p) {
          break label382;
        }
      }
      label382:
      for (boolean bool = true;; bool = false)
      {
        ((ScanEntryProviderContainerView)localObject1).a((ancd)localObject2, bool);
        return;
        if (l1 == 3L)
        {
          this.jdField_a_of_type_Ancd = new ancc();
          this.jdField_a_of_type_Ancd.b(this.jdField_b_of_type_ComTencentCommonAppAppInterface, (Bundle)localObject2);
          localObject1 = localObject2;
          break;
        }
        localObject1 = localObject2;
        if (l1 != 1L) {
          break;
        }
        this.jdField_a_of_type_Ancd = new ancf();
        this.jdField_a_of_type_Ancd.b(this.jdField_b_of_type_ComTencentCommonAppAppInterface, (Bundle)localObject2);
        localObject1 = localObject2;
        break;
      }
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("initArConfig mArEnabled=%s", new Object[] { Boolean.valueOf(this.p) }));
    }
    if (!this.p) {
      return;
    }
    this.jdField_a_of_type_Amtv.a(this, true, this.jdField_a_of_type_Anbr, this.jdField_a_of_type_Anbr, this.jdField_a_of_type_Anbr, null);
    this.jdField_l_of_type_Long = System.currentTimeMillis();
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375981));
    n();
    o();
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView = ((ScanEntryProviderContainerView)findViewById(2131376086));
    ScanEntryProviderContainerView localScanEntryProviderContainerView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView;
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    if (!this.q) {}
    for (boolean bool = true;; bool = false)
    {
      localScanEntryProviderContainerView.setScanRect(localRect, bool);
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.setRenderEngine(this.jdField_a_of_type_ComTencentMobileqqArViewScanGLRenderEnvFragment.a());
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.setInitEnv(this.jdField_b_of_type_ComTencentCommonAppAppInterface, this);
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.a();
      ThreadManager.getUIHandler().postDelayed(new ScanTorchActivity.2(this), 100L);
      return;
    }
  }
  
  private void n()
  {
    ImmersiveUtils.a();
    ImmersiveUtils.b();
    int i2;
    int i1;
    if (anch.jdField_a_of_type_Int < anch.jdField_b_of_type_Int)
    {
      i2 = anch.jdField_a_of_type_Int;
      i1 = anch.jdField_b_of_type_Int;
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        break label184;
      }
      i1 -= ImmersiveUtils.getStatusBarHeight(this);
    }
    label184:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, String.format("initQrScanRectDisplay screenWidth=%s, screenHeight=%s, exclude=%b", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Boolean.valueOf(bool) }));
      }
      int i4 = (int)(amuc.a().a * Math.min(i1, i2));
      int i3 = i4;
      if (i4 <= 0) {
        i3 = aekt.a(248.0F, getResources());
      }
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, i3, i3);
      this.jdField_a_of_type_AndroidGraphicsRect.offset(i2 / 2 - this.jdField_a_of_type_AndroidGraphicsRect.centerX(), (int)(i1 / 2 - 0.55F * this.jdField_a_of_type_AndroidGraphicsRect.height()));
      return;
      i1 = anch.jdField_a_of_type_Int;
      i2 = anch.jdField_b_of_type_Int;
      break;
    }
  }
  
  private void o()
  {
    if ((this.n) || (this.jdField_a_of_type_ComTencentMobileqqArViewScanGLRenderEnvFragment != null)) {}
    do
    {
      return;
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      this.jdField_a_of_type_ComTencentMobileqqArViewScanGLRenderEnvFragment = ScanGLRenderEnvFragment.a(null);
      localFragmentTransaction.add(2131362745, this.jdField_a_of_type_ComTencentMobileqqArViewScanGLRenderEnvFragment);
      localFragmentTransaction.commitAllowingStateLoss();
    } while (this.g >= 0L);
    this.g = System.currentTimeMillis();
  }
  
  public long a()
  {
    return this.jdField_j_of_type_Long;
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
    if (!this.jdField_j_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X8006ABD", "0X8006ABD", 0, 0, "1", "", "", "");
  }
  
  public void a(boolean paramBoolean)
  {
    amqa.a().b(4);
    setResult(11);
    finish();
  }
  
  public final boolean b()
  {
    return azib.b(ThemeUtil.getCurrentThemeId());
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnBackPressed");
    }
    a(true);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    int i1 = getResources().getDisplayMetrics().widthPixels;
    int i2 = getResources().getDisplayMetrics().heightPixels;
    if ((i1 != this.c) || (i2 != this.d)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ScanTorchActivity", 2, String.format("doOnConfigurationChanged [%d,%d,%b]", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Boolean.valueOf(bool) }));
      }
      if (bool)
      {
        this.c = i1;
        this.d = i2;
        ThreadManager.getUIHandler().postDelayed(new ScanTorchActivity.4(this), 100L);
      }
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnCreate");
    }
    getWindow().setFormat(-3);
    getWindow().addFlags(128);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (Build.VERSION.SDK_INT <= 28) {
        break label284;
      }
      super.getWindow().addFlags(1024);
    }
    for (;;)
    {
      this.n = false;
      this.jdField_i_of_type_Long = System.currentTimeMillis();
      this.mNeedStatusTrans = true;
      this.mActNeedImmersive = false;
      if (paramBundle != null) {}
      try
      {
        paramBundle.setClassLoader(ArConfigInfo.class.getClassLoader());
        long l2 = System.currentTimeMillis();
        if ((Build.MODEL.equalsIgnoreCase("STF-AL10")) || (Build.MODEL.equalsIgnoreCase("LON-AL00-PD")) || (Build.MODEL.equalsIgnoreCase("vivo Y55A")) || (Build.MODEL.equalsIgnoreCase("OPPO_R11st")) || (Build.MODEL.equalsIgnoreCase("vivo_Xplay5A")) || (Build.MODEL.equalsIgnoreCase("EML-AL00")) || (Build.MODEL.equalsIgnoreCase("SM-G9250")) || (Build.MODEL.equalsIgnoreCase("Pixel 2"))) {}
        for (;;)
        {
          super.doOnCreate(paramBundle);
          if (QLog.isColorLevel()) {
            QLog.i("ScanTorchActivity", 2, String.format("super.doOnCreate time cost:%sms SDK version %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), Integer.valueOf(Build.VERSION.SDK_INT) }));
          }
          setContentView(2131561118);
          if (!isInMultiWindow()) {
            break label337;
          }
          QQToast.a(this, alpo.a(2131713903), 0).a();
          finish();
          return true;
          label284:
          super.getWindow().addFlags(256);
          super.getWindow().addFlags(512);
          break;
          this.isClearCoverLayer = false;
        }
        hideTitleBar();
      }
      catch (Exception paramBundle)
      {
        QLog.d("ScanTorchActivity", 1, "doOnCreate fail!", paramBundle);
        this.jdField_a_of_type_MqqAppQQBroadcastReceiver = null;
        finish();
        return true;
      }
    }
    label337:
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      if (paramBundle.getBooleanExtra("from_qr", false)) {
        this.p = paramBundle.getBooleanExtra("ar_enabled", false);
      }
      if (!this.p) {
        this.q = paramBundle.getBooleanExtra("hide_album", false);
      }
    }
    m();
    k();
    if (this.jdField_a_of_type_MqqAppQQBroadcastReceiver != null)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq__alive");
      registerReceiver(this.jdField_a_of_type_MqqAppQQBroadcastReceiver, paramBundle);
    }
    this.jdField_a_of_type_Avxx = new avxx(this.jdField_a_of_type_AndroidOsHandler, this);
    this.jdField_a_of_type_Avxx.a(this);
    amnx.a(this).a();
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.setUniformResManager(this.jdField_a_of_type_Anbr);
    amud.a().a();
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.CAMERA") == 0) {
        break label572;
      }
      QLog.d("ScanTorchActivity", 1, "checkSelfPermission. not grant");
      requestPermissions(new avxv(this), 1, new String[] { "android.permission.CAMERA" });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ScanTorchActivity", 2, String.format("doOnCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
      }
      AudioHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      return true;
      label572:
      QLog.d("ScanTorchActivity", 1, "checkSelfPermission. grant");
    }
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnDestroy,  needReportRedDot = " + this.jdField_k_of_type_Boolean);
    }
    if (this.jdField_k_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("dc00898", "", this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8008614", "0X8008614", 0, 0, "", "", "", "");
    }
    if (amtr.a) {
      amtr.a().a();
    }
    try
    {
      if (this.jdField_a_of_type_MqqAppQQBroadcastReceiver != null) {
        unregisterReceiver(this.jdField_a_of_type_MqqAppQQBroadcastReceiver);
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      h();
    }
    catch (Exception localException1)
    {
      try
      {
        if (this.jdField_a_of_type_Amtv != null)
        {
          this.jdField_a_of_type_Amtv.a();
          this.jdField_a_of_type_Amtv = null;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView != null) {
          this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.f();
        }
        super.doOnDestroy();
        if (b()) {
          ImmersiveUtils.a(true, getWindow());
        }
        this.n = true;
        xwb.a(this);
        return;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.d("ScanTorchActivity", 2, "doOnDestroy mArconfigManager unbind fail. ", localException2);
        }
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("doOnNewIntent filePath=%s", new Object[] { paramIntent }));
    }
    this.jdField_b_of_type_JavaLangString = paramIntent;
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnPause");
    }
    this.jdField_l_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.c();
    }
    super.doOnPause();
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnResume");
    }
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.b();
    }
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.a(this.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_JavaLangString = null;
    }
    if ((isInMultiWindow()) && (!this.m))
    {
      QQToast.a(this, alpo.a(2131713902), 1).a();
      this.m = true;
    }
    if (b()) {
      ImmersiveUtils.a(false, getWindow());
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnStart");
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_Avxx != null) {
      this.jdField_a_of_type_Avxx.a();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnStop");
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X80069CB", "0X80069CB", 0, 0, "1", String.valueOf(l1 - l2), "", "");
    if (this.jdField_a_of_type_Avxx != null) {
      this.jdField_a_of_type_Avxx.b();
    }
  }
  
  /* Error */
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 781	com/tencent/mobileqq/olympic/activity/OlympicToolBaseActivity:doOnWindowFocusChanged	(Z)V
    //   5: invokestatic 231	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +36 -> 44
    //   11: ldc 175
    //   13: iconst_2
    //   14: ldc_w 783
    //   17: iconst_2
    //   18: anewarray 89	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: iload_1
    //   24: invokestatic 252	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: aload_0
    //   31: getfield 785	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:o	Z
    //   34: invokestatic 252	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   37: aastore
    //   38: invokestatic 102	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   41: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: monitorenter
    //   46: iload_1
    //   47: ifeq +29 -> 76
    //   50: aload_0
    //   51: getfield 787	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:t	Z
    //   54: ifne +22 -> 76
    //   57: aload_0
    //   58: iconst_1
    //   59: putfield 787	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:t	Z
    //   62: aload_0
    //   63: getfield 237	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView	Lcom/tencent/mobileqq/ar/view/ScanEntryProviderContainerView;
    //   66: ifnull +10 -> 76
    //   69: aload_0
    //   70: getfield 237	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView	Lcom/tencent/mobileqq/ar/view/ScanEntryProviderContainerView;
    //   73: invokevirtual 789	com/tencent/mobileqq/ar/view/ScanEntryProviderContainerView:d	()V
    //   76: aload_0
    //   77: monitorexit
    //   78: iload_1
    //   79: ifeq +10 -> 89
    //   82: aload_0
    //   83: invokestatic 263	java/lang/System:currentTimeMillis	()J
    //   86: putfield 791	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_k_of_type_Long	J
    //   89: iload_1
    //   90: ifeq +141 -> 231
    //   93: aload_0
    //   94: getfield 793	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:s	Z
    //   97: ifne +134 -> 231
    //   100: aload_0
    //   101: invokevirtual 113	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:getIntent	()Landroid/content/Intent;
    //   104: astore 6
    //   106: aload 6
    //   108: ifnull +111 -> 219
    //   111: aload 6
    //   113: ldc_w 795
    //   116: iconst_0
    //   117: invokevirtual 131	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   120: istore_1
    //   121: aload 6
    //   123: ldc_w 797
    //   126: lconst_0
    //   127: invokevirtual 800	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   130: lstore_2
    //   131: aload 6
    //   133: ldc_w 802
    //   136: lconst_0
    //   137: invokevirtual 800	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   140: lstore 4
    //   142: aload 6
    //   144: ldc_w 804
    //   147: invokevirtual 139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   150: astore 6
    //   152: invokestatic 643	amud:a	()Lamud;
    //   155: iload_1
    //   156: lload_2
    //   157: lload 4
    //   159: aload 6
    //   161: invokevirtual 807	amud:a	(ZJJLjava/lang/String;)V
    //   164: aload_0
    //   165: getfield 809	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:r	Z
    //   168: ifeq +51 -> 219
    //   171: lload_2
    //   172: lconst_0
    //   173: lcmp
    //   174: ifle +45 -> 219
    //   177: invokestatic 263	java/lang/System:currentTimeMillis	()J
    //   180: lstore 4
    //   182: ldc_w 810
    //   185: invokestatic 576	alpo:a	(I)Ljava/lang/String;
    //   188: iconst_1
    //   189: anewarray 89	java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: lload 4
    //   196: lload_2
    //   197: lsub
    //   198: invokestatic 564	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   201: aastore
    //   202: invokestatic 102	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   205: astore 6
    //   207: aload_0
    //   208: iconst_0
    //   209: aload 6
    //   211: iconst_0
    //   212: invokestatic 813	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   215: invokevirtual 584	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   218: pop
    //   219: aload_0
    //   220: iconst_1
    //   221: putfield 793	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:s	Z
    //   224: aload_0
    //   225: invokestatic 263	java/lang/System:currentTimeMillis	()J
    //   228: putfield 413	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_j_of_type_Long	J
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
  
  public void h()
  {
    Intent localIntent = getIntent();
    long l1;
    int i1;
    int i2;
    int i3;
    HashMap localHashMap;
    if ((localIntent != null) && (this.jdField_i_of_type_Long > 0L) && (this.g > 0L) && (this.f > 0L))
    {
      l1 = localIntent.getLongExtra("click_time", 0L);
      i1 = (int)(this.jdField_i_of_type_Long - l1);
      i2 = (int)(this.f - this.g);
      i3 = (int)(this.g - l1);
      if ((i1 > 0) && (i2 > 0) && (i3 > 0))
      {
        localHashMap = new HashMap();
        if (!localIntent.getBooleanExtra("proc_exist", false)) {
          break label315;
        }
        str = "1";
        localHashMap.put("proc_exist", str);
        if (!localIntent.getBooleanExtra("first_click", false)) {
          break label323;
        }
      }
    }
    label315:
    label323:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("first_click", str);
      localHashMap.put("rcv_kill_broadcast", String.valueOf(this.jdField_b_of_type_Int));
      localHashMap.put("time_oncreate", a(i1));
      localHashMap.put("time_ar_ready", a(i2));
      localHashMap.put("time_add_fragment", a(i3));
      azmz.a(this).a("", "olympic_tool_proc_report", true, i2, 0L, localHashMap, "", true);
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, new Object[] { "doReport, params=", localHashMap });
      }
      if (this.h > 0L)
      {
        l1 = (System.currentTimeMillis() - this.h) / 1000L;
        if (l1 < 7200L) {
          azmz.a(BaseApplicationImpl.getApplication()).a(null, "actARFaceRecog", true, l1, 0L, null, "", true);
        }
      }
      return;
      str = "0";
      break;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return true;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.e();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void j()
  {
    if (isFinishing()) {}
    do
    {
      int i1;
      int i2;
      do
      {
        return;
        i1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth();
        i2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        if (QLog.isColorLevel()) {
          QLog.i("ScanTorchActivity", 2, String.format("updateQRRect [%d,%d]", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) }));
        }
      } while ((i1 <= 0) || (i2 <= 0) || ((anch.jdField_a_of_type_Int == i1) && (anch.jdField_b_of_type_Int == i2)));
      anch.jdField_a_of_type_Int = i1;
      anch.jdField_b_of_type_Int = i2;
      n();
    } while (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView == null);
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.a(this.jdField_a_of_type_AndroidGraphicsRect);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    QLog.i("ScanTorchActivity", 2, "onMultiWindowModeChanged" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ScanTorchActivity
 * JD-Core Version:    0.7.0.1
 */