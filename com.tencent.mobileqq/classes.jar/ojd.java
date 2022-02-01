import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ojd
  implements View.OnClickListener
{
  public ojd(ReadInJoyNewBaseActivity paramReadInJoyNewBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ojd
 * JD-Core Version:    0.7.0.1
 */