import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemSingle;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rjj
  implements View.OnClickListener
{
  public rjj(ComponentTopicItemSingle paramComponentTopicItemSingle, rsj paramrsj) {}
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.a();
    pqx.a = localArticleInfo;
    pkh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext(), this.jdField_a_of_type_Rsj.b);
    String str1 = pqf.a(localArticleInfo.mAlgorithmID, pqw.a(localArticleInfo), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e(), 0, 0, NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext()), localArticleInfo.mSubscribeID, null, localArticleInfo.innerUniqueID, null, localArticleInfo);
    String str2 = uvs.b(localArticleInfo.mChannelID);
    olh.a(null, localArticleInfo.mSubscribeID, str2, str2, 0, 0, localArticleInfo.mFeedId + "", String.valueOf(this.jdField_a_of_type_Rsj.a), String.valueOf(localArticleInfo.mAlgorithmID), str1, false);
    pqb.c(localArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rjj
 * JD-Core Version:    0.7.0.1
 */