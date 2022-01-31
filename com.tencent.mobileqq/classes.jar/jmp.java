import com.tencent.av.redpacket.ui.RedPacketShareFragment;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class jmp
  implements Runnable
{
  public jmp(RedPacketShareFragment paramRedPacketShareFragment) {}
  
  public void run()
  {
    String str = RedPacketShareFragment.a(this.a);
    ThreadManager.getUIHandler().post(new jmq(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jmp
 * JD-Core Version:    0.7.0.1
 */