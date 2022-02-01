package cooperation.qzone;

import Override;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import anvx;
import bjkv;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZonePluginManager;
import cooperation.qzone.plugin.QZonePluginMangerHelper;
import cooperation.qzone.plugin.QZonePluginMangerHelper.OnQzonePluginClientReadyListner;
import cooperation.qzone.plugin.QZonePluginUtils;
import cooperation.qzone.plugin.QZoneRemotePluginHandler;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.video.QzoneVideoBeaconReport;

public class QZoneLiveVideoDownLoadActivtyV2
  extends QZoneLiveVideoBaseDownLoadActivty
  implements QZonePluginMangerHelper.OnQzonePluginClientReadyListner
{
  private static final String TAG = "QZoneLiveVideoDownLoadActivtyV2";
  IQZonePluginManager manger;
  
  private PluginBaseInfo toPluginInfo(PluginRecord paramPluginRecord)
  {
    if (paramPluginRecord == null) {
      return null;
    }
    PluginBaseInfo localPluginBaseInfo = new PluginBaseInfo();
    localPluginBaseInfo.mState = paramPluginRecord.state;
    localPluginBaseInfo.mDownloadProgress = paramPluginRecord.progress;
    localPluginBaseInfo.mVersion = String.valueOf(paramPluginRecord.ver);
    localPluginBaseInfo.mID = paramPluginRecord.id;
    return localPluginBaseInfo;
  }
  
  protected void cancelInstall()
  {
    super.cancelInstall();
    if (QzoneConfig.getInstance().getConfig("LiveSetting", "PluginDownloadCanceledOnCloseBtn", 0) == 1) {
      this.manger.cancelInstall("qzone_live_video_plugin_hack.apk");
    }
    QzoneVideoBeaconReport.reportVideoEvent(this.account, "live_video_entry", "9", null);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void downloadLivePluginSo()
  {
    if ((this.mMode == 1) && (!QZonePluginUtils.isQzoneLiveSoExist(BaseApplicationImpl.getContext())) && (this.manger != null)) {
      try
      {
        this.manger.installPituSo(new QZoneLiveVideoDownLoadActivtyV2.2(this), 1);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, localRemoteException, new Object[0]);
        return;
      }
    }
    launchLiveVideo();
  }
  
  protected String getPluginid()
  {
    return "qzone_live_video_plugin_hack.apk";
  }
  
  protected void handleDownloadPlugin(PluginBaseInfo paramPluginBaseInfo)
  {
    super.handleDownloadPlugin(paramPluginBaseInfo);
    if (paramPluginBaseInfo.mState == 2)
    {
      if (QZonePluginUtils.isProcessExist("com.tencent.mobileqq:qzonelive"))
      {
        RemoteHandleManager.getInstance().sendData("cmd.killLiveVideo", new Bundle(), false);
        new Handler().postDelayed(new QZoneLiveVideoDownLoadActivtyV2.1(this, paramPluginBaseInfo), 500L);
      }
    }
    else {
      return;
    }
    try
    {
      this.manger.installPlugin(paramPluginBaseInfo.mID, null, this.mMode);
      return;
    }
    catch (RemoteException paramPluginBaseInfo)
    {
      paramPluginBaseInfo.printStackTrace();
    }
  }
  
  protected void installPlugin()
  {
    super.installPlugin();
    try
    {
      this.manger.installPlugin("qzone_live_video_plugin_hack.apk", new QZoneLiveVideoDownLoadActivtyV2.PluginInstallListener(this), this.mMode);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, localRemoteException, new Object[0]);
    }
  }
  
  protected void installPluginSilence()
  {
    QLog.d("QZoneLiveVideoDownLoadActivtyV2", 1, "installPluginSilence");
    try
    {
      this.manger.installPlugin("qzone_live_video_plugin_hack.apk", null, 3);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, "installPluginSilence", localRemoteException);
    }
  }
  
  protected void launchLiveVideo()
  {
    super.launchLiveVideo();
    if ((this.mMode != 1) && (!QZonePluginUtils.isQzoneLiveSoExist(BaseApplicationImpl.getContext())) && (this.manger != null)) {}
    try
    {
      this.manger.installPituSo(null, 3);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, localRemoteException, new Object[0]);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.d("QZoneLiveVideoDownLoadActivtyV2", 4, "oncreate");
    if (!canEnterLiveVideo()) {
      return;
    }
    try
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_launch_completed");
      this.mReceiver = new QZoneLiveVideoBaseDownLoadActivty.LaunchCompletedObserver(this, "QZoneLiveVideo", "qzone_live_video_plugin_hack.apk");
      registerReceiver(this.mReceiver, paramBundle);
      QZonePluginMangerHelper.getQzonePluginClient(this, this);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.w("QZoneLiveVideoDownLoadActivtyV2", 1, "", paramBundle);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.manger = null;
  }
  
  public void onQzonePluginClientReady(IQZonePluginManager paramIQZonePluginManager)
  {
    if (paramIQZonePluginManager == null)
    {
      QZonePluginMangerHelper.getQzonePluginClient(this, this);
      return;
    }
    QQAppInterface localQQAppInterface2 = (QQAppInterface)getAppRuntime();
    QQAppInterface localQQAppInterface1 = localQQAppInterface2;
    if (localQQAppInterface2 == null)
    {
      QLog.i("QZoneLiveVideoDownLoadActivtyV2", 1, "onQzonePluginClientReady: getAppRuntime return null.");
      localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    if (localQQAppInterface1 != null) {
      QZoneRemotePluginHandler.getInstance().setAppInterface(localQQAppInterface1);
    }
    this.manger = paramIQZonePluginManager;
    paramIQZonePluginManager = this.manger.queryPlugin("qzone_live_video_plugin_hack.apk");
    if (paramIQZonePluginManager != null)
    {
      if (paramIQZonePluginManager.state == 4)
      {
        launchLiveVideoWhetherDownloadSo();
        return;
      }
      if (paramIQZonePluginManager.state == 2) {
        try
        {
          this.manger.installPlugin("qzone_live_video_plugin_hack.apk", null, this.mMode);
          return;
        }
        catch (RemoteException paramIQZonePluginManager)
        {
          QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, paramIQZonePluginManager, new Object[0]);
          return;
        }
      }
      QLog.d("QZoneLiveVideoDownLoadActivtyV2", 1, "QZoneLiveVideo has not installed");
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.mLaunchTime) / 1000.0D, 7, this.mMode + "");
      if ((3 == this.mMode) && (!TextUtils.isEmpty(this.mBackupUrl)) && (HttpUtil.isValidUrl(this.mBackupUrl)))
      {
        paramIQZonePluginManager = this.mBackupUrl + "&stayin=1";
        QLog.d("QZoneLiveVideoDownLoadActivtyV2", 1, "watch mode, jump to H5, " + paramIQZonePluginManager);
        QZoneHelper.forwardToBrowser(this, paramIQZonePluginManager, -1, null, null);
        if (QZonePluginManager.canDownloadPlugin()) {
          installPluginSilence();
        }
        doFinish();
        return;
      }
      if (1 == this.mMode) {
        LpReportInfo_dc00321.report(8, 128, 3, false, false, null);
      }
      int i = NetworkState.getNetworkType();
      QLog.d("QZoneLiveVideoDownLoadActivtyV2", 1, "network type = " + i);
      if ((1 == i) || (4 == i) || (5 == i) || (3 == i))
      {
        installPlugin();
        return;
      }
      paramIQZonePluginManager = Message.obtain();
      paramIQZonePluginManager.what = 1000;
      paramIQZonePluginManager.arg1 = 1;
      this.mHandler.sendMessage(paramIQZonePluginManager);
      return;
    }
    installPlugin();
    bjkv.a().a(anvx.a(2131711404));
    doFinish();
  }
  
  protected PluginBaseInfo queryPlugin(String paramString)
  {
    return toPluginInfo(this.manger.queryPlugin(paramString));
  }
  
  protected boolean validate(PluginBaseInfo paramPluginBaseInfo)
  {
    boolean bool = super.validate(paramPluginBaseInfo);
    if (!bool)
    {
      installPlugin();
      this.mHandler.sendEmptyMessageDelayed(1005, 500L);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2
 * JD-Core Version:    0.7.0.1
 */