package cooperation.troop;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class NearbyVideoProxyBroadcastReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void a(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendPluginBroadcast:");
      ((StringBuilder)localObject).append(paramIntent.getAction());
      QLog.d("NearbyVideoProxyBroadcastReceiver", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent(paramIntent.getAction());
    ((Intent)localObject).putExtras(paramIntent);
    ((Intent)localObject).putExtra("action", paramIntent.getAction());
    paramIntent = new IPluginManager.PluginParams(1);
    paramIntent.d = "nearby_video_chat_plugin.apk";
    paramIntent.g = PluginInfo.l;
    paramIntent.c = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    paramIntent.h = "com.tencent.mobileqq.nearbyvideochat.service.NearbyVideoMsgBroadcastReceiver";
    paramIntent.j = ((Intent)localObject);
    IPluginManager.b(paramContext, paramIntent);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("onReceive:");
      paramContext.append(paramIntent.getAction());
      QLog.d("NearbyVideoProxyBroadcastReceiver", 2, paramContext.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop.NearbyVideoProxyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */