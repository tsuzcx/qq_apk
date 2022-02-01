package cooperation.qzone.webviewplugin;

import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.util.AlbumLibDownloaderUtil;

class QZoneSharePictureJsPlugin$1
  implements Runnable
{
  QZoneSharePictureJsPlugin$1(QZoneSharePictureJsPlugin paramQZoneSharePictureJsPlugin, String[] paramArrayOfString) {}
  
  public void run()
  {
    if (AlbumLibDownloaderUtil.getInstance().vertifySoIsOK(AlbumLibDownloaderUtil.GIF_SO_LIB_NAME, true))
    {
      QZoneSharePictureJsPlugin localQZoneSharePictureJsPlugin = this.this$0;
      QZoneSharePictureJsPlugin.access$000(localQZoneSharePictureJsPlugin, localQZoneSharePictureJsPlugin.parentPlugin.mRuntime, this.val$args);
      return;
    }
    QZoneSharePictureJsPlugin.access$100(this.this$0, this.val$args);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */