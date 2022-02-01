package cooperation.liveroom;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import blvy;
import blwh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
    blwh localblwh = new blwh(1);
    localblwh.b = "LiveRoomPlugin.apk";
    localblwh.d = "直播SDK";
    localblwh.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localblwh.e = "com.tencent.gamecontent.livesdkqqplugin.plugins.QQLiveRoomPluginService";
    localblwh.jdField_a_of_type_AndroidContentIntent = localIntent;
    if (QLog.isColorLevel()) {
      QLog.d("LiveRoomPluginLoader", 2, "[LiveRoomPluginLoader] launchPluginService");
    }
    blvy.c(BaseApplicationImpl.getApplication(), localblwh);
  }
  
  public static void stopService()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    localBaseApplication.stopService(new Intent(localBaseApplication, LiveRoomProxyService.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomPluginLoader
 * JD-Core Version:    0.7.0.1
 */