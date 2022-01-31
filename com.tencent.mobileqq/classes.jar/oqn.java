import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class oqn
  implements ViewBase.OnClickListener
{
  oqn(oqd paramoqd) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = owy.a().a();
    if ((paramViewBase != null) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
    {
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isShowFreeNetFlow = false;
      ors.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), paramViewBase.a());
      orc.a(false, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), null);
      pga.a("0X8009661");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oqn
 * JD-Core Version:    0.7.0.1
 */