import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class suw
  implements Runnable
{
  public suw(Leba paramLeba) {}
  
  public void run()
  {
    TroopRedTouchManager localTroopRedTouchManager = (TroopRedTouchManager)this.a.a.getManager(69);
    oidb_0x791.RedDotInfo localRedDotInfo = localTroopRedTouchManager.a(7);
    this.a.a(new sux(this, localRedDotInfo, localTroopRedTouchManager));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     suw
 * JD-Core Version:    0.7.0.1
 */