import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class oqj
  implements ViewBase.OnClickListener
{
  oqj(oqd paramoqd, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    TemplateBean localTemplateBean = opy.a(null, this.jdField_a_of_type_Oqd.jdField_a_of_type_Int, this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    if (localTemplateBean != null)
    {
      ViewBean localViewBean = localTemplateBean.findViewById(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getName());
      opy.a(localTemplateBean, paramViewBase);
      opy.a(localViewBean);
    }
    ors.a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oqj
 * JD-Core Version:    0.7.0.1
 */