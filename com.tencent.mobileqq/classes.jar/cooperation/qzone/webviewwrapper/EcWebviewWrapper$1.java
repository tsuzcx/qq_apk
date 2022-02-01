package cooperation.qzone.webviewwrapper;

import com.tencent.biz.ui.TouchWebView;

class EcWebviewWrapper$1
  implements QzoneWebViewBaseBuilder.WebviewStatusListener
{
  EcWebviewWrapper$1(EcWebviewWrapper paramEcWebviewWrapper, IWebviewListener paramIWebviewListener) {}
  
  public void onPageFinished()
  {
    if (EcWebviewWrapper.access$000(this.this$0) == null) {}
    do
    {
      return;
      if (EcWebviewWrapper.access$000(this.this$0).getVisibility() != 0) {
        EcWebviewWrapper.access$000(this.this$0).setVisibility(0);
      }
    } while (this.val$listener == null);
    this.val$listener.onPageFinished();
  }
  
  public void onReceiveError(int paramInt, String paramString1, String paramString2)
  {
    if (this.val$listener != null) {
      this.val$listener.onReceiveError(paramInt, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewwrapper.EcWebviewWrapper.1
 * JD-Core Version:    0.7.0.1
 */