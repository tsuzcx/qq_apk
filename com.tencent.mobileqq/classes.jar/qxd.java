import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemSingle;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qxd
  implements View.OnClickListener
{
  public qxd(ComponentTopicItemSingle paramComponentTopicItemSingle, rgc paramrgc) {}
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.a();
    pay.a = localArticleInfo;
    pay.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext(), this.jdField_a_of_type_Rgc.b);
    String str1 = pay.a(localArticleInfo.mAlgorithmID, pay.a(localArticleInfo), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e(), 0, 0, NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext()), localArticleInfo.mSubscribeID, null, localArticleInfo.innerUniqueID, null, localArticleInfo);
    String str2 = uhv.b(localArticleInfo.mChannelID);
    odq.a(null, localArticleInfo.mSubscribeID, str2, str2, 0, 0, localArticleInfo.mFeedId + "", String.valueOf(this.jdField_a_of_type_Rgc.a), String.valueOf(localArticleInfo.mAlgorithmID), str1, false);
    pay.a(localArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxd
 * JD-Core Version:    0.7.0.1
 */