package cooperation.qzone.plugin;

import android.os.Message;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.module.report.ImageDownloadReporter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class QZonePluginDownloader$DownLoadListner
  implements Downloader.DownloadListener
{
  QZonePluginDownloader.DownloadRecord downloadRecord;
  
  public QZonePluginDownloader$DownLoadListner(QZonePluginDownloader paramQZonePluginDownloader, QZonePluginDownloader.DownloadRecord paramDownloadRecord)
  {
    this.downloadRecord = paramDownloadRecord;
  }
  
  public void onDownloadCanceled(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 1, "plugin download canceled, url=" + paramString);
    }
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
        paramString.arg1 = paramDownloadResult.retCode;
        if (!AppNetConnInfo.isNetSupport()) {
          continue;
        }
        i = 1;
        paramString.arg2 = i;
        QLog.w("QZonePluginManger", 1, "plugin download failed, code=" + paramDownloadResult.retCode + ", arg2=" + paramString.arg2);
      }
      catch (Exception paramDownloadResult)
      {
        int i;
        QLog.w("QZonePluginManger", 1, "onDownloadFailed", paramDownloadResult);
        continue;
      }
      paramString.sendToTarget();
      return;
      i = 0;
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    QZonePluginDownloader.access$602(this.this$0, (int)(100.0F * paramFloat));
    paramString = Message.obtain(this.this$0.handler, 5);
    QZonePluginDownloader.DownloadRecord.access$200(this.downloadRecord).progress = paramFloat;
    paramString.obj = this.downloadRecord;
    paramString.sendToTarget();
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("QZonePluginManger", 2, "onDownloadSucceed, downloaded path:" + paramDownloadResult.getPath());
      paramString = QZonePluginUtils.getPluginDownLoadedPath(QZonePluginDownloader.access$500(this.this$0), QZonePluginDownloader.DownloadRecord.access$100(this.downloadRecord));
      QLog.d("QZonePluginManger", 2, "onDownloadSucceed, saved path:" + paramString + ", exsit:" + paramString.exists());
    }
    paramString = Message.obtain(this.this$0.handler, 4);
    paramString.obj = this.downloadRecord;
    paramString.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginDownloader.DownLoadListner
 * JD-Core Version:    0.7.0.1
 */