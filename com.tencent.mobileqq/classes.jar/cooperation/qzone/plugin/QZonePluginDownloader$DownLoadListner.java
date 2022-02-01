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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("plugin download canceled, url=");
      localStringBuilder.append(paramString);
      QLog.d("QZonePluginManger", 1, localStringBuilder.toString());
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
          break label152;
        }
        i = 1;
        paramString.arg2 = i;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("plugin download failed, code=");
        localStringBuilder.append(paramDownloadResult.retCode);
        localStringBuilder.append(", arg2=");
        localStringBuilder.append(paramString.arg2);
        QLog.w("QZonePluginManger", 1, localStringBuilder.toString());
      }
      catch (Exception paramDownloadResult)
      {
        QLog.w("QZonePluginManger", 1, "onDownloadFailed", paramDownloadResult);
      }
      paramString.sendToTarget();
      return;
      label152:
      int i = 0;
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
      paramString = new StringBuilder();
      paramString.append("onDownloadSucceed, downloaded path:");
      paramString.append(paramDownloadResult.getPath());
      QLog.d("QZonePluginManger", 2, paramString.toString());
      paramString = QZonePluginUtils.getPluginDownLoadedPath(QZonePluginDownloader.access$500(this.this$0), QZonePluginDownloader.DownloadRecord.access$100(this.downloadRecord));
      paramDownloadResult = new StringBuilder();
      paramDownloadResult.append("onDownloadSucceed, saved path:");
      paramDownloadResult.append(paramString);
      paramDownloadResult.append(", exsit:");
      paramDownloadResult.append(paramString.exists());
      QLog.d("QZonePluginManger", 2, paramDownloadResult.toString());
    }
    paramString = Message.obtain(this.this$0.handler, 4);
    paramString.obj = this.downloadRecord;
    paramString.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginDownloader.DownLoadListner
 * JD-Core Version:    0.7.0.1
 */