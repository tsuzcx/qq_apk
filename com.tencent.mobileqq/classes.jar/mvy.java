import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.widget.XListView.DrawFinishedListener;

public class mvy
  implements XListView.DrawFinishedListener
{
  public mvy(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void a()
  {
    if ((!this.a.c) && (this.a.d))
    {
      this.a.c = true;
      PublicTracker.a("SUBSCRIPT_FEEDS_COST", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mvy
 * JD-Core Version:    0.7.0.1
 */