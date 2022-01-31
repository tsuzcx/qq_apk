package cooperation.groupvideo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import atbh;
import azqs;
import beft;
import bejh;
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
    this.jdField_a_of_type_Beft.b(false);
    this.jdField_a_of_type_Bejh.a.setVisibility(8);
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
    this.jdField_a_of_type_Bejk.c = 0L;
    return super.d(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    atbh.a("2729128");
    if (!this.jdField_a_of_type_Boolean)
    {
      atbh.a("2489207");
      azqs.b(null, "dc00899", "Huayang_video", "", "group_video", "loadHideWeb", 1, 0, "", "8.3.5", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.groupvideo.GVideoTranslucentBrowerActivity.GVideoBrowserFragment
 * JD-Core Version:    0.7.0.1
 */