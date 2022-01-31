package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import bgkq;
import bgkz;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

public class QzoneVideoPluginProxyService
  extends PluginProxyService
{
  public static void a(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection)
  {
    paramIntent.putExtra("useSkinEngine", 1);
    bgkz localbgkz = new bgkz(0);
    localbgkz.b = "qzone_plugin.apk";
    localbgkz.d = "QZone";
    localbgkz.jdField_a_of_type_JavaLangString = paramString;
    localbgkz.e = "com.qzone.video.service.QzoneVideoPluginService";
    localbgkz.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbgkz.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bgkq.c(paramContext, localbgkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */