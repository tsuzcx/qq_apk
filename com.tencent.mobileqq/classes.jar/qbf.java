import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qbf
  implements View.OnClickListener
{
  public qbf(ReadInJoyViolaChannelFragment paramReadInJoyViolaChannelFragment) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyViolaChannelFragment.a(this.a).d();
    ReadInJoyViolaChannelFragment.a(this.a);
    ReadInJoyViolaChannelFragment.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbf
 * JD-Core Version:    0.7.0.1
 */