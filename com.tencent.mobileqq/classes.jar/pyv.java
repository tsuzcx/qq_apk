import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class pyv
  implements ViewBase.OnClickListener
{
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private sel jdField_a_of_type_Sel;
  
  public pyv(ArticleInfo paramArticleInfo, sel paramsel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_Sel = paramsel;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_Sel.a();
    if (paramViewBase != null) {
      paramViewBase.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 2);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.invalidateProteusTemplateBean();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyv
 * JD-Core Version:    0.7.0.1
 */