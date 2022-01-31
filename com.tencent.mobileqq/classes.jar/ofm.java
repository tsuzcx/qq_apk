import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class ofm
  implements ViewBase.OnClickListener
{
  ofm(ofe paramofe) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.jdField_a_of_type_Oii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      paramViewBase = new ofv(this.a.jdField_a_of_type_Oii).a().a();
      noo.a(null, ohi.a(this.a.jdField_a_of_type_Oii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009010", "0X8009010", 0, 0, String.valueOf(this.a.jdField_a_of_type_Oii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.a.jdField_a_of_type_Oii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.a.jdField_a_of_type_Oii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramViewBase, false);
    }
    if (((this.a.jdField_a_of_type_Oii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) && (((CommentData)this.a.jdField_a_of_type_Oii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentNum > 0))
    {
      if ((this.a.jdField_a_of_type_Ohv instanceof ogq)) {
        ((ogq)this.a.jdField_a_of_type_Ohv).a(this.a.jdField_a_of_type_Oii, ofd.a(this.a.jdField_a_of_type_Oii, 0));
      }
      return;
    }
    this.a.jdField_a_of_type_Ohv.a(this.a.jdField_a_of_type_Oii);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ofm
 * JD-Core Version:    0.7.0.1
 */