import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class oau
  implements ViewBase.OnClickListener
{
  oau(oal paramoal) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = ogy.a().a();
    if ((paramViewBase != null) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
    {
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isShowFreeNetFlow = false;
      obz.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), paramViewBase.a());
      obj.a(false, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), null);
      opt.a("0X8009661");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oau
 * JD-Core Version:    0.7.0.1
 */