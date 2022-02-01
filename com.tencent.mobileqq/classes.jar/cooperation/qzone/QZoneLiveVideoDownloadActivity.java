package cooperation.qzone;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
  
  protected String getPluginid()
  {
    return "qzone_live_video_plugin.apk";
  }
  
  protected void installPlugin()
  {
    super.installPlugin();
    PluginManagerClient localPluginManagerClient = this.mPluginManager;
    if (localPluginManagerClient == null)
    {
      QZLog.e("QZoneLiveVideoDownloadActivity", "[installPlugin] mPluginManager is null");
      return;
    }
    localPluginManagerClient.installPlugin(getPluginid());
  }
  
  protected void installPluginSilence()
  {
    QLog.d("QZoneLiveVideoDownloadActivity", 1, "installPluginSilence");
    this.mPluginManager.installPlugin(getPluginid());
  }
  
  protected void onCreate(Bundle paramBundle)
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
    }
    catch (Exception paramBundle)
    {
      QLog.w("QZoneLiveVideoDownloadActivity", 1, "", paramBundle);
    }
    PluginManagerHelper.getPluginInterface(this, this);
  }
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    if (paramPluginManagerClient == null)
    {
      QZLog.w("QZoneLiveVideoDownloadActivity", "[onPluginManagerLoaded] pInterface is null");
      paramPluginManagerClient = BaseApplicationImpl.getContext().getString(2131717339);
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
      paramPluginManagerClient = new StringBuilder();
      paramPluginManagerClient.append("[onPluginManagerLoaded] PluginBaseInfo is null, isReady=");
      paramPluginManagerClient.append(this.mPluginManager.isReady());
      QLog.w("QZoneLiveVideoDownloadActivity", 2, paramPluginManagerClient.toString());
      paramPluginManagerClient = BaseApplicationImpl.getContext().getString(2131717339);
      QQToast.a(BaseApplicationImpl.getContext(), paramPluginManagerClient, 1).a();
      return;
    }
    if (QZLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onPluginManagerLoaded] plugin state=");
      localStringBuilder.append(paramPluginManagerClient.mState);
      QZLog.d("QZoneLiveVideoDownloadActivity", 2, localStringBuilder.toString());
    }
    if (2 == paramPluginManagerClient.mState)
    {
      QLog.d("QZoneLiveVideoDownloadActivity", 2, "[onPluginManagerLoaded] plugin downloaded, continue to install");
      this.mPluginManager.installPlugin(getPluginid());
      return;
    }
    QLog.d("QZoneLiveVideoDownloadActivity", 2, "[onPluginManagerLoaded] plugin not downloaded");
    paramPluginManagerClient = getPluginid();
    double d = System.currentTimeMillis() - this.mLaunchTime;
    Double.isNaN(d);
    d /= 1000.0D;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mMode);
    localStringBuilder.append("");
    LpReportInfo_dc01500.reportLaunch(paramPluginManagerClient, "", d, 7, localStringBuilder.toString());
    if ((3 == this.mMode) && (!TextUtils.isEmpty(this.mBackupUrl)) && (HttpUtil.isValidUrl(this.mBackupUrl)))
    {
      paramPluginManagerClient = new StringBuilder();
      paramPluginManagerClient.append(this.mBackupUrl);
      paramPluginManagerClient.append("&stayin=1");
      paramPluginManagerClient = paramPluginManagerClient.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("watch mode, jump to H5, ");
      localStringBuilder.append(paramPluginManagerClient);
      QLog.d("QZoneLiveVideoDownloadActivity", 1, localStringBuilder.toString());
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
    paramPluginManagerClient = new StringBuilder();
    paramPluginManagerClient.append("network type = ");
    paramPluginManagerClient.append(i);
    QLog.d("QZoneLiveVideoDownloadActivity", 1, paramPluginManagerClient.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */