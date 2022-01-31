import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ppp
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public ppp(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnTopicRecommendHeaderClickListener", 2, "business url is " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.size() > 0)) {}
    for (Object localObject = (qno)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.get(0);; localObject = null)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (localObject == null))
      {
        QLog.d("OnTopicRecommendHeaderClickListener", 1, new Object[] { "articleInfo is null or topicRecommendInfo is null, articleInfo: ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, " topicRecommendInfo: ", localObject });
        return;
      }
      String str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl;
      if (TextUtils.isEmpty(str)) {
        break;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
      localIntent.putExtra("url", str);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      str = ors.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      localObject = ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, ((qno)localObject).a + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      nrt.a(null, str, "0X8008A63", "0X8008A63", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), (String)localObject, false);
      rqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    int i = rqj.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (i != 79)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ppp
 * JD-Core Version:    0.7.0.1
 */