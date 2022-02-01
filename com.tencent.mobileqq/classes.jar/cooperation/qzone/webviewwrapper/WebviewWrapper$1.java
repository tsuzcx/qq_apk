package cooperation.qzone.webviewwrapper;

import com.tencent.biz.ui.TouchWebView;

class WebviewWrapper$1
  implements QzoneWebViewBaseBuilder.WebviewStatusListener
{
  WebviewWrapper$1(WebviewWrapper paramWebviewWrapper, IWebviewListener paramIWebviewListener) {}
  
  public void onPageFinished()
  {
    if (WebviewWrapper.access$000(this.this$0) == null) {
      return;
    }
    if (WebviewWrapper.access$000(this.this$0).getVisibility() != 0) {
      WebviewWrapper.access$000(this.this$0).setVisibility(0);
    }
    IWebviewListener localIWebviewListener = this.val$listener;
    if (localIWebviewListener != null) {
      localIWebviewListener.onPageFinished();
    }
  }
  
  public void onReceiveError(int paramInt, String paramString1, String paramString2)
  {
    IWebviewListener localIWebviewListener = this.val$listener;
    if (localIWebviewListener != null) {
      localIWebviewListener.onReceiveError(paramInt, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewwrapper.WebviewWrapper.1
 * JD-Core Version:    0.7.0.1
 */