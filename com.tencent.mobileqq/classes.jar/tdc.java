import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.qphone.base.util.QLog;

public class tdc
  implements DialogInterface.OnClickListener
{
  public tdc(ReadinjoyTabFrame paramReadinjoyTabFrame, SelectPositionModule.PositionData paramPositionData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyTabFrame", 2, "showLocationChangedDialog change confirm");
    }
    paramDialogInterface = pvj.a().a();
    if (paramDialogInterface != null) {
      paramDialogInterface.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData);
    }
    paramDialogInterface = pvj.a().a();
    if (paramDialogInterface != null) {
      paramDialogInterface.a().b(41695);
    }
    pvj.a().a(41695, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.city);
    pvm.a().h(41695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tdc
 * JD-Core Version:    0.7.0.1
 */