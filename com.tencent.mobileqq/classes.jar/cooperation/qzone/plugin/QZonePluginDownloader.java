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
    if ((paramDownloadRecord != null) && (QZonePluginDownloader.DownloadRecord.access$200(paramDownloadRecord) != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cancelDownLoadPlugin url:");
        ((StringBuilder)localObject).append(QZonePluginDownloader.DownloadRecord.access$200(paramDownloadRecord).url);
        QLog.d("QZonePluginManger", 2, ((StringBuilder)localObject).toString());
      }
      localObject = QZonePluginDownloader.DownloadRecord.access$200(paramDownloadRecord);
      this.downloader.abort(((PluginRecord)localObject).url, new QZonePluginDownloader.DownLoadListner(this, paramDownloadRecord));
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cancelDownLoadPlugin, downloadRecord or record is null, downloadRecord=");
    ((StringBuilder)localObject).append(paramDownloadRecord);
    QLog.w("QZonePluginManger", 1, ((StringBuilder)localObject).toString());
  }
  
  private void downloadPluginInner(QZonePluginDownloader.DownloadRecord paramDownloadRecord)
  {
    Object localObject1 = "";
    PluginRecord localPluginRecord = QZonePluginDownloader.DownloadRecord.access$200(paramDownloadRecord);
    Object localObject2 = QZonePluginDownloader.DownloadRecord.access$300(paramDownloadRecord);
    QZonePluginDownloader.DownloadRecord.access$200(paramDownloadRecord).state = 1;
    ((QZonePluginDownloader.OnPluginDownloadListner)localObject2).onDownLoadStart(localPluginRecord);
    File localFile = QZonePluginUtils.getPluginDownLoadedPath(this.mContext, localPluginRecord.id);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("downloadPluginInner url:");
      ((StringBuilder)localObject2).append(localPluginRecord.url);
      ((StringBuilder)localObject2).append(",path:");
      ((StringBuilder)localObject2).append(localFile);
      QLog.d("QZonePluginManger", 2, ((StringBuilder)localObject2).toString());
    }
    startDownloadTime = System.currentTimeMillis();
    startNetworkType = NetworkState.g().getNetworkType();
    if (TextUtils.isEmpty(downloadId))
    {
      try
      {
        localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        QLog.w("QZonePluginManger", 1, "", localException);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(startDownloadTime);
      localStringBuilder.append("_");
      localStringBuilder.append((String)localObject1);
      downloadId = localStringBuilder.toString();
    }
    this.totalProgress = 0;
    if (isLowSpace(localFile.getParent()))
    {
      localObject1 = Message.obtain(this.handler, 3);
      ((Message)localObject1).obj = paramDownloadRecord;
      ((Message)localObject1).arg1 = -9998;
      ((Message)localObject1).sendToTarget();
      return;
    }
    if (!this.downloader.download(localPluginRecord.url, localFile.getAbsolutePath(), new QZonePluginDownloader.DownLoadListner(this, paramDownloadRecord)))
    {
      localObject1 = Message.obtain(this.handler, 3);
      ((Message)localObject1).obj = paramDownloadRecord;
      ((Message)localObject1).sendToTarget();
    }
  }
  
  private boolean isLowSpace(String paramString)
  {
    for (;;)
    {
      try
      {
        StatFs localStatFs = new StatFs(paramString);
        long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
        if (l < QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginDownloadAvailableSpace", ENOUGH_SPACE_SIZE))
        {
          bool = true;
          if (bool)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("low storage: totalSize=");
            localStringBuilder.append(localStatFs.getBlockCount() * localStatFs.getBlockSize());
            localStringBuilder.append(", availableSize=");
            localStringBuilder.append(l);
            localStringBuilder.append(", path=");
            localStringBuilder.append(paramString);
            QLog.w("QZonePluginManger", 1, localStringBuilder.toString());
          }
          return bool;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("QZonePluginManger", 1, "", paramString);
        return true;
      }
      boolean bool = false;
    }
  }
  
  private void reportDownload(QZonePluginDownloader.DownloadRecord paramDownloadRecord, int paramInt, String paramString)
  {
    Object localObject1 = QZonePluginDownloader.DownloadRecord.access$200(paramDownloadRecord);
    long l1 = System.currentTimeMillis();
    long l2 = startDownloadTime;
    String str1 = ((PluginRecord)localObject1).id;
    String str2 = ((PluginRecord)localObject1).old_ver;
    localObject1 = ((PluginRecord)localObject1).ver;
    String str3 = downloadId;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(startNetworkType);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    int i = QZonePluginDownloader.DownloadRecord.access$400(paramDownloadRecord);
    double d = l1 - l2;
    Double.isNaN(d);
    LpReportInfo_dc01500.reportDownload(str1, str2, (String)localObject1, str3, (String)localObject2, i, d / 1000.0D, paramInt, this.totalProgress, paramString);
  }
  
  private void reportDownload(QZonePluginDownloader.DownloadRecord paramDownloadRecord, int paramInt, String paramString1, String paramString2)
  {
    Object localObject1 = QZonePluginDownloader.DownloadRecord.access$200(paramDownloadRecord);
    long l1 = System.currentTimeMillis();
    long l2 = startDownloadTime;
    String str1 = ((PluginRecord)localObject1).id;
    String str2 = ((PluginRecord)localObject1).old_ver;
    localObject1 = ((PluginRecord)localObject1).ver;
    String str3 = downloadId;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(startNetworkType);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    int i = QZonePluginDownloader.DownloadRecord.access$400(paramDownloadRecord);
    double d = l1 - l2;
    Double.isNaN(d);
    LpReportInfo_dc01500.reportDownload(str1, str2, (String)localObject1, str3, (String)localObject2, i, d / 1000.0D, paramInt, this.totalProgress, paramString1, paramString2);
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
    int i = paramMessage.what;
    if (i != 0)
    {
      Object localObject1;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return false;
              }
              paramMessage = (QZonePluginDownloader.DownloadRecord)paramMessage.obj;
              if (this.downloadingMap.containsKey(QZonePluginDownloader.DownloadRecord.access$100(paramMessage)))
              {
                localObject1 = QZonePluginDownloader.DownloadRecord.access$300(paramMessage);
                if (localObject1 != null)
                {
                  ((QZonePluginDownloader.OnPluginDownloadListner)localObject1).onDownloadProgress(QZonePluginDownloader.DownloadRecord.access$200(paramMessage));
                  return false;
                }
              }
            }
            else
            {
              paramMessage = (QZonePluginDownloader.DownloadRecord)paramMessage.obj;
              if (this.downloadingMap.containsKey(QZonePluginDownloader.DownloadRecord.access$100(paramMessage)))
              {
                reportDownload(paramMessage, 0, "");
                this.downloadingMap.remove(QZonePluginDownloader.DownloadRecord.access$100(paramMessage));
                localObject1 = QZonePluginDownloader.DownloadRecord.access$300(paramMessage);
                if (localObject1 != null)
                {
                  QZonePluginDownloader.DownloadRecord.access$200(paramMessage).state = 2;
                  ((QZonePluginDownloader.OnPluginDownloadListner)localObject1).onDownloadSucceed(QZonePluginDownloader.DownloadRecord.access$200(paramMessage), QZonePluginDownloader.DownloadRecord.access$400(paramMessage));
                  return false;
                }
              }
            }
          }
          else
          {
            localObject1 = (QZonePluginDownloader.DownloadRecord)paramMessage.obj;
            if (this.downloadingMap.containsKey(QZonePluginDownloader.DownloadRecord.access$100((QZonePluginDownloader.DownloadRecord)localObject1)))
            {
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramMessage.arg1);
              ((StringBuilder)localObject2).append("");
              localObject2 = ((StringBuilder)localObject2).toString();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramMessage.arg2);
              localStringBuilder.append("");
              reportDownload((QZonePluginDownloader.DownloadRecord)localObject1, 2, (String)localObject2, localStringBuilder.toString());
              this.downloadingMap.remove(QZonePluginDownloader.DownloadRecord.access$100((QZonePluginDownloader.DownloadRecord)localObject1));
              localObject2 = QZonePluginDownloader.DownloadRecord.access$300((QZonePluginDownloader.DownloadRecord)localObject1);
              if (localObject2 != null)
              {
                ((QZonePluginDownloader.OnPluginDownloadListner)localObject2).onDownloadFailed(QZonePluginDownloader.DownloadRecord.access$200((QZonePluginDownloader.DownloadRecord)localObject1), paramMessage.arg1);
                return false;
              }
            }
          }
        }
        else
        {
          paramMessage = (QZonePluginDownloader.DownloadRecord)paramMessage.obj;
          if (this.downloadingMap.containsKey(QZonePluginDownloader.DownloadRecord.access$100(paramMessage)))
          {
            reportDownload(paramMessage, 1, "");
            this.downloadingMap.remove(QZonePluginDownloader.DownloadRecord.access$100(paramMessage));
            localObject1 = QZonePluginDownloader.DownloadRecord.access$300(paramMessage);
            if (localObject1 != null)
            {
              ((QZonePluginDownloader.OnPluginDownloadListner)localObject1).onDownloadCanceled(QZonePluginDownloader.DownloadRecord.access$200(paramMessage));
              return false;
            }
          }
        }
      }
      else
      {
        paramMessage = (QZonePluginDownloader.DownloadRecord)paramMessage.obj;
        if (this.downloadingMap.containsKey(QZonePluginDownloader.DownloadRecord.access$100(paramMessage)))
        {
          reportDownload(paramMessage, 3, "");
          this.downloadingMap.remove(QZonePluginDownloader.DownloadRecord.access$100(paramMessage));
          cancelDownLoadPluginInner(paramMessage);
          localObject1 = QZonePluginDownloader.DownloadRecord.access$300(paramMessage);
          if (localObject1 != null) {
            ((QZonePluginDownloader.OnPluginDownloadListner)localObject1).onDownloadCanceled(QZonePluginDownloader.DownloadRecord.access$200(paramMessage));
          }
        }
      }
      return false;
    }
    paramMessage = (QZonePluginDownloader.DownloadRecord)paramMessage.obj;
    if (this.downloadingMap.containsKey(QZonePluginDownloader.DownloadRecord.access$100(paramMessage))) {
      return false;
    }
    this.downloadingMap.put(QZonePluginDownloader.DownloadRecord.access$100(paramMessage), paramMessage);
    downloadPluginInner(paramMessage);
    return true;
  }
  
  public void onDestroy()
  {
    startDownloadTime = 0L;
    startNetworkType = 0;
    downloadId = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginDownloader
 * JD-Core Version:    0.7.0.1
 */