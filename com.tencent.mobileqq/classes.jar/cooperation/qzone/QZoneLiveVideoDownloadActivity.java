package cooperation.qzone;

import Override;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.plugin.QZonePluginManager;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;

public class QZoneLiveVideoDownloadActivity
  extends QZoneLiveVideoBaseDownLoadActivty
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public static final String TAG = "QZoneLiveVideoDownloadActivity";
  public PluginManagerClient mPluginManager;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected String getPluginid()
  {
    return "qzone_live_video_plugin.apk";
  }
  
  protected void installPlugin()
  {
    super.installPlugin();
    if (this.mPluginManager == null)
    {
      QZLog.e("QZoneLiveVideoDownloadActivity", "[installPlugin] mPluginManager is null");
      return;
    }
    this.mPluginManager.installPlugin(getPluginid());
  }
  
  protected void installPluginSilence()
  {
    QLog.d("QZoneLiveVideoDownloadActivity", 1, "installPluginSilence");
    this.mPluginManager.installPlugin(getPluginid());
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
    if (!canEnterLiveVideo()) {
      return;
    }
    try
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_launch_completed");
      this.mReceiver = new QZoneLiveVideoBaseDownLoadActivty.LaunchCompletedObserver(this, "QZoneLiveVideo", "qzone_live_video_plugin.apk");
      registerReceiver(this.mReceiver, paramBundle);
      PluginManagerHelper.getPluginInterface(this, this);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.w("QZoneLiveVideoDownloadActivity", 1, "", paramBundle);
      }
    }
  }
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    if (paramPluginManagerClient == null)
    {
      QZLog.w("QZoneLiveVideoDownloadActivity", "[onPluginManagerLoaded] pInterface is null");
      paramPluginManagerClient = BaseApplicationImpl.getContext().getString(2131716822);
      QQToast.a(BaseApplicationImpl.getContext(), paramPluginManagerClient, 1).a();
      return;
    }
    this.mPluginManager = paramPluginManagerClient;
    if (this.mPluginManager.isPluginInstalled(getPluginid()))
    {
      QLog.d("QZoneLiveVideoDownloadActivity", 2, "[onPluginManagerLoaded] plugin installed already");
      launchLiveVideo();
      return;
    }
    paramPluginManagerClient = this.mPluginManager.queryPlugin(getPluginid());
    if (paramPluginManagerClient == null)
    {
      QLog.w("QZoneLiveVideoDownloadActivity", 2, "[onPluginManagerLoaded] PluginBaseInfo is null, isReady=" + this.mPluginManager.isReady());
      paramPluginManagerClient = BaseApplicationImpl.getContext().getString(2131716822);
      QQToast.a(BaseApplicationImpl.getContext(), paramPluginManagerClient, 1).a();
      return;
    }
    if (QZLog.isColorLevel()) {
      QZLog.d("QZoneLiveVideoDownloadActivity", 2, "[onPluginManagerLoaded] plugin state=" + paramPluginManagerClient.mState);
    }
    if (2 == paramPluginManagerClient.mState)
    {
      QLog.d("QZoneLiveVideoDownloadActivity", 2, "[onPluginManagerLoaded] plugin downloaded, continue to install");
      this.mPluginManager.installPlugin(getPluginid());
      return;
    }
    QLog.d("QZoneLiveVideoDownloadActivity", 2, "[onPluginManagerLoaded] plugin not downloaded");
    LpReportInfo_dc01500.reportLaunch(getPluginid(), "", (System.currentTimeMillis() - this.mLaunchTime) / 1000.0D, 7, this.mMode + "");
    if ((3 == this.mMode) && (!TextUtils.isEmpty(this.mBackupUrl)) && (HttpUtil.isValidUrl(this.mBackupUrl)))
    {
      paramPluginManagerClient = this.mBackupUrl + "&stayin=1";
      QLog.d("QZoneLiveVideoDownloadActivity", 1, "watch mode, jump to H5, " + paramPluginManagerClient);
      QZoneHelper.forwardToBrowser(this, paramPluginManagerClient, -1, null, null);
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
    QLog.d("QZoneLiveVideoDownloadActivity", 1, "network type = " + i);
    if ((2 != i) && (i != 0))
    {
      installPlugin();
      return;
    }
    paramPluginManagerClient = Message.obtain();
    paramPluginManagerClient.what = 1000;
    paramPluginManagerClient.arg1 = 1;
    this.mHandler.sendMessage(paramPluginManagerClient);
  }
  
  protected PluginBaseInfo queryPlugin(String paramString)
  {
    return this.mPluginManager.queryPlugin(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */