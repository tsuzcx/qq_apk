package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import bmgk;
import bmgt;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

public class QzoneVideoPluginProxyService
  extends PluginProxyService
{
  public static void a(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection)
  {
    paramIntent.putExtra("useSkinEngine", 1);
    bmgt localbmgt = new bmgt(0);
    localbmgt.b = "qzone_plugin.apk";
    localbmgt.d = "QZone";
    localbmgt.jdField_a_of_type_JavaLangString = paramString;
    localbmgt.e = "com.qzone.video.service.QzoneVideoPluginService";
    localbmgt.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbmgt.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bmgk.c(paramContext, localbmgt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */