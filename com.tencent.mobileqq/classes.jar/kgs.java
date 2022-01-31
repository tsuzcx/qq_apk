import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.qphone.base.util.QLog;

class kgs
  implements Runnable
{
  kgs(kgr paramkgr) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged isCallingRunnable run end  mIsCalling: " + this.a.a.jdField_a_of_type_Boolean);
    }
    if (this.a.a.jdField_a_of_type_Boolean)
    {
      this.a.a.jdField_a_of_type_Boolean = false;
      if (this.a.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener != null) {
        this.a.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     kgs
 * JD-Core Version:    0.7.0.1
 */