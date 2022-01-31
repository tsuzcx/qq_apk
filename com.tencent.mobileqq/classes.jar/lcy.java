import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.widget.XListView.DrawFinishedListener;

public class lcy
  implements XListView.DrawFinishedListener
{
  public lcy(ReadInJoyMessagesActivity paramReadInJoyMessagesActivity) {}
  
  public void a()
  {
    if ((!this.a.a) && (this.a.b))
    {
      this.a.a = true;
      PublicTracker.a("subscribe_tab_cost", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lcy
 * JD-Core Version:    0.7.0.1
 */