package cooperation.plugin;

import android.app.ProgressDialog;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;

class PluginManagerV2$PluginInstallForLaunch
  extends OnPluginInstallListener.Stub
{
  long jdField_a_of_type_Long = 0L;
  private PluginManagerV2.LaunchState jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState;
  boolean jdField_a_of_type_Boolean;
  
  public PluginManagerV2$PluginInstallForLaunch(PluginManagerV2 paramPluginManagerV2, PluginManagerV2.LaunchState paramLaunchState)
  {
    this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState = paramLaunchState;
  }
  
  public void onInstallBegin(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInstallBegin.");
    localStringBuilder.append(paramString);
    QLog.d("plugin_tag", 1, localStringBuilder.toString());
    if ((!this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInstallDownloadProgress.");
      localStringBuilder.append(paramString);
      QLog.d("plugin_tag", 2, localStringBuilder.toString());
    }
    if ((!this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog != null))
    {
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog.setMax(paramInt2);
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog.setProgress(paramInt1);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onInstallError.");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.d("plugin_tag", 1, (String)localObject);
    localObject = this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState;
    if ((localObject != null) && (((PluginManagerV2.LaunchState)localObject).jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener != null))
    {
      paramString = this.jdField_a_of_type_CooperationPluginPluginManagerV2.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        ((PluginManagerV2.LaunchState)localObject).jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.d = paramString.mInstalledPath;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        paramString = ((PluginManagerV2.LaunchState)localObject).jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener;
        if (paramInt != 2) {
          bool = false;
        }
        paramString.a(bool, ((PluginManagerV2.LaunchState)localObject).jdField_a_of_type_AndroidContentContext, ((PluginManagerV2.LaunchState)localObject).jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
      }
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onInstallFinish.");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("plugin_tag", 1, ((StringBuilder)localObject).toString());
    paramString = this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState;
    if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      paramString.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
    if ((paramString != null) && (paramString.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener != null))
    {
      localObject = PluginManagerV2.a(this.jdField_a_of_type_CooperationPluginPluginManagerV2).a(paramString.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.b);
      if ((localObject != null) && (((PluginInfo)localObject).mInstalledPath != null))
      {
        paramString.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.d = ((PluginInfo)localObject).mInstalledPath;
        paramString.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.a((PluginBaseInfo)localObject);
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        paramString.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
        PluginManagerV2.a(this.jdField_a_of_type_CooperationPluginPluginManagerV2, paramString.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
      }
    }
    long l2 = this.jdField_a_of_type_Long;
    long l1 = 0L;
    if (l2 != 0L) {
      l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_CooperationPluginPluginManagerV2.a(this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.b, "pluginDownloadCost", l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.PluginManagerV2.PluginInstallForLaunch
 * JD-Core Version:    0.7.0.1
 */