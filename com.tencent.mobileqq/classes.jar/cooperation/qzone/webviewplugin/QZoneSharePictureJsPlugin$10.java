package cooperation.qzone.webviewplugin;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.util.QZLog;

class QZoneSharePictureJsPlugin$10
  implements Downloader.DownloadListener
{
  QZoneSharePictureJsPlugin$10(QZoneSharePictureJsPlugin paramQZoneSharePictureJsPlugin, String[] paramArrayOfString) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("QZoneSharePictureJsPlugin", "onDownloadCanceled");
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.w("QZoneSharePictureJsPlugin", "下载GIF组件失败，请稍后重试");
    QZoneSharePictureJsPlugin.access$600(this.this$0, HardCodeUtil.a(2131909882), 1);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.i("QZoneSharePictureJsPlugin", "下载GIF组件成功");
    if (this.this$0.parentPlugin != null)
    {
      paramString = this.this$0;
      QZoneSharePictureJsPlugin.access$000(paramString, paramString.parentPlugin.mRuntime, this.val$args);
      return;
    }
    QZLog.w("QZoneSharePictureJsPlugin", "parentPlugin is null");
    QZoneSharePictureJsPlugin.access$600(this.this$0, HardCodeUtil.a(2131909862), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */