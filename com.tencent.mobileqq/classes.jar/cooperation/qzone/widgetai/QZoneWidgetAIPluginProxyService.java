package cooperation.qzone.widgetai;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public class QZoneWidgetAIPluginProxyService
  extends PluginProxyService
{
  public static void a(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection)
  {
    paramIntent.putExtra("useSkinEngine", -1);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "qzone_widgetai.apk";
    localPluginParams.d = "qzone_widgetai";
    localPluginParams.jdField_a_of_type_JavaLangString = paramString;
    localPluginParams.e = "com.qzone.commonbase.service.PetLaunchService";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    IPluginManager.b(paramContext, localPluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.widgetai.QZoneWidgetAIPluginProxyService
 * JD-Core Version:    0.7.0.1
 */