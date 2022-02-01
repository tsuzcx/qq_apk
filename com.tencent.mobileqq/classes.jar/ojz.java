import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ojz
  implements View.OnClickListener
{
  public ojz(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a instanceof ohm)) {
      ((ohm)this.a.a).p();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ojz
 * JD-Core Version:    0.7.0.1
 */