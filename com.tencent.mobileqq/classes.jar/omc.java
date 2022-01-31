import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class omc
  implements ViewBase.OnClickListener
{
  omc(olt paramolt) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = osg.a().a();
    if ((paramViewBase != null) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
    {
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isShowFreeNetFlow = false;
      onh.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), paramViewBase.a());
      omr.a(false, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), null);
      par.a("0X8009661");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     omc
 * JD-Core Version:    0.7.0.1
 */