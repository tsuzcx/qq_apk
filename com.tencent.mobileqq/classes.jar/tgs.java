import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

public class tgs
  implements Runnable
{
  public tgs(NearbyActivity paramNearbyActivity) {}
  
  public void run()
  {
    this.a.a.c();
    NearbyHandler localNearbyHandler = (NearbyHandler)this.a.a.a(3);
    localNearbyHandler.a(this.a.a.getCurrentAccountUin());
    localNearbyHandler.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tgs
 * JD-Core Version:    0.7.0.1
 */