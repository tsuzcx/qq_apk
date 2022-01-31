import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemMulti;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class pyi
  implements View.OnClickListener
{
  public pyi(ComponentTopicItemMulti paramComponentTopicItemMulti) {}
  
  public void onClick(View paramView)
  {
    onh.a = ComponentTopicItemMulti.a(this.a);
    onh.a(this.a.getContext(), this.a.a.b);
    paramView = shu.b(ComponentTopicItemMulti.a(this.a));
    String str = onh.a(ComponentTopicItemMulti.a(this.a).mAlgorithmID, onh.a(ComponentTopicItemMulti.a(this.a)), ComponentTopicItemMulti.a(this.a), 0, 0, bbfj.h(this.a.getContext()), ComponentTopicItemMulti.a(this.a).mSubscribeID, null, ComponentTopicItemMulti.a(this.a).innerUniqueID, null, ComponentTopicItemMulti.a(this.a));
    nol.a(null, ComponentTopicItemMulti.a(this.a).mSubscribeID, paramView, paramView, 0, 0, ComponentTopicItemMulti.a(this.a).mFeedId + "", String.valueOf(this.a.a.a), String.valueOf(ComponentTopicItemMulti.a(this.a).mAlgorithmID), str, false);
    onh.a(ComponentTopicItemMulti.a(this.a), ComponentTopicItemMulti.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pyi
 * JD-Core Version:    0.7.0.1
 */