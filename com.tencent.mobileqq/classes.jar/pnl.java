import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFragmentWithSubChannel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class pnl
  implements AdapterView.OnItemClickListener
{
  public pnl(ReadInJoyFragmentWithSubChannel paramReadInJoyFragmentWithSubChannel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.a(paramView, paramInt);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pnl
 * JD-Core Version:    0.7.0.1
 */