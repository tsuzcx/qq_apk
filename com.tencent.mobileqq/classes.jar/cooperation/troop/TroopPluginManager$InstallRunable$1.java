package cooperation.troop;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class TroopPluginManager$InstallRunable$1
  extends Handler
{
  TroopPluginManager$InstallRunable$1(TroopPluginManager.InstallRunable paramInstallRunable, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.a.a == null);
      this.a.a.onInstallFinish(0);
      return;
    } while (this.a.a == null);
    this.a.a.onInstallFinish(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.InstallRunable.1
 * JD-Core Version:    0.7.0.1
 */