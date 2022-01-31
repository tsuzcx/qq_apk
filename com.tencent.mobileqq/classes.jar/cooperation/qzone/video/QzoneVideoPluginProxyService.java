package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import biqn;
import biqw;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

public class QzoneVideoPluginProxyService
  extends PluginProxyService
{
  public static void a(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection)
  {
    paramIntent.putExtra("useSkinEngine", 1);
    biqw localbiqw = new biqw(0);
    localbiqw.b = "qzone_plugin.apk";
    localbiqw.d = "QZone";
    localbiqw.jdField_a_of_type_JavaLangString = paramString;
    localbiqw.e = "com.qzone.video.service.QzoneVideoPluginService";
    localbiqw.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbiqw.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    biqn.c(paramContext, localbiqw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */