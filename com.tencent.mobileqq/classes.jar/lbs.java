import com.tencent.biz.pubaccount.readinjoy.SubscriptionViewController;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySubscriptionListViewGroup;
import java.util.List;

public class lbs
  extends ReadInJoyObserver
{
  public lbs(SubscriptionViewController paramSubscriptionViewController) {}
  
  public void a(List paramList)
  {
    if ((SubscriptionViewController.a(this.a) != null) && ((SubscriptionViewController.a(this.a) instanceof ReadInJoySubscriptionListViewGroup))) {
      ((ReadInJoySubscriptionListViewGroup)SubscriptionViewController.a(this.a)).a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbs
 * JD-Core Version:    0.7.0.1
 */