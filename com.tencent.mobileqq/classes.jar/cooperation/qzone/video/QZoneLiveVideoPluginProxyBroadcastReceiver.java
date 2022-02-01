package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
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
    if (TextUtils.isEmpty(paramString2))
    {
      paramContext = new StringBuilder();
      paramContext.append("启动失败 错误的pluginid=");
      paramContext.append(paramString2);
      QLog.e("PluginDebug", 1, paramContext.toString());
      return;
    }
    if (paramString2.equals("qzone_live_video_plugin_hack.apk"))
    {
      if ((new File(QZonePluginUtils.getPluginInstallDir(paramContext), paramString2).exists()) && (QLog.isColorLevel()))
      {
        paramContext = new StringBuilder();
        paramContext.append("sendBroadcast 加载动态包:hackPluginID:");
        paramContext.append(paramString2);
        QLog.d("PluginDebug", 2, paramContext.toString());
      }
    }
    else
    {
      if (!paramString2.equals("qzone_live_video_plugin.apk")) {
        break label194;
      }
      paramString2 = new IPluginManager.PluginParams(0);
      paramString2.b = "qzone_live_video_plugin.apk";
      paramString2.e = "QZoneLiveVideo";
      paramString2.jdField_a_of_type_JavaLangString = paramString1;
      paramString2.f = "com.qzone.adapter.livevideo.LiveVideoPluginPreloadBroadcastReceiver";
      paramString2.jdField_a_of_type_AndroidContentIntent = paramIntent;
      paramString2.b = "qzone_live_video_plugin.apk";
      paramString2.e = "QZoneLiveVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      IPluginManager.b(paramContext, paramString2);
    }
    return;
    label194:
    paramContext = new StringBuilder();
    paramContext.append("启动失败 错误的pluginid=");
    paramContext.append(paramString2);
    QLog.e("PluginDebug", 1, paramContext.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.video.QZoneLiveVideoPluginProxyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */