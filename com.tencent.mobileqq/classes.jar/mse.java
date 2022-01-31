import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.widget.XListView.DrawFinishedListener;

public class mse
  implements XListView.DrawFinishedListener
{
  public mse(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
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
 * Qualified Name:     mse
 * JD-Core Version:    0.7.0.1
 */