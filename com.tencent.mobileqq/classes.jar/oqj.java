import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class oqj
  implements ViewBase.OnClickListener
{
  oqj(otp paramotp, otd paramotd) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    if (this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      paramViewBase = new orb(this.jdField_a_of_type_Otp).a().a();
      ocd.a(null, osp.a(this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009010", "0X8009010", 0, 0, String.valueOf(this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramViewBase, false);
    }
    if ((this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData))
    {
      paramViewBase = this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if (paramViewBase == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData");
      }
      if (((CommentData)paramViewBase).subCommentNum > 0)
      {
        if ((this.jdField_a_of_type_Otd instanceof orv))
        {
          paramViewBase = this.jdField_a_of_type_Otd;
          if (paramViewBase == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter");
          }
          ((orv)paramViewBase).a(this.jdField_a_of_type_Otp, oqy.a(this.jdField_a_of_type_Otp, 0), 1);
        }
        return;
      }
    }
    this.jdField_a_of_type_Otd.a(this.jdField_a_of_type_Otp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqj
 * JD-Core Version:    0.7.0.1
 */