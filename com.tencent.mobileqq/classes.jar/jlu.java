import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketManager.RedPacketGameShower;
import com.tencent.av.redpacket.SoundPoolHelper.OnLoadFinishListener;
import com.tencent.qphone.base.util.QLog;

class jlu
  implements SoundPoolHelper.OnLoadFinishListener
{
  jlu(jlt paramjlt, long paramLong) {}
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    QLog.d("AVRedPacketManager", 1, "preloadCountDownRes, music load finish,cost =" + (l1 - l2));
    l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_Jlt.a.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$RedPacketGameShower != null)
    {
      this.jdField_a_of_type_Jlt.a.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$RedPacketGameShower.a(1, this.jdField_a_of_type_Jlt.a.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$ResPreLoadObserver);
      l2 = System.currentTimeMillis();
      QLog.d("AVRedPacketManager", 1, "preloadCountDownRes, preloadRes finish,cost =" + (l2 - l1));
      return;
    }
    QLog.d("AVRedPacketManager", 1, "preloadCountDownRes,  mRedPacketGameShower is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jlu
 * JD-Core Version:    0.7.0.1
 */