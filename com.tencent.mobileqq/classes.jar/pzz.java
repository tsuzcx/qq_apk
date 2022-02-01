import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class pzz
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private blir jdField_a_of_type_Blir;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private qzd jdField_a_of_type_Qzd;
  
  public pzz(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramArticleInfo);
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.size() > 0)) {
      this.jdField_a_of_type_Qzd = ((qzd)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.get(0));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = ozs.a();
    if (this.jdField_a_of_type_Qzd != null)
    {
      localObject = ((AppRuntime)localObject).getAccount();
      if (QLog.isColorLevel()) {
        QLog.d("OnTopicRecommendHeaderFollowClickListener", 2, "before request0x978 articleInfo articleID = ，isfollow = " + paramBoolean + " businessId = " + this.jdField_a_of_type_Qzd.a);
      }
      if (paramBoolean) {
        pfa.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_Qzd.a), true, "", new qac(this, paramBoolean), 3);
      }
    }
    else
    {
      return;
    }
    pfa.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_Qzd.a), false, "", new qad(this, paramBoolean), 3);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Qzd == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Qzd.c != 1) {
        break;
      }
    } while (ozs.v(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    a();
    return;
    a(true);
    if (!ozs.v(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      str1 = ozs.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      String str2 = ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID, ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID, bhnv.h(this.jdField_a_of_type_AndroidContentContext), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId + "");
      ocd.a(null, str1, "0X8008A61", "0X8008A61", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID), str2, false);
      sel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    if (ubg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID)) {}
    for (String str1 = "0X800941D";; str1 = "0X80080EC")
    {
      sel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, str1, str1, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      pfa.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      break;
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Blir = ((blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null));
    this.jdField_a_of_type_Blir.a(2131694702, 3);
    this.jdField_a_of_type_Blir.c(2131690580);
    this.jdField_a_of_type_Blir.setOnDismissListener(new qaa(this));
    this.jdField_a_of_type_Blir.a(new qab(this));
    if (!this.jdField_a_of_type_Blir.isShowing()) {
      this.jdField_a_of_type_Blir.show();
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pzz
 * JD-Core Version:    0.7.0.1
 */