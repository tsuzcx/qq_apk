package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import biqn;
import biqw;
import bjoa;
import bjog;
import bjpz;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QZoneLiveVideoPluginProxyBroadcastReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void a(Context paramContext, String paramString1, Intent paramIntent, String paramString2)
  {
    paramIntent.putExtra("useSkinEngine", -1);
    paramString2 = bjpz.a();
    if (TextUtils.isEmpty(paramString2)) {
      QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + paramString2);
    }
    do
    {
      return;
      if (!paramString2.equals("qzone_live_video_plugin_hack.apk")) {
        break;
      }
    } while (!new File(bjpz.a(paramContext), paramString2).exists());
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "sendBroadcast 加载动态包:hackPluginID:" + paramString2);
    }
    bjog localbjog = new bjog(0);
    localbjog.b = "qzone_live_video_plugin_hack.apk";
    localbjog.d = "QZoneLiveVideo";
    localbjog.jdField_a_of_type_JavaLangString = paramString1;
    localbjog.e = "com.qzone.adapter.livevideo.LiveVideoPluginPreloadBroadcastReceiver";
    localbjog.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbjog.b = paramString2;
    localbjog.d = "QZoneLiveVideo";
    bjoa.b(paramContext, localbjog);
    return;
    if (paramString2.equals("qzone_live_video_plugin.apk"))
    {
      paramString2 = new biqw(0);
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
      biqn.b(paramContext, paramString2);
      return;
    }
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.video.QZoneLiveVideoPluginProxyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */