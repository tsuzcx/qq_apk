package cooperation.liveroom;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import java.lang.ref.WeakReference;

public class LiveRoomPluginInstaller
{
  private static LiveRoomPluginInstaller INSTANCE;
  private static final String TAG = "LiveRoomPluginInstaller";
  private WeakReference<OnPluginInstallListener> mInstallistener;
  private boolean pluginDownloading;
  
  public static LiveRoomPluginInstaller getInstance()
  {
    if (INSTANCE == null) {}
    try
    {
      if (INSTANCE == null) {
        INSTANCE = new LiveRoomPluginInstaller();
      }
      return INSTANCE;
    }
    finally {}
  }
  
  private boolean hasInstallListener()
  {
    return (this.mInstallistener != null) && (this.mInstallistener.get() != null);
  }
  
  public static void release()
  {
    INSTANCE = null;
  }
  
  public void installFromQQ(OnPluginInstallListener paramOnPluginInstallListener, String paramString)
  {
    this.mInstallistener = new WeakReference(paramOnPluginInstallListener);
    if (this.pluginDownloading) {}
    PluginInfo localPluginInfo;
    do
    {
      return;
      QLog.i("LiveRoomPluginInstaller", 1, "start download LiveRoomPlugin in QQ");
      paramOnPluginInstallListener = LiveRoomHelper.getPluginManagerInQQ();
      if (paramOnPluginInstallListener == null)
      {
        QLog.e("LiveRoomPluginInstaller", 1, "PluginManager is NOT ready");
        return;
      }
      localPluginInfo = LiveRoomHelper.getPluginInfoInQQ();
    } while ((localPluginInfo != null) && (localPluginInfo.mState != 0) && (localPluginInfo.mState != -2) && (localPluginInfo.mState != -1));
    LiveRoomHelper.startTime = NetConnInfoCenter.getServerTimeMillis();
    LiveRoomHelper.report(paramString, "install", "start", 0L);
    this.pluginDownloading = true;
    ThreadManager.executeOnNetWorkThread(new LiveRoomPluginInstaller.2(this, paramOnPluginInstallListener, paramString));
  }
  
  public void installFromTool(Context paramContext, String paramString)
  {
    if (this.pluginDownloading) {
      return;
    }
    PluginManagerHelper.getPluginInterface(paramContext.getApplicationContext(), new LiveRoomPluginInstaller.1(this, paramString));
  }
  
  public void installFromTool(PluginManagerClient paramPluginManagerClient, String paramString)
  {
    if (this.pluginDownloading) {
      return;
    }
    this.pluginDownloading = true;
    QLog.i("LiveRoomPluginInstaller", 1, "start download LiveRoomPlugin in tool 1");
    LiveRoomHelper.startTime = NetConnInfoCenter.getServerTimeMillis();
    LiveRoomHelper.report(paramString, "install", "start", 0L);
    paramPluginManagerClient.installPlugin("LiveRoomPlugin.apk", new LiveRoomPluginInstaller.MyOnPluginInstallListener(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomPluginInstaller
 * JD-Core Version:    0.7.0.1
 */