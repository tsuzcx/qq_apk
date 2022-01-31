package cooperation.qzone.networkedmodule;

import amgh;
import amgi;
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
  private static String jdField_a_of_type_JavaLangString = "QzoneModuleDownloadManager";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Downloader.DownloadListener jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = new amgh(this);
  private QzonePreDownloadManager jdField_a_of_type_CooperationQzoneQzonePreDownloadManager;
  private Map jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  QzoneModuleDownloadManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager = QzonePreDownloadManager.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(QzoneHandlerThreadFactory.getHandlerThreadLooper("Normal_HandlerThread"), this);
  }
  
  private void a(amgi paramamgi)
  {
    String str1 = paramamgi.jdField_a_of_type_CooperationQzoneNetworkedmoduleQzoneModuleConfigManager$QzoneModuleRecord.d;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(str1)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(str1, paramamgi);
    Object localObject = paramamgi.jdField_a_of_type_CooperationQzoneNetworkedmoduleQzoneModuleConfigManager$QzoneModuleRecord;
    String str2 = QzoneModuleConst.getModuleSavePath(this.jdField_a_of_type_AndroidContentContext, (QzoneModuleConfigManager.QzoneModuleRecord)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "----------savePath--" + str2);
    }
    File localFile = new File(str2);
    if (localFile.exists())
    {
      String str3 = ((QzoneModuleConfigManager.QzoneModuleRecord)localObject).e;
      if ((TextUtils.isEmpty(str3)) || ((((QzoneModuleConfigManager.QzoneModuleRecord)localObject).jdField_a_of_type_Long != 0L) && (((QzoneModuleConfigManager.QzoneModuleRecord)localObject).jdField_a_of_type_Long == localFile.length())))
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "download succeed: from cache.");
        QzoneModuleConfigManager.a().a((QzoneModuleConfigManager.QzoneModuleRecord)localObject);
        if (paramamgi.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null)
        {
          paramamgi.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadSucceed(paramamgi.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilMap.remove(str1);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "before download-- orgMD5: " + str3 + " , downloadFilePath: " + localFile.getPath());
        }
        localObject = new File(str2);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "check download cache failed: md5 verify is not passed.");
      }
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "start download--" + paramamgi.jdField_a_of_type_JavaLangString + ",priority: " + paramamgi.jdField_a_of_type_Boolean + " ,startImmediately: " + paramamgi.b);
    paramamgi.jdField_a_of_type_Long = System.nanoTime();
    this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager.a(str1, str2, paramamgi.jdField_a_of_type_Boolean, paramamgi.b, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
  }
  
  private void c(String paramString)
  {
    amgi localamgi = (amgi)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    String str2;
    QzoneModuleConfigManager.QzoneModuleRecord localQzoneModuleRecord;
    String str3;
    long l;
    if (localamgi != null)
    {
      str2 = QzoneModuleConst.getModuleSavePath(this.jdField_a_of_type_AndroidContentContext, localamgi.jdField_a_of_type_CooperationQzoneNetworkedmoduleQzoneModuleConfigManager$QzoneModuleRecord);
      localQzoneModuleRecord = localamgi.jdField_a_of_type_CooperationQzoneNetworkedmoduleQzoneModuleConfigManager$QzoneModuleRecord;
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "download complete: " + str2);
      }
      str3 = localQzoneModuleRecord.e;
      String str1 = "";
      if (!TextUtils.isEmpty(str3)) {
        str1 = MD5Utils.a(str2);
      }
      l = (System.nanoTime() - localamgi.jdField_a_of_type_Long) / 1000000L;
      if ((!TextUtils.isEmpty(str3)) && (!str3.equalsIgnoreCase(str1))) {
        break label253;
      }
      QzoneModuleConfigManager.a().a(localQzoneModuleRecord);
    }
    for (;;)
    {
      try
      {
        if (QzoneModuleConst.QZONE_MODULES_NEED_INSTALL.contains(localQzoneModuleRecord.jdField_a_of_type_JavaLangString)) {
          new DexClassLoader(str2, this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getDir("dex", 0).getAbsolutePath(), str2, this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getClassLoader());
        }
        if (localamgi.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localamgi.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadSucceed(localamgi.jdField_a_of_type_JavaLangString);
        }
        QzoneModuleReport.a(localQzoneModuleRecord, true, l);
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "after download,new DexClassLoader error: ", localThrowable);
        continue;
      }
      label253:
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "download complete-- orgMD5: " + str3 + " , downloadMD5: " + localThrowable);
      }
      File localFile = new File(str2);
      if (localFile.exists()) {
        localFile.delete();
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "download failed: md5 verify is not passed.");
      if (localamgi.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
        localamgi.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadFailed(localamgi.jdField_a_of_type_JavaLangString);
      }
      QzoneModuleReport.a(localQzoneModuleRecord, false, l);
    }
  }
  
  public void a(String paramString)
  {
    paramString = QzoneModuleConfigManager.a().a(paramString);
    if ((paramString == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString.d))) {}
    do
    {
      return;
      paramString = (amgi)this.jdField_a_of_type_JavaUtilMap.get(paramString.d);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    localMessage.what = 4;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean a(QzoneModuleConfigManager.QzoneModuleRecord paramQzoneModuleRecord, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(paramQzoneModuleRecord, false, paramModuleDownloadListener);
  }
  
  public boolean a(QzoneModuleConfigManager.QzoneModuleRecord paramQzoneModuleRecord, boolean paramBoolean, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(paramQzoneModuleRecord, paramBoolean, false, paramModuleDownloadListener);
  }
  
  public boolean a(QzoneModuleConfigManager.QzoneModuleRecord paramQzoneModuleRecord, boolean paramBoolean1, boolean paramBoolean2, ModuleDownloadListener paramModuleDownloadListener)
  {
    if (paramQzoneModuleRecord == null) {
      return false;
    }
    amgi localamgi = new amgi(null);
    localamgi.jdField_a_of_type_JavaLangString = paramQzoneModuleRecord.jdField_a_of_type_JavaLangString;
    localamgi.jdField_a_of_type_CooperationQzoneNetworkedmoduleQzoneModuleConfigManager$QzoneModuleRecord = paramQzoneModuleRecord;
    localamgi.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener = paramModuleDownloadListener;
    localamgi.jdField_a_of_type_Boolean = paramBoolean1;
    localamgi.b = paramBoolean2;
    paramQzoneModuleRecord = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    paramQzoneModuleRecord.what = 1;
    paramQzoneModuleRecord.obj = localamgi;
    paramQzoneModuleRecord.sendToTarget();
    return true;
  }
  
  public void b(String paramString)
  {
    paramString = QzoneModuleConfigManager.a().a(paramString);
    if ((paramString == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString.d))) {}
    do
    {
      return;
      paramString = (amgi)this.jdField_a_of_type_JavaUtilMap.get(paramString.d);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    localMessage.what = 7;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    amgi localamgi;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      a((amgi)paramMessage.obj);
      return true;
    case 2: 
      c((String)paramMessage.obj);
      return true;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      localamgi = (amgi)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
      if (localamgi != null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "download failed: " + localamgi.jdField_a_of_type_JavaLangString);
        if (localamgi.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localamgi.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadFailed(localamgi.jdField_a_of_type_JavaLangString);
        }
        long l = (System.nanoTime() - localamgi.jdField_a_of_type_Long) / 1000000L;
        QzoneModuleReport.a(localamgi.jdField_a_of_type_CooperationQzoneNetworkedmoduleQzoneModuleConfigManager$QzoneModuleRecord, false, l);
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
      return true;
    case 4: 
      paramMessage = (amgi)paramMessage.obj;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancel download: " + paramMessage.jdField_a_of_type_JavaLangString);
      paramMessage = paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleQzoneModuleConfigManager$QzoneModuleRecord.d;
      this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager.a(paramMessage, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
      return true;
    case 5: 
      paramMessage = (String)paramMessage.obj;
      localamgi = (amgi)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
      if (localamgi != null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "download canceled: " + localamgi.jdField_a_of_type_JavaLangString);
        if (localamgi.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localamgi.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadCanceled(localamgi.jdField_a_of_type_JavaLangString);
        }
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
      return true;
    case 6: 
      paramMessage = (amgi)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null))
      {
        float f = ((Float)paramMessage.jdField_a_of_type_JavaLangObject).floatValue();
        paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadProgress(paramMessage.jdField_a_of_type_JavaLangString, f);
      }
      return true;
    }
    paramMessage = (amgi)paramMessage.obj;
    QLog.w(jdField_a_of_type_JavaLangString, 1, "abort download: " + paramMessage.jdField_a_of_type_JavaLangString);
    paramMessage = paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleQzoneModuleConfigManager$QzoneModuleRecord.d;
    this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager.b(paramMessage, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleDownloadManager
 * JD-Core Version:    0.7.0.1
 */