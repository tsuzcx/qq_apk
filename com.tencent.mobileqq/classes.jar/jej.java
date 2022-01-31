import android.content.IntentFilter;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class jej
{
  public static String a;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  jek jdField_a_of_type_Jek;
  boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = "AccountReceiver";
  }
  
  public jej(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Jek = new jek(paramVideoAppInterface);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_Jek);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "regist QQ Account Receiver");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("tencent.video.q2v.membersChange");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_Jek, localIntentFilter) != null) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jej
 * JD-Core Version:    0.7.0.1
 */