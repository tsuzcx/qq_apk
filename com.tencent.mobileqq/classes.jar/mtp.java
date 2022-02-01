import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class mtp
  extends BroadcastReceiver
{
  mtp(mtm parammtm) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    boolean bool3;
    boolean bool1;
    int i;
    if (str.equals("android.intent.action.SCREEN_ON"))
    {
      bool3 = VideoController.a(paramContext);
      if (Build.VERSION.SDK_INT < 20) {
        break label437;
      }
      bool1 = ((PowerManager)((Context)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).getSystemService("power")).isInteractive();
      paramContext = ((WindowManager)((Context)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).getSystemService("window")).getDefaultDisplay();
      if (paramContext == null) {
        break label432;
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
          mtm.a(this.a, mtm.a(this.a));
        }
      }
      label313:
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
              break label313;
            }
            i = paramIntent.getIntExtra("why", 0);
            QLog.d(this.a.jdField_a_of_type_JavaLangString, 1, "ACTION_SCREEN_OFF, why[" + i + "]");
          } while (this.a.jdField_a_of_type_ComTencentAvVideoController == null);
          this.a.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "4");
          lcd.jdField_a_of_type_JavaLangString = "4";
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
      mtm.a(this.a, mtm.a(this.a));
      return;
      label432:
      i = 2;
      continue;
      label437:
      i = 2;
      bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mtp
 * JD-Core Version:    0.7.0.1
 */