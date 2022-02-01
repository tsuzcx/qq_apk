package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import bkkq;
import bkkz;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;
import cooperation.qzone.plugin.QZonePluginUtils;
import java.io.File;

public class QZoneLiveVideoPluginProxyService
  extends PluginProxyService
{
  public static final String PRELOAD_ACTION = "com.qzone.preloadLiveVideo";
  
  public static void bindService(Context paramContext, String paramString1, Intent paramIntent, ServiceConnection paramServiceConnection, String paramString2)
  {
    paramIntent.putExtra("useSkinEngine", -1);
    Object localObject1 = QZonePluginUtils.getLoadQZoneLivePluginId();
    Object localObject2 = paramIntent.getAction();
    paramString2 = "";
    if ("com.qzone.preloadLiveVideo".equals(localObject2)) {
      paramString2 = "com.qzone.adapter.livevideo.LiveVideoPreloadPluginService";
    }
    do
    {
      while (TextUtils.isEmpty(paramString2))
      {
        QLog.e("PluginDebug", 1, "启动失败 conponentName 为空");
        return;
        if ("com.qzone.LiveVideoScreenRecordPluginService".equals(localObject2)) {
          paramString2 = "com.qzone.livevideo.service.LiveVideoScreenRecordPluginService";
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject1);
        return;
      }
      if (!((String)localObject1).equals("qzone_live_video_plugin_hack.apk")) {
        break;
      }
      localObject2 = new File(QZonePluginUtils.getPluginInstallDir(paramContext), (String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "bindService 加载动态包:hackPluginID:" + (String)localObject1);
      }
    } while (!((File)localObject2).exists());
    localObject2 = new IQZonePluginManager.PluginParams(0);
    ((IQZonePluginManager.PluginParams)localObject2).mPluginID = "qzone_live_video_plugin_hack.apk";
    ((IQZonePluginManager.PluginParams)localObject2).mPluginName = "QZoneLiveVideo";
    ((IQZonePluginManager.PluginParams)localObject2).mUin = paramString1;
    ((IQZonePluginManager.PluginParams)localObject2).mConponentName = paramString2;
    ((IQZonePluginManager.PluginParams)localObject2).mIntent = paramIntent;
    ((IQZonePluginManager.PluginParams)localObject2).mServiceConnection = paramServiceConnection;
    ((IQZonePluginManager.PluginParams)localObject2).mPluginID = ((String)localObject1);
    ((IQZonePluginManager.PluginParams)localObject2).mPluginName = "QZoneLiveVideo";
    IQZonePluginManager.launchPluginService(paramContext, (IQZonePluginManager.PluginParams)localObject2);
    return;
    if (((String)localObject1).equals("qzone_live_video_plugin.apk"))
    {
      localObject1 = new bkkz(0);
      ((bkkz)localObject1).b = "qzone_live_video_plugin.apk";
      ((bkkz)localObject1).d = "QZoneLiveVideo";
      ((bkkz)localObject1).jdField_a_of_type_JavaLangString = paramString1;
      ((bkkz)localObject1).e = paramString2;
      ((bkkz)localObject1).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((bkkz)localObject1).jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
      ((bkkz)localObject1).b = "qzone_live_video_plugin.apk";
      ((bkkz)localObject1).d = "QZoneLiveVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      bkkq.c(paramContext, (bkkz)localObject1);
      return;
    }
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.video.QZoneLiveVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */