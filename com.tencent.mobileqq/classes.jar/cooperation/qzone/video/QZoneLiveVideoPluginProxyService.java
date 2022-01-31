package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import bglh;
import bglq;
import bhii;
import bhio;
import bhkh;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QZoneLiveVideoPluginProxyService
  extends PluginProxyService
{
  public static void a(Context paramContext, String paramString1, Intent paramIntent, ServiceConnection paramServiceConnection, String paramString2)
  {
    paramIntent.putExtra("useSkinEngine", -1);
    Object localObject1 = bhkh.a();
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
      localObject2 = new File(bhkh.a(paramContext), (String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "bindService 加载动态包:hackPluginID:" + (String)localObject1);
      }
    } while (!((File)localObject2).exists());
    localObject2 = new bhio(0);
    ((bhio)localObject2).b = "qzone_live_video_plugin_hack.apk";
    ((bhio)localObject2).d = "QZoneLiveVideo";
    ((bhio)localObject2).jdField_a_of_type_JavaLangString = paramString1;
    ((bhio)localObject2).e = paramString2;
    ((bhio)localObject2).jdField_a_of_type_AndroidContentIntent = paramIntent;
    ((bhio)localObject2).jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    ((bhio)localObject2).b = ((String)localObject1);
    ((bhio)localObject2).d = "QZoneLiveVideo";
    bhii.a(paramContext, (bhio)localObject2);
    return;
    if (((String)localObject1).equals("qzone_live_video_plugin.apk"))
    {
      localObject1 = new bglq(0);
      ((bglq)localObject1).b = "qzone_live_video_plugin.apk";
      ((bglq)localObject1).d = "QZoneLiveVideo";
      ((bglq)localObject1).jdField_a_of_type_JavaLangString = paramString1;
      ((bglq)localObject1).e = paramString2;
      ((bglq)localObject1).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((bglq)localObject1).jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
      ((bglq)localObject1).b = "qzone_live_video_plugin.apk";
      ((bglq)localObject1).d = "QZoneLiveVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      bglh.c(paramContext, (bglq)localObject1);
      return;
    }
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.QZoneLiveVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */