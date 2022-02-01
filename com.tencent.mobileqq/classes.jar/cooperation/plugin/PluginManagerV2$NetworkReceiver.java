package cooperation.plugin;

import android.content.Context;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;

public class PluginManagerV2$NetworkReceiver
  implements INetEventHandler
{
  private Context b = BaseApplicationImpl.getApplication();
  private boolean c;
  
  public PluginManagerV2$NetworkReceiver(PluginManagerV2 paramPluginManagerV2) {}
  
  public void a()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    try
    {
      AppNetConnInfo.registerNetChangeReceiver(this.b, this);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, localException, new Object[0]);
      }
    }
  }
  
  public void b()
  {
    if (!this.c) {
      return;
    }
    this.c = false;
    try
    {
      AppNetConnInfo.unregisterNetEventHandler(this);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, localException, new Object[0]);
      }
    }
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    PluginManagerV2.b(this.a).sendEmptyMessage(66304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginManagerV2.NetworkReceiver
 * JD-Core Version:    0.7.0.1
 */