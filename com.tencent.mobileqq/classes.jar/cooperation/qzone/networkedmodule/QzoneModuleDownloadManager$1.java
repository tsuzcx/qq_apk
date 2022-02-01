package cooperation.qzone.networkedmodule;

import android.os.Message;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Map;

class QzoneModuleDownloadManager$1
  implements Downloader.DownloadListener
{
  QzoneModuleDownloadManager$1(QzoneModuleDownloadManager paramQzoneModuleDownloadManager) {}
  
  public void onDownloadCanceled(String paramString)
  {
    Message localMessage = Message.obtain(QzoneModuleDownloadManager.access$000(this.this$0));
    localMessage.what = 5;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramDownloadResult = Message.obtain(QzoneModuleDownloadManager.access$000(this.this$0));
    paramDownloadResult.what = 3;
    paramDownloadResult.obj = paramString;
    paramDownloadResult.sendToTarget();
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    paramString = (QzoneModuleDownloadManager.DownloadTask)QzoneModuleDownloadManager.access$100(this.this$0).get(paramString);
    if (paramString != null) {
      paramString.obj = Float.valueOf(paramFloat);
    }
    Message localMessage = Message.obtain(QzoneModuleDownloadManager.access$000(this.this$0));
    localMessage.what = 6;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    paramDownloadResult = Message.obtain(QzoneModuleDownloadManager.access$000(this.this$0));
    paramDownloadResult.what = 2;
    paramDownloadResult.obj = paramString;
    paramDownloadResult.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */