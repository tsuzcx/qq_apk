import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

public class pii
  extends pja
{
  private VafContext a;
  
  public pii(ArticleInfo paramArticleInfo, VafContext paramVafContext)
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
    if (shu.a(paramArticleInfo.mChannelID)) {}
    String str2;
    for (String str1 = "0X8009360";; str1 = "0X8007B67")
    {
      str2 = onh.a(paramArticleInfo);
      if ((!ram.i(paramArticleInfo)) && (!ram.a(paramArticleInfo)) && (!ram.j(paramArticleInfo)) && (!ram.k(paramArticleInfo))) {
        break;
      }
      if (!ram.o(paramArticleInfo)) {
        nol.a(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Qda.jdField_a_of_type_Long), str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
      if ((!onh.k(paramArticleInfo)) && (!onh.l(paramArticleInfo))) {
        ram.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      }
      return;
    }
    nol.a(null, paramArticleInfo.mSubscribeID, str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
  }
  
  protected void a(ViewBase paramViewBase)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.d > 0) && (!shq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.comment_jump_url))
      {
        onh.e(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.comment_jump_url);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isCardJumpUrlAvailable == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getCardJumpUrl())))
      {
        onh.e(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getCardJumpUrl());
        return;
      }
      onh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, true);
      return;
    }
    ohf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getCurActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, 9, ajya.a(2131707847), null, false, null, false, null, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pii
 * JD-Core Version:    0.7.0.1
 */