package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import bkkq;
import bkkz;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

public class QzoneVideoPluginProxyService
  extends PluginProxyService
{
  public static void bindService(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection)
  {
    paramIntent.putExtra("useSkinEngine", 1);
    bkkz localbkkz = new bkkz(0);
    localbkkz.b = "qzone_plugin.apk";
    localbkkz.d = "QZone";
    localbkkz.jdField_a_of_type_JavaLangString = paramString;
    localbkkz.e = "com.qzone.video.service.QzoneVideoPluginService";
    localbkkz.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbkkz.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bkkq.c(paramContext, localbkkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */