import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySubscriptionListViewGroup;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.widget.XListView.DrawFinishedListener;

public class mjk
  implements XListView.DrawFinishedListener
{
  public mjk(ReadInJoySubscriptionListViewGroup paramReadInJoySubscriptionListViewGroup) {}
  
  public void a()
  {
    if ((!this.a.b) && (this.a.c))
    {
      this.a.b = true;
      PublicTracker.a("SUBSCRIPT_FEEDS_COST", null);
      PublicTracker.a("KANDIAN_TO_SUBSCRIPT_COST", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mjk
 * JD-Core Version:    0.7.0.1
 */