package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import blvy;
import blwh;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

public class QzoneVideoPluginProxyService
  extends PluginProxyService
{
  public static void bindService(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection)
  {
    paramIntent.putExtra("useSkinEngine", 1);
    blwh localblwh = new blwh(0);
    localblwh.b = "qzone_plugin.apk";
    localblwh.d = "QZone";
    localblwh.jdField_a_of_type_JavaLangString = paramString;
    localblwh.e = "com.qzone.video.service.QzoneVideoPluginService";
    localblwh.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localblwh.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    blvy.c(paramContext, localblwh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */