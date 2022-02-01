package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public class QzoneVideoPluginProxyService
  extends PluginProxyService
{
  public static void bindService(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection)
  {
    paramIntent.putExtra("useSkinEngine", 1);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.d = "qzone_plugin.apk";
    localPluginParams.g = "QZone";
    localPluginParams.c = paramString;
    localPluginParams.h = "com.qzone.video.service.QzoneVideoPluginService";
    localPluginParams.j = paramIntent;
    localPluginParams.o = paramServiceConnection;
    IPluginManager.c(paramContext, localPluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */