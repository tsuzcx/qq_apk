package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import bimg;
import bimp;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

public class QzoneVideoPluginProxyService
  extends PluginProxyService
{
  public static void a(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection)
  {
    paramIntent.putExtra("useSkinEngine", 1);
    bimp localbimp = new bimp(0);
    localbimp.b = "qzone_plugin.apk";
    localbimp.d = "QZone";
    localbimp.jdField_a_of_type_JavaLangString = paramString;
    localbimp.e = "com.qzone.video.service.QzoneVideoPluginService";
    localbimp.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbimp.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bimg.c(paramContext, localbimp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */