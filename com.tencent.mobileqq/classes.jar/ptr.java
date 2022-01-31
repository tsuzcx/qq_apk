import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class ptr
  extends psx
{
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public ptr(NativeSummaryView paramNativeSummaryView, ArticleInfo paramArticleInfo, int paramInt)
  {
    super(-12084769, 13421772, 860716207);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void onClick(View paramView)
  {
    if ((rqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.getContext() instanceof Activity)))
    {
      ors.b((Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      rqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    if (rqj.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {}
    for (int i = 2;; i = 3)
    {
      ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ptr
 * JD-Core Version:    0.7.0.1
 */