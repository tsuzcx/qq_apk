import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity;
import com.tencent.widget.XListView.DrawFinishedListener;

public class otr
  implements XListView.DrawFinishedListener
{
  public otr(ReadInJoyMessagesActivity paramReadInJoyMessagesActivity) {}
  
  public void drawFinished()
  {
    if ((!this.a.a) && (this.a.b))
    {
      this.a.a = true;
      uuq.a("subscribe_tab_cost", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     otr
 * JD-Core Version:    0.7.0.1
 */