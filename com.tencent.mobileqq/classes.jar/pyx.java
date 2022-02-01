import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;

public class pyx
  extends pzu
{
  private VafContext a;
  
  public pyx(ArticleInfo paramArticleInfo, VafContext paramVafContext)
  {
    super(paramArticleInfo, paramVafContext.getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
  }
  
  private void b(ArticleInfo paramArticleInfo)
  {
    if ((sel.a(paramArticleInfo)) || (sel.b(paramArticleInfo)))
    {
      if (!TextUtils.isEmpty(paramArticleInfo.commentJumpUrl)) {
        ozs.d(this.jdField_a_of_type_AndroidContentContext, paramArticleInfo.commentJumpUrl);
      }
      while ((paramArticleInfo.isCardJumpUrlAvailable != 1) || (TextUtils.isEmpty(paramArticleInfo.getCardJumpUrl()))) {
        return;
      }
      ozs.d(this.jdField_a_of_type_AndroidContentContext, paramArticleInfo.getCardJumpUrl());
      return;
    }
    ozs.a(this.jdField_a_of_type_AndroidContentContext, paramArticleInfo, true);
  }
  
  protected int a()
  {
    return 3;
  }
  
  protected void a(ArticleInfo paramArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    if (ubg.a(paramArticleInfo.mChannelID)) {}
    String str2;
    for (String str1 = "0X8009360";; str1 = "0X8007B67")
    {
      str2 = ozs.a(paramArticleInfo);
      if ((!sel.i(paramArticleInfo)) && (!sel.g(paramArticleInfo)) && (!sel.j(paramArticleInfo)) && (!sel.k(paramArticleInfo))) {
        break;
      }
      if (!sel.o(paramArticleInfo)) {
        ocd.a(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Long), str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
      if ((!ozs.k(paramArticleInfo)) && (!ozs.l(paramArticleInfo))) {
        sel.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      }
      return;
    }
    ocd.a(null, paramArticleInfo.mSubscribeID, str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
  }
  
  protected void a(ViewBase paramViewBase)
  {
    QLog.d("OnCommentClickListener", 1, "click comment");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 36)
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        ozs.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 8);
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.d > 0) && (!ubd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      QLog.d("OnCommentClickListener", 1, "jumpUrl");
      b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
    }
    QLog.d("OnCommentClickListener", 1, "openCommentComponent");
    osp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getCurActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, 9, anzj.a(2131706715), null, false, null, false, null, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyx
 * JD-Core Version:    0.7.0.1
 */