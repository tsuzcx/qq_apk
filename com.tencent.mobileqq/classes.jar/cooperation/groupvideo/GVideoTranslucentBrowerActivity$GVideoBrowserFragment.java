package cooperation.groupvideo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import aqmd;
import awqx;
import bazb;
import bbcj;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class GVideoTranslucentBrowerActivity$GVideoBrowserFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
{
  private boolean a;
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    this.jdField_a_of_type_Bazb.b(false);
    this.jdField_a_of_type_Bbcj.a.setVisibility(8);
    return i;
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "GVideoBrowserFragment onReceivedError = ");
    }
    this.jdField_a_of_type_Boolean = true;
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "GVideoBrowserFragment doOnCreate = ");
    }
    boolean bool = super.a(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(new String[] { "groupVideo" });
    return bool;
  }
  
  public int d(Bundle paramBundle)
  {
    this.jdField_a_of_type_Bbcm.c = 0L;
    return super.d(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    aqmd.a("2729128");
    if (!this.jdField_a_of_type_Boolean)
    {
      aqmd.a("2489207");
      awqx.b(null, "dc00899", "Huayang_video", "", "group_video", "loadHideWeb", 1, 0, "", "8.2.6", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.groupvideo.GVideoTranslucentBrowerActivity.GVideoBrowserFragment
 * JD-Core Version:    0.7.0.1
 */