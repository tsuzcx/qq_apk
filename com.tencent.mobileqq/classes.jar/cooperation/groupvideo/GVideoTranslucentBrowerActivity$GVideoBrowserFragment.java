package cooperation.groupvideo;

import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;

public class GVideoTranslucentBrowerActivity$GVideoBrowserFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
{
  private boolean a;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "GVideoBrowserFragment doOnCreate = ");
    }
    boolean bool = super.doOnCreate(paramBundle);
    if ((this.webView != null) && (this.webView.getPluginEngine() != null)) {
      this.webView.getPluginEngine().a(new String[] { "groupVideo" });
    }
    return bool;
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new GVideoTranslucentBrowerActivity.GVideoBrowserFragment.1(this, this.webViewSurface);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Monitor.a("2729128");
    if (!this.a)
    {
      Monitor.a("2489207");
      ReportController.b(null, "dc00899", "Huayang_video", "", "group_video", "loadHideWeb", 1, 0, "", "8.7.0", "", "");
    }
  }
  
  public void onFinalState(Bundle paramBundle, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super.onFinalState(paramBundle, paramWebViewKernelCallBack);
    getSwiftTitleUI().b(false);
    getUIStyleHandler().a.setVisibility(8);
  }
  
  public void onInitUIContent(Bundle paramBundle, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    getUIStyle().c = 0L;
    super.onInitUIContent(paramBundle, paramWebViewKernelCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.groupvideo.GVideoTranslucentBrowerActivity.GVideoBrowserFragment
 * JD-Core Version:    0.7.0.1
 */