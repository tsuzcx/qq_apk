import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class osv
  implements View.OnClickListener
{
  public osv(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyBaseDeliverActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osv
 * JD-Core Version:    0.7.0.1
 */