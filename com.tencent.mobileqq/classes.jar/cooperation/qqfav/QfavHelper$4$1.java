package cooperation.qqfav;

import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;

class QfavHelper$4$1
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  QfavHelper$4$1(QfavHelper.4 param4) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    try
    {
      if (!paramPluginManagerClient.isPluginInstalled("qqfav.apk"))
      {
        if (this.a.b == null)
        {
          paramPluginManagerClient.installPlugin("qqfav.apk");
          return;
        }
        paramPluginManagerClient.installPlugin("qqfav.apk", this.a.b);
        return;
      }
      paramPluginManagerClient = this.a.b;
      if (paramPluginManagerClient == null) {
        break label104;
      }
      try
      {
        this.a.b.onInstallFinish("qqfav.apk");
        return;
      }
      catch (RemoteException paramPluginManagerClient)
      {
        paramPluginManagerClient.printStackTrace();
        return;
      }
    }
    catch (Exception paramPluginManagerClient)
    {
      label73:
      label104:
      break label73;
    }
    if (this.a.b != null) {
      try
      {
        this.a.b.onInstallError("qqfav.apk", -1);
        return;
      }
      catch (RemoteException paramPluginManagerClient)
      {
        paramPluginManagerClient.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.QfavHelper.4.1
 * JD-Core Version:    0.7.0.1
 */