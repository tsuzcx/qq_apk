package cooperation.qzone.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import anew;
import anex;
import aney;
import anez;
import anfc;
import anfd;
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
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  private static long jdField_b_of_type_Long = 20971520L;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Map jdField_a_of_type_JavaUtilMap;
  private int jdField_b_of_type_Int;
  
  QZonePluginDownloader(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext);
    DownloaderFactory.init(new anex(), new QZonePluginDownloaderLog());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.createDownloader("QZonePluginDownloader");
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setPortConfigStrategy(new anez());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDirectIPConfigStrategy(new aney());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setBackupIPConfigStrategy(new anew());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setKeepAliveStrategy(new QZonePluginDownloadConfigKeepAliveStrategy());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDownloadMode(Downloader.DownloadMode.StrictMode);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.enableResumeTransfer(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void a(anfd paramanfd)
  {
    PluginRecord localPluginRecord = anfd.a(paramanfd);
    Object localObject = anfd.a(paramanfd);
    anfd.a(paramanfd).jdField_a_of_type_Int = 1;
    ((QZonePluginDownloader.OnPluginDownloadListner)localObject).a(localPluginRecord);
    File localFile = QZonePluginUtils.e(this.jdField_a_of_type_AndroidContentContext, localPluginRecord.f);
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "downloadPluginInner url:" + localPluginRecord.jdField_a_of_type_JavaLangString + ",path:" + localFile);
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_Int = NetworkState.g().getNetworkType();
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
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
      } while (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(localPluginRecord.jdField_a_of_type_JavaLangString, localFile.getAbsolutePath(), new anfc(this, paramanfd)));
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = paramanfd;
      ((Message)localObject).sendToTarget();
    }
    jdField_a_of_type_JavaLangString = jdField_a_of_type_Long + "_" + (String)localObject;
    this.jdField_b_of_type_Int = 0;
    if (a(localFile.getParent()))
    {
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = paramanfd;
      ((Message)localObject).arg1 = -9998;
      ((Message)localObject).sendToTarget();
      return;
    }
  }
  
  private void a(anfd paramanfd, int paramInt, String paramString)
  {
    PluginRecord localPluginRecord = anfd.a(paramanfd);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.f, localPluginRecord.d, localPluginRecord.c, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", anfd.a(paramanfd), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString);
  }
  
  private void a(anfd paramanfd, int paramInt, String paramString1, String paramString2)
  {
    PluginRecord localPluginRecord = anfd.a(paramanfd);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.f, localPluginRecord.d, localPluginRecord.c, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", anfd.a(paramanfd), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString1, paramString2);
  }
  
  private boolean a(String paramString)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramString);
      long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
      if (l < QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginDownloadAvailableSpace", jdField_b_of_type_Long)) {}
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
  
  private void b(anfd paramanfd)
  {
    if ((paramanfd == null) || (anfd.a(paramanfd) == null))
    {
      QLog.w("QZonePluginManger", 1, "cancelDownLoadPlugin, downloadRecord or record is null, downloadRecord=" + paramanfd);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "cancelDownLoadPlugin url:" + anfd.a(paramanfd).jdField_a_of_type_JavaLangString);
    }
    PluginRecord localPluginRecord = anfd.a(paramanfd);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.abort(localPluginRecord.jdField_a_of_type_JavaLangString, new anfc(this, paramanfd));
  }
  
  public void a()
  {
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(PluginRecord paramPluginRecord, QZonePluginDownloader.OnPluginDownloadListner paramOnPluginDownloadListner)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    anfd localanfd = new anfd(null);
    anfd.a(localanfd, paramPluginRecord.f);
    anfd.a(localanfd, paramPluginRecord);
    anfd.a(localanfd, -1);
    anfd.a(localanfd, paramOnPluginDownloadListner);
    localMessage.obj = localanfd;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(PluginRecord paramPluginRecord, QZonePluginDownloader.OnPluginDownloadListner paramOnPluginDownloadListner, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    anfd localanfd = new anfd(null);
    anfd.a(localanfd, paramPluginRecord.f);
    paramPluginRecord.jdField_a_of_type_Int = 0;
    anfd.a(localanfd, paramPluginRecord);
    anfd.a(localanfd, paramOnPluginDownloadListner);
    anfd.a(localanfd, paramInt);
    localMessage.obj = localanfd;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (anfd)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(anfd.a(paramMessage))) {
        return false;
      }
      this.jdField_a_of_type_JavaUtilMap.put(anfd.a(paramMessage), paramMessage);
      a(paramMessage);
      return true;
      paramMessage = (anfd)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(anfd.a(paramMessage)))
      {
        a(paramMessage, 3, "");
        this.jdField_a_of_type_JavaUtilMap.remove(anfd.a(paramMessage));
        b(paramMessage);
        Object localObject = anfd.a(paramMessage);
        if (localObject != null)
        {
          ((QZonePluginDownloader.OnPluginDownloadListner)localObject).b(anfd.a(paramMessage));
          continue;
          paramMessage = (anfd)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(anfd.a(paramMessage)))
          {
            a(paramMessage, 1, "");
            this.jdField_a_of_type_JavaUtilMap.remove(anfd.a(paramMessage));
            localObject = anfd.a(paramMessage);
            if (localObject != null)
            {
              ((QZonePluginDownloader.OnPluginDownloadListner)localObject).b(anfd.a(paramMessage));
              continue;
              localObject = (anfd)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(anfd.a((anfd)localObject)))
              {
                a((anfd)localObject, 2, paramMessage.arg1 + "", paramMessage.arg2 + "");
                this.jdField_a_of_type_JavaUtilMap.remove(anfd.a((anfd)localObject));
                QZonePluginDownloader.OnPluginDownloadListner localOnPluginDownloadListner = anfd.a((anfd)localObject);
                if (localOnPluginDownloadListner != null)
                {
                  localOnPluginDownloadListner.a(anfd.a((anfd)localObject), paramMessage.arg1);
                  continue;
                  paramMessage = (anfd)paramMessage.obj;
                  if (this.jdField_a_of_type_JavaUtilMap.containsKey(anfd.a(paramMessage)))
                  {
                    a(paramMessage, 0, "");
                    this.jdField_a_of_type_JavaUtilMap.remove(anfd.a(paramMessage));
                    localObject = anfd.a(paramMessage);
                    if (localObject != null)
                    {
                      anfd.a(paramMessage).jdField_a_of_type_Int = 2;
                      ((QZonePluginDownloader.OnPluginDownloadListner)localObject).b(anfd.a(paramMessage), anfd.a(paramMessage));
                      continue;
                      paramMessage = (anfd)paramMessage.obj;
                      if (this.jdField_a_of_type_JavaUtilMap.containsKey(anfd.a(paramMessage)))
                      {
                        localObject = anfd.a(paramMessage);
                        if (localObject != null) {
                          ((QZonePluginDownloader.OnPluginDownloadListner)localObject).c(anfd.a(paramMessage));
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
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginDownloader
 * JD-Core Version:    0.7.0.1
 */