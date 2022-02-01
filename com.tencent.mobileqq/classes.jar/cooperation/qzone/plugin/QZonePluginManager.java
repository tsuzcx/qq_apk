package cooperation.qzone.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.ProcessUtils;
import dov.com.qq.im.ae.download.AEResUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class QZonePluginManager
  extends IQZonePluginManager
  implements Handler.Callback, QZoneLiveSoDownloader.OnSoDownloadListener, QZonePluginDownloader.OnPluginDownloadListner, QZonePluginInstaller.OnPluginInstallListner, QZonePluginInstaller.OnPluginUninstallListner, QZonePluginUpdater.OnUpdateListner, Manager
{
  public static final int CONFIRM_CODE_DEAMON_INSTALL_LAUNCH = 3;
  public static final int CONFIRM_CODE_INSTALL_LAUNCH = 1;
  public static final int CONFIRM_CODE_NO_INSTALL_LAUNCH = 2;
  public static final int CONFIRM_CODE_NO_INSTALL_NO_LAUNCH = 0;
  private static final int MSG_GET_NETWORK_PLUGIN_LIST = 0;
  private static final String MTA_EVENT_KEY_PLUGIN_DOWNLOAD_REFER = "QzonePluginDownloadRefer";
  private static final String MTA_SUB_KEY_PLUGIN_ID = "plugin_id";
  private static final String MTA_SUB_KEY_REFER = "refer";
  public static final String TAG = "QZonePluginManger";
  private boolean closed = false;
  private QZonePluginDownloader downloader;
  private QZonePluginInstaller installer;
  private boolean lastUpdateSuccess = false;
  Context mContext;
  private boolean mIsReady = false;
  Object mPendingLaunchLock = new Object();
  QZonePluginManager.LaunchState mPendingLaunchState;
  private ConcurrentHashMap<String, WeakReference<OnQZonePluginInstallListner>> mPluginRecords;
  private ConcurrentHashMap<String, PluginRecord> mProcessingPlugins;
  private Handler pluginHandler;
  private boolean pluginInfoRequesting;
  private QZonePluginPreInstaller preInstaller;
  private WeakReference<OnQZoneLiveSoDownloadListener> soDownloadListener;
  private QZoneLiveSoDownloader soDownloader;
  private QZonePluginUpdater updater;
  
  public QZonePluginManager(QQAppInterface paramQQAppInterface)
  {
    QLog.i("QZonePluginManger", 1, "QZonePluginManager init");
    this.pluginHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.mContext = paramQQAppInterface.getApp();
    this.updater = new QZonePluginUpdater(paramQQAppInterface, this.mContext, this.pluginHandler);
    this.updater.setOnUpdateListner(this);
    this.mProcessingPlugins = new ConcurrentHashMap();
    this.mPluginRecords = new ConcurrentHashMap();
    this.downloader = new QZonePluginDownloader(this.mContext);
    this.soDownloader = new QZoneLiveSoDownloader(this.mContext);
    this.installer = new QZonePluginInstaller(this.mContext);
    this.closed = false;
    QZoneRemotePluginHandler.getInstance().setAppInterface(paramQQAppInterface);
  }
  
  public static boolean canDownloadPlugin()
  {
    boolean bool2 = true;
    int i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginDownloadOnlyWifi", 1);
    QLog.d("QZonePluginManger", 1, "canDownloadPlugin, onlyWifi=" + i);
    boolean bool1;
    if (i > 0) {
      bool1 = NetworkState.isWifiConn();
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            i = NetworkState.getNetworkType();
            QLog.d("QZonePluginManger", 1, "network type = " + i);
            bool1 = bool2;
          } while (1 == i);
          bool1 = bool2;
        } while (4 == i);
        bool1 = bool2;
      } while (5 == i);
      bool1 = bool2;
    } while (3 == i);
    return false;
  }
  
  private void checkUpdate(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (paramPluginParams == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          QLog.i("QZonePluginManger", 1, "checkUpdate:" + paramPluginParams.mPluginID);
        } while (isClosed());
        if (this.mIsReady) {
          break;
        }
      } while (paramOnPluginReadyListener == null);
      paramOnPluginReadyListener.onPluginReady(false, paramContext, paramPluginParams);
      return;
      localObject = paramPluginParams.mPluginID;
      PluginRecord localPluginRecord = this.updater.getNewPluginInfo((String)localObject);
      if (localPluginRecord == null)
      {
        doInstallAndLaunch(0, paramContext, paramPluginParams, paramOnPluginReadyListener);
        return;
      }
      boolean bool = isPluginInstalled((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "installed :" + bool);
      }
      localObject = this.installer.getInstalledPlugininfo((String)localObject);
      if (bool)
      {
        bool = this.updater.checkUpToDate((PluginRecord)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("QZonePluginManger", 2, "up to day :" + bool);
        }
        if (bool)
        {
          doInstallAndLaunch(2, paramContext, paramPluginParams, paramOnPluginReadyListener);
          return;
        }
      }
      if ((!QZonePluginUtils.isPluginRunning(localPluginRecord, paramContext)) || (localPluginRecord == null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "plugin still running");
      }
    } while (paramOnPluginReadyListener == null);
    paramPluginParams.mApkFilePath = ((PluginRecord)localObject).mInstalledPath;
    paramOnPluginReadyListener.onPluginReady(true, paramContext, paramPluginParams);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "forceUpdate, deamonInstall：" + true + ", " + true);
    }
    doInstallAndLaunch(3, paramContext, paramPluginParams, paramOnPluginReadyListener);
  }
  
  private void doInstallAndLaunch(int paramInt, Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (paramPluginParams == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              QLog.i("QZonePluginManger", 1, "doInstallAndLaunch. confirmCode, pluginId:" + paramInt + "," + paramPluginParams.mPluginID);
            } while (isClosed());
            if (this.mIsReady) {
              break;
            }
          } while (paramOnPluginReadyListener == null);
          paramOnPluginReadyListener.onPluginReady(false, paramContext, paramPluginParams);
          return;
          if (paramInt != 0) {
            break;
          }
        } while (paramOnPluginReadyListener == null);
        paramOnPluginReadyListener.onPluginReady(false, paramContext, paramPluginParams);
        return;
        if (paramInt != 2) {
          break;
        }
      } while (paramOnPluginReadyListener == null);
      localObject1 = this.installer.getInstalledPlugininfo(paramPluginParams.mPluginID);
      if (localObject1 != null) {
        paramPluginParams.mApkFilePath = ((PluginRecord)localObject1).mInstalledPath;
      }
      paramOnPluginReadyListener.onPluginReady(true, paramContext, paramPluginParams);
      return;
      if (paramInt == 1)
      {
        localObject1 = paramPluginParams.mPluginID;
        localObject2 = this.updater.getNewPluginRecord((String)localObject1);
        if (localObject2 == null) {}
        for (;;)
        {
          localObject2 = new QZonePluginManager.LaunchState();
          ((QZonePluginManager.LaunchState)localObject2).context = paramContext;
          ((QZonePluginManager.LaunchState)localObject2).params = paramPluginParams;
          ((QZonePluginManager.LaunchState)localObject2).listener = paramOnPluginReadyListener;
          try
          {
            installPlugin((String)localObject1, new QZonePluginManager.PluginInstallForLaunch(this, (QZonePluginManager.LaunchState)localObject2), 0);
            return;
          }
          catch (RemoteException paramContext)
          {
            QLog.e("QZonePluginManger", 1, paramContext, new Object[0]);
            return;
          }
          localObject2 = ((PluginRecord)localObject2).name;
        }
      }
    } while (paramInt != 3);
    Object localObject1 = paramPluginParams.mPluginID;
    Object localObject2 = new QZonePluginManager.LaunchState();
    ((QZonePluginManager.LaunchState)localObject2).context = paramContext;
    ((QZonePluginManager.LaunchState)localObject2).params = paramPluginParams;
    ((QZonePluginManager.LaunchState)localObject2).listener = paramOnPluginReadyListener;
    try
    {
      installPlugin((String)localObject1, new QZonePluginManager.PluginInstallForLaunch(this, (QZonePluginManager.LaunchState)localObject2), 0);
      return;
    }
    catch (RemoteException paramContext)
    {
      QLog.e("QZonePluginManger", 1, paramContext, new Object[0]);
    }
  }
  
  private void getPluginList()
  {
    QLog.i("QZonePluginManger", 2, "getPluginList  pluginInfoRequesting:" + this.pluginInfoRequesting);
    if (isClosed()) {}
    while (this.pluginInfoRequesting) {
      return;
    }
    this.pluginInfoRequesting = true;
    this.updater.getPluginList();
  }
  
  private void getPluginListIfNeed()
  {
    QLog.i("QZonePluginManger", 1, "getPluginListIfNeed  pluginInfoRequesting:" + this.pluginInfoRequesting + " isReady:" + isReady() + " :lastUpdateSuccess:" + this.lastUpdateSuccess);
    if (isClosed()) {}
    while ((this.pluginInfoRequesting) || (this.lastUpdateSuccess)) {
      return;
    }
    this.pluginHandler.sendEmptyMessage(0);
  }
  
  private PluginRecord getPluginRecordInner(String paramString)
  {
    if (isClosed()) {
      QLog.i("QZonePluginManger", 1, "getPluginRecordInner: manager is close. pluginId=" + paramString);
    }
    do
    {
      return null;
      QLog.i("QZonePluginManger", 1, "getPluginRecordInner " + paramString + "");
    } while (TextUtils.isEmpty(paramString));
    PluginRecord localPluginRecord2 = (PluginRecord)this.mProcessingPlugins.get(paramString);
    QLog.i("QZonePluginManger", 1, "mProcessingPlugins getInstalledPlugininfo " + localPluginRecord2 + "");
    PluginRecord localPluginRecord1;
    if (localPluginRecord2 == null)
    {
      localPluginRecord1 = this.installer.getInstalledPlugininfo(paramString);
      QLog.i("QZonePluginManger", 1, "installer getInstalledPlugininfo " + localPluginRecord1 + "");
      if (localPluginRecord1 == null)
      {
        localPluginRecord1 = this.updater.getNewPluginRecord(paramString);
        QLog.i("QZonePluginManger", 1, "updater getNewPluginRecord " + localPluginRecord1 + "");
      }
    }
    for (;;)
    {
      QLog.i("QZonePluginManger", 1, "getPluginRecordInner final record " + localPluginRecord1 + "");
      return localPluginRecord1;
      boolean bool = this.updater.checkUpToDate(localPluginRecord1);
      QLog.i("QZonePluginManger", 1, "updater.checkUpToDate: " + bool + "");
      if (!bool)
      {
        localPluginRecord1 = this.updater.getNewPluginRecord(paramString);
        QLog.i("QZonePluginManger", 1, "updater getNewPluginRecord " + localPluginRecord1 + "");
        continue;
        int i = localPluginRecord2.state;
        if ((i != -1) && (i != 4))
        {
          localPluginRecord1 = localPluginRecord2;
          if (i != -2) {}
        }
        else
        {
          this.mProcessingPlugins.remove(paramString);
          localPluginRecord1 = localPluginRecord2;
        }
      }
    }
  }
  
  private boolean isClosed()
  {
    return this.closed;
  }
  
  private boolean isPluginInstallBackground(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 2);
  }
  
  private void reportBeacon(String paramString, int paramInt)
  {
    if (isClosed()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("pluginid", paramString);
    StatisticCollector.getInstance(this.mContext).collectPerformance(null, "actQzonePluginPatch", true, 0L, 0L, localHashMap, null);
  }
  
  private void reportDownloadReferToMTA(String paramString, int paramInt)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new QZonePluginManager.1(this, paramString, paramInt));
  }
  
  public boolean cancelInstall(String paramString)
  {
    QLog.i("QZonePluginManger", 1, "cancelInstall " + paramString + "");
    if (isClosed()) {}
    while (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = this.updater.getNewPluginRecord(paramString);
    this.downloader.cancelDownLoadPlugin(paramString, this);
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      getPluginList();
    }
  }
  
  public void installPituSo(OnQZoneLiveSoDownloadListener paramOnQZoneLiveSoDownloadListener, int paramInt)
  {
    QLog.i("QZonePluginManger", 1, "installPituSo");
    if (QZoneRemotePluginHandler.getInstance().getAppInterface() == null) {
      QLog.w("QZonePluginManger", 1, "installPituSo, app is null");
    }
    do
    {
      return;
      this.soDownloadListener = new WeakReference(paramOnQZoneLiveSoDownloadListener);
      paramOnQZoneLiveSoDownloadListener = QZoneHelper.getQzonePluginSoUrl();
    } while (TextUtils.isEmpty(paramOnQZoneLiveSoDownloadListener));
    this.soDownloader.downloadSo(paramOnQZoneLiveSoDownloadListener, this, paramInt);
  }
  
  public boolean installPlugin(String paramString, OnQZonePluginInstallListner paramOnQZonePluginInstallListner, int paramInt)
  {
    if (isClosed()) {
      QLog.i("QZonePluginManger", 1, "installPlugin: manager is closed. pluginId=" + paramString);
    }
    do
    {
      return false;
      QLog.i("QZonePluginManger", 1, "installPlugin pluginid=" + paramString + " refer=" + paramInt);
    } while (TextUtils.isEmpty(paramString));
    if (this.mProcessingPlugins.containsKey(paramString))
    {
      QLog.d("QZonePluginManger", 1, "installPlugin pluginid:" + paramString + ",正在处理，skip。。。");
      return false;
    }
    this.mPluginRecords.put(paramString, new WeakReference(paramOnQZonePluginInstallListner));
    PluginRecord localPluginRecord1 = this.updater.getNewPluginRecord(paramString);
    if (localPluginRecord1 != null)
    {
      PluginRecord localPluginRecord2 = this.installer.getInstalledPlugininfo(paramString);
      if ((localPluginRecord2 != null) && (localPluginRecord2.state == 4) && (this.updater.checkUpToDate(localPluginRecord2)))
      {
        QLog.i("QZonePluginManger", 1, "installPlugin " + paramString + " 已安装");
        if (paramOnQZonePluginInstallListner != null) {
          paramOnQZonePluginInstallListner.onInstallFinish(paramString);
        }
      }
    }
    for (;;)
    {
      if (this.preInstaller == null) {
        this.preInstaller = new QZonePluginPreInstaller(this, this.updater);
      }
      return true;
      QLog.i("QZonePluginManger", 1, "installPlugin " + paramString + " 未安装,开始下载");
      this.mProcessingPlugins.put(paramString, localPluginRecord1);
      this.downloader.downloadPlugin(localPluginRecord1, this, paramInt);
      reportDownloadReferToMTA(localPluginRecord1.id, paramInt);
      continue;
      QLog.e("QZonePluginManger", 1, "installPlugin record==null 没有插件信息，失败");
      this.mProcessingPlugins.remove(paramString);
      if (paramOnQZonePluginInstallListner != null) {
        paramOnQZonePluginInstallListner.onInstallError(paramString, 1);
      }
      reportBeacon(paramString, 1);
    }
  }
  
  public boolean isPluginInstalled(String paramString)
  {
    boolean bool = true;
    QLog.i("QZonePluginManger", 1, "isPluginInstalled: " + paramString);
    if (isClosed()) {}
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(paramString));
      paramString = queryPlugin(paramString);
    } while (paramString == null);
    QLog.i("QZonePluginManger", 1, " isPluginInstalled record :" + paramString);
    if (paramString.state == 4) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean isReady()
  {
    if (isClosed()) {
      return false;
    }
    return this.mIsReady;
  }
  
  public void onDestroy()
  {
    QLog.i("QZonePluginManger", 1, "onDestroy");
    this.mPluginRecords.clear();
    this.mProcessingPlugins.clear();
    this.updater = null;
    this.installer = null;
    if (this.downloader != null) {
      this.downloader.onDestroy();
    }
    this.soDownloader = null;
    this.downloader = null;
    if (this.preInstaller != null) {
      this.preInstaller.onDestroy();
    }
    this.preInstaller = null;
    this.closed = true;
  }
  
  public void onDownLoadStart(PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onDownLoadStart record:" + paramPluginRecord);
    if (isClosed()) {
      break label33;
    }
    for (;;)
    {
      label33:
      return;
      if (paramPluginRecord != null)
      {
        Object localObject = (PluginRecord)this.mProcessingPlugins.get(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        ((PluginRecord)localObject).state = 1;
        localObject = (WeakReference)this.mPluginRecords.get(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        try
        {
          localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((OnQZonePluginInstallListner)localObject).onInstallBegin(paramPluginRecord.id);
            return;
          }
        }
        catch (RemoteException paramPluginRecord)
        {
          QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
        }
      }
    }
  }
  
  public void onDownLoadStart(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord)
  {
    if (this.soDownloadListener != null) {}
    try
    {
      paramDownloadSoRecord = (OnQZoneLiveSoDownloadListener)this.soDownloadListener.get();
      if (paramDownloadSoRecord != null) {
        paramDownloadSoRecord.onDownloadBegin();
      }
      return;
    }
    catch (RemoteException paramDownloadSoRecord)
    {
      QLog.e("QZonePluginManger", 1, paramDownloadSoRecord, new Object[0]);
    }
  }
  
  public void onDownloadCanceled(PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onDownloadCanceled record:" + paramPluginRecord);
    if (isClosed()) {}
    while (paramPluginRecord == null) {
      return;
    }
    paramPluginRecord.state = -1;
    this.mProcessingPlugins.remove(paramPluginRecord.id);
    Object localObject = (WeakReference)this.mPluginRecords.remove(paramPluginRecord.id);
    if (localObject != null) {}
    try
    {
      localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnQZonePluginInstallListner)localObject).onInstallError(paramPluginRecord.id, 3);
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("QZonePluginManger", 1, localRemoteException, new Object[0]);
      }
    }
    reportBeacon(paramPluginRecord.id, 3);
  }
  
  public void onDownloadCanceled(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord)
  {
    if (this.soDownloadListener != null) {}
    try
    {
      paramDownloadSoRecord = (OnQZoneLiveSoDownloadListener)this.soDownloadListener.get();
      if (paramDownloadSoRecord != null) {
        paramDownloadSoRecord.onDownloadCancel();
      }
      return;
    }
    catch (RemoteException paramDownloadSoRecord)
    {
      QLog.e("QZonePluginManger", 1, paramDownloadSoRecord, new Object[0]);
    }
  }
  
  public void onDownloadFailed(PluginRecord paramPluginRecord, int paramInt)
  {
    QLog.i("QZonePluginManger", 1, "onDownloadFailed record:" + paramPluginRecord);
    if (isClosed()) {
      break label33;
    }
    label33:
    Object localObject;
    for (;;)
    {
      return;
      if (paramPluginRecord != null)
      {
        paramPluginRecord.state = -2;
        this.mProcessingPlugins.remove(paramPluginRecord.id);
        localObject = (WeakReference)this.mPluginRecords.remove(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        try
        {
          localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
          if (localObject != null) {
            if (-9998 == paramInt)
            {
              ((OnQZonePluginInstallListner)localObject).onInstallError(paramPluginRecord.id, 8);
              reportBeacon(paramPluginRecord.id, 8);
              return;
            }
          }
        }
        catch (RemoteException paramPluginRecord)
        {
          QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
          return;
        }
      }
    }
    ((OnQZonePluginInstallListner)localObject).onInstallError(paramPluginRecord.id, 5);
    reportBeacon(paramPluginRecord.id, 5);
  }
  
  public void onDownloadFailed(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord)
  {
    if (this.soDownloadListener != null) {}
    try
    {
      OnQZoneLiveSoDownloadListener localOnQZoneLiveSoDownloadListener = (OnQZoneLiveSoDownloadListener)this.soDownloadListener.get();
      if (localOnQZoneLiveSoDownloadListener != null) {
        localOnQZoneLiveSoDownloadListener.onDownloadFail(paramDownloadSoRecord.errorCode);
      }
      return;
    }
    catch (RemoteException paramDownloadSoRecord)
    {
      QLog.e("QZonePluginManger", 1, paramDownloadSoRecord, new Object[0]);
    }
  }
  
  public void onDownloadProgress(PluginRecord paramPluginRecord)
  {
    if (isClosed()) {
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if (paramPluginRecord != null)
      {
        Object localObject = (PluginRecord)this.mProcessingPlugins.get(paramPluginRecord.id);
        if (localObject != null) {
          ((PluginRecord)localObject).state = 1;
        }
        localObject = (WeakReference)this.mPluginRecords.get(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        try
        {
          localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((OnQZonePluginInstallListner)localObject).onInstallDownloadProgress(paramPluginRecord.id, paramPluginRecord.progress, paramPluginRecord.size);
            return;
          }
        }
        catch (RemoteException paramPluginRecord)
        {
          QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
        }
      }
    }
  }
  
  public void onDownloadProgress(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord)
  {
    if ((this.soDownloadListener != null) && (paramDownloadSoRecord != null)) {}
    try
    {
      OnQZoneLiveSoDownloadListener localOnQZoneLiveSoDownloadListener = (OnQZoneLiveSoDownloadListener)this.soDownloadListener.get();
      if (localOnQZoneLiveSoDownloadListener != null) {
        localOnQZoneLiveSoDownloadListener.onDownloadProgress(paramDownloadSoRecord.progress);
      }
      return;
    }
    catch (RemoteException paramDownloadSoRecord)
    {
      QLog.e("QZonePluginManger", 1, paramDownloadSoRecord, new Object[0]);
    }
  }
  
  public void onDownloadSucceed(PluginRecord paramPluginRecord, int paramInt)
  {
    QLog.i("QZonePluginManger", 1, "onDownloadSucceed record:" + paramPluginRecord + " refer=" + paramInt);
    if (isClosed()) {}
    PluginRecord localPluginRecord;
    do
    {
      do
      {
        return;
      } while (paramPluginRecord == null);
      localPluginRecord = (PluginRecord)this.mProcessingPlugins.get(paramPluginRecord.id);
    } while (localPluginRecord == null);
    localPluginRecord.state = 2;
    boolean bool;
    if ((isPluginInstallBackground(paramInt)) && (QZonePluginUtils.isPluginRunning(paramPluginRecord, this.mContext)))
    {
      if (!paramPluginRecord.id.equals(QZonePluginUtils.getLoadQZoneLivePluginId())) {
        break label248;
      }
      if (!ProcessUtils.isQzoneLive(ProcessUtils.getRunningProcessPackageName())) {
        break label243;
      }
      bool = true;
    }
    for (;;)
    {
      QLog.i("QZonePluginManger", 1, "onDownloadSucceed record=" + paramPluginRecord + " isPluginRealRunning=" + bool);
      Object localObject;
      if (bool)
      {
        localObject = (WeakReference)this.mPluginRecords.get(paramPluginRecord.id);
        if (localObject != null)
        {
          localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
          if (localObject == null) {}
        }
      }
      try
      {
        ((OnQZonePluginInstallListner)localObject).onInstallError(paramPluginRecord.id, 2);
        reportBeacon(paramPluginRecord.id, 2);
        this.installer.installPlugin(localPluginRecord, this);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          QLog.e("QZonePluginManger", 1, localRemoteException, new Object[0]);
        }
      }
      label243:
      bool = false;
      continue;
      label248:
      bool = true;
    }
  }
  
  public void onDownloadSucceed(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord)
  {
    if (this.soDownloadListener != null) {}
    try
    {
      paramDownloadSoRecord = (OnQZoneLiveSoDownloadListener)this.soDownloadListener.get();
      if (paramDownloadSoRecord != null) {
        paramDownloadSoRecord.onDownloadSuccess();
      }
      return;
    }
    catch (RemoteException paramDownloadSoRecord)
    {
      QLog.e("QZonePluginManger", 1, paramDownloadSoRecord, new Object[0]);
    }
  }
  
  public void onInstallBegin(PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onInstallBegin record:" + paramPluginRecord);
    if (isClosed()) {
      break label33;
    }
    for (;;)
    {
      label33:
      return;
      if (paramPluginRecord != null)
      {
        Object localObject = (PluginRecord)this.mProcessingPlugins.get(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        ((PluginRecord)localObject).state = 3;
        localObject = (WeakReference)this.mPluginRecords.get(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        try
        {
          localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((OnQZonePluginInstallListner)localObject).onInstallBegin(paramPluginRecord.id);
            return;
          }
        }
        catch (RemoteException paramPluginRecord)
        {
          QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
        }
      }
    }
  }
  
  public void onInstallFinish(boolean paramBoolean, PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onInstallFinish record:" + paramPluginRecord);
    if (isClosed()) {}
    while (paramPluginRecord == null) {
      return;
    }
    Object localObject = (WeakReference)this.mPluginRecords.remove(paramPluginRecord.id);
    try
    {
      this.mProcessingPlugins.remove(paramPluginRecord.id);
      if (paramBoolean)
      {
        if (localObject != null)
        {
          localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
          if (localObject != null) {
            ((OnQZonePluginInstallListner)localObject).onInstallFinish(paramPluginRecord.id);
          }
        }
        reportBeacon(paramPluginRecord.id, 0);
        return;
      }
    }
    catch (RemoteException paramPluginRecord)
    {
      QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
      return;
    }
    if (localObject != null)
    {
      localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnQZonePluginInstallListner)localObject).onInstallError(paramPluginRecord.id, 7);
      }
    }
    reportBeacon(paramPluginRecord.id, 7);
  }
  
  public void onUnInstallBegin(PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onUnInstallBegin record:" + paramPluginRecord);
    if (isClosed()) {}
  }
  
  public void onUnInstallFinish(boolean paramBoolean, PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onUnInstallFinish reslut:" + paramBoolean + "record:" + paramPluginRecord);
    if (isClosed()) {}
  }
  
  public void onUpdatefinish(boolean paramBoolean)
  {
    QLog.i("QZonePluginManger", 1, "onUpdatefinish success:" + paramBoolean);
    if (isClosed()) {
      return;
    }
    this.lastUpdateSuccess = paramBoolean;
    this.mIsReady = true;
    if ((paramBoolean) && (this.preInstaller != null)) {
      this.preInstaller.preload();
    }
    synchronized (this.mPendingLaunchLock)
    {
      if (this.mPendingLaunchState != null)
      {
        QLog.i("QZonePluginManger", 1, "onUpdateFinish. handle pending launch state");
        QZonePluginManager.LaunchState localLaunchState = this.mPendingLaunchState;
        checkUpdate(localLaunchState.context, localLaunchState.params, localLaunchState.listener);
        this.mPendingLaunchState = null;
        this.pluginHandler.post(new QZonePluginManager.2(this));
        return;
      }
      QLog.i("QZonePluginManger", 1, "mPendingLaunchState is null");
    }
  }
  
  public PluginRecord queryPlugin(String paramString)
  {
    if (isClosed()) {
      QLog.i("QZonePluginManger", 1, "queryPlugin: manager is close. pluginId=" + paramString);
    }
    while (TextUtils.isEmpty(paramString)) {
      return null;
    }
    PluginRecord localPluginRecord2 = getPluginRecordInner(paramString);
    PluginRecord localPluginRecord1 = localPluginRecord2;
    if (localPluginRecord2 != null) {
      localPluginRecord1 = localPluginRecord2.clone();
    }
    getPluginListIfNeed();
    QLog.i("QZonePluginManger", 1, "queryPlugin queryPlugin：" + paramString + ",record:" + localPluginRecord1);
    return localPluginRecord1;
  }
  
  public void readyForLaunch(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (isClosed())
    {
      QLog.w("QZonePluginManger", 1, "QZonePluginManagerIsClosed=true");
      return;
    }
    if (!this.mIsReady)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "not ready");
      }
      synchronized (this.mPendingLaunchLock)
      {
        if (this.mPendingLaunchState != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZonePluginManger", 2, "mPengdingLaunchState already set");
          }
          if (paramOnPluginReadyListener != null) {
            paramOnPluginReadyListener.onPluginReady(false, paramContext, paramPluginParams);
          }
          return;
        }
      }
      synchronized (this.mPendingLaunchLock)
      {
        getPluginListIfNeed();
        QZonePluginManager.LaunchState localLaunchState = new QZonePluginManager.LaunchState();
        localLaunchState.context = paramContext;
        localLaunchState.params = paramPluginParams;
        localLaunchState.listener = paramOnPluginReadyListener;
        this.mPendingLaunchState = localLaunchState;
        if (QLog.isColorLevel()) {
          QLog.d("QZonePluginManger", 2, "set mPendingLaunchState");
        }
        return;
      }
    }
    checkUpdate(paramContext, paramPluginParams, paramOnPluginReadyListener);
  }
  
  public void setReadyToNetworking()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "setReadyToNetworking");
    }
    getPluginListIfNeed();
  }
  
  public void triggerQQDownloadPtuFilter()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 1, "triggerQQDownloadPtuFilter");
    }
    QQAppInterface localQQAppInterface = QZoneRemotePluginHandler.getInstance().getAppInterface();
    if (localQQAppInterface == null) {
      QLog.w("QZonePluginManger", 1, "triggerQQDownloadPtuFilter, app is null");
    }
    do
    {
      do
      {
        return;
      } while (!PtvFilterSoLoad.a());
      QLog.w("QZonePluginManger", 1, "triggerQQDownloadPtuFilter");
    } while (AEResUtil.b());
    PtvFilterSoLoad.a(localQQAppInterface, BaseApplicationImpl.getContext());
  }
  
  public boolean uninstallPlugin(String paramString)
  {
    QLog.i("QZonePluginManger", 1, "uninstallPlugin " + paramString);
    if (isClosed()) {}
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(paramString));
      paramString = this.updater.getNewPluginRecord(paramString);
      this.installer.unInstallPlugin(paramString, null);
      this.downloader.cancelDownLoadPlugin(paramString, this);
      paramString = QZoneHelper.getQzonePluginSoUrl();
    } while (TextUtils.isEmpty(paramString));
    this.soDownloader.cancelDownLoadSo(paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginManager
 * JD-Core Version:    0.7.0.1
 */