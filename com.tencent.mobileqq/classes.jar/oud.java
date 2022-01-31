import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class oud
  implements ViewBase.OnClickListener
{
  oud(ouc paramouc, Container paramContainer, opw paramopw, int paramInt) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ouc.a(this.jdField_a_of_type_Ouc, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_Opw, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("BiuPgcProteusItem", 2, "click gallery summary for jumping to gallery articleinfo = " + this.jdField_a_of_type_Opw.a() + " position = " + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oud
 * JD-Core Version:    0.7.0.1
 */