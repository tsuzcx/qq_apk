import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import com.tencent.av.utils.PhoneStatusMonitor.1;
import com.tencent.av.utils.PhoneStatusMonitor.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class mse
{
  public Context a;
  public Handler a;
  public PhoneStateListener a;
  Runnable jdField_a_of_type_JavaLangRunnable = new PhoneStatusMonitor.2(this);
  public msf a;
  msg jdField_a_of_type_Msg;
  public boolean a;
  
  public mse(Context paramContext, msf parammsf)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = null;
    long l = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor Begin");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Msf = parammsf;
    try
    {
      this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = new msh(this);
      this.jdField_a_of_type_Msg = new msg(this);
    }
    catch (Exception parammsf)
    {
      try
      {
        do
        {
          ThreadManager.post(new PhoneStatusMonitor.1(this, paramContext), 5, null, false);
          if (QLog.isColorLevel()) {
            QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor Step1,time=" + (SystemClock.elapsedRealtime() - l));
          }
          parammsf = new IntentFilter();
          parammsf.addAction("android.intent.action.PHONE_STATE");
          parammsf.addAction("android.intent.action.PHONE_STATE2");
          parammsf.addAction("android.intent.action.PHONE_STATE_2");
          parammsf.addAction("android.intent.action.PHONE_STATE_EXT");
          parammsf.addAction("android.intent.action.NEW_OUTGOING_CALL");
          paramContext.registerReceiver(this.jdField_a_of_type_Msg, parammsf);
          QLog.d("PhoneStatusMonitor", 1, "mPhoneStatusReceiver.registerReceiver()");
          if (QLog.isColorLevel()) {
            QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor End,time=" + (SystemClock.elapsedRealtime() - l));
          }
          this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
          return;
          parammsf = parammsf;
        } while (!QLog.isColorLevel());
        QLog.e("PhoneStatusMonitor", 2, "PhoneStatusMonitor e1 = " + parammsf);
      }
      catch (InternalError parammsf)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PhoneStatusMonitor", 2, "PhoneStatusMonitor e = " + parammsf);
          }
        }
      }
      catch (IncompatibleClassChangeError parammsf)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PhoneStatusMonitor", 2, "PhoneStatusMonitor e2 = " + parammsf);
          }
        }
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_AndroidTelephonyPhoneStateListener == null)) {
      return;
    }
    msi.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 0);
    QLog.d("PhoneStatusMonitor", 1, "mPhoneStatusReceiver.unregisterReceiver()");
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Msg);
    this.jdField_a_of_type_Msf = null;
    this.jdField_a_of_type_Msg = null;
    this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    a();
  }
  
  protected void finalize()
  {
    try
    {
      a();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mse
 * JD-Core Version:    0.7.0.1
 */