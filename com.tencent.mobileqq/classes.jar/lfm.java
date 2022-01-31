import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.widget.XListView.DrawFinishedListener;

public class lfm
  implements XListView.DrawFinishedListener
{
  public lfm(ReadInJoyMessagesActivity paramReadInJoyMessagesActivity) {}
  
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
 * Qualified Name:     lfm
 * JD-Core Version:    0.7.0.1
 */