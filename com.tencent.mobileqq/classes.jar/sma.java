import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sma
  implements View.OnClickListener
{
  public sma(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    ReadinjoyTabFrame.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sma
 * JD-Core Version:    0.7.0.1
 */