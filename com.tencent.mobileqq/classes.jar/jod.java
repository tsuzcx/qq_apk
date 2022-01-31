import com.tencent.av.redpacket.ui.RedPacketShareFragment;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class jod
  implements Runnable
{
  public jod(RedPacketShareFragment paramRedPacketShareFragment, int paramInt) {}
  
  public void run()
  {
    String str = RedPacketShareFragment.a(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment);
    ThreadManager.getUIHandler().post(new joe(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jod
 * JD-Core Version:    0.7.0.1
 */