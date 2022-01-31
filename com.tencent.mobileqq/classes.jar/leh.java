import android.app.Application;
import android.app.Notification;
import android.content.Intent;
import android.os.RemoteException;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class leh
{
  private static String jdField_a_of_type_JavaLangString = "AVServiceProxy";
  protected VideoAppInterface a;
  protected lei a;
  protected lwq a;
  private boolean jdField_a_of_type_Boolean = true;
  
  public leh(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), AVServiceForQQ.class);
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().startService(localIntent);
      this.jdField_a_of_type_Lei = new lei(this);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().bindService(localIntent, this.jdField_a_of_type_Lei, 1);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        lcl.e(jdField_a_of_type_JavaLangString, "bindService " + localThrowable.getMessage());
      }
    }
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("setAVServiceForegroud start=%s mAvService=%s", new Object[] { Boolean.valueOf(paramBoolean), this.jdField_a_of_type_Lwq }));
    if (this.jdField_a_of_type_Lwq != null) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Lwq.a(paramBoolean, paramNotification);
        this.jdField_a_of_type_Boolean = paramBoolean;
        return;
      }
      catch (RemoteException paramNotification)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "setAVServiceForegroud fail.", paramNotification);
        continue;
      }
      catch (Throwable paramNotification)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "setAVServiceForegroud fail.", paramNotification);
        continue;
      }
      try
      {
        MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication();
        Intent localIntent = new Intent(localMobileQQ, AVServiceForQQ.class);
        localIntent.putExtra("setForeground", true);
        localIntent.putExtra("foreground", paramBoolean);
        localIntent.putExtra("notification", paramNotification);
        localMobileQQ.startService(localIntent);
      }
      catch (Throwable paramNotification)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "setAVServiceForegroud fail.", paramNotification);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), AVServiceForQQ.class);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().stopService(localIntent);
    if (this.jdField_a_of_type_Lwq != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unbindService(this.jdField_a_of_type_Lei);
      return;
    }
    catch (Exception localException)
    {
      lcl.e(jdField_a_of_type_JavaLangString, "unbindService msg = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     leh
 * JD-Core Version:    0.7.0.1
 */