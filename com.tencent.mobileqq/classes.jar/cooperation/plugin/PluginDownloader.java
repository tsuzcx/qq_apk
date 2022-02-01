package cooperation.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
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
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
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
  private Context a;
  private Handler b;
  private QQAppInterface c;
  private HashMap<String, Long> d = new HashMap();
  private HashMap<String, PluginDownloader.DownloadRecord> e;
  private HashMap<String, HttpEngineTask> f;
  private final Lock g = new ReentrantLock();
  private IPreDownloadController h;
  
  public PluginDownloader(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.a = paramContext;
    this.c = paramQQAppInterface;
    this.b = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.e = new HashMap();
    this.f = new HashMap();
    try
    {
      this.h = ((IPreDownloadController)paramQQAppInterface.getRuntimeService(IPreDownloadController.class));
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
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
      paramNetReq = (PluginDownloader.DownloadRecord)this.e.get(str);
      if (paramNetReq != null) {
        paramNetReq = PluginDownloader.DownloadRecord.d(paramNetReq);
      } else {
        paramNetReq = null;
      }
      if (paramNetReq != null) {
        paramNetReq.a(paramInt1, paramInt2, str);
      }
      if (QLog.isColorLevel())
      {
        paramNetReq = new StringBuilder();
        paramNetReq.append("doOnProgress: ");
        paramNetReq.append(paramInt1 / paramInt2);
        paramNetReq.append(", ");
        paramNetReq.append(str);
        QLog.d("plugin_tag", 2, paramNetReq.toString());
      }
    }
  }
  
  private void a(NetResp paramNetResp)
  {
    String str = (String)paramNetResp.mReq.getUserData();
    f(str);
    boolean bool;
    if (paramNetResp.mResult == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = null;
    try
    {
      IPreDownloadController localIPreDownloadController = (IPreDownloadController)this.c.getRuntimeService(IPreDownloadController.class);
      localObject = localIPreDownloadController;
    }
    catch (Exception localException)
    {
      QLog.e("plugin_tag", 1, "get IPreDownloadController error!", localException);
    }
    PluginDownloader.DownloadRecord localDownloadRecord = (PluginDownloader.DownloadRecord)this.e.remove(str);
    if (localDownloadRecord != null)
    {
      if ((PluginDownloader.DownloadRecord.c(localDownloadRecord) != null) && (localObject != null)) {
        ((IPreDownloadController)localObject).preDownloadSuccess(PluginDownloader.DownloadRecord.c(localDownloadRecord).mReqUrl, paramNetResp.mTotalFileLen);
      }
      PluginDownloader.OnPluginDownLoadListener localOnPluginDownLoadListener = PluginDownloader.DownloadRecord.d(localDownloadRecord);
      a(str, paramNetResp);
      if (PluginDownloader.DownloadRecord.a(localDownloadRecord))
      {
        if (bool) {
          localObject = "success";
        } else {
          localObject = "failed";
        }
        a(str, (String)localObject);
      }
      a(a(this.a), str, false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doOnResp. result,pluginid,length: ");
        ((StringBuilder)localObject).append(paramNetResp.mResult);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramNetResp.mTotalFileLen);
        QLog.d("plugin_tag", 2, ((StringBuilder)localObject).toString());
        if ((!bool) && (QLog.isColorLevel()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("doOnResp. err: ");
          ((StringBuilder)localObject).append(paramNetResp.mErrCode);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(paramNetResp.mErrDesc);
          QLog.e("plugin_tag", 2, ((StringBuilder)localObject).toString());
        }
      }
      if (localOnPluginDownLoadListener != null) {
        localOnPluginDownLoadListener.a(bool, str);
      }
    }
  }
  
  private void a(File paramFile, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doDeleteDiscardFiles: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("plugin_tag", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramFile != null) && (paramFile.exists()))
    {
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          StringBuilder localStringBuilder = paramFile[i];
          localObject = localStringBuilder.getPath();
          if ((localObject != null) && (((String)localObject).startsWith(paramString)) && (!((String)localObject).endsWith(".cfg"))) {
            if (((String)localObject).equals(paramString))
            {
              if (paramBoolean)
              {
                localStringBuilder.delete();
                if (QLog.isColorLevel())
                {
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("doDeleteDiscardFiles: ");
                  localStringBuilder.append((String)localObject);
                  QLog.d("plugin_tag", 2, localStringBuilder.toString());
                }
              }
            }
            else
            {
              localStringBuilder.delete();
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("doDeleteDiscardFiles: ");
                localStringBuilder.append((String)localObject);
                QLog.d("plugin_tag", 2, localStringBuilder.toString());
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(String paramString, HttpNetReq paramHttpNetReq, PluginDownloader.OnPluginDownLoadListener paramOnPluginDownLoadListener, AbsPreDownloadTask paramAbsPreDownloadTask, boolean paramBoolean)
  {
    if (paramOnPluginDownLoadListener != null) {
      paramOnPluginDownLoadListener.b(paramString);
    }
    this.d.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
    this.g.lock();
    try
    {
      Object localObject = (HttpEngineTask)this.f.remove(paramString);
      if ((localObject != null) && (this.h != null)) {
        this.h.cancelPreDownload(((HttpEngineTask)localObject).httpReq.mReqUrl);
      }
      localObject = new PluginDownloader.DownloadRecord(null);
      PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject, paramHttpNetReq);
      PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject, paramOnPluginDownLoadListener);
      PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject, paramAbsPreDownloadTask);
      PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject, paramBoolean);
      this.e.put(paramString, localObject);
      return;
    }
    finally
    {
      this.g.unlock();
    }
  }
  
  private void a(String paramString, NetResp paramNetResp)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = (Long)this.d.get(paramString);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = Long.valueOf(0L);
    }
    localHashMap.put("mResult", String.valueOf(paramNetResp.mResult));
    localHashMap.put("param_FailCode", String.valueOf(paramNetResp.mErrCode));
    localHashMap.put("mErrDesc", paramNetResp.mErrDesc);
    localObject = paramNetResp.mReq;
    if ((paramNetResp.mResult != 0) && (localObject != null) && ((localObject instanceof HttpNetReq))) {
      localHashMap.put("Url", ((HttpNetReq)localObject).mReqUrl);
    }
    localHashMap.put("mRespProperties[KeyReason]", paramNetResp.mRespProperties.get("netresp_param_reason"));
    localHashMap.put("mRespProperties[KeyRawRespHttpHeader]", paramNetResp.mRespProperties.get("param_reqHeader"));
    localObject = StatisticCollector.getInstance(BaseApplication.getContext());
    String str = this.c.getCurrentAccountUin();
    boolean bool;
    if (paramNetResp.mResult == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((StatisticCollector)localObject).collectPerformance(str, "NetPluginsDownload", bool, paramString.longValue(), 0L, localHashMap, null);
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
    try
    {
      paramString1 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    }
    catch (Throwable paramString1)
    {
      label56:
      break label56;
    }
    QLog.e("plugin_tag", 1, "getAccount faild ！！！");
    paramString1 = "";
    localHashMap.put("qq_num", paramString1);
    localHashMap.put("result", paramString2);
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramString1, "qqPluginPreDownloadReporter", true, 0L, 0L, localHashMap, null);
  }
  
  private int b(String paramString)
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
  
  private void c(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doCancelInstall: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("plugin_tag", 2, ((StringBuilder)localObject).toString());
    }
    this.g.lock();
    try
    {
      PluginDownloader.DownloadRecord localDownloadRecord = (PluginDownloader.DownloadRecord)this.e.remove(paramString);
      HttpEngineTask localHttpEngineTask = (HttpEngineTask)this.f.remove(paramString);
      this.g.unlock();
      if ((localDownloadRecord != null) || (localHttpEngineTask != null))
      {
        if (localDownloadRecord != null) {
          if (PluginDownloader.DownloadRecord.b(localDownloadRecord) != null)
          {
            localObject = this.h;
            if (localObject != null) {
              ((IPreDownloadController)localObject).cancelPreDownload(PluginDownloader.DownloadRecord.c(localDownloadRecord).mReqUrl);
            }
          }
          else
          {
            ((IHttpEngineService)this.c.getRuntimeService(IHttpEngineService.class, "all")).cancelReq(PluginDownloader.DownloadRecord.c(localDownloadRecord));
          }
        }
        if (localDownloadRecord != null)
        {
          localObject = this.h;
          if (localObject != null) {
            ((IPreDownloadController)localObject).cancelPreDownload(PluginDownloader.DownloadRecord.c(localDownloadRecord).mReqUrl);
          }
        }
        if (localDownloadRecord != null) {
          localObject = PluginDownloader.DownloadRecord.d(localDownloadRecord);
        } else {
          localObject = (PluginDownloader.OnPluginDownLoadListener)localHttpEngineTask.userData;
        }
        if (localObject != null) {
          ((PluginDownloader.OnPluginDownLoadListener)localObject).c(paramString);
        }
        d(paramString);
        if (((localDownloadRecord != null) && (PluginDownloader.DownloadRecord.a(localDownloadRecord))) || (localHttpEngineTask != null)) {
          a(paramString, "cancel");
        }
      }
      return;
    }
    finally
    {
      this.g.unlock();
    }
  }
  
  private void d(String paramString)
  {
    Object localObject = (Long)this.d.get(paramString);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = Long.valueOf(0L);
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", "0");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.c.getCurrentAccountUin(), "NetPluginsCancelDownload", false, paramString.longValue(), 0L, (HashMap)localObject, null);
  }
  
  private boolean e(String paramString)
  {
    Context localContext = this.a;
    boolean bool = false;
    long l1 = localContext.getSharedPreferences("pluginPreDownloadStartTime", 0).getLong(paramString, 0L);
    long l2 = System.currentTimeMillis();
    if ((l1 == 0L) || (l2 - l1 >= 28800000L)) {
      bool = true;
    }
    return bool;
  }
  
  private void f(String paramString)
  {
    this.a.getSharedPreferences("pluginPreDownloadStartTime", 0).edit().putLong(paramString, System.currentTimeMillis()).apply();
  }
  
  public void a(PluginInfo paramPluginInfo, PluginDownloader.OnPluginDownLoadListener paramOnPluginDownLoadListener, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("doDownloadPlugin.");
    ((StringBuilder)localObject1).append(paramPluginInfo.mID);
    ((StringBuilder)localObject1).append(", isPreDownload ");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.d("plugin_tag", 1, ((StringBuilder)localObject1).toString());
    if ((paramBoolean) && (!e(paramPluginInfo.mID)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "exceed pre download frequency, ignore this call!");
      }
      return;
    }
    Object localObject2;
    try
    {
      localObject1 = (IHttpEngineService)this.c.getRuntimeService(IHttpEngineService.class, "all");
    }
    catch (Exception localException)
    {
      QLog.e("plugin_tag", 1, "download plugin get IHttpEngineService error", localException);
      localObject2 = null;
    }
    if (localObject2 == null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doDownloadPlugin nohttpabort");
      ((StringBuilder)localObject2).append(paramPluginInfo.mID);
      QLog.d("plugin_tag", 1, ((StringBuilder)localObject2).toString());
      if (paramOnPluginDownLoadListener != null) {
        paramOnPluginDownLoadListener.c(paramPluginInfo.mID);
      }
      return;
    }
    this.g.lock();
    try
    {
      if (this.e.containsKey(paramPluginInfo.mID))
      {
        localObject2 = (PluginDownloader.DownloadRecord)this.e.get(paramPluginInfo.mID);
        if ((!paramBoolean) && (localObject2 != null) && (PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject2)))
        {
          PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject2, false);
          a(paramPluginInfo.mID, "cancel");
          PluginDownloader.DownloadRecord.a((PluginDownloader.DownloadRecord)localObject2, paramOnPluginDownLoadListener);
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
      }
      do
      {
        this.g.unlock();
        return;
        if (!this.f.containsKey(paramPluginInfo.mID)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "pending downloading already exist");
        }
      } while (paramBoolean);
      Object localObject3 = (HttpEngineTask)this.f.remove(paramPluginInfo.mID);
      if ((localObject3 != null) && (localObject3 != null) && (this.h != null)) {
        this.h.cancelPreDownload(((HttpEngineTask)localObject3).httpReq.mReqUrl);
      }
      this.g.unlock();
      double d1 = paramPluginInfo.mLength;
      Double.isNaN(d1);
      if ((float)(d1 * 1.75D) > FileUtils.getAvailableInnernalMemorySize())
      {
        if (paramOnPluginDownLoadListener != null) {
          paramOnPluginDownLoadListener.a(paramPluginInfo.mID);
        }
        return;
      }
      localObject3 = new HttpNetReq();
      ((HttpNetReq)localObject3).mCallback = this;
      ((HttpNetReq)localObject3).mSupportBreakResume = true;
      ((HttpNetReq)localObject3).mReqUrl = paramPluginInfo.mURL;
      ((HttpNetReq)localObject3).mHttpMethod = 0;
      ((HttpNetReq)localObject3).mNeedIpConnect = true;
      ((HttpNetReq)localObject3).bAcceptNegativeContentLength = true;
      ((HttpNetReq)localObject3).setUserData(paramPluginInfo.mID);
      String str = new File(a(this.a), paramPluginInfo.mID).getPath();
      ((HttpNetReq)localObject3).mOutPath = str;
      Object localObject4;
      if (paramBoolean)
      {
        localObject4 = this.h;
        if ((localObject4 != null) && (((IPreDownloadController)localObject4).isEnable())) {
          this.g.lock();
        }
      }
      try
      {
        localObject2 = new HttpEngineTask(this.c, paramPluginInfo.mID, this, (HttpNetReq)localObject3);
        ((HttpEngineTask)localObject2).userData = paramOnPluginDownLoadListener;
        paramOnPluginDownLoadListener = this.h;
        int i = b(paramPluginInfo.mID);
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(paramPluginInfo.mID);
        ((StringBuilder)localObject4).append(paramPluginInfo.mMD5);
        paramOnPluginDownLoadListener.requestPreDownload(i, null, ((StringBuilder)localObject4).toString(), 0, paramPluginInfo.mURL, str, 1, 0, false, (AbsPreDownloadTask)localObject2);
        this.f.put(paramPluginInfo.mID, localObject2);
        this.g.unlock();
      }
      finally
      {
        this.g.unlock();
      }
      ((IHttpEngineService)localObject2).sendReq((NetReq)localObject3);
      if (QLog.isColorLevel())
      {
        paramPluginInfo = new StringBuilder();
        paramPluginInfo.append("downloadPlugin: ");
        paramPluginInfo.append(((HttpNetReq)localObject3).mReqUrl);
        QLog.d("plugin_tag", 2, paramPluginInfo.toString());
      }
      return;
    }
    finally
    {
      this.g.unlock();
    }
    for (;;)
    {
      throw paramPluginInfo;
    }
  }
  
  public void a(String paramString)
  {
    this.b.obtainMessage(65794, paramString).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 65794: 
      c((String)paramMessage.obj);
      break;
    case 65793: 
      a((NetReq)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
      break;
    case 65792: 
      a((NetResp)paramMessage.obj);
    }
    return false;
  }
  
  public void onPreDownloadStart(HttpEngineTask paramHttpEngineTask)
  {
    this.f.remove(paramHttpEngineTask.httpReq.getUserData());
    a((String)paramHttpEngineTask.httpReq.getUserData(), paramHttpEngineTask.httpReq, (PluginDownloader.OnPluginDownLoadListener)paramHttpEngineTask.userData, paramHttpEngineTask, true);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    this.b.obtainMessage(65792, paramNetResp).sendToTarget();
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.b.obtainMessage(65793, (int)paramLong1, (int)paramLong2, paramNetReq).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginDownloader
 * JD-Core Version:    0.7.0.1
 */