package cooperation.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bkkq;
import bklc;
import bkld;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class PluginCrashReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject = paramIntent.getAction();
            if ((!"com.tencent.mobileqq.ACTION_PLUGIN_CRASH".equals(localObject)) || ("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED".equals(localObject))) {
              try
              {
                new bkld(paramIntent).execute(new String[] { "" });
                return;
              }
              catch (Throwable paramContext)
              {
                return;
              }
            }
            if ("com.tencent.mobileqq.ACTION_PLUGIN_DIR_INFO_LOG".equals(localObject)) {
              try
              {
                new bklc(paramContext).execute(new String[] { "" });
                return;
              }
              catch (Throwable paramContext)
              {
                return;
              }
            }
            if (!"com.tencent.mobileqq.ACTION_PLUGIN_INSTALL_FAILED".equals(localObject)) {
              break;
            }
            localObject = BaseApplicationImpl.getApplication().getRuntime();
          } while (!(localObject instanceof QQAppInterface));
          paramContext = paramIntent.getStringExtra("plugin");
          paramIntent = paramIntent.getStringExtra("process");
          QLog.d("plugin_tag", 1, "receive installFailed " + paramContext + ", " + paramIntent);
        } while ("com.tencent.mobileqq".equals(paramIntent));
        paramIntent = (QQAppInterface)localObject;
      } while (!paramIntent.isCreateManager(27));
      ((bkkq)paramIntent.getManager(27)).cancelInstall(paramContext);
      return;
    } while (!"com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_SPEED_INFO".equals(localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.plugin.PluginCrashReceiver
 * JD-Core Version:    0.7.0.1
 */