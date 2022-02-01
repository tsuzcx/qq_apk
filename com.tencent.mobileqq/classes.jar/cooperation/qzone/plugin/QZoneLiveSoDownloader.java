package cooperation.qzone.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(QZonePluginUtils.getQzoneSVFilterSoPath(BaseApplicationImpl.getContext()));
      ((StringBuilder)localObject).append(soZipName);
      localObject = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("downloadSoInner url:");
        localStringBuilder.append(QZoneLiveSoDownloader.DownloadSoRecord.access$000(paramDownloadSoRecord));
        localStringBuilder.append("     path:");
        localStringBuilder.append((String)localObject);
        QLog.d("QZoneLiveSoDownloader", 2, localStringBuilder.toString());
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
  
  /* Error */
  private static void unZipPluginSo()
  {
    // Byte code:
    //   0: invokestatic 116	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokestatic 122	cooperation/qzone/plugin/QZonePluginUtils:getQzoneSVFilterSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore_1
    //   7: aload_1
    //   8: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: new 109	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   22: astore_0
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_0
    //   30: getstatic 128	cooperation/qzone/plugin/QZoneLiveSoDownloader:soZipName	Ljava/lang/String;
    //   33: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: new 214	java/io/File
    //   40: dup
    //   41: aload_0
    //   42: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 217	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual 220	java/io/File:exists	()Z
    //   53: ifne +4 -> 57
    //   56: return
    //   57: aload_0
    //   58: new 214	java/io/File
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 217	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: invokestatic 226	cooperation/qzone/util/FileUtils:unzip	(Ljava/io/File;Ljava/io/File;)Z
    //   69: pop
    //   70: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +11 -> 84
    //   76: ldc 23
    //   78: iconst_2
    //   79: ldc 228
    //   81: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: aload_0
    //   85: invokevirtual 231	java/io/File:delete	()Z
    //   88: pop
    //   89: return
    //   90: astore_1
    //   91: goto +41 -> 132
    //   94: astore_1
    //   95: new 109	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   102: astore_2
    //   103: aload_2
    //   104: ldc 233
    //   106: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_2
    //   111: aload_1
    //   112: invokevirtual 236	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   115: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: ldc 23
    //   121: iconst_1
    //   122: aload_2
    //   123: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 239	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: goto -45 -> 84
    //   132: aload_0
    //   133: invokevirtual 231	java/io/File:delete	()Z
    //   136: pop
    //   137: goto +5 -> 142
    //   140: aload_1
    //   141: athrow
    //   142: goto -2 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	111	0	localObject1	Object
    //   6	57	1	str	String
    //   90	1	1	localObject2	Object
    //   94	47	1	localException	java.lang.Exception
    //   102	21	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   57	84	90	finally
    //   95	129	90	finally
    //   57	84	94	java/lang/Exception
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
    int i = paramMessage.what;
    if (i != 0)
    {
      Object localObject;
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
              if ((paramMessage.obj instanceof QZoneLiveSoDownloader.DownloadSoRecord))
              {
                paramMessage = (QZoneLiveSoDownloader.DownloadSoRecord)paramMessage.obj;
                if (this.downloadingMap.containsKey(QZoneLiveSoDownloader.DownloadSoRecord.access$000(paramMessage)))
                {
                  localObject = QZoneLiveSoDownloader.DownloadSoRecord.access$100(paramMessage);
                  if (localObject != null)
                  {
                    ((QZoneLiveSoDownloader.OnSoDownloadListener)localObject).onDownloadProgress(paramMessage);
                    return false;
                  }
                }
              }
            }
            else if ((paramMessage.obj instanceof QZoneLiveSoDownloader.DownloadSoRecord))
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
                  if (localObject != null)
                  {
                    ((QZoneLiveSoDownloader.OnSoDownloadListener)localObject).onDownloadSucceed(paramMessage);
                    return false;
                  }
                }
                else if (localObject != null)
                {
                  ((QZoneLiveSoDownloader.OnSoDownloadListener)localObject).onDownloadFailed(paramMessage);
                  return false;
                }
              }
            }
          }
          else if ((paramMessage.obj instanceof QZoneLiveSoDownloader.DownloadSoRecord))
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
                return false;
              }
            }
          }
        }
        else if ((paramMessage.obj instanceof QZoneLiveSoDownloader.DownloadSoRecord))
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
              return false;
            }
          }
        }
      }
      else if ((paramMessage.obj instanceof String))
      {
        paramMessage = (String)paramMessage.obj;
        if (this.downloadingMap.containsKey(paramMessage))
        {
          localObject = (QZoneLiveSoDownloader.DownloadSoRecord)this.downloadingMap.get(paramMessage);
          reportDownload((QZoneLiveSoDownloader.DownloadSoRecord)localObject, 3, QZoneLiveSoDownloader.DownloadSoRecord.access$200((QZoneLiveSoDownloader.DownloadSoRecord)localObject));
          this.downloadingMap.remove(paramMessage);
          cancelDownLoadSoInner((QZoneLiveSoDownloader.DownloadSoRecord)localObject);
          return false;
        }
      }
    }
    else if ((paramMessage.obj instanceof QZoneLiveSoDownloader.DownloadSoRecord))
    {
      paramMessage = (QZoneLiveSoDownloader.DownloadSoRecord)paramMessage.obj;
      if (this.downloadingMap.containsKey(QZoneLiveSoDownloader.DownloadSoRecord.access$000(paramMessage))) {
        return false;
      }
      this.downloadingMap.put(QZoneLiveSoDownloader.DownloadSoRecord.access$000(paramMessage), paramMessage);
      downloadSoInner(paramMessage);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.plugin.QZoneLiveSoDownloader
 * JD-Core Version:    0.7.0.1
 */