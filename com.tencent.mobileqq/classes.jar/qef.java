import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class qef
  extends qdl
{
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public qef(NativeSummaryView paramNativeSummaryView, ArticleInfo paramArticleInfo, int paramInt)
  {
    super(-15504151, 13421772, 860716207);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void onClick(View paramView)
  {
    if ((sel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.getContext() instanceof Activity)))
    {
      ozs.b((Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      sel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    if (sel.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {}
    for (int i = 2;; i = 3)
    {
      ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qef
 * JD-Core Version:    0.7.0.1
 */