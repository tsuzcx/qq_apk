import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ovo
  implements View.OnClickListener
{
  ovo(ovn paramovn, ArticleInfo paramArticleInfo, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.isEmpty())) {
      QLog.d("PackProteusItem", 1, "articleInfo is null or topicRecommendInfo is null or topicRecommendInfoList is empty");
    }
    String str1;
    do
    {
      return;
      str1 = ((prx)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).b;
    } while (TextUtils.isEmpty(str1));
    String str2 = obz.a("1", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (rvf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID)) {}
    for (paramView = "0X800935C";; paramView = "0X8007BA3")
    {
      ndn.a(null, "", paramView, paramView, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId, str2, false);
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
      paramView.putExtra("url", str1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovo
 * JD-Core Version:    0.7.0.1
 */