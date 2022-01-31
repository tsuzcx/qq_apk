import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.VideoController;
import com.tencent.av.utils.SensorHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class kgu
  extends BroadcastReceiver
{
  public kgu(SensorHelper paramSensorHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    boolean bool3;
    boolean bool1;
    int i;
    if (str.equals("android.intent.action.SCREEN_ON"))
    {
      bool3 = ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      if (Build.VERSION.SDK_INT < 20) {
        break label445;
      }
      bool1 = ((PowerManager)((Context)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).getSystemService("power")).isInteractive();
      paramContext = ((WindowManager)((Context)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).getSystemService("window")).getDefaultDisplay();
      if (paramContext == null) {
        break label440;
      }
      i = paramContext.getState();
    }
    for (;;)
    {
      paramContext = this.a.jdField_a_of_type_JavaLangString;
      paramIntent = new StringBuilder().append("ACTION_SCREEN_ON, mVideoController[");
      boolean bool2;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        bool2 = true;
        QLog.d(paramContext, 1, bool2 + "], isInteractive[" + bool1 + "], nState[" + i + "], inKeyguardRestrictedInputMode[" + bool3 + "], mIsStarted[" + this.a.d + "]");
        if (this.a.d)
        {
          this.a.jdField_a_of_type_Int = 1;
          SensorHelper.a(this.a, SensorHelper.a(this.a));
        }
      }
      label321:
      do
      {
        do
        {
          do
          {
            return;
            bool2 = false;
            break;
            if (!str.equals("android.intent.action.SCREEN_OFF")) {
              break label321;
            }
            i = paramIntent.getIntExtra("why", 0);
            QLog.d(this.a.jdField_a_of_type_JavaLangString, 1, "ACTION_SCREEN_OFF, why[" + i + "]");
          } while (this.a.jdField_a_of_type_ComTencentAvVideoController == null);
          this.a.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "4");
          com.tencent.av.VideoConstants.ProcessInfo.jdField_a_of_type_JavaLangString = "4";
          return;
          if (str.equals("android.intent.action.USER_PRESENT"))
          {
            QLog.d(this.a.jdField_a_of_type_JavaLangString, 1, "ACTION_USER_PRESENT");
            return;
          }
        } while (!str.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        paramContext = paramIntent.getStringExtra("reason");
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 1, "ACTION_CLOSE_SYSTEM_DIALOGS, reason[" + paramContext + "]");
      } while ((!"homekey".equalsIgnoreCase(paramContext)) || (!this.a.d));
      this.a.jdField_a_of_type_Int = 1;
      SensorHelper.a(this.a, SensorHelper.a(this.a));
      return;
      label440:
      i = 2;
      continue;
      label445:
      i = 2;
      bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kgu
 * JD-Core Version:    0.7.0.1
 */