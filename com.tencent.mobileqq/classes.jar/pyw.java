import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class pyw
  implements View.OnClickListener
{
  pyw(pyv parampyv) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    this.a.a.a(paramView, i);
    pih.a(this.a.a.getActivity(), "0X8009A71", this.a.a.a(), ((pyu)this.a.a.a.get(i)).a.mChannelCoverId);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyw
 * JD-Core Version:    0.7.0.1
 */