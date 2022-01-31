package cooperation.qzone;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bizm;
import bjlh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import ndd;

public class QZoneLiveVideoDownloadActivity
  extends QZoneLiveVideoBaseDownLoadActivty
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public PluginManagerClient a;
  
  protected PluginBaseInfo a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin(paramString);
  }
  
  protected String a()
  {
    return "qzone_live_video_plugin.apk";
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null)
    {
      QZLog.e("QZoneLiveVideoDownloadActivity", "[installPlugin] mPluginManager is null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin(a());
  }
  
  protected void c()
  {
    QLog.d("QZoneLiveVideoDownloadActivity", 1, "installPluginSilence");
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin(a());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!a()) {
      return;
    }
    try
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_launch_completed");
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new QZoneLiveVideoBaseDownLoadActivty.LaunchCompletedObserver(this, "QZoneLiveVideo", "qzone_live_video_plugin.apk");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
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
      paramPluginManagerClient = BaseApplicationImpl.getContext().getString(2131718301);
      QQToast.a(BaseApplicationImpl.getContext(), paramPluginManagerClient, 1).a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient = paramPluginManagerClient;
    if (this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.isPluginInstalled(a()))
    {
      QLog.d("QZoneLiveVideoDownloadActivity", 2, "[onPluginManagerLoaded] plugin installed already");
      e();
      return;
    }
    paramPluginManagerClient = this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin(a());
    if (paramPluginManagerClient == null)
    {
      QLog.w("QZoneLiveVideoDownloadActivity", 2, "[onPluginManagerLoaded] PluginBaseInfo is null, isReady=" + this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.isReady());
      paramPluginManagerClient = BaseApplicationImpl.getContext().getString(2131718301);
      QQToast.a(BaseApplicationImpl.getContext(), paramPluginManagerClient, 1).a();
      return;
    }
    if (QZLog.isColorLevel()) {
      QZLog.d("QZoneLiveVideoDownloadActivity", 2, "[onPluginManagerLoaded] plugin state=" + paramPluginManagerClient.mState);
    }
    if (2 == paramPluginManagerClient.mState)
    {
      QLog.d("QZoneLiveVideoDownloadActivity", 2, "[onPluginManagerLoaded] plugin downloaded, continue to install");
      this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin(a());
      return;
    }
    QLog.d("QZoneLiveVideoDownloadActivity", 2, "[onPluginManagerLoaded] plugin not downloaded");
    LpReportInfo_dc01500.reportLaunch(a(), "", (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D, 7, this.c + "");
    if ((3 == this.c) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (ndd.a(this.jdField_a_of_type_JavaLangString)))
    {
      paramPluginManagerClient = this.jdField_a_of_type_JavaLangString + "&stayin=1";
      QLog.d("QZoneLiveVideoDownloadActivity", 1, "watch mode, jump to H5, " + paramPluginManagerClient);
      bizm.a(this, paramPluginManagerClient, -1, null, null);
      if (bjlh.b()) {
        c();
      }
      a();
      return;
    }
    if (1 == this.c) {
      LpReportInfo_dc00321.report(8, 128, 3, false, false, null);
    }
    int i = NetworkState.getNetworkType();
    QLog.d("QZoneLiveVideoDownloadActivity", 1, "network type = " + i);
    if ((2 != i) && (i != 0))
    {
      b();
      return;
    }
    paramPluginManagerClient = Message.obtain();
    paramPluginManagerClient.what = 1000;
    paramPluginManagerClient.arg1 = 1;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramPluginManagerClient);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */