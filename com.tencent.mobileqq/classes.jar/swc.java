import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;

public class swc
  implements Runnable
{
  public swc(LikeRankingListActivity paramLikeRankingListActivity) {}
  
  public void run()
  {
    LocalRedTouchManager localLocalRedTouchManager = (LocalRedTouchManager)this.a.app.getManager(159);
    RedTouchItem localRedTouchItem1 = localLocalRedTouchManager.a(100601);
    if (localLocalRedTouchManager.a(localRedTouchItem1, false))
    {
      RedTouchItem localRedTouchItem2 = localLocalRedTouchManager.a(100500);
      if ((localLocalRedTouchManager.a(localRedTouchItem2, true)) && (localRedTouchItem2.receiveTime == localRedTouchItem1.receiveTime)) {
        localRedTouchItem2.unReadFlag = false;
      }
      localLocalRedTouchManager.a(100601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     swc
 * JD-Core Version:    0.7.0.1
 */