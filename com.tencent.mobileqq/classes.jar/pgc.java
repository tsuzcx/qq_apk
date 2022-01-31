import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class pgc
  implements ViewBase.OnClickListener
{
  pgc(pfy parampfy, ArticleInfo paramArticleInfo, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.multiVideoColumnInfo.b;
    if (paramViewBase != null)
    {
      qoi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
      pfy.a(this.jdField_a_of_type_Pfy, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 3, paramViewBase.e, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgc
 * JD-Core Version:    0.7.0.1
 */