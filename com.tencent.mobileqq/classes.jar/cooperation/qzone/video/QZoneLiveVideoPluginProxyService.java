package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.plugin.QZonePluginUtils;
import java.io.File;

public class QZoneLiveVideoPluginProxyService
  extends PluginProxyService
{
  public static final String PRELOAD_ACTION = "com.qzone.preloadLiveVideo";
  
  public static void bindService(Context paramContext, String paramString1, Intent paramIntent, ServiceConnection paramServiceConnection, String paramString2)
  {
    paramIntent.putExtra("useSkinEngine", -1);
    Object localObject = QZonePluginUtils.getLoadQZoneLivePluginId();
    paramString2 = paramIntent.getAction();
    if ("com.qzone.preloadLiveVideo".equals(paramString2)) {
      paramString2 = "com.qzone.adapter.livevideo.LiveVideoPreloadPluginService";
    } else if ("com.qzone.LiveVideoScreenRecordPluginService".equals(paramString2)) {
      paramString2 = "com.qzone.livevideo.service.LiveVideoScreenRecordPluginService";
    } else {
      paramString2 = "";
    }
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("PluginDebug", 1, "启动失败 conponentName 为空");
      return;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramContext = new StringBuilder();
      paramContext.append("启动失败 错误的pluginid=");
      paramContext.append((String)localObject);
      QLog.e("PluginDebug", 1, paramContext.toString());
      return;
    }
    if (((String)localObject).equals("qzone_live_video_plugin_hack.apk"))
    {
      paramContext = new File(QZonePluginUtils.getPluginInstallDir(paramContext), (String)localObject);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("bindService 加载动态包:hackPluginID:");
        paramString1.append((String)localObject);
        QLog.d("PluginDebug", 2, paramString1.toString());
      }
      paramContext.exists();
      return;
    }
    if (((String)localObject).equals("qzone_live_video_plugin.apk"))
    {
      localObject = new IPluginManager.PluginParams(0);
      ((IPluginManager.PluginParams)localObject).b = "qzone_live_video_plugin.apk";
      ((IPluginManager.PluginParams)localObject).e = "QZoneLiveVideo";
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramString1;
      ((IPluginManager.PluginParams)localObject).f = paramString2;
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
      ((IPluginManager.PluginParams)localObject).b = "qzone_live_video_plugin.apk";
      ((IPluginManager.PluginParams)localObject).e = "QZoneLiveVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      IPluginManager.c(paramContext, (IPluginManager.PluginParams)localObject);
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("启动失败 错误的pluginid=");
    paramContext.append((String)localObject);
    QLog.e("PluginDebug", 1, paramContext.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.video.QZoneLiveVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */