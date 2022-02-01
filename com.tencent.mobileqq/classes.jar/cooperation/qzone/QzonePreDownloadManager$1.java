package cooperation.qzone;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

class QzonePreDownloadManager$1
  implements Downloader.DownloadListener
{
  QzonePreDownloadManager$1(QzonePreDownloadManager paramQzonePreDownloadManager, QzonePreDownloadManager.DownloadEnty paramDownloadEnty) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QzonePreDownloadManager.access$002(this.this$0, false);
    if (QzonePreDownloadManager.access$100(this.this$0).size() > 0)
    {
      QzonePreDownloadManager.DownloadEnty localDownloadEnty = (QzonePreDownloadManager.DownloadEnty)QzonePreDownloadManager.access$100(this.this$0).get(0);
      QzonePreDownloadManager.access$100(this.this$0).remove(0);
      QzonePreDownloadManager.access$200(this.this$0, localDownloadEnty);
    }
    if (this.val$downloadEnty.oridownloadListener != null) {
      this.val$downloadEnty.oridownloadListener.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QzonePreDownloadManager.access$002(this.this$0, false);
    if (QzonePreDownloadManager.access$100(this.this$0).size() > 0)
    {
      QzonePreDownloadManager.DownloadEnty localDownloadEnty = (QzonePreDownloadManager.DownloadEnty)QzonePreDownloadManager.access$100(this.this$0).get(0);
      QzonePreDownloadManager.access$100(this.this$0).remove(0);
      QzonePreDownloadManager.access$200(this.this$0, localDownloadEnty);
    }
    if (this.val$downloadEnty.oridownloadListener != null) {
      this.val$downloadEnty.oridownloadListener.onDownloadFailed(paramString, paramDownloadResult);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.val$downloadEnty.oridownloadListener != null) {
      this.val$downloadEnty.oridownloadListener.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QzonePreDownloadManager.access$002(this.this$0, false);
    if (QzonePreDownloadManager.access$100(this.this$0).size() > 0)
    {
      QzonePreDownloadManager.DownloadEnty localDownloadEnty = (QzonePreDownloadManager.DownloadEnty)QzonePreDownloadManager.access$100(this.this$0).get(0);
      QzonePreDownloadManager.access$100(this.this$0).remove(0);
      QzonePreDownloadManager.access$200(this.this$0, localDownloadEnty);
    }
    if (this.val$downloadEnty.oridownloadListener != null) {
      this.val$downloadEnty.oridownloadListener.onDownloadSucceed(paramString, paramDownloadResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.QzonePreDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */