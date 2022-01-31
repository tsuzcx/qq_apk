import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;

public class tbw
  implements Runnable
{
  public tbw(Leba paramLeba) {}
  
  public void run()
  {
    LocalRedTouchManager localLocalRedTouchManager = (LocalRedTouchManager)this.a.a.getManager(159);
    RedTouchItem localRedTouchItem1 = localLocalRedTouchManager.a(10017);
    RedTouchItem localRedTouchItem2 = localLocalRedTouchManager.a(103421);
    if ((localLocalRedTouchManager.a(localRedTouchItem2)) && (localRedTouchItem2.redtouchType == 1)) {
      localLocalRedTouchManager.a(103421);
    }
    if (localLocalRedTouchManager.a(localRedTouchItem1)) {
      localLocalRedTouchManager.a(10017);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tbw
 * JD-Core Version:    0.7.0.1
 */