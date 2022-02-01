package cooperation.ilive.manager;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.IliveDownloadCallback;
import cooperation.ilive.IlivePluginDownloadManager;
import cooperation.ilive.config.IliveConfigBean;
import cooperation.ilive.time.TimeMonitorData;
import cooperation.ilive.time.TimeMonitorManager;
import cooperation.ilive.util.IliveEntranceUtil;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class IlivePreDownloadManager
  implements IliveDownloadCallback
{
  private static final String TAG = "IlivePreDownloadManager";
  private static IlivePreDownloadManager sInstance;
  
  private void downloadPlugin()
  {
    TimeMonitorManager.a().b("PLUGIN_DOWNLOAD");
    IlivePluginDownloadManager.a().a(true);
  }
  
  public static IlivePreDownloadManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new IlivePreDownloadManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void onPreloadDownloadComplete(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onPreloadDownloadComplete isSuccess = ");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.e("IlivePreDownloadManager", 1, ((StringBuilder)localObject1).toString());
    localObject1 = IlivePluginDownloadManager.a().j();
    if (localObject1 != null)
    {
      if (TextUtils.isEmpty(((IliveConfigBean)localObject1).c())) {
        return;
      }
      Object localObject2 = new File(((IliveConfigBean)localObject1).a());
      long l;
      if (((File)localObject2).exists()) {
        l = ((File)localObject2).length();
      } else {
        l = -1L;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onPreloadDownloadComplete isSuccess = ");
        ((StringBuilder)localObject2).append(paramBoolean);
        ((StringBuilder)localObject2).append(" url = ");
        ((StringBuilder)localObject2).append(((IliveConfigBean)localObject1).c());
        ((StringBuilder)localObject2).append(" fileSize = ");
        ((StringBuilder)localObject2).append(l);
        QLog.i("IlivePreDownloadManager", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject2 instanceof QQAppInterface))
      {
        localObject2 = (IPreDownloadController)((QQAppInterface)localObject2).getRuntimeService(IPreDownloadController.class);
        localObject1 = ((IliveConfigBean)localObject1).c();
        if (!paramBoolean) {
          l = -1L;
        }
        ((IPreDownloadController)localObject2).preDownloadSuccess((String)localObject1, l);
        return;
      }
      QLog.e("IlivePreDownloadManager", 1, "onPreloadDownloadComplete app is not QQAppInterface");
    }
  }
  
  private void preloadDownload()
  {
    IliveConfigBean localIliveConfigBean = IlivePluginDownloadManager.a().j();
    if ((localIliveConfigBean != null) && (!TextUtils.isEmpty(localIliveConfigBean.c())))
    {
      TimeMonitorManager.a().b("PLUGIN_PRE_DOWNLOAD");
      Object localObject1 = new IlivePreDownloadManager.2(this);
      QLog.e("IlivePreDownloadManager", 1, "add preload dispatch");
      Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject2 instanceof QQAppInterface))
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)localObject2;
        localObject2 = (IPreDownloadController)localQQAppInterface.getRuntimeService(IPreDownloadController.class);
        localObject1 = new RunnableTask(localQQAppInterface, localIliveConfigBean.c(), (Runnable)localObject1, 4000L);
        ((IPreDownloadController)localObject2).requestPreDownload(10095, "vas", localIliveConfigBean.b(), 4, localIliveConfigBean.c(), localIliveConfigBean.a(), 2, 0, false, (AbsPreDownloadTask)localObject1);
        return;
      }
      QLog.e("IlivePreDownloadManager", 1, "onPreloadDownloadStart app is not QQAppInterface");
      ((Runnable)localObject1).run();
      return;
    }
  }
  
  public void cancelPreloadDownload()
  {
    IliveConfigBean localIliveConfigBean = IlivePluginDownloadManager.a().j();
    if (localIliveConfigBean != null)
    {
      if (TextUtils.isEmpty(localIliveConfigBean.c())) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("IlivePreDownloadManager", 2, " cancelPreloadDownload ");
      }
      IlivePluginDownloadManager.a().g();
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        ((IPreDownloadController)((QQAppInterface)localAppRuntime).getRuntimeService(IPreDownloadController.class)).cancelPreDownload(localIliveConfigBean.c());
        return;
      }
      QLog.e("IlivePreDownloadManager", 1, "cancelPreloadDownload app is not QQAppInterface");
    }
  }
  
  public void onFail(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      paramString = str.substring(str.lastIndexOf("errorCode="));
      boolean bool = TextUtils.isEmpty(paramString);
      if ((!bool) && (paramString.contains("-106")))
      {
        QLog.e("IlivePreDownloadManager", 1, "preload onFail -106 ,cancel report ");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preload onFail code = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" msg = ");
      localStringBuilder.append(str);
      localStringBuilder.append(paramString);
      QLog.e("IlivePreDownloadManager", 1, localStringBuilder.toString());
      paramString = new HashMap();
      paramString.put("status", "fail");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append(str);
      paramString.put("errorCode", localStringBuilder.toString());
      TimeMonitorManager.a().d("PLUGIN_PRE_DOWNLOAD").a("plugin_pre_download_result", paramString);
      onPreloadDownloadComplete(false);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onProgress(float paramFloat) {}
  
  public void onSuccess()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", "success");
    TimeMonitorManager.a().d("PLUGIN_PRE_DOWNLOAD").a("plugin_pre_download_result", localHashMap);
    if (!IlivePluginDownloadManager.a().k())
    {
      onFail(102, "pre download success but local apk file is not exist");
      return;
    }
    onPreloadDownloadComplete(true);
  }
  
  public void preloadPluginConfig(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preloadPluginConfig isPreload = ");
    localStringBuilder.append(paramInt);
    QLog.e("IlivePreDownloadManager", 1, localStringBuilder.toString());
    if (paramInt != 1) {
      return;
    }
    if (!IliveEntranceUtil.b())
    {
      QLog.e("IlivePreDownloadManager", 1, "stop preloadPluginConfig current version disable predownload");
      return;
    }
    ThreadManagerV2.executeOnFileThread(new IlivePreDownloadManager.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.manager.IlivePreDownloadManager
 * JD-Core Version:    0.7.0.1
 */