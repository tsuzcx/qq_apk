import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;

public class sxd
  implements Runnable
{
  public sxd(Leba paramLeba) {}
  
  public void run()
  {
    LocalRedTouchManager localLocalRedTouchManager = (LocalRedTouchManager)this.a.a.getManager(159);
    if (localLocalRedTouchManager.a(localLocalRedTouchManager.a(10013))) {
      localLocalRedTouchManager.a(10013);
    }
    ReportController.b(this.a.a, "dc00898", "", "", "0X8008823", "0X8008823", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sxd
 * JD-Core Version:    0.7.0.1
 */