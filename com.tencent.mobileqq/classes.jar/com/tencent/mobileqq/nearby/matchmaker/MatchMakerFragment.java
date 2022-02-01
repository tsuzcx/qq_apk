package com.tencent.mobileqq.nearby.matchmaker;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.fragment.TitlebarStatus;
import com.tencent.mobileqq.nearby.MatchMakerPlugin;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.nearby.report.IODReportTask;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class MatchMakerFragment
  extends CommonTabFragment
{
  private long jdField_a_of_type_Long = 0L;
  private boolean jdField_a_of_type_Boolean = false;
  private long b = 0L;
  
  private void f()
  {
    if (a() == null) {
      return;
    }
    INearbyProcManager localINearbyProcManager = a().getNearbyProcManager();
    if ((localINearbyProcManager != null) && (localINearbyProcManager.a())) {
      localINearbyProcManager.d();
    }
  }
  
  protected void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel())
    {
      paramWebView = new StringBuilder();
      paramWebView.append("onPageFinished: isVisible=");
      paramWebView.append(isVisible());
      QLog.d("MatchMakerFragment", 2, paramWebView.toString());
    }
    if (!"about:blank".equals(paramString))
    {
      ((IODReportTask)QRoute.api(IODReportTask.class)).setModule("nearby_hongniang").setAction("page_load_end").setRes1(System.currentTimeMillis() - this.b).setExtCol1(String.valueOf(isDetached())).setUin(a().getCurrentAccountUin()).report();
      this.b = System.currentTimeMillis();
    }
  }
  
  protected void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.a(paramWebView, paramString, paramBitmap);
    paramWebView = new StringBuilder();
    paramWebView.append("onPageStarted: url=");
    paramWebView.append(paramString);
    QLog.d("MatchMakerFragment", 2, paramWebView.toString());
    this.b = System.currentTimeMillis();
    if (!"about:blank".equals(paramString)) {
      ((IODReportTask)QRoute.api(IODReportTask.class)).setModule("nearby_hongniang").setAction("page_load_start").setRes1(String.valueOf(this.b - this.jdField_a_of_type_Long)).setUin(a().getCurrentAccountUin()).report();
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a(HardCodeUtil.a(2131707229)).a(new MatchMakerFragment.1(this));
    this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.d("MatchMakerFragment", 2, "onPageStarted: onCreate");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ((IODReportTask)QRoute.api(IODReportTask.class)).setModule("nearby_hongniang").setAction("tab_page_create").setUin(a().getCurrentAccountUin()).report();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((IODReportTask)QRoute.api(IODReportTask.class)).setModule("nearby_hongniang").setAction("tab_page_destroy").setUin(a().getCurrentAccountUin()).setRes1(String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long)).setExtCol1(String.valueOf(this.jdField_a_of_type_Boolean)).setExtCol2(String.valueOf(System.currentTimeMillis() - this.b)).setExtCol3(String.valueOf(MatchMakerPlugin.a())).report();
  }
  
  public void onPause()
  {
    super.onPause();
    if (a()) {
      f();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.matchmaker.MatchMakerFragment
 * JD-Core Version:    0.7.0.1
 */