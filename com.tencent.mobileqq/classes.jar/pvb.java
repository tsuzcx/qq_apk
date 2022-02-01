import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pvb
  implements View.OnClickListener
{
  pvb(puz parampuz, Container paramContainer, ppu paramppu, int paramInt) {}
  
  public void onClick(View paramView)
  {
    puz.a(this.jdField_a_of_type_Puz, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_Ppu, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("BiuPgcProteusItem", 2, "click bottom bar for jumping to gallery articleinfo = " + this.jdField_a_of_type_Ppu.a() + " position = " + this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvb
 * JD-Core Version:    0.7.0.1
 */