package cooperation.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.RandomUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class PluginDownloader
  implements Handler.Callback, INetEngineListener, HttpEngineTask.IHttpEngineTask
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PreDownloadController jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController;
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private HashMap<String, PluginDownloader.DownloadRecord> b;
  private HashMap<String, HttpEngineTask> c;
  
  public PluginDownloader(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new HashMap();
    this.c = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController = ((PreDownloadController)paramQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2));
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
    String str = (String)paramNetReq.getUserData();
    if (paramInt2 > 0)
    {
      paramNetReq = (PluginDownloader.DownloadRecord)this.b.get(str);
      if (paramNetReq == null) {
        break label95;
      }
    }
    label95:
    for (paramNetReq = PluginDownloader.DownloadRecord.a(paramNetReq);; paramNetReq = null)
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
  
  private void a(NetResp paramNetResp)
  {
    String str = (String)paramNetResp.mReq.getUserData();
    d(str);
    boolean bool;
    Object localObject2;
    if (paramNetResp.mResult == 0)
    {
      bool = true;
      localObject2 = (PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
      localObject1 = (PluginDownloader.DownloadRecord)this.b.remove(str);
      if (localObject1 != null)
      {
        if (PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject1) != null) {
          ((PreDownloadController)localObject2).preDownloadSuccess(PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject1).mReqUrl, paramNetResp.mTotalFileLen);
        }
        localObject2 = PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject1);
        a(str, paramNetResp);
        if (PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject1)) {
          if (!bool) {
            break label257;
          }
        }
      }
    }
    label257:
    for (Object localObject1 = "success";; localObject1 = "failed")
    {
      a(str, (String)localObject1);
      a(a(this.jdField_a_of_type_AndroidContentContext), str, false);
      if (QLog.isColorLevel())
      {
        QLog.d("plugin_tag", 2, "doOnResp. result,pluginid,length: " + paramNetResp.mResult + "," + str + ", " + paramNetResp.mTotalFileLen);
        if ((!bool) && (QLog.isColorLevel())) {
          QLog.e("plugin_tag", 2, "doOnResp. err: " + paramNetResp.mErrCode + ", " + paramNetResp.mErrDesc);
        }
      }
      if (localObject2 != null) {
        ((PluginDownloader.OnPluginDownLoadListener)localObject2).a(bool, str);
      }
      return;
      bool = false;
      break;
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
  
  private void a(String paramString, HttpNetReq paramHttpNetReq, PluginDownloader.OnPluginDownLoadListener paramOnPluginDownLoadListener, AbsPreDownloadTask paramAbsPreDownloadTask, boolean paramBoolean)
  {
    if (paramOnPluginDownLoadListener != null) {
      paramOnPluginDownLoadListener.b(paramString);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Object localObject = (HttpEngineTask)this.c.remove(paramString);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.cancelPreDownload(((HttpEngineTask)localObject).httpReq.mReqUrl);
      }
      localObject = new PluginDownloader.DownloadRecord(null);
      PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject, paramHttpNetReq);
      PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject, paramOnPluginDownLoadListener);
      PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject, paramAbsPreDownloadTask);
      PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject, paramBoolean);
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
      localHashMap.put("mResult", String.valueOf(paramNetResp.mResult));
      localHashMap.put("param_FailCode", String.valueOf(paramNetResp.mErrCode));
      localHashMap.put("mErrDesc", paramNetResp.mErrDesc);
      Object localObject = paramNetResp.mReq;
      if ((paramNetResp.mResult != 0) && (localObject != null) && ((localObject instanceof HttpNetReq))) {
        localHashMap.put("Url", ((HttpNetReq)localObject).mReqUrl);
      }
      localHashMap.put("mRespProperties[KeyReason]", paramNetResp.mRespProperties.get("netresp_param_reason"));
      localHashMap.put("mRespProperties[KeyRawRespHttpHeader]", paramNetResp.mRespProperties.get("param_reqHeader"));
      localObject = StatisticCollector.getInstance(BaseApplication.getContext());
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (paramNetResp.mResult == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((StatisticCollector)localObject).collectPerformance(str, "NetPluginsDownload", bool, paramString.longValue(), 0L, localHashMap, null);
        return;
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (Float.compare(RandomUtils.a(0.0F, 1.0F), 0.01F) > 0)
    {
      QLog.e("plugin_tag", 1, "Do not need to report this plugin launch event!");
      return;
    }
    HashMap localHashMap = new HashMap(3);
    localHashMap.put("plugin_id", paramString1);
    paramString1 = "";
    try
    {
      String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      paramString1 = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("plugin_tag", 1, "getAccount faild ！！！");
      }
    }
    localHashMap.put("qq_num", paramString1);
    localHashMap.put("result", paramString2);
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramString1, "qqPluginPreDownloadReporter", true, 0L, 0L, localHashMap, null);
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    long l1 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("pluginPreDownloadStartTime", 0).getLong(paramString, 0L);
    long l2 = System.currentTimeMillis();
    if ((l1 == 0L) || (l2 - l1 >= 28800000L)) {
      bool = true;
    }
    return bool;
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doCancelInstall: " + paramString);
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      PluginDownloader.DownloadRecord localDownloadRecord;
      HttpEngineTask localHttpEngineTask;
      try
      {
        localDownloadRecord = (PluginDownloader.DownloadRecord)this.b.remove(paramString);
        localHttpEngineTask = (HttpEngineTask)this.c.remove(paramString);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if ((localDownloadRecord != null) || (localHttpEngineTask != null))
        {
          if (localDownloadRecord != null)
          {
            if (PluginDownloader.DownloadRecord.a(localDownloadRecord) == null) {
              break label191;
            }
            this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.cancelPreDownload(PluginDownloader.DownloadRecord.a(localDownloadRecord).mReqUrl);
          }
          if (localDownloadRecord != null) {
            this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.cancelPreDownload(PluginDownloader.DownloadRecord.a(localDownloadRecord).mReqUrl);
          }
          if (localDownloadRecord == null) {
            break label219;
          }
          localOnPluginDownLoadListener = PluginDownloader.DownloadRecord.a(localDownloadRecord);
          if (localOnPluginDownLoadListener != null) {
            localOnPluginDownLoadListener.c(paramString);
          }
          c(paramString);
          if (((localDownloadRecord != null) && (PluginDownloader.DownloadRecord.a(localDownloadRecord))) || (localHttpEngineTask != null)) {
            a(paramString, "cancel");
          }
        }
        return;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      label191:
      ((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).cancelReq(PluginDownloader.DownloadRecord.a(localDownloadRecord));
      continue;
      label219:
      PluginDownloader.OnPluginDownLoadListener localOnPluginDownLoadListener = (PluginDownloader.OnPluginDownLoadListener)localHttpEngineTask.userData;
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
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "NetPluginsCancelDownload", false, paramString.longValue(), 0L, localHashMap, null);
      return;
    }
  }
  
  private void d(String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("pluginPreDownloadStartTime", 0).edit().putLong(paramString, System.currentTimeMillis()).apply();
  }
  
  public void a(PluginInfo paramPluginInfo, PluginDownloader.OnPluginDownLoadListener paramOnPluginDownLoadListener, boolean paramBoolean)
  {
    QLog.d("plugin_tag", 1, "doDownloadPlugin." + paramPluginInfo.mID + ", isPreDownload " + paramBoolean);
    if ((paramBoolean) && (!a(paramPluginInfo.mID))) {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "exceed pre download frequency, ignore this call!");
      }
    }
    Object localObject1;
    Object localObject2;
    label407:
    String str;
    for (;;)
    {
      return;
      try
      {
        IHttpEngineService localIHttpEngineService = (IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all");
        if (localIHttpEngineService == null)
        {
          QLog.d("plugin_tag", 1, "doDownloadPlugin nohttpabort" + paramPluginInfo.mID);
          if (paramOnPluginDownLoadListener == null) {
            continue;
          }
          paramOnPluginDownLoadListener.c(paramPluginInfo.mID);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("plugin_tag", 1, "download plugin get IHttpEngineService error", localException);
          localObject1 = null;
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
        try
        {
          if (this.b.containsKey(paramPluginInfo.mID))
          {
            localObject1 = (PluginDownloader.DownloadRecord)this.b.get(paramPluginInfo.mID);
            if ((!paramBoolean) && (localObject1 != null) && (PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject1)))
            {
              PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject1, false);
              a(paramPluginInfo.mID, "cancel");
              PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject1, paramOnPluginDownLoadListener);
              if (paramOnPluginDownLoadListener != null) {
                paramOnPluginDownLoadListener.b(paramPluginInfo.mID);
              }
              if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, "has pre download task running, replace current record listener!");
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("plugin_tag", 2, "downloading already");
            }
            return;
          }
          if (this.c.containsKey(paramPluginInfo.mID))
          {
            if (QLog.isColorLevel()) {
              QLog.d("plugin_tag", 2, "pending downloading already exist");
            }
            if (paramBoolean) {
              break label407;
            }
            localObject2 = (HttpEngineTask)this.c.remove(paramPluginInfo.mID);
            if ((localObject2 != null) && (localObject2 != null)) {
              this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.cancelPreDownload(((HttpEngineTask)localObject2).httpReq.mReqUrl);
            }
          }
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          if ((float)(paramPluginInfo.mLength * 1.75D) > FileUtils.a())
          {
            if (paramOnPluginDownLoadListener == null) {
              continue;
            }
            paramOnPluginDownLoadListener.a(paramPluginInfo.mID);
            return;
            return;
          }
        }
        finally
        {
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        }
        localObject2 = new HttpNetReq();
        ((HttpNetReq)localObject2).mCallback = this;
        ((HttpNetReq)localObject2).mSupportBreakResume = true;
        ((HttpNetReq)localObject2).mReqUrl = paramPluginInfo.mURL;
        ((HttpNetReq)localObject2).mHttpMethod = 0;
        ((HttpNetReq)localObject2).mNeedIpConnect = true;
        ((HttpNetReq)localObject2).bAcceptNegativeContentLength = true;
        ((HttpNetReq)localObject2).setUserData(paramPluginInfo.mID);
        str = new File(a(this.jdField_a_of_type_AndroidContentContext), paramPluginInfo.mID).getPath();
        ((HttpNetReq)localObject2).mOutPath = str;
        if (!paramBoolean) {
          break label690;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.isEnable()) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    for (;;)
    {
      try
      {
        localObject1 = new HttpEngineTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPluginInfo.mID, this, (HttpNetReq)localObject2);
        ((HttpEngineTask)localObject1).userData = paramOnPluginDownLoadListener;
        this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.requestPreDownload(a(paramPluginInfo.mID), null, paramPluginInfo.mID + paramPluginInfo.mMD5, 0, paramPluginInfo.mURL, str, 1, 0, false, (AbsPreDownloadTask)localObject1);
        this.c.put(paramPluginInfo.mID, localObject1);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("plugin_tag", 2, "downloadPlugin: " + ((HttpNetReq)localObject2).mReqUrl);
        return;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      label690:
      a(paramPluginInfo.mID, (HttpNetReq)localObject2, paramOnPluginDownLoadListener, null, false);
      ((IHttpEngineService)localObject1).sendReq((NetReq)localObject2);
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
      a((NetResp)paramMessage.obj);
      continue;
      a((NetReq)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
      continue;
      b((String)paramMessage.obj);
    }
  }
  
  public void onPreDownloadStart(HttpEngineTask paramHttpEngineTask)
  {
    this.c.remove(paramHttpEngineTask.httpReq.getUserData());
    a((String)paramHttpEngineTask.httpReq.getUserData(), paramHttpEngineTask.httpReq, (PluginDownloader.OnPluginDownLoadListener)paramHttpEngineTask.userData, paramHttpEngineTask, true);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65792, paramNetResp).sendToTarget();
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65793, (int)paramLong1, (int)paramLong2, paramNetReq).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.PluginDownloader
 * JD-Core Version:    0.7.0.1
 */