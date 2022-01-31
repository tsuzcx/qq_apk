import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class oaq
  implements ViewBase.OnClickListener
{
  oaq(oal paramoal, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    TemplateBean localTemplateBean = oag.a(null, this.jdField_a_of_type_Oal.jdField_a_of_type_Int, this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    if (localTemplateBean != null)
    {
      ViewBean localViewBean = localTemplateBean.findViewById(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getName());
      oag.a(localTemplateBean, paramViewBase);
      oag.a(localViewBean);
    }
    obz.a(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oaq
 * JD-Core Version:    0.7.0.1
 */