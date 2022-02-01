import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rhi
  implements View.OnClickListener
{
  public rhi(ComponentContentRecommendFollowList paramComponentContentRecommendFollowList) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rhi
 * JD-Core Version:    0.7.0.1
 */