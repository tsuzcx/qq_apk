import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeBiuCommentView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class qvv
  extends qvo
{
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public qvv(NativeBiuCommentView paramNativeBiuCommentView, ArticleInfo paramArticleInfo, int paramInt)
  {
    super(paramInt, 13421772, 860716207);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void onClick(View paramView)
  {
    if (ppe.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      pqx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeBiuCommentView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 0, false, 5, false);
      pqb.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    if (ppe.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeBiuCommentView.getContext();
      if ((paramView instanceof Activity)) {
        pqx.b(paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 6);
      }
      pqb.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    pqx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeBiuCommentView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qvv
 * JD-Core Version:    0.7.0.1
 */