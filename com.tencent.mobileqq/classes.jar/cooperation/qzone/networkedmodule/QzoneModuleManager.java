package cooperation.qzone.networkedmodule;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.ProcessUtils;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QzoneModuleManager
{
  private static final int DISABLE_MODULE = 1;
  private static final int ENABLE_MODULE = 0;
  private static final String TAG = "QzoneModuleManager";
  private static volatile QzoneModuleManager sModuleManager;
  public volatile boolean hasLoadNewMapSDK = false;
  public volatile boolean hasLoadOldMapSDK = false;
  private volatile boolean hasSetVersionNum = false;
  QzoneModuleDownloadManager mDownloadManager = new QzoneModuleDownloadManager(BaseApplicationImpl.getApplication());
  private volatile boolean mHasStartedUpdateTask = false;
  public Object mLock = new Object();
  private Map<String, Boolean> mModueLoadState = new ConcurrentHashMap();
  private int mNextModuleIndex = 0;
  
  public static QzoneModuleManager getInstance()
  {
    if (sModuleManager == null) {
      try
      {
        if (sModuleManager == null) {
          sModuleManager = new QzoneModuleManager();
        }
      }
      finally {}
    }
    return sModuleManager;
  }
  
  private boolean securityCheck(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "qzone_module_disable", 0) == 1)
    {
      QLog.e("QzoneModuleManager", 1, "loadModule error: networked module is disabled");
      return false;
    }
    if (QzoneModuleCompat.isDeviceInBlackList())
    {
      QLog.w("QzoneModuleManager", 1, "loadModule error:device is in the blacklist.");
      return false;
    }
    return QzoneModuleConst.isLoadAccordingToCrashCount(paramString);
  }
  
  public void abortDownloadModule(String paramString)
  {
    this.mDownloadManager.abortDownloadModule(paramString);
  }
  
  public void cancelDownloadModule(String paramString)
  {
    this.mDownloadManager.cancelDownloadModule(paramString);
  }
  
  public boolean checkIfNeedUpdate(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = QzoneModuleConfigManager.getInstance().getModuleRecord(paramString);
      if (localObject != null)
      {
        if ((!((QzoneModuleRecord)localObject).hasNewConfig()) && (isModuleDownloaded(paramString)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("checkIfNeedUpdate: ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(",no new configs");
          QLog.i("QzoneModuleManager", 2, ((StringBuilder)localObject).toString());
          return false;
        }
        return true;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkIfNeedUpdate: record is null,");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("QzoneModuleManager", 2, ((StringBuilder)localObject).toString());
      return false;
    }
    throw new IllegalArgumentException("moduleId is null or empty.");
  }
  
  public boolean downloadModule(String paramString, ModuleDownloadListener paramModuleDownloadListener)
  {
    paramString = QzoneModuleConfigManager.getInstance().getModuleRecord(paramString);
    if (paramString == null) {
      return false;
    }
    return this.mDownloadManager.downloadModule(paramString.getDownloadRecord(), paramModuleDownloadListener);
  }
  
  public String getModuleFilePath(String paramString)
  {
    paramString = QzoneModuleConfigManager.getInstance().getModuleRecord(paramString);
    if (paramString != null) {
      return QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), paramString);
    }
    return "";
  }
  
  public boolean hasStartedUpdateTask()
  {
    return this.mHasStartedUpdateTask;
  }
  
  public boolean isModuleDownloaded(String paramString)
  {
    paramString = QzoneModuleConfigManager.getInstance().getModuleRecord(paramString);
    if (paramString != null)
    {
      File localFile = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), paramString));
      if ((localFile.exists()) && (paramString.mModuleFileLength != 0L) && (paramString.mModuleFileLength == localFile.length())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isModuleLoaded(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        boolean bool = ((Boolean)this.mModueLoadState.get(paramString)).booleanValue();
        return bool;
      }
      return false;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean loadLibraryById(String paramString)
  {
    paramString = getModuleFilePath(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        System.load(paramString);
        return true;
      }
      catch (Throwable paramString)
      {
        QLog.e("QzoneModuleManager", 1, "catch an exception:", paramString);
      }
    }
    return false;
  }
  
  boolean loadModule(QzoneModuleRecord paramQzoneModuleRecord, ClassLoader paramClassLoader, boolean paramBoolean)
  {
    if (paramQzoneModuleRecord == null)
    {
      QLog.e("QzoneModuleManager", 1, "record is null");
      return false;
    }
    String str1 = paramQzoneModuleRecord.mModuleId;
    if (this.mModueLoadState.containsKey(str1)) {
      return ((Boolean)this.mModueLoadState.get(str1)).booleanValue();
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    String str2 = QzoneModuleConst.getModuleSavePath(localBaseApplicationImpl, paramQzoneModuleRecord);
    synchronized (this.mLock)
    {
      if (this.mModueLoadState.containsKey(str1))
      {
        paramBoolean = ((Boolean)this.mModueLoadState.get(str1)).booleanValue();
        return paramBoolean;
      }
      paramBoolean = QzoneModuleLoader.loadModuleDex(str2, localBaseApplicationImpl.getApplicationContext(), paramClassLoader, paramQzoneModuleRecord.mKeyClassName, paramQzoneModuleRecord, paramBoolean);
      this.mModueLoadState.put(str1, Boolean.valueOf(paramBoolean));
      return paramBoolean;
    }
  }
  
  public boolean loadModule(File arg1)
  {
    if (!???.exists())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(???.getAbsolutePath());
      ((StringBuilder)localObject1).append(" is not exist.");
      QLog.e("QzoneModuleManager", 1, ((StringBuilder)localObject1).toString());
      return false;
    }
    Object localObject1 = ???.getAbsolutePath();
    String str = ???.getName();
    if (this.mModueLoadState.containsKey(str)) {
      return ((Boolean)this.mModueLoadState.get(str)).booleanValue();
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    QzoneModuleRecord localQzoneModuleRecord = new QzoneModuleRecord(str, ???.getName(), "", "", "", "", "", 0, 0L, null);
    synchronized (this.mLock)
    {
      if (this.mModueLoadState.containsKey(str))
      {
        bool = ((Boolean)this.mModueLoadState.get(str)).booleanValue();
        return bool;
      }
      boolean bool = QzoneModuleLoader.loadModuleDex((String)localObject1, localBaseApplicationImpl.getApplicationContext(), getClass().getClassLoader(), localQzoneModuleRecord.mKeyClassName, localQzoneModuleRecord);
      this.mModueLoadState.put(str, Boolean.valueOf(bool));
      return bool;
    }
  }
  
  public boolean loadModule(String paramString, ClassLoader paramClassLoader, boolean paramBoolean1, boolean paramBoolean2)
  {
    QzoneModuleRecord localQzoneModuleRecord = QzoneModuleConfigManager.getInstance().getModuleRecord(paramString);
    if (localQzoneModuleRecord == null)
    {
      paramClassLoader = new StringBuilder();
      paramClassLoader.append("loadModule error: can't find information about ");
      paramClassLoader.append(paramString);
      paramClassLoader.append(",please ensure is do exist");
      QLog.e("QzoneModuleManager", 1, paramClassLoader.toString());
      return false;
    }
    if (!securityCheck(paramString))
    {
      QLog.e("QzoneModuleManager", 1, "securityCheck: reject");
      return false;
    }
    if (paramBoolean1) {
      return loadModule2QQClassLoader(localQzoneModuleRecord);
    }
    return loadModule(localQzoneModuleRecord, paramClassLoader, paramBoolean2);
  }
  
  boolean loadModule2QQClassLoader(QzoneModuleRecord paramQzoneModuleRecord)
  {
    if (paramQzoneModuleRecord == null)
    {
      QLog.e("QzoneModuleManager", 1, "record is null");
      return false;
    }
    String str1 = paramQzoneModuleRecord.mModuleId;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (ProcessUtils.isQQ(ProcessUtils.getCurProcessName(localBaseApplicationImpl)))
    {
      QLog.e("QzoneModuleManager", 1, "-------try to load module into MainClassLoader in QQ process.This shouldn't happen,please ensure this is really what you want...");
      return false;
    }
    if (this.mModueLoadState.containsKey(str1)) {
      return ((Boolean)this.mModueLoadState.get(str1)).booleanValue();
    }
    String str2 = QzoneModuleConst.getModuleSavePath(localBaseApplicationImpl, paramQzoneModuleRecord);
    synchronized (this.mLock)
    {
      if (this.mModueLoadState.containsKey(str1))
      {
        bool = ((Boolean)this.mModueLoadState.get(str1)).booleanValue();
        return bool;
      }
      boolean bool = QzoneModuleLoader.loadModuleDex2MainClassLoader(str2, localBaseApplicationImpl.getApplicationContext(), paramQzoneModuleRecord.mKeyClassName, paramQzoneModuleRecord);
      this.mModueLoadState.put(str1, Boolean.valueOf(bool));
      if ((bool) && (!this.hasSetVersionNum)) {
        QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QzoneModuleManager.2(this));
      }
      return bool;
    }
  }
  
  public boolean loadModuleAsQQPatch(String paramString)
  {
    Object localObject = QzoneModuleConfigManager.getInstance().getModuleRecord(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadModule error: can't find information about ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",please ensure is do exist");
      QLog.e("QzoneModuleManager", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    if (!securityCheck(paramString))
    {
      QLog.e("QzoneModuleManager", 1, "securityCheck: reject");
      return false;
    }
    return loadModule2QQClassLoader((QzoneModuleRecord)localObject);
  }
  
  public boolean loadModuleAsQzonePatch(String paramString, ClassLoader paramClassLoader)
  {
    QzoneModuleRecord localQzoneModuleRecord = QzoneModuleConfigManager.getInstance().getModuleRecord(paramString);
    if (localQzoneModuleRecord == null)
    {
      paramClassLoader = new StringBuilder();
      paramClassLoader.append("loadModule error: can't find information about ");
      paramClassLoader.append(paramString);
      paramClassLoader.append(",please ensure is do exist");
      QLog.e("QzoneModuleManager", 1, paramClassLoader.toString());
      return false;
    }
    if (!securityCheck(paramString))
    {
      QLog.e("QzoneModuleManager", 1, "securityCheck: reject");
      return false;
    }
    return loadModule(localQzoneModuleRecord, paramClassLoader, true);
  }
  
  public void updateAllModules()
  {
    if (this.mHasStartedUpdateTask) {
      return;
    }
    this.mHasStartedUpdateTask = true;
    QLog.i("QzoneModuleManager", 1, "start to updateAllModules.");
    QzoneModuleManager.1 local1 = new QzoneModuleManager.1(this);
    while (this.mNextModuleIndex < QzoneModuleConst.QZONE_MODULES_PREDOWNLOAD.size())
    {
      String str = (String)QzoneModuleConst.QZONE_MODULES_PREDOWNLOAD.get(this.mNextModuleIndex);
      if (checkIfNeedUpdate(str))
      {
        updateModule(str, local1);
        return;
      }
      this.mNextModuleIndex += 1;
    }
  }
  
  public void updateModule(String paramString, ModuleDownloadListener paramModuleDownloadListener)
  {
    if (!checkIfNeedUpdate(paramString)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateModule: ");
    localStringBuilder.append(paramString);
    QLog.i("QzoneModuleManager", 1, localStringBuilder.toString());
    downloadModule(paramString, paramModuleDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleManager
 * JD-Core Version:    0.7.0.1
 */