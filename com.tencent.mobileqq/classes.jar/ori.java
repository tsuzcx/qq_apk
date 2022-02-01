import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ori
  implements ViewBase.OnClickListener
{
  ori(ouo paramouo, ouc paramouc) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    if (this.jdField_a_of_type_Ouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      paramViewBase = new osa(this.jdField_a_of_type_Ouo).a().a();
      odq.a(null, oto.a(this.jdField_a_of_type_Ouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009010", "0X8009010", 0, 0, String.valueOf(this.jdField_a_of_type_Ouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_Ouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_Ouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramViewBase, false);
    }
    if ((this.jdField_a_of_type_Ouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData))
    {
      paramViewBase = this.jdField_a_of_type_Ouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if (paramViewBase == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData");
      }
      if (((CommentData)paramViewBase).subCommentNum > 0)
      {
        if ((this.jdField_a_of_type_Ouc instanceof osu))
        {
          paramViewBase = this.jdField_a_of_type_Ouc;
          if (paramViewBase == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter");
          }
          ((osu)paramViewBase).a(this.jdField_a_of_type_Ouo, orx.a(this.jdField_a_of_type_Ouo, -1), 1);
        }
        return;
      }
    }
    this.jdField_a_of_type_Ouc.a(this.jdField_a_of_type_Ouo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ori
 * JD-Core Version:    0.7.0.1
 */