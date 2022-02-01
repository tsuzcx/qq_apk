package cooperation.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class PluginCrashReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    Object localObject = paramIntent.getAction();
    "com.tencent.mobileqq.ACTION_PLUGIN_CRASH".equals(localObject);
    if ("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED".equals(localObject)) {}
    try
    {
      new PluginCrashReceiver.StartPluginFailedReported(paramIntent).execute(new String[] { "" });
      return;
    }
    catch (Throwable paramContext) {}
    if ("com.tencent.mobileqq.ACTION_PLUGIN_DIR_INFO_LOG".equals(localObject))
    {
      new PluginCrashReceiver.PluginDirInfoLoger(paramContext).execute(new String[] { "" });
      return;
    }
    if ("com.tencent.mobileqq.ACTION_PLUGIN_INSTALL_FAILED".equals(localObject))
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        paramContext = paramIntent.getStringExtra("plugin");
        paramIntent = paramIntent.getStringExtra("process");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("receive installFailed ");
        localStringBuilder.append(paramContext);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramIntent);
        QLog.d("plugin_tag", 1, localStringBuilder.toString());
        if (!"com.tencent.mobileqq".equals(paramIntent))
        {
          paramIntent = (QQAppInterface)localObject;
          if (paramIntent.isCreateManager(QQManagerFactory.MGR_PLUGIN)) {
            ((IPluginManager)paramIntent.getManager(QQManagerFactory.MGR_PLUGIN)).cancelInstall(paramContext);
          }
        }
      }
    }
    else
    {
      "com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_SPEED_INFO".equals(localObject);
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginCrashReceiver
 * JD-Core Version:    0.7.0.1
 */