package cooperation.troop;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class TroopPluginManager$2
  extends Handler
{
  TroopPluginManager$2(TroopPluginManager paramTroopPluginManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    ((TroopPluginManager.TroopPluginCallback)paramMessage.obj).onInstallFinish(paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.2
 * JD-Core Version:    0.7.0.1
 */