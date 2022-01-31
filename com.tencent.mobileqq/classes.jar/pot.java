import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;

public class pot
  extends ppl
{
  private VafContext a;
  
  public pot(ArticleInfo paramArticleInfo, VafContext paramVafContext)
  {
    super(paramArticleInfo, paramVafContext.getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
  }
  
  private void b(ArticleInfo paramArticleInfo)
  {
    if (!TextUtils.isEmpty(paramArticleInfo.comment_jump_url))
    {
      ors.d(this.jdField_a_of_type_AndroidContentContext, paramArticleInfo.comment_jump_url);
      return;
    }
    if ((paramArticleInfo.isCardJumpUrlAvailable == 1) && (!TextUtils.isEmpty(paramArticleInfo.getCardJumpUrl())))
    {
      ors.d(this.jdField_a_of_type_AndroidContentContext, paramArticleInfo.getCardJumpUrl());
      return;
    }
    ors.a(this.jdField_a_of_type_AndroidContentContext, paramArticleInfo, true);
  }
  
  protected int a()
  {
    return 3;
  }
  
  protected void a(ArticleInfo paramArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    if (szp.a(paramArticleInfo.mChannelID)) {}
    String str2;
    for (String str1 = "0X8009360";; str1 = "0X8007B67")
    {
      str2 = ors.a(paramArticleInfo);
      if ((!rqj.i(paramArticleInfo)) && (!rqj.b(paramArticleInfo)) && (!rqj.j(paramArticleInfo)) && (!rqj.k(paramArticleInfo))) {
        break;
      }
      if (!rqj.o(paramArticleInfo)) {
        nrt.a(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Long), str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
      if ((!ors.k(paramArticleInfo)) && (!ors.l(paramArticleInfo))) {
        rqj.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      }
      return;
    }
    nrt.a(null, paramArticleInfo.mSubscribeID, str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
  }
  
  protected void a(ViewBase paramViewBase)
  {
    QLog.d("OnCommentClickListener", 1, "click comment");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 36)
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        ors.c((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 8);
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.d > 0) && (!szl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      QLog.d("OnCommentClickListener", 1, "jumpUrl");
      b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
    }
    QLog.d("OnCommentClickListener", 1, "openCommentComponent");
    olt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getCurActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, 9, alud.a(2131708231), null, false, null, false, null, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pot
 * JD-Core Version:    0.7.0.1
 */