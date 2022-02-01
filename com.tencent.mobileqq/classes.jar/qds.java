import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeBiuCommentView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class qds
  extends qdl
{
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public qds(NativeBiuCommentView paramNativeBiuCommentView, ArticleInfo paramArticleInfo, int paramInt)
  {
    super(paramInt, 13421772, 860716207);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void onClick(View paramView)
  {
    if (sel.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeBiuCommentView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 0, false, 5, false);
      sel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    if (sel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeBiuCommentView.getContext();
      if ((paramView instanceof Activity)) {
        ozs.c(paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 6);
      }
      sel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeBiuCommentView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qds
 * JD-Core Version:    0.7.0.1
 */