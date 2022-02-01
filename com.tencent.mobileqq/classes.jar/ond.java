import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ond
  implements View.OnClickListener
{
  public ond(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ond
 * JD-Core Version:    0.7.0.1
 */