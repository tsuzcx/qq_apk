import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class pqh
  implements View.OnClickListener
{
  public pqh(ReadInJoyViolaChannelFragment paramReadInJoyViolaChannelFragment) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyViolaChannelFragment.a(this.a).d();
    ReadInJoyViolaChannelFragment.a(this.a);
    ReadInJoyViolaChannelFragment.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqh
 * JD-Core Version:    0.7.0.1
 */