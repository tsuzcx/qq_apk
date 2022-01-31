import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.widget.BounceScrollView.DrawFinishedListener;

public class lqk
  implements BounceScrollView.DrawFinishedListener
{
  public lqk(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void a()
  {
    if (ReadInJoySelfFragment.a(this.a))
    {
      ReadInJoySelfFragment.a(this.a, false);
      PublicTracker.a("self_tab_cost", null);
      PublicTracker.a = 4;
      PublicTracker.a("KANDIAN_FEEDS_COST", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lqk
 * JD-Core Version:    0.7.0.1
 */