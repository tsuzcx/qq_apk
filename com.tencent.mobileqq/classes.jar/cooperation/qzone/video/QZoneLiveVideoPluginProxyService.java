package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;
import cooperation.qzone.plugin.QZonePluginUtils;
import java.io.File;

public class QZoneLiveVideoPluginProxyService
  extends PluginProxyService
{
  public static void a(Context paramContext, String paramString1, Intent paramIntent, ServiceConnection paramServiceConnection, String paramString2)
  {
    paramIntent.putExtra("useSkinEngine", -1);
    Object localObject1 = QZonePluginUtils.a();
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
      localObject2 = new File(QZonePluginUtils.a(paramContext), (String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "bindService 加载动态包:hackPluginID:" + (String)localObject1);
      }
    } while (!((File)localObject2).exists());
    localObject2 = new IQZonePluginManager.PluginParams(0);
    ((IQZonePluginManager.PluginParams)localObject2).b = "qzone_live_video_plugin_hack.apk";
    ((IQZonePluginManager.PluginParams)localObject2).d = "QZoneLiveVideo";
    ((IQZonePluginManager.PluginParams)localObject2).jdField_a_of_type_JavaLangString = paramString1;
    ((IQZonePluginManager.PluginParams)localObject2).e = paramString2;
    ((IQZonePluginManager.PluginParams)localObject2).jdField_a_of_type_AndroidContentIntent = paramIntent;
    ((IQZonePluginManager.PluginParams)localObject2).jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    ((IQZonePluginManager.PluginParams)localObject2).b = ((String)localObject1);
    ((IQZonePluginManager.PluginParams)localObject2).d = "QZoneLiveVideo";
    IQZonePluginManager.a(paramContext, (IQZonePluginManager.PluginParams)localObject2);
    return;
    if (((String)localObject1).equals("qzone_live_video_plugin.apk"))
    {
      localObject1 = new IPluginManager.PluginParams(0);
      ((IPluginManager.PluginParams)localObject1).b = "qzone_live_video_plugin.apk";
      ((IPluginManager.PluginParams)localObject1).d = "QZoneLiveVideo";
      ((IPluginManager.PluginParams)localObject1).jdField_a_of_type_JavaLangString = paramString1;
      ((IPluginManager.PluginParams)localObject1).e = paramString2;
      ((IPluginManager.PluginParams)localObject1).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((IPluginManager.PluginParams)localObject1).jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
      ((IPluginManager.PluginParams)localObject1).b = "qzone_live_video_plugin.apk";
      ((IPluginManager.PluginParams)localObject1).d = "QZoneLiveVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      IPluginManager.b(paramContext, (IPluginManager.PluginParams)localObject1);
      return;
    }
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.QZoneLiveVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */