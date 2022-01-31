import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class oao
  implements ViewBase.OnClickListener
{
  oao(oal paramoal) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
    {
      obz.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramViewBase.getEventAttachedData());
      QLog.d("ProteusSupportUtil", 2, "familyJumpUrl " + paramViewBase.getEventAttachedData());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oao
 * JD-Core Version:    0.7.0.1
 */