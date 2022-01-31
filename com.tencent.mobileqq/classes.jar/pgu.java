import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class pgu
  implements ViewBase.OnClickListener
{
  pgu(pgs parampgs, Container paramContainer, pax parampax, int paramInt) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    pgs.a(this.jdField_a_of_type_Pgs, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_Pax, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("PgcProteusItem", 2, "click gallery comment for jumping to gallery articleinfo = " + this.jdField_a_of_type_Pax.a() + " position = " + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgu
 * JD-Core Version:    0.7.0.1
 */