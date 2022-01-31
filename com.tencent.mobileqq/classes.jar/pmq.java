import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemMulti;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class pmq
  implements View.OnClickListener
{
  public pmq(ComponentTopicItemMulti paramComponentTopicItemMulti) {}
  
  public void onClick(View paramView)
  {
    obz.a = ComponentTopicItemMulti.a(this.a);
    obz.a(this.a.getContext(), this.a.a.b);
    paramView = rvf.b(ComponentTopicItemMulti.a(this.a));
    String str = obz.a(ComponentTopicItemMulti.a(this.a).mAlgorithmID, obz.a(ComponentTopicItemMulti.a(this.a)), ComponentTopicItemMulti.a(this.a), 0, 0, badq.h(this.a.getContext()), ComponentTopicItemMulti.a(this.a).mSubscribeID, null, ComponentTopicItemMulti.a(this.a).innerUniqueID, null, ComponentTopicItemMulti.a(this.a));
    ndn.a(null, ComponentTopicItemMulti.a(this.a).mSubscribeID, paramView, paramView, 0, 0, ComponentTopicItemMulti.a(this.a).mFeedId + "", String.valueOf(this.a.a.a), String.valueOf(ComponentTopicItemMulti.a(this.a).mAlgorithmID), str, false);
    obz.a(ComponentTopicItemMulti.a(this.a), ComponentTopicItemMulti.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pmq
 * JD-Core Version:    0.7.0.1
 */