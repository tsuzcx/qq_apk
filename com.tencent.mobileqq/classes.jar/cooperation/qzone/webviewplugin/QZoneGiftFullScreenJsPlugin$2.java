package cooperation.qzone.webviewplugin;

import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.QzoneGiftFullScreenViewController.GiftFullScreenPlayListener;

class QZoneGiftFullScreenJsPlugin$2
  implements QzoneGiftFullScreenViewController.GiftFullScreenPlayListener
{
  QZoneGiftFullScreenJsPlugin$2(QZoneGiftFullScreenJsPlugin paramQZoneGiftFullScreenJsPlugin, String paramString) {}
  
  public void giftFullScreenPlayEnd()
  {
    if (this.this$0.parentPlugin != null)
    {
      String str = "window." + this.val$playCmd + "({playFinish:1})";
      this.this$0.parentPlugin.callJs(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneGiftFullScreenJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */