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
    Object localObject1 = paramDownloadTask.record;
    String str2 = QzoneModuleConst.getModuleSavePath(this.mContext, (QzoneModuleRecord)localObject1);
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject2 = TAG;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("----------savePath--");
      ((StringBuilder)localObject3).append(str2);
      QLog.d((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    }
    Object localObject2 = new File(str2);
    if (((File)localObject2).exists())
    {
      localObject3 = ((QzoneModuleRecord)localObject1).mMD5;
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && ((((QzoneModuleRecord)localObject1).mModuleFileLength == 0L) || (((QzoneModuleRecord)localObject1).mModuleFileLength != ((File)localObject2).length())))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("before download-- orgMD5: ");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(" , downloadFilePath: ");
          localStringBuilder.append(((File)localObject2).getPath());
          QLog.d((String)localObject1, 1, localStringBuilder.toString());
        }
        localObject1 = new File(str2);
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        QLog.i(TAG, 1, "check download cache failed: md5 verify is not passed.");
      }
      else
      {
        QLog.i(TAG, 1, "download succeed: from cache.");
        QzoneModuleConfigManager.getInstance().updateConfigAfterDownloaded((QzoneModuleRecord)localObject1);
        if (paramDownloadTask.listener != null)
        {
          paramDownloadTask.listener.onDownloadSucceed(paramDownloadTask.moduleId);
          this.taskMap.remove(str1);
          return;
        }
      }
    }
    localObject1 = TAG;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("start download--");
    ((StringBuilder)localObject2).append(paramDownloadTask.moduleId);
    ((StringBuilder)localObject2).append(",priority: ");
    ((StringBuilder)localObject2).append(paramDownloadTask.priority);
    ((StringBuilder)localObject2).append(" ,startImmediately: ");
    ((StringBuilder)localObject2).append(paramDownloadTask.startImmediately);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    paramDownloadTask.startTimeStamp = System.nanoTime();
    this.mDownloader.download(str1, str2, paramDownloadTask.priority, paramDownloadTask.startImmediately, this.mDowndloadListener);
  }
  
  private void onHandleSuccess(String paramString)
  {
    QzoneModuleDownloadManager.DownloadTask localDownloadTask = (QzoneModuleDownloadManager.DownloadTask)this.taskMap.get(paramString);
    if (localDownloadTask != null)
    {
      String str1 = QzoneModuleConst.getModuleSavePath(this.mContext, localDownloadTask.record);
      QzoneModuleRecord localQzoneModuleRecord = localDownloadTask.record;
      Object localObject1;
      if (QLog.isDevelopLevel())
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("download complete: ");
        ((StringBuilder)localObject2).append(str1);
        QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = localQzoneModuleRecord.mMD5;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = MD5Utils.encodeFileHexStr(str1);
      } else {
        localObject1 = "";
      }
      long l = (System.nanoTime() - localDownloadTask.startTimeStamp) / 1000000L;
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equalsIgnoreCase((String)localObject1)))
      {
        if (QLog.isDevelopLevel())
        {
          String str2 = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("download complete-- orgMD5: ");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(" , downloadMD5: ");
          localStringBuilder.append((String)localObject1);
          QLog.d(str2, 1, localStringBuilder.toString());
        }
        localObject1 = new File(str1);
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        QLog.i(TAG, 1, "download failed: md5 verify is not passed.");
        if (localDownloadTask.listener != null) {
          localDownloadTask.listener.onDownloadFailed(localDownloadTask.moduleId);
        }
        QzoneModuleReport.reportDownloadRes(localQzoneModuleRecord, false, l);
      }
      else
      {
        QzoneModuleConfigManager.getInstance().updateConfigAfterDownloaded(localQzoneModuleRecord);
        try
        {
          if (QzoneModuleConst.QZONE_MODULES_NEED_INSTALL.contains(localQzoneModuleRecord.mModuleId)) {
            new DexClassLoader(str1, this.mContext.getApplicationContext().getDir("dex", 0).getAbsolutePath(), str1, this.mContext.getApplicationContext().getClassLoader());
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e(TAG, 1, "after download,new DexClassLoader error: ", localThrowable);
        }
        if (localDownloadTask.listener != null) {
          localDownloadTask.listener.onDownloadSucceed(localDownloadTask.moduleId);
        }
        QzoneModuleReport.reportDownloadRes(localQzoneModuleRecord, true, l);
      }
    }
    this.taskMap.remove(paramString);
  }
  
  public void abortDownloadModule(String paramString)
  {
    paramString = QzoneModuleConfigManager.getInstance().getModuleRecord(paramString);
    if (paramString != null)
    {
      if (!this.taskMap.containsKey(paramString.mUrl)) {
        return;
      }
      paramString = (QzoneModuleDownloadManager.DownloadTask)this.taskMap.get(paramString.mUrl);
      if (paramString != null)
      {
        Message localMessage = Message.obtain(this.mHandler);
        localMessage.what = 7;
        localMessage.obj = paramString;
        localMessage.sendToTarget();
      }
    }
  }
  
  public void cancelDownloadModule(String paramString)
  {
    paramString = QzoneModuleConfigManager.getInstance().getModuleRecord(paramString);
    if (paramString != null)
    {
      if (!this.taskMap.containsKey(paramString.mUrl)) {
        return;
      }
      paramString = (QzoneModuleDownloadManager.DownloadTask)this.taskMap.get(paramString.mUrl);
      if (paramString != null)
      {
        Message localMessage = Message.obtain(this.mHandler);
        localMessage.what = 4;
        localMessage.obj = paramString;
        localMessage.sendToTarget();
      }
    }
  }
  
  public boolean downloadModule(QzoneModuleRecord paramQzoneModuleRecord, ModuleDownloadListener paramModuleDownloadListener)
  {
    return downloadModule(paramQzoneModuleRecord, false, paramModuleDownloadListener);
  }
  
  public boolean downloadModule(QzoneModuleRecord paramQzoneModuleRecord, boolean paramBoolean, ModuleDownloadListener paramModuleDownloadListener)
  {
    return downloadModule(paramQzoneModuleRecord, paramBoolean, false, paramModuleDownloadListener);
  }
  
  public boolean downloadModule(QzoneModuleRecord paramQzoneModuleRecord, boolean paramBoolean1, boolean paramBoolean2, ModuleDownloadListener paramModuleDownloadListener)
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
    Object localObject1;
    Object localObject2;
    StringBuilder localStringBuilder;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 7: 
      paramMessage = (QzoneModuleDownloadManager.DownloadTask)paramMessage.obj;
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("abort download: ");
      ((StringBuilder)localObject2).append(paramMessage.moduleId);
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      paramMessage = paramMessage.record.mUrl;
      this.mDownloader.abort(paramMessage, this.mDowndloadListener);
      return true;
    case 6: 
      paramMessage = (QzoneModuleDownloadManager.DownloadTask)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.listener != null))
      {
        float f = ((Float)paramMessage.obj).floatValue();
        paramMessage.listener.onDownloadProgress(paramMessage.moduleId, f);
        return true;
      }
      break;
    case 5: 
      paramMessage = (String)paramMessage.obj;
      localObject1 = (QzoneModuleDownloadManager.DownloadTask)this.taskMap.get(paramMessage);
      if (localObject1 != null)
      {
        localObject2 = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("download canceled: ");
        localStringBuilder.append(((QzoneModuleDownloadManager.DownloadTask)localObject1).moduleId);
        QLog.w((String)localObject2, 1, localStringBuilder.toString());
        if (((QzoneModuleDownloadManager.DownloadTask)localObject1).listener != null) {
          ((QzoneModuleDownloadManager.DownloadTask)localObject1).listener.onDownloadCanceled(((QzoneModuleDownloadManager.DownloadTask)localObject1).moduleId);
        }
      }
      this.taskMap.remove(paramMessage);
      return true;
    case 4: 
      paramMessage = (QzoneModuleDownloadManager.DownloadTask)paramMessage.obj;
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("cancel download: ");
      ((StringBuilder)localObject2).append(paramMessage.moduleId);
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      paramMessage = paramMessage.record.mUrl;
      this.mDownloader.cancel(paramMessage, this.mDowndloadListener);
      return true;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      localObject1 = (QzoneModuleDownloadManager.DownloadTask)this.taskMap.get(paramMessage);
      if (localObject1 != null)
      {
        localObject2 = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("download failed: ");
        localStringBuilder.append(((QzoneModuleDownloadManager.DownloadTask)localObject1).moduleId);
        QLog.e((String)localObject2, 1, localStringBuilder.toString());
        if (((QzoneModuleDownloadManager.DownloadTask)localObject1).listener != null) {
          ((QzoneModuleDownloadManager.DownloadTask)localObject1).listener.onDownloadFailed(((QzoneModuleDownloadManager.DownloadTask)localObject1).moduleId);
        }
        long l = (System.nanoTime() - ((QzoneModuleDownloadManager.DownloadTask)localObject1).startTimeStamp) / 1000000L;
        QzoneModuleReport.reportDownloadRes(((QzoneModuleDownloadManager.DownloadTask)localObject1).record, false, l);
      }
      this.taskMap.remove(paramMessage);
      return true;
    case 2: 
      onHandleSuccess((String)paramMessage.obj);
      return true;
    case 1: 
      onHandleDownload((QzoneModuleDownloadManager.DownloadTask)paramMessage.obj);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleDownloadManager
 * JD-Core Version:    0.7.0.1
 */