import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class qpc
  implements ViewBase.OnClickListener
{
  qpc(qpa paramqpa, Container paramContainer, qfw paramqfw, int paramInt) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    qpa.a(this.jdField_a_of_type_Qpa, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_Qfw, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("PgcProteusItem", 2, "click gallery comment for jumping to gallery articleinfo = " + this.jdField_a_of_type_Qfw.a() + " position = " + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpc
 * JD-Core Version:    0.7.0.1
 */