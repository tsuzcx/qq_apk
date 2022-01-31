package cooperation.qzone.plugin;

import amxi;
import amxj;
import amxk;
import amxl;
import amxo;
import amxp;
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
    DownloaderFactory.init(new amxj(), new QZonePluginDownloaderLog());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.createDownloader("QZonePluginDownloader");
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setPortConfigStrategy(new amxl());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDirectIPConfigStrategy(new amxk());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setBackupIPConfigStrategy(new amxi());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setKeepAliveStrategy(new QZonePluginDownloadConfigKeepAliveStrategy());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDownloadMode(Downloader.DownloadMode.StrictMode);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.enableResumeTransfer(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void a(amxp paramamxp)
  {
    PluginRecord localPluginRecord = amxp.a(paramamxp);
    Object localObject = amxp.a(paramamxp);
    amxp.a(paramamxp).jdField_a_of_type_Int = 1;
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
      } while (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(localPluginRecord.jdField_a_of_type_JavaLangString, localFile.getAbsolutePath(), new amxo(this, paramamxp)));
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = paramamxp;
      ((Message)localObject).sendToTarget();
    }
    jdField_a_of_type_JavaLangString = jdField_a_of_type_Long + "_" + (String)localObject;
    this.jdField_b_of_type_Int = 0;
    if (a(localFile.getParent()))
    {
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = paramamxp;
      ((Message)localObject).arg1 = -9998;
      ((Message)localObject).sendToTarget();
      return;
    }
  }
  
  private void a(amxp paramamxp, int paramInt, String paramString)
  {
    PluginRecord localPluginRecord = amxp.a(paramamxp);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.f, localPluginRecord.d, localPluginRecord.c, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", amxp.a(paramamxp), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString);
  }
  
  private void a(amxp paramamxp, int paramInt, String paramString1, String paramString2)
  {
    PluginRecord localPluginRecord = amxp.a(paramamxp);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.f, localPluginRecord.d, localPluginRecord.c, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", amxp.a(paramamxp), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString1, paramString2);
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
  
  private void b(amxp paramamxp)
  {
    if ((paramamxp == null) || (amxp.a(paramamxp) == null))
    {
      QLog.w("QZonePluginManger", 1, "cancelDownLoadPlugin, downloadRecord or record is null, downloadRecord=" + paramamxp);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "cancelDownLoadPlugin url:" + amxp.a(paramamxp).jdField_a_of_type_JavaLangString);
    }
    PluginRecord localPluginRecord = amxp.a(paramamxp);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.abort(localPluginRecord.jdField_a_of_type_JavaLangString, new amxo(this, paramamxp));
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
    amxp localamxp = new amxp(null);
    amxp.a(localamxp, paramPluginRecord.f);
    amxp.a(localamxp, paramPluginRecord);
    amxp.a(localamxp, -1);
    amxp.a(localamxp, paramOnPluginDownloadListner);
    localMessage.obj = localamxp;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(PluginRecord paramPluginRecord, QZonePluginDownloader.OnPluginDownloadListner paramOnPluginDownloadListner, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    amxp localamxp = new amxp(null);
    amxp.a(localamxp, paramPluginRecord.f);
    paramPluginRecord.jdField_a_of_type_Int = 0;
    amxp.a(localamxp, paramPluginRecord);
    amxp.a(localamxp, paramOnPluginDownloadListner);
    amxp.a(localamxp, paramInt);
    localMessage.obj = localamxp;
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
      paramMessage = (amxp)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(amxp.a(paramMessage))) {
        return false;
      }
      this.jdField_a_of_type_JavaUtilMap.put(amxp.a(paramMessage), paramMessage);
      a(paramMessage);
      return true;
      paramMessage = (amxp)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(amxp.a(paramMessage)))
      {
        a(paramMessage, 3, "");
        this.jdField_a_of_type_JavaUtilMap.remove(amxp.a(paramMessage));
        b(paramMessage);
        Object localObject = amxp.a(paramMessage);
        if (localObject != null)
        {
          ((QZonePluginDownloader.OnPluginDownloadListner)localObject).b(amxp.a(paramMessage));
          continue;
          paramMessage = (amxp)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(amxp.a(paramMessage)))
          {
            a(paramMessage, 1, "");
            this.jdField_a_of_type_JavaUtilMap.remove(amxp.a(paramMessage));
            localObject = amxp.a(paramMessage);
            if (localObject != null)
            {
              ((QZonePluginDownloader.OnPluginDownloadListner)localObject).b(amxp.a(paramMessage));
              continue;
              localObject = (amxp)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(amxp.a((amxp)localObject)))
              {
                a((amxp)localObject, 2, paramMessage.arg1 + "", paramMessage.arg2 + "");
                this.jdField_a_of_type_JavaUtilMap.remove(amxp.a((amxp)localObject));
                QZonePluginDownloader.OnPluginDownloadListner localOnPluginDownloadListner = amxp.a((amxp)localObject);
                if (localOnPluginDownloadListner != null)
                {
                  localOnPluginDownloadListner.a(amxp.a((amxp)localObject), paramMessage.arg1);
                  continue;
                  paramMessage = (amxp)paramMessage.obj;
                  if (this.jdField_a_of_type_JavaUtilMap.containsKey(amxp.a(paramMessage)))
                  {
                    a(paramMessage, 0, "");
                    this.jdField_a_of_type_JavaUtilMap.remove(amxp.a(paramMessage));
                    localObject = amxp.a(paramMessage);
                    if (localObject != null)
                    {
                      amxp.a(paramMessage).jdField_a_of_type_Int = 2;
                      ((QZonePluginDownloader.OnPluginDownloadListner)localObject).b(amxp.a(paramMessage), amxp.a(paramMessage));
                      continue;
                      paramMessage = (amxp)paramMessage.obj;
                      if (this.jdField_a_of_type_JavaUtilMap.containsKey(amxp.a(paramMessage)))
                      {
                        localObject = amxp.a(paramMessage);
                        if (localObject != null) {
                          ((QZonePluginDownloader.OnPluginDownloadListner)localObject).c(amxp.a(paramMessage));
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