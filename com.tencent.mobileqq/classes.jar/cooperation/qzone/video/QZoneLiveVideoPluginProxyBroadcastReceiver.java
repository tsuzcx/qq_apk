package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;
import cooperation.qzone.plugin.QZonePluginUtils;
import java.io.File;

public class QZoneLiveVideoPluginProxyBroadcastReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void a(Context paramContext, String paramString1, Intent paramIntent, String paramString2)
  {
    paramIntent.putExtra("useSkinEngine", -1);
    if ("qzone_vertical_video_plugin.apk".equals(paramString2)) {
      if (QzoneVerticalVideoDownloadActivity.a())
      {
        localObject = new IPluginManager.PluginParams(0);
        ((IPluginManager.PluginParams)localObject).b = "qzone_vertical_video_plugin.apk";
        ((IPluginManager.PluginParams)localObject).d = "QZoneVerticalVideo";
        ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramString1;
        ((IPluginManager.PluginParams)localObject).e = "com.qzone.verticalvideo.app.QZoneVerticalVideoPreloadBroadcastReceiver";
        ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
        QLog.i("PluginDebug", 1, "sendBroadcast 加载原始插件:" + paramString2);
        IPluginManager.a(paramContext, (IPluginManager.PluginParams)localObject);
      }
    }
    do
    {
      do
      {
        return;
      } while (!new File(QZonePluginUtils.a(paramContext), paramString2).exists());
      QLog.i("PluginDebug", 1, "sendBroadcast 加载动态包:hackPluginID:" + paramString2);
      paramString2 = new IQZonePluginManager.PluginParams(0);
      paramString2.b = "qzone_vertical_video_plugin.apk";
      paramString2.d = "QZoneVerticalVideo";
      paramString2.jdField_a_of_type_JavaLangString = paramString1;
      paramString2.e = "com.qzone.verticalvideo.app.QZoneVerticalVideoPreloadBroadcastReceiver";
      paramString2.jdField_a_of_type_AndroidContentIntent = paramIntent;
      IQZonePluginManager.b(paramContext, paramString2);
      return;
      paramString2 = QZonePluginUtils.a();
      if (TextUtils.isEmpty(paramString2))
      {
        QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + paramString2);
        return;
      }
      if (!paramString2.equals("qzone_live_video_plugin_hack.apk")) {
        break;
      }
    } while (!new File(QZonePluginUtils.a(paramContext), paramString2).exists());
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "sendBroadcast 加载动态包:hackPluginID:" + paramString2);
    }
    Object localObject = new IQZonePluginManager.PluginParams(0);
    ((IQZonePluginManager.PluginParams)localObject).b = "qzone_live_video_plugin_hack.apk";
    ((IQZonePluginManager.PluginParams)localObject).d = "QZoneLiveVideo";
    ((IQZonePluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramString1;
    ((IQZonePluginManager.PluginParams)localObject).e = "com.qzone.adapter.livevideo.LiveVideoPluginPreloadBroadcastReceiver";
    ((IQZonePluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
    ((IQZonePluginManager.PluginParams)localObject).b = paramString2;
    ((IQZonePluginManager.PluginParams)localObject).d = "QZoneLiveVideo";
    IQZonePluginManager.b(paramContext, (IQZonePluginManager.PluginParams)localObject);
    return;
    if (paramString2.equals("qzone_live_video_plugin.apk"))
    {
      paramString2 = new IPluginManager.PluginParams(0);
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
      IPluginManager.a(paramContext, paramString2);
      return;
    }
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.QZoneLiveVideoPluginProxyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */