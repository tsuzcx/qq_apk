import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeBiuCommentView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class pte
  extends psx
{
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public pte(NativeBiuCommentView paramNativeBiuCommentView, ArticleInfo paramArticleInfo, int paramInt)
  {
    super(-12084769, 13421772, 860716207);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void onClick(View paramView)
  {
    if (rqj.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeBiuCommentView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 0, false, 5, false);
      rqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    if (rqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeBiuCommentView.getContext();
      if ((paramView instanceof Activity)) {
        ors.c((Activity)paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 6);
      }
      rqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeBiuCommentView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pte
 * JD-Core Version:    0.7.0.1
 */