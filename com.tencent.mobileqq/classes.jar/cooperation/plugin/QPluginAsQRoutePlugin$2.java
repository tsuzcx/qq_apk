package cooperation.plugin;

import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.qroute.module.IQRoutePluginInstallListener;

class QPluginAsQRoutePlugin$2
  implements OnPluginInstallListener
{
  QPluginAsQRoutePlugin$2(QPluginAsQRoutePlugin paramQPluginAsQRoutePlugin, IQRoutePluginInstallListener paramIQRoutePluginInstallListener) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqQrouteModuleIQRoutePluginInstallListener.onInstallBegin(paramString);
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqQrouteModuleIQRoutePluginInstallListener.onInstallDownloadProgress(paramString, paramInt1, paramInt2);
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqQrouteModuleIQRoutePluginInstallListener.onInstallError(paramString, paramInt);
  }
  
  public void onInstallFinish(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqQrouteModuleIQRoutePluginInstallListener.onInstallFinish(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.QPluginAsQRoutePlugin.2
 * JD-Core Version:    0.7.0.1
 */