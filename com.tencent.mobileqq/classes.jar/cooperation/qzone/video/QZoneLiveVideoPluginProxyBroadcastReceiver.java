package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import bglh;
import bglq;
import bhii;
import bhio;
import bhkh;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QZoneLiveVideoPluginProxyBroadcastReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void a(Context paramContext, String paramString1, Intent paramIntent, String paramString2)
  {
    paramIntent.putExtra("useSkinEngine", -1);
    paramString2 = bhkh.a();
    if (TextUtils.isEmpty(paramString2)) {
      QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + paramString2);
    }
    do
    {
      return;
      if (!paramString2.equals("qzone_live_video_plugin_hack.apk")) {
        break;
      }
    } while (!new File(bhkh.a(paramContext), paramString2).exists());
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "sendBroadcast 加载动态包:hackPluginID:" + paramString2);
    }
    bhio localbhio = new bhio(0);
    localbhio.b = "qzone_live_video_plugin_hack.apk";
    localbhio.d = "QZoneLiveVideo";
    localbhio.jdField_a_of_type_JavaLangString = paramString1;
    localbhio.e = "com.qzone.adapter.livevideo.LiveVideoPluginPreloadBroadcastReceiver";
    localbhio.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbhio.b = paramString2;
    localbhio.d = "QZoneLiveVideo";
    bhii.b(paramContext, localbhio);
    return;
    if (paramString2.equals("qzone_live_video_plugin.apk"))
    {
      paramString2 = new bglq(0);
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
      bglh.b(paramContext, paramString2);
      return;
    }
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.QZoneLiveVideoPluginProxyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */