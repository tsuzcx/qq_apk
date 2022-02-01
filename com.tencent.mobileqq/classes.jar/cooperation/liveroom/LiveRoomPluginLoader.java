package cooperation.liveroom;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import mqq.app.AppRuntime;

public class LiveRoomPluginLoader
{
  private static final String TAG = "LiveRoomPluginLoader";
  
  public static void preLoadPlugin()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), LiveRoomProxyService.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("isPreloadProcess", true);
    localIntent.putExtra("preloadEntry", 9999);
    localIntent.putExtra("sendTime", SystemClock.elapsedRealtime());
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.d = "LiveRoomPlugin.apk";
    localPluginParams.g = "直播SDK";
    localPluginParams.c = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localPluginParams.h = "com.tencent.gamecontent.livesdkqqplugin.plugins.QQLiveRoomPluginService";
    localPluginParams.j = localIntent;
    if (QLog.isColorLevel()) {
      QLog.d("LiveRoomPluginLoader", 2, "[LiveRoomPluginLoader] launchPluginService");
    }
    IPluginManager.c(BaseApplicationImpl.getApplication(), localPluginParams);
  }
  
  public static void stopService()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    localBaseApplication.stopService(new Intent(localBaseApplication, LiveRoomProxyService.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomPluginLoader
 * JD-Core Version:    0.7.0.1
 */