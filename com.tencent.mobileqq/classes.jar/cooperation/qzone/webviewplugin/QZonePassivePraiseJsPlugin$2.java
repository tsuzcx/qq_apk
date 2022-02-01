package cooperation.qzone.webviewplugin;

import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.IQzoneGiftFullScreenViewController.GiftFullScreenPlayListener;

class QZonePassivePraiseJsPlugin$2
  implements IQzoneGiftFullScreenViewController.GiftFullScreenPlayListener
{
  QZonePassivePraiseJsPlugin$2(QZonePassivePraiseJsPlugin paramQZonePassivePraiseJsPlugin, String paramString) {}
  
  public void giftFullScreenPlayEnd()
  {
    if (this.this$0.parentPlugin != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("window.");
      ((StringBuilder)localObject).append(this.val$playCmd);
      ((StringBuilder)localObject).append("({playAnimationFinish:1})");
      localObject = ((StringBuilder)localObject).toString();
      this.this$0.parentPlugin.callJs((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZonePassivePraiseJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */