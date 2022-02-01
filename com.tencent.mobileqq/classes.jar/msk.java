import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class msk
  extends BroadcastReceiver
{
  msk(msi parammsi) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (paramContext = null;; paramContext = paramIntent.getAction())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneStatusMonitor", 2, "PhoneStatusReceiver.onReceive, action[" + paramContext + "]");
      }
      this.a.c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     msk
 * JD-Core Version:    0.7.0.1
 */