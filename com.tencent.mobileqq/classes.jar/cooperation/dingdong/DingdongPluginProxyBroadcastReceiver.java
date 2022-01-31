package cooperation.dingdong;

import android.content.Intent;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import mqq.app.AppRuntime;

public class DingdongPluginProxyBroadcastReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    if (paramIntent.getAction() == null) {
      paramIntent.setAction("com.tencent.mobileqq.ACTION_DINGDONG_BROADCAST");
    }
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "dingdong_plugin.apk";
    localPluginParams.d = "叮咚";
    localPluginParams.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localPluginParams.e = "com.dingdong.broadcast.DingdongBroadcastReceiver";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    IPluginManager.a(paramAppRuntime.getApplication(), localPluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.dingdong.DingdongPluginProxyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */