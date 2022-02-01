package cooperation.plugin;

import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;

class PluginManagerV2$OnPluginDownLoadListenerTransfer
  implements OnPluginInstallListener
{
  private PluginDownloader.OnPluginDownLoadListener a;
  
  public PluginManagerV2$OnPluginDownLoadListenerTransfer(PluginDownloader.OnPluginDownLoadListener paramOnPluginDownLoadListener)
  {
    this.a = paramOnPluginDownLoadListener;
  }
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (this.a != null) {
      this.a.b(paramString);
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      this.a.a(paramInt1, paramInt2, paramString);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (this.a != null) {
      this.a.a(false, paramString);
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (this.a != null) {
      this.a.a(true, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.PluginManagerV2.OnPluginDownLoadListenerTransfer
 * JD-Core Version:    0.7.0.1
 */