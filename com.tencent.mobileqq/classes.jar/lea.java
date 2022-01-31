import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySelfActivity;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.widget.BounceScrollView.DrawFinishedListener;

public class lea
  implements BounceScrollView.DrawFinishedListener
{
  public lea(ReadInJoySelfActivity paramReadInJoySelfActivity) {}
  
  public void a()
  {
    if (ReadInJoySelfActivity.a(this.a))
    {
      ReadInJoySelfActivity.a(this.a, false);
      PublicTracker.a("self_tab_cost", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lea
 * JD-Core Version:    0.7.0.1
 */