package cooperation.buscard;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle.ActivityLifecycleCallback;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class NFCActivityLifecycleCallback
  implements ActivityLifecycle.ActivityLifecycleCallback
{
  public void onNewIntent(Activity paramActivity, Intent paramIntent)
  {
    if ((paramIntent != null) && ("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction()))) {
      BuscardHelper.a("", paramActivity, paramIntent);
    }
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "NFCActivityLifecycleCallback onNewIntent " + MobileQQ.processName);
    }
  }
  
  public void onPause(Activity paramActivity)
  {
    try
    {
      BuscardHelper.a(paramActivity, true, "", "");
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "NFCActivityLifecycleCallback onPause " + MobileQQ.processName);
      }
      return;
    }
    catch (Throwable paramActivity)
    {
      for (;;)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public void onResume(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "NFCActivityLifecycleCallback onResume " + MobileQQ.processName);
    }
    try
    {
      BuscardHelper.a(paramActivity, true, "", "", null);
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.buscard.NFCActivityLifecycleCallback
 * JD-Core Version:    0.7.0.1
 */