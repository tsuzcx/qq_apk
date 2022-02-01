import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.11.1;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tcy
  implements View.OnClickListener
{
  public tcy(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    EventCollector.getInstance().onViewClicked(ReadinjoyTabFrame.a(this.a));
    ReadinjoyTabFrame.a(this.a).postDelayed(new ReadinjoyTabFrame.11.1(this, paramView), 300L);
    if ((!RecommendFeedsDiandianEntranceManager.a().a()) && (!bmhv.w())) {
      RecommendFeedsDiandianEntranceManager.a().b(0, this.a.a());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tcy
 * JD-Core Version:    0.7.0.1
 */