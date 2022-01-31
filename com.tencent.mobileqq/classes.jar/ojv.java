import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class ojv
  implements ViewBase.OnClickListener
{
  ojv(ojn paramojn) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.jdField_a_of_type_Omt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      paramViewBase = new oke(this.a.jdField_a_of_type_Omt).a().a();
      nrt.a(null, olt.a(this.a.jdField_a_of_type_Omt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009010", "0X8009010", 0, 0, String.valueOf(this.a.jdField_a_of_type_Omt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.a.jdField_a_of_type_Omt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.a.jdField_a_of_type_Omt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramViewBase, false);
    }
    if (((this.a.jdField_a_of_type_Omt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) && (((CommentData)this.a.jdField_a_of_type_Omt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentNum > 0))
    {
      if ((this.a.jdField_a_of_type_Omg instanceof ola)) {
        ((ola)this.a.jdField_a_of_type_Omg).a(this.a.jdField_a_of_type_Omt, ojm.a(this.a.jdField_a_of_type_Omt, 0));
      }
      return;
    }
    this.a.jdField_a_of_type_Omg.a(this.a.jdField_a_of_type_Omt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ojv
 * JD-Core Version:    0.7.0.1
 */