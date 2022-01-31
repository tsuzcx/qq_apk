import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class ofj
  implements ViewBase.OnClickListener
{
  ofj(ofb paramofb) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.jdField_a_of_type_Oif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      paramViewBase = new ofs(this.a.jdField_a_of_type_Oif).a().a();
      nol.a(null, ohf.a(this.a.jdField_a_of_type_Oif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009010", "0X8009010", 0, 0, String.valueOf(this.a.jdField_a_of_type_Oif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.a.jdField_a_of_type_Oif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.a.jdField_a_of_type_Oif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramViewBase, false);
    }
    if (((this.a.jdField_a_of_type_Oif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) && (((CommentData)this.a.jdField_a_of_type_Oif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentNum > 0))
    {
      if ((this.a.jdField_a_of_type_Ohs instanceof ogn)) {
        ((ogn)this.a.jdField_a_of_type_Ohs).a(this.a.jdField_a_of_type_Oif, ofa.a(this.a.jdField_a_of_type_Oif, 0));
      }
      return;
    }
    this.a.jdField_a_of_type_Ohs.a(this.a.jdField_a_of_type_Oif);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ofj
 * JD-Core Version:    0.7.0.1
 */