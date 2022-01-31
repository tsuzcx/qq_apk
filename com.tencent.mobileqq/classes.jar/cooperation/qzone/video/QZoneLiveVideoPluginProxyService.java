package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import bimg;
import bimp;
import bjjt;
import bjjz;
import bjls;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QZoneLiveVideoPluginProxyService
  extends PluginProxyService
{
  public static void a(Context paramContext, String paramString1, Intent paramIntent, ServiceConnection paramServiceConnection, String paramString2)
  {
    paramIntent.putExtra("useSkinEngine", -1);
    Object localObject1 = bjls.a();
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
      localObject2 = new File(bjls.a(paramContext), (String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "bindService 加载动态包:hackPluginID:" + (String)localObject1);
      }
    } while (!((File)localObject2).exists());
    localObject2 = new bjjz(0);
    ((bjjz)localObject2).b = "qzone_live_video_plugin_hack.apk";
    ((bjjz)localObject2).d = "QZoneLiveVideo";
    ((bjjz)localObject2).jdField_a_of_type_JavaLangString = paramString1;
    ((bjjz)localObject2).e = paramString2;
    ((bjjz)localObject2).jdField_a_of_type_AndroidContentIntent = paramIntent;
    ((bjjz)localObject2).jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    ((bjjz)localObject2).b = ((String)localObject1);
    ((bjjz)localObject2).d = "QZoneLiveVideo";
    bjjt.a(paramContext, (bjjz)localObject2);
    return;
    if (((String)localObject1).equals("qzone_live_video_plugin.apk"))
    {
      localObject1 = new bimp(0);
      ((bimp)localObject1).b = "qzone_live_video_plugin.apk";
      ((bimp)localObject1).d = "QZoneLiveVideo";
      ((bimp)localObject1).jdField_a_of_type_JavaLangString = paramString1;
      ((bimp)localObject1).e = paramString2;
      ((bimp)localObject1).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((bimp)localObject1).jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
      ((bimp)localObject1).b = "qzone_live_video_plugin.apk";
      ((bimp)localObject1).d = "QZoneLiveVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      bimg.c(paramContext, (bimp)localObject1);
      return;
    }
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.video.QZoneLiveVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */