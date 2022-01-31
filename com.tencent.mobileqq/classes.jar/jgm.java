import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class jgm
  extends BroadcastReceiver
{
  public static String a;
  VideoAppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "AccountReceiver";
  }
  
  public jgm(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    long l;
    int i;
    boolean bool;
    int j;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              try
              {
                paramContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "recv account broadcast: " + paramIntent.getAction());
                }
                if (!paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_KICKED")) {
                  break;
                }
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1001);
                if (paramContext != null) {
                  paramContext.L();
                }
                Process.killProcess(Process.myPid());
                return;
              }
              catch (RuntimeException paramContext) {}
            } while (!QLog.isColorLevel());
            QLog.e(jdField_a_of_type_JavaLangString, 2, "RuntimeException", paramContext);
            return;
            if (paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_EXPIRED"))
            {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1003);
              if (paramContext != null) {
                paramContext.L();
              }
              Process.killProcess(Process.myPid());
              return;
            }
            if (paramIntent.getAction().equals("mqq.intent.action.LOGOUT"))
            {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1002);
              if (paramContext != null) {
                paramContext.L();
              }
              Process.killProcess(Process.myPid());
              return;
            }
            if (paramIntent.getAction().equals("mqq.intent.action.EXIT_" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName()))
            {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1005);
              if (paramContext != null) {
                paramContext.L();
              }
              Process.killProcess(Process.myPid());
              return;
            }
            if (!"mqq.intent.action.ACCOUNT_CHANGED".equals(paramIntent.getAction())) {
              break;
            }
          } while (paramContext == null);
          if (paramContext.e) {
            paramContext.a(paramContext.c, paramContext.a, 74);
          }
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "ACTION_ACCOUNT_CHANGED, video process exit!");
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004);
          paramContext.L();
          Process.killProcess(Process.myPid());
          return;
        } while (!"tencent.video.q2v.membersChange".equals(paramIntent.getAction()));
        l = paramIntent.getLongExtra("relationId", -1L);
        i = paramIntent.getIntExtra("relationType", 0);
        if (l != -1L) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "can not get the right value");
      return;
      bool = paramIntent.getBooleanExtra("Exit", false);
      j = paramIntent.getIntExtra("avtype", 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(79), Long.valueOf(l), Boolean.valueOf(bool), Integer.valueOf(j) });
    } while ((!bool) || (j == 2));
    paramContext.c(i, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jgm
 * JD-Core Version:    0.7.0.1
 */