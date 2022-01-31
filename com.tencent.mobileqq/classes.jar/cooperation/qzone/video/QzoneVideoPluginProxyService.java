package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import bfcz;
import bfdi;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

public class QzoneVideoPluginProxyService
  extends PluginProxyService
{
  public static void a(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection)
  {
    paramIntent.putExtra("useSkinEngine", 1);
    bfdi localbfdi = new bfdi(0);
    localbfdi.b = "qzone_plugin.apk";
    localbfdi.d = "QZone";
    localbfdi.jdField_a_of_type_JavaLangString = paramString;
    localbfdi.e = "com.qzone.video.service.QzoneVideoPluginService";
    localbfdi.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbfdi.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bfcz.c(paramContext, localbfdi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */