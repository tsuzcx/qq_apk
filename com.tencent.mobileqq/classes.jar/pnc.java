import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class pnc
  implements ViewBase.OnClickListener
{
  pnc(pna parampna, Container paramContainer, pgd parampgd, int paramInt) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    pna.a(this.jdField_a_of_type_Pna, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_Pgd, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("PgcProteusItem", 2, "click gallery comment for jumping to gallery articleinfo = " + this.jdField_a_of_type_Pgd.a() + " position = " + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pnc
 * JD-Core Version:    0.7.0.1
 */