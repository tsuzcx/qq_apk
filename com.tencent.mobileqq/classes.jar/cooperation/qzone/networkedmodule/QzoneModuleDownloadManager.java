package cooperation.qzone.networkedmodule;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePreDownloadManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class QzoneModuleDownloadManager
  implements Handler.Callback
{
  public static final int MSG_DOWNLOAD_ABORT = 7;
  public static final int MSG_DOWNLOAD_CANCEL = 4;
  public static final int MSG_DOWNLOAD_CANCELED = 5;
  public static final int MSG_DOWNLOAD_FAILED = 3;
  public static final int MSG_DOWNLOAD_MODULE = 1;
  public static final int MSG_DOWNLOAD_PROGRESS = 6;
  public static final int MSG_DOWNLOAD_SUCCESS = 2;
  private static String TAG = "QzoneModuleDownloadManager";
  private Context mContext;
  private Downloader.DownloadListener mDowndloadListener = new QzoneModuleDownloadManager.1(this);
  private QzonePreDownloadManager mDownloader;
  private Handler mHandler;
  private Map<String, QzoneModuleDownloadManager.DownloadTask> taskMap = new ConcurrentHashMap();
  
  public QzoneModuleDownloadManager(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mDownloader = QzonePreDownloadManager.getInstance();
    this.mHandler = new Handler(QzoneHandlerThreadFactory.getHandlerThreadLooper("Normal_HandlerThread"), this);
  }
  
  private void onHandleDownload(QzoneModuleDownloadManager.DownloadTask paramDownloadTask)
  {
    String str1 = paramDownloadTask.record.mUrl;
    if (this.taskMap.containsKey(str1)) {
      return;
    }
    this.taskMap.put(str1, paramDownloadTask);
    Object localObject = paramDownloadTask.record;
    String str2 = QzoneModuleConst.getModuleSavePath(this.mContext, (QzoneModuleConfigManager.QzoneModuleRecord)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "----------savePath--" + str2);
    }
    File localFile = new File(str2);
    if (localFile.exists())
    {
      String str3 = ((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mMD5;
      if ((TextUtils.isEmpty(str3)) || ((((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mModuleFileLength != 0L) && (((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mModuleFileLength == localFile.length())))
      {
        QLog.i(TAG, 1, "download succeed: from cache.");
        QzoneModuleConfigManager.getInstance().updateConfigAfterDownloaded((QzoneModuleConfigManager.QzoneModuleRecord)localObject);
        if (paramDownloadTask.listener != null)
        {
          paramDownloadTask.listener.onDownloadSucceed(paramDownloadTask.moduleId);
          this.taskMap.remove(str1);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 1, "before download-- orgMD5: " + str3 + " , downloadFilePath: " + localFile.getPath());
        }
        localObject = new File(str2);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        QLog.i(TAG, 1, "check download cache failed: md5 verify is not passed.");
      }
    }
    QLog.i(TAG, 1, "start download--" + paramDownloadTask.moduleId + ",priority: " + paramDownloadTask.priority + " ,startImmediately: " + paramDownloadTask.startImmediately);
    paramDownloadTask.startTimeStamp = System.nanoTime();
    this.mDownloader.download(str1, str2, paramDownloadTask.priority, paramDownloadTask.startImmediately, this.mDowndloadListener);
  }
  
  private void onHandleSuccess(String paramString)
  {
    QzoneModuleDownloadManager.DownloadTask localDownloadTask = (QzoneModuleDownloadManager.DownloadTask)this.taskMap.get(paramString);
    String str2;
    QzoneModuleConfigManager.QzoneModuleRecord localQzoneModuleRecord;
    String str3;
    long l;
    if (localDownloadTask != null)
    {
      str2 = QzoneModuleConst.getModuleSavePath(this.mContext, localDownloadTask.record);
      localQzoneModuleRecord = localDownloadTask.record;
      if (QLog.isDevelopLevel()) {
        QLog.d(TAG, 1, "download complete: " + str2);
      }
      str3 = localQzoneModuleRecord.mMD5;
      String str1 = "";
      if (!TextUtils.isEmpty(str3)) {
        str1 = MD5Utils.encodeFileHexStr(str2);
      }
      l = (System.nanoTime() - localDownloadTask.startTimeStamp) / 1000000L;
      if ((!TextUtils.isEmpty(str3)) && (!str3.equalsIgnoreCase(str1))) {
        break label254;
      }
      QzoneModuleConfigManager.getInstance().updateConfigAfterDownloaded(localQzoneModuleRecord);
    }
    for (;;)
    {
      try
      {
        if (QzoneModuleConst.QZONE_MODULES_NEED_INSTALL.contains(localQzoneModuleRecord.mModuleId)) {
          new DexClassLoader(str2, this.mContext.getApplicationContext().getDir("dex", 0).getAbsolutePath(), str2, this.mContext.getApplicationContext().getClassLoader());
        }
        if (localDownloadTask.listener != null) {
          localDownloadTask.listener.onDownloadSucceed(localDownloadTask.moduleId);
        }
        QzoneModuleReport.reportDownloadRes(localQzoneModuleRecord, true, l);
        this.taskMap.remove(paramString);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e(TAG, 1, "after download,new DexClassLoader error: ", localThrowable);
        continue;
      }
      label254:
      if (QLog.isDevelopLevel()) {
        QLog.d(TAG, 1, "download complete-- orgMD5: " + str3 + " , downloadMD5: " + localThrowable);
      }
      File localFile = new File(str2);
      if (localFile.exists()) {
        localFile.delete();
      }
      QLog.i(TAG, 1, "download failed: md5 verify is not passed.");
      if (localDownloadTask.listener != null) {
        localDownloadTask.listener.onDownloadFailed(localDownloadTask.moduleId);
      }
      QzoneModuleReport.reportDownloadRes(localQzoneModuleRecord, false, l);
    }
  }
  
  public void abortDownloadModule(String paramString)
  {
    paramString = QzoneModuleConfigManager.getInstance().getModuleRecord(paramString);
    if ((paramString == null) || (!this.taskMap.containsKey(paramString.mUrl))) {}
    do
    {
      return;
      paramString = (QzoneModuleDownloadManager.DownloadTask)this.taskMap.get(paramString.mUrl);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.mHandler);
    localMessage.what = 7;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void cancelDownloadModule(String paramString)
  {
    paramString = QzoneModuleConfigManager.getInstance().getModuleRecord(paramString);
    if ((paramString == null) || (!this.taskMap.containsKey(paramString.mUrl))) {}
    do
    {
      return;
      paramString = (QzoneModuleDownloadManager.DownloadTask)this.taskMap.get(paramString.mUrl);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.mHandler);
    localMessage.what = 4;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean downloadModule(QzoneModuleConfigManager.QzoneModuleRecord paramQzoneModuleRecord, ModuleDownloadListener paramModuleDownloadListener)
  {
    return downloadModule(paramQzoneModuleRecord, false, paramModuleDownloadListener);
  }
  
  public boolean downloadModule(QzoneModuleConfigManager.QzoneModuleRecord paramQzoneModuleRecord, boolean paramBoolean, ModuleDownloadListener paramModuleDownloadListener)
  {
    return downloadModule(paramQzoneModuleRecord, paramBoolean, false, paramModuleDownloadListener);
  }
  
  public boolean downloadModule(QzoneModuleConfigManager.QzoneModuleRecord paramQzoneModuleRecord, boolean paramBoolean1, boolean paramBoolean2, ModuleDownloadListener paramModuleDownloadListener)
  {
    if (paramQzoneModuleRecord == null) {
      return false;
    }
    QzoneModuleDownloadManager.DownloadTask localDownloadTask = new QzoneModuleDownloadManager.DownloadTask(null);
    localDownloadTask.moduleId = paramQzoneModuleRecord.mModuleId;
    localDownloadTask.record = paramQzoneModuleRecord;
    localDownloadTask.listener = paramModuleDownloadListener;
    localDownloadTask.priority = paramBoolean1;
    localDownloadTask.startImmediately = paramBoolean2;
    paramQzoneModuleRecord = Message.obtain(this.mHandler);
    paramQzoneModuleRecord.what = 1;
    paramQzoneModuleRecord.obj = localDownloadTask;
    paramQzoneModuleRecord.sendToTarget();
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    QzoneModuleDownloadManager.DownloadTask localDownloadTask;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      onHandleDownload((QzoneModuleDownloadManager.DownloadTask)paramMessage.obj);
      return true;
    case 2: 
      onHandleSuccess((String)paramMessage.obj);
      return true;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      localDownloadTask = (QzoneModuleDownloadManager.DownloadTask)this.taskMap.get(paramMessage);
      if (localDownloadTask != null)
      {
        QLog.e(TAG, 1, "download failed: " + localDownloadTask.moduleId);
        if (localDownloadTask.listener != null) {
          localDownloadTask.listener.onDownloadFailed(localDownloadTask.moduleId);
        }
        long l = (System.nanoTime() - localDownloadTask.startTimeStamp) / 1000000L;
        QzoneModuleReport.reportDownloadRes(localDownloadTask.record, false, l);
      }
      this.taskMap.remove(paramMessage);
      return true;
    case 4: 
      paramMessage = (QzoneModuleDownloadManager.DownloadTask)paramMessage.obj;
      QLog.w(TAG, 1, "cancel download: " + paramMessage.moduleId);
      paramMessage = paramMessage.record.mUrl;
      this.mDownloader.cancel(paramMessage, this.mDowndloadListener);
      return true;
    case 5: 
      paramMessage = (String)paramMessage.obj;
      localDownloadTask = (QzoneModuleDownloadManager.DownloadTask)this.taskMap.get(paramMessage);
      if (localDownloadTask != null)
      {
        QLog.w(TAG, 1, "download canceled: " + localDownloadTask.moduleId);
        if (localDownloadTask.listener != null) {
          localDownloadTask.listener.onDownloadCanceled(localDownloadTask.moduleId);
        }
      }
      this.taskMap.remove(paramMessage);
      return true;
    case 6: 
      paramMessage = (QzoneModuleDownloadManager.DownloadTask)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.listener != null))
      {
        float f = ((Float)paramMessage.obj).floatValue();
        paramMessage.listener.onDownloadProgress(paramMessage.moduleId, f);
      }
      return true;
    }
    paramMessage = (QzoneModuleDownloadManager.DownloadTask)paramMessage.obj;
    QLog.w(TAG, 1, "abort download: " + paramMessage.moduleId);
    paramMessage = paramMessage.record.mUrl;
    this.mDownloader.abort(paramMessage, this.mDowndloadListener);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleDownloadManager
 * JD-Core Version:    0.7.0.1
 */