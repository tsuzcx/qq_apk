import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class pgg
  implements ViewBase.OnClickListener
{
  pgg(pgd parampgd, ArticleInfo paramArticleInfo, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mNewPolymericInfo.a != null)
    {
      paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mNewPolymericInfo.a;
      qoi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
      pgd.a(this.jdField_a_of_type_Pgd, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramViewBase.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgg
 * JD-Core Version:    0.7.0.1
 */