import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class pwv
  implements ViewBase.OnClickListener
{
  pwv(pws parampws, ArticleInfo paramArticleInfo, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mNewPolymericInfo.a != null)
    {
      paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mNewPolymericInfo.a;
      rpt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
      pws.a(this.jdField_a_of_type_Pws, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramViewBase.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwv
 * JD-Core Version:    0.7.0.1
 */