import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class oso
  implements View.OnClickListener
{
  public oso(ReadInJoyBaseActivity paramReadInJoyBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oso
 * JD-Core Version:    0.7.0.1
 */