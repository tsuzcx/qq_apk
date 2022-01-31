import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class pgj
  implements ViewBase.OnClickListener
{
  pgj(pgh parampgh, pau parampau, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_Pau.a();
    if (paramViewBase != null)
    {
      onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase.mArticleContentUrl, null);
      ram.a(paramViewBase, 0);
      pgh.b(this.jdField_a_of_type_Pgh, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgj
 * JD-Core Version:    0.7.0.1
 */