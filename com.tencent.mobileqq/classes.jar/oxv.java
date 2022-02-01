import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class oxv
  implements ViewBase.OnClickListener
{
  oxv(pay parampay, pan parampan) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    if (this.jdField_a_of_type_Pay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      paramViewBase = new oyn(this.jdField_a_of_type_Pay).a().a();
      oat.a(null, paa.a(this.jdField_a_of_type_Pay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009010", "0X8009010", 0, 0, String.valueOf(this.jdField_a_of_type_Pay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_Pay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_Pay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramViewBase, false);
    }
    if ((this.jdField_a_of_type_Pay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData))
    {
      paramViewBase = this.jdField_a_of_type_Pay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if (paramViewBase == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData");
      }
      if (((CommentData)paramViewBase).subCommentNum > 0)
      {
        if ((this.jdField_a_of_type_Pan instanceof ozh))
        {
          paramViewBase = this.jdField_a_of_type_Pan;
          if (paramViewBase == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter");
          }
          ((ozh)paramViewBase).a(this.jdField_a_of_type_Pay, oyk.a(this.jdField_a_of_type_Pay, 0), 1);
        }
        return;
      }
    }
    this.jdField_a_of_type_Pan.a(this.jdField_a_of_type_Pay);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oxv
 * JD-Core Version:    0.7.0.1
 */