import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qov
  implements View.OnClickListener
{
  public qov(ComponentContentRecommendFollowGroup paramComponentContentRecommendFollowGroup) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qov
 * JD-Core Version:    0.7.0.1
 */