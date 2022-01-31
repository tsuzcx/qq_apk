import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class lha
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private boolean jdField_a_of_type_Boolean;
  
  public lha(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new lhb(this);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioExitMonitor", 2, "regist QQ Process Exit Receiver1");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.av.EXIT_VIDEO_PROCESS");
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter) != null) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lha
 * JD-Core Version:    0.7.0.1
 */