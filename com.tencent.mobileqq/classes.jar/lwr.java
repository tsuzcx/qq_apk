import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemMulti;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.utils.NetworkUtil;

public class lwr
  implements View.OnClickListener
{
  public lwr(ComponentTopicItemMulti paramComponentTopicItemMulti) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyUtils.a = ComponentTopicItemMulti.a(this.a);
    ReadInJoyUtils.a(this.a.getContext(), this.a.a.b);
    paramView = ReadInJoyUtils.a(ComponentTopicItemMulti.a(this.a).mAlgorithmID, ReadInJoyUtils.a(ComponentTopicItemMulti.a(this.a)), ComponentTopicItemMulti.a(this.a), 0, 0, NetworkUtil.h(this.a.getContext()), ComponentTopicItemMulti.a(this.a).mSubscribeID, null, ComponentTopicItemMulti.a(this.a).innerUniqueID, null, ComponentTopicItemMulti.a(this.a));
    PublicAccountReportUtils.a(null, ComponentTopicItemMulti.a(this.a).mSubscribeID, "0X8007625", "0X8007625", 0, 0, ComponentTopicItemMulti.a(this.a).mFeedId + "", String.valueOf(this.a.a.a), String.valueOf(ComponentTopicItemMulti.a(this.a).mAlgorithmID), paramView, false);
    ReadInJoyUtils.a(ComponentTopicItemMulti.a(this.a), ComponentTopicItemMulti.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lwr
 * JD-Core Version:    0.7.0.1
 */