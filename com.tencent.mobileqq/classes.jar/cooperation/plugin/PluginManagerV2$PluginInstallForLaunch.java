package cooperation.plugin;

import android.app.ProgressDialog;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;

class PluginManagerV2$PluginInstallForLaunch
  extends OnPluginInstallListener.Stub
{
  long jdField_a_of_type_Long = 0L;
  private PluginManagerV2.LaunchState jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState;
  
  public PluginManagerV2$PluginInstallForLaunch(PluginManagerV2 paramPluginManagerV2, PluginManagerV2.LaunchState paramLaunchState)
  {
    this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState = paramLaunchState;
  }
  
  public void onInstallBegin(String paramString)
  {
    QLog.d("plugin_tag", 1, "onInstallBegin." + paramString);
    if ((!this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallDownloadProgress." + paramString);
    }
    if ((!this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog != null))
    {
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog.setMax(paramInt2);
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog.setProgress(paramInt1);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    boolean bool = true;
    QLog.d("plugin_tag", 1, "onInstallError." + paramString + "," + paramInt);
    PluginManagerV2.LaunchState localLaunchState = this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState;
    if ((localLaunchState != null) && (localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener != null))
    {
      paramString = this.jdField_a_of_type_CooperationPluginPluginManagerV2.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.d = paramString.mInstalledPath;
      }
      paramString = localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener;
      if (paramInt != 2) {
        break label116;
      }
    }
    for (;;)
    {
      paramString.a(bool, localLaunchState.jdField_a_of_type_AndroidContentContext, localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
      return;
      label116:
      bool = false;
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    long l = 0L;
    QLog.d("plugin_tag", 1, "onInstallFinish." + paramString);
    paramString = this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState;
    if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      paramString.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
    if ((paramString != null) && (paramString.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener != null))
    {
      PluginInfo localPluginInfo = PluginManagerV2.a(this.jdField_a_of_type_CooperationPluginPluginManagerV2).a(paramString.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.b);
      if ((localPluginInfo != null) && (localPluginInfo.mInstalledPath != null))
      {
        paramString.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.d = localPluginInfo.mInstalledPath;
        paramString.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.a(localPluginInfo);
      }
      paramString.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
    }
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_CooperationPluginPluginManagerV2.a(this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.b, "pluginDownloadCost", l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.PluginManagerV2.PluginInstallForLaunch
 * JD-Core Version:    0.7.0.1
 */