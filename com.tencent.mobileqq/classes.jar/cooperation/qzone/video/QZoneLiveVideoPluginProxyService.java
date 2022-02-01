package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import blfh;
import blfq;
import bmcj;
import bmcp;
import bmei;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QZoneLiveVideoPluginProxyService
  extends PluginProxyService
{
  public static void a(Context paramContext, String paramString1, Intent paramIntent, ServiceConnection paramServiceConnection, String paramString2)
  {
    paramIntent.putExtra("useSkinEngine", -1);
    Object localObject1 = bmei.a();
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
      localObject2 = new File(bmei.a(paramContext), (String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "bindService 加载动态包:hackPluginID:" + (String)localObject1);
      }
    } while (!((File)localObject2).exists());
    localObject2 = new bmcp(0);
    ((bmcp)localObject2).b = "qzone_live_video_plugin_hack.apk";
    ((bmcp)localObject2).d = "QZoneLiveVideo";
    ((bmcp)localObject2).jdField_a_of_type_JavaLangString = paramString1;
    ((bmcp)localObject2).e = paramString2;
    ((bmcp)localObject2).jdField_a_of_type_AndroidContentIntent = paramIntent;
    ((bmcp)localObject2).jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    ((bmcp)localObject2).b = ((String)localObject1);
    ((bmcp)localObject2).d = "QZoneLiveVideo";
    bmcj.a(paramContext, (bmcp)localObject2);
    return;
    if (((String)localObject1).equals("qzone_live_video_plugin.apk"))
    {
      localObject1 = new blfq(0);
      ((blfq)localObject1).b = "qzone_live_video_plugin.apk";
      ((blfq)localObject1).d = "QZoneLiveVideo";
      ((blfq)localObject1).jdField_a_of_type_JavaLangString = paramString1;
      ((blfq)localObject1).e = paramString2;
      ((blfq)localObject1).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((blfq)localObject1).jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
      ((blfq)localObject1).b = "qzone_live_video_plugin.apk";
      ((blfq)localObject1).d = "QZoneLiveVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      blfh.c(paramContext, (blfq)localObject1);
      return;
    }
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.video.QZoneLiveVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */