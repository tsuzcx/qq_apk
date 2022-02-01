package cooperation.pluginbridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class BridgeHelper$MyReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action:");
      localStringBuilder.append(paramIntent);
      QLog.i("BridgeHelper", 2, localStringBuilder.toString());
    }
    if (("bridge.plugin.onresume.broadcast".equals(paramIntent)) || ("bridge.onresume.broadcast".equals(paramIntent)))
    {
      try
      {
        paramContext.unregisterReceiver(BridgeHelper.a());
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
      }
      BridgeHelper.a(null);
      if (BridgeHelper.a() != null)
      {
        BridgeHelper.a().dismiss();
        BridgeHelper.a(null);
      }
      if ((paramContext instanceof BridgePluginInstallActivity))
      {
        if (QLog.isColorLevel()) {
          QLog.w("BridgeHelper", 2, "Activity finish!");
        }
        ((BridgePluginInstallActivity)paramContext).finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.pluginbridge.BridgeHelper.MyReceiver
 * JD-Core Version:    0.7.0.1
 */