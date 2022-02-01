import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class otg
  implements View.OnClickListener
{
  public otg(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyChannelActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     otg
 * JD-Core Version:    0.7.0.1
 */