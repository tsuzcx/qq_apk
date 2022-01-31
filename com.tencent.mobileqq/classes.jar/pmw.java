import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeBiuCommentView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class pmw
  extends pmp
{
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public pmw(NativeBiuCommentView paramNativeBiuCommentView, ArticleInfo paramArticleInfo, int paramInt)
  {
    super(-12084769, 13421772, 860716207);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void onClick(View paramView)
  {
    if (ram.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeBiuCommentView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 0, false, 5, false);
      ram.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeBiuCommentView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pmw
 * JD-Core Version:    0.7.0.1
 */