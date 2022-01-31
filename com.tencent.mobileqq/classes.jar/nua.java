import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class nua
  implements ViewBase.OnClickListener
{
  nua(ntu paramntu) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.jdField_a_of_type_Nwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      paramViewBase = new nuj(this.a.jdField_a_of_type_Nwx).a().a();
      ndn.a(null, nvx.a(this.a.jdField_a_of_type_Nwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009010", "0X8009010", 0, 0, String.valueOf(this.a.jdField_a_of_type_Nwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.a.jdField_a_of_type_Nwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.a.jdField_a_of_type_Nwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramViewBase, false);
    }
    if (((this.a.jdField_a_of_type_Nwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) && (((CommentData)this.a.jdField_a_of_type_Nwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentNum > 0))
    {
      if ((this.a.jdField_a_of_type_Nwk instanceof nvf)) {
        ((nvf)this.a.jdField_a_of_type_Nwk).a(this.a.jdField_a_of_type_Nwx, ntt.a(this.a.jdField_a_of_type_Nwx, 0));
      }
      return;
    }
    this.a.jdField_a_of_type_Nwk.a(this.a.jdField_a_of_type_Nwx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nua
 * JD-Core Version:    0.7.0.1
 */