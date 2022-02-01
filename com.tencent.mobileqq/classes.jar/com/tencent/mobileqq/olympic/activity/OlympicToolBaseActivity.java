package com.tencent.mobileqq.olympic.activity;

import Override;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import anvx;
import ayxr;
import ayxs;
import bisl;
import bkys;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.NearbyReceiver;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;
import com.tencent.mobileqq.olympic.ScannerResultReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class OlympicToolBaseActivity
  extends AbsBaseWebViewActivity
{
  public static boolean g = true;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new ayxs(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ayxr(this);
  private bisl jdField_a_of_type_Bisl;
  private bkys jdField_a_of_type_Bkys;
  public QQAppInterface a;
  public ARScanAR a;
  public OcrConfig a;
  public OlympicToolAppInterface a;
  public ScannerResultReceiver a;
  public boolean a;
  public AppInterface b;
  private boolean h;
  private boolean i;
  
  private void h()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.i = NearbyFakeActivity.a();
    this.jdField_a_of_type_Bkys.removeMessages(0);
    if (this.i)
    {
      f();
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    i();
    k();
    this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(0, 5000L);
  }
  
  private void i()
  {
    if (this.h) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_Bisl == null)
        {
          this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
          this.jdField_a_of_type_Bisl.a(anvx.a(2131707290));
          this.jdField_a_of_type_Bisl.c(false);
        }
        this.h = true;
        this.jdField_a_of_type_Bisl.show();
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("ScanBaseActivity", 2, "");
  }
  
  private void j()
  {
    try
    {
      if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
        this.jdField_a_of_type_Bisl.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScanBaseActivity", 2, "hide init check progress:" + localException.getMessage());
      }
      localException.printStackTrace();
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanBaseActivity", 2, "sendBroadcastToToolProc");
    }
    Intent localIntent = new Intent(this, NearbyReceiver.class);
    localIntent.putExtra("resultreceiver_nearbyfakeactivity", this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver);
    localIntent.setExtrasClassLoader(getClassLoader());
    try
    {
      sendBroadcast(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ScanBaseActivity", 2, new Object[] { "sendBroadcastToToolProc, exception=", localThrowable.getMessage(), localThrowable });
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int != 2) {
      e();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int != 1) {
      g();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Int != 0) {
      h();
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Bkys = new bkys(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver = new ScannerResultReceiver(null);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Bisl != null) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver.a(null);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver.a(this);
    }
  }
  
  public void e()
  {
    Intent localIntent = new Intent(this, ScannerActivity.class);
    localIntent.addFlags(67108864);
    if (this.jdField_a_of_type_Int == 0)
    {
      localIntent.putExtra("from", ScanTorchActivity.class.getSimpleName());
      localIntent.putExtra("forbidGuideBubble", true);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARScanAR != null) {
        localIntent.putExtra("key_ar_config", this.jdField_a_of_type_ComTencentMobileqqArARScanAR);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) {
        localIntent.putExtra("key_ocr_config", this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig);
      }
      startActivity(localIntent);
      overridePendingTransition(0, 0);
      finish();
      return;
      if (this.jdField_a_of_type_Int == 1) {
        localIntent.putExtra("from", ScanOcrActivity.class.getSimpleName());
      }
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bkys.removeMessages(0);
    j();
    Intent localIntent = new Intent(this, ScanTorchActivity.class);
    localIntent.addFlags(67108864);
    localIntent.addFlags(268435456);
    localIntent.addFlags(65536);
    localIntent.putExtra("click_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("first_click", g);
    localIntent.putExtra("proc_exist", this.i);
    localIntent.putExtra("software", getSharedPreferences("immerse_ar", 0).getBoolean("software", false));
    g = false;
    localIntent.putExtra("log_on", ScanTorchActivity.h);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARScanAR.e)) {
      localIntent.putExtra("icon_text", "QQ-AR");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARScanAR.c)) {
        localIntent.putExtra("icon_url", this.jdField_a_of_type_ComTencentMobileqqArARScanAR.c);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARScanAR.f)) {
        localIntent.putExtra("scan_ar_default_tips", this.jdField_a_of_type_ComTencentMobileqqArARScanAR.f);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARScanAR.g)) {
        localIntent.putExtra("scan_ar_default_tips2", this.jdField_a_of_type_ComTencentMobileqqArARScanAR.g);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) {
        localIntent.putExtra("key_ocr_config", this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig);
      }
      localIntent.putExtra("key_ar_config", this.jdField_a_of_type_ComTencentMobileqqArARScanAR);
      startActivityForResult(localIntent, 10);
      overridePendingTransition(0, 0);
      finish();
      return;
      localIntent.putExtra("icon_text", this.jdField_a_of_type_ComTencentMobileqqArARScanAR.e);
    }
  }
  
  public void g() {}
  
  public String getModuleId()
  {
    if ("ScanTorchActivity".equals(getClass().getSimpleName())) {
      return "module_olympic";
    }
    return super.getModuleId();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void updateAppRuntime()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localAppRuntime);
      this.b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    }
    while (!(localAppRuntime instanceof OlympicToolAppInterface)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface = ((OlympicToolAppInterface)localAppRuntime);
    this.b = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.OlympicToolBaseActivity
 * JD-Core Version:    0.7.0.1
 */