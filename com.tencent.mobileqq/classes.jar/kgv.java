import android.telephony.PhoneStateListener;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class kgv
  extends PhoneStateListener
{
  public kgv(PhoneStatusMonitor paramPhoneStatusMonitor) {}
  
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
          if (this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener != null) {
            this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener.a(true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     kgv
 * JD-Core Version:    0.7.0.1
 */