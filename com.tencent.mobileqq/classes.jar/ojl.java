import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ojl
  implements View.OnClickListener
{
  public ojl(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.m = true;
    ReadInJoyBaseDeliverActivity.a(this.a);
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ojl
 * JD-Core Version:    0.7.0.1
 */