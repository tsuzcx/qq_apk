import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class pfc
  implements ViewBase.OnClickListener
{
  pfc(pfb parampfb, Container paramContainer, pau parampau, int paramInt) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    pfb.a(this.jdField_a_of_type_Pfb, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_Pau, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("BiuPgcProteusItem", 2, "click gallery summary for jumping to gallery articleinfo = " + this.jdField_a_of_type_Pau.a() + " position = " + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pfc
 * JD-Core Version:    0.7.0.1
 */