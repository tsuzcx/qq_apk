import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class olw
  implements ViewBase.OnClickListener
{
  olw(olt paramolt) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
    {
      onh.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramViewBase.getEventAttachedData());
      QLog.d("ProteusSupportUtil", 2, "familyJumpUrl " + paramViewBase.getEventAttachedData());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     olw
 * JD-Core Version:    0.7.0.1
 */