import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class pva
  implements ViewBase.OnClickListener
{
  pva(puz parampuz, Container paramContainer, ppu paramppu, int paramInt) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    puz.a(this.jdField_a_of_type_Puz, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_Ppu, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("BiuPgcProteusItem", 2, "click gallery summary for jumping to gallery articleinfo = " + this.jdField_a_of_type_Ppu.a() + " position = " + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pva
 * JD-Core Version:    0.7.0.1
 */