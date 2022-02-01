package com.tencent.mobileqq.nearby.matchmaker;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.fragment.TitlebarStatus;
import com.tencent.mobileqq.nearby.MatchMakerPlugin;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.nearby.report.ODReportTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class MatchMakerFragment
  extends CommonTabFragment
{
  private long a;
  private long b = 0L;
  private boolean d = false;
  
  public MatchMakerFragment()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void g()
  {
    if (a() == null) {}
    NearbyProcManager localNearbyProcManager;
    do
    {
      return;
      localNearbyProcManager = a().a();
    } while ((localNearbyProcManager == null) || (!localNearbyProcManager.a()));
    localNearbyProcManager.e();
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    this.d = true;
    if (QLog.isColorLevel()) {
      QLog.d("MatchMakerFragment", 2, "onPageFinished: isVisible=" + isVisible());
    }
    if (!"about:blank".equals(paramString))
    {
      new ODReportTask().b("nearby_hongniang").c("page_load_end").a(System.currentTimeMillis() - this.b).f(String.valueOf(isDetached())).a(a().getCurrentAccountUin()).a();
      this.b = System.currentTimeMillis();
    }
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.a(paramWebView, paramString, paramBitmap);
    QLog.d("MatchMakerFragment", 2, "onPageStarted: url=" + paramString);
    this.b = System.currentTimeMillis();
    if (!"about:blank".equals(paramString)) {
      new ODReportTask().b("nearby_hongniang").c("page_load_start").i(String.valueOf(this.b - this.jdField_a_of_type_Long)).a(a().getCurrentAccountUin()).a();
    }
  }
  
  protected void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a(HardCodeUtil.a(2131707204)).a(new MatchMakerFragment.1(this));
    this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.d("MatchMakerFragment", 2, "onPageStarted: onCreate");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    new ODReportTask().b("nearby_hongniang").c("tab_page_create").a(a().getCurrentAccountUin()).a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    new ODReportTask().b("nearby_hongniang").c("tab_page_destroy").a(a().getCurrentAccountUin()).i(String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long)).f(String.valueOf(this.d)).g(String.valueOf(System.currentTimeMillis() - this.b)).h(String.valueOf(MatchMakerPlugin.a())).a();
  }
  
  public void onPause()
  {
    super.onPause();
    if (b()) {
      g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.matchmaker.MatchMakerFragment
 * JD-Core Version:    0.7.0.1
 */