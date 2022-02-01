import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemMulti;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qxb
  implements View.OnClickListener
{
  public qxb(ComponentTopicItemMulti paramComponentTopicItemMulti) {}
  
  public void onClick(View paramView)
  {
    pay.a = ComponentTopicItemMulti.a(this.a);
    pay.a(this.a.getContext(), this.a.a.b);
    String str1 = uhv.b(ComponentTopicItemMulti.a(this.a));
    String str2 = pay.a(ComponentTopicItemMulti.a(this.a).mAlgorithmID, pay.a(ComponentTopicItemMulti.a(this.a)), ComponentTopicItemMulti.a(this.a), 0, 0, NetworkUtil.isWifiConnected(this.a.getContext()), ComponentTopicItemMulti.a(this.a).mSubscribeID, null, ComponentTopicItemMulti.a(this.a).innerUniqueID, null, ComponentTopicItemMulti.a(this.a));
    odq.a(null, ComponentTopicItemMulti.a(this.a).mSubscribeID, str1, str1, 0, 0, ComponentTopicItemMulti.a(this.a).mFeedId + "", String.valueOf(this.a.a.a), String.valueOf(ComponentTopicItemMulti.a(this.a).mAlgorithmID), str2, false);
    pay.a(ComponentTopicItemMulti.a(this.a), ComponentTopicItemMulti.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxb
 * JD-Core Version:    0.7.0.1
 */