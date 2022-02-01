package cooperation.ilive.manager;

import android.text.TextUtils;
import bluh;
import blul;
import bluv;
import blvj;
import blvk;
import blvm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class IlivePreDownloadManager
  implements bluh
{
  private static final String TAG = "IlivePreDownloadManager";
  private static IlivePreDownloadManager sInstance;
  
  private void downloadPlugin()
  {
    blvk.a().b("PLUGIN_DOWNLOAD");
    blul.a().a(true);
  }
  
  public static IlivePreDownloadManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new IlivePreDownloadManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  private void onPreloadDownloadComplete(boolean paramBoolean)
  {
    QLog.e("IlivePreDownloadManager", 1, "onPreloadDownloadComplete isSuccess = " + paramBoolean);
    Object localObject1 = blul.a().a();
    if ((localObject1 == null) || (TextUtils.isEmpty(((bluv)localObject1).c()))) {
      return;
    }
    Object localObject2 = new File(((bluv)localObject1).a());
    if (((File)localObject2).exists()) {}
    for (long l = ((File)localObject2).length();; l = -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IlivePreDownloadManager", 2, "onPreloadDownloadComplete isSuccess = " + paramBoolean + " url = " + ((bluv)localObject1).c() + " fileSize = " + l);
      }
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject2 instanceof QQAppInterface))
      {
        localObject2 = (PreDownloadController)((QQAppInterface)localObject2).getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
        localObject1 = ((bluv)localObject1).c();
        if (paramBoolean) {}
        for (;;)
        {
          ((PreDownloadController)localObject2).preDownloadSuccess((String)localObject1, l);
          return;
          l = -1L;
        }
      }
      QLog.e("IlivePreDownloadManager", 1, "onPreloadDownloadComplete app is not QQAppInterface");
      return;
    }
  }
  
  private void preloadDownload()
  {
    bluv localbluv = blul.a().a();
    if ((localbluv == null) || (TextUtils.isEmpty(localbluv.c()))) {
      return;
    }
    blvk.a().b("PLUGIN_PRE_DOWNLOAD");
    Object localObject1 = new IlivePreDownloadManager.2(this);
    QLog.e("IlivePreDownloadManager", 1, "add preload dispatch");
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject2;
      localObject2 = (PreDownloadController)localQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
      localObject1 = new RunnableTask(localQQAppInterface, localbluv.c(), (Runnable)localObject1, 4000L);
      ((PreDownloadController)localObject2).requestPreDownload(10095, "vas", localbluv.b(), ((Integer)PreDownloadConstants.BUSINESS_PRIORITY.get(Integer.valueOf(10095))).intValue(), localbluv.c(), localbluv.a(), 2, 0, false, (AbsPreDownloadTask)localObject1);
      return;
    }
    QLog.e("IlivePreDownloadManager", 1, "onPreloadDownloadStart app is not QQAppInterface");
    ((Runnable)localObject1).run();
  }
  
  public void cancelPreloadDownload()
  {
    bluv localbluv = blul.a().a();
    if ((localbluv == null) || (TextUtils.isEmpty(localbluv.c()))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("IlivePreDownloadManager", 2, " cancelPreloadDownload ");
    }
    blul.a().a();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      ((PreDownloadController)((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2)).cancelPreDownload(localbluv.c());
      return;
    }
    QLog.e("IlivePreDownloadManager", 1, "cancelPreloadDownload app is not QQAppInterface");
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
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("-106")))
      {
        QLog.e("IlivePreDownloadManager", 1, "preload onFail -106 ,cancel report ");
        return;
      }
      QLog.e("IlivePreDownloadManager", 1, "preload onFail code = " + paramInt + " msg = " + str + paramString);
      paramString = new HashMap();
      paramString.put("status", "fail");
      paramString.put("errorCode", paramInt + str);
      blvk.a().a("PLUGIN_PRE_DOWNLOAD").a("plugin_pre_download_result", paramString);
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
    blvk.a().a("PLUGIN_PRE_DOWNLOAD").a("plugin_pre_download_result", localHashMap);
    if (!blul.a().b())
    {
      onFail(102, "pre download success but local apk file is not exist");
      return;
    }
    onPreloadDownloadComplete(true);
  }
  
  public void preloadPluginConfig(int paramInt)
  {
    QLog.e("IlivePreDownloadManager", 1, "preloadPluginConfig isPreload = " + paramInt);
    if (paramInt != 1) {
      return;
    }
    if (!blvm.b())
    {
      QLog.e("IlivePreDownloadManager", 1, "stop preloadPluginConfig current version disable predownload");
      return;
    }
    ThreadManagerV2.executeOnFileThread(new IlivePreDownloadManager.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.manager.IlivePreDownloadManager
 * JD-Core Version:    0.7.0.1
 */