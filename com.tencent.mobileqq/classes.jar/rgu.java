import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rgu
  implements View.OnClickListener
{
  public rgu(ComponentContentRecommend paramComponentContentRecommend) {}
  
  public void onClick(View paramView)
  {
    this.a.a(ComponentContentRecommend.a(this.a));
    pvj.a().a(ComponentContentRecommend.a(this.a).mArticleID, ComponentContentRecommend.a(this.a).mRecommendFollowInfos.a);
    ComponentContentRecommend.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rgu
 * JD-Core Version:    0.7.0.1
 */