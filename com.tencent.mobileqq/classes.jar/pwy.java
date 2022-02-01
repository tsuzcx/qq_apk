import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class pwy
  implements ViewBase.OnClickListener
{
  pwy(pww parampww, ppu paramppu, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_Ppu.a();
    if (paramViewBase != null)
    {
      ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase.mArticleContentUrl, null);
      sel.a(paramViewBase, 0);
      pww.b(this.jdField_a_of_type_Pww, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwy
 * JD-Core Version:    0.7.0.1
 */