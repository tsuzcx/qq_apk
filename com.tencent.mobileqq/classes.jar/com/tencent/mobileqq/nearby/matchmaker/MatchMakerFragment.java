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
  private long g = 0L;
  private long h = 0L;
  private boolean i = false;
  
  private void i()
  {
    if (f() == null) {
      return;
    }
    INearbyProcManager localINearbyProcManager = f().getNearbyProcManager();
    if ((localINearbyProcManager != null) && (localINearbyProcManager.h())) {
      localINearbyProcManager.f();
    }
  }
  
  protected void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    this.i = true;
    if (QLog.isColorLevel())
    {
      paramWebView = new StringBuilder();
      paramWebView.append("onPageFinished: isVisible=");
      paramWebView.append(isVisible());
      QLog.d("MatchMakerFragment", 2, paramWebView.toString());
    }
    if (!"about:blank".equals(paramString))
    {
      ((IODReportTask)QRoute.api(IODReportTask.class)).setModule("nearby_hongniang").setAction("page_load_end").setRes1(System.currentTimeMillis() - this.h).setExtCol1(String.valueOf(isDetached())).setUin(f().getCurrentAccountUin()).report();
      this.h = System.currentTimeMillis();
    }
  }
  
  protected void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.a(paramWebView, paramString, paramBitmap);
    paramWebView = new StringBuilder();
    paramWebView.append("onPageStarted: url=");
    paramWebView.append(paramString);
    QLog.d("MatchMakerFragment", 2, paramWebView.toString());
    this.h = System.currentTimeMillis();
    if (!"about:blank".equals(paramString)) {
      ((IODReportTask)QRoute.api(IODReportTask.class)).setModule("nearby_hongniang").setAction("page_load_start").setRes1(String.valueOf(this.h - this.g)).setUin(f().getCurrentAccountUin()).report();
    }
  }
  
  protected void h()
  {
    if (this.aj == null) {
      return;
    }
    this.aj.a(HardCodeUtil.a(2131905060)).a(new MatchMakerFragment.1(this));
    this.aj.a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.d("MatchMakerFragment", 2, "onPageStarted: onCreate");
    this.g = System.currentTimeMillis();
    ((IODReportTask)QRoute.api(IODReportTask.class)).setModule("nearby_hongniang").setAction("tab_page_create").setUin(f().getCurrentAccountUin()).report();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((IODReportTask)QRoute.api(IODReportTask.class)).setModule("nearby_hongniang").setAction("tab_page_destroy").setUin(f().getCurrentAccountUin()).setRes1(String.valueOf(System.currentTimeMillis() - this.g)).setExtCol1(String.valueOf(this.i)).setExtCol2(String.valueOf(System.currentTimeMillis() - this.h)).setExtCol3(String.valueOf(MatchMakerPlugin.b())).report();
  }
  
  public void onPause()
  {
    super.onPause();
    if (g()) {
      i();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.matchmaker.MatchMakerFragment
 * JD-Core Version:    0.7.0.1
 */