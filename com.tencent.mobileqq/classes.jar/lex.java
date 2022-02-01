import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class lex
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private boolean jdField_a_of_type_Boolean;
  
  public lex(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new lez(paramVideoAppInterface, null);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qav.notify.accept");
    localIntentFilter.addAction("com.tencent.qav.notify.refuse");
    localIntentFilter.addAction("tencent.video.q2v.ptusoDownloadRet");
    localIntentFilter.addAction("tencent.video.q2v.ptuLibpagDownloadRet");
    localIntentFilter.addAction("tencent.video.q2v.avReceivePushMsg");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("QAVNotifyActionMonitor", 2, "register");
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QAVNotifyActionMonitor", 2, "unRegister");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lex
 * JD-Core Version:    0.7.0.1
 */