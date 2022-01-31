import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class oqg
  implements ViewBase.OnClickListener
{
  oqg(oqd paramoqd) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
    {
      ors.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramViewBase.getEventAttachedData());
      QLog.d("ProteusSupportUtil", 2, "familyJumpUrl " + paramViewBase.getEventAttachedData());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oqg
 * JD-Core Version:    0.7.0.1
 */