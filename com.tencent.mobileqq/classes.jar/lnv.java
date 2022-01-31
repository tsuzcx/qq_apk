import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubscribeFragement;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.widget.XListView.DrawFinishedListener;

public class lnv
  implements XListView.DrawFinishedListener
{
  public lnv(ReadInJoySubscribeFragement paramReadInJoySubscribeFragement) {}
  
  public void a()
  {
    if ((!this.a.c) && (this.a.d))
    {
      this.a.c = true;
      PublicTracker.a("subscribe_tab_cost", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lnv
 * JD-Core Version:    0.7.0.1
 */