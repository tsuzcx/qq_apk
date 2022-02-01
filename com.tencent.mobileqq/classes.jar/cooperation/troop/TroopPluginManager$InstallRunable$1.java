package cooperation.troop;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.troop.plugin.TroopPluginCallback;

class TroopPluginManager$InstallRunable$1
  extends Handler
{
  TroopPluginManager$InstallRunable$1(TroopPluginManager.InstallRunable paramInstallRunable, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1001)
    {
      if (i != 1002) {
        return;
      }
      if (this.a.a != null) {
        this.a.a.onInstallFinish(2);
      }
    }
    else if (this.a.a != null)
    {
      this.a.a.onInstallFinish(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.InstallRunable.1
 * JD-Core Version:    0.7.0.1
 */