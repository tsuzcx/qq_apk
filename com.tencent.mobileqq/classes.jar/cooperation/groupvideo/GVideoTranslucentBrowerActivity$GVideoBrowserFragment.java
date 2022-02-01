package cooperation.groupvideo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import awbj;
import bdll;
import binq;
import birg;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class GVideoTranslucentBrowerActivity$GVideoBrowserFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
{
  private boolean a;
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    this.mSwiftTitleUI.b(false);
    this.mUIStyleHandler.a.setVisibility(8);
    return i;
  }
  
  public int doCreateLoopStep_InitUIContent(Bundle paramBundle)
  {
    this.mUIStyle.c = 0L;
    return super.doCreateLoopStep_InitUIContent(paramBundle);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "GVideoBrowserFragment doOnCreate = ");
    }
    boolean bool = super.doOnCreate(paramBundle);
    this.mPluginEngine.a(new String[] { "groupVideo" });
    return bool;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    awbj.a("2729128");
    if (!this.a)
    {
      awbj.a("2489207");
      bdll.b(null, "dc00899", "Huayang_video", "", "group_video", "loadHideWeb", 1, 0, "", "8.4.5", "", "");
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "GVideoBrowserFragment onReceivedError = ");
    }
    this.a = true;
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.groupvideo.GVideoTranslucentBrowerActivity.GVideoBrowserFragment
 * JD-Core Version:    0.7.0.1
 */