import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemSingle;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.utils.NetworkUtil;

public class lwk
  implements View.OnClickListener
{
  public lwk(ComponentTopicItemSingle paramComponentTopicItemSingle, TopicRecommendFeedsInfo.TopicRecommendInfo paramTopicRecommendInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.a();
    ReadInJoyUtils.a = paramView;
    ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo.b);
    String str = ReadInJoyUtils.a(paramView.mAlgorithmID, ReadInJoyUtils.a(paramView), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e(), 0, 0, NetworkUtil.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext()), paramView.mSubscribeID, null, paramView.innerUniqueID, null, paramView);
    PublicAccountReportUtils.a(null, paramView.mSubscribeID, "0X8007625", "0X8007625", 0, 0, paramView.mFeedId + "", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo.a), String.valueOf(paramView.mAlgorithmID), str, false);
    ReadInJoyUtils.a(paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lwk
 * JD-Core Version:    0.7.0.1
 */