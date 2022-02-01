package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import blfh;
import blfq;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

public class QzoneVideoPluginProxyService
  extends PluginProxyService
{
  public static void a(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection)
  {
    paramIntent.putExtra("useSkinEngine", 1);
    blfq localblfq = new blfq(0);
    localblfq.b = "qzone_plugin.apk";
    localblfq.d = "QZone";
    localblfq.jdField_a_of_type_JavaLangString = paramString;
    localblfq.e = "com.qzone.video.service.QzoneVideoPluginService";
    localblfq.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localblfq.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    blfh.c(paramContext, localblfq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */