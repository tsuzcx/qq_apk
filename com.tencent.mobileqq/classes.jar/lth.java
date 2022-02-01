import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketManager.2;
import com.tencent.qphone.base.util.QLog;

public class lth
  implements ltq
{
  public lth(AVRedPacketManager.2 param2, long paramLong) {}
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    QLog.d("AVRedPacketManager", 1, "preloadCountDownRes, music load finish,cost =" + (l1 - l2));
    l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$2.this$0.jdField_a_of_type_Lti != null)
    {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$2.this$0.jdField_a_of_type_Lti.a(1, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$2.this$0.jdField_a_of_type_Ltj);
      l2 = System.currentTimeMillis();
      QLog.d("AVRedPacketManager", 1, "preloadCountDownRes, preloadRes finish,cost =" + (l2 - l1));
      return;
    }
    QLog.d("AVRedPacketManager", 1, "preloadCountDownRes,  mRedPacketGameShower is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lth
 * JD-Core Version:    0.7.0.1
 */