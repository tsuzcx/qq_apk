import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ovs
  implements ViewBase.OnClickListener
{
  ovs(ovq paramovq, Container paramContainer, opw paramopw, int paramInt) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ovq.a(this.jdField_a_of_type_Ovq, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_Opw, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("PgcProteusItem", 2, "click gallery comment for jumping to gallery articleinfo = " + this.jdField_a_of_type_Opw.a() + " position = " + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovs
 * JD-Core Version:    0.7.0.1
 */