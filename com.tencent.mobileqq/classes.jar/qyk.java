import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemMulti;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qyk
  implements View.OnClickListener
{
  public qyk(ComponentTopicItemMulti paramComponentTopicItemMulti) {}
  
  public void onClick(View paramView)
  {
    pha.a = ComponentTopicItemMulti.a(this.a);
    pha.a(this.a.getContext(), this.a.a.b);
    String str1 = ube.b(ComponentTopicItemMulti.a(this.a));
    String str2 = pha.a(ComponentTopicItemMulti.a(this.a).mAlgorithmID, pha.a(ComponentTopicItemMulti.a(this.a)), ComponentTopicItemMulti.a(this.a), 0, 0, bgnt.h(this.a.getContext()), ComponentTopicItemMulti.a(this.a).mSubscribeID, null, ComponentTopicItemMulti.a(this.a).innerUniqueID, null, ComponentTopicItemMulti.a(this.a));
    oat.a(null, ComponentTopicItemMulti.a(this.a).mSubscribeID, str1, str1, 0, 0, ComponentTopicItemMulti.a(this.a).mFeedId + "", String.valueOf(this.a.a.a), String.valueOf(ComponentTopicItemMulti.a(this.a).mAlgorithmID), str2, false);
    pha.a(ComponentTopicItemMulti.a(this.a), ComponentTopicItemMulti.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyk
 * JD-Core Version:    0.7.0.1
 */