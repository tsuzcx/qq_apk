import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tdr
  implements View.OnClickListener
{
  public tdr(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    PublicTransFragmentActivity.a(this.a.a(), ReadInJoyChannelPanelFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tdr
 * JD-Core Version:    0.7.0.1
 */