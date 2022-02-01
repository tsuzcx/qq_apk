import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import org.json.JSONException;
import org.json.JSONObject;

public class qaf
  implements ViewBase.OnClickListener
{
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  
  public qaf(ArticleInfo paramArticleInfo, VafContext paramVafContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if (ozs.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      osp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getCurActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, 17, "", "", false, null, -1);
      oxw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getCurActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009A72", null);
      return;
    }
    osp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getCurActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId, anzj.a(2131706725), null, false, null, false, null, 1);
    if (ubg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID)) {}
    for (paramViewBase = "0X80094A0";; paramViewBase = "0X800949E") {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", "x");
        ocd.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, paramViewBase, paramViewBase, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId, localJSONObject.toString(), false);
        return;
      }
      catch (JSONException paramViewBase)
      {
        paramViewBase.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qaf
 * JD-Core Version:    0.7.0.1
 */