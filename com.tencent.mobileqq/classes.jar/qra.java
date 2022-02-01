import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemSingle;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qra
  implements View.OnClickListener
{
  public qra(ComponentTopicItemSingle paramComponentTopicItemSingle, qzd paramqzd) {}
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.a();
    ozs.a = localArticleInfo;
    ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext(), this.jdField_a_of_type_Qzd.b);
    String str1 = ozs.a(localArticleInfo.mAlgorithmID, ozs.a(localArticleInfo), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e(), 0, 0, bhnv.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext()), localArticleInfo.mSubscribeID, null, localArticleInfo.innerUniqueID, null, localArticleInfo);
    String str2 = ubg.b(localArticleInfo.mChannelID);
    ocd.a(null, localArticleInfo.mSubscribeID, str2, str2, 0, 0, localArticleInfo.mFeedId + "", String.valueOf(this.jdField_a_of_type_Qzd.a), String.valueOf(localArticleInfo.mAlgorithmID), str1, false);
    ozs.a(localArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qra
 * JD-Core Version:    0.7.0.1
 */