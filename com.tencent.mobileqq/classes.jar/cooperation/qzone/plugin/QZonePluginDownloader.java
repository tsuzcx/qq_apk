package cooperation.qzone.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class QZonePluginDownloader
  implements Handler.Callback
{
  private static long ENOUGH_SPACE_SIZE = 20971520L;
  public static final int ERR_CODE_DEFAULT = -9999;
  public static final int ERR_CODE_NO_SPACE = -9998;
  private static final int MSG_CANCEL_DOWNLOAD_PLUGIN = 1;
  private static final int MSG_DOWNLOAD_PLUGIN = 0;
  private static final int MSG_DOWNLOAD_PLUGIN_CANCELED = 2;
  private static final int MSG_DOWNLOAD_PLUGIN_FAIL = 3;
  private static final int MSG_DOWNLOAD_PLUGIN_PROGESS = 5;
  private static final int MSG_DOWNLOAD_PLUGIN_SUCCESS = 4;
  public static final int REFER_DOWNLOAD_BACKGROUND = 0;
  public static final int REFER_DOWNLOAD_BACKGROUND_RETRY = 2;
  public static final int REFER_DOWNLOAD_LAUNCH = 1;
  public static final int REFER_DOWNLOAD_WATCH = 3;
  private static String downloadId;
  private static long startDownloadTime;
  private static int startNetworkType;
  private Downloader downloader;
  private Map<String, QZonePluginDownloader.DownloadRecord> downloadingMap;
  Handler handler;
  private Context mContext;
  private int totalProgress;
  
  QZonePluginDownloader(Context paramContext)
  {
    this.mContext = paramContext;
    DownloaderFactory.getInstance(this.mContext);
    DownloaderFactory.init(new QZonePluginDownloadConfig(), new QZonePluginDownloaderLog());
    this.downloader = DownloaderFactory.createDownloader("QZonePluginDownloader");
    this.downloader.setPortConfigStrategy(new QZonePluginDownloadPortConfig());
    this.downloader.setDirectIPConfigStrategy(new QZonePluginDownloadIPStracyConfig());
    this.downloader.setBackupIPConfigStrategy(new QZonePluginDownloadBackupConfig());
    this.downloader.setKeepAliveStrategy(new QZonePluginDownloadConfigKeepAliveStrategy());
    this.downloader.setDownloadMode(Downloader.DownloadMode.StrictMode);
    this.downloader.enableResumeTransfer(true);
    this.downloadingMap = new HashMap();
    this.handler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void cancelDownLoadPluginInner(QZonePluginDownloader.DownloadRecord paramDownloadRecord)
  {
    if ((paramDownloadRecord == null) || (QZonePluginDownloader.DownloadRecord.access$200(paramDownloadRecord) == null))
    {
      QLog.w("QZonePluginManger", 1, "cancelDownLoadPlugin, downloadRecord or record is null, downloadRecord=" + paramDownloadRecord);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "cancelDownLoadPlugin url:" + QZonePluginDownloader.DownloadRecord.access$200(paramDownloadRecord).url);
    }
    PluginRecord localPluginRecord = QZonePluginDownloader.DownloadRecord.access$200(paramDownloadRecord);
    this.downloader.abort(localPluginRecord.url, new QZonePluginDownloader.DownLoadListner(this, paramDownloadRecord));
  }
  
  private void downloadPluginInner(QZonePluginDownloader.DownloadRecord paramDownloadRecord)
  {
    PluginRecord localPluginRecord = QZonePluginDownloader.DownloadRecord.access$200(paramDownloadRecord);
    Object localObject = QZonePluginDownloader.DownloadRecord.access$300(paramDownloadRecord);
    QZonePluginDownloader.DownloadRecord.access$200(paramDownloadRecord).state = 1;
    ((QZonePluginDownloader.OnPluginDownloadListner)localObject).onDownLoadStart(localPluginRecord);
    File localFile = QZonePluginUtils.getPluginDownLoadedPath(this.mContext, localPluginRecord.id);
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "downloadPluginInner url:" + localPluginRecord.url + ",path:" + localFile);
    }
    startDownloadTime = System.currentTimeMillis();
    startNetworkType = NetworkState.g().getNetworkType();
    if (TextUtils.isEmpty(downloadId)) {
      localObject = "";
    }
    try
    {
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject = str;
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          QLog.w("QZonePluginManger", 1, "", localException);
        }
      } while (this.downloader.download(localPluginRecord.url, localFile.getAbsolutePath(), new QZonePluginDownloader.DownLoadListner(this, paramDownloadRecord)));
      localObject = Message.obtain(this.handler, 3);
      ((Message)localObject).obj = paramDownloadRecord;
      ((Message)localObject).sendToTarget();
    }
    downloadId = startDownloadTime + "_" + (String)localObject;
    this.totalProgress = 0;
    if (isLowSpace(localFile.getParent()))
    {
      localObject = Message.obtain(this.handler, 3);
      ((Message)localObject).obj = paramDownloadRecord;
      ((Message)localObject).arg1 = -9998;
      ((Message)localObject).sendToTarget();
      return;
    }
  }
  
  private boolean isLowSpace(String paramString)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramString);
      long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
      if (l < QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginDownloadAvailableSpace", ENOUGH_SPACE_SIZE)) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          QLog.w("QZonePluginManger", 1, "low storage: totalSize=" + localStatFs.getBlockCount() * localStatFs.getBlockSize() + ", availableSize=" + l + ", path=" + paramString);
        }
        return bool;
      }
      return true;
    }
    catch (Throwable paramString)
    {
      QLog.e("QZonePluginManger", 1, "", paramString);
    }
  }
  
  private void reportDownload(QZonePluginDownloader.DownloadRecord paramDownloadRecord, int paramInt, String paramString)
  {
    PluginRecord localPluginRecord = QZonePluginDownloader.DownloadRecord.access$200(paramDownloadRecord);
    long l1 = System.currentTimeMillis();
    long l2 = startDownloadTime;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, downloadId, startNetworkType + "", QZonePluginDownloader.DownloadRecord.access$400(paramDownloadRecord), (l1 - l2) / 1000.0D, paramInt, this.totalProgress, paramString);
  }
  
  private void reportDownload(QZonePluginDownloader.DownloadRecord paramDownloadRecord, int paramInt, String paramString1, String paramString2)
  {
    PluginRecord localPluginRecord = QZonePluginDownloader.DownloadRecord.access$200(paramDownloadRecord);
    long l1 = System.currentTimeMillis();
    long l2 = startDownloadTime;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, downloadId, startNetworkType + "", QZonePluginDownloader.DownloadRecord.access$400(paramDownloadRecord), (l1 - l2) / 1000.0D, paramInt, this.totalProgress, paramString1, paramString2);
  }
  
  public void cancelDownLoadPlugin(PluginRecord paramPluginRecord, QZonePluginDownloader.OnPluginDownloadListner paramOnPluginDownloadListner)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    QZonePluginDownloader.DownloadRecord localDownloadRecord = new QZonePluginDownloader.DownloadRecord(null);
    QZonePluginDownloader.DownloadRecord.access$102(localDownloadRecord, paramPluginRecord.id);
    QZonePluginDownloader.DownloadRecord.access$202(localDownloadRecord, paramPluginRecord);
    QZonePluginDownloader.DownloadRecord.access$402(localDownloadRecord, -1);
    QZonePluginDownloader.DownloadRecord.access$302(localDownloadRecord, paramOnPluginDownloadListner);
    localMessage.obj = localDownloadRecord;
    this.handler.sendMessage(localMessage);
  }
  
  public void downloadPlugin(PluginRecord paramPluginRecord, QZonePluginDownloader.OnPluginDownloadListner paramOnPluginDownloadListner, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    QZonePluginDownloader.DownloadRecord localDownloadRecord = new QZonePluginDownloader.DownloadRecord(null);
    QZonePluginDownloader.DownloadRecord.access$102(localDownloadRecord, paramPluginRecord.id);
    paramPluginRecord.state = 0;
    QZonePluginDownloader.DownloadRecord.access$202(localDownloadRecord, paramPluginRecord);
    QZonePluginDownloader.DownloadRecord.access$302(localDownloadRecord, paramOnPluginDownloadListner);
    QZonePluginDownloader.DownloadRecord.access$402(localDownloadRecord, paramInt);
    localMessage.obj = localDownloadRecord;
    this.handler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (QZonePluginDownloader.DownloadRecord)paramMessage.obj;
      if (this.downloadingMap.containsKey(QZonePluginDownloader.DownloadRecord.access$100(paramMessage))) {
        return false;
      }
      this.downloadingMap.put(QZonePluginDownloader.DownloadRecord.access$100(paramMessage), paramMessage);
      downloadPluginInner(paramMessage);
      return true;
      paramMessage = (QZonePluginDownloader.DownloadRecord)paramMessage.obj;
      if (this.downloadingMap.containsKey(QZonePluginDownloader.DownloadRecord.access$100(paramMessage)))
      {
        reportDownload(paramMessage, 3, "");
        this.downloadingMap.remove(QZonePluginDownloader.DownloadRecord.access$100(paramMessage));
        cancelDownLoadPluginInner(paramMessage);
        Object localObject = QZonePluginDownloader.DownloadRecord.access$300(paramMessage);
        if (localObject != null)
        {
          ((QZonePluginDownloader.OnPluginDownloadListner)localObject).onDownloadCanceled(QZonePluginDownloader.DownloadRecord.access$200(paramMessage));
          continue;
          paramMessage = (QZonePluginDownloader.DownloadRecord)paramMessage.obj;
          if (this.downloadingMap.containsKey(QZonePluginDownloader.DownloadRecord.access$100(paramMessage)))
          {
            reportDownload(paramMessage, 1, "");
            this.downloadingMap.remove(QZonePluginDownloader.DownloadRecord.access$100(paramMessage));
            localObject = QZonePluginDownloader.DownloadRecord.access$300(paramMessage);
            if (localObject != null)
            {
              ((QZonePluginDownloader.OnPluginDownloadListner)localObject).onDownloadCanceled(QZonePluginDownloader.DownloadRecord.access$200(paramMessage));
              continue;
              localObject = (QZonePluginDownloader.DownloadRecord)paramMessage.obj;
              if (this.downloadingMap.containsKey(QZonePluginDownloader.DownloadRecord.access$100((QZonePluginDownloader.DownloadRecord)localObject)))
              {
                reportDownload((QZonePluginDownloader.DownloadRecord)localObject, 2, paramMessage.arg1 + "", paramMessage.arg2 + "");
                this.downloadingMap.remove(QZonePluginDownloader.DownloadRecord.access$100((QZonePluginDownloader.DownloadRecord)localObject));
                QZonePluginDownloader.OnPluginDownloadListner localOnPluginDownloadListner = QZonePluginDownloader.DownloadRecord.access$300((QZonePluginDownloader.DownloadRecord)localObject);
                if (localOnPluginDownloadListner != null)
                {
                  localOnPluginDownloadListner.onDownloadFailed(QZonePluginDownloader.DownloadRecord.access$200((QZonePluginDownloader.DownloadRecord)localObject), paramMessage.arg1);
                  continue;
                  paramMessage = (QZonePluginDownloader.DownloadRecord)paramMessage.obj;
                  if (this.downloadingMap.containsKey(QZonePluginDownloader.DownloadRecord.access$100(paramMessage)))
                  {
                    reportDownload(paramMessage, 0, "");
                    this.downloadingMap.remove(QZonePluginDownloader.DownloadRecord.access$100(paramMessage));
                    localObject = QZonePluginDownloader.DownloadRecord.access$300(paramMessage);
                    if (localObject != null)
                    {
                      QZonePluginDownloader.DownloadRecord.access$200(paramMessage).state = 2;
                      ((QZonePluginDownloader.OnPluginDownloadListner)localObject).onDownloadSucceed(QZonePluginDownloader.DownloadRecord.access$200(paramMessage), QZonePluginDownloader.DownloadRecord.access$400(paramMessage));
                      continue;
                      paramMessage = (QZonePluginDownloader.DownloadRecord)paramMessage.obj;
                      if (this.downloadingMap.containsKey(QZonePluginDownloader.DownloadRecord.access$100(paramMessage)))
                      {
                        localObject = QZonePluginDownloader.DownloadRecord.access$300(paramMessage);
                        if (localObject != null) {
                          ((QZonePluginDownloader.OnPluginDownloadListner)localObject).onDownloadProgress(QZonePluginDownloader.DownloadRecord.access$200(paramMessage));
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    startDownloadTime = 0L;
    startNetworkType = 0;
    downloadId = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginDownloader
 * JD-Core Version:    0.7.0.1
 */