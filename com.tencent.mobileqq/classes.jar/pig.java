import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class pig
  implements ViewBase.OnClickListener
{
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private ram jdField_a_of_type_Ram;
  
  public pig(ArticleInfo paramArticleInfo, ram paramram)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_Ram = paramram;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_Ram.a();
    if (paramViewBase != null) {
      paramViewBase.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 2);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.invalidateProteusTemplateBean();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pig
 * JD-Core Version:    0.7.0.1
 */