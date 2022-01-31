import com.tencent.av.redpacket.ui.RedPacketShareFragment;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class jmc
  implements Runnable
{
  public jmc(RedPacketShareFragment paramRedPacketShareFragment, int paramInt) {}
  
  public void run()
  {
    String str = RedPacketShareFragment.a(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment);
    ThreadManager.getUIHandler().post(new jmd(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jmc
 * JD-Core Version:    0.7.0.1
 */