package cooperation.qzone.plugin;

import android.os.Message;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.module.report.ImageDownloadReporter;
import com.tencent.qphone.base.util.QLog;

class QZoneLiveSoDownloader$SoDownloadListener
  implements Downloader.DownloadListener
{
  QZoneLiveSoDownloader.DownloadSoRecord downloadRecord;
  
  public QZoneLiveSoDownloader$SoDownloadListener(QZoneLiveSoDownloader paramQZoneLiveSoDownloader, QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord)
  {
    this.downloadRecord = paramDownloadSoRecord;
  }
  
  public void onDownloadCanceled(String paramString)
  {
    paramString = Message.obtain(this.this$0.handler, 2);
    paramString.obj = this.downloadRecord;
    paramString.sendToTarget();
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = Message.obtain(this.this$0.handler, 3);
    paramString.obj = this.downloadRecord;
    paramString.arg1 = -9999;
    if ((paramDownloadResult != null) && (paramDownloadResult.getReport() != null)) {}
    for (;;)
    {
      try
      {
        paramDownloadResult = new ImageDownloadReporter().obtainReportObj(paramDownloadResult, paramDownloadResult.getReport());
        if (paramDownloadResult != null)
        {
          paramString.arg1 = paramDownloadResult.retCode;
          QLog.w("QZoneLiveSoDownloader", 1, "So download failed, code=" + paramDownloadResult.retCode);
          this.downloadRecord.errorCode = paramDownloadResult.retCode;
        }
      }
      catch (Exception paramDownloadResult)
      {
        QLog.w("QZoneLiveSoDownloader", 1, "", paramDownloadResult);
        continue;
      }
      paramString.sendToTarget();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveSoDownloader", 2, "So download failed downloadResult:null");
      }
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    int i = (int)(100.0F * paramFloat);
    if (this.downloadRecord != null) {
      this.downloadRecord.progress = i;
    }
    paramString = Message.obtain(this.this$0.handler, 5);
    paramString.obj = this.downloadRecord;
    paramString.sendToTarget();
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveSoDownloader", 2, "onDownloadSucceed path:" + paramDownloadResult.getPath());
    }
    paramString = Message.obtain(this.this$0.handler, 4);
    paramString.obj = this.downloadRecord;
    paramString.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZoneLiveSoDownloader.SoDownloadListener
 * JD-Core Version:    0.7.0.1
 */