package com.tencent.mobileqq.olympic.activity;

import agjh;
import agji;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.text.TextUtils;
import android.view.View.OnClickListener;
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
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import mqq.app.AppRuntime;

public class OlympicToolBaseActivity
  extends AbsBaseWebViewActivity
{
  public static boolean g = true;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new agji(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new agjh(this);
  public QQAppInterface a;
  public ARScanAR a;
  public OcrConfig a;
  public OlympicToolAppInterface a;
  public ScannerResultReceiver a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  public boolean a;
  public AppInterface b;
  private boolean h;
  private boolean i;
  
  private void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.i = NearbyFakeActivity.a();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
    if (this.i)
    {
      g();
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    i();
    k();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(0, 5000L);
  }
  
  private void i()
  {
    if (this.h) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在加载...");
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
        }
        this.h = true;
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
      f();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Int != 1) {
      h();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver = new ScannerResultReceiver(null);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver.a(null);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver.a(this);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Int != 0) {
      a();
    }
  }
  
  public void f()
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
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
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
    localIntent.putExtra("log_on", ScanTorchActivity.i);
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
  
  public String getModuleId()
  {
    if ("ScanTorchActivity".equals(getClass().getSimpleName())) {
      return "module_olympic";
    }
    return super.getModuleId();
  }
  
  public void h()
  {
    Intent localIntent = new Intent(this, ScanOcrActivity.class);
    localIntent.addFlags(67108864);
    if (this.jdField_a_of_type_ComTencentMobileqqArARScanAR != null) {
      localIntent.putExtra("key_ar_config", this.jdField_a_of_type_ComTencentMobileqqArARScanAR);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) {
      localIntent.putExtra("key_ocr_config", this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig);
    }
    localIntent.putExtra("ocr_from_where", 0);
    startActivity(localIntent);
    overridePendingTransition(0, 0);
    finish();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.OlympicToolBaseActivity
 * JD-Core Version:    0.7.0.1
 */