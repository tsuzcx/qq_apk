package cooperation.qzone.plugin;

import amha;
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
  private static String jdField_a_of_type_JavaLangString = "livepluginso.jar";
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Map jdField_a_of_type_JavaUtilMap;
  
  QZoneLiveSoDownloader(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext).getCommonDownloader();
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.enableResumeTransfer(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private static void a()
  {
    String str = QZonePluginUtils.a(BaseApplicationImpl.getContext());
    if (TextUtils.isEmpty(str)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(str + jdField_a_of_type_JavaLangString);
    } while (!localFile.exists());
    try
    {
      FileUtils.b(localFile, new File(str));
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
  
  private void a(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord)
  {
    if (paramDownloadSoRecord != null)
    {
      Object localObject = QZoneLiveSoDownloader.DownloadSoRecord.a(paramDownloadSoRecord);
      if (localObject != null) {
        ((QZoneLiveSoDownloader.OnSoDownloadListener)localObject).a(paramDownloadSoRecord);
      }
      localObject = QZonePluginUtils.a(BaseApplicationImpl.getContext()) + jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveSoDownloader", 2, "downloadSoInner url:" + QZoneLiveSoDownloader.DownloadSoRecord.a(paramDownloadSoRecord) + "     path:" + (String)localObject);
      }
      if (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(QZoneLiveSoDownloader.DownloadSoRecord.a(paramDownloadSoRecord), (String)localObject, new amha(this, paramDownloadSoRecord)))
      {
        localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
        ((Message)localObject).obj = paramDownloadSoRecord;
        ((Message)localObject).sendToTarget();
      }
    }
  }
  
  private void a(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord, int paramInt1, int paramInt2)
  {
    paramDownloadSoRecord = new HashMap();
    paramDownloadSoRecord.put("ret_code", String.valueOf(paramInt1));
    paramDownloadSoRecord.put("refer", String.valueOf(paramInt2));
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actQZLiveDownloadSoReport", true, 0L, 0L, paramDownloadSoRecord, null);
    }
  }
  
  private void b(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord)
  {
    if (paramDownloadSoRecord != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.cancel(QZoneLiveSoDownloader.DownloadSoRecord.a(paramDownloadSoRecord), new amha(this, paramDownloadSoRecord));
    }
  }
  
  public void a(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramString;
  }
  
  public void a(String paramString, QZoneLiveSoDownloader.OnSoDownloadListener paramOnSoDownloadListener, int paramInt)
  {
    QZoneLiveSoDownloader.DownloadSoRecord localDownloadSoRecord = new QZoneLiveSoDownloader.DownloadSoRecord();
    QZoneLiveSoDownloader.DownloadSoRecord.a(localDownloadSoRecord, paramString);
    QZoneLiveSoDownloader.DownloadSoRecord.a(localDownloadSoRecord, paramOnSoDownloadListener);
    QZoneLiveSoDownloader.DownloadSoRecord.a(localDownloadSoRecord, paramInt);
    if ((QZonePluginUtils.a(BaseApplicationImpl.getContext())) && (paramOnSoDownloadListener != null))
    {
      paramOnSoDownloadListener.d(localDownloadSoRecord);
      return;
    }
    paramString = Message.obtain();
    paramString.what = 0;
    paramString.obj = localDownloadSoRecord;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
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
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(QZoneLiveSoDownloader.DownloadSoRecord.a(paramMessage))) {
          return false;
        }
        this.jdField_a_of_type_JavaUtilMap.put(QZoneLiveSoDownloader.DownloadSoRecord.a(paramMessage), paramMessage);
        a(paramMessage);
        return true;
        if ((paramMessage.obj instanceof String))
        {
          paramMessage = (String)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMessage))
          {
            Object localObject = (QZoneLiveSoDownloader.DownloadSoRecord)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
            a((QZoneLiveSoDownloader.DownloadSoRecord)localObject, 3, QZoneLiveSoDownloader.DownloadSoRecord.a((QZoneLiveSoDownloader.DownloadSoRecord)localObject));
            this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
            b((QZoneLiveSoDownloader.DownloadSoRecord)localObject);
            continue;
            if ((paramMessage.obj instanceof QZoneLiveSoDownloader.DownloadSoRecord))
            {
              paramMessage = (QZoneLiveSoDownloader.DownloadSoRecord)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(QZoneLiveSoDownloader.DownloadSoRecord.a(paramMessage)))
              {
                a(paramMessage, 1, QZoneLiveSoDownloader.DownloadSoRecord.a(paramMessage));
                this.jdField_a_of_type_JavaUtilMap.remove(QZoneLiveSoDownloader.DownloadSoRecord.a(paramMessage));
                localObject = QZoneLiveSoDownloader.DownloadSoRecord.a(paramMessage);
                if (localObject != null)
                {
                  ((QZoneLiveSoDownloader.OnSoDownloadListener)localObject).b(paramMessage);
                  continue;
                  if ((paramMessage.obj instanceof QZoneLiveSoDownloader.DownloadSoRecord))
                  {
                    paramMessage = (QZoneLiveSoDownloader.DownloadSoRecord)paramMessage.obj;
                    if (this.jdField_a_of_type_JavaUtilMap.containsKey(QZoneLiveSoDownloader.DownloadSoRecord.a(paramMessage)))
                    {
                      a(paramMessage, 2, QZoneLiveSoDownloader.DownloadSoRecord.a(paramMessage));
                      this.jdField_a_of_type_JavaUtilMap.remove(QZoneLiveSoDownloader.DownloadSoRecord.a(paramMessage));
                      localObject = QZoneLiveSoDownloader.DownloadSoRecord.a(paramMessage);
                      if (localObject != null)
                      {
                        ((QZoneLiveSoDownloader.OnSoDownloadListener)localObject).c(paramMessage);
                        continue;
                        if ((paramMessage.obj instanceof QZoneLiveSoDownloader.DownloadSoRecord))
                        {
                          paramMessage = (QZoneLiveSoDownloader.DownloadSoRecord)paramMessage.obj;
                          if (this.jdField_a_of_type_JavaUtilMap.containsKey(QZoneLiveSoDownloader.DownloadSoRecord.a(paramMessage)))
                          {
                            localObject = QZoneLiveSoDownloader.DownloadSoRecord.a(paramMessage);
                            a();
                            LocalMultiProcConfig.putInt("QzoneLiveSoVersion", QzoneConfig.getInstance().getConfig("LiveSetting", "LivePluginSOVersion", 5));
                            if (QZonePluginUtils.a(BaseApplicationImpl.getContext()))
                            {
                              a(paramMessage, 0, QZoneLiveSoDownloader.DownloadSoRecord.a(paramMessage));
                              this.jdField_a_of_type_JavaUtilMap.remove(QZoneLiveSoDownloader.DownloadSoRecord.a(paramMessage));
                              if (localObject != null) {
                                ((QZoneLiveSoDownloader.OnSoDownloadListener)localObject).d(paramMessage);
                              }
                            }
                            else if (localObject != null)
                            {
                              ((QZoneLiveSoDownloader.OnSoDownloadListener)localObject).c(paramMessage);
                              continue;
                              if ((paramMessage.obj instanceof QZoneLiveSoDownloader.DownloadSoRecord))
                              {
                                paramMessage = (QZoneLiveSoDownloader.DownloadSoRecord)paramMessage.obj;
                                if (this.jdField_a_of_type_JavaUtilMap.containsKey(QZoneLiveSoDownloader.DownloadSoRecord.a(paramMessage)))
                                {
                                  localObject = QZoneLiveSoDownloader.DownloadSoRecord.a(paramMessage);
                                  if (localObject != null) {
                                    ((QZoneLiveSoDownloader.OnSoDownloadListener)localObject).e(paramMessage);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.plugin.QZoneLiveSoDownloader
 * JD-Core Version:    0.7.0.1
 */