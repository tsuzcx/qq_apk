import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

public class owt
  extends oxl
{
  private VafContext a;
  
  public owt(ArticleInfo paramArticleInfo, VafContext paramVafContext)
  {
    super(paramArticleInfo, paramVafContext.getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
  }
  
  protected int a()
  {
    return 3;
  }
  
  protected void a(ArticleInfo paramArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    if (rvf.a(paramArticleInfo.mChannelID)) {}
    String str2;
    for (String str1 = "0X8009360";; str1 = "0X8007B67")
    {
      str2 = obz.a(paramArticleInfo);
      if ((!qoe.i(paramArticleInfo)) && (!qoe.a(paramArticleInfo)) && (!qoe.j(paramArticleInfo)) && (!qoe.k(paramArticleInfo))) {
        break;
      }
      if (!qoe.o(paramArticleInfo)) {
        ndn.a(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Pre.jdField_a_of_type_Long), str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
      if ((!obz.k(paramArticleInfo)) && (!obz.l(paramArticleInfo))) {
        qoe.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      }
      return;
    }
    ndn.a(null, paramArticleInfo.mSubscribeID, str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
  }
  
  protected void a(ViewBase paramViewBase)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.d > 0) && (!rvb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.comment_jump_url))
      {
        obz.e(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.comment_jump_url);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isCardJumpUrlAvailable == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getCardJumpUrl())))
      {
        obz.e(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getCardJumpUrl());
        return;
      }
      obz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, true);
      return;
    }
    nvx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getCurActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, 9, ajjy.a(2131642051), null, false, null, false, null, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owt
 * JD-Core Version:    0.7.0.1
 */