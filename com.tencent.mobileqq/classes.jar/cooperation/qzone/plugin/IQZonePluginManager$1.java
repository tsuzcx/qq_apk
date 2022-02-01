package cooperation.qzone.plugin;

import amtj;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;

final class IQZonePluginManager$1
  implements IQZonePluginManager.OnPluginReadyListener
{
  public void onPluginReady(boolean paramBoolean, Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean)
    {
      long l1 = paramPluginParams.mIntent.getLongExtra("key_launch_time", 0L);
      if (l1 > 0L)
      {
        long l2 = System.currentTimeMillis();
        QZLog.d("plugin_tag", 1, "IPluginManager onPluginReady Open Plugin Activity timedelay=" + (l2 - l1));
      }
      IQZonePluginManager.doOpenActivityForResult((Activity)paramContext, paramPluginParams);
      return;
    }
    Toast.makeText(BaseApplicationImpl.getContext(), amtj.a(2131704979), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.plugin.IQZonePluginManager.1
 * JD-Core Version:    0.7.0.1
 */