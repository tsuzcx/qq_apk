import android.telephony.PhoneStateListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class muy
  extends PhoneStateListener
{
  muy(muv parammuv) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onCallStateChanged(paramInt, paramString);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged CALL_STATE_IDLE  mIsCalling:  " + this.a.jdField_a_of_type_Boolean);
      }
      if (this.a.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged isCallingRunnable mIsCalling: " + this.a.jdField_a_of_type_Boolean);
        }
        ThreadManager.post(this.a.jdField_a_of_type_JavaLangRunnable, 8, null, false);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged CALL_STATE_RINGING or CALL_STATE_OFFHOOK");
        }
        if (!this.a.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_Boolean = true;
          if (this.a.jdField_a_of_type_Muw != null) {
            this.a.jdField_a_of_type_Muw.a(true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     muy
 * JD-Core Version:    0.7.0.1
 */