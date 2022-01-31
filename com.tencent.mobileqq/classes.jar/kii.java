import android.os.Handler;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.qphone.base.util.QLog;

public class kii
  implements Runnable
{
  public kii(PhoneStatusMonitor paramPhoneStatusMonitor) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged isCallingRunnable run");
    }
    if ((this.a.jdField_a_of_type_AndroidContentContext != null) && (!PhoneStatusTools.d(this.a.jdField_a_of_type_AndroidContentContext)) && (this.a.jdField_a_of_type_AndroidOsHandler != null)) {
      this.a.jdField_a_of_type_AndroidOsHandler.post(new kij(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     kii
 * JD-Core Version:    0.7.0.1
 */