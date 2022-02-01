package cooperation.qzone;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.smtt.sdk.WebView;

class QzoneTranslucentBrowserFragment$1
  extends WebKernelCallBackProxy
{
  QzoneTranslucentBrowserFragment$1(QzoneTranslucentBrowserFragment paramQzoneTranslucentBrowserFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    this.this$0.onFinalState(paramBundle, this.webViewKernelCallBack);
  }
  
  public void onInitUIContent(Bundle paramBundle)
  {
    this.this$0.onInitUIContent(paramBundle, this.webViewKernelCallBack);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.webViewKernelCallBack.onPageFinished(paramWebView, paramString);
    if (QzoneTranslucentBrowserFragment.access$000(this.this$0))
    {
      paramWebView = this.this$0;
      QzoneTranslucentBrowserFragment.access$100(paramWebView, paramWebView.contentView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneTranslucentBrowserFragment.1
 * JD-Core Version:    0.7.0.1
 */