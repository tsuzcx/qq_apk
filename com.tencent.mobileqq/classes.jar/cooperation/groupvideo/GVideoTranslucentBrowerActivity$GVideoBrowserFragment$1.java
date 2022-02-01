package cooperation.groupvideo;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class GVideoTranslucentBrowerActivity$GVideoBrowserFragment$1
  extends WebKernelCallBackProxy
{
  GVideoTranslucentBrowerActivity$GVideoBrowserFragment$1(GVideoTranslucentBrowerActivity.GVideoBrowserFragment paramGVideoBrowserFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    this.a.onFinalState(paramBundle, this.webViewKernelCallBack);
  }
  
  public void onInitUIContent(Bundle paramBundle)
  {
    this.a.onInitUIContent(paramBundle, this.webViewKernelCallBack);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "GVideoBrowserFragment onReceivedError = ");
    }
    GVideoTranslucentBrowerActivity.GVideoBrowserFragment.a(this.a, true);
    if (this.a.getActivity() != null) {
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.groupvideo.GVideoTranslucentBrowerActivity.GVideoBrowserFragment.1
 * JD-Core Version:    0.7.0.1
 */