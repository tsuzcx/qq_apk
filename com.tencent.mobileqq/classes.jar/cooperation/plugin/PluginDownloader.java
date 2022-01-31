package cooperation.plugin;

import amtr;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PluginDownloader
  implements Handler.Callback, INetEngine.IBreakDownFix, INetEngine.INetEngineListener, HttpEngineTask.IHttpEngineTask
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PreDownloadController jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private HashMap b;
  private HashMap c;
  
  public PluginDownloader(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new HashMap();
    this.c = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController = ((PreDownloadController)paramQQAppInterface.getManager(192));
  }
  
  private int a(String paramString)
  {
    if ("qqreaderplugin.apk".equals(paramString)) {
      return 10010;
    }
    if ("comic_plugin.apk".equals(paramString)) {
      return 10011;
    }
    if ("qqdataline.apk".equals(paramString)) {
      return 10013;
    }
    if ("qqsmartdevice.apk".equals(paramString)) {
      return 10014;
    }
    if ("qlink_plugin.apk".equals(paramString)) {
      return 10060;
    }
    if ("wlx_jtcode.apk".equals(paramString)) {
      return 10062;
    }
    return 10058;
  }
  
  public static final File a(Context paramContext)
  {
    paramContext = new File(new File(new File(paramContext.getFilesDir(), "pddata"), "prd"), "plugin_download");
    paramContext.mkdirs();
    return paramContext;
  }
  
  private void a(NetReq paramNetReq, int paramInt1, int paramInt2)
  {
    String str = (String)paramNetReq.a();
    if (paramInt2 > 0)
    {
      paramNetReq = (amtr)this.b.get(str);
      if (paramNetReq == null) {
        break label95;
      }
    }
    label95:
    for (paramNetReq = amtr.a(paramNetReq);; paramNetReq = null)
    {
      if (paramNetReq != null) {
        paramNetReq.a(paramInt1, paramInt2, str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "doOnProgress: " + paramInt1 / paramInt2 + ", " + str);
      }
      return;
    }
  }
  
  private void a(File paramFile, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doDeleteDiscardFiles: " + paramString);
    }
    if ((paramFile != null) && (paramFile.exists()))
    {
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramFile[i];
          String str = localObject.getPath();
          if ((str == null) || (!str.startsWith(paramString))) {}
          for (;;)
          {
            i += 1;
            break;
            if (!str.endsWith(".cfg")) {
              if (str.equals(paramString))
              {
                if (paramBoolean)
                {
                  localObject.delete();
                  if (QLog.isColorLevel()) {
                    QLog.d("plugin_tag", 2, "doDeleteDiscardFiles: " + str);
                  }
                }
              }
              else
              {
                localObject.delete();
                if (QLog.isColorLevel()) {
                  QLog.d("plugin_tag", 2, "doDeleteDiscardFiles: " + str);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void a(String paramString, HttpNetReq paramHttpNetReq, PluginDownloader.OnPluginDownLoadListener paramOnPluginDownLoadListener, AbsPreDownloadTask paramAbsPreDownloadTask)
  {
    if (paramOnPluginDownLoadListener != null) {
      paramOnPluginDownLoadListener.c(paramString);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Object localObject = (HttpEngineTask)this.c.remove(paramString);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.a(((HttpEngineTask)localObject).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_JavaLangString);
      }
      localObject = new amtr(null);
      amtr.a((amtr)localObject, paramHttpNetReq);
      amtr.a((amtr)localObject, paramOnPluginDownLoadListener);
      amtr.a((amtr)localObject, paramAbsPreDownloadTask);
      this.b.put(paramString, localObject);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private void a(String paramString, NetResp paramNetResp)
  {
    HashMap localHashMap = new HashMap();
    paramString = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      paramString = Long.valueOf(0L);
    }
    for (;;)
    {
      localHashMap.put("mResult", String.valueOf(paramNetResp.jdField_a_of_type_Int));
      localHashMap.put("param_FailCode", String.valueOf(paramNetResp.b));
      localHashMap.put("mErrDesc", paramNetResp.jdField_a_of_type_JavaLangString);
      Object localObject = paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
      if ((paramNetResp.jdField_a_of_type_Int != 0) && (localObject != null) && ((localObject instanceof HttpNetReq))) {
        localHashMap.put("Url", ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString);
      }
      localHashMap.put("mRespProperties[KeyReason]", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason"));
      localHashMap.put("mRespProperties[KeyRawRespHttpHeader]", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("param_reqHeader"));
      localObject = StatisticCollector.a(BaseApplication.getContext());
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (paramNetResp.jdField_a_of_type_Int == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((StatisticCollector)localObject).a(str, "NetPluginsDownload", bool, paramString.longValue(), 0L, localHashMap, null);
        return;
      }
    }
  }
  
  private void b(NetResp paramNetResp)
  {
    String str = (String)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    if (paramNetResp.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = (PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(192);
      amtr localamtr = (amtr)this.b.remove(str);
      if (localamtr != null)
      {
        if (amtr.a(localamtr) != null) {
          ((PreDownloadController)localObject).a(amtr.a(localamtr).jdField_a_of_type_JavaLangString, paramNetResp.jdField_a_of_type_Long);
        }
        localObject = amtr.a(localamtr);
        a(str, paramNetResp);
        a(a(this.jdField_a_of_type_AndroidContentContext), str, false);
        if (QLog.isColorLevel())
        {
          QLog.d("plugin_tag", 2, "doOnResp. result,pluginid,length: " + paramNetResp.jdField_a_of_type_Int + "," + str + ", " + paramNetResp.jdField_a_of_type_Long);
          if ((!bool) && (QLog.isColorLevel())) {
            QLog.e("plugin_tag", 2, "doOnResp. err: " + paramNetResp.b + ", " + paramNetResp.jdField_a_of_type_JavaLangString);
          }
        }
        if (localObject != null) {
          ((PluginDownloader.OnPluginDownLoadListener)localObject).a(bool, str);
        }
      }
      return;
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doCancelInstall: " + paramString);
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      HttpEngineTask localHttpEngineTask;
      try
      {
        localObject = (amtr)this.b.remove(paramString);
        localHttpEngineTask = (HttpEngineTask)this.c.remove(paramString);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if ((localObject != null) || (localHttpEngineTask != null))
        {
          if (localObject != null)
          {
            if (amtr.a((amtr)localObject) != null) {
              this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.a(amtr.a((amtr)localObject).jdField_a_of_type_JavaLangString);
            }
          }
          else
          {
            if (localObject != null) {
              this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.a(amtr.a((amtr)localObject).jdField_a_of_type_JavaLangString);
            }
            if (localObject == null) {
              break label185;
            }
            localObject = amtr.a((amtr)localObject);
            if (localObject != null) {
              ((PluginDownloader.OnPluginDownLoadListener)localObject).d(paramString);
            }
            c(paramString);
          }
        }
        else {
          return;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0).b(amtr.a((amtr)localObject));
      continue;
      label185:
      Object localObject = (PluginDownloader.OnPluginDownLoadListener)localHttpEngineTask.jdField_a_of_type_JavaLangObject;
    }
  }
  
  private void c(String paramString)
  {
    paramString = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      paramString = Long.valueOf(0L);
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", "0");
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "NetPluginsCancelDownload", false, paramString.longValue(), 0L, localHashMap, null);
      return;
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65793, (int)paramLong1, (int)paramLong2, paramNetReq).sendToTarget();
  }
  
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    while (!(paramNetReq instanceof HttpNetReq)) {
      return;
    }
    paramNetReq = (HttpNetReq)paramNetReq;
    paramNetReq.jdField_a_of_type_Long += paramNetResp.c;
    paramNetResp.c = 0L;
    paramNetResp = "bytes=" + paramNetReq.jdField_a_of_type_Long + "-";
    paramNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
  }
  
  public void a(NetResp paramNetResp)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65792, paramNetResp).sendToTarget();
  }
  
  public void a(HttpEngineTask paramHttpEngineTask)
  {
    this.c.remove(paramHttpEngineTask.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.a());
    a((String)paramHttpEngineTask.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.a(), paramHttpEngineTask.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq, (PluginDownloader.OnPluginDownLoadListener)paramHttpEngineTask.jdField_a_of_type_JavaLangObject, paramHttpEngineTask);
  }
  
  public void a(PluginInfo paramPluginInfo, PluginDownloader.OnPluginDownLoadListener paramOnPluginDownLoadListener, boolean paramBoolean)
  {
    QLog.d("plugin_tag", 1, "doDownloadPlugin." + paramPluginInfo.mID + ", isPreDownload " + paramBoolean);
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    Object localObject2;
    try
    {
      if (this.b.containsKey(paramPluginInfo.mID)) {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "downloading already");
        }
      }
      do
      {
        return;
        if (this.c.containsKey(paramPluginInfo.mID))
        {
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "pending downloading already exist");
          }
          if (paramBoolean) {
            break;
          }
          localObject1 = (HttpEngineTask)this.c.remove(paramPluginInfo.mID);
          if ((localObject1 != null) && (localObject1 != null)) {
            this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.a(((HttpEngineTask)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
        if ((float)(paramPluginInfo.mLength * 1.75D) <= FileUtils.a()) {
          break label235;
        }
      } while (paramOnPluginDownLoadListener == null);
      paramOnPluginDownLoadListener.b(paramPluginInfo.mID);
      return;
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    label235:
    Object localObject1 = new HttpNetReq();
    ((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    ((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = this;
    ((HttpNetReq)localObject1).jdField_a_of_type_JavaLangString = paramPluginInfo.mURL;
    ((HttpNetReq)localObject1).jdField_a_of_type_Int = 0;
    ((HttpNetReq)localObject1).jdField_a_of_type_Boolean = true;
    ((HttpNetReq)localObject1).m = true;
    ((HttpNetReq)localObject1).n = true;
    ((HttpNetReq)localObject1).a(paramPluginInfo.mID);
    String str = new File(a(this.jdField_a_of_type_AndroidContentContext), paramPluginInfo.mID).getPath();
    ((HttpNetReq)localObject1).c = str;
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.a())) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    for (;;)
    {
      try
      {
        localObject2 = new HttpEngineTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPluginInfo.mID, this, (HttpNetReq)localObject1);
        ((HttpEngineTask)localObject2).jdField_a_of_type_JavaLangObject = paramOnPluginDownLoadListener;
        this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.a(a(paramPluginInfo.mID), null, paramPluginInfo.mID + paramPluginInfo.mMD5, 0, paramPluginInfo.mURL, str, 1, 2, false, (AbsPreDownloadTask)localObject2);
        this.c.put(paramPluginInfo.mID, localObject2);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("plugin_tag", 2, "downloadPlugin: " + ((HttpNetReq)localObject1).jdField_a_of_type_JavaLangString);
        return;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      a(paramPluginInfo.mID, (HttpNetReq)localObject1, paramOnPluginDownLoadListener, null);
      ((INetEngine)localObject2).a((NetReq)localObject1);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65794, paramString).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b((NetResp)paramMessage.obj);
      continue;
      a((NetReq)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
      continue;
      b((String)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.plugin.PluginDownloader
 * JD-Core Version:    0.7.0.1
 */