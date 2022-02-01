package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import blvy;
import blwh;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;
import cooperation.qzone.plugin.QZonePluginUtils;
import java.io.File;

public class QZoneLiveVideoPluginProxyBroadcastReceiver
  extends PluginProxyBroadcastReceiver
{
  public static final String TAG = "QZoneLiveVideoPluginProxyBroadcastReceiver";
  
  public static void sendBroadcast(Context paramContext, String paramString1, Intent paramIntent, String paramString2)
  {
    paramIntent.putExtra("useSkinEngine", -1);
    paramString2 = QZonePluginUtils.getLoadQZoneLivePluginId();
    if (TextUtils.isEmpty(paramString2)) {
      QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + paramString2);
    }
    do
    {
      return;
      if (!paramString2.equals("qzone_live_video_plugin_hack.apk")) {
        break;
      }
    } while (!new File(QZonePluginUtils.getPluginInstallDir(paramContext), paramString2).exists());
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "sendBroadcast 加载动态包:hackPluginID:" + paramString2);
    }
    IQZonePluginManager.PluginParams localPluginParams = new IQZonePluginManager.PluginParams(0);
    localPluginParams.mPluginID = "qzone_live_video_plugin_hack.apk";
    localPluginParams.mPluginName = "QZoneLiveVideo";
    localPluginParams.mUin = paramString1;
    localPluginParams.mConponentName = "com.qzone.adapter.livevideo.LiveVideoPluginPreloadBroadcastReceiver";
    localPluginParams.mIntent = paramIntent;
    localPluginParams.mPluginID = paramString2;
    localPluginParams.mPluginName = "QZoneLiveVideo";
    IQZonePluginManager.launchPluginBroadcast(paramContext, localPluginParams);
    return;
    if (paramString2.equals("qzone_live_video_plugin.apk"))
    {
      paramString2 = new blwh(0);
      paramString2.b = "qzone_live_video_plugin.apk";
      paramString2.d = "QZoneLiveVideo";
      paramString2.jdField_a_of_type_JavaLangString = paramString1;
      paramString2.e = "com.qzone.adapter.livevideo.LiveVideoPluginPreloadBroadcastReceiver";
      paramString2.jdField_a_of_type_AndroidContentIntent = paramIntent;
      paramString2.b = "qzone_live_video_plugin.apk";
      paramString2.d = "QZoneLiveVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      blvy.b(paramContext, paramString2);
      return;
    }
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.video.QZoneLiveVideoPluginProxyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */