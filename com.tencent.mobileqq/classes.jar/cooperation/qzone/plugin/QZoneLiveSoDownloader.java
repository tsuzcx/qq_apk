package cooperation.qzone.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.FileUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class QZoneLiveSoDownloader
  implements Handler.Callback
{
  private static final int MSG_CANCEL_DOWNLOAD_SO = 1;
  private static final int MSG_DOWNLOAD_SO = 0;
  private static final int MSG_DOWNLOAD_SO_CANCELED = 2;
  private static final int MSG_DOWNLOAD_SO_FAIL = 3;
  private static final int MSG_DOWNLOAD_SO_PROGESS = 5;
  private static final int MSG_DOWNLOAD_SO_SUCCESS = 4;
  private static final String TAG = "QZoneLiveSoDownloader";
  private static String soZipName = "livepluginso.jar";
  private Downloader downloader;
  private Map<String, QZoneLiveSoDownloader.DownloadSoRecord> downloadingMap;
  Handler handler;
  private Context mContext;
  
  QZoneLiveSoDownloader(Context paramContext)
  {
    this.mContext = paramContext;
    this.downloader = DownloaderFactory.getInstance(this.mContext).getCommonDownloader();
    this.downloader.enableResumeTransfer(true);
    this.downloadingMap = new HashMap();
    this.handler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void cancelDownLoadSoInner(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord)
  {
    if (paramDownloadSoRecord != null) {
      this.downloader.cancel(QZoneLiveSoDownloader.DownloadSoRecord.access$000(paramDownloadSoRecord), new QZoneLiveSoDownloader.SoDownloadListener(this, paramDownloadSoRecord));
    }
  }
  
  private void downloadSoInner(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord)
  {
    if (paramDownloadSoRecord != null)
    {
      Object localObject = QZoneLiveSoDownloader.DownloadSoRecord.access$100(paramDownloadSoRecord);
      if (localObject != null) {
        ((QZoneLiveSoDownloader.OnSoDownloadListener)localObject).onDownLoadStart(paramDownloadSoRecord);
      }
      localObject = QZonePluginUtils.getQzoneSVFilterSoPath(BaseApplicationImpl.getContext()) + soZipName;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveSoDownloader", 2, "downloadSoInner url:" + QZoneLiveSoDownloader.DownloadSoRecord.access$000(paramDownloadSoRecord) + "     path:" + (String)localObject);
      }
      if (!this.downloader.download(QZoneLiveSoDownloader.DownloadSoRecord.access$000(paramDownloadSoRecord), (String)localObject, new QZoneLiveSoDownloader.SoDownloadListener(this, paramDownloadSoRecord)))
      {
        localObject = Message.obtain(this.handler, 3);
        ((Message)localObject).obj = paramDownloadSoRecord;
        ((Message)localObject).sendToTarget();
      }
    }
  }
  
  private void reportDownload(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord, int paramInt1, int paramInt2)
  {
    paramDownloadSoRecord = new HashMap();
    paramDownloadSoRecord.put("ret_code", String.valueOf(paramInt1));
    paramDownloadSoRecord.put("refer", String.valueOf(paramInt2));
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actQZLiveDownloadSoReport", true, 0L, 0L, paramDownloadSoRecord, null);
    }
  }
  
  private static void unZipPluginSo()
  {
    String str = QZonePluginUtils.getQzoneSVFilterSoPath(BaseApplicationImpl.getContext());
    if (TextUtils.isEmpty(str)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(str + soZipName);
    } while (!localFile.exists());
    try
    {
      FileUtils.unzip(localFile, new File(str));
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveSoDownloader", 2, "unZipPluginSo success");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.w("QZoneLiveSoDownloader", 1, "unzipTofolder" + localException.getMessage());
      return;
    }
    finally
    {
      localFile.delete();
    }
  }
  
  public void cancelDownLoadSo(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramString;
  }
  
  public void downloadSo(String paramString, QZoneLiveSoDownloader.OnSoDownloadListener paramOnSoDownloadListener, int paramInt)
  {
    QZoneLiveSoDownloader.DownloadSoRecord localDownloadSoRecord = new QZoneLiveSoDownloader.DownloadSoRecord();
    QZoneLiveSoDownloader.DownloadSoRecord.access$002(localDownloadSoRecord, paramString);
    QZoneLiveSoDownloader.DownloadSoRecord.access$102(localDownloadSoRecord, paramOnSoDownloadListener);
    QZoneLiveSoDownloader.DownloadSoRecord.access$202(localDownloadSoRecord, paramInt);
    if ((QZonePluginUtils.isQzoneLiveSoExist(BaseApplicationImpl.getContext())) && (paramOnSoDownloadListener != null))
    {
      paramOnSoDownloadListener.onDownloadSucceed(localDownloadSoRecord);
      return;
    }
    paramString = Message.obtain();
    paramString.what = 0;
    paramString.obj = localDownloadSoRecord;
    this.handler.sendMessage(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((paramMessage.obj instanceof QZoneLiveSoDownloader.DownloadSoRecord))
      {
        paramMessage = (QZoneLiveSoDownloader.DownloadSoRecord)paramMessage.obj;
        if (this.downloadingMap.containsKey(QZoneLiveSoDownloader.DownloadSoRecord.access$000(paramMessage))) {
          return false;
        }
        this.downloadingMap.put(QZoneLiveSoDownloader.DownloadSoRecord.access$000(paramMessage), paramMessage);
        downloadSoInner(paramMessage);
        return true;
        if ((paramMessage.obj instanceof String))
        {
          paramMessage = (String)paramMessage.obj;
          if (this.downloadingMap.containsKey(paramMessage))
          {
            Object localObject = (QZoneLiveSoDownloader.DownloadSoRecord)this.downloadingMap.get(paramMessage);
            reportDownload((QZoneLiveSoDownloader.DownloadSoRecord)localObject, 3, QZoneLiveSoDownloader.DownloadSoRecord.access$200((QZoneLiveSoDownloader.DownloadSoRecord)localObject));
            this.downloadingMap.remove(paramMessage);
            cancelDownLoadSoInner((QZoneLiveSoDownloader.DownloadSoRecord)localObject);
            continue;
            if ((paramMessage.obj instanceof QZoneLiveSoDownloader.DownloadSoRecord))
            {
              paramMessage = (QZoneLiveSoDownloader.DownloadSoRecord)paramMessage.obj;
              if (this.downloadingMap.containsKey(QZoneLiveSoDownloader.DownloadSoRecord.access$000(paramMessage)))
              {
                reportDownload(paramMessage, 1, QZoneLiveSoDownloader.DownloadSoRecord.access$200(paramMessage));
                this.downloadingMap.remove(QZoneLiveSoDownloader.DownloadSoRecord.access$000(paramMessage));
                localObject = QZoneLiveSoDownloader.DownloadSoRecord.access$100(paramMessage);
                if (localObject != null)
                {
                  ((QZoneLiveSoDownloader.OnSoDownloadListener)localObject).onDownloadCanceled(paramMessage);
                  continue;
                  if ((paramMessage.obj instanceof QZoneLiveSoDownloader.DownloadSoRecord))
                  {
                    paramMessage = (QZoneLiveSoDownloader.DownloadSoRecord)paramMessage.obj;
                    if (this.downloadingMap.containsKey(QZoneLiveSoDownloader.DownloadSoRecord.access$000(paramMessage)))
                    {
                      reportDownload(paramMessage, 2, QZoneLiveSoDownloader.DownloadSoRecord.access$200(paramMessage));
                      this.downloadingMap.remove(QZoneLiveSoDownloader.DownloadSoRecord.access$000(paramMessage));
                      localObject = QZoneLiveSoDownloader.DownloadSoRecord.access$100(paramMessage);
                      if (localObject != null)
                      {
                        ((QZoneLiveSoDownloader.OnSoDownloadListener)localObject).onDownloadFailed(paramMessage);
                        continue;
                        if ((paramMessage.obj instanceof QZoneLiveSoDownloader.DownloadSoRecord))
                        {
                          paramMessage = (QZoneLiveSoDownloader.DownloadSoRecord)paramMessage.obj;
                          if (this.downloadingMap.containsKey(QZoneLiveSoDownloader.DownloadSoRecord.access$000(paramMessage)))
                          {
                            localObject = QZoneLiveSoDownloader.DownloadSoRecord.access$100(paramMessage);
                            unZipPluginSo();
                            LocalMultiProcConfig.putInt("QzoneLiveSoVersion", QzoneConfig.getInstance().getConfig("LiveSetting", "LivePluginSOVersion", 5));
                            if (QZonePluginUtils.isQzoneLiveSoExist(BaseApplicationImpl.getContext()))
                            {
                              reportDownload(paramMessage, 0, QZoneLiveSoDownloader.DownloadSoRecord.access$200(paramMessage));
                              this.downloadingMap.remove(QZoneLiveSoDownloader.DownloadSoRecord.access$000(paramMessage));
                              if (localObject != null) {
                                ((QZoneLiveSoDownloader.OnSoDownloadListener)localObject).onDownloadSucceed(paramMessage);
                              }
                            }
                            else if (localObject != null)
                            {
                              ((QZoneLiveSoDownloader.OnSoDownloadListener)localObject).onDownloadFailed(paramMessage);
                              continue;
                              if ((paramMessage.obj instanceof QZoneLiveSoDownloader.DownloadSoRecord))
                              {
                                paramMessage = (QZoneLiveSoDownloader.DownloadSoRecord)paramMessage.obj;
                                if (this.downloadingMap.containsKey(QZoneLiveSoDownloader.DownloadSoRecord.access$000(paramMessage)))
                                {
                                  localObject = QZoneLiveSoDownloader.DownloadSoRecord.access$100(paramMessage);
                                  if (localObject != null) {
                                    ((QZoneLiveSoDownloader.OnSoDownloadListener)localObject).onDownloadProgress(paramMessage);
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
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZoneLiveSoDownloader
 * JD-Core Version:    0.7.0.1
 */