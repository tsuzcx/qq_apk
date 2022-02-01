package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import cooperation.qzone.plugin.QZonePluginUtils;

public class QZoneLiveVideoPluginScreenRecordProxyService
  extends PluginProxyService
{
  public static final String LIVE_VIDEO_FLOAT_SERVICE_ACTION = "com.qzone.LiveVideoScreenRecordPluginService";
  
  public static void startLiveVideoFloatService(Context paramContext, String paramString, Bundle paramBundle, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent(paramContext, QZoneLiveVideoPluginScreenRecordProxyService.class);
    localIntent.setAction("com.qzone.LiveVideoScreenRecordPluginService");
    localIntent.putExtras(paramBundle);
    QZoneLiveVideoPluginProxyService.bindService(paramContext, paramString, localIntent, paramServiceConnection, QZonePluginUtils.getLoadQZoneLivePluginId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.video.QZoneLiveVideoPluginScreenRecordProxyService
 * JD-Core Version:    0.7.0.1
 */