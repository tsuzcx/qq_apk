package cooperation.liveroom;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import bimg;
import bimp;
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
    bimp localbimp = new bimp(1);
    localbimp.b = "LiveRoomPlugin.apk";
    localbimp.d = "直播SDK";
    localbimp.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localbimp.e = "com.tencent.gamecontent.livesdkqqplugin.plugins.QQLiveRoomPluginService";
    localbimp.jdField_a_of_type_AndroidContentIntent = localIntent;
    if (QLog.isColorLevel()) {
      QLog.d("LiveRoomPluginLoader", 2, "[LiveRoomPluginLoader] launchPluginService");
    }
    bimg.c(BaseApplicationImpl.getApplication(), localbimp);
  }
  
  public static void stopService()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    localBaseApplication.stopService(new Intent(localBaseApplication, LiveRoomProxyService.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomPluginLoader
 * JD-Core Version:    0.7.0.1
 */