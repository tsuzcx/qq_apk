import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class omb
  implements ViewBase.OnClickListener
{
  omb(olw paramolw, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    TemplateBean localTemplateBean = olr.a(null, this.jdField_a_of_type_Olw.jdField_a_of_type_Int, this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    if (localTemplateBean != null)
    {
      ViewBean localViewBean = localTemplateBean.findViewById(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getName());
      olr.a(localTemplateBean, paramViewBase);
      olr.a(localViewBean);
    }
    onk.a(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     omb
 * JD-Core Version:    0.7.0.1
 */